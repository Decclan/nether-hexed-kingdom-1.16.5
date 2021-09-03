package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
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
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WightEntityRenderer extends BipedRenderer<WightEntity, BipedModel<WightEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wight_entity.png");
	
	public WightEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new WightEntityModel(), 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<WightEntity>(1.0F), new BipedModel<WightEntity>(1.0F)));
//	    this.addLayer(new HeldItemLayer<>(this));
//	    this.addLayer(new HeadLayer<>(this));
	    //player model boolean = slim
	    
//		this.addLayer(new BipedArmorLayer<>(this, new TestEntityModel(), new TestEntityModel()));
//		this.addLayer(new BipedArmorLayer<TestEntity, BipedModel<TestEntity>, BipedModel<T>>(p_i50936_1_, p_i50936_2_, p_i50936_3_));
	}
	
	@Override
	public ResourceLocation getTextureLocation(WightEntity entity) 
	{
		return TEXTURE;
	}
}