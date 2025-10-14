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

public class PlasmidSynthesiserJEITypeRecipeCategory implements IRecipeCategory<PlasmidSynthesiserJEITypeRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("genetic_playground:plasmid_synthesiser_jei_type");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("genetic_playground:textures/screens/plasmidsynthesiserjei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public PlasmidSynthesiserJEITypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 115);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GeneticPlaygroundModBlocks.PLASMID_SYNTHESISER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<PlasmidSynthesiserJEITypeRecipe> getRecipeType() {
		return GeneticPlaygroundModJeiPlugin.PlasmidSynthesiserJEIType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Plasmid Synthesiser");
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
	public void draw(PlasmidSynthesiserJEITypeRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, PlasmidSynthesiserJEITypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 134, 71).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 134, 53).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 134, 35).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 116, 17).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 98, 17).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 17).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 35).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 53).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 71).addIngredients(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 89).addIngredients(recipe.getIngredients().get(9));
		builder.addSlot(RecipeIngredientRole.INPUT, 98, 89).addIngredients(recipe.getIngredients().get(10));
		builder.addSlot(RecipeIngredientRole.INPUT, 116, 89).addIngredients(recipe.getIngredients().get(11));
		builder.addSlot(RecipeIngredientRole.INPUT, 136, 15).addIngredients(recipe.getIngredients().get(12));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 98, 53).addItemStack(recipe.getResultItem(null));
	}
}