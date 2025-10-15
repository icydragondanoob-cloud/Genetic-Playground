/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.geneticplayground.block.WarningSignBlock;
import net.mcreator.geneticplayground.block.UnknownBlockBlock;
import net.mcreator.geneticplayground.block.ThermalTurbineBlock;
import net.mcreator.geneticplayground.block.SuperFrozenIceBlock;
import net.mcreator.geneticplayground.block.StrobeLightBlock;
import net.mcreator.geneticplayground.block.StoneLeadOreBlock;
import net.mcreator.geneticplayground.block.StoneBauxiteOreBlock;
import net.mcreator.geneticplayground.block.SterileBloodBlock;
import net.mcreator.geneticplayground.block.SolarPanelBlock;
import net.mcreator.geneticplayground.block.SirenBlock;
import net.mcreator.geneticplayground.block.PlasmidSynthesiserBlock;
import net.mcreator.geneticplayground.block.PlasmidInjectionChamberBlock;
import net.mcreator.geneticplayground.block.PlasmaResidueBlock;
import net.mcreator.geneticplayground.block.NetheriteCableBlock;
import net.mcreator.geneticplayground.block.NetherUraniumOreBlock;
import net.mcreator.geneticplayground.block.LeadBlockBlock;
import net.mcreator.geneticplayground.block.LabWallsBlock;
import net.mcreator.geneticplayground.block.LabWallFacadeBlock;
import net.mcreator.geneticplayground.block.LabTilesBlock;
import net.mcreator.geneticplayground.block.LabLightBlock;
import net.mcreator.geneticplayground.block.LabFanBlock;
import net.mcreator.geneticplayground.block.LabBrickWallsBlock;
import net.mcreator.geneticplayground.block.LabBrickFacadeBlock;
import net.mcreator.geneticplayground.block.HeatGeneratorBlock;
import net.mcreator.geneticplayground.block.GoldCableBlock;
import net.mcreator.geneticplayground.block.FissionPowerPlantControllerBlock;
import net.mcreator.geneticplayground.block.DeepslateLeadOreBlock;
import net.mcreator.geneticplayground.block.DeepslateBauxiteOreBlock;
import net.mcreator.geneticplayground.block.DNAExtractorBlock;
import net.mcreator.geneticplayground.block.CreativeEnergyBlockBlock;
import net.mcreator.geneticplayground.block.CrackedLabWallBlock;
import net.mcreator.geneticplayground.block.CellAnalyzerBlock;
import net.mcreator.geneticplayground.block.BorderlessLabWallsBlock;
import net.mcreator.geneticplayground.block.BloodPurifierBlock;
import net.mcreator.geneticplayground.block.BloodCentrifugeBlock;
import net.mcreator.geneticplayground.block.BiohazardSignBlock;
import net.mcreator.geneticplayground.block.AluminiumCableBlock;
import net.mcreator.geneticplayground.block.AluminiumBlockBlock;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

import java.util.function.Function;

