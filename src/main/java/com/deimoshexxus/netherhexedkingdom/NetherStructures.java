package com.deimoshexxus.netherhexedkingdom;

import com.deimoshexxus.netherhexedkingdom.config.ConfigHandler;
import com.deimoshexxus.netherhexedkingdom.structures.NetherBullionTemple;
import com.deimoshexxus.netherhexedkingdom.structures.NetherGreedMines;
import com.deimoshexxus.netherhexedkingdom.structures.NetherIronClad;
import com.deimoshexxus.netherhexedkingdom.structures.NetherLookout;
import com.deimoshexxus.netherhexedkingdom.structures.NetherOutpost;
import com.deimoshexxus.netherhexedkingdom.structures.NetherPrison;
import com.deimoshexxus.netherhexedkingdom.structures.NetherRedSunTower;
import com.deimoshexxus.netherhexedkingdom.structures.NetherVolcanPit;
import com.deimoshexxus.netherhexedkingdom.structures.NetherWatchTower;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;


import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class NetherStructures {

    public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, NetherHexedKingdomMain.MOD_ID);
   
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_WATCH_TOWER = DEFERRED_REGISTRY_STRUCTURE.register("hexed_watch_tower", () -> (new NetherWatchTower(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_PRISON = DEFERRED_REGISTRY_STRUCTURE.register("hexed_prison", () -> (new NetherPrison(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_GREED_MINES = DEFERRED_REGISTRY_STRUCTURE.register("hexed_greed_mines", () -> (new NetherGreedMines(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_LOOKOUT = DEFERRED_REGISTRY_STRUCTURE.register("hexed_lookout", () -> (new NetherLookout(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_OUTPOST = DEFERRED_REGISTRY_STRUCTURE.register("hexed_outpost", () -> (new NetherOutpost(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_BULLION_TEMPLE = DEFERRED_REGISTRY_STRUCTURE.register("hexed_bullion_temple", () -> (new NetherBullionTemple(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_IRON_CLAD = DEFERRED_REGISTRY_STRUCTURE.register("hexed_iron_clad", () -> (new NetherIronClad(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_RED_SUN_TOWER = DEFERRED_REGISTRY_STRUCTURE.register("hexed_red_sun_tower", () -> (new NetherRedSunTower(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_VOLCAN_PIT = DEFERRED_REGISTRY_STRUCTURE.register("hexed_volcan_pit", () -> (new NetherVolcanPit(NoFeatureConfig.CODEC)));
    
    public static void setupStructures() {
//        setupMapSpacingAndLand(
//                STRUCTURE_INSTANCE.get(), /* The instance of the structure */
//                new StructureSeparationSettings(10 /* average distance apart in chunks between spawn attempts */,
//                        5 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
//                        1234567890 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
//                true);

        setupMapSpacingAndLand(
        		NETHER_WATCH_TOWER.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_WATCH_TOWER_MAX.get(),
                		ConfigHandler.NETHER_WATCH_TOWER_MIN.get(),
                        294028347 ),
                true);
        
        setupMapSpacingAndLand(
        		NETHER_PRISON.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_PRISON_MAX.get(),
                		ConfigHandler.NETHER_PRISON_MIN.get(),
                        563854638 ),
                true);
        
        setupMapSpacingAndLand(
        		NETHER_GREED_MINES.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_GREED_MINES_MAX.get(),
                		ConfigHandler.NETHER_GREED_MINES_MIN.get(),
                        674646743 ),
                false);
        
        setupMapSpacingAndLand(
        		NETHER_LOOKOUT.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_LOOKOUT_MAX.get(),
                		ConfigHandler.NETHER_LOOKOUT_MIN.get(),
                        329405624 ),
                false);
        
        setupMapSpacingAndLand(
        		NETHER_OUTPOST.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_OUTPOST_MAX.get(),
                		ConfigHandler.NETHER_OUTPOST_MIN.get(),
                        920485738 ),
                true);
        
        setupMapSpacingAndLand(
        		NETHER_BULLION_TEMPLE.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_BULLION_TEMPLE_MAX.get(),
                		ConfigHandler.NETHER_BULLION_TEMPLE_MIN.get(),
                        2049876748 ),
                false);
        
        setupMapSpacingAndLand(
        		NETHER_IRON_CLAD.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_IRON_CLAD_MAX.get(),
                		ConfigHandler.NETHER_IRON_CLAD_MIN.get(),
                        994756773 ),
                true);
        
        setupMapSpacingAndLand(
        		NETHER_RED_SUN_TOWER.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_RED_SUN_TOWER_MAX.get(),
                		ConfigHandler.NETHER_RED_SUN_TOWER_MIN.get(),
                        529055930 ),
                true);
        
        setupMapSpacingAndLand(
        		NETHER_VOLCAN_PIT.get(),
                new StructureSeparationSettings(ConfigHandler.NETHER_VOLCAN_PIT_MAX.get(),
                		ConfigHandler.NETHER_VOLCAN_PIT_MIN.get(),
                        574783746 ),
                false);
        // Add more structures here and so on
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        if(transformSurroundingLand){
            Structure.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }

        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

            if(structureMap instanceof ImmutableMap){
//            	private final Map<Structure<?>, StructureSeparationSettings> structureConfig;
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
//                settings.getValue().structureSettings().structureConfig();
            }
            else{
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
}
