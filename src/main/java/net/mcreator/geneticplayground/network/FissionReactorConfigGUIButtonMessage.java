package net.mcreator.geneticplayground.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.procedures.SpentFuelRedstoneClickedProcedure;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FissionReactorConfigGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FissionReactorConfigGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(GeneticPlaygroundMod.MODID, "fission_reactor_config_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FissionReactorConfigGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FissionReactorConfigGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FissionReactorConfigGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FissionReactorConfigGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FissionReactorConfigGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SpentFuelRedstoneClickedProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		GeneticPlaygroundMod.addNetworkMessage(FissionReactorConfigGUIButtonMessage.TYPE, FissionReactorConfigGUIButtonMessage.STREAM_CODEC, FissionReactorConfigGUIButtonMessage::handleData);
	}
}