/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.geneticplayground.item.WoolyPlasmidItem;
import net.mcreator.geneticplayground.item.WaterSpeedPlasmidItem;
import net.mcreator.geneticplayground.item.WaterBreathingPlasmidItem;
import net.mcreator.geneticplayground.item.TeleporationPlasmidItem;
import net.mcreator.geneticplayground.item.SyringeOfSterileBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfSheepBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfSalmonBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfRabbitBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfPigBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfMuleBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfHorseBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfEndermanEnderfluidItem;
import net.mcreator.geneticplayground.item.SyringeOfDonkeyBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfCowBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfCodBloodItem;
import net.mcreator.geneticplayground.item.SyringeOfChickenBloodItem;
import net.mcreator.geneticplayground.item.SyringeItem;
import net.mcreator.geneticplayground.item.SterileBloodItem;
import net.mcreator.geneticplayground.item.SheepCellItem;
import net.mcreator.geneticplayground.item.SalmonCellItem;
import net.mcreator.geneticplayground.item.RabbitCellItem;
import net.mcreator.geneticplayground.item.PlasmaResidueItem;
import net.mcreator.geneticplayground.item.PigCellItem;
import net.mcreator.geneticplayground.item.MuleCellItem;
import net.mcreator.geneticplayground.item.MovementSpeedPlasmidItem;
import net.mcreator.geneticplayground.item.MilkablePlasmidItem;
import net.mcreator.geneticplayground.item.MaxHealthPlasmidItem;
import net.mcreator.geneticplayground.item.MachineSpeedUpgradeItem;
import net.mcreator.geneticplayground.item.HydrophobiaPlasmidItem;
import net.mcreator.geneticplayground.item.HydrophobiaDoubleHelixItem;
import net.mcreator.geneticplayground.item.HorseCellItem;
import net.mcreator.geneticplayground.item.HigherJumpPlasmidItem;
import net.mcreator.geneticplayground.item.GrazingPlasmidItem;
import net.mcreator.geneticplayground.item.EndersightPlasmidItem;
import net.mcreator.geneticplayground.item.EndermanCellItem;
import net.mcreator.geneticplayground.item.EmptyPlasmidItem;
import net.mcreator.geneticplayground.item.EggPlasmidItem;
import net.mcreator.geneticplayground.item.DoubleHelixWoolyItem;
import net.mcreator.geneticplayground.item.DoubleHelixWaterSpeedItem;
import net.mcreator.geneticplayground.item.DoubleHelixWaterBreathingItem;
import net.mcreator.geneticplayground.item.DoubleHelixTeleporationItem;
import net.mcreator.geneticplayground.item.DoubleHelixMovementSpeedItem;
import net.mcreator.geneticplayground.item.DoubleHelixMilkableItem;
import net.mcreator.geneticplayground.item.DoubleHelixMaxHealthItem;
import net.mcreator.geneticplayground.item.DoubleHelixHigherJumpItem;
import net.mcreator.geneticplayground.item.DoubleHelixGrazingItem;
import net.mcreator.geneticplayground.item.DoubleHelixFailedItem;
import net.mcreator.geneticplayground.item.DoubleHelixEndersightItem;
import net.mcreator.geneticplayground.item.DoubleHelixEggItem;
import net.mcreator.geneticplayground.item.DonkeyCellItem;
import net.mcreator.geneticplayground.item.CowCellItem;
import net.mcreator.geneticplayground.item.CodCellItem;
import net.mcreator.geneticplayground.item.ChickenCellItem;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

