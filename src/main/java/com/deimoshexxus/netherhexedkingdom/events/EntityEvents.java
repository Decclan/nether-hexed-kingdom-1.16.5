package com.deimoshexxus.netherhexedkingdom.events;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID)
public class EntityEvents 
{
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event)
	{
		if (event.getName() == null)
			return;
		MobSpawnInfoBuilder spawns = event.getSpawns();
		
		//if (event.getCategory().equals(Biome.Category.NETHER))
		if (event.getCategory().equals(Biome.Category.NETHER))//getCategory().equals(Biomes.SOUL_SAND_VALLEY)
		{
			spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntities.WITHER_SKELETON_HORSE.get(), 3, 2, 3));
			spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntities.VOLCAN_DAEMON_ENTITY.get(), 1, 1, 3));
		} //MobSpawnInfo																								//weight min max
	}
	
	

}
