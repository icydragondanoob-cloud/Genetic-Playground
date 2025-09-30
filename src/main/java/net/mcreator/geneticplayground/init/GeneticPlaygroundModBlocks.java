/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.geneticplayground.block.WarningSignBlock;
import net.mcreator.geneticplayground.block.SterileBloodBlock;
import net.mcreator.geneticplayground.block.PlasmidSynthesiserBlock;
import net.mcreator.geneticplayground.block.PlasmidInjectionChamberBlock;
import net.mcreator.geneticplayground.block.PlasmaResidueBlock;
import net.mcreator.geneticplayground.block.NetheriteCableBlock;
import net.mcreator.geneticplayground.block.LabWallsBlock;
import net.mcreator.geneticplayground.block.LabWallFacadeBlock;
import net.mcreator.geneticplayground.block.LabTilesBlock;
import net.mcreator.geneticplayground.block.LabFanBlock;
import net.mcreator.geneticplayground.block.LabBrickWallsBlock;
import net.mcreator.geneticplayground.block.LabBrickFacadeBlock;
import net.mcreator.geneticplayground.block.GoldCableBlock;
import net.mcreator.geneticplayground.block.FissionPowerPlantControllerBlock;
import net.mcreator.geneticplayground.block.ElectricPumpBlock;
import net.mcreator.geneticplayground.block.DNAExtractorBlock;
import net.mcreator.geneticplayground.block.CreativeEnergyBlockBlock;
import net.mcreator.geneticplayground.block.CrackedLabWallBlock;
import net.mcreator.geneticplayground.block.CopperPipingBlock;
import net.mcreator.geneticplayground.block.CellAnalyzerBlock;
import net.mcreator.geneticplayground.block.BorderlessLabWallsBlock;
import net.mcreator.geneticplayground.block.BloodPurifierBlock;
import net.mcreator.geneticplayground.block.BloodCentrifugeBlock;
import net.mcreator.geneticplayground.block.BiohazardSignBlock;
import net.mcreator.geneticplayground.block.AluminiumCableBlock;
import net.mcreator.geneticplayground.block.AluminiumBlockBlock;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

public class GeneticPlaygroundModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(GeneticPlaygroundMod.MODID);
	public static final DeferredBlock<Block> BLOOD_PURIFIER = REGISTRY.register("blood_purifier", BloodPurifierBlock::new);
	public static final DeferredBlock<Block> PLASMA_RESIDUE = REGISTRY.register("plasma_residue", PlasmaResidueBlock::new);
	public static final DeferredBlock<Block> STERILE_BLOOD = REGISTRY.register("sterile_blood", SterileBloodBlock::new);
	public static final DeferredBlock<Block> BLOOD_CENTRIFUGE = REGISTRY.register("blood_centrifuge", BloodCentrifugeBlock::new);
	public static final DeferredBlock<Block> CREATIVE_ENERGY_BLOCK = REGISTRY.register("creative_energy_block", CreativeEnergyBlockBlock::new);
	public static final DeferredBlock<Block> CELL_ANALYZER = REGISTRY.register("cell_analyzer", CellAnalyzerBlock::new);
	public static final DeferredBlock<Block> DNA_EXTRACTOR = REGISTRY.register("dna_extractor", DNAExtractorBlock::new);
	public static final DeferredBlock<Block> PLASMID_SYNTHESISER = REGISTRY.register("plasmid_synthesiser", PlasmidSynthesiserBlock::new);
	public static final DeferredBlock<Block> LAB_BRICK_WALLS = REGISTRY.register("lab_brick_walls", LabBrickWallsBlock::new);
	public static final DeferredBlock<Block> LAB_WALLS = REGISTRY.register("lab_walls", LabWallsBlock::new);
	public static final DeferredBlock<Block> BORDERLESS_LAB_WALLS = REGISTRY.register("borderless_lab_walls", BorderlessLabWallsBlock::new);
	public static final DeferredBlock<Block> LAB_BRICK_FACADE = REGISTRY.register("lab_brick_facade", LabBrickFacadeBlock::new);
	public static final DeferredBlock<Block> LAB_WALL_FACADE = REGISTRY.register("lab_wall_facade", LabWallFacadeBlock::new);
	public static final DeferredBlock<Block> PLASMID_INJECTION_CHAMBER = REGISTRY.register("plasmid_injection_chamber", PlasmidInjectionChamberBlock::new);
	public static final DeferredBlock<Block> ALUMINIUM_BLOCK = REGISTRY.register("aluminium_block", AluminiumBlockBlock::new);
	public static final DeferredBlock<Block> LAB_FAN = REGISTRY.register("lab_fan", LabFanBlock::new);
	public static final DeferredBlock<Block> LAB_TILES = REGISTRY.register("lab_tiles", LabTilesBlock::new);
	public static final DeferredBlock<Block> CRACKED_LAB_WALL = REGISTRY.register("cracked_lab_wall", CrackedLabWallBlock::new);
	public static final DeferredBlock<Block> WARNING_SIGN = REGISTRY.register("warning_sign", WarningSignBlock::new);
	public static final DeferredBlock<Block> BIOHAZARD_SIGN = REGISTRY.register("biohazard_sign", BiohazardSignBlock::new);
	public static final DeferredBlock<Block> FISSION_POWER_PLANT_CONTROLLER = REGISTRY.register("fission_power_plant_controller", FissionPowerPlantControllerBlock::new);
	public static final DeferredBlock<Block> COPPER_PIPING = REGISTRY.register("copper_piping", CopperPipingBlock::new);
	public static final DeferredBlock<Block> GOLD_CABLE = REGISTRY.register("gold_cable", GoldCableBlock::new);
	public static final DeferredBlock<Block> ALUMINIUM_CABLE = REGISTRY.register("aluminium_cable", AluminiumCableBlock::new);
	public static final DeferredBlock<Block> NETHERITE_CABLE = REGISTRY.register("netherite_cable", NetheriteCableBlock::new);
	public static final DeferredBlock<Block> ELECTRIC_PUMP = REGISTRY.register("electric_pump", ElectricPumpBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}