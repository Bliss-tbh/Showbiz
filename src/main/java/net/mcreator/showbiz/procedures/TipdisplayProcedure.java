package net.mcreator.showbiz.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.showbiz.network.ShowbizModVariables;

public class TipdisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(ShowbizModVariables.PLAYER_VARIABLES).playerdonateuses == 10) {
			return true;
		}
		return false;
	}
}