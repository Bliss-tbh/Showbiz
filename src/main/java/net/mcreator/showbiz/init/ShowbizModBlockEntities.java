/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.showbiz.block.entity.TipJarBlockEntity;
import net.mcreator.showbiz.block.entity.PoweredmailboxBlockEntity;
import net.mcreator.showbiz.block.entity.GearboxPoweredBlockEntity;
import net.mcreator.showbiz.block.entity.GearboxBlockEntity;
import net.mcreator.showbiz.block.entity.DonationMailboxBlockEntity;
import net.mcreator.showbiz.block.entity.CassettePlayerBlockEntity;
import net.mcreator.showbiz.block.entity.CameraONBlockEntity;
import net.mcreator.showbiz.block.entity.CameraBlockEntity;
import net.mcreator.showbiz.block.entity.BuzzerButtonBlockEntity;
import net.mcreator.showbiz.ShowbizMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ShowbizModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ShowbizMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CameraBlockEntity>> CAMERA = register("camera", ShowbizModBlocks.CAMERA, CameraBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CameraONBlockEntity>> CAMERA_ON = register("camera_on", ShowbizModBlocks.CAMERA_ON, CameraONBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TipJarBlockEntity>> TIP_JAR = register("tip_jar", ShowbizModBlocks.TIP_JAR, TipJarBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CassettePlayerBlockEntity>> CASSETTE_PLAYER = register("cassette_player", ShowbizModBlocks.CASSETTE_PLAYER, CassettePlayerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DonationMailboxBlockEntity>> DONATION_MAILBOX = register("donation_mailbox", ShowbizModBlocks.DONATION_MAILBOX, DonationMailboxBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PoweredmailboxBlockEntity>> POWEREDMAILBOX = register("poweredmailbox", ShowbizModBlocks.POWEREDMAILBOX, PoweredmailboxBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BuzzerButtonBlockEntity>> BUZZER_BUTTON = register("buzzer_button", ShowbizModBlocks.BUZZER_BUTTON, BuzzerButtonBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GearboxBlockEntity>> GEARBOX = register("gearbox", ShowbizModBlocks.GEARBOX, GearboxBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GearboxPoweredBlockEntity>> GEARBOX_POWERED = register("gearbox_powered", ShowbizModBlocks.GEARBOX_POWERED, GearboxPoweredBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CAMERA.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CAMERA_ON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TIP_JAR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CASSETTE_PLAYER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DONATION_MAILBOX.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, POWEREDMAILBOX.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BUZZER_BUTTON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GEARBOX.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GEARBOX_POWERED.get(), SidedInvWrapper::new);
	}
}