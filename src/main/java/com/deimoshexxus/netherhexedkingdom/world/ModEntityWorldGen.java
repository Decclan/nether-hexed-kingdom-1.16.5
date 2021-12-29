package com.deimoshexxus.netherhexedkingdom.world;

import java.util.Arrays;
import java.util.List;

import com.deimoshexxus.netherhexedkingdom.config.ConfigHandler;
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
		if (ConfigHandler.WILD_WITHER_SKELETON_SPAWN.get())
		{
			specificNetherBiomes(event, EntityType.WITHER_SKELETON,
					ConfigHandler.WEIGHT_WITHER_SKELETON_SPAWN.get(),
					ConfigHandler.MIN_WITHER_SKELETON_SPAWN.get(),
					ConfigHandler.MAX_WITHER_SKELETON_SPAWN.get(),
					Biomes.NETHER_WASTES);
		}
		if (ConfigHandler.WILD_WITHER_SKELETON_HORSE_SPAWN.get())
		{
			specificNetherBiomes(event, ModEntities.WITHER_SKELETON_HORSE.get(),
					ConfigHandler.WEIGHT_WITHER_SKELETON_HORSE_SPAWN.get(),
					ConfigHandler.MIN_WITHER_SKELETON_HORSE_SPAWN.get(),
					ConfigHandler.MAX_WITHER_SKELETON_HORSE_SPAWN.get(),
					Biomes.NETHER_WASTES);
		}
		if (ConfigHandler.WILD_WITHER_SKELETON_DEATH_RIDER_SPAWN.get())
		{
			specificNetherBiomes(event, ModEntities.WITHER_SKELETON_HORSE_RIDER.get(),
					ConfigHandler.WEIGHT_WITHER_SKELETON_DEATH_RIDER_SPAWN.get(),
					ConfigHandler.MIN_WITHER_SKELETON_DEATH_RIDER_SPAWN.get(),
					ConfigHandler.MAX_WITHER_SKELETON_DEATH_RIDER_SPAWN.get(),
					Biomes.NETHER_WASTES);
		}
		if (ConfigHandler.WILD_HEXED_UNDEAD_HORSE_SPAWN.get())
		{
			specificNetherBiomes(event, ModEntities.UNDEAD_HORSE.get(),
					ConfigHandler.WEIGHT_HEXED_UNDEAD_HORSE_SPAWN.get(),
					ConfigHandler.MIN_HEXED_UNDEAD_HORSE_SPAWN.get(),
					ConfigHandler.MAX_HEXED_UNDEAD_HORSE_SPAWN.get(),
					Biomes.CRIMSON_FOREST);
		}
		if (ConfigHandler.WILD_HEXED_UNDEAD_HORSE_RIDER_SPAWN.get())
		{
			specificNetherBiomes(event, ModEntities.UNDEAD_HORSE_RIDER.get(),
					ConfigHandler.WEIGHT_HEXED_UNDEAD_HORSE_RIDER_SPAWN.get(),
					ConfigHandler.MIN_HEXED_UNDEAD_HORSE_RIDER_SPAWN.get(),
					ConfigHandler.MAX_HEXED_UNDEAD_HORSE_RIDER_SPAWN.get(),
					Biomes.SOUL_SAND_VALLEY);
		}
		
		//specificNetherBiomes(event, EntityType.SKELETON_HORSE, 100, 1, 3, Biomes.NETHER_WASTES); //creatures/animals dont spawn in nether, needs to be monster
			
		specificNetherBiomes(event, ModEntities.VOLCAN_DAEMON_ENTITY.get(),
				80, 1, 3, Biomes.BASALT_DELTAS);
		
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
}
