package net.mcreator.geneticplayground.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class GeneticPlaygroundModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("genetic_playground:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(
				List.of(new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get()),
						new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get()),
						new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get()),
						new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COD_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_SALMON_BLOOD.get()), new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_CREEPER_BLOOD.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.genetic_playground.blood_extraction"));
		registration.addIngredientInfo(List.of(new ItemStack(GeneticPlaygroundModItems.PIG_CELL.get()), new ItemStack(GeneticPlaygroundModItems.COW_CELL.get()), new ItemStack(GeneticPlaygroundModItems.SHEEP_CELL.get()),
				new ItemStack(GeneticPlaygroundModItems.ENDERMAN_CELL.get()), new ItemStack(GeneticPlaygroundModItems.CHICKEN_CELL.get()), new ItemStack(GeneticPlaygroundModItems.RABBIT_CELL.get()),
				new ItemStack(GeneticPlaygroundModItems.DONKEY_CELL.get()), new ItemStack(GeneticPlaygroundModItems.MULE_CELL.get()), new ItemStack(GeneticPlaygroundModItems.COD_CELL.get()), new ItemStack(GeneticPlaygroundModItems.SALMON_CELL.get()),
				new ItemStack(GeneticPlaygroundModItems.CREEPER_CELL.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.genetic_playground.cell_analyzation"));
		registration.addIngredientInfo(List.of(new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.genetic_playground.sterile_blood_info"));
	}
}