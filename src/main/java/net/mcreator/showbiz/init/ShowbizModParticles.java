/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.showbiz.client.particle.YellowConfettiParticle;
import net.mcreator.showbiz.client.particle.PinkConfettiParticle;
import net.mcreator.showbiz.client.particle.OrangeConfettiParticle;
import net.mcreator.showbiz.client.particle.BlueConfettiParticle;
import net.mcreator.showbiz.client.particle.BlackConfettiParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ShowbizModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ShowbizModParticleTypes.PINK_CONFETTI.get(), PinkConfettiParticle::provider);
		event.registerSpriteSet(ShowbizModParticleTypes.ORANGE_CONFETTI.get(), OrangeConfettiParticle::provider);
		event.registerSpriteSet(ShowbizModParticleTypes.BLUE_CONFETTI.get(), BlueConfettiParticle::provider);
		event.registerSpriteSet(ShowbizModParticleTypes.YELLOW_CONFETTI.get(), YellowConfettiParticle::provider);
		event.registerSpriteSet(ShowbizModParticleTypes.BLACK_CONFETTI.get(), BlackConfettiParticle::provider);
	}
}