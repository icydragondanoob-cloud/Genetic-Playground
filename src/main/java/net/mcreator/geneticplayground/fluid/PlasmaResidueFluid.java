package net.mcreator.geneticplayground.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluids;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluidTypes;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModBlocks;

public abstract class PlasmaResidueFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> GeneticPlaygroundModFluidTypes.PLASMA_RESIDUE_TYPE.get(), () -> GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(),
			() -> GeneticPlaygroundModFluids.FLOWING_PLASMA_RESIDUE.get()).explosionResistance(100f).bucket(() -> GeneticPlaygroundModItems.PLASMA_RESIDUE_BUCKET.get()).block(() -> (LiquidBlock) GeneticPlaygroundModBlocks.PLASMA_RESIDUE.get());

	private PlasmaResidueFluid() {
		super(PROPERTIES);
	}

	public static class Source extends PlasmaResidueFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends PlasmaResidueFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}