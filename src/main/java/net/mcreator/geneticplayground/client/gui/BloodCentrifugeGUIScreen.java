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

import net.mcreator.geneticplayground.world.inventory.BloodCentrifugeGUIMenu;
import net.mcreator.geneticplayground.procedures.ProgressUpdaterProcedure;
import net.mcreator.geneticplayground.procedures.BatteryTooltipProcedure;
import net.mcreator.geneticplayground.procedures.BatterySpritesheetProcedureProcedure;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;
import net.mcreator.geneticplayground.block.entity.BloodCentrifugeBlockEntity;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class BloodCentrifugeGUIScreen extends AbstractContainerScreen<BloodCentrifugeGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public BloodCentrifugeGUIScreen(BloodCentrifugeGUIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("genetic_playground:textures/screens/blood_centrifuge_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 8 && mouseX < leftPos + 24 && mouseY > topPos + 16 && mouseY < topPos + 80) {
			String hoverText = BatteryTooltipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 24 && mouseX < leftPos + 42 && mouseY > topPos + 62 && mouseY < topPos + 79) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.blood_centrifuge_gui.tooltip_machine_speed_upgrade"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 73 && mouseX < leftPos + 95 && mouseY > topPos + 42 && mouseY < topPos + 57) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.genetic_playground.blood_centrifuge_gui.tooltip_ss3_requires_and_uses_40_kfe"), mouseX, mouseY);
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
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/bucket_je2_be2-1.png-1.png_3.png"), this.leftPos + 25, this.topPos + 63, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/syringe-1.png_4.png"), this.leftPos + 53, this.topPos + 41, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/syringe-1.png_4.png"), this.leftPos + 100, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/new_piskel-1.png_75.png"), this.leftPos + 151, this.topPos + 14, 0, 0, 18, 66, 18, 66);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheet_12.png"), this.leftPos + 8, this.topPos + 16, Mth.clamp((int) BatterySpritesheetProcedureProcedure.execute(world, x, y, z) * 16, 0, 880), 0, 16, 64, 896,
				64);
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheet_3.png"), this.leftPos + 72, this.topPos + 41, Mth.clamp((int) ProgressUpdaterProcedure.execute(world, x, y, z) * 24, 0, 504), 0, 24, 16, 528, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.genetic_playground.blood_centrifuge_gui.label_blood_purification_chamber"), 5, 4, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		this.addFluidWidget();
	}

	public void addFluidWidget() {
		BloodCentrifugeBlockEntity blockEntity = (BloodCentrifugeBlockEntity) this.world.getBlockEntity(BlockPos.containing(x, y, z));
		addRenderableOnly(new net.mcreator.geneticplayground.utils.FluidStackWidget(this, blockEntity.getFluidTank0(), this.leftPos + 152, this.topPos + 15, 16, 64));
	}
}