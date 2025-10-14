package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;

public class FissionPowerPlantOnSCRAMButtonProcedure {
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
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:nuclearpowerplant.scram")), SoundSource.BLOCKS, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:nuclearpowerplant.scram")), SoundSource.BLOCKS, 2, 1, false);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(1, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(3, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(4, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(5, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(6, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(7, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(8, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(9, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(10, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 11).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(11, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 12).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(12, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 13).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(13, _setstack);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 14).copy()).getItem() == GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.DISCARDED_FUEL_ROD.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(14, _setstack);
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
}