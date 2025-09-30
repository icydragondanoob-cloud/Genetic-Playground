package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class CommandgetgenesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("WoolyGene: " + entity.getPersistentData().getBoolean("WoolyGene") + "\n" + "GrazingGene:" + entity.getPersistentData().getBoolean("GrazingGene"))), false);
	}
}