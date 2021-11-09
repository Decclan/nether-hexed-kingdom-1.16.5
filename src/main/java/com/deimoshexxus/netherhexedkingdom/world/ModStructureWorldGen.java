//package com.deimoshexxus.netherhexedkingdom.world;
//
//import com.deimoshexxus.netherhexedkingdom.NetherConfiguredStructures;
//import com.deimoshexxus.netherhexedkingdom.config.ConfigHandler;
//
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//
//public class ModStructureWorldGen
//{
//	public static void onStructureSpawn(final BiomeLoadingEvent event)
//	{
//	    if (ConfigHandler.NETHER_WATCH_TOWER_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_WATCH_TOWER);
//	    }
//	    if (ConfigHandler.NETHER_PRISON_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_PRISON);
//	    }
//	    if (ConfigHandler.NETHER_GREED_MINES_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_GREED_MINES);
//	    }
//	    if (ConfigHandler.NETHER_LOOKOUT_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_LOOKOUT);
//	    }
//	    if (ConfigHandler.NETHER_OUTPOST_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_OUTPOST);
//	    }
//	    if (ConfigHandler.NETHER_BULLION_TEMPLE_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_BULLION_TEMPLE);
//	    }
//	    if (ConfigHandler.NETHER_IRON_CLAD_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_IRON_CLAD);
//	    }
//	    if (ConfigHandler.NETHER_RED_SUN_TOWER_SPAWN.get())
//	    {
//	    	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_RED_SUN_TOWER);
//	    }
//	}
//}
