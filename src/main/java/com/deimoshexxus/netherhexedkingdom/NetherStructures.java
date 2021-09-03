package com.deimoshexxus.netherhexedkingdom;

import com.deimoshexxus.netherhexedkingdom.structures.NetherWatchTower;
import com.deimoshexxus.netherhexedkingdom.structures.RunDownHouseStructure;
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
import java.util.function.Supplier;

import javax.annotation.Nullable;

public class NetherStructures {

    public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, NetherHexedKingdomMain.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("run_down_house", () -> (new RunDownHouseStructure(NoFeatureConfig.CODEC)));

    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_WATCH_TOWER = DEFERRED_REGISTRY_STRUCTURE.register("hexed_watch_tower", () -> (new NetherWatchTower(NoFeatureConfig.CODEC)));

    
    public static void setupStructures() {
        setupMapSpacingAndLand(
                RUN_DOWN_HOUSE.get(), /* The instance of the structure */
                new StructureSeparationSettings(10 /* average distance apart in chunks between spawn attempts */,
                        5 /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1234567890 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);


        setupMapSpacingAndLand(
        		NETHER_WATCH_TOWER.get(),
                new StructureSeparationSettings(10,
                        3,
                        1234567890 ),
                true);
        
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
