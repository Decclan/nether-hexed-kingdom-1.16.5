package com.deimoshexxus.netherhexedkingdom.entities.render;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.HexedUndeadHorseEntity;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.deimoshexxus.netherhexedkingdom.entities.render.layers.HexedUndeadHorseArmorRenderer;

@OnlyIn(Dist.CLIENT)
public class HexedUndeadHorseRenderer extends AbstractHorseRenderer<HexedUndeadHorseEntity, HorseModel<HexedUndeadHorseEntity>>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/hexed_undead_horse.png");

//	private static final RenderType GLOW = RenderType.eyes(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "textures/entity/wither_skeleton_horse_redeyes.png"));
	
	public HexedUndeadHorseRenderer(EntityRendererManager rendererManager) 
	{
		super(rendererManager, new HorseModel<HexedUndeadHorseEntity>(0.0F), 1.1F);
		this.addLayer(new HexedUndeadHorseArmorRenderer(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(HexedUndeadHorseEntity entity) 
	{
		return TEXTURE;
	}
}