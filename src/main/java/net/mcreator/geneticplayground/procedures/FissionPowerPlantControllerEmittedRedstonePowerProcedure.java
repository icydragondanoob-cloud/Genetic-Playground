package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FissionPowerPlantControllerEmittedRedstonePowerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double redstone = 0;
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") != 0) {
			redstone = 15;
		} else {
			redstone = 0;
		}
		return redstone;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}