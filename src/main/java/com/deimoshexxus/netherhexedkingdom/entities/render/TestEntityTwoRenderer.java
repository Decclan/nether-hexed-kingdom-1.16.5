package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityTwo;
//import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityTwoModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityTwoModel;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TestEntityTwoRenderer extends MobRenderer<TestEntityTwo, TestEntityTwoModel>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/nether_hexan_guard.png");
	
//	@SuppressWarnings("rawtypes")
	public TestEntityTwoRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new TestEntityTwoModel(), 0.5F);
//	    this.addLayer(new BipedArmorLayer<>(this, new TestEntityTwoModel(0.5F, true), new TestEntityTwoModel(1.0F, true)));

//		this.addLayer(new BipedArmorLayer<>(this, new TestEntityTwoModel(), new TestEntityTwoModel()));
//		this.addLayer(new BipedArmorLayer<TestEntityTwo, BipedModel<TestEntityTwo>, BipedModel<T>>(p_i50936_1_, p_i50936_2_, p_i50936_3_));
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntityTwo entity) 
	{
		return TEXTURE;
	}
	
//	@OnlyIn(Dist.CLIENT)
//	public class SkeletonRenderer extends BipedRenderer<AbstractSkeletonEntity, SkeletonModel<AbstractSkeletonEntity>> {
//	   private static final ResourceLocation SKELETON_LOCATION = new ResourceLocation("textures/entity/skeleton/skeleton.png");
//
//	   public SkeletonRenderer(EntityRendererManager p_i46143_1_) {
//	      super(p_i46143_1_, new SkeletonModel<>(), 0.5F);
//	      this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel(0.5F, true), new SkeletonModel(1.0F, true)));
//	   }
//
//	   public ResourceLocation getTextureLocation(AbstractSkeletonEntity p_110775_1_) {
//	      return SKELETON_LOCATION;
//	   }
//	}
}