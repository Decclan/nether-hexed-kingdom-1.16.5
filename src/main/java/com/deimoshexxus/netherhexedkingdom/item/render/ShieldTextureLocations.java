package com.deimoshexxus.netherhexedkingdom.item.render;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ShieldTextureLocations
{
	public static final ShieldRenderInfo RENDER_INFO_WITHER_SHIELD = new ShieldRenderInfo(new ResourceLocation("netherhexedkingdom", "item/withered_death_shield"), new ResourceLocation("spartanshields", "entity/shield_tower_wood_pattern"));
	  

}
