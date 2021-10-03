package com.deimoshexxus.netherhexedkingdom.item.render;

import com.deimoshexxus.netherhexedkingdom.init.ModItems;
import com.deimoshexxus.netherhexedkingdom.item.MilitusAlloyShield;

import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlockingHelper 
{
	  public static void registerShieldPropertyOverrides(MilitusAlloyShield item) 
	  {
		    ItemModelsProperties.register((Item)item, new ResourceLocation("blocking"), (stack, world, living) -> 
		        
		        (living != null && living.isUsingItem() && living.getUseItem() == stack) ? 1.0F : 0.0F);
	  }

}
