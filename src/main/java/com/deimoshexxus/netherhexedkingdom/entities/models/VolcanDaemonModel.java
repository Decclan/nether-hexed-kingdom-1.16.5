package com.deimoshexxus.netherhexedkingdom.entities.models;

import com.deimoshexxus.netherhexedkingdom.entities.VolcanDaemon;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.PhantomModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class VolcanDaemonModel extends PhantomModel<VolcanDaemon> 
{
	private final ModelRenderer body;
	private final ModelRenderer leftWingBase;	//leftWingBase
	private final ModelRenderer leftWingTip;
	private final ModelRenderer rightWingBase;	//rightWingBase
	private final ModelRenderer rightWingTip;
	private final ModelRenderer head;
	private final ModelRenderer headTopHornTip;
	private final ModelRenderer headBottomHornTip;
	private final ModelRenderer tail;
	private final ModelRenderer tailtip;
	
	public VolcanDaemonModel() 
	{
		texWidth = 256;
		texHeight = 256;

//		body = new ModelRenderer(this);
//		body.setPos(0.0F, 0.0F, 0.0F);
//		body.texOffs(93, 93).addBox(-8.4F, -5.2F, -22.4F, 14.0F, 8.0F, 25.0F, 0.0F, false);
//
//		leftWingBase = new ModelRenderer(this);
//		leftWingBase.setPos(5.6F, -48.8F, -22.4F);
//		body.addChild(leftWingBase);
//		setRotationAngle(leftWingBase, 0.0F, 0.0F, 0.0873F);
//		leftWingBase.texOffs(76, 0).addBox(3.7848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, 0.0F, false);
//
//		leftWingTip = new ModelRenderer(this);
//		leftWingTip.setPos(16.8F, 0.0F, 0.0F);
//		leftWingBase.addChild(leftWingTip);
//		setRotationAngle(leftWingTip, 0.0F, 0.0F, 0.1745F);
//		leftWingTip.texOffs(0, 0).addBox(10.8637F, 41.9647F, 11.2F, 14.0F, 3.0F, 48.0F, 0.0F, false);
//		leftWingTip.texOffs(17, 22).addBox(11.4637F, 41.9647F, 5.6F, 6.0F, 3.0F, 6.0F, 0.0F, false);
//
//		rightWingBase = new ModelRenderer(this);
//		rightWingBase.setPos(-8.4F, -48.8F, -22.4F);
//		body.addChild(rightWingBase);
//		setRotationAngle(rightWingBase, 0.0F, 0.0F, -0.0873F);
//		rightWingBase.texOffs(76, 0).addBox(-20.9848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, 0.0F, true);
//
//		rightWingTip = new ModelRenderer(this);
//		rightWingTip.setPos(-16.8F, 0.0F, 0.0F);
//		rightWingBase.addChild(rightWingTip);
//		setRotationAngle(rightWingTip, 0.0F, 0.0F, -0.1745F);
//		rightWingTip.texOffs(0, 51).addBox(-24.8637F, 41.9647F, 11.2F, 14.0F, 3.0F, 45.0F, 0.0F, false);
//		rightWingTip.texOffs(17, 22).addBox(-17.8637F, 41.9647F, 5.6F, 6.0F, 3.0F, 6.0F, 0.0F, false);
//
//		head = new ModelRenderer(this);
//		head.setPos(0.0F, -40.4F, -19.6F);
//		body.addChild(head);
//		head.texOffs(0, 0).addBox(-5.2F, 38.0F, -14.0F, 8.0F, 8.0F, 14.0F, 0.0F, false);
//		head.texOffs(0, 22).addBox(1.6F, 44.8F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
//		head.texOffs(0, 22).addBox(-7.6F, 44.8F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
//		head.texOffs(0, 22).addBox(-7.6F, 35.6F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
//		head.texOffs(0, 22).addBox(1.6F, 35.6F, -22.4F, 3.0F, 3.0F, 11.0F, 0.0F, false);
//
//		tail = new ModelRenderer(this);
//		tail.setPos(0.0F, -48.8F, 2.8F);
//		body.addChild(tail);
//		setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
//		tail.texOffs(0, 99).addBox(-13.8F, 42.8F, 0.0F, 25.0F, 6.0F, 17.0F, 0.0F, false);
//		tail.texOffs(76, 31).addBox(-8.4F, 42.8F, 16.8F, 14.0F, 6.0F, 11.0F, 0.0F, false);
//
//		tailtip = new ModelRenderer(this);
//		tailtip.setPos(0.0F, 1.4F, 16.8F);
//		tail.addChild(tailtip);
//		setRotationAngle(tailtip, -0.0873F, 0.0F, 0.0F);
//		tailtip.texOffs(73, 51).addBox(-3.0F, 43.0F, 11.2F, 3.0F, 3.0F, 39.0F, 0.0F, false);	}

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(96, 82).addBox(-8.4F, -5.2F, -19.4F, 14.0F, 8.0F, 22.0F, 0.0F, false);

		leftWingBase = new ModelRenderer(this);
		leftWingBase.setPos(5.6F, -48.8F, -22.4F);
		body.addChild(leftWingBase);
		setRotationAngle(leftWingBase, 0.0F, 0.0F, 0.0873F);
		leftWingBase.texOffs(76, 0).addBox(3.7848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, 0.0F, false);

//		PartDefinition leftWingBase = body.addOrReplaceChild("leftWingBase", CubeListBuilder.create()
//				.texOffs(76, 0)
//				.addBox(3.7848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, new CubeDeformation(0.0F)), PartPose
//				.offsetAndRotation(5.6F, -48.8F, -22.4F,
//						0.0F, 0.0F, 0.0873F));
		
		leftWingTip = new ModelRenderer(this);
		leftWingTip.setPos(16.8F, 0.0F, 0.0F);
		leftWingBase.addChild(leftWingTip);
		setRotationAngle(leftWingTip, 0.0F, 0.0F, 0.1745F);
		leftWingTip.texOffs(0, 0).addBox(10.8637F, 41.9647F, -10.8F, 14.0F, 3.0F, 48.0F, 0.0F, false);
		leftWingTip.texOffs(24, 34).addBox(11.4637F, 41.9647F, -16.4F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		leftWingTip.texOffs(132, 49).addBox(11.4637F, 41.9647F, 36.6F, 6.0F, 3.0F, 15.0F, 0.0F, false);
		
//		PartDefinition leftWingTip = leftWingBase.addOrReplaceChild("leftWingTip", CubeListBuilder.create()
//				.texOffs(0, 0)
//				.addBox(10.8637F, 41.9647F, -10.8F, 14.0F, 3.0F, 48.0F, new CubeDeformation(0.0F))
//				
//		.texOffs(24, 34).addBox(11.4637F, 41.9647F, -16.4F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
//		.texOffs(132, 49).addBox(11.4637F, 41.9647F, 36.6F, 6.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose
//		.offsetAndRotation(16.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		rightWingBase = new ModelRenderer(this);
		rightWingBase.setPos(-8.4F, -48.8F, -22.4F);
		body.addChild(rightWingBase);
		setRotationAngle(rightWingBase, 0.0F, 0.0F, -0.0873F);
		rightWingBase.texOffs(73, 51).addBox(-20.9848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, 0.0F, true);
		
//		PartDefinition rightWingBase = body.addOrReplaceChild("rightWingBase", CubeListBuilder.create()
//				.texOffs(73, 51)
//				.addBox(-20.9848F, 42.4514F, 0.0F, 17.0F, 6.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.
//				offsetAndRotation(-8.4F, -48.8F, -22.4F, 0.0F, 0.0F, -0.0873F));

		rightWingTip = new ModelRenderer(this);
		rightWingTip.setPos(-16.8F, 0.0F, 0.0F);
		rightWingBase.addChild(rightWingTip);
		setRotationAngle(rightWingTip, 0.0F, 0.0F, -0.1745F);
		rightWingTip.texOffs(0, 51).addBox(-24.8637F, 41.9647F, -10.8F, 14.0F, 3.0F, 45.0F, 0.0F, false);
		rightWingTip.texOffs(0, 34).addBox(-17.8637F, 41.9647F, -16.4F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		rightWingTip.texOffs(124, 31).addBox(-17.8637F, 41.9647F, 33.6F, 6.0F, 3.0F, 15.0F, 0.0F, false);
		
//		PartDefinition rightWingTip = rightWingBase.addOrReplaceChild("rightWingTip", CubeListBuilder.create()
//				.texOffs(0, 51)
//				.addBox(-24.8637F, 41.9647F, -10.8F, 14.0F, 3.0F, 45.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 34)
//		.addBox(-17.8637F, 41.9647F, -16.4F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
//		.texOffs(124, 31)
//		.addBox(-17.8637F, 41.9647F, 33.6F, 6.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose
//		.offsetAndRotation(-16.8F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		head = new ModelRenderer(this);
		head.setPos(0.0F, -40.4F, -19.6F);
		body.addChild(head);
		head.texOffs(0, 0).addBox(-5.2F, 30.0F, -12.0F, 8.0F, 20.0F, 14.0F, 0.0F, false);
		head.texOffs(122, 112).addBox(-7.2F, 33.0F, -11.8F, 12.0F, 14.0F, 12.0F, -1.0F, false);

//		head.texOffs(0, 51).addBox(-4.2F, -7.4F, -13.6F, 8.0F, 16.0F, 14.0F, -2.0F, false);
//		head.texOffs(0, 51).addBox(-4.2F, -9.4F, -11.6F, 8.0F, 16.0F, 14.0F, -2.0F, false);

		headTopHornTip = new ModelRenderer(this);
		headTopHornTip.setPos(-1.0F, 49.4F, -0.4F);
		head.addChild(headTopHornTip);
		setRotationAngle(headTopHornTip, 0.5236F, 0.0F, 0.0F);
		headTopHornTip.texOffs(0, 51).addBox(-4.2F, -7.4F, -13.6F, 8.0F, 16.0F, 14.0F, -2.0F, false);
		
		headBottomHornTip = new ModelRenderer(this);
		headBottomHornTip.setPos(-1.0F, 30.4F, -2.4F);
		head.addChild(headBottomHornTip);
		setRotationAngle(headBottomHornTip, -0.5236F, 0.0F, 0.0F);
		headBottomHornTip.texOffs(0, 51).addBox(-4.2F, -9.4F, -11.6F, 8.0F, 16.0F, 14.0F, -2.0F, false);
		
//		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
//				.texOffs(0, 0)
//				.addBox(-5.2F, 30.0F, -12.0F, 8.0F, 20.0F, 14.0F, new CubeDeformation(-1.0F))
//		.texOffs(122, 112)
//		.addBox(-7.2F, 33.0F, -11.8F, 12.0F, 14.0F, 12.0F, new CubeDeformation(-1.0F)), PartPose
		

//		PartDefinition headTopHornTip = head.addOrReplaceChild("head_r1", CubeListBuilder.create()
//				.texOffs(0, 51)
//				.addBox(-4.2F, -7.4F, -13.6F, 8.0F, 16.0F, 14.0F, new CubeDeformation(-2.0F)), PartPose
//				.offsetAndRotation(-1.0F, 49.4F, -0.4F, //pos
//						0.5236F, 0.0F, 0.0F)); 
//						//setRotationAngle(headTopHornTip, 0.5236F, 0.0F, 0.0F);

//		PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create()
//				.texOffs(0, 51)
//				.addBox(-4.2F, -9.4F, -11.6F, 8.0F, 16.0F, 14.0F, new CubeDeformation(-2.0F)), PartPose
//				.offsetAndRotation(-1.0F, 30.4F, -2.4F, 
//						-0.5236F, 0.0F, 0.0F));
		
		
		
		
		tail = new ModelRenderer(this);
		tail.setPos(0.0F, -48.8F, 2.8F);
		body.addChild(tail);
		setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
		tail.texOffs(0, 99).addBox(-9.8F, 41.8F, 0.0F, 17.0F, 11.0F, 17.0F, 0.0F, false);
		tail.texOffs(68, 112).addBox(-8.4F, 41.8F, 15.8F, 14.0F, 11.0F, 13.0F, -1.0F, false);

		tailtip = new ModelRenderer(this);
		tailtip.setPos(0.0F, 1.4F, 16.8F);
		tail.addChild(tailtip);
		setRotationAngle(tailtip, -0.0873F, 0.0F, 0.0F);
		tailtip.texOffs(0, 127).addBox(-3.0F, 43.0F, 11.2F, 3.0F, 3.0F, 19.0F, 0.0F, false);
		tailtip.texOffs(44, 127).addBox(-3.0F, 43.0F, 31.2F, 3.0F, 3.0F, 18.0F, 0.0F, false);
	
//	PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create()
//			.texOffs(0, 99)
//			.addBox(-9.8F, 41.8F, 0.0F, 17.0F, 11.0F, 17.0F, new CubeDeformation(0.0F))
//	.texOffs(68, 112)
//	.addBox(-8.4F, 41.8F, 15.8F, 14.0F, 11.0F, 13.0F, new CubeDeformation(-1.0F)), PartPose
//	.offsetAndRotation(0.0F, -48.8F, 2.8F,
//			-0.0873F, 0.0F, 0.0F));

//	PartDefinition tailtip = tail.addOrReplaceChild("tailtip", CubeListBuilder.create()
//			.texOffs(0, 127)
//			.addBox(-3.0F, 43.0F, 11.2F, 3.0F, 3.0F, 19.0F, new CubeDeformation(1.0F))
//	.texOffs(44, 127).addBox(-3.0F, 43.0F, 31.2F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose
//	.offsetAndRotation(0.0F, 1.4F, 16.8F, 
//		-0.0873F, 0.0F, 0.0F));
	}
	
	
	
	
	
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

