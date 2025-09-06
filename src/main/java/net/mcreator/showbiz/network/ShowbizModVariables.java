package net.mcreator.showbiz.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.showbiz.ShowbizMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ShowbizModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ShowbizMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ShowbizMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.lastX = original.lastX;
			clone.LastY = original.LastY;
			clone.LastZ = original.LastZ;
			clone.insync = original.insync;
			clone.synccooldown = original.synccooldown;
			clone.TVX = original.TVX;
			clone.TVY = original.TVY;
			clone.TVZ = original.TVZ;
			clone.playerdonateuses = original.playerdonateuses;
			clone.playerdonatecooldown = original.playerdonatecooldown;
			if (!event.isWasDeath()) {
				clone.spectatormode = original.spectatormode;
				clone.goobert = original.goobert;
				clone.corporealmode = original.corporealmode;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double lastX = 0;
		public double LastY = 0;
		public double LastZ = 0;
		public boolean spectatormode = false;
		public boolean goobert = false;
		public double insync = 0;
		public double synccooldown = 0;
		public double TVX = 0;
		public double TVY = 0;
		public double TVZ = 0;
		public boolean corporealmode = false;
		public double playerdonateuses = 0;
		public double playerdonatecooldown = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("lastX", lastX);
			nbt.putDouble("LastY", LastY);
			nbt.putDouble("LastZ", LastZ);
			nbt.putBoolean("spectatormode", spectatormode);
			nbt.putBoolean("goobert", goobert);
			nbt.putDouble("insync", insync);
			nbt.putDouble("synccooldown", synccooldown);
			nbt.putDouble("TVX", TVX);
			nbt.putDouble("TVY", TVY);
			nbt.putDouble("TVZ", TVZ);
			nbt.putBoolean("corporealmode", corporealmode);
			nbt.putDouble("playerdonateuses", playerdonateuses);
			nbt.putDouble("playerdonatecooldown", playerdonatecooldown);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			lastX = nbt.getDouble("lastX");
			LastY = nbt.getDouble("LastY");
			LastZ = nbt.getDouble("LastZ");
			spectatormode = nbt.getBoolean("spectatormode");
			goobert = nbt.getBoolean("goobert");
			insync = nbt.getDouble("insync");
			synccooldown = nbt.getDouble("synccooldown");
			TVX = nbt.getDouble("TVX");
			TVY = nbt.getDouble("TVY");
			TVZ = nbt.getDouble("TVZ");
			corporealmode = nbt.getBoolean("corporealmode");
			playerdonateuses = nbt.getDouble("playerdonateuses");
			playerdonatecooldown = nbt.getDouble("playerdonatecooldown");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ShowbizMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}