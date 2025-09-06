package net.mcreator.showbiz.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.showbiz.procedures.FaceTVItemInHandTickProcedure;

public class FaceTVItem extends Item {
	public FaceTVItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			FaceTVItemInHandTickProcedure.execute(itemstack);
	}
}