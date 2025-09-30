package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluids;

public class FissionPowerPlantControllerRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.LAVA, 100000), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(Fluids.WATER, 100000), IFluidHandler.FluidAction.EXECUTE);
		}
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.STERILE_BLOOD.get(), 80000), IFluidHandler.FluidAction.EXECUTE);
		}
	}
}