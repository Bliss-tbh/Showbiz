/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.showbiz.block.TipJarBlock;
import net.mcreator.showbiz.block.StarwallBlock;
import net.mcreator.showbiz.block.StageLightBlock;
import net.mcreator.showbiz.block.RelayBlock;
import net.mcreator.showbiz.block.PoweredmailboxBlock;
import net.mcreator.showbiz.block.GearboxPoweredBlock;
import net.mcreator.showbiz.block.GearboxBlock;
import net.mcreator.showbiz.block.DonationPresentBlock;
import net.mcreator.showbiz.block.DonationMailboxBlock;
import net.mcreator.showbiz.block.ConfettiCannonBlock;
import net.mcreator.showbiz.block.ClapboardBlock;
import net.mcreator.showbiz.block.ChainlinkFenceBlock;
import net.mcreator.showbiz.block.CatwalkBlock;
import net.mcreator.showbiz.block.CassettePlayerBlock;
import net.mcreator.showbiz.block.CameraONBlock;
import net.mcreator.showbiz.block.CameraBlock;
import net.mcreator.showbiz.block.BuzzerButtonBlock;
import net.mcreator.showbiz.ShowbizMod;

import java.util.function.Function;

public class ShowbizModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ShowbizMod.MODID);
	public static final DeferredBlock<Block> CAMERA = register("camera", CameraBlock::new);
	public static final DeferredBlock<Block> CAMERA_ON = register("camera_on", CameraONBlock::new);
	public static final DeferredBlock<Block> TIP_JAR = register("tip_jar", TipJarBlock::new);
	public static final DeferredBlock<Block> STAGE_LIGHT = register("stage_light", StageLightBlock::new);
	public static final DeferredBlock<Block> CATWALK = register("catwalk", CatwalkBlock::new);
	public static final DeferredBlock<Block> CLAPBOARD = register("clapboard", ClapboardBlock::new);
	public static final DeferredBlock<Block> CASSETTE_PLAYER = register("cassette_player", CassettePlayerBlock::new);
	public static final DeferredBlock<Block> RELAY = register("relay", RelayBlock::new);
	public static final DeferredBlock<Block> DONATION_PRESENT = register("donation_present", DonationPresentBlock::new);
	public static final DeferredBlock<Block> DONATION_MAILBOX = register("donation_mailbox", DonationMailboxBlock::new);
	public static final DeferredBlock<Block> POWEREDMAILBOX = register("poweredmailbox", PoweredmailboxBlock::new);
	public static final DeferredBlock<Block> BUZZER_BUTTON = register("buzzer_button", BuzzerButtonBlock::new);
	public static final DeferredBlock<Block> STARWALL = register("starwall", StarwallBlock::new);
	public static final DeferredBlock<Block> GEARBOX = register("gearbox", GearboxBlock::new);
	public static final DeferredBlock<Block> GEARBOX_POWERED = register("gearbox_powered", GearboxPoweredBlock::new);
	public static final DeferredBlock<Block> CHAINLINK_FENCE = register("chainlink_fence", ChainlinkFenceBlock::new);
	public static final DeferredBlock<Block> CONFETTI_CANNON = register("confetti_cannon", ConfettiCannonBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}