package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class GoldCableOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("feblock", 0);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("cableholdenergy", (getEnergyStored(world, BlockPos.containing(x, y, z), null)));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:femachines")))
				&& !(world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:fegenerator")))
				&& getEnergyStored(world, BlockPos.containing(x + 1, y, z), null) == getMaxEnergyStored(world, BlockPos.containing(x + 1, y, z), null)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("feblock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:femachines")))
				&& !(world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:fegenerator")))
				&& getEnergyStored(world, BlockPos.containing(x - 1, y, z), null) != getMaxEnergyStored(world, BlockPos.containing(x - 1, y, z), null)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("feblock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:femachines")))
				&& !(world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:fegenerator")))
				&& getEnergyStored(world, BlockPos.containing(x, y, z + 1), null) != getMaxEnergyStored(world, BlockPos.containing(x, y, z + 1), null)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("feblock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:femachines")))
				&& !(world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:fegenerator")))
				&& getEnergyStored(world, BlockPos.containing(x, y, z - 1), null) != getMaxEnergyStored(world, BlockPos.containing(x, y, z - 1), null)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("feblock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:femachines")))
				&& !(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:fegenerator")))
				&& getEnergyStored(world, BlockPos.containing(x, y + 1, z), null) != getMaxEnergyStored(world, BlockPos.containing(x, y + 1, z), null)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("feblock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:femachines")))
				|| !(!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("geneticplayground:fegenerator")))
						&& getEnergyStored(world, BlockPos.containing(x, y - 1, z), null) != getMaxEnergyStored(world, BlockPos.containing(x, y - 1, z), null))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("feblock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock") > 0) {
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x + 1, y, z), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x - 1, y, z), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y + 1, z), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y - 1, z), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z + 1), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z - 1), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
				if (_entityStorage != null)
					_entityStorage.extractEnergy((int) (getEnergyStored(world, BlockPos.containing(x, y, z), null) * getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feblock")), false);
			}
		}
	}

	public static int getEnergyStored(LevelAccessor level, BlockPos pos, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IEnergyStorage energyStorage = levelExtension.getCapability(Capabilities.EnergyStorage.BLOCK, pos, direction);
			if (energyStorage != null)
				return energyStorage.getEnergyStored();
		}
		return 0;
	}

	public static int getMaxEnergyStored(LevelAccessor level, BlockPos pos, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IEnergyStorage energyStorage = levelExtension.getCapability(Capabilities.EnergyStorage.BLOCK, pos, direction);
			if (energyStorage != null)
				return energyStorage.getMaxEnergyStored();
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}