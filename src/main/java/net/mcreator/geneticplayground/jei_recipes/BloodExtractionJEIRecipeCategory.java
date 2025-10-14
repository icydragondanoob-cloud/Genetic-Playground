package net.mcreator.geneticplayground.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModJeiPlugin;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class BloodExtractionJEIRecipeCategory implements IRecipeCategory<BloodExtractionJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("genetic_playground:blood_extraction_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("genetic_playground:textures/screens/bloodextractionjei1.png");
	private final IDrawable background;
	private final IDrawable icon;

	public BloodExtractionJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 95, 56);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GeneticPlaygroundModBlocks.DNA_EXTRACTOR.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<BloodExtractionJEIRecipe> getRecipeType() {
		return GeneticPlaygroundModJeiPlugin.BloodExtractionJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Blood Extraction JEI");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(BloodExtractionJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, BloodExtractionJEIRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 14, 17).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 65, 17).addItemStack(recipe.getResultItem(null));
	}
}