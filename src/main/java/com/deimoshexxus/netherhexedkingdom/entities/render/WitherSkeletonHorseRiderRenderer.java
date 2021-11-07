package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseRider;
import com.deimoshexxus.netherhexedkingdom.entities.render.layers.GlowEyesLayer;
import com.deimoshexxus.netherhexedkingdom.entities.render.layers.RiderDeadHorseArmorRenderer;

import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WitherSkeletonHorseRiderRenderer extends AbstractHorseRenderer<WitherSkeletonHorseRider, HorseModel<WitherSkeletonHorseRider>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wither_skeleton_horse.png");

	public WitherSkeletonHorseRiderRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new HorseModel<WitherSkeletonHorseRider>(0.0F), 1.2F);
		this.addLayer(new RiderDeadHorseArmorRenderer(this));
		this.addLayer(new GlowEyesLayer<WitherSkeletonHorseRider, HorseModel<WitherSkeletonHorseRider>>(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(WitherSkeletonHorseRider entity) 
	{
		return TEXTURE;
	}
}