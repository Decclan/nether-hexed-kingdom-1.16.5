package com.deimoshexxus.netherhexedkingdom.entities.models;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class HexanGuardEntityModel extends EntityModel<HexanGuardEntity> 
{
	
	private final ModelRenderer waist;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightItem;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftItem;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public HexanGuardEntityModel() 
	{
		super(RenderType::entityCutoutNoCull);
		
		texWidth = 64;
		texHeight = 32;

		waist = new ModelRenderer(this);
		waist.setPos(0.0F, 12.0F, 0.0F);
		

		body = new ModelRenderer(this);
		body.setPos(0.0F, -12.0F, 0.0F);
		waist.addChild(body);
		body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(-5.0F, -10.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(4.0F, -10.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-5.0F, 2.0F, 0.0F);
		body.addChild(rightArm);
		rightArm.texOffs(40, 16).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setPos(-1.0F, 7.0F, 1.0F);
		rightArm.addChild(rightItem);
		

		leftArm = new ModelRenderer(this);
		leftArm.setPos(5.0F, 2.0F, 0.0F);
		body.addChild(leftArm);
		leftArm.texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);

		leftItem = new ModelRenderer(this);
		leftItem.setPos(1.0F, 7.0F, 1.0F);
		leftArm.addChild(leftItem);
		

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(-2.0F, 12.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(2.0F, 12.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);	
	}

	@Override
	public void setupAnim(HexanGuardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
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
	 
		
//		float f = MathHelper.sin(this.attackTime * (float)Math.PI);
//        float f1 = MathHelper.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float)Math.PI);
//        this.rightArm.zRot = 0.0F;
//        this.leftArm.zRot = 0.0F;
//        this.rightArm.yRot = -(0.1F - f * 0.6F);
//        this.leftArm.yRot = 0.1F - f * 0.6F;
//        this.rightArm.xRot = (-(float)Math.PI / 2F);
//        this.leftArm.xRot = (-(float)Math.PI / 2F);
//        this.rightArm.xRot -= f * 1.2F - f1 * 0.4F;
//        this.leftArm.xRot -= f * 1.2F - f1 * 0.4F;
//        ModelHelper.bobArms(this.rightArm, this.leftArm, ageInTicks);	
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		waist.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}