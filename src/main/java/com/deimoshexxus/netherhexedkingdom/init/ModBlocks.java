package com.deimoshexxus.netherhexedkingdom.init;

import java.util.function.Supplier;

import com.deimoshexxus.netherhexedkingdom.block.RotatableBlock;
import com.deimoshexxus.netherhexedkingdom.item.ModItemGroup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModBlocks 
{
	public static final RegistryObject<Block> MILITUS_ALLOY_ORE = register("militus_alloy_ore", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
				.strength(3, 10)
				.harvestLevel(2)
				.sound(SoundType.STONE)
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				));

	public static final RegistryObject<Block> MILITUS_ALLOY_BLOCK = register("militus_alloy_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL)
				.strength(3, 12)
				.sound(SoundType.METAL)
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> IRON_PLATE_BLOCK = register("iron_plate_block", () ->
		new Block(AbstractBlock.Properties.of(Material.METAL)
				.strength(3, 8)
				.sound(SoundType.METAL)
				.harvestLevel(1)
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<RotatedPillarBlock> ETERNAL_LIGHT_BLOCK = register("eternal_light_block", () ->
		new RotatedPillarBlock(AbstractBlock.Properties.of(Material.DECORATION)
				.lightLevel(state -> 14)
				.strength(1, 1)
				.sound(SoundType.GLASS)));
	
	public static final RegistryObject<RotatableBlock> HUMAN_SKELETON_TOP_BLOCK = register("human_skeleton_top_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.CLAY)
				.strength(1, 1)
				.noOcclusion()
				.sound(SoundType.BONE_BLOCK)));

	public static final RegistryObject<RotatableBlock> HUMAN_SKELETON_BOTTOM_BLOCK = register("human_skeleton_bottom_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.CLAY)
				.strength(1, 1)
				.noOcclusion()
				.sound(SoundType.BONE_BLOCK)));

	public static final RegistryObject<Block> BACKSTONE_FIRESTAND_BLOCK = register("blackstone_firestand_block", () ->
		new Block(AbstractBlock.Properties.of(Material.STONE)
				.lightLevel(state -> 11)
				.harvestLevel(1)
				.strength(2, 6)
				.noOcclusion()
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.STONE)));
	
	public static final RegistryObject<RotatableBlock> GARGOYLE_GOLD_BLOCK = register("gargoyle_gold_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.METAL)
				.lightLevel(state -> 3)
				.harvestLevel(2)
				.strength(3, 5)
				.noOcclusion()
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.METAL)));
	
	public static final RegistryObject<RotatableBlock> GARGOYLE_BLACKSTONE_BLOCK = register("gargoyle_blackstone_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.STONE)
				.harvestLevel(1)
				.strength(2, 3)
				.noOcclusion()
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.STONE)));
	
	public static final RegistryObject<RotatableBlock> GARGOYLE_QUARTZ_BLOCK = register("gargoyle_quartz_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.STONE)
				.harvestLevel(1)
				.strength(2, 3)
				.noOcclusion()
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.STONE)));
	
	public static final RegistryObject<RotatableBlock> GARGOYLE_BASALT_BLOCK = register("gargoyle_basalt_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.STONE)
				.harvestLevel(1)
				.strength(2, 3)
				.noOcclusion()
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.STONE)));
	
	public static final RegistryObject<RotatableBlock> GARGOYLE_OBSIDIAN_BLOCK = register("gargoyle_obsidian_block", () ->
		new RotatableBlock(AbstractBlock.Properties.of(Material.STONE)
				.harvestLevel(3)
				.strength(6, 6)
				.noOcclusion()
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.STONE)));

	private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier <T> block)
	{
		return Registration.BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
	{
		RegistryObject<T> ret = registerNoItem(name, block);
		Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModItemGroup.NETHER_HEXED_GROUP)));
		return ret;
	}
	
	static void register() {}
	
	@OnlyIn(Dist.CLIENT)
    public static void registerRenderTypes(FMLClientSetupEvent event) 
	{
		RenderTypeLookup.setRenderLayer(HUMAN_SKELETON_TOP_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(HUMAN_SKELETON_BOTTOM_BLOCK.get(), RenderType.cutout());
    }
}
