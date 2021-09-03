package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WightTraderEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
//import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.WightEntityModel;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WightTraderEntityRenderer extends WightEntityRenderer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wight_trader_entity.png");
	
	public WightTraderEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager);
	}
	
	public ResourceLocation getTextureLocation(WightEntity entity) 
	{
		return TEXTURE;
	}
}