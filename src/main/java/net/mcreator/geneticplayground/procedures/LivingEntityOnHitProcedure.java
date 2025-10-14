package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.geneticplayground.init.GeneticPlaygroundModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LivingEntityOnHitProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Pig) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_PIG_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "GrazingGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity8.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity11.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Cow) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COW_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "GrazingGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "MilkableGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity26.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity29.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity32.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Sheep) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_SHEEP_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "GrazingGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "WoolyGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity47 && _livingEntity47.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity47.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity50.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity53.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Chicken) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_CHICKEN_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity64 && _livingEntity64.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity64.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity67 && _livingEntity67.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity67.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity70 && _livingEntity70.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity70.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "EggGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Rabbit) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_RABBIT_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity83 && _livingEntity83.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity83.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity86.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity89.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "HigherJump";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Horse) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_HORSE_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity102 && _livingEntity102.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity102.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity105 && _livingEntity105.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity105.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity108 && _livingEntity108.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity108.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Mule) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_MULE_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity119 && _livingEntity119.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity119.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity122 && _livingEntity122.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity122.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity125 && _livingEntity125.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity125.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Donkey) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_DONKEY_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity136 && _livingEntity136.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity136.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity139 && _livingEntity139.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity139.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity142 && _livingEntity142.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity142.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof EnderMan) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_ENDERMAN_ENDERFLUID.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "TeleportationGene";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "Hydrophobia";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "Endersight";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity159 && _livingEntity159.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity159.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity162 && _livingEntity162.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity162.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity166 && _livingEntity166.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity166.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Cod) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COD_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "Waterbreathing";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity178 && _livingEntity178.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity178.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity181 && _livingEntity181.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity181.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity185 && _livingEntity185.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity185.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "WaterSpeed";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Salmon) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_COD_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "Waterbreathing";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity199 && _livingEntity199.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity199.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity202 && _livingEntity202.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity202.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity206 && _livingEntity206.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity206.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "WaterSpeed";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE.get() && entity instanceof Creeper) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE_OF_CREEPER_BLOOD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			{
				final String _tagName = "explosive";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity220 && _livingEntity220.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity220.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity223 && _livingEntity223.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity223.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity227 && _livingEntity227.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity227.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (sourceentity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("genetic_playground:first_blood"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableSpeed") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity240 && _livingEntity240.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity240.getAttribute(Attributes.MOVEMENT_SPEED)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA")));
			if (entity instanceof LivingEntity _livingEntity243 && _livingEntity243.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY))
				_livingEntity243.getAttribute(Attributes.MOVEMENT_EFFICIENCY)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableMaxHealth") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity254 && _livingEntity254.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity254.getAttribute(Attributes.MAX_HEALTH)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableGrazing") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("GrazingGene",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GrazingGene")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && !(entity instanceof Sheep)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWooly") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("WoolyGene",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("WoolyGene")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && !(entity instanceof Cow)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableMilkable") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("MilkableGene",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("MilkableGene")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS && entity.getPersistentData().getDouble("TimerWool") == 0
				&& entity.getPersistentData().getBoolean("WoolyGene") == true) {
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
			entity.getPersistentData().putDouble("TimerWool", 1200);
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET && entity.getPersistentData().getBoolean("MilkableGene") == true) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.fill")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.fill")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && !(entity instanceof EnderMan)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableHydrophobia") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("Hydrophobia",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Hydrophobia")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.MILK_BUCKET).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && !(entity instanceof EnderMan)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableTeleportation") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("TeleportationGene",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("TeleportationGene")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && !(entity instanceof Chicken)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableEgg") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("EggGene", ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EggGene")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get() && !(entity instanceof Rabbit)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableHigherJump") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("HigherJump",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("HigherJump")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWaterSpeed") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity364 && _livingEntity364.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
				_livingEntity364.getAttribute(NeoForgeMod.SWIM_SPEED)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableWaterbreathing") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("Waterbreathing",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Waterbreathing")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == GeneticPlaygroundModItems.SYRINGE_OF_STERILE_BLOOD.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("InjectableExplosive") == true) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			entity.getPersistentData().putBoolean("Explosive",
					((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("explosive")));
			if (sourceentity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}