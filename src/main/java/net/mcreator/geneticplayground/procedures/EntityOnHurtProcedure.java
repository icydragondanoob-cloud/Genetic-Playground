package net.mcreator.geneticplayground.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.network.GeneticPlaygroundModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityOnHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!(entity instanceof Player)) {
			entity.getPersistentData().putDouble("tpx", 0);
			entity.getPersistentData().putDouble("tpy", 0);
			entity.getPersistentData().putDouble("tpz", 0);
			if (entity.getPersistentData().getBoolean("TeleportationGene") == true) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 3, 3, 3, 0.1);
				entity.getPersistentData().putDouble("tpx", (entity.getX() + Mth.nextInt(RandomSource.create(), -100, 100)));
				entity.getPersistentData().putDouble("tpy", (Mth.nextInt(RandomSource.create(), 40, 130)));
				entity.getPersistentData().putDouble("tpz", (entity.getZ() + Mth.nextInt(RandomSource.create(), -100, 100)));
				if ((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy"), entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") + 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") + 2, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR)
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.VOID_AIR)
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.WATER)
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.CAVE_AIR)) {
					{
						Entity _ent = entity;
						_ent.teleportTo((entity.getPersistentData().getDouble("tpx")), (entity.getPersistentData().getDouble("tpy")), (entity.getPersistentData().getDouble("tpz")));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("tpx")), (entity.getPersistentData().getDouble("tpy")), (entity.getPersistentData().getDouble("tpz")), _ent.getYRot(), _ent.getXRot());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 3, 3, 3, 0.1);
				} else {
					EntityOnHurtProcedure.execute(world, x, y, z, entity);
				}
			}
		} else if (entity instanceof Player) {
			entity.getPersistentData().putDouble("tpx", 0);
			entity.getPersistentData().putDouble("tpy", (Mth.nextInt(RandomSource.create(), 40, 130)));
			entity.getPersistentData().putDouble("tpz", (entity.getZ() + Mth.nextInt(RandomSource.create(), -100, 100)));
			if (entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES).TeleportationGene == true) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 3, 3, 3, 0.1);
				entity.getPersistentData().putDouble("tpx", (entity.getX() + Mth.nextInt(RandomSource.create(), -100, 100)));
				entity.getPersistentData().putDouble("tpy", (Mth.nextInt(RandomSource.create(), 40, 130)));
				entity.getPersistentData().putDouble("tpz", (entity.getZ() + Mth.nextInt(RandomSource.create(), -100, 100)));
				if ((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy"), entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") + 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") + 2, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.AIR)
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.VOID_AIR)
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.WATER)
						&& !((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("tpx"), entity.getPersistentData().getDouble("tpy") - 1, entity.getPersistentData().getDouble("tpz")))).getBlock() == Blocks.CAVE_AIR)) {
					{
						Entity _ent = entity;
						_ent.teleportTo((entity.getPersistentData().getDouble("tpx")), (entity.getPersistentData().getDouble("tpy")), (entity.getPersistentData().getDouble("tpz")));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("tpx")), (entity.getPersistentData().getDouble("tpy")), (entity.getPersistentData().getDouble("tpz")), _ent.getYRot(), _ent.getXRot());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 3, 3, 3, 0.1);
				} else {
					EntityOnHurtProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}