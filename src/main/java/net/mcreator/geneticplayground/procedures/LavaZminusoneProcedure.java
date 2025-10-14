package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LavaZminusoneProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean lava = false;
		if ((world.getFluidState(BlockPos.containing(x, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.LAVA) {
			lava = true;
		} else {
			lava = false;
		}
		return lava;
	}
}