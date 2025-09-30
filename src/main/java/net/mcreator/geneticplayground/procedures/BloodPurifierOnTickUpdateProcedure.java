package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModFluids;

public class BloodPurifierOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double previousRecipe = 0;
		double fireHeight = 0;
		ItemStack blood = ItemStack.EMPTY;
		ItemStack blood2 = ItemStack.EMPTY;
		ItemStack slot0 = ItemStack.EMPTY;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "MilkableGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("MilkableGene"));
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
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "purified";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "MilkableGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("MilkableGene"));
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "WoolyGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("WoolyGene"));
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
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "purified";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "WoolyGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("WoolyGene"));
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
							final String _tagName = "EggGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EggGene"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
							final String _tagName = "GrazingGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EggGene"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "TeleportationGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("TeleportationGene"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "Endersight";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Endersight"));
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
							final String _tagName = "Hydrophobia";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Hydrophobia"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "TeleportationGene";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("TeleportationGene"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "purified";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "Hydrophobia";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Hydrophobia"));
							CustomData.update(DataComponents.CUSTOM_DATA, blood2, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						{
							final String _tagName = "Endersight";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Endersight"));
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
							final String _tagName = "HigherJump";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("HigherJump"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
							final String _tagName = "HigherJump";
							final boolean _tagValue = (slot0.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("HigherJump"));
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
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get()) {
			if (getEnergyStored(world, BlockPos.containing(x, y, z), null) >= 12500 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get()
					&& getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) < 1000
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == false
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < 1) {
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(GeneticPlaygroundModFluids.PLASMA_RESIDUE.get(), 100), IFluidHandler.FluidAction.EXECUTE);
						}
						if (world instanceof ILevelExtension _ext) {
							IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
							if (_entityStorage != null)
								_entityStorage.extractEnergy(12500, false);
						}
						blood2 = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get()).copy();
						slot0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						{
							final String _tagName = "purified";
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
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = blood2.copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 2);
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
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_COD_BLOOD.get()) {
			BloodPuriferCodProcedure.execute(world, x, y, z);
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_SALMON_BLOOD.get()) {
			BloodPuriferSalmonProcedure.execute(world, x, y, z);
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
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") != 0) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.BUCKET && getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) >= 1000) {
			if (world instanceof ILevelExtension _ext) {
				IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
				if (_fluidHandler != null)
					_fluidHandler.drain(1000, IFluidHandler.FluidAction.EXECUTE);
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 2;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.shrink(1);
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.PLASMA_RESIDUE_BUCKET.get()).copy();
				_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.fill")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.fill")), SoundSource.NEUTRAL, 1, 1, false);
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

	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IFluidHandler fluidHandler = levelExtension.getCapability(Capabilities.FluidHandler.BLOCK, pos, direction);
			if (fluidHandler != null)
				return fluidHandler.getFluidInTank(tank).getAmount();
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