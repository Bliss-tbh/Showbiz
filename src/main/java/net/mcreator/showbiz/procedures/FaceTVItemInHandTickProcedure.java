package net.mcreator.showbiz.procedures;

import net.minecraft.world.item.ItemStack;

public class FaceTVItemInHandTickProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.shrink(64);
	}
}