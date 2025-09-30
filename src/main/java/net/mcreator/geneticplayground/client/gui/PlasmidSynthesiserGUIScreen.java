package net.mcreator.geneticplayground.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.world.inventory.PlasmidSynthesiserGUIMenu;
import net.mcreator.geneticplayground.procedures.ProgressUpdaterProcedure;
import net.mcreator.geneticplayground.procedures.BatteryTooltipProcedure;
import net.mcreator.geneticplayground.procedures.BatterySpritesheetProcedureProcedure;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class PlasmidSynthesiserGUIScreen extends AbstractContainerScreen<PlasmidSynthesiserGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public PlasmidSynthesiserGUIScreen(PlasmidSynthesiserGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 196;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("genetic_playground:textures/screens/plasmid_synthesiser_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 13 && mouseX < leftPos + 29 && mouseY > topPos + 31 && mouseY < topPos + 95) {
			String hoverText = BatteryTooltipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 80 && mouseX < leftPos + 95 && mouseY > topPos + 35 && mouseY < topPos + 87) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.plasmid_synthesiser_gui.tooltip_ss3_requires_and_uses_350kfe"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 117 && mouseX < leftPos + 132 && mouseY > topPos + 35 && mouseY < topPos + 87) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.plasmid_synthesiser_gui.tooltip_ss3_requires_and_uses_350kfe1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 95 && mouseX < leftPos + 117 && mouseY > topPos + 72 && mouseY < topPos + 87) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.plasmid_synthesiser_gui.tooltip_ss3_requires_and_uses_350kfe2"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 95 && mouseX < leftPos + 117 && mouseY > topPos + 35 && mouseY < topPos + 51) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.plasmid_synthesiser_gui.tooltip_ss3_requires_and_uses_350kfe3"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 62, this.topPos + 71, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 62, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 62, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 80, this.topPos + 89, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 98, this.topPos + 89, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 116, this.topPos + 89, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 134, this.topPos + 71, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 134, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 134, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 116, this.topPos + 17, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 98, this.topPos + 17, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_1.png"), this.leftPos + 80, this.topPos + 17, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_6.png"), this.leftPos + 98, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_6.png"), this.leftPos + 136, this.topPos + 15, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheet_12.png"), this.leftPos + 13, this.topPos + 31, Mth.clamp((int) BatterySpritesheetProcedureProcedure.execute(world, x, y, z) * 16, 0, 880), 0, 16, 64,
				896, 64);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheetplasmid.png"), this.leftPos + 80, this.topPos + 35, 0, Mth.clamp((int) ProgressUpdaterProcedure.execute(world, x, y, z) * 52, 0, 832), 52, 52, 52, 884);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.plasmid_synthesiser_gui.label_blood_purification_chamber"), 5, 4, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}