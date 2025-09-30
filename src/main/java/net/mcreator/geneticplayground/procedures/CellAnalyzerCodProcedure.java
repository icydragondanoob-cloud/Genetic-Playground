package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;

public class CellAnalyzerCodProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double previousRecipe = 0;
		double fireHeight = 0;
		ItemStack blood = ItemStack.EMPTY;
		ItemStack blood2 = ItemStack.EMPTY;
		ItemStack slot0 = ItemStack.EMPTY;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.COD_CELL.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 80000 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.COD_CELL.get()
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 64) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == GeneticPlaygroundModItems.MACHINE_SPEED_UPGRADE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("maxTimer", 350);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("maxTimer", 2750);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == GeneticPlaygroundModItems.MACHINE_SPEED_UPGRADE.get()) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") > 350) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("timer", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(80000, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.COD_CELL.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "analyzed";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "SpeedDNA";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "MaxHealthDNA";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "SpeedEffDNA";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "WaterSpeed";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "Waterbreathing";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(1, _setstack);
						}
					}
				} else {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") > 2750) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("timer", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(80000, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.COD_CELL.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "analyzed";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "SpeedDNA";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "SpeedEffDNA";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "MaxHealthDNA";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "WaterSpeed";
							final double _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "Waterbreathing";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(1, _setstack);
						}
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("timer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("timer", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	public static int getEnergyStored(LevelAccessor level, BlockPos pos, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IEnergyStorage energyStorage = levelExtension.getCapability(Capabilities.EnergyStorage.BLOCK, pos, direction);
			if (energyStorage != null)
				return energyStorage.getEnergyStored();
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