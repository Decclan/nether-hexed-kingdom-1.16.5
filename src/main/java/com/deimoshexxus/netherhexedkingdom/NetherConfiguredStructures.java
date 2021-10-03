package com.deimoshexxus.netherhexedkingdom;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class NetherConfiguredStructures 
{
	public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE = NetherStructures.RUN_DOWN_HOUSE.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_WATCH_TOWER = NetherStructures.NETHER_WATCH_TOWER.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_PRISON = NetherStructures.NETHER_PRISON.get().configured(IFeatureConfig.NONE);

	public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_run_down_house"), CONFIGURED_RUN_DOWN_HOUSE);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_watch_tower"), CONFIGURED_NETHER_WATCH_TOWER);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_prison"), CONFIGURED_NETHER_PRISON);

        /* add your structure to this to
        * prevent any sort of crash or issue with other mod's custom ChunkGenerators. If they use
        * FlatGenerationSettings.STRUCTURE_FEATURES in it and you don't add your structure to it, the game
        * could crash later when you attempt to add the StructureSeparationSettings to the dimension.
        *
        * (It would also crash with superflat worldtype if you omit the below line
        * and attempt to add the structure's StructureSeparationSettings to the world)
        *
        * Note: If you want your structure to spawn in superflat, remove the FlatChunkGenerator check
        * in StructureTutorialMain.addDimensionalSpacing and then create a superflat world, exit it,
        * and re-enter it and your structures will be spawning. I could not figure out why it needs
        * the restart but honestly, superflat is really buggy and shouldn't be your main focus in my opinion.
        *
        * Requires AccessTransformer ( see resources/META-INF/accesstransformer.cfg )
        */
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.RUN_DOWN_HOUSE.get(), CONFIGURED_RUN_DOWN_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_WATCH_TOWER.get(), CONFIGURED_NETHER_WATCH_TOWER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_PRISON.get(), CONFIGURED_NETHER_PRISON);
    }
}
