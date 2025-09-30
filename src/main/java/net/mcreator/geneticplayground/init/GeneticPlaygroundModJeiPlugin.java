package net.mcreator.geneticplayground.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.geneticplayground.jei_recipes.PlasmidSynthesiserJEITypeRecipeCategory;
import net.mcreator.geneticplayground.jei_recipes.PlasmidSynthesiserJEITypeRecipe;

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

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("genetic_playground:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new PlasmidSynthesiserJEITypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<PlasmidSynthesiserJEITypeRecipe> PlasmidSynthesiserJEITypeRecipes = recipeManager.getAllRecipesFor(PlasmidSynthesiserJEITypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(PlasmidSynthesiserJEIType_Type, PlasmidSynthesiserJEITypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(GeneticPlaygroundModBlocks.PLASMID_SYNTHESISER.get().asItem()), PlasmidSynthesiserJEIType_Type);
	}
}