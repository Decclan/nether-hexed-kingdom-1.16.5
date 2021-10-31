//package com.deimoshexxus.netherhexedkingdom.item.render;
//
//
//import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
//import com.deimoshexxus.netherhexedkingdom.item.models.BaseShieldModel;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.vertex.IVertexBuilder;
//import net.minecraft.client.renderer.IRenderTypeBuffer;
//import net.minecraft.client.renderer.ItemRenderer;
//import net.minecraft.client.renderer.model.ItemCameraTransforms;
//import net.minecraft.client.renderer.model.RenderMaterial;
//import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class ShieldRenderer extends ItemStackTileEntityRenderer {
//	
//	private final ShieldRenderInfo renderInfo;
//    private final BaseShieldModel shieldModel;
//    
//    public ShieldRenderer() {
//    	
//    	this.renderInfo = ShieldTextureLocations.RENDER_INFO_WITHER_SHIELD;
//        this.shieldModel = new BaseShieldModel();
//        
//    }
//    
//    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, 
//								IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
//    	
//    	matrixStack.pushPose();
//    	matrixStack.scale(1.0F, -1.0F, -1.0F);
//    	
//        RenderMaterial material = this.renderInfo.getMaterialNoPattern();
//        
//    	
//    	final IVertexBuilder vertexBuilder = ItemRenderer.getFoilBuffer(buffer, 
//    						this.shieldModel.renderType(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/item/withered_death_shield.png")), false, stack.hasFoil());
//    	
//        this.shieldModel.getHandle().render(matrixStack, vertexBuilder, combinedLight, combinedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
//        this.shieldModel.getMainPlate().render(matrixStack, vertexBuilder, combinedLight, combinedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
//        this.shieldModel.renderExtraParts(matrixStack, vertexBuilder, combinedLight, combinedOverlay);
//
//    	
////    	this.shieldModel.renderToBuffer(matrixStack, vertexBuilder, combinedLight, combinedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
//    	
//    	matrixStack.popPose();
//    	
//    	
////        if (item == Items.SHIELD) {
////            boolean flag = stack.getTagElement("BlockEntityTag") != null;
////            matrixStack.pushPose();
////            matrixStack.scale(1.0F, -1.0F, -1.0F);
////            RenderMaterial rendermaterial = flag ? ModelBakery.SHIELD_BASE : ModelBakery.NO_PATTERN_SHIELD;
////            IVertexBuilder ivertexbuilder = rendermaterial.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.shieldModel.renderType(rendermaterial.atlasLocation()), true, stack.hasFoil()));
////            this.shieldModel.getHandle().render(matrixStack, ivertexbuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
////            if (flag) {
////               List<Pair<BannerPattern, DyeColor>> list = BannerTileEntity.createPatterns(ShieldItem.getColor(stack), BannerTileEntity.getItemPatterns(stack));
////               BannerTileEntityRenderer.renderPatterns(matrixStack, buffer, combinedLight, combinedOverlay, this.shieldModel.getMainPlate(), rendermaterial, false, list, stack.hasFoil());
////            } else {
////               this.shieldModel.getMainPlate().render(matrixStack, ivertexbuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
////            }
////        }
//    }	 
//
//    
//
//}