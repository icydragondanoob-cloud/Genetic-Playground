package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.network.GeneticPlaygroundModVariables;
import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;

public class SyringeItemHitInAirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableSpeed") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity9.getAttribute(Attributes.MOVEMENT_SPEED)
						.setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA")));
			if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY))
				_livingEntity12.getAttribute(Attributes.MOVEMENT_EFFICIENCY)
						.setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA")));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableMaxHealth") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity23.getAttribute(Attributes.MAX_HEALTH)
						.setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA")));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableGrazing") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.GrazingGene = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWooly") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.WoolyGene = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("WoolyGene");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS && entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES).TimerWool == 0
				&& entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES).WoolyGene == true) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WHITE_WOOL));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.TimerWool = 1200;
				_vars.syncPlayerVariables(entity);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableHydrophobia") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.Hydrophobia = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Hydrophobia");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableTeleportation") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.TeleportationGene = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("TeleportationGene");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableEgg") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.EggGene = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EggGene");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableHigherJump") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.HigherJump = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("HigherJump");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableEndersight") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.Endersight = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Endersight");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWaterbreathing") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.Waterbreathing = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWaterSpeed") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity120 && _livingEntity120.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
				_livingEntity120.getAttribute(NeoForgeMod.SWIM_SPEED)
						.setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed")));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableExplosive") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				GeneticPlaygroundModVariables.PlayerVariables _vars = entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES);
				_vars.Explosive = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("explosive");
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}