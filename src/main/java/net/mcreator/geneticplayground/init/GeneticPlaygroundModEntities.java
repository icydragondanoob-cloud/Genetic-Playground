/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.geneticplayground.entity.CultivatedCreeperEntity;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GeneticPlaygroundModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, GeneticPlaygroundMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<CultivatedCreeperEntity>> CULTIVATED_CREEPER = register("cultivated_creeper",
			EntityType.Builder.<CultivatedCreeperEntity>of(CultivatedCreeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(5).setUpdateInterval(3)

					.sized(0.6f, 1.7f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		CultivatedCreeperEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CULTIVATED_CREEPER.get(), CultivatedCreeperEntity.createAttributes().build());
	}
}