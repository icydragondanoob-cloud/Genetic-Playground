package net.mcreator.geneticplayground.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluids;

public class PlasmaResidueBlock extends LiquidBlock {
	public PlasmaResidueBlock() {
		super(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}