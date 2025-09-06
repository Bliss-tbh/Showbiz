package net.mcreator.showbiz.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.showbiz.network.ShowbizModVariables;

public class LetmeoutDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(ShowbizModVariables.PLAYER_VARIABLES).spectatormode;
	}
}