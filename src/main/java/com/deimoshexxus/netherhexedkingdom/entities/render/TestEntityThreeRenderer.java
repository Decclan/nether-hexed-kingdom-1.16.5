package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityThree;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityTwo;
//import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityThreeModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityThreeModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityThreeModel;

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
public class TestEntityThreeRenderer extends BipedRenderer<TestEntityThree, SkeletonModel<TestEntityThree>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/nether_hexan_guard.png");
	
	public TestEntityThreeRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new TestEntityThreeModel(), 0.5F);
	    //this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel<TestEntityThree>(1.0F, false), new SkeletonModel<TestEntityThree>(1.0F, false)));

	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<TestEntityThree>(1.0F), new BipedModel<TestEntityThree>(1.0F)));
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntityThree entity) 
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