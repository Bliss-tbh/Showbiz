package net.mcreator.showbiz.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.showbiz.network.ShowbizModVariables;
import net.mcreator.showbiz.ShowbizMod;

public class LeaveBroadcastOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ShowbizModVariables.PLAYER_VARIABLES).spectatormode == true) {
			{
				ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
				_vars.spectatormode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
				_vars.corporealmode = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			entity.clearFire();
			ShowbizMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					_ent.teleportTo(entity.getData(ShowbizModVariables.PLAYER_VARIABLES).lastX, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).LastY, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).LastZ);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getData(ShowbizModVariables.PLAYER_VARIABLES).lastX, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).LastY, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).LastZ,
								_ent.getYRot(), _ent.getXRot());
				}
			});
			if (!(getBlockNBTNumber(world, BlockPos.containing(entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVX, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVY, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVZ),
					"view") == 0)) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVX, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVY, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData()
								.putDouble("view",
										(getBlockNBTNumber(world,
												BlockPos.containing(entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVX, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVY, entity.getData(ShowbizModVariables.PLAYER_VARIABLES).TVZ), "view")
												- 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}