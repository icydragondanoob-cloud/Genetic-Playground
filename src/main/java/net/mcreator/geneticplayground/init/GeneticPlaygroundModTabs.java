/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.geneticplayground.GeneticPlaygroundMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GeneticPlaygroundModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GENETIC_PLAYGROUND = REGISTRY.register("genetic_playground",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.genetic_playground.genetic_playground")).icon(() -> new ItemStack(GeneticPlaygroundModItems.SYRINGE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GeneticPlaygroundModBlocks.BLOOD_PURIFIER.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.BLOOD_CENTRIFUGE.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.CELL_ANALYZER.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.DNA_EXTRACTOR.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.PLASMID_INJECTION_CHAMBER.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.PLASMID_SYNTHESISER.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.ALUMINIUM_BLOCK.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.LAB_FAN.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.LAB_BRICK_WALLS.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.LAB_WALLS.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.BORDERLESS_LAB_WALLS.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.LAB_TILES.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.CRACKED_LAB_WALL.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.CREATIVE_ENERGY_BLOCK.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.LAB_BRICK_FACADE.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.LAB_WALL_FACADE.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.WARNING_SIGN.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.BIOHAZARD_SIGN.get().asItem());
				tabData.accept(GeneticPlaygroundModItems.PLASMA_RESIDUE_BUCKET.get());
				tabData.accept(GeneticPlaygroundModItems.STERILE_BLOOD_BUCKET.get());
				tabData.accept(GeneticPlaygroundModItems.MACHINE_SPEED_UPGRADE.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_COD_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.SYRINGE_OF_SALMON_BLOOD.get());
				tabData.accept(GeneticPlaygroundModItems.PIG_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.COW_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.SHEEP_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.ENDERMAN_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.CHICKEN_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.RABBIT_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.HORSE_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.DONKEY_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.MULE_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.COD_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.SALMON_CELL.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_FAILED.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_MOVEMENT_SPEED.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_MAX_HEALTH.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_MILKABLE.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_GRAZING.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_WOOLY.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_TELEPORATION.get());
				tabData.accept(GeneticPlaygroundModItems.HYDROPHOBIA_DOUBLE_HELIX.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_ENDERSIGHT.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_EGG.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_HIGHER_JUMP.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_WATER_BREATHING.get());
				tabData.accept(GeneticPlaygroundModItems.DOUBLE_HELIX_WATER_SPEED.get());
				tabData.accept(GeneticPlaygroundModItems.EMPTY_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.MOVEMENT_SPEED_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.MILKABLE_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.GRAZING_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.MAX_HEALTH_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.WOOLY_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.TELEPORATION_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.HYDROPHOBIA_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.ENDERSIGHT_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.EGG_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.HIGHER_JUMP_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.WATER_SPEED_PLASMID.get());
				tabData.accept(GeneticPlaygroundModItems.WATER_BREATHING_PLASMID.get());
				tabData.accept(GeneticPlaygroundModBlocks.FISSION_POWER_PLANT_CONTROLLER.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.COPPER_PIPING.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.GOLD_CABLE.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.ALUMINIUM_CABLE.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.NETHERITE_CABLE.get().asItem());
				tabData.accept(GeneticPlaygroundModBlocks.ELECTRIC_PUMP.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(GeneticPlaygroundModItems.CULTIVATED_CREEPER_SPAWN_EGG.get());
		}
	}
}