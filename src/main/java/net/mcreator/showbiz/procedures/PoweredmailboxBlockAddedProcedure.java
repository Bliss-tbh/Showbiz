package net.mcreator.showbiz.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.showbiz.init.ShowbizModBlocks;
import net.mcreator.showbiz.ShowbizMod;

public class PoweredmailboxBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ShowbizMod.queueServerWork(5, () -> {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = ShowbizModBlocks.DONATION_MAILBOX.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		});
	}
}