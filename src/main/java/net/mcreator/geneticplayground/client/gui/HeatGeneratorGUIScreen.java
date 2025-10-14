package net.mcreator.geneticplayground.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.world.inventory.HeatGeneratorGUIMenu;
import net.mcreator.geneticplayground.procedures.LavaZplusoneProcedure;
import net.mcreator.geneticplayground.procedures.LavaZminusoneProcedure;
import net.mcreator.geneticplayground.procedures.LavaYplusoneProcedure;
import net.mcreator.geneticplayground.procedures.LavaYminusoneProcedure;
import net.mcreator.geneticplayground.procedures.LavaXplusoneProcedure;
import net.mcreator.geneticplayground.procedures.LavaXminusoneProcedure;
import net.mcreator.geneticplayground.procedures.HeatGeneratorLavaTooltipProcedure;
import net.mcreator.geneticplayground.procedures.FEperTickProcedure;
import net.mcreator.geneticplayground.procedures.BatteryTooltipProcedure;
import net.mcreator.geneticplayground.procedures.BatterySpritesheetProcedureProcedure;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class HeatGeneratorGUIScreen extends AbstractContainerScreen<HeatGeneratorGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public HeatGeneratorGUIScreen(HeatGeneratorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("genetic_playground:textures/screens/heat_generator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 148 && mouseX < leftPos + 168 && mouseY > topPos + 42 && mouseY < topPos + 113) {
			String hoverText = BatteryTooltipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (LavaZminusoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 69 && mouseX < leftPos + 103 && mouseY > topPos + 123 && mouseY < topPos + 158) {
				String hoverText = HeatGeneratorLavaTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (LavaZplusoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 70 && mouseX < leftPos + 103 && mouseY > topPos + 51 && mouseY < topPos + 86) {
				String hoverText = HeatGeneratorLavaTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (LavaXminusoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 36 && mouseX < leftPos + 69 && mouseY > topPos + 87 && mouseY < topPos + 121) {
				String hoverText = HeatGeneratorLavaTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (LavaXplusoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 104 && mouseX < leftPos + 137 && mouseY > topPos + 87 && mouseY < topPos + 122) {
				String hoverText = HeatGeneratorLavaTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (LavaYminusoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 36 && mouseX < leftPos + 69 && mouseY > topPos + 123 && mouseY < topPos + 158) {
				String hoverText = HeatGeneratorLavaTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (LavaYplusoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 104 && mouseX < leftPos + 137 && mouseY > topPos + 51 && mouseY < topPos + 86) {
				String hoverText = HeatGeneratorLavaTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
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
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/heatgenguipart.png"), this.leftPos + 36, this.topPos + 51, 0, 0, 101, 107, 101, 107);
		if (LavaXplusoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/lavaheatgencoolio.png"), this.leftPos + 105, this.topPos + 88, 0, 0, 31, 33, 31, 33);
		}
		if (LavaXminusoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/lavaheatgencoolio.png"), this.leftPos + 37, this.topPos + 88, 0, 0, 31, 33, 31, 33);
		}
		if (LavaZplusoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/lavaheatgencoolio.png"), this.leftPos + 71, this.topPos + 52, 0, 0, 31, 33, 31, 33);
		}
		if (LavaZminusoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/lavaheatgencoolio.png"), this.leftPos + 71, this.topPos + 124, 0, 0, 31, 33, 31, 33);
		}
		if (LavaYplusoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/lavaheatgencoolio.png"), this.leftPos + 105, this.topPos + 52, 0, 0, 31, 33, 31, 33);
		}
		if (LavaYminusoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/lavaheatgencoolio.png"), this.leftPos + 37, this.topPos + 124, 0, 0, 31, 33, 31, 33);
		}
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheet_12.png"), this.leftPos + 150, this.topPos + 47, Mth.clamp((int) BatterySpritesheetProcedureProcedure.execute(world, x, y, z) * 16, 0, 880), 0, 16, 64,
				896, 64);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.heat_generator_gui.label_heat_generator"), 6, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.heat_generator_gui.label_place_lava_around_heat_generator"), 20, 17, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.heat_generator_gui.label_generator_to_produce_fe"), 21, 26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.heat_generator_gui.label_fet"), 5, 39, -12829636, false);
		guiGraphics.drawString(this.font, FEperTickProcedure.execute(world, x, y, z), 33, 39, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}