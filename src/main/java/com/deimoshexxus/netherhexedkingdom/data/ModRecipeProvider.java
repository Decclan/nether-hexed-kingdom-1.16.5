package com.deimoshexxus.netherhexedkingdom.data;

import java.util.function.Consumer;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

//@Mod.EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Bus.MOD)
public class ModRecipeProvider extends RecipeProvider
{

	public ModRecipeProvider(DataGenerator dataGenerator) 
	{
		super(dataGenerator);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) 
	{
		//Items
		
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
		
		ShapedRecipeBuilder.shaped(ModItems.SKELETON_BONE_SHIELD.get())
		.define('#', Items.BONE)
		.define('c', Items.CRIMSON_PLANKS)
		.define('m', ModItems.MILITUS_ALLOY_NUGGET.get())
		.pattern("#m#")
		.pattern("mcm")
		.pattern("#m#")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModItems.MILITUS_ALLOY_SHIELD.get())
		.define('c', Items.CRIMSON_PLANKS)
		.define('#', ModItems.MILITUS_ALLOY_INGOT.get())
		.pattern("# #")
		.pattern("c#c")
		.pattern("# #")
		.unlockedBy("has_item", has(ModItems.MILITUS_ALLOY_INGOT.get()))
		.save(consumer);
		
//		ShapedRecipeBuilder.shaped(ModBlocks.IRON_PLATE_BLOCK.get())
//		.define('#', Items.IRON_NUGGET)
//		.define('a', Items.NETHERRACK)
//		.pattern(" # ")
//		.pattern("#a#")
//		.pattern(" # ")
//		.unlockedBy("has_item", has(Items.IRON_NUGGET))
//		.save(consumer);
		
		ShapedRecipeBuilder.shaped(ModBlocks.BACKSTONE_FIRESTAND_BLOCK.get())
		.define('#', Items.POLISHED_BLACKSTONE)
		.define('m', Items.MAGMA_BLOCK)
		.define('s', Items.POLISHED_BLACKSTONE_BRICK_SLAB)
		.pattern("   ")
		.pattern("#m#")
		.pattern("s#s")
		.unlockedBy("has_item", has(Items.BLACKSTONE))
		.save(consumer);
		
		
		
		//Cooking
		
		CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.MILITUS_ALLOY_ORE.get()), ModItems.MILITUS_ALLOY_INGOT.get(), 0.7F, 200)
		.unlockedBy("has_item", has(ModBlocks.MILITUS_ALLOY_ORE.get()))
		.save(consumer, modId("militus_alloy_ingot_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.MILITUS_ALLOY_ORE.get()), ModItems.MILITUS_ALLOY_INGOT.get(), 0.7F, 100)
		.unlockedBy("has_item", has(ModBlocks.MILITUS_ALLOY_ORE.get()))
		.save(consumer, modId("militus_alloy_ingot_blasting"));

		CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.IRON_PLATE_BLOCK.get()), Items.IRON_INGOT, 0.5F, 200)
		.unlockedBy("has_item", has(ModBlocks.IRON_PLATE_BLOCK.get()))
		.save(consumer, modId("ironplate_ingot_smelting"));
		CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.IRON_PLATE_BLOCK.get()), Items.IRON_INGOT, 0.5F, 100)
		.unlockedBy("has_item", has(ModBlocks.IRON_PLATE_BLOCK.get()))
		.save(consumer, modId("ironplate_ingot_blasting"));
		
		
		
	}
	
	private ResourceLocation modId(String path)
	{
		return new ResourceLocation(NetherHexedKingdomMain.MOD_ID, path);
	}
	
}
