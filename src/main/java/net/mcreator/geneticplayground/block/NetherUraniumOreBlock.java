package net.mcreator.geneticplayground.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class NetherUraniumOreBlock extends Block {
	public NetherUraniumOreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHER_ORE).strength(0.4f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.SNARE));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}