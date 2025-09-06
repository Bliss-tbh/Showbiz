/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.showbiz.world.inventory.TipguiMenu;
import net.mcreator.showbiz.world.inventory.ContainerMenu;
import net.mcreator.showbiz.network.MenuStateUpdateMessage;
import net.mcreator.showbiz.ShowbizMod;

import java.util.Map;

public class ShowbizModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ShowbizMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<TipguiMenu>> TIPGUI = REGISTRY.register("tipgui", () -> IMenuTypeExtension.create(TipguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ContainerMenu>> CONTAINER = REGISTRY.register("container", () -> IMenuTypeExtension.create(ContainerMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof ShowbizModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}