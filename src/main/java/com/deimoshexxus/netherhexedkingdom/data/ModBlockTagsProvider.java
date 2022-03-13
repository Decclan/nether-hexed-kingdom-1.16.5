package com.deimoshexxus.netherhexedkingdom.data;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdom.init.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider 
{

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) 
	{
		super(generatorIn, NetherHexedKingdomMain.MOD_ID, existingFileHelper);
		
	}

	@Override
	protected void addTags() 
	{
		tag(ModTags.Blocks.ORES_MILITUS).add(ModBlocks.MILITUS_ALLOY_ORE.get());
		tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_MILITUS);
		tag(ModTags.Blocks.STORAGE_BLOCKS_MILITUS).add(ModBlocks.MILITUS_ALLOY_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_MILITUS);
		
		tag(ModTags.Blocks.BLOCK_IRON_PLATE).add(ModBlocks.IRON_PLATE_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_IRON_PLATE);
		
		tag(ModTags.Blocks.BLOCK_ETERNAL_LIGHT).add(ModBlocks.ETERNAL_LIGHT_BLOCK.get());
		tag(Tags.Blocks.GLASS).addTag(ModTags.Blocks.BLOCK_ETERNAL_LIGHT);
		
		tag(ModTags.Blocks.BLOCK_SKELETON_TOP).add(ModBlocks.HUMAN_SKELETON_TOP_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_SKELETON_TOP);
		tag(ModTags.Blocks.BLOCK_SKELETON_BOTTOM).add(ModBlocks.HUMAN_SKELETON_BOTTOM_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_SKELETON_BOTTOM);

		tag(ModTags.Blocks.BLOCK_BLACKSTONE_FIRESTAND).add(ModBlocks.BACKSTONE_FIRESTAND_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_BLACKSTONE_FIRESTAND);
		
		tag(ModTags.Blocks.BLOCK_GOLD_GARGOYLE).add(ModBlocks.GARGOYLE_GOLD_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_GOLD_GARGOYLE);
		tag(ModTags.Blocks.BLOCK_BLACKSTONE_GARGOYLE).add(ModBlocks.GARGOYLE_BLACKSTONE_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_BLACKSTONE_GARGOYLE);
		tag(ModTags.Blocks.BLOCK_QUARTZ_GARGOYLE).add(ModBlocks.GARGOYLE_QUARTZ_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_QUARTZ_GARGOYLE);
		tag(ModTags.Blocks.BLOCK_BASALT_GARGOYLE).add(ModBlocks.GARGOYLE_BASALT_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_BASALT_GARGOYLE);
		tag(ModTags.Blocks.BLOCK_OBSIDIAN_GARGOYLE).add(ModBlocks.GARGOYLE_OBSIDIAN_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_OBSIDIAN_GARGOYLE);

		tag(ModTags.Blocks.BLOCK_HEXAN_CHISELED_NETHER_BRICK).add(ModBlocks.HEXAN_CHISELED_NETHER_BRICKS.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCK_HEXAN_CHISELED_NETHER_BRICK);

		
		
//		tag(ModTags.Blocks.NETHER_BRICK_PLATE).add(ModBlocks.NETHER_BRICK_PRESSURE_PLATE.get());
//		tag(Tags.Blocks.STONE).addTag(ModTags.Blocks.NETHER_BRICK_PLATE);
//		
//		tag(ModTags.Blocks.NETHER_BRICK_TORCH).add(ModBlocks.NETHER_BRICK_TORCH.get());
//		tag(Tags.Blocks.STONE).addTag(ModTags.Blocks.NETHER_BRICK_TORCH);
//		tag(ModTags.Blocks.NETHER_BRICK_WALL_TORCH).add(ModBlocks.NETHER_BRICK_WALL_TORCH.get());
//		tag(Tags.Blocks.STONE).addTag(ModTags.Blocks.NETHER_BRICK_WALL_TORCH);
		
	}

}
