package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LavaYplusoneProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean lava = false;
		if ((world.getFluidState(BlockPos.containing(x, y + 1, z)).createLegacyBlock()).getBlock() == Blocks.LAVA) {
			lava = true;
		} else {
			lava = false;
		}
		return lava;
	}
}