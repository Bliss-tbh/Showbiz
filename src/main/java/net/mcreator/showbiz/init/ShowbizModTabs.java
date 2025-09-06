/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.showbiz.ShowbizMod;

public class ShowbizModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShowbizMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SHOWBIZ = REGISTRY.register("showbiz",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.showbiz.showbiz")).icon(() -> new ItemStack(ShowbizModBlocks.CAMERA.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ShowbizModBlocks.CAMERA.get().asItem());
				tabData.accept(ShowbizModItems.REMOTE.get());
				tabData.accept(ShowbizModBlocks.TIP_JAR.get().asItem());
				tabData.accept(ShowbizModBlocks.STAGE_LIGHT.get().asItem());
				tabData.accept(ShowbizModBlocks.CATWALK.get().asItem());
				tabData.accept(ShowbizModBlocks.CLAPBOARD.get().asItem());
				tabData.accept(ShowbizModBlocks.CASSETTE_PLAYER.get().asItem());
				tabData.accept(ShowbizModItems.CASSETTE.get());
				tabData.accept(ShowbizModItems.CENTRESCREEN.get());
				tabData.accept(ShowbizModItems.LAUGHING.get());
				tabData.accept(ShowbizModItems.LIMELAND.get());
				tabData.accept(ShowbizModItems.PRESENTING.get());
				tabData.accept(ShowbizModItems.SPONSORSHIP.get());
				tabData.accept(ShowbizModItems.THEBOARD.get());
				tabData.accept(ShowbizModItems.EMPTY_CASSETTE.get());
				tabData.accept(ShowbizModBlocks.RELAY.get().asItem());
				tabData.accept(ShowbizModBlocks.DONATION_PRESENT.get().asItem());
				tabData.accept(ShowbizModBlocks.DONATION_MAILBOX.get().asItem());
				tabData.accept(ShowbizModItems.WRENCH.get());
				tabData.accept(ShowbizModItems.SNOWING.get());
				tabData.accept(ShowbizModBlocks.BUZZER_BUTTON.get().asItem());
				tabData.accept(ShowbizModBlocks.STARWALL.get().asItem());
				tabData.accept(ShowbizModBlocks.GEARBOX.get().asItem());
				tabData.accept(ShowbizModBlocks.CHAINLINK_FENCE.get().asItem());
				tabData.accept(ShowbizModBlocks.CONFETTI_CANNON.get().asItem());
			}).build());
}