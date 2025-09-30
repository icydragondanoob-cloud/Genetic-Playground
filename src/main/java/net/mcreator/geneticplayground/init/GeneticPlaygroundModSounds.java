/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.geneticplayground.GeneticPlaygroundMod;

public class GeneticPlaygroundModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> SYRINGE_STAB = REGISTRY.register("syringe.stab", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("genetic_playground", "syringe.stab")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CENTRIFUGE_SPIN = REGISTRY.register("centrifuge.spin", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("genetic_playground", "centrifuge.spin")));
}