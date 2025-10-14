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
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModBlocks;

public class FissionPowerPlantControllerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack FuelRod0 = ItemStack.EMPTY;
		ItemStack FuelRod1 = ItemStack.EMPTY;
		ItemStack FuelRod2 = ItemStack.EMPTY;
		ItemStack FuelRod3 = ItemStack.EMPTY;
		ItemStack FuelRod4 = ItemStack.EMPTY;
		ItemStack FuelRod5 = ItemStack.EMPTY;
		ItemStack FuelRod6 = ItemStack.EMPTY;
		ItemStack FuelRod7 = ItemStack.EMPTY;
		ItemStack FuelRod8 = ItemStack.EMPTY;
		ItemStack FuelRod9 = ItemStack.EMPTY;
		ItemStack FuelRod10 = ItemStack.EMPTY;
		ItemStack FuelRod11 = ItemStack.EMPTY;
		ItemStack FuelRod12 = ItemStack.EMPTY;
		ItemStack FuelRod13 = ItemStack.EMPTY;
		ItemStack FuelRod14 = ItemStack.EMPTY;
		double redstone = 0;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("FuelRods", 0);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 0;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(0, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 1;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(1, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 2;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 3;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(3, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 4;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(4, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 5;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(5, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 6;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(6, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 7;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(7, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 8;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(8, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 9;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(9, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 10;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(10, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 11).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 11;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 11).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 11).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(11, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 12).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 12;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 12).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 12).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(12, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 13).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 13;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 13).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 13).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(13, _setstack);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 14).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				int _slotid = 14;
				ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
				_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
				});
				_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("FuelRods", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 14).copy()).getDamageValue() == 99988 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 14).copy()).getDamageValue() == 99989) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(14, _setstack);
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") != 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OOhU", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") * 425));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhU", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") * 425 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OcU")));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUOT", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") * 425));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUT", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhU")));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OphU", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OphU") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OOhU")));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUF", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT")));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelRods") == 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OOhU", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhU", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUOT", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") != 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("OhUT", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") / 212.5));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("OhUF", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT")));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OphU") != 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("OphU", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OphU") - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OphU") / 212.5));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") == 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUT", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUOT")));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUF") < 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUF", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") < 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OhUT", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OphU") < 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("OphU", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OhUT") > 31874998) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 25, Level.ExplosionInteraction.TNT);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 7500, 3, 3, 3, 0.05);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 500, 1, 1, 1, 0.1);
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == GeneticPlaygroundModBlocks.THERMAL_TURBINE.get()) {
			if (world instanceof ILevelExtension _ext) {
				IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y + 1, z), null);
				if (_entityStorage != null)
					_entityStorage.receiveEnergy((int) (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OOhU") * 5), false);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("Slot", 0);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 11).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 12).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 13).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == true) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 14).copy()).getItem() == GeneticPlaygroundModItems.SPENT_FUEL_ROD.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Slot", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slot") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "SpentFuelRedstone") == false) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("Slot", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}