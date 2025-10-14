package net.mcreator.geneticplayground.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.geneticplayground.GeneticPlaygroundMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GeneticPlaygroundModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, GeneticPlaygroundMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		GeneticPlaygroundMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			if (!event.isWasDeath()) {
				clone.Endersight = original.Endersight;
				clone.HigherJump = original.HigherJump;
				clone.EggGene = original.EggGene;
				clone.TeleportationGene = original.TeleportationGene;
				clone.Hydrophobia = original.Hydrophobia;
				clone.GrazingGene = original.GrazingGene;
				clone.MilkableGene = original.MilkableGene;
				clone.WoolyGene = original.WoolyGene;
				clone.TimerWool = original.TimerWool;
				clone.TimerEgg = original.TimerEgg;
				clone.Waterbreathing = original.Waterbreathing;
				clone.Explosive = original.Explosive;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean Endersight = false;
		public boolean HigherJump = false;
		public boolean EggGene = false;
		public boolean TeleportationGene = false;
		public boolean Hydrophobia = false;
		public boolean GrazingGene = false;
		public boolean MilkableGene = false;
		public boolean WoolyGene = false;
		public double TimerWool = 0;
		public double TimerEgg = 0;
		public boolean Waterbreathing = false;
		public boolean Explosive = false;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("Endersight", Endersight);
			nbt.putBoolean("HigherJump", HigherJump);
			nbt.putBoolean("EggGene", EggGene);
			nbt.putBoolean("TeleportationGene", TeleportationGene);
			nbt.putBoolean("Hydrophobia", Hydrophobia);
			nbt.putBoolean("GrazingGene", GrazingGene);
			nbt.putBoolean("MilkableGene", MilkableGene);
			nbt.putBoolean("WoolyGene", WoolyGene);
			nbt.putDouble("TimerWool", TimerWool);
			nbt.putDouble("TimerEgg", TimerEgg);
			nbt.putBoolean("Waterbreathing", Waterbreathing);
			nbt.putBoolean("Explosive", Explosive);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			Endersight = nbt.getBoolean("Endersight");
			HigherJump = nbt.getBoolean("HigherJump");
			EggGene = nbt.getBoolean("EggGene");
			TeleportationGene = nbt.getBoolean("TeleportationGene");
			Hydrophobia = nbt.getBoolean("Hydrophobia");
			GrazingGene = nbt.getBoolean("GrazingGene");
			MilkableGene = nbt.getBoolean("MilkableGene");
			WoolyGene = nbt.getBoolean("WoolyGene");
			TimerWool = nbt.getDouble("TimerWool");
			TimerEgg = nbt.getDouble("TimerEgg");
			Waterbreathing = nbt.getBoolean("Waterbreathing");
			Explosive = nbt.getBoolean("Explosive");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(GeneticPlaygroundMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}