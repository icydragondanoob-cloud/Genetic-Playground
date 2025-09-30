package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ProgressUpdaterProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double ProgressLevel = 0;
		ProgressLevel = Math.round((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") * 21) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "maxTimer"));
		return ProgressLevel;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}