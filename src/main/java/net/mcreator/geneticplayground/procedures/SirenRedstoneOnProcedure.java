package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModBlocks;

public class SirenRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z)) && (world.getBlockState(BlockPos.containing(x, y, z))) == (new Object() {
			public BlockState with(BlockState _bs, String _property, int _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
			}
		}.with(GeneticPlaygroundModBlocks.SIREN.get().defaultBlockState(), "blockstate", 0))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:siren.alarm")), SoundSource.BLOCKS, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:siren.alarm")), SoundSource.BLOCKS, 3, 1, false);
				}
			}
		} else if (world instanceof Level _level5 && _level5.hasNeighborSignal(BlockPos.containing(x, y, z)) && (world.getBlockState(BlockPos.containing(x, y, z))) == (new Object() {
			public BlockState with(BlockState _bs, String _property, int _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
			}
		}.with(GeneticPlaygroundModBlocks.SIREN.get().defaultBlockState(), "blockstate", 1))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:siren.alarm2")), SoundSource.BLOCKS, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:siren.alarm2")), SoundSource.BLOCKS, 3, 1, false);
				}
			}
		} else if (world instanceof Level _level10 && _level10.hasNeighborSignal(BlockPos.containing(x, y, z)) && (world.getBlockState(BlockPos.containing(x, y, z))) == (new Object() {
			public BlockState with(BlockState _bs, String _property, int _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
			}
		}.with(GeneticPlaygroundModBlocks.SIREN.get().defaultBlockState(), "blockstate", 2))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:siren.alarm3")), SoundSource.BLOCKS, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:siren.alarm3")), SoundSource.BLOCKS, 3, 1, false);
				}
			}
		}
	}
}