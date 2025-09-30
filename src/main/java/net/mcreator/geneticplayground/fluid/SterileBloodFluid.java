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

public abstract class SterileBloodFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> GeneticPlaygroundModFluidTypes.STERILE_BLOOD_TYPE.get(), () -> GeneticPlaygroundModFluids.STERILE_BLOOD.get(),
			() -> GeneticPlaygroundModFluids.FLOWING_STERILE_BLOOD.get()).explosionResistance(100f).bucket(() -> GeneticPlaygroundModItems.STERILE_BLOOD_BUCKET.get()).block(() -> (LiquidBlock) GeneticPlaygroundModBlocks.STERILE_BLOOD.get());

	private SterileBloodFluid() {
		super(PROPERTIES);
	}

	public static class Source extends SterileBloodFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SterileBloodFluid {
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