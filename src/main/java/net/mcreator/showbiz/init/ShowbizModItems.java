/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.showbiz.item.WrenchItem;
import net.mcreator.showbiz.item.TheboardItem;
import net.mcreator.showbiz.item.SponsorshipItem;
import net.mcreator.showbiz.item.SnowingItem;
import net.mcreator.showbiz.item.RemoteItem;
import net.mcreator.showbiz.item.PresentingItem;
import net.mcreator.showbiz.item.LimelandItem;
import net.mcreator.showbiz.item.LaughingItem;
import net.mcreator.showbiz.item.FaceTVItem;
import net.mcreator.showbiz.item.EmptyCassetteItem;
import net.mcreator.showbiz.item.CentrescreenItem;
import net.mcreator.showbiz.item.CassetteItem;
import net.mcreator.showbiz.ShowbizMod;

import java.util.function.Function;

public class ShowbizModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ShowbizMod.MODID);
	public static final DeferredItem<Item> CAMERA = block(ShowbizModBlocks.CAMERA);
	public static final DeferredItem<Item> REMOTE = register("remote", RemoteItem::new);
	public static final DeferredItem<Item> TIP_JAR = block(ShowbizModBlocks.TIP_JAR);
	public static final DeferredItem<Item> FACE_TV = register("face_tv", FaceTVItem::new);
	public static final DeferredItem<Item> STAGE_LIGHT = block(ShowbizModBlocks.STAGE_LIGHT);
	public static final DeferredItem<Item> CATWALK = block(ShowbizModBlocks.CATWALK);
	public static final DeferredItem<Item> CLAPBOARD = block(ShowbizModBlocks.CLAPBOARD);
	public static final DeferredItem<Item> CASSETTE_PLAYER = block(ShowbizModBlocks.CASSETTE_PLAYER);
	public static final DeferredItem<Item> CASSETTE = register("cassette", CassetteItem::new);
	public static final DeferredItem<Item> CENTRESCREEN = register("centrescreen", CentrescreenItem::new);
	public static final DeferredItem<Item> LAUGHING = register("laughing", LaughingItem::new);
	public static final DeferredItem<Item> LIMELAND = register("limeland", LimelandItem::new);
	public static final DeferredItem<Item> PRESENTING = register("presenting", PresentingItem::new);
	public static final DeferredItem<Item> SPONSORSHIP = register("sponsorship", SponsorshipItem::new);
	public static final DeferredItem<Item> THEBOARD = register("theboard", TheboardItem::new);
	public static final DeferredItem<Item> EMPTY_CASSETTE = register("empty_cassette", EmptyCassetteItem::new);
	public static final DeferredItem<Item> RELAY = block(ShowbizModBlocks.RELAY);
	public static final DeferredItem<Item> DONATION_PRESENT = block(ShowbizModBlocks.DONATION_PRESENT);
	public static final DeferredItem<Item> DONATION_MAILBOX = block(ShowbizModBlocks.DONATION_MAILBOX);
	public static final DeferredItem<Item> WRENCH = register("wrench", WrenchItem::new);
	public static final DeferredItem<Item> SNOWING = register("snowing", SnowingItem::new);
	public static final DeferredItem<Item> BUZZER_BUTTON = block(ShowbizModBlocks.BUZZER_BUTTON);
	public static final DeferredItem<Item> STARWALL = block(ShowbizModBlocks.STARWALL);
	public static final DeferredItem<Item> GEARBOX = block(ShowbizModBlocks.GEARBOX);
	public static final DeferredItem<Item> CHAINLINK_FENCE = block(ShowbizModBlocks.CHAINLINK_FENCE);
	public static final DeferredItem<Item> CONFETTI_CANNON = block(ShowbizModBlocks.CONFETTI_CANNON);
	public static final DeferredItem<Item> ENDER_CAMERA = block(ShowbizModBlocks.ENDER_CAMERA);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}