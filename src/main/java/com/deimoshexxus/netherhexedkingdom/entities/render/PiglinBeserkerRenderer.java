package com.deimoshexxus.netherhexedkingdom.entities.render;

import java.util.Map;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.PiglinBeserkerEntity;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;
import com.google.common.collect.ImmutableMap;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PiglinModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//import net.minecraft.client.renderer.entity.PiglinRenderer;

@OnlyIn(Dist.CLIENT)
public class PiglinBeserkerRenderer extends BipedRenderer<PiglinBeserkerEntity, PiglinModel<PiglinBeserkerEntity>>
{
	//private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/piglin_beserker.png");
	   private static final Map<EntityType<?>, ResourceLocation> resourceLocations = ImmutableMap.of(ModEntities.PIGLIN_BESERKER_ENTITY.get(), new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/piglin_beserker.png"), EntityType.ZOMBIFIED_PIGLIN, new ResourceLocation("textures/entity/piglin/zombified_piglin.png"));

	
	
	public PiglinBeserkerRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new PiglinModel<PiglinBeserkerEntity>(0.0F, 64, 64), 0.5F);
		this.addLayer(new BipedArmorLayer<>(this, new BipedModel<PiglinBeserkerEntity>(1.02F), new BipedModel<PiglinBeserkerEntity>(1.02F)));
	}
	
	@Override
	public ResourceLocation getTextureLocation(PiglinBeserkerEntity entity) 
	{
	      ResourceLocation resourcelocation = resourceLocations.get(entity.getType());
	      if (resourcelocation == null) {
	         throw new IllegalArgumentException("I don't know what texture to use for " + entity.getType());
	      } else {
	         return resourcelocation;
	      }
	}
	
	protected boolean isShaking(MobEntity p_230495_1_) {
		return p_230495_1_ instanceof AbstractPiglinEntity && ((AbstractPiglinEntity)p_230495_1_).isConverting();
	}
}