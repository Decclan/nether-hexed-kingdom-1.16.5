package com.deimoshexxus.netherhexedkingdom;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.deimoshexxus.netherhexedkingdom.init.Registration;
import com.mojang.serialization.Codec;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
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

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("PREINIT");
        event.enqueueWork(() -> {
//    		ModEntities.registerEntityAttributes();
    		//ModEntityTypes.registerEntitySpawns();
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
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("netherhexedkingdom", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    //SubscribeEvent let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("Server starting FML event");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }
//Structures code
    public void biomeModification(final BiomeLoadingEvent event) 
    {
    	event.setCategory(Category.NETHER);
        event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_RUN_DOWN_HOUSE);
        event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_WATCH_TOWER);
        event.getGeneration().getStructures().add(() -> NetherConfiguredStructures.CONFIGURED_NETHER_PRISON);
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
//          //prevents overworld spawn - doesn't work elif?
//            else if(serverWorld.dimension().equals(World.OVERWORLD))
//            {
//                return;
//            }
            
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(NetherStructures.RUN_DOWN_HOUSE.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.RUN_DOWN_HOUSE.get()));
            tempMap.putIfAbsent(NetherStructures.NETHER_WATCH_TOWER.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_WATCH_TOWER.get()));
            tempMap.putIfAbsent(NetherStructures.NETHER_PRISON.get(), DimensionStructuresSettings.DEFAULTS.get(NetherStructures.NETHER_PRISON.get()));
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
