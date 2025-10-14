package net.mcreator.geneticplayground.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class SpentFuelRodItem extends Item {
	public SpentFuelRodItem() {
		super(new Item.Properties());
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack itemstack, BlockState state) {
		return true;
	}
}