package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.deimoshexxus.netherhexedkingdom.entities.render.layers.DeadHorseArmorRenderer;

@OnlyIn(Dist.CLIENT)
public class WitherSkeletonHorseRenderer extends AbstractHorseRenderer<WitherSkeletonHorseEntity, HorseModel<WitherSkeletonHorseEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wither_skeleton_horse.png");

	public WitherSkeletonHorseRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new HorseModel<WitherSkeletonHorseEntity>(0.0F), 1.2F);
		this.addLayer(new DeadHorseArmorRenderer(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(WitherSkeletonHorseEntity entity) 
	{
		return TEXTURE;
	}
	
	
	
	
	
	
	
}