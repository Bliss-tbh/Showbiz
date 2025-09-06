package net.mcreator.showbiz.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.showbiz.network.ShowbizModVariables;

public class SetlastxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
			_vars.lastX = x;
			_vars.syncPlayerVariables(entity);
		}
		{
			ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
			_vars.LastY = y;
			_vars.syncPlayerVariables(entity);
		}
		{
			ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
			_vars.LastZ = z;
			_vars.syncPlayerVariables(entity);
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(
					Component.literal((entity.getData(ShowbizModVariables.PLAYER_VARIABLES).lastX + "" + entity.getData(ShowbizModVariables.PLAYER_VARIABLES).LastY + entity.getData(ShowbizModVariables.PLAYER_VARIABLES).LastZ)), false);
		{
			ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
			_vars.goobert = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}