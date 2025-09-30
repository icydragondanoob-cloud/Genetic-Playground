package net.mcreator.geneticplayground.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.geneticplayground.entity.CultivatedCreeperEntity;

public class CultivatedCreeperRenderer extends MobRenderer<CultivatedCreeperEntity, CreeperModel<CultivatedCreeperEntity>> {
	public CultivatedCreeperRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel<CultivatedCreeperEntity>(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CultivatedCreeperEntity entity) {
		return ResourceLocation.parse("genetic_playground:textures/entities/cultivatedcreeper.png");
	}
}