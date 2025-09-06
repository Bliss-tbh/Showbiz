package net.mcreator.showbiz.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.showbiz.init.ShowbizModParticleTypes;

public class ConfettiCannonRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("showbiz:cannon")), SoundSource.NEUTRAL, (float) 0.2, (float) Mth.nextDouble(RandomSource.create(), 1, 3.5));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("showbiz:cannon")), SoundSource.NEUTRAL, (float) 0.2, (float) Mth.nextDouble(RandomSource.create(), 1, 3.5), false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ShowbizModParticleTypes.PINK_CONFETTI.get()), x, y, z, 5, 0, 1.5, 0, 0.6);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ShowbizModParticleTypes.ORANGE_CONFETTI.get()), x, y, z, 5, 0, 1.5, 0, 0.6);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ShowbizModParticleTypes.BLUE_CONFETTI.get()), x, y, z, 5, 0, 1.5, 0, 0.6);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ShowbizModParticleTypes.YELLOW_CONFETTI.get()), x, y, z, 5, 0, 1.5, 0, 0.6);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ShowbizModParticleTypes.BLACK_CONFETTI.get()), x, y, z, 5, 0, 1.5, 0, 0.6);
	}
}