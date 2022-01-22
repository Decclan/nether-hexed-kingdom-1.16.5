package com.deimoshexxus.netherhexedkingdom;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class NetherConfiguredStructures 
{
	public static StructureFeature<?, ?> CONFIGURED_NETHER_WATCH_TOWER = NetherStructures.NETHER_WATCH_TOWER.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_PRISON = NetherStructures.NETHER_PRISON.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_GREED_MINES = NetherStructures.NETHER_GREED_MINES.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_LOOKOUT = NetherStructures.NETHER_LOOKOUT.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_OUTPOST = NetherStructures.NETHER_OUTPOST.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_BULLION_TEMPLE = NetherStructures.NETHER_BULLION_TEMPLE.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_IRON_CLAD = NetherStructures.NETHER_IRON_CLAD.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_RED_SUN_TOWER = NetherStructures.NETHER_RED_SUN_TOWER.get().configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_NETHER_VOLCAN_PIT = NetherStructures.NETHER_VOLCAN_PIT.get().configured(IFeatureConfig.NONE);
	
	public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;      
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_watch_tower"), CONFIGURED_NETHER_WATCH_TOWER);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_prison"), CONFIGURED_NETHER_PRISON);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_greed_mines"), CONFIGURED_NETHER_GREED_MINES);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_lookout"), CONFIGURED_NETHER_LOOKOUT);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_outpost"), CONFIGURED_NETHER_OUTPOST);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_bullion_temple"), CONFIGURED_NETHER_BULLION_TEMPLE);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_iron_clad"), CONFIGURED_NETHER_IRON_CLAD);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_red_sun_tower"), CONFIGURED_NETHER_RED_SUN_TOWER);
        Registry.register(registry, new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "configured_hexed_volcan_pit"), CONFIGURED_NETHER_VOLCAN_PIT);
        
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_WATCH_TOWER.get(), CONFIGURED_NETHER_WATCH_TOWER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_PRISON.get(), CONFIGURED_NETHER_PRISON);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_GREED_MINES.get(), CONFIGURED_NETHER_GREED_MINES);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_LOOKOUT.get(), CONFIGURED_NETHER_LOOKOUT);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_OUTPOST.get(), CONFIGURED_NETHER_OUTPOST);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_BULLION_TEMPLE.get(), CONFIGURED_NETHER_BULLION_TEMPLE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_IRON_CLAD.get(), CONFIGURED_NETHER_IRON_CLAD);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_RED_SUN_TOWER.get(), CONFIGURED_NETHER_RED_SUN_TOWER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(NetherStructures.NETHER_VOLCAN_PIT.get(), CONFIGURED_NETHER_VOLCAN_PIT);
    }
}
