package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class TestTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == GeneticPlaygroundModItems.PIG_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.COW_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SHEEP_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.ENDERMAN_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.CHICKEN_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.RABBIT_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.HORSE_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DONKEY_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.MULE_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.COD_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.CREEPER_CELL.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("analyzed") == true) {
			tooltip.add(Component.literal("\u00A77\u00A7oAnalyzed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_MOVEMENT_SPEED.get()) {
			tooltip.add(Component.literal(("\u00A72Speed DNA: " + "\u00A7r" + new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA")))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_MILKABLE.get()) {
			tooltip.add(Component.literal("\u00A79Milkable "));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_MAX_HEALTH.get()) {
			tooltip.add(Component.literal(("\u00A72Max Health DNA: " + "\u00A7r" + new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxhealthDNA")))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_GRAZING.get()) {
			tooltip.add(Component.literal("\u00A79Eat Grass"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_EGG.get()) {
			tooltip.add(Component.literal("\u00A79Egg Prod."));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.HYDROPHOBIA_DOUBLE_HELIX.get()) {
			tooltip.add(Component.literal("\u00A75Hydrophobia"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_TELEPORATION.get()) {
			tooltip.add(Component.literal("\u00A75Teleporation"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_ENDERSIGHT.get()) {
			tooltip.add(Component.literal("\u00A75Endersight"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_HIGHER_JUMP.get()) {
			tooltip.add(Component.literal("\u00A79Higher Jump"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_WATER_SPEED.get()) {
			tooltip.add(Component.literal("\u00A79Water Speed"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_WATER_BREATHING.get()) {
			tooltip.add(Component.literal("\u00A79Water Breathing"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.DOUBLE_HELIX_EXPLOSIVE.get()) {
			tooltip.add(Component.literal("\u00A79Explosive"));
		}
	}
}