package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CreativeEnergyOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x + 1, y, z), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(400000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x - 1, y, z), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(400000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y + 1, z), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(400000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y - 1, z), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(400000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z + 1), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(400000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z - 1), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(400000, false);
		}
	}
}