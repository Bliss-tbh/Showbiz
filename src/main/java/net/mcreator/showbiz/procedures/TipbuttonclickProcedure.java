package net.mcreator.showbiz.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.showbiz.network.ShowbizModVariables;

public class TipbuttonclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "X"), getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Y"), getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Z"));
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("haspresent", true);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		{
			ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
			_vars.playerdonateuses = entity.getData(ShowbizModVariables.PLAYER_VARIABLES).playerdonateuses + 1;
			_vars.syncPlayerVariables(entity);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}