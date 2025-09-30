/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.geneticplayground.fluid.types.SterileBloodFluidType;
import net.mcreator.geneticplayground.fluid.types.PlasmaResidueFluidType;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

public class GeneticPlaygroundModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> PLASMA_RESIDUE_TYPE = REGISTRY.register("plasma_residue", () -> new PlasmaResidueFluidType());
	public static final DeferredHolder<FluidType, FluidType> STERILE_BLOOD_TYPE = REGISTRY.register("sterile_blood", () -> new SterileBloodFluidType());
}