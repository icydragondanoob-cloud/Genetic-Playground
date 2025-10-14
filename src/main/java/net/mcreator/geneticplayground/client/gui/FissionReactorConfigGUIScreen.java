package net.mcreator.geneticplayground.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.world.inventory.FissionReactorConfigGUIMenu;
import net.mcreator.geneticplayground.procedures.SpentFuelRedstoneSignalClickedShowProcedure;
import net.mcreator.geneticplayground.procedures.SpentFuelRedstoneSignalClickedHideProcedure;
import net.mcreator.geneticplayground.network.FissionReactorConfigGUIButtonMessage;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class FissionReactorConfigGUIScreen extends AbstractContainerScreen<FissionReactorConfigGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_buttonborder2;

	public FissionReactorConfigGUIScreen(FissionReactorConfigGUIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("genetic_playground:textures/screens/fission_reactor_config_gui.png");

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
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/uyguyguguyguyguyg2.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 200, 166, 200, 166);
		if (SpentFuelRedstoneSignalClickedHideProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/buttonunclicked.png"), this.leftPos + 114, this.topPos + 36, 0, 0, 11, 11, 11, 11);
		}
		if (SpentFuelRedstoneSignalClickedShowProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/buttonclicked.png"), this.leftPos + 114, this.topPos + 36, 0, 0, 11, 11, 11, 11);
		}
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
		imagebutton_buttonborder2 = new ImageButton(this.leftPos + 114, this.topPos + 36, 11, 11,
				new WidgetSprites(ResourceLocation.parse("genetic_playground:textures/screens/buttonborder.png"), ResourceLocation.parse("genetic_playground:textures/screens/buttonborder.png")), e -> {
					int x = FissionReactorConfigGUIScreen.this.x;
					int y = FissionReactorConfigGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FissionReactorConfigGUIButtonMessage(0, x, y, z));
						FissionReactorConfigGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_buttonborder2);
	}
}