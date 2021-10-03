package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WightKnightEntityRenderer extends WightEntityRenderer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wight_entity.png");
	
	public WightKnightEntityRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager);
	}
	
	public ResourceLocation getTextureLocation(WightEntity entity) 
	{
		return TEXTURE;
	}
}