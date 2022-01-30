package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardRangedEntity;
//import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityThreeModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.HexanGuardRangedEntityModel;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HexanGuardRangedEntityRenderer extends BipedRenderer<HexanGuardRangedEntity, SkeletonModel<HexanGuardRangedEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/nether_hexan_guard.png");
	
	public HexanGuardRangedEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new HexanGuardRangedEntityModel(), 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<HexanGuardRangedEntity>(1.02F), new BipedModel<HexanGuardRangedEntity>(1.02F)));
	}
	
	@Override
	public ResourceLocation getTextureLocation(HexanGuardRangedEntity entity) 
	{
		return TEXTURE;
	}
}