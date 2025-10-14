package net.mcreator.geneticplayground.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.geneticplayground.world.inventory.FissionPowerPlantGUIMenu;
import net.mcreator.geneticplayground.procedures.SCRAMTooltipProcedure;
import net.mcreator.geneticplayground.procedures.OhUTooltipProcedure;
import net.mcreator.geneticplayground.procedures.OhUSpritesheetProcedureProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipWATERProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipUNKOWNProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipSNOWProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipPACKEDICEProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipICEProcedure;
import net.mcreator.geneticplayground.procedures.OcUTooltipBLUEICEProcedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltipProcedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip9Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip8Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip7Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip6Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip5Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip4Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip3Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip2Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip1Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip14Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip13Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip12Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip11Procedure;
import net.mcreator.geneticplayground.procedures.FuelRodSlotTooltip10Procedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantWaterProcedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantUnkownProcedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantSnowProcedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantPackedIceProcedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantNoneProcedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantIceProcedure;
import net.mcreator.geneticplayground.procedures.FissionPowerCoolantBlueIceProcedure;
import net.mcreator.geneticplayground.network.FissionPowerPlantGUIButtonMessage;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class FissionPowerPlantGUIScreen extends AbstractContainerScreen<FissionPowerPlantGUIMenu> implements GeneticPlaygroundModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_scrambutton;
	ImageButton imagebutton_fissionreactorconfig;

	public FissionPowerPlantGUIScreen(FissionPowerPlantGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 208;
		this.imageHeight = 202;
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
		if (mouseX > leftPos + 173 && mouseX < leftPos + 189 && mouseY > topPos + 38 && mouseY < topPos + 102) {
			String hoverText = OhUTooltipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 51 && mouseX < leftPos + 71 && mouseY > topPos + 43 && mouseY < topPos + 63) {
			String hoverText = FuelRodSlotTooltipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 72 && mouseX < leftPos + 92 && mouseY > topPos + 43 && mouseY < topPos + 63) {
			String hoverText = FuelRodSlotTooltip1Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 94 && mouseX < leftPos + 114 && mouseY > topPos + 43 && mouseY < topPos + 63) {
			String hoverText = FuelRodSlotTooltip2Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 116 && mouseX < leftPos + 136 && mouseY > topPos + 43 && mouseY < topPos + 63) {
			String hoverText = FuelRodSlotTooltip3Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 137 && mouseX < leftPos + 157 && mouseY > topPos + 43 && mouseY < topPos + 63) {
			String hoverText = FuelRodSlotTooltip4Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 51 && mouseX < leftPos + 71 && mouseY > topPos + 71 && mouseY < topPos + 91) {
			String hoverText = FuelRodSlotTooltip5Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 72 && mouseX < leftPos + 92 && mouseY > topPos + 71 && mouseY < topPos + 91) {
			String hoverText = FuelRodSlotTooltip6Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 94 && mouseX < leftPos + 114 && mouseY > topPos + 71 && mouseY < topPos + 91) {
			String hoverText = FuelRodSlotTooltip7Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 116 && mouseX < leftPos + 136 && mouseY > topPos + 71 && mouseY < topPos + 91) {
			String hoverText = FuelRodSlotTooltip8Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 137 && mouseX < leftPos + 156 && mouseY > topPos + 71 && mouseY < topPos + 91) {
			String hoverText = FuelRodSlotTooltip9Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 51 && mouseX < leftPos + 71 && mouseY > topPos + 98 && mouseY < topPos + 118) {
			String hoverText = FuelRodSlotTooltip10Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 72 && mouseX < leftPos + 92 && mouseY > topPos + 98 && mouseY < topPos + 118) {
			String hoverText = FuelRodSlotTooltip11Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 94 && mouseX < leftPos + 114 && mouseY > topPos + 98 && mouseY < topPos + 118) {
			String hoverText = FuelRodSlotTooltip12Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 116 && mouseX < leftPos + 136 && mouseY > topPos + 98 && mouseY < topPos + 118) {
			String hoverText = FuelRodSlotTooltip13Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 137 && mouseX < leftPos + 158 && mouseY > topPos + 98 && mouseY < topPos + 118) {
			String hoverText = FuelRodSlotTooltip14Procedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (FissionPowerCoolantNoneProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 5 && mouseX < leftPos + 49 && mouseY > topPos + 34 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FissionPowerCoolantWaterProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 6 && mouseX < leftPos + 48 && mouseY > topPos + 35 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipWATERProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FissionPowerCoolantSnowProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 6 && mouseX < leftPos + 48 && mouseY > topPos + 35 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipSNOWProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FissionPowerCoolantIceProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 6 && mouseX < leftPos + 48 && mouseY > topPos + 35 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipICEProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FissionPowerCoolantPackedIceProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 7 && mouseX < leftPos + 47 && mouseY > topPos + 36 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipPACKEDICEProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FissionPowerCoolantBlueIceProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 6 && mouseX < leftPos + 48 && mouseY > topPos + 35 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipBLUEICEProcedure.execute();
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (mouseX > leftPos + 7 && mouseX < leftPos + 38 && mouseY > topPos + 135 && mouseY < topPos + 148) {
			String hoverText = SCRAMTooltipProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (FissionPowerCoolantUnkownProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 6 && mouseX < leftPos + 47 && mouseY > topPos + 35 && mouseY < topPos + 99) {
				String hoverText = OcUTooltipUNKOWNProcedure.execute();
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
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/fissionreactorblockgui2.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 208, 202, 208, 202);
		if (FissionPowerCoolantNoneProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantnone.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		if (FissionPowerCoolantWaterProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantwater.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		if (FissionPowerCoolantSnowProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantsnow.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		if (FissionPowerCoolantIceProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantice.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		if (FissionPowerCoolantPackedIceProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantpackedice.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		if (FissionPowerCoolantBlueIceProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantblueice.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/blocke.png"), this.leftPos + 6, this.topPos + 98, 0, 0, 42, 20, 42, 20);
		if (FissionPowerCoolantUnkownProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/coolantunkown.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 42, 83, 42, 83);
		}
		guiGraphics.blit(ResourceLocation.parse("genetic_playground:textures/screens/spritesheet_12_1.png"), this.leftPos + 173, this.topPos + 38, 0, Mth.clamp((int) OhUSpritesheetProcedureProcedure.execute(world, x, y, z) * 64, 0, 3840), 16, 64, 16,
				3904);
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
		imagebutton_scrambutton = new ImageButton(this.leftPos + 7, this.topPos + 135, 31, 13,
				new WidgetSprites(ResourceLocation.parse("genetic_playground:textures/screens/scrambutton.png"), ResourceLocation.parse("genetic_playground:textures/screens/scrambuttonselection.png")), e -> {
					int x = FissionPowerPlantGUIScreen.this.x;
					int y = FissionPowerPlantGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FissionPowerPlantGUIButtonMessage(0, x, y, z));
						FissionPowerPlantGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_scrambutton);
		imagebutton_fissionreactorconfig = new ImageButton(this.leftPos + 7, this.topPos + 149, 31, 13,
				new WidgetSprites(ResourceLocation.parse("genetic_playground:textures/screens/fissionreactorconfig.png"), ResourceLocation.parse("genetic_playground:textures/screens/fissionreactorconfigselected.png")), e -> {
					int x = FissionPowerPlantGUIScreen.this.x;
					int y = FissionPowerPlantGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FissionPowerPlantGUIButtonMessage(1, x, y, z));
						FissionPowerPlantGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_fissionreactorconfig);
	}
}