public class GeneticPlaygroundModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(GeneticPlaygroundMod.MODID);
	public static final DeferredBlock<Block> BLOOD_PURIFIER = register("blood_purifier", BloodPurifierBlock::new);
	public static final DeferredBlock<Block> PLASMA_RESIDUE = register("plasma_residue", PlasmaResidueBlock::new);
	public static final DeferredBlock<Block> STERILE_BLOOD = register("sterile_blood", SterileBloodBlock::new);
	public static final DeferredBlock<Block> BLOOD_CENTRIFUGE = register("blood_centrifuge", BloodCentrifugeBlock::new);
	public static final DeferredBlock<Block> CREATIVE_ENERGY_BLOCK = register("creative_energy_block", CreativeEnergyBlockBlock::new);
	public static final DeferredBlock<Block> CELL_ANALYZER = register("cell_analyzer", CellAnalyzerBlock::new);
	public static final DeferredBlock<Block> DNA_EXTRACTOR = register("dna_extractor", DNAExtractorBlock::new);
	public static final DeferredBlock<Block> PLASMID_SYNTHESISER = register("plasmid_synthesiser", PlasmidSynthesiserBlock::new);
	public static final DeferredBlock<Block> LAB_BRICK_WALLS = register("lab_brick_walls", LabBrickWallsBlock::new);
	public static final DeferredBlock<Block> LAB_WALLS = register("lab_walls", LabWallsBlock::new);
	public static final DeferredBlock<Block> BORDERLESS_LAB_WALLS = register("borderless_lab_walls", BorderlessLabWallsBlock::new);
	public static final DeferredBlock<Block> LAB_BRICK_FACADE = register("lab_brick_facade", LabBrickFacadeBlock::new);
	public static final DeferredBlock<Block> LAB_WALL_FACADE = register("lab_wall_facade", LabWallFacadeBlock::new);
	public static final DeferredBlock<Block> PLASMID_INJECTION_CHAMBER = register("plasmid_injection_chamber", PlasmidInjectionChamberBlock::new);
	public static final DeferredBlock<Block> ALUMINIUM_BLOCK = register("aluminium_block", AluminiumBlockBlock::new);
	public static final DeferredBlock<Block> LAB_FAN = register("lab_fan", LabFanBlock::new);
	public static final DeferredBlock<Block> LAB_TILES = register("lab_tiles", LabTilesBlock::new);
	public static final DeferredBlock<Block> CRACKED_LAB_WALL = register("cracked_lab_wall", CrackedLabWallBlock::new);
	public static final DeferredBlock<Block> WARNING_SIGN = register("warning_sign", WarningSignBlock::new);
	public static final DeferredBlock<Block> BIOHAZARD_SIGN = register("biohazard_sign", BiohazardSignBlock::new);
	public static final DeferredBlock<Block> FISSION_POWER_PLANT_CONTROLLER = register("fission_power_plant_controller", FissionPowerPlantControllerBlock::new);
	public static final DeferredBlock<Block> GOLD_CABLE = register("gold_cable", GoldCableBlock::new);
	public static final DeferredBlock<Block> ALUMINIUM_CABLE = register("aluminium_cable", AluminiumCableBlock::new);
	public static final DeferredBlock<Block> NETHERITE_CABLE = register("netherite_cable", NetheriteCableBlock::new);
	public static final DeferredBlock<Block> NETHER_URANIUM_ORE = register("nether_uranium_ore", NetherUraniumOreBlock::new);
	public static final DeferredBlock<Block> THERMAL_TURBINE = register("thermal_turbine", ThermalTurbineBlock::new);
	public static final DeferredBlock<Block> UNKNOWN_BLOCK = register("unknown_block", UnknownBlockBlock::new);
	public static final DeferredBlock<Block> SUPER_FROZEN_ICE = register("super_frozen_ice", SuperFrozenIceBlock::new);
	public static final DeferredBlock<Block> LEAD_BLOCK = register("lead_block", LeadBlockBlock::new);
	public static final DeferredBlock<Block> STROBE_LIGHT = register("strobe_light", StrobeLightBlock::new);
	public static final DeferredBlock<Block> SIREN = register("siren", SirenBlock::new);
	public static final DeferredBlock<Block> LAB_LIGHT = register("lab_light", LabLightBlock::new);
	public static final DeferredBlock<Block> STONE_BAUXITE_ORE = register("stone_bauxite_ore", StoneBauxiteOreBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_BAUXITE_ORE = register("deepslate_bauxite_ore", DeepslateBauxiteOreBlock::new);
	public static final DeferredBlock<Block> STONE_LEAD_ORE = register("stone_lead_ore", StoneLeadOreBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", DeepslateLeadOreBlock::new);
	public static final DeferredBlock<Block> SOLAR_PANEL = register("solar_panel", SolarPanelBlock::new);
	public static final DeferredBlock<Block> HEAT_GENERATOR = register("heat_generator", HeatGeneratorBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}