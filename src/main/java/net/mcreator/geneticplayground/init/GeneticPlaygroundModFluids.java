/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.geneticplayground.fluid.SterileBloodFluid;
import net.mcreator.geneticplayground.fluid.PlasmaResidueFluid;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

public class GeneticPlaygroundModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> PLASMA_RESIDUE = REGISTRY.register("plasma_residue", () -> new PlasmaResidueFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PLASMA_RESIDUE = REGISTRY.register("flowing_plasma_residue", () -> new PlasmaResidueFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> STERILE_BLOOD = REGISTRY.register("sterile_blood", () -> new SterileBloodFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_STERILE_BLOOD = REGISTRY.register("flowing_sterile_blood", () -> new SterileBloodFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(PLASMA_RESIDUE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PLASMA_RESIDUE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(STERILE_BLOOD.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_STERILE_BLOOD.get(), RenderType.translucent());
		}
	}
}