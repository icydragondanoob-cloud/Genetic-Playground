package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class FuelRodSlotTooltip2Procedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return "\u00A7a\u00A7oFuel Rod Slot" + "\n" + " \u00A7o\u00A76\u25BA +425 \u03A9hU/t" + "\n" + " \u00A7o\u00A76\u25BA " + new java.text.DecimalFormat("#.##")
				.format((((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getMaxDamage() - (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getDamageValue()) / 20d) / 60) + " Minutes until decay.";
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}