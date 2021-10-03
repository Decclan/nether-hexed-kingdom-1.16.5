package com.deimoshexxus.netherhexedkingdom.entities.models;

import com.deimoshexxus.netherhexedkingdom.entities.VolcanDaemon;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.PhantomModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class FaceEaterModel extends PhantomModel<VolcanDaemon> 
{
	private final ModelRenderer body;
	private final ModelRenderer leftWingBase;	//leftWingBase
	private final ModelRenderer leftWingTip;
	private final ModelRenderer rightWingBase;	//rightWingBase
	private final ModelRenderer rightWingTip;
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer tailtip;
	
	public FaceEaterModel() 
	{
		texWidth = 256;
		texHeight = 256;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(93, 93).addBox(-8.4F, -5.2F, -22.4F, 14.0F, 8.0F, 25.0F, 0.0F, false);

		leftWingBase = new ModelRenderer(this);
		leftWingBase.setPos(5.6F, -48.8F, -22.4F);
		body.addChild(leftWingBase);
		setRotationAngle(leftWingBase, 0.0F, 0.0F, 0.0873F);
		leftWingBase.texOffs(76, 0).addBox(3.7848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, 0.0F, false);

		leftWingTip = new ModelRenderer(this);
		leftWingTip.setPos(16.8F, 0.0F, 0.0F);
		leftWingBase.addChild(leftWingTip);
		setRotationAngle(leftWingTip, 0.0F, 0.0F, 0.1745F);
		leftWingTip.texOffs(0, 0).addBox(10.8637F, 41.9647F, 11.2F, 14.0F, 3.0F, 48.0F, 0.0F, false);
		leftWingTip.texOffs(17, 22).addBox(11.4637F, 41.9647F, 5.6F, 6.0F, 3.0F, 6.0F, 0.0F, false);

		rightWingBase = new ModelRenderer(this);
		rightWingBase.setPos(-8.4F, -48.8F, -22.4F);
		body.addChild(rightWingBase);
		setRotationAngle(rightWingBase, 0.0F, 0.0F, -0.0873F);
		rightWingBase.texOffs(76, 0).addBox(-20.9848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, 0.0F, true);

		rightWingTip = new ModelRenderer(this);
		rightWingTip.setPos(-16.8F, 0.0F, 0.0F);
		rightWingBase.addChild(rightWingTip);
		setRotationAngle(rightWingTip, 0.0F, 0.0F, -0.1745F);
		rightWingTip.texOffs(0, 51).addBox(-24.8637F, 41.9647F, 11.2F, 14.0F, 3.0F, 45.0F, 0.0F, false);
		rightWingTip.texOffs(17, 22).addBox(-17.8637F, 41.9647F, 5.6F, 6.0F, 3.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, -40.4F, -19.6F);
		body.addChild(head);
		head.texOffs(0, 0).addBox(-5.2F, 38.0F, -14.0F, 8.0F, 8.0F, 14.0F, 0.0F, false);
		head.texOffs(0, 22).addBox(1.6F, 44.8F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		head.texOffs(0, 22).addBox(-7.6F, 44.8F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		head.texOffs(0, 22).addBox(-7.6F, 35.6F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
		head.texOffs(0, 22).addBox(1.6F, 35.6F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setPos(0.0F, -48.8F, 2.8F);
		body.addChild(tail);
		setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
		tail.texOffs(0, 99).addBox(-13.8F, 42.8F, 0.0F, 25.0F, 6.0F, 17.0F, 0.0F, false);
		tail.texOffs(76, 31).addBox(-8.4F, 42.8F, 16.8F, 14.0F, 6.0F, 11.0F, 0.0F, false);

		tailtip = new ModelRenderer(this);
		tailtip.setPos(0.0F, 1.4F, 16.8F);
		tail.addChild(tailtip);
		setRotationAngle(tailtip, -0.0873F, 0.0F, 0.0F);
		tailtip.texOffs(73, 51).addBox(-3.0F, 43.0F, 11.2F, 3.0F, 3.0F, 39.0F, 0.0F, false);	}

	@Override
	public void setupAnim(VolcanDaemon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	      float f = ((float)(entity.getId() * 3) + ageInTicks) * 0.13F;
//	      float f1 = 16.0F;
	      this.leftWingBase.zRot = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
	      this.leftWingTip.zRot = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
	      this.rightWingBase.zRot = -this.leftWingBase.zRot;
	      this.rightWingTip.zRot = -this.leftWingTip.zRot;
	      this.tail.xRot = -(5.0F + MathHelper.cos(f * 2.0F) * 5.0F) * ((float)Math.PI / 180F);
	      this.tailtip.xRot = -(5.0F + MathHelper.cos(f * 2.0F) * 5.0F) * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}

