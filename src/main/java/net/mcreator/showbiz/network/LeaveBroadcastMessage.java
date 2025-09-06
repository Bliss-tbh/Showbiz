package net.mcreator.showbiz.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.showbiz.procedures.LeaveBroadcastOnKeyPressedProcedure;
import net.mcreator.showbiz.ShowbizMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record LeaveBroadcastMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<LeaveBroadcastMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ShowbizMod.MODID, "key_leave_broadcast"));
	public static final StreamCodec<RegistryFriendlyByteBuf, LeaveBroadcastMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, LeaveBroadcastMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new LeaveBroadcastMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<LeaveBroadcastMessage> type() {
		return TYPE;
	}

	public static void handleData(final LeaveBroadcastMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			LeaveBroadcastOnKeyPressedProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ShowbizMod.addNetworkMessage(LeaveBroadcastMessage.TYPE, LeaveBroadcastMessage.STREAM_CODEC, LeaveBroadcastMessage::handleData);
	}
}