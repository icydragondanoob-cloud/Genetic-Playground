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

public class BloodCentrifugeJEIRecipeCategory implements IRecipeCategory<BloodCentrifugeJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("genetic_playground:blood_centrifuge_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("genetic_playground:textures/screens/bloodcentrifugejei2.png");
	private final IDrawable background;
	private final IDrawable icon;

	public BloodCentrifugeJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 89);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GeneticPlaygroundModBlocks.BLOOD_CENTRIFUGE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<BloodCentrifugeJEIRecipe> getRecipeType() {
		return GeneticPlaygroundModJeiPlugin.BloodCentrifugeJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Blood Centrifuge");
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
	public void draw(BloodCentrifugeJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, BloodCentrifugeJEIRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 53, 41).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 100, 50).addItemStack(recipe.getResultItem(null));
	}
}