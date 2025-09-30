package net.mcreator.geneticplayground.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.world.inventory.FissionPowerPlantGUIMenu;
import net.mcreator.geneticplayground.procedures.BatteryTooltipProcedure;
import net.mcreator.geneticplayground.procedures.BatterySpritesheetProcedureProcedure;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;
import net.mcreator.geneticplayground.block.entity.FissionPowerPlantControllerBlockEntity;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class FissionPowerPlantGUIScreen extends AbstractContainerScreen<FissionPowerPlantGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public FissionPowerPlantGUIScreen(FissionPowerPlantGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 181;
		this.imageHeight = 195;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("genetic_playground:textures/screens/fission_power_plant_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 121 && mouseX < leftPos + 137 && mouseY > topPos + 48 && mouseY < topPos + 112) {
			String hoverText = BatteryTooltipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 146 && mouseX < leftPos + 164 && mouseY > topPos + 92 && mouseY < topPos + 109) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.fission_power_plant_gui.tooltip_radioactive"), mouseX, mouseY);
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
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/fissionreactor4.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 181, 195, 181, 195);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheet_12.png"), this.leftPos + 121, this.topPos + 48, Mth.clamp((int) BatterySpritesheetProcedureProcedure.execute(world, x, y, z) * 16, 0, 880), 0, 16, 64,
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
	}

	@Override
	public void init() {
		super.init();
		this.addFluidWidget();
	}

	public void addFluidWidget() {
		FissionPowerPlantControllerBlockEntity blockEntity = (FissionPowerPlantControllerBlockEntity) this.world.getBlockEntity(BlockPos.containing(x, y, z));
		addRenderableOnly(new net.mcreator.geneticplayground.utils.FluidStackWidget(this, blockEntity.getFluidTank0(), this.leftPos + 147, this.topPos + 26, 16, 64));
		addRenderableOnly(new net.mcreator.geneticplayground.utils.FluidStackWidget(this, blockEntity.getFluidTank1(), this.leftPos + 16, this.topPos + 26, 16, 64));
		addRenderableOnly(new net.mcreator.geneticplayground.utils.FluidStackWidget(this, blockEntity.getFluidTank2(), this.leftPos + 47, this.topPos + 41, 16, 64));
	}
}