package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
import com.deimoshexxus.netherhexedkingdom.entities.render.GlowEyesLayer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.PhantomEyesLayer;
import net.minecraft.client.renderer.entity.UndeadHorseRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LeatherHorseArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.deimoshexxus.netherhexedkingdom.entities.render.DeadHorseArmorRenderer;

@OnlyIn(Dist.CLIENT)
public class WitherSkeletonHorseRenderer extends AbstractHorseRenderer<WitherSkeletonHorseEntity, HorseModel<WitherSkeletonHorseEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wither_skeleton_horse.png");

//	private static final RenderType GLOW = RenderType.eyes(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wither_skeleton_horse_redeyes.png"));
	
	public WitherSkeletonHorseRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new HorseModel<WitherSkeletonHorseEntity>(0.0F), 1.2F);
		this.addLayer(new DeadHorseArmorRenderer(this));
		
//		this.addLayer(new GlowEyesLayer<WitherSkeletonHorseEntity, HorseModel<WitherSkeletonHorseEntity>>(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(WitherSkeletonHorseEntity entity) 
	{
		return TEXTURE;
	}
	
	
	
	
	
	
	
}