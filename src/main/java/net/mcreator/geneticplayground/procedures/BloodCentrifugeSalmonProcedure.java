package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
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
import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluids;

public class BloodCentrifugeSalmonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack Slot2 = ItemStack.EMPTY;
		ItemStack Slot0 = ItemStack.EMPTY;
		ItemStack Slot1 = ItemStack.EMPTY;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_SALMON_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 40000 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_SALMON_BLOOD.get()
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == GeneticPlaygroundModItems.MACHINE_SPEED_UPGRADE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("maxTimer", 500);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("maxTimer", 5000);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == GeneticPlaygroundModItems.MACHINE_SPEED_UPGRADE.get()) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") > 500) {
						Slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("timer", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(40000, false);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SALMON_CELL.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(2, _setstack);
						}
						Slot2 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).copy();
						{
							final String _tagName = "Waterbreathing";
							final boolean _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing"));
							CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "SpeedDNA";
							final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "SpeedEffDNA";
							final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "MaxHealthDNA";
							final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA"));
							CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "WaterSpeed";
							final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed"));
							CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = Slot1.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(1, _setstack);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = Slot2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(2, _setstack);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
							_itemHandlerModifiable.setStackInSlot(1, _setstack);
						}
						if (world instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.STERILE_BLOOD.get(), 150), IFluidHandler.FluidAction.EXECUTE);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") > 5000) {
					Slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("timer", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 0;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
						if (_entityStorage != null)
							_entityStorage.extractEnergy(40000, false);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SALMON_CELL.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					Slot2 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).copy();
					{
						final String _tagName = "Waterbreathing";
						final boolean _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing"));
						CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					{
						final String _tagName = "WaterSpeed";
						final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed"));
						CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "SpeedDNA";
						final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA"));
						CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "SpeedEffDNA";
						final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA"));
						CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "MaxHealthDNA";
						final double _tagValue = (Slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA"));
						CustomData.update(DataComponents.CUSTOM_DATA, Slot2, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = Slot1.copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(1, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = Slot2.copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(1, _setstack);
					}
					if (world instanceof ILevelExtension _ext) {
						IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
						if (_fluidHandler != null)
							_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.STERILE_BLOOD.get(), 150), IFluidHandler.FluidAction.EXECUTE);
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