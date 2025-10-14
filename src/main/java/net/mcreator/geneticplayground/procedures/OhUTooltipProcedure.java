package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class OhUTooltipProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return "\u00A7cHeat/t: \u00A76" + new java.text.DecimalFormat("##.##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhU")) + " \u03A9hU" + "\n" + "\u00A7cHeat: \u00A76"
				+ new java.text.DecimalFormat("##.##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUF")) + " \u03A9hU" + "\n" + "\u00A79Coolant: \u00A76"
				+ new java.text.DecimalFormat("##.##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OcU")) + " \u03A9cU" + "\n" + "\u00A7cPotential heat/t: \u00A76"
				+ new java.text.DecimalFormat("##.##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OOhU")) + " \u03A9phU";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}