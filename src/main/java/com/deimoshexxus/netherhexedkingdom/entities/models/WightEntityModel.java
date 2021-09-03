package com.deimoshexxus.netherhexedkingdom.entities.models;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityTwo;

import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.RenderType;

// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

//Made with Blockbench 3.8.4
//Exported for Minecraft version 1.15 - 1.16
//Paste this class into your mod and generate all required imports


public class WightEntityModel extends BipedModel<WightEntity>
{
	
//	private final ModelRenderer waist;
	private final ModelRenderer body;
	private final ModelRenderer head;
//	private final ModelRenderer hat;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightItem;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftItem;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public WightEntityModel() 
	{
		//super(RenderType::entityTranslucent);
		super(0.0F);
		
		texWidth = 64;
		texHeight = 64;



		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.texOffs(40, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
		body.texOffs(0, 38).addBox(-5.0F, 9.0F, -3.0F, 10.0F, 4.0F, 6.0F, 0.0F, false);
		
		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-5.0F, 2.0F, 0.0F);
		body.addChild(rightArm);
		rightArm.texOffs(32, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(48, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setPos(-3.0F, 7.0F, -2.0F);
		rightArm.addChild(rightItem);
		

		leftArm = new ModelRenderer(this);
		leftArm.setPos(5.0F, 2.0F, 0.0F);
		body.addChild(leftArm);
		leftArm.texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		leftArm.texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, true);

		leftItem = new ModelRenderer(this);
		leftItem.setPos(3.0F, 7.0F, -2.0F);
		leftArm.addChild(leftItem);
		

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(-1.9F, 12.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.texOffs(16, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		rightLeg.texOffs(0, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.25F, false);
		rightLeg.texOffs(35, 38).addBox(-3.0F, 1.0F, -3.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(1.9F, 12.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.texOffs(16, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		leftLeg.texOffs(0, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.25F, true);
		leftLeg.texOffs(35, 38).addBox(-2.0F, 1.0F, -3.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);
		
//		body = new ModelRenderer(this);
//		body.setPos(0.0F, 0.0F, 0.0F);
//		body.texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
//		body.texOffs(40, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
//		body.texOffs(0, 38).addBox(-5.0F, 9.0F, -3.0F, 10.0F, 4.0F, 6.0F, 0.0F, false);
//		
//		head = new ModelRenderer(this);
//		head.setPos(0.0F, 0.0F, 0.0F);
//		body.addChild(head);
//		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
//		head.texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
//
//		rightArm = new ModelRenderer(this);
//		rightArm.setPos(-5.0F, 2.0F, 0.0F);
//		body.addChild(rightArm);
//		rightArm.texOffs(32, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
//		rightArm.texOffs(48, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
//
//		rightItem = new ModelRenderer(this);
//		rightItem.setPos(-3.0F, 7.0F, -2.0F);
//		rightArm.addChild(rightItem);
//		
//
//		leftArm = new ModelRenderer(this);
//		leftArm.setPos(5.0F, 2.0F, 0.0F);
//		body.addChild(leftArm);
//		leftArm.texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
//		leftArm.texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
//
//		leftItem = new ModelRenderer(this);
//		leftItem.setPos(3.0F, 7.0F, -2.0F);
//		leftArm.addChild(leftItem);
//		
//
//		rightLeg = new ModelRenderer(this);
//		rightLeg.setPos(-1.9F, 12.0F, 0.0F);
//		body.addChild(rightLeg);
//		rightLeg.texOffs(16, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
//		rightLeg.texOffs(0, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.25F, false);
//		rightLeg.texOffs(35, 38).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);
//
//		leftLeg = new ModelRenderer(this);
//		leftLeg.setPos(1.9F, 12.0F, 0.0F);
//		body.addChild(leftLeg);
//		leftLeg.texOffs(16, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
//		leftLeg.texOffs(0, 52).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.25F, true);
//		leftLeg.texOffs(35, 38).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);
	}
	

	@Override
	public void setupAnim(WightEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		boolean flag = entity.getFallFlyingTicks() > 4;
	      this.body.yRot = 0.0F;
	      this.rightArm.z = 0.0F;
	      this.rightArm.x = -5.0F;
	      this.leftArm.z = 0.0F;
	      this.leftArm.x = 5.0F;
	      float f = 1.0F;
	      if (flag) {
	         f = (float)entity.getDeltaMovement().lengthSqr();
	         f = f / 0.2F;
	         f = f * f * f;
	      }

	      if (f < 1.0F) {
	         f = 1.0F;
	      }
		
	      this.rightArm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
	      this.leftArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
	      this.rightArm.zRot = 0.0F;
	      this.leftArm.zRot = 0.0F;
	      this.rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
	      this.leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
	      this.rightLeg.yRot = 0.0F;
	      this.leftLeg.yRot = 0.0F;
	      this.rightLeg.zRot = 0.0F;
	      this.leftLeg.zRot = 0.0F;

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
	
	@Override
	public void translateToHand(HandSide p_225599_1_, MatrixStack p_225599_2_) 
	{
		float f = p_225599_1_ == HandSide.RIGHT ? 1.0F : -1.0F;
		ModelRenderer modelrenderer = this.getArm(p_225599_1_);
		modelrenderer.x += f;
		modelrenderer.translateAndRotate(p_225599_2_);
		modelrenderer.x -= f;
	}
}