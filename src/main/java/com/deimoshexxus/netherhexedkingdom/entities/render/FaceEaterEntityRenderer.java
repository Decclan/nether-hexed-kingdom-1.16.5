package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.FaceEaterEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
import com.deimoshexxus.netherhexedkingdom.entities.models.FaceEaterModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.WightEntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.entity.model.PhantomModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class FaceEaterEntityRenderer extends MobRenderer <FaceEaterEntity, PhantomModel<FaceEaterEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/face_eater_entity_large_char.png");
	
	public FaceEaterEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new FaceEaterModel(), 0.75F);
		this.addLayer(new GlowFireLayer<FaceEaterEntity, PhantomModel<FaceEaterEntity>>(this));

	}

	@Override
	public ResourceLocation getTextureLocation(FaceEaterEntity entity) 
	{
		return TEXTURE;
	}

	protected void scale(FaceEaterEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) 
	{
		int i = p_225620_1_.getPhantomSize();
		float f = 1.0F + 0.15F * (float)i;
		p_225620_2_.scale(f, f, f);
		p_225620_2_.translate(0.0D, 1.3125D, 0.1875D);
	}

   protected void setupRotations(FaceEaterEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) 
   {
	      super.setupRotations(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
	      p_225621_2_.mulPose(Vector3f.XP.rotationDegrees(p_225621_1_.xRot));
   }
   
   
}