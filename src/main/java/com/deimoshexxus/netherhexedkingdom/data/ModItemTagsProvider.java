package com.deimoshexxus.netherhexedkingdom.data;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModItems;
import com.deimoshexxus.netherhexedkingdom.init.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider 
{

	public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) 
	{
		super(dataGenerator, blockTagsProvider, NetherHexedKingdomMain.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() 
	{
		copy(ModTags.Blocks.ORES_MILITUS, ModTags.Items.ORES_MILITUS);
		copy(Tags.Blocks.ORES, Tags.Items.ORES);
		copy(ModTags.Blocks.STORAGE_BLOCKS_MILITUS, ModTags.Items.STORAGE_BLOCKS_MILITUS);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.ORES);
		
		copy(ModTags.Blocks.BLOCK_IRON_PLATE, ModTags.Items.BLOCK_IRON_PLATE);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		copy(ModTags.Blocks.BLOCK_ETERNAL_LIGHT, ModTags.Items.BLOCK_ETERNAL_LIGHT);
		copy(Tags.Blocks.GLASS, Tags.Items.GLASS);
		
		copy(ModTags.Blocks.BLOCK_SKELETON_TOP, ModTags.Items.BLOCK_SKELETON_TOP);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		copy(ModTags.Blocks.BLOCK_SKELETON_BOTTOM, ModTags.Items.BLOCK_SKELETON_BOTTOM);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		
		copy(ModTags.Blocks.BLOCK_BLACKSTONE_FIRESTAND, ModTags.Items.BLOCK_BLACKSTONE_FIRESTAND);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		copy(ModTags.Blocks.BLOCK_GOLD_GARGOYLE, ModTags.Items.BLOCK_GOLD_GARGOYLE);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		copy(ModTags.Blocks.BLOCK_BLACKSTONE_GARGOYLE, ModTags.Items.BLOCK_BLACKSTONE_GARGOYLE);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		
//		copy(ModTags.Blocks.NETHER_BRICK_PLATE, ModTags.Items.NETHER_BRICK_PLATE);
//		copy(Tags.Blocks.STONE, Tags.Items.STONE);
//		copy(ModTags.Blocks.NETHER_BRICK_TORCH, ModTags.Items.NETHER_BRICK_TORCH);
//		copy(Tags.Blocks.STONE, Tags.Items.STONE);
		
		tag(ModTags.Items.INGOTS_MILITUS).add(ModItems.MILITUS_ALLOY_INGOT.get());
		tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_MILITUS);
		tag(ModTags.Items.NUGGETS_MILITUS).add(ModItems.MILITUS_ALLOY_NUGGET.get());
		tag(Tags.Items.NUGGETS).addTag(ModTags.Items.NUGGETS_MILITUS);
		
		tag(ModTags.Items.SHIELD_MILITUS).add(ModItems.MILITUS_ALLOY_SHIELD.get());
		tag(Tags.Items.STORAGE_BLOCKS).addTag(ModTags.Items.SHIELD_MILITUS);
		tag(ModTags.Items.SHIELD_BONE).add(ModItems.SKELETON_BONE_SHIELD.get());
		tag(Tags.Items.STORAGE_BLOCKS).addTag(ModTags.Items.SHIELD_BONE);
		
	}
}
