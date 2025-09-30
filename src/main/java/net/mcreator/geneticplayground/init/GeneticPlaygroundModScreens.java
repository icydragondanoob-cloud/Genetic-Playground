/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.geneticplayground.client.gui.PlasmidSynthesiserGUIScreen;
import net.mcreator.geneticplayground.client.gui.PlasmidInjectionChamberGUIScreen;
import net.mcreator.geneticplayground.client.gui.FissionPowerPlantGUIScreen;
import net.mcreator.geneticplayground.client.gui.DNAExtractorGUIScreen;
import net.mcreator.geneticplayground.client.gui.CellAnalyzerGUIScreen;
import net.mcreator.geneticplayground.client.gui.BloodPurifierGUIScreen;
import net.mcreator.geneticplayground.client.gui.BloodCentrifugeGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GeneticPlaygroundModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(GeneticPlaygroundModMenus.BLOOD_PURIFIER_GUI.get(), BloodPurifierGUIScreen::new);
		event.register(GeneticPlaygroundModMenus.BLOOD_CENTRIFUGE_GUI.get(), BloodCentrifugeGUIScreen::new);
		event.register(GeneticPlaygroundModMenus.CELL_ANALYZER_GUI.get(), CellAnalyzerGUIScreen::new);
		event.register(GeneticPlaygroundModMenus.DNA_EXTRACTOR_GUI.get(), DNAExtractorGUIScreen::new);
		event.register(GeneticPlaygroundModMenus.PLASMID_SYNTHESISER_GUI.get(), PlasmidSynthesiserGUIScreen::new);
		event.register(GeneticPlaygroundModMenus.PLASMID_INJECTION_CHAMBER_GUI.get(), PlasmidInjectionChamberGUIScreen::new);
		event.register(GeneticPlaygroundModMenus.FISSION_POWER_PLANT_GUI.get(), FissionPowerPlantGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}