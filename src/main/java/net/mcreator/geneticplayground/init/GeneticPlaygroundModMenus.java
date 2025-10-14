/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.geneticplayground.world.inventory.ThermalTurbineGUIMenu;
import net.mcreator.geneticplayground.world.inventory.PlasmidSynthesiserGUIMenu;
import net.mcreator.geneticplayground.world.inventory.PlasmidInjectionChamberGUIMenu;
import net.mcreator.geneticplayground.world.inventory.HeatGeneratorGUIMenu;
import net.mcreator.geneticplayground.world.inventory.FissionReactorConfigGUIMenu;
import net.mcreator.geneticplayground.world.inventory.FissionPowerPlantGUIMenu;
import net.mcreator.geneticplayground.world.inventory.DNAExtractorGUIMenu;
import net.mcreator.geneticplayground.world.inventory.CellAnalyzerGUIMenu;
import net.mcreator.geneticplayground.world.inventory.BloodPurifierGUIMenu;
import net.mcreator.geneticplayground.world.inventory.BloodCentrifugeGUIMenu;
import net.mcreator.geneticplayground.network.MenuStateUpdateMessage;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

import java.util.Map;

public class GeneticPlaygroundModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<BloodPurifierGUIMenu>> BLOOD_PURIFIER_GUI = REGISTRY.register("blood_purifier_gui", () -> IMenuTypeExtension.create(BloodPurifierGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BloodCentrifugeGUIMenu>> BLOOD_CENTRIFUGE_GUI = REGISTRY.register("blood_centrifuge_gui", () -> IMenuTypeExtension.create(BloodCentrifugeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CellAnalyzerGUIMenu>> CELL_ANALYZER_GUI = REGISTRY.register("cell_analyzer_gui", () -> IMenuTypeExtension.create(CellAnalyzerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DNAExtractorGUIMenu>> DNA_EXTRACTOR_GUI = REGISTRY.register("dna_extractor_gui", () -> IMenuTypeExtension.create(DNAExtractorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PlasmidSynthesiserGUIMenu>> PLASMID_SYNTHESISER_GUI = REGISTRY.register("plasmid_synthesiser_gui", () -> IMenuTypeExtension.create(PlasmidSynthesiserGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PlasmidInjectionChamberGUIMenu>> PLASMID_INJECTION_CHAMBER_GUI = REGISTRY.register("plasmid_injection_chamber_gui", () -> IMenuTypeExtension.create(PlasmidInjectionChamberGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FissionPowerPlantGUIMenu>> FISSION_POWER_PLANT_GUI = REGISTRY.register("fission_power_plant_gui", () -> IMenuTypeExtension.create(FissionPowerPlantGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ThermalTurbineGUIMenu>> THERMAL_TURBINE_GUI = REGISTRY.register("thermal_turbine_gui", () -> IMenuTypeExtension.create(ThermalTurbineGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FissionReactorConfigGUIMenu>> FISSION_REACTOR_CONFIG_GUI = REGISTRY.register("fission_reactor_config_gui", () -> IMenuTypeExtension.create(FissionReactorConfigGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeatGeneratorGUIMenu>> HEAT_GENERATOR_GUI = REGISTRY.register("heat_generator_gui", () -> IMenuTypeExtension.create(HeatGeneratorGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof GeneticPlaygroundModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}