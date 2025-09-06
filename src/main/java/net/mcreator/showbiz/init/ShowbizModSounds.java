/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.showbiz.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.showbiz.ShowbizMod;

public class ShowbizModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ShowbizMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> CLAPPER = REGISTRY.register("clapper", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "clapper")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CASSETEINPUTOUTPUT = REGISTRY.register("casseteinputoutput", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "casseteinputoutput")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AWW = REGISTRY.register("aww", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "aww")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CENTRESCREEN = REGISTRY.register("centrescreen", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "centrescreen")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LAUGHING = REGISTRY.register("laughing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "laughing")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LIMELAND = REGISTRY.register("limeland", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "limeland")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PRESENTING = REGISTRY.register("presenting", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "presenting")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SPONSORSHIP = REGISTRY.register("sponsorship", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "sponsorship")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEBOARD = REGISTRY.register("theboard", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "theboard")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SNOWINGELSE = REGISTRY.register("snowingelse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "snowingelse")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CANNON = REGISTRY.register("cannon", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("showbiz", "cannon")));
}