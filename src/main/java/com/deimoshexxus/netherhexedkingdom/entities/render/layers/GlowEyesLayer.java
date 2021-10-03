package com.deimoshexxus.netherhexedkingdom.entities.render.layers;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GlowEyesLayer<T extends Entity, M extends EntityModel<T>> extends AbstractEyesLayer<T, M>
{
	private static final RenderType GLOW = RenderType.eyes(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wither_skeleton_horse_redeyes.png"));

   public GlowEyesLayer(IEntityRenderer<T, M> p_i50928_1_) 
   {
      super(p_i50928_1_);
   }
   

   public RenderType renderType() 
   {
      return GLOW;
   }
}