package net.mcreator.showbiz.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.showbiz.network.ShowbizModVariables;

import java.util.Comparator;

public class RelayOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				{
					ShowbizModVariables.PlayerVariables _vars = entityiterator.getData(ShowbizModVariables.PLAYER_VARIABLES);
					_vars.insync = 1;
					_vars.syncPlayerVariables(entityiterator);
				}
			}
		}
	}
}