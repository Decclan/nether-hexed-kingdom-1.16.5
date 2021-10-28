package com.deimoshexxus.netherhexedkingdom.world;

import java.util.Arrays;
import java.util.List;

import com.deimoshexxus.netherhexedkingdom.init.ModEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModEntityWorldGen 
{
	public static void onEntitySpawn(final BiomeLoadingEvent event)
	{
		specificNetherBiomes(event, ModEntities.WIGHT_ENTITY.get(), 100, 8, 16, Biomes.NETHER_WASTES);
	}

	@SafeVarargs
	private static void specificNetherBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes)
	{
		boolean isBiomeSelected = Arrays.stream(biomes)
				.map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));
		
		if(isBiomeSelected)
		{
			addEntityAllBiomes(event, type, weight, minCount, maxCount);
		}
	}
	
	private static void addEntityAllBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount)
	{
		List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
//		base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
	}
	
//	private static void allNetherBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount)
//	{
//		if (event.getCategory().equals(Biome.Category.NETHER))
//	}
}
