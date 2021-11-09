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
		specificNetherBiomes(event, ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), 50, 1, 3, Biomes.NETHER_WASTES);
		specificNetherBiomes(event, ModEntities.WITHER_SKELETON_HORSE.get(), 40, 1, 3, Biomes.NETHER_WASTES);
		//specificNetherBiomes(event, EntityType.SKELETON_HORSE, 100, 1, 3, Biomes.NETHER_WASTES); //creatures/animals dont spawn in nether, needs to be monster
		specificNetherBiomes(event, EntityType.WITHER_SKELETON, 50, 1, 3, Biomes.BASALT_DELTAS, Biomes.NETHER_WASTES);
		
		specificNetherBiomes(event, ModEntities.UNDEAD_HORSE.get(), 5, 0, 2, Biomes.CRIMSON_FOREST);
		specificNetherBiomes(event, ModEntities.UNDEAD_HORSE_RIDER.get(), 10, 0, 3, Biomes.SOUL_SAND_VALLEY);
		
		specificNetherBiomes(event, ModEntities.VOLCAN_DAEMON_ENTITY.get(), 80, 1, 3, Biomes.BASALT_DELTAS);
		
		specificNetherBiomes(event, ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(), 80, 1, 3, Biomes.WARPED_FOREST);
		specificNetherBiomes(event, ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(), 80, 1, 3, Biomes.WARPED_FOREST);
	}

	@SafeVarargs
	private static void specificNetherBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes)
	{
		boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::location)
				.map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));
		
		if(isBiomeSelected)
		{
			addEntityAllBiomes(event, type, weight, minCount, maxCount);
		}
	}
	
	private static void addEntityAllBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount)
	{
		List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
		base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
	}
	
//	private static void allNetherBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount)
//	{
//		if (event.getCategory().equals(Biome.Category.NETHER))
//	}
}
