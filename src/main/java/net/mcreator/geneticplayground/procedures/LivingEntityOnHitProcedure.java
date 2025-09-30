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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

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
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity19.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity22.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity25.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity39 && _livingEntity39.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity39.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity42 && _livingEntity42.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity42.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity45 && _livingEntity45.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity45.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity55 && _livingEntity55.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity55.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity58 && _livingEntity58.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity58.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity61 && _livingEntity61.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity61.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity73 && _livingEntity73.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity73.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity76 && _livingEntity76.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity76.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity79 && _livingEntity79.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity79.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity91 && _livingEntity91.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity91.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity94 && _livingEntity94.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity94.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity97 && _livingEntity97.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity97.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity107 && _livingEntity107.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity107.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity110 && _livingEntity110.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity110.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity113 && _livingEntity113.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity113.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity123 && _livingEntity123.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity123.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity126 && _livingEntity126.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity126.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
						: 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "MaxHealthDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity129 && _livingEntity129.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity129.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("genetic_playground:syringe.stab")), SoundSource.PLAYERS, 1, 1, false);
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity145 && _livingEntity145.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity145.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity148 && _livingEntity148.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity148.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity152 && _livingEntity152.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity152.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity163 && _livingEntity163.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity163.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity166 && _livingEntity166.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity166.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity170 && _livingEntity170.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity170.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "WaterSpeed";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity183 && _livingEntity183.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity183.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "SpeedEffDNA";
				final double _tagValue = (entity instanceof LivingEntity _livingEntity186 && _livingEntity186.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY)
						? _livingEntity186.getAttribute(Attributes.MOVEMENT_EFFICIENCY).getBaseValue()
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
				final double _tagValue = (entity instanceof LivingEntity _livingEntity190 && _livingEntity190.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity190.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "WaterSpeed";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
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
			if (entity instanceof LivingEntity _livingEntity204 && _livingEntity204.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
				_livingEntity204.getAttribute(Attributes.MOVEMENT_SPEED)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedDNA")));
			if (entity instanceof LivingEntity _livingEntity207 && _livingEntity207.getAttributes().hasAttribute(Attributes.MOVEMENT_EFFICIENCY))
				_livingEntity207.getAttribute(Attributes.MOVEMENT_EFFICIENCY)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpeedEffDNA")));
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _livingEntity218 && _livingEntity218.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity218.getAttribute(Attributes.MAX_HEALTH)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MaxHealthDNA")));
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(GeneticPlaygroundModItems.SYRINGE.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (entity instanceof Player _player) {
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
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _entity) {
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
			if (entity instanceof LivingEntity _livingEntity328 && _livingEntity328.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
				_livingEntity328.getAttribute(NeoForgeMod.SWIM_SPEED)
						.setBaseValue(((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("WaterSpeed")));
			if (entity instanceof LivingEntity _entity) {
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