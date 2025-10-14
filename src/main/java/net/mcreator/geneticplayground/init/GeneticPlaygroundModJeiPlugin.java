package net.mcreator.geneticplayground.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.geneticplayground.jei_recipes.UraniumFuelRodDecayRecipeCategory;
import net.mcreator.geneticplayground.jei_recipes.UraniumFuelRodDecayRecipe;
import net.mcreator.geneticplayground.jei_recipes.PlasmidSynthesiserJEITypeRecipeCategory;
import net.mcreator.geneticplayground.jei_recipes.PlasmidSynthesiserJEITypeRecipe;
import net.mcreator.geneticplayground.jei_recipes.BloodExtractionJEIRecipeCategory;
import net.mcreator.geneticplayground.jei_recipes.BloodExtractionJEIRecipe;
import net.mcreator.geneticplayground.jei_recipes.BloodCentrifugeJEIRecipeCategory;
import net.mcreator.geneticplayground.jei_recipes.BloodCentrifugeJEIRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class GeneticPlaygroundModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<PlasmidSynthesiserJEITypeRecipe> PlasmidSynthesiserJEIType_Type = new mezz.jei.api.recipe.RecipeType<>(PlasmidSynthesiserJEITypeRecipeCategory.UID, PlasmidSynthesiserJEITypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<BloodCentrifugeJEIRecipe> BloodCentrifugeJEI_Type = new mezz.jei.api.recipe.RecipeType<>(BloodCentrifugeJEIRecipeCategory.UID, BloodCentrifugeJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<BloodExtractionJEIRecipe> BloodExtractionJEI_Type = new mezz.jei.api.recipe.RecipeType<>(BloodExtractionJEIRecipeCategory.UID, BloodExtractionJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<UraniumFuelRodDecayRecipe> UraniumFuelRodDecay_Type = new mezz.jei.api.recipe.RecipeType<>(UraniumFuelRodDecayRecipeCategory.UID, UraniumFuelRodDecayRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("genetic_playground:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new PlasmidSynthesiserJEITypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new BloodCentrifugeJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new BloodExtractionJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new UraniumFuelRodDecayRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<PlasmidSynthesiserJEITypeRecipe> PlasmidSynthesiserJEITypeRecipes = recipeManager.getAllRecipesFor(PlasmidSynthesiserJEITypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(PlasmidSynthesiserJEIType_Type, PlasmidSynthesiserJEITypeRecipes);
		List<BloodCentrifugeJEIRecipe> BloodCentrifugeJEIRecipes = recipeManager.getAllRecipesFor(BloodCentrifugeJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BloodCentrifugeJEI_Type, BloodCentrifugeJEIRecipes);
		List<BloodExtractionJEIRecipe> BloodExtractionJEIRecipes = recipeManager.getAllRecipesFor(BloodExtractionJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(BloodExtractionJEI_Type, BloodExtractionJEIRecipes);
		List<UraniumFuelRodDecayRecipe> UraniumFuelRodDecayRecipes = recipeManager.getAllRecipesFor(UraniumFuelRodDecayRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(UraniumFuelRodDecay_Type, UraniumFuelRodDecayRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(GeneticPlaygroundModBlocks.PLASMID_SYNTHESISER.get().asItem()), PlasmidSynthesiserJEIType_Type);
		registration.addRecipeCatalyst(new ItemStack(GeneticPlaygroundModBlocks.BLOOD_CENTRIFUGE.get().asItem()), BloodCentrifugeJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(GeneticPlaygroundModBlocks.DNA_EXTRACTOR.get().asItem()), BloodExtractionJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(GeneticPlaygroundModBlocks.FISSION_POWER_PLANT_CONTROLLER.get().asItem()), UraniumFuelRodDecay_Type);
	}
}