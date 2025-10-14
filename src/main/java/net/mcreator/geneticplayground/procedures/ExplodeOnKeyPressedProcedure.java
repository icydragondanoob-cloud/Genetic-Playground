package net.mcreator.geneticplayground.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.geneticplayground.network.GeneticPlaygroundModVariables;

public class ExplodeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(GeneticPlaygroundModVariables.PLAYER_VARIABLES).Explosive == true) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.MOB);
		}
	}
}