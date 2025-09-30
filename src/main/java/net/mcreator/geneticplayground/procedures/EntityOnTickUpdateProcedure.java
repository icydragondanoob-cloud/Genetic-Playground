package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityOnTickUpdateProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("WoolyGene") == true) {
			if (entity.getPersistentData().getDouble("TimerWool") != 0) {
				entity.getPersistentData().putDouble("TimerWool", (entity.getPersistentData().getDouble("TimerWool") - 1));
			}
		}
		if (entity.getPersistentData().getBoolean("Hydrophobia") == true) {
			if (entity.isInWaterRainOrBubble()) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 2);
			}
		}
		if (entity.getPersistentData().getBoolean("EggGene") == true) {
			if (entity.getPersistentData().getDouble("TimerEgg") == 0) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EGG));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.chicken.egg")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.chicken.egg")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("TimerEgg", 10000);
			}
			if (entity.getPersistentData().getDouble("TimerEgg") != 0) {
				entity.getPersistentData().putDouble("TimerEgg", (entity.getPersistentData().getDouble("TimerEgg") - 1));
			}
		}
		if (entity.getPersistentData().getBoolean("HigherJump") == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 4, false, false));
		}
		if (entity.getPersistentData().getBoolean("Waterbreathing") == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 1, false, false));
		}
	}
}