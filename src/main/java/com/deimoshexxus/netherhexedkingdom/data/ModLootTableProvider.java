package com.deimoshexxus.netherhexedkingdom.data;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.deimoshexxus.netherhexedkingdom.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdom.init.Registration;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ModLootTableProvider extends LootTableProvider 
{

	public ModLootTableProvider(DataGenerator dataGenerator) 
	{
		super(dataGenerator);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
	{
		return ImmutableList.of(
				Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK),
                Pair.of(ModEntityLootTableProvider::new, LootParameterSets.ENTITY));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker)
	{
       map.forEach((p_218436_2_, p_218436_3_) -> {
          LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_);
       });
	}
	
	public static class ModBlockLootTables extends BlockLootTables
	{
		@Override
		protected void addTables()
		{
			dropSelf(ModBlocks.MILITUS_ALLOY_BLOCK.get());
			dropSelf(ModBlocks.MILITUS_ALLOY_ORE.get());
			dropSelf(ModBlocks.IRON_PLATE_BLOCK.get());
			dropOther(ModBlocks.ETERNAL_LIGHT_BLOCK.get(), Items.GLOWSTONE_DUST.asItem());
			dropOther(ModBlocks.HUMAN_SKELETON_TOP_BLOCK.get(), Items.BONE.asItem());
			dropOther(ModBlocks.HUMAN_SKELETON_BOTTOM_BLOCK.get(), Items.BONE.asItem());
			dropSelf(ModBlocks.BACKSTONE_FIRESTAND_BLOCK.get());
			dropSelf(ModBlocks.GARGOYLE_GOLD_BLOCK.get());
			dropSelf(ModBlocks.GARGOYLE_BLACKSTONE_BLOCK.get());
			dropSelf(ModBlocks.GARGOYLE_QUARTZ_BLOCK.get());
			dropSelf(ModBlocks.GARGOYLE_BASALT_BLOCK.get());
			dropSelf(ModBlocks.GARGOYLE_OBSIDIAN_BLOCK.get());
			dropSelf(ModBlocks.HEXAN_CHISELED_NETHER_BRICKS.get());
			dropSelf(ModBlocks.GILDED_BRICKS_OF_LOST_TIME.get());
			dropSelf(ModBlocks.RED_GILDED_BRICKS_OF_LOST_TIME.get());
			dropSelf(ModBlocks.HEXAN_CHISELED_POLISHED_BLACKSTONE.get());
		}
		
		@Override
		protected Iterable<Block> getKnownBlocks()
		{
			return Registration.BLOCKS.getEntries().stream()
					.map(RegistryObject::get)
					.collect(Collectors.toList());
		}
	}
}