public class GeneticPlaygroundModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(GeneticPlaygroundMod.MODID);
	public static final DeferredItem<Item> SYRINGE = REGISTRY.register("syringe", SyringeItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_PIG_BLOOD = REGISTRY.register("syringe_of_pig_blood", SyringeOfPigBloodItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_COW_BLOOD = REGISTRY.register("syringe_of_cow_blood", SyringeOfCowBloodItem::new);
	public static final DeferredItem<Item> BLOOD_PURIFIER = block(GeneticPlaygroundModBlocks.BLOOD_PURIFIER);
	public static final DeferredItem<Item> PLASMA_RESIDUE_BUCKET = REGISTRY.register("plasma_residue_bucket", PlasmaResidueItem::new);
	public static final DeferredItem<Item> MACHINE_SPEED_UPGRADE = REGISTRY.register("machine_speed_upgrade", MachineSpeedUpgradeItem::new);
	public static final DeferredItem<Item> PIG_CELL = REGISTRY.register("pig_cell", PigCellItem::new);
	public static final DeferredItem<Item> COW_CELL = REGISTRY.register("cow_cell", CowCellItem::new);
	public static final DeferredItem<Item> STERILE_BLOOD_BUCKET = REGISTRY.register("sterile_blood_bucket", SterileBloodItem::new);
	public static final DeferredItem<Item> BLOOD_CENTRIFUGE = block(GeneticPlaygroundModBlocks.BLOOD_CENTRIFUGE);
	public static final DeferredItem<Item> CREATIVE_ENERGY_BLOCK = block(GeneticPlaygroundModBlocks.CREATIVE_ENERGY_BLOCK);
	public static final DeferredItem<Item> CELL_ANALYZER = block(GeneticPlaygroundModBlocks.CELL_ANALYZER);
	public static final DeferredItem<Item> DNA_EXTRACTOR = block(GeneticPlaygroundModBlocks.DNA_EXTRACTOR);
	public static final DeferredItem<Item> DOUBLE_HELIX_MOVEMENT_SPEED = REGISTRY.register("double_helix_movement_speed", DoubleHelixMovementSpeedItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_MILKABLE = REGISTRY.register("double_helix_milkable", DoubleHelixMilkableItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_MAX_HEALTH = REGISTRY.register("double_helix_max_health", DoubleHelixMaxHealthItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_GRAZING = REGISTRY.register("double_helix_grazing", DoubleHelixGrazingItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_FAILED = REGISTRY.register("double_helix_failed", DoubleHelixFailedItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_STERILE_BLOOD = REGISTRY.register("syringe_of_sterile_blood", SyringeOfSterileBloodItem::new);
	public static final DeferredItem<Item> PLASMID_SYNTHESISER = block(GeneticPlaygroundModBlocks.PLASMID_SYNTHESISER);
	public static final DeferredItem<Item> EMPTY_PLASMID = REGISTRY.register("empty_plasmid", EmptyPlasmidItem::new);
	public static final DeferredItem<Item> MOVEMENT_SPEED_PLASMID = REGISTRY.register("movement_speed_plasmid", MovementSpeedPlasmidItem::new);
	public static final DeferredItem<Item> CULTIVATED_CREEPER_SPAWN_EGG = REGISTRY.register("cultivated_creeper_spawn_egg", () -> new DeferredSpawnEggItem(GeneticPlaygroundModEntities.CULTIVATED_CREEPER, -13395712, -16737946, new Item.Properties()));
	public static final DeferredItem<Item> LAB_BRICK_WALLS = block(GeneticPlaygroundModBlocks.LAB_BRICK_WALLS);
	public static final DeferredItem<Item> LAB_WALLS = block(GeneticPlaygroundModBlocks.LAB_WALLS);
	public static final DeferredItem<Item> BORDERLESS_LAB_WALLS = block(GeneticPlaygroundModBlocks.BORDERLESS_LAB_WALLS);
	public static final DeferredItem<Item> LAB_BRICK_FACADE = block(GeneticPlaygroundModBlocks.LAB_BRICK_FACADE);
	public static final DeferredItem<Item> LAB_WALL_FACADE = block(GeneticPlaygroundModBlocks.LAB_WALL_FACADE);
	public static final DeferredItem<Item> PLASMID_INJECTION_CHAMBER = block(GeneticPlaygroundModBlocks.PLASMID_INJECTION_CHAMBER);
	public static final DeferredItem<Item> MILKABLE_PLASMID = REGISTRY.register("milkable_plasmid", MilkablePlasmidItem::new);
	public static final DeferredItem<Item> ALUMINIUM_BLOCK = block(GeneticPlaygroundModBlocks.ALUMINIUM_BLOCK);
	public static final DeferredItem<Item> GRAZING_PLASMID = REGISTRY.register("grazing_plasmid", GrazingPlasmidItem::new);
	public static final DeferredItem<Item> MAX_HEALTH_PLASMID = REGISTRY.register("max_health_plasmid", MaxHealthPlasmidItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_SHEEP_BLOOD = REGISTRY.register("syringe_of_sheep_blood", SyringeOfSheepBloodItem::new);
	public static final DeferredItem<Item> SHEEP_CELL = REGISTRY.register("sheep_cell", SheepCellItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_WOOLY = REGISTRY.register("double_helix_wooly", DoubleHelixWoolyItem::new);
	public static final DeferredItem<Item> WOOLY_PLASMID = REGISTRY.register("wooly_plasmid", WoolyPlasmidItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_ENDERMAN_ENDERFLUID = REGISTRY.register("syringe_of_enderman_enderfluid", SyringeOfEndermanEnderfluidItem::new);
	public static final DeferredItem<Item> ENDERMAN_CELL = REGISTRY.register("enderman_cell", EndermanCellItem::new);
	public static final DeferredItem<Item> HYDROPHOBIA_DOUBLE_HELIX = REGISTRY.register("hydrophobia_double_helix", HydrophobiaDoubleHelixItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_TELEPORATION = REGISTRY.register("double_helix_teleporation", DoubleHelixTeleporationItem::new);
	public static final DeferredItem<Item> HYDROPHOBIA_PLASMID = REGISTRY.register("hydrophobia_plasmid", HydrophobiaPlasmidItem::new);
	public static final DeferredItem<Item> TELEPORATION_PLASMID = REGISTRY.register("teleporation_plasmid", TeleporationPlasmidItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_CHICKEN_BLOOD = REGISTRY.register("syringe_of_chicken_blood", SyringeOfChickenBloodItem::new);
	public static final DeferredItem<Item> CHICKEN_CELL = REGISTRY.register("chicken_cell", ChickenCellItem::new);
	public static final DeferredItem<Item> EGG_PLASMID = REGISTRY.register("egg_plasmid", EggPlasmidItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_EGG = REGISTRY.register("double_helix_egg", DoubleHelixEggItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_RABBIT_BLOOD = REGISTRY.register("syringe_of_rabbit_blood", SyringeOfRabbitBloodItem::new);
	public static final DeferredItem<Item> RABBIT_CELL = REGISTRY.register("rabbit_cell", RabbitCellItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_HIGHER_JUMP = REGISTRY.register("double_helix_higher_jump", DoubleHelixHigherJumpItem::new);
	public static final DeferredItem<Item> HIGHER_JUMP_PLASMID = REGISTRY.register("higher_jump_plasmid", HigherJumpPlasmidItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_ENDERSIGHT = REGISTRY.register("double_helix_endersight", DoubleHelixEndersightItem::new);
	public static final DeferredItem<Item> ENDERSIGHT_PLASMID = REGISTRY.register("endersight_plasmid", EndersightPlasmidItem::new);
	public static final DeferredItem<Item> LAB_FAN = block(GeneticPlaygroundModBlocks.LAB_FAN);
	public static final DeferredItem<Item> SYRINGE_OF_HORSE_BLOOD = REGISTRY.register("syringe_of_horse_blood", SyringeOfHorseBloodItem::new);
	public static final DeferredItem<Item> HORSE_CELL = REGISTRY.register("horse_cell", HorseCellItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_DONKEY_BLOOD = REGISTRY.register("syringe_of_donkey_blood", SyringeOfDonkeyBloodItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_MULE_BLOOD = REGISTRY.register("syringe_of_mule_blood", SyringeOfMuleBloodItem::new);
	public static final DeferredItem<Item> DONKEY_CELL = REGISTRY.register("donkey_cell", DonkeyCellItem::new);
	public static final DeferredItem<Item> MULE_CELL = REGISTRY.register("mule_cell", MuleCellItem::new);
	public static final DeferredItem<Item> SYRINGE_OF_COD_BLOOD = REGISTRY.register("syringe_of_cod_blood", SyringeOfCodBloodItem::new);
	public static final DeferredItem<Item> COD_CELL = REGISTRY.register("cod_cell", CodCellItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_WATER_SPEED = REGISTRY.register("double_helix_water_speed", DoubleHelixWaterSpeedItem::new);
	public static final DeferredItem<Item> WATER_SPEED_PLASMID = REGISTRY.register("water_speed_plasmid", WaterSpeedPlasmidItem::new);
	public static final DeferredItem<Item> DOUBLE_HELIX_WATER_BREATHING = REGISTRY.register("double_helix_water_breathing", DoubleHelixWaterBreathingItem::new);
	public static final DeferredItem<Item> WATER_BREATHING_PLASMID = REGISTRY.register("water_breathing_plasmid", WaterBreathingPlasmidItem::new);
	public static final DeferredItem<Item> LAB_TILES = block(GeneticPlaygroundModBlocks.LAB_TILES);
	public static final DeferredItem<Item> CRACKED_LAB_WALL = block(GeneticPlaygroundModBlocks.CRACKED_LAB_WALL);
	public static final DeferredItem<Item> SYRINGE_OF_SALMON_BLOOD = REGISTRY.register("syringe_of_salmon_blood", SyringeOfSalmonBloodItem::new);
	public static final DeferredItem<Item> SALMON_CELL = REGISTRY.register("salmon_cell", SalmonCellItem::new);
	public static final DeferredItem<Item> WARNING_SIGN = block(GeneticPlaygroundModBlocks.WARNING_SIGN);
	public static final DeferredItem<Item> BIOHAZARD_SIGN = block(GeneticPlaygroundModBlocks.BIOHAZARD_SIGN);
	public static final DeferredItem<Item> FISSION_POWER_PLANT_CONTROLLER = block(GeneticPlaygroundModBlocks.FISSION_POWER_PLANT_CONTROLLER);
	public static final DeferredItem<Item> COPPER_PIPING = block(GeneticPlaygroundModBlocks.COPPER_PIPING);
	public static final DeferredItem<Item> GOLD_CABLE = block(GeneticPlaygroundModBlocks.GOLD_CABLE);
	public static final DeferredItem<Item> ALUMINIUM_CABLE = block(GeneticPlaygroundModBlocks.ALUMINIUM_CABLE);
	public static final DeferredItem<Item> NETHERITE_CABLE = block(GeneticPlaygroundModBlocks.NETHERITE_CABLE);
	public static final DeferredItem<Item> ELECTRIC_PUMP = block(GeneticPlaygroundModBlocks.ELECTRIC_PUMP);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}