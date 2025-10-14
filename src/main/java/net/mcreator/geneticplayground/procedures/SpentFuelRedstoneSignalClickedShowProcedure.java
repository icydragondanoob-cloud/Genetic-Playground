package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SpentFuelRedstoneSignalClickedShowProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}