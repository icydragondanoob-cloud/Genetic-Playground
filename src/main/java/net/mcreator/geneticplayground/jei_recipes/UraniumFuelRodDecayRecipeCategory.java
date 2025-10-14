package net.mcreator.geneticplayground.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModJeiPlugin;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class UraniumFuelRodDecayRecipeCategory implements IRecipeCategory<UraniumFuelRodDecayRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("genetic_playground:uranium_fuel_rod_decay");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("genetic_playground:textures/screens/uraniumdecayjei2.png");
	private final IDrawable background;
	private final IDrawable icon;

	public UraniumFuelRodDecayRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 73);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GeneticPlaygroundModItems.URANIUM_FUEL_ROD.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<UraniumFuelRodDecayRecipe> getRecipeType() {
		return GeneticPlaygroundModJeiPlugin.UraniumFuelRodDecay_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Uranium Fuel Rod Decay");
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
	public void draw(UraniumFuelRodDecayRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, UraniumFuelRodDecayRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 18, 27).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 144, 27).addItemStack(recipe.getResultItem(null));
	}
}