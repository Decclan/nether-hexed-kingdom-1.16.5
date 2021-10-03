package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
//import com.deimoshexxus.netherhexedkingdom.entities.models.TestEntityModel;
import com.deimoshexxus.netherhexedkingdom.entities.models.WightEntityModel;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WightEntityRenderer extends BipedRenderer<WightEntity, BipedModel<WightEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wight_entity.png");
	
	public WightEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new WightEntityModel(), 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<WightEntity>(1.0F), new BipedModel<WightEntity>(1.0F)));
	}
	
	@Override
	public ResourceLocation getTextureLocation(WightEntity entity) 
	{
		return TEXTURE;
	}
}