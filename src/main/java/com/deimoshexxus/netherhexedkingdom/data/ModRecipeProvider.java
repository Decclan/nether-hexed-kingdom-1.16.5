package com.deimoshexxus.netherhexedkingdom.data;

import java.util.function.Consumer;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModRecipeProvider extends RecipeProvider
{
	public ModRecipeProvider(DataGenerator dataGenerator) 
	{
		super(dataGenerator);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) 
	{
		//Items//
		
		ShapelessRecipeBuilder.shapeless(ModItems.MILITUS_ALLOY_INGOT.get(), 9)
		.requires(ModBlocks.MILITUS_ALLOY_BLOCK.get())
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModBlocks.MILITUS_ALLOY_BLOCK.get())
		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
		.pattern("###")
		.pattern("###")
		.pattern("###")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_INGOT.get())
		.define('#', ModItems.MILITUS_ALLOY_NUGGET.get())
		.pattern("###")
		.pattern("###")
		.pattern("###")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_NUGGET.get()))
		.save(consumer, "militus_ingot_from_nuggets");

		ShapelessRecipeBuilder.shapeless(ModItems.MILITUS_ALLOY_NUGGET.get(), 9)
		.requires(ModItems.MILITUS_ALLOY_INGOT.get())
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
//		ShapelessRecipeBuilder.shapeless(Items.GOLD_INGOT, 4)
//		.requires(ModItems.GOLD_CLUMP.get())
//		.unlockedBy("has_item", has(ModItems.GOLD_CLUMP.get()))
//		.save(consumer, "gold_ingots_from_clump");
		
		ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET, 4)
		.requires(ModItems.IRON_CLUMP.get())
		.unlockedBy("has_item", has(ModItems.IRON_CLUMP.get()))
		.save(consumer, "iron_nuggets_from_clump");
		
		ShapelessRecipeBuilder.shapeless(Items.NETHERITE_SCRAP, 1)
		.requires(ModItems.NETHERITE_FRAGMENT_BUNDLE.get(), 6)
		.unlockedBy("has_item", has(ModItems.NETHERITE_FRAGMENT.get()))
		.save(consumer, "netherite_scrap_from_bundle");
		
		ShapelessRecipeBuilder.shapeless(ModItems.NETHERITE_FRAGMENT_BUNDLE.get(), 1)
		.requires(ModItems.NETHERITE_FRAGMENT.get(), 4)
		.unlockedBy("has_item", has(ModItems.NETHERITE_FRAGMENT.get()))
		.save(consumer, "netherite_bundle_from_fragments");
		
		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_BOOTS.get())
		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
		.pattern("# #")
		.pattern("# #")
		.pattern("   ")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_CHESTPLATE.get())
		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
		.pattern("# #")
		.pattern("###")
		.pattern("###")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_LEGGINGS.get())
		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
		.pattern("###")
		.pattern("# #")
		.pattern("# #")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_HELMET.get())
		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
		.pattern("###")
		.pattern("# #")
		.pattern("   ")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
//		ShapedRecipeBuilder.shaped(ModItems.SKELETON_BONE_SHIELD.get())
//		.define('#', Items.BONE)
//		.define('c', Items.CRIMSON_PLANKS)
//		.define('m', ModItems.MILITUS_ALLOY_NUGGET.get())
//		.pattern("#m#")
//		.pattern("mcm")
//		.pattern("#m#")
//		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
//		.save(consumer);
		
//		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_SHIELD.get())
//		.define('c', Items.CRIMSON_PLANKS)
//		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
//		.pattern("# #")
//		.pattern("c#c")
//		.pattern("# #")
//		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
//		.save(consumer);
		
		//Blocks//
		
		ShapedRecipeBuilder.shaped(ModBlocks.IRON_PLATE_BLOCK.get())
		.define('#', Items.IRON_NUGGET)
		.define('a', Items.CRIMSON_PLANKS)
		.pattern(" # ")
		.pattern("#a#")
		.pattern(" # ")
		.unlockedBy("has_item", has(Items.CRIMSON_PLANKS))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModBlocks.BACKSTONE_FIRESTAND_BLOCK.get())
		.define('#', Items.POLISHED_BLACKSTONE)
		.define('m', Items.MAGMA_BLOCK)
		.define('s', Items.POLISHED_BLACKSTONE_BRICK_SLAB)
		.pattern("   ")
		.pattern("#m#")
		.pattern("s#s")
		.unlockedBy("has_item", has(Items.BLACKSTONE))
		.save(consumer);

		ShapedRecipeBuilder.shaped(ModBlocks.HEXAN_CHISELED_NETHER_BRICKS.get())
		.define('i', ModItems.MILITUS_ALLOY_NUGGET.get())
		.define('#', Items.NETHER_BRICK_SLAB)
		.pattern(" # ")
		.pattern(" i ")
		.pattern(" # ")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_NUGGET.get()))
		.save(consumer);
		
		
		//Cooking//
		CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.MILITUS_ALLOY_ORE.get()), ModItems.MILITUS_ALLOY_INGOT.get(), 0.7F, 200)
		.unlockedBy("has_item", has(ModBlocks.MILITUS_ALLOY_ORE.get()))
		.save(consumer, modId("militus_alloy_ingot_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.MILITUS_ALLOY_ORE.get()), ModItems.MILITUS_ALLOY_INGOT.get(), 0.7F, 100)
		.unlockedBy("has_item", has(ModBlocks.MILITUS_ALLOY_ORE.get()))
		.save(consumer, modId("militus_alloy_ingot_blasting"));

		CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.GARGOYLE_GOLD_BLOCK.get()), Items.GOLD_BLOCK, 0.8F, 350)
		.unlockedBy("has_item", has(ModBlocks.GARGOYLE_GOLD_BLOCK.get()))
		.save(consumer, modId("gold_clump_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.GARGOYLE_GOLD_BLOCK.get()), Items.GOLD_BLOCK, 0.7F, 300)
		.unlockedBy("has_item", has(ModBlocks.GARGOYLE_GOLD_BLOCK.get()))
		.save(consumer, modId("gold_clump_blasting"));
		
		CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.IRON_PLATE_BLOCK.get()), ModItems.IRON_CLUMP.get(), 0.8F, 250)
		.unlockedBy("has_item", has(ModBlocks.IRON_PLATE_BLOCK.get()))
		.save(consumer, modId("iron_clump_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.IRON_PLATE_BLOCK.get()), ModItems.IRON_CLUMP.get(), 0.7F, 200)
		.unlockedBy("has_item", has(ModBlocks.IRON_PLATE_BLOCK.get()))
		.save(consumer, modId("iron_clump_blasting"));
		
		CookingRecipeBuilder.smelting(Ingredient.of(ModItems.NETHERITE_OXIDE.get()), ModItems.NETHERITE_FRAGMENT.get(), 0.9F, 400)
		.unlockedBy("has_item", has(ModItems.NETHERITE_OXIDE.get()))
		.save(consumer, modId("netherite_oxide_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModItems.NETHERITE_OXIDE.get()), ModItems.NETHERITE_FRAGMENT.get(), 0.7F, 300)
		.unlockedBy("has_item", has(ModItems.NETHERITE_OXIDE.get()))
		.save(consumer, modId("netherite_oxide_blasting"));
		
		CookingRecipeBuilder.smelting(Ingredient.of(ModItems.IMPERIAL_COINS.get()), Items.GOLD_NUGGET, 0.4F, 200)
		.unlockedBy("has_item", has(ModItems.IMPERIAL_COINS.get()))
		.save(consumer, modId("imperial_coins_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModItems.IMPERIAL_COINS.get()), Items.GOLD_NUGGET, 0.3F, 150)
		.unlockedBy("has_item", has(ModItems.IMPERIAL_COINS.get()))
		.save(consumer, modId("imperial_coins_blasting"));
	}
	
	private ResourceLocation modId(String path)
	{
		return new ResourceLocation(NetherHexedKingdomMain.MOD_ID, path);
	}
	
}
