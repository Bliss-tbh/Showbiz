/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.showbiz.ShowbizMod;

public class ShowbizModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, ShowbizMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_CONFETTI = REGISTRY.register("pink_confetti", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ORANGE_CONFETTI = REGISTRY.register("orange_confetti", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_CONFETTI = REGISTRY.register("blue_confetti", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> YELLOW_CONFETTI = REGISTRY.register("yellow_confetti", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLACK_CONFETTI = REGISTRY.register("black_confetti", () -> new SimpleParticleType(false));
}