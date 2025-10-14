package net.mcreator.geneticplayground.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.world.inventory.ThermalTurbineGUIMenu;
import net.mcreator.geneticplayground.procedures.GetOOhUperTickOfBlockProcedure;
import net.mcreator.geneticplayground.procedures.GetOOhUOfBlockProcedure;
import net.mcreator.geneticplayground.procedures.BatteryTooltipProcedure;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ThermalTurbineGUIScreen extends AbstractContainerScreen<ThermalTurbineGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public ThermalTurbineGUIScreen(ThermalTurbineGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("genetic_playground:textures/screens/thermal_turbine_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/ih.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 200, 166, 200, 166);
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
		guiGraphics.drawString(this.font, BatteryTooltipProcedure.execute(world, x, y, z), 14, 97, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.thermal_turbine_gui.label_1_ophu_100_fe"), 14, 132, -1, false);
		guiGraphics.drawString(this.font, GetOOhUOfBlockProcedure.execute(world, x, y, z), 14, 31, -1, false);
		guiGraphics.drawString(this.font, GetOOhUperTickOfBlockProcedure.execute(world, x, y, z), 14, 65, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}