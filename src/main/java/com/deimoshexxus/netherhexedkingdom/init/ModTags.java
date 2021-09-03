package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags 
{
	public static final class Blocks
	{
		public static final ITag.INamedTag<Block> ORES_MILITUS = forge("ores/militus");
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_MILITUS = forge("storage_blocks/militus");
		
		public static final ITag.INamedTag<Block> BLOCK_IRON_PLATE = mod("iron_plate");
		public static final ITag.INamedTag<Block> BLOCK_ETERNAL_LIGHT = mod("eternal_light");
		
		public static final ITag.INamedTag<Block> BLOCK_SKELETON_TOP = mod("skeleton_top");
		public static final ITag.INamedTag<Block> BLOCK_SKELETON_BOTTOM = mod("skeleton_bottom");
		
		public static final ITag.INamedTag<Block> BLOCK_BLACKSTONE_FIRESTAND = mod("blackstone_firestand");
		public static final ITag.INamedTag<Block> BLOCK_GOLD_GARGOYLE = mod("gold_gargoyle");
		public static final ITag.INamedTag<Block> BLOCK_BLACKSTONE_GARGOYLE = mod("blackstone_gargoyle");

//		public static final ITag.INamedTag<Block> NETHER_BRICK_PLATE = mod("nether_brick_plate");
//		public static final ITag.INamedTag<Block> NETHER_BRICK_TORCH = mod("nether_brick_torch");
//		public static final ITag.INamedTag<Block> NETHER_BRICK_WALL_TORCH = mod("nether_brick_wall_torch");

		
		private static ITag.INamedTag<Block> forge(String path)
		{
			return BlockTags.bind(new ResourceLocation("forge", path).toString());
		}
		
		private static ITag.INamedTag<Block> mod(String path)
		{
			return BlockTags.bind(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, path).toString());
		}
	}

	public static final class Items
	{
		public static final ITag.INamedTag<Item> ORES_MILITUS = forge("ores/militus");
		public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MILITUS = forge("storage_blocks/militus");

		public static final ITag.INamedTag<Item> INGOTS_MILITUS = forge("ingots/militus");
		public static final ITag.INamedTag<Item> NUGGETS_MILITUS = forge("nuggets/militus");
		
		public static final ITag.INamedTag<Item> BLOCK_IRON_PLATE = mod("iron_plate");
		public static final ITag.INamedTag<Item> BLOCK_ETERNAL_LIGHT = mod("eternal_light");
		
		public static final ITag.INamedTag<Item> BLOCK_SKELETON_TOP = mod("skeleton_top");
		public static final ITag.INamedTag<Item> BLOCK_SKELETON_BOTTOM = mod("skeleton_bottom");
		
		public static final ITag.INamedTag<Item> BLOCK_BLACKSTONE_FIRESTAND = mod("blackstone_firestand");
		public static final ITag.INamedTag<Item> BLOCK_GOLD_GARGOYLE = mod("gold_gargoyle");
		public static final ITag.INamedTag<Item> BLOCK_BLACKSTONE_GARGOYLE = mod("blackstone_gargoyle");
		
		public static final ITag.INamedTag<Item> SHIELD_MILITUS = forge("militus_shield");
		public static final ITag.INamedTag<Item> SHIELD_BONE = forge("bone_shield");

//		public static final ITag.INamedTag<Item> NETHER_BRICK_PLATE = mod("nether_brick_plate");
//		public static final ITag.INamedTag<Item> NETHER_BRICK_TORCH = mod("nether_brick_torch");
	
		
		private static ITag.INamedTag<Item> forge(String path)
		{
			return ItemTags.bind(new ResourceLocation("forge", path).toString());
		}
		
		private static ITag.INamedTag<Item> mod(String path)
		{
			return ItemTags.bind(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, path).toString());
		}
	}
}
