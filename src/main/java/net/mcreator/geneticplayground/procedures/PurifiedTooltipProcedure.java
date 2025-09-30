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
public class PurifiedTooltipProcedure {
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
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_COD_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("purified") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oPurified Blood"));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableSpeed") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Speed:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableMilkable") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Milkable Gene:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("MilkableGene"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableGrazing") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Grazing Gene:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableMaxHealth") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Max Health:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWooly") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Shearable:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("WoolyGene"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableHydrophobia") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Hydrophobia:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Hydrophobia"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableTeleportation") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Teleportation:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("TeleportationGene"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableEgg") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Egg Production:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EggGene"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableHigherJump") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Higher Jumpower:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("HigherJump"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableEndersight") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Endersight:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Endersight"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWaterSpeed") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Water Speed:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed"))));
		}
		if (itemstack.getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWaterbreathing") == true) {
			tooltip.add(1, Component.literal("\u00A77\u00A7oInjectable"));
			tooltip.add(2, Component.literal(" "));
			tooltip.add(3, Component.literal(("\u00A72Water Breathing:" + "\u00A7r " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing"))));
		}
	}
}