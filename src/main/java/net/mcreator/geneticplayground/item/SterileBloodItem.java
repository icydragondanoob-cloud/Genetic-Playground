package net.mcreator.geneticplayground.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluids;

public class SterileBloodItem extends BucketItem {
	public SterileBloodItem() {
		super(GeneticPlaygroundModFluids.STERILE_BLOOD.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}