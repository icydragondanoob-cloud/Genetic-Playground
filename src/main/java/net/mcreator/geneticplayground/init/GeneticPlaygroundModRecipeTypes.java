package net.mcreator.geneticplayground.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.geneticplayground.jei_recipes.UraniumFuelRodDecayRecipe;
import net.mcreator.geneticplayground.jei_recipes.PlasmidSynthesiserJEITypeRecipe;
import net.mcreator.geneticplayground.jei_recipes.BloodExtractionJEIRecipe;
import net.mcreator.geneticplayground.jei_recipes.BloodCentrifugeJEIRecipe;
import net.mcreator.geneticplayground.GeneticPlaygroundMod;

@EventBusSubscriber(modid = GeneticPlaygroundMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GeneticPlaygroundModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "genetic_playground");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "genetic_playground");
	public static RecipeMap recipes = null;

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("genetic_playground").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("plasmid_synthesiser_jei_type", () -> PlasmidSynthesiserJEITypeRecipe.Type.INSTANCE);
			SERIALIZERS.register("plasmid_synthesiser_jei_type", () -> PlasmidSynthesiserJEITypeRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("blood_centrifuge_jei", () -> BloodCentrifugeJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("blood_centrifuge_jei", () -> BloodCentrifugeJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("blood_extraction_jei", () -> BloodExtractionJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("blood_extraction_jei", () -> BloodExtractionJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("uranium_fuel_rod_decay", () -> UraniumFuelRodDecayRecipe.Type.INSTANCE);
			SERIALIZERS.register("uranium_fuel_rod_decay", () -> UraniumFuelRodDecayRecipe.Serializer.INSTANCE);
		});
	}

	@EventBusSubscriber
	private static class Fetcher {
		@SubscribeEvent
		public static void syncRecipes(OnDatapackSyncEvent event) {
			event.sendRecipes(PlasmidSynthesiserJEITypeRecipe.Type.INSTANCE);
			event.sendRecipes(BloodCentrifugeJEIRecipe.Type.INSTANCE);
			event.sendRecipes(BloodExtractionJEIRecipe.Type.INSTANCE);
			event.sendRecipes(UraniumFuelRodDecayRecipe.Type.INSTANCE);
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void receiveRecipes(RecipesReceivedEvent event) {
			recipes = event.getRecipeMap();
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void clearRecipes(ClientPlayerNetworkEvent.LoggingOut event) {
			recipes = null;
		}
	}
}