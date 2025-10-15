/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.geneticplayground.block.entity.UnknownBlockBlockEntity;
import net.mcreator.geneticplayground.block.entity.ThermalTurbineBlockEntity;
import net.mcreator.geneticplayground.block.entity.SuperFrozenIceBlockEntity;
import net.mcreator.geneticplayground.block.entity.SolarPanelBlockEntity;
import net.mcreator.geneticplayground.block.entity.PlasmidSynthesiserBlockEntity;
import net.mcreator.geneticplayground.block.entity.PlasmidInjectionChamberBlockEntity;
import net.mcreator.geneticplayground.block.entity.NetheriteCableBlockEntity;
import net.mcreator.geneticplayground.block.entity.HeatGeneratorBlockEntity;
import net.mcreator.geneticplayground.block.entity.GoldCableBlockEntity;
import net.mcreator.geneticplayground.block.entity.FissionPowerPlantControllerBlockEntity;
import net.mcreator.geneticplayground.block.entity.DNAExtractorBlockEntity;
import net.mcreator.geneticplayground.block.entity.CreativeEnergyBlockBlockEntity;
import net.mcreator.geneticplayground.block.entity.CellAnalyzerBlockEntity;
import net.mcreator.geneticplayground.block.entity.BloodPurifierBlockEntity;
import net.mcreator.geneticplayground.block.entity.BloodCentrifugeBlockEntity;
import net.mcreator.geneticplayground.block.entity.AluminiumCableBlockEntity;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GeneticPlaygroundModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BloodPurifierBlockEntity>> BLOOD_PURIFIER = register("blood_purifier", GeneticPlaygroundModBlocks.BLOOD_PURIFIER, BloodPurifierBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BloodCentrifugeBlockEntity>> BLOOD_CENTRIFUGE = register("blood_centrifuge", GeneticPlaygroundModBlocks.BLOOD_CENTRIFUGE, BloodCentrifugeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeEnergyBlockBlockEntity>> CREATIVE_ENERGY_BLOCK = register("creative_energy_block", GeneticPlaygroundModBlocks.CREATIVE_ENERGY_BLOCK,
			CreativeEnergyBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CellAnalyzerBlockEntity>> CELL_ANALYZER = register("cell_analyzer", GeneticPlaygroundModBlocks.CELL_ANALYZER, CellAnalyzerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DNAExtractorBlockEntity>> DNA_EXTRACTOR = register("dna_extractor", GeneticPlaygroundModBlocks.DNA_EXTRACTOR, DNAExtractorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlasmidSynthesiserBlockEntity>> PLASMID_SYNTHESISER = register("plasmid_synthesiser", GeneticPlaygroundModBlocks.PLASMID_SYNTHESISER, PlasmidSynthesiserBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlasmidInjectionChamberBlockEntity>> PLASMID_INJECTION_CHAMBER = register("plasmid_injection_chamber", GeneticPlaygroundModBlocks.PLASMID_INJECTION_CHAMBER,
			PlasmidInjectionChamberBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FissionPowerPlantControllerBlockEntity>> FISSION_POWER_PLANT_CONTROLLER = register("fission_power_plant_controller", GeneticPlaygroundModBlocks.FISSION_POWER_PLANT_CONTROLLER,
			FissionPowerPlantControllerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldCableBlockEntity>> GOLD_CABLE = register("gold_cable", GeneticPlaygroundModBlocks.GOLD_CABLE, GoldCableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AluminiumCableBlockEntity>> ALUMINIUM_CABLE = register("aluminium_cable", GeneticPlaygroundModBlocks.ALUMINIUM_CABLE, AluminiumCableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NetheriteCableBlockEntity>> NETHERITE_CABLE = register("netherite_cable", GeneticPlaygroundModBlocks.NETHERITE_CABLE, NetheriteCableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermalTurbineBlockEntity>> THERMAL_TURBINE = register("thermal_turbine", GeneticPlaygroundModBlocks.THERMAL_TURBINE, ThermalTurbineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UnknownBlockBlockEntity>> UNKNOWN_BLOCK = register("unknown_block", GeneticPlaygroundModBlocks.UNKNOWN_BLOCK, UnknownBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SuperFrozenIceBlockEntity>> SUPER_FROZEN_ICE = register("super_frozen_ice", GeneticPlaygroundModBlocks.SUPER_FROZEN_ICE, SuperFrozenIceBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarPanelBlockEntity>> SOLAR_PANEL = register("solar_panel", GeneticPlaygroundModBlocks.SOLAR_PANEL, SolarPanelBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HeatGeneratorBlockEntity>> HEAT_GENERATOR = register("heat_generator", GeneticPlaygroundModBlocks.HEAT_GENERATOR, HeatGeneratorBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLOOD_PURIFIER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, BLOOD_PURIFIER.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, BLOOD_PURIFIER.get(), (blockEntity, side) -> blockEntity.getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLOOD_CENTRIFUGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, BLOOD_CENTRIFUGE.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, BLOOD_CENTRIFUGE.get(), (blockEntity, side) -> blockEntity.getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREATIVE_ENERGY_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, CREATIVE_ENERGY_BLOCK.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CELL_ANALYZER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, CELL_ANALYZER.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DNA_EXTRACTOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, DNA_EXTRACTOR.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PLASMID_SYNTHESISER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, PLASMID_SYNTHESISER.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PLASMID_INJECTION_CHAMBER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, PLASMID_INJECTION_CHAMBER.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FISSION_POWER_PLANT_CONTROLLER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOLD_CABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, GOLD_CABLE.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ALUMINIUM_CABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ALUMINIUM_CABLE.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NETHERITE_CABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, NETHERITE_CABLE.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, THERMAL_TURBINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, THERMAL_TURBINE.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UNKNOWN_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUPER_FROZEN_ICE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOLAR_PANEL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, SOLAR_PANEL.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HEAT_GENERATOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, HEAT_GENERATOR.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
	}
}