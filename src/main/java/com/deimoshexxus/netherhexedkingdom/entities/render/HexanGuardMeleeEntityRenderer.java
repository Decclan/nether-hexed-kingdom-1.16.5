package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardMeleeEntity;
import com.deimoshexxus.netherhexedkingdom.entities.models.HexanGuardMeleeEntityModel;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HexanGuardMeleeEntityRenderer extends BipedRenderer<HexanGuardMeleeEntity, SkeletonModel<HexanGuardMeleeEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/nether_hexan_guard.png");
	
	public HexanGuardMeleeEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new HexanGuardMeleeEntityModel(), 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<HexanGuardMeleeEntity>(1.0F), new BipedModel<HexanGuardMeleeEntity>(1.0F)));
	}
	
	@Override
	public ResourceLocation getTextureLocation(HexanGuardMeleeEntity entity) 
	{
		return TEXTURE;
	}
}