package com.deimoshexxus.netherhexedkingdom.item;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterShieldBlockingLocation 
{
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		
//		itemPropertieShield(ModItems.WITHERED_DEATH_SHIELD.get());
		itemPropertieShield(ModItems.MILITUS_ALLOY_SHIELD.get());

		
	}
	
	private static void itemPropertieShield(Item item) {
		
    	ItemModelsProperties.register(item, new ResourceLocation("blocking"), (p_239421_0_, p_239421_1_, p_239421_2_) -> {
			
			return p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == p_239421_0_ ? 1.0F : 0.0F;
			
		});
		
	}
	
}
