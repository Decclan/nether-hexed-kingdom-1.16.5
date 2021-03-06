package com.deimoshexxus.netherhexedkingdom.events;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.world.ModEntityWorldGen;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

//import net.minecraft.entity.EntitySpawnPlacementRegistry; //this one
//import net.minecraft.world.spawner.WanderingTraderSpawner;
//import net.minecraft.world.spawner.WorldEntitySpawner; //look into
//import net.minecraft.world.biome.provider.NetherBiomeProvider;
//import net.minecraft.world.biome.MobSpawnInfo.
//import net.minecraft.world.spawner.PhantomSpawner;
//import net.minecraft.world.spawner.AbstractSpawner;

@EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID) //, bus = Mod.EventBusSubscriber.Bus.MOD
public class EntityEvents 
{

	@SubscribeEvent (priority = EventPriority.HIGH)
	public static void onBiomeLoad(final BiomeLoadingEvent event)
	{
		ModEntityWorldGen.onEntitySpawn(event);

		if (event.getName() == null) return;	
	}
}
