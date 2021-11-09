package com.deimoshexxus.netherhexedkingdom;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.deimoshexxus.netherhexedkingdom.config.ConfigHandler;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;
import com.deimoshexxus.netherhexedkingdom.init.Registration;
import com.mojang.serialization.Codec;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(NetherHexedKingdomMain.MOD_ID)

//@Mod.EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Bus.MOD)
public class NetherHexedKingdomMain 
{
	
	public static final String MOD_ID = "netherhexedkingdom";
    public static final Logger LOGGER = LogManager.getLogger();

    public NetherHexedKingdomMain() 
    {
    	Registration.register();
    	
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	NetherStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);

        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
    	
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::client);

        ModLoadingContext.get()
        	.registerConfig(Type.COMMON, ConfigHandler.SPEC, "netherhexedkingdom-common.toml");        
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("PREINIT");
        event.enqueueWork(() -> {
    		ModEntities.registerEntitySpawns();
            NetherStructures.setupStructures();
            NetherConfiguredStructures.registerConfiguredStructures();

            LOGGER.info("Sounds Added");
    	});    
     }

    private void client(final FMLClientSetupEvent event) 
    {
    	Registration.registerRenderers();
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("netherhexedkingdom", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("Server starting FML event");
    }

//Structures code
    public void biomeModification(final BiomeLoadingEvent event) 
    {
//    	RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
//    	event.setCategory(Category.NETHER);

    	if (event.getName().equals(Biomes.NETHER_WASTES.getRegistryName()))
    	{
	        if (ConfigHandler.NETHER_WATCH_TOWER_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_WATCH_TOWER);
	        }
	        if (ConfigHandler.NETHER_PRISON_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_PRISON);
	        }
	        if (ConfigHandler.NETHER_GREED_MINES_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_GREED_MINES);
	        }
	        if (ConfigHandler.NETHER_LOOKOUT_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_LOOKOUT);
	        }
	        if (ConfigHandler.NETHER_OUTPOST_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_OUTPOST);
	        }
	        if (ConfigHandler.NETHER_BULLION_TEMPLE_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_BULLION_TEMPLE);
	        }
	        if (ConfigHandler.NETHER_IRON_CLAD_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_IRON_CLAD);
	        }
	        if (ConfigHandler.NETHER_RED_SUN_TOWER_SPAWN.get())
	        {
	        	event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_RED_SUN_TOWER);
	        }
    	}	        
    }
    
    public Map<Structure<?>, StructureSeparationSettings> structureConfig() {
        return this.structureConfig();
     }
    
    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
            	NetherHexedKingdomMain.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }
            //prevents superflat spawn
            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                serverWorld.dimension().equals(World.OVERWORLD)){
                return;
            }
            
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
           
            if (ConfigHandler.NETHER_WATCH_TOWER_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_WATCH_TOWER.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_WATCH_TOWER.get()));
            }
            if (ConfigHandler.NETHER_PRISON_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_PRISON.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_PRISON.get()));
            }
            if (ConfigHandler.NETHER_GREED_MINES_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_GREED_MINES.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_GREED_MINES.get()));
            }
            if (ConfigHandler.NETHER_LOOKOUT_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_LOOKOUT.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_LOOKOUT.get()));
            }
            if (ConfigHandler.NETHER_OUTPOST_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_OUTPOST.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_OUTPOST.get()));
            }
            if (ConfigHandler.NETHER_BULLION_TEMPLE_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_BULLION_TEMPLE.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_BULLION_TEMPLE.get()));
            }
            if (ConfigHandler.NETHER_IRON_CLAD_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_IRON_CLAD.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_IRON_CLAD.get()));
            }
            if (ConfigHandler.NETHER_RED_SUN_TOWER_SPAWN.get())
            {
            	tempMap.putIfAbsent(NetherStructures.NETHER_RED_SUN_TOWER.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_RED_SUN_TOWER.get()));
            }
           
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
   }
   
 // Registration helper
    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) 
    {
        entry.setRegistryName(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, registryKey));
        registry.register(entry);
        return entry;
    }
}
