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
		public static final ITag.INamedTag<Block> BLOCK_QUARTZ_GARGOYLE = mod("quartz_gargoyle");
		public static final ITag.INamedTag<Block> BLOCK_BASALT_GARGOYLE = mod("basalt_gargoyle");
		public static final ITag.INamedTag<Block> BLOCK_OBSIDIAN_GARGOYLE = mod("obsidian_gargoyle");
		
		public static final ITag.INamedTag<Block> BLOCK_HEXAN_CHISELED_NETHER_BRICK = mod("hexan_chiseled_nether_bricks");
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
		//BlockItems
		public static final ITag.INamedTag<Item> ORES_MILITUS = forge("ores/militus");
		public static final ITag.INamedTag<Item> STORAGE_BLOCKS_MILITUS = forge("storage_blocks/militus");
		
		public static final ITag.INamedTag<Item> BLOCK_IRON_PLATE = mod("iron_plate");
		public static final ITag.INamedTag<Item> BLOCK_ETERNAL_LIGHT = mod("eternal_light");
		
		public static final ITag.INamedTag<Item> BLOCK_SKELETON_TOP = mod("skeleton_top");
		public static final ITag.INamedTag<Item> BLOCK_SKELETON_BOTTOM = mod("skeleton_bottom");
		
		public static final ITag.INamedTag<Item> BLOCK_BLACKSTONE_FIRESTAND = mod("blackstone_firestand");
		public static final ITag.INamedTag<Item> BLOCK_GOLD_GARGOYLE = mod("gold_gargoyle");
		public static final ITag.INamedTag<Item> BLOCK_BLACKSTONE_GARGOYLE = mod("blackstone_gargoyle");
		public static final ITag.INamedTag<Item> BLOCK_QUARTZ_GARGOYLE = mod("quartz_gargoyle");
		public static final ITag.INamedTag<Item> BLOCK_BASALT_GARGOYLE = mod("basalt_gargoyle");
		public static final ITag.INamedTag<Item> BLOCK_OBSIDIAN_GARGOYLE = mod("obsidian_gargoyle");

		public static final ITag.INamedTag<Item> BLOCK_HEXAN_CHISELED_NETHER_BRICK = mod("hexan_chiseled_nether_bricks");
		
		//ItemItems
		public static final ITag.INamedTag<Item> INGOTS_MILITUS = forge("ingots/militus");
		public static final ITag.INamedTag<Item> NUGGETS_MILITUS = forge("nuggets/militus");
		
		public static final ITag.INamedTag<Item> CLUMPS_GOLD = forge("clumps/gold");
		public static final ITag.INamedTag<Item> CLUMPS_IRON = forge("clumps/iron");
		
		public static final ITag.INamedTag<Item> FRAGMENT_BUNDLE_NETHERITE = forge("fragment/bundle_netherite");
		public static final ITag.INamedTag<Item> FRAGMENT_NETHERITE = forge("fragment/netherite");
		public static final ITag.INamedTag<Item> OXIDE_NETHERITE = forge("dusts/netherite");
		
		public static final ITag.INamedTag<Item> COINS_IMPERIAL = forge("coins/imperial");
		
		public static final ITag.INamedTag<Item> SHIELD_MILITUS = forge("militus_shield");
		public static final ITag.INamedTag<Item> SHIELD_BONE = forge("bone_shield");
		public static final ITag.INamedTag<Item> SHIELD_WITHERED = forge("withered_shield");

		public static final ITag.INamedTag<Item> BOOTS_MILITUS = forge("militus_boots");
		public static final ITag.INamedTag<Item> CHESTPLATE_MILITUS = forge("militus_chestplate");
		public static final ITag.INamedTag<Item> LEGGINGS_MILITUS = forge("militus_leggings");
		public static final ITag.INamedTag<Item> HELMET_MILITUS = forge("militus_helmet");
		
		
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
