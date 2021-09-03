package com.deimoshexxus.netherhexedkingdom.init;

import java.util.function.Supplier;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.block.RotatableBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.AbstractPressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.particles.ParticleTypes;
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
				.harvestTool(ToolType.PICKAXE)));

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
		
//	public static final RegistryObject<NetherBrickPressurePlate> NETHER_BRICK_PRESSURE_PLATE = register("nether_brick_pressure_plate", () ->
//			new NetherBrickPressurePlate(AbstractBlock.Properties.of(Material.DECORATION)
//					.strength(2, 2)
//					.sound(SoundType.NETHER_BRICKS)));
	
//	public static final RegistryObject<Block> NETHER_BRICK_PRESSURE_PLATE = register("nether_brick_pressure_plate", () -> 
//			new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.STONE)
//            .harvestLevel(2)
//            .requiresCorrectToolForDrops()
//            .harvestTool(ToolType.PICKAXE)
//            .strength(2, 2)));
	
//    public static final RegistryObject<TorchBlock> NETHER_BRICK_TORCH = register("nether_brick_torch", () -> 
//    		new TorchBlock(AbstractBlock.Properties.of(Material.DECORATION)
//                    .noCollission()
//                    .strength(0)
//                    .lightLevel(state -> 14)
//                    .sound(SoundType.STONE),
//                    ParticleTypes.FLAME));
////    				bro -> getNetherBrickTorchItem());
//    
//    public static final RegistryObject<WallTorchBlock> NETHER_BRICK_WALL_TORCH = registerNoItem("nether_brick_wall_torch", () ->
//    		new WallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION)
//    				.noCollission()
//    				.strength(0)
//    				.lightLevel(state -> 14)
//    				.sound(SoundType.STONE),
////    				.dropsLike(NETHER_BRICK_TORCH.get()),
//    				ParticleTypes.FLAME));
    

	
	
	
//	private static BlockRegistryObject <T extends Block> Supplier(BlockItem) defaultItem(BlockRegistryObject<T> block)
//	{
//		
//	}
//	
//    private static Supplier<BlockItem> getNetherBrickTorchItem() {
//        return () -> new WallOrFloorItem(NETHER_BRICK_TORCH.get(), NETHER_BRICK_WALL_TORCH.get(), new Item.Properties());
//    }
	
	private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier <T> block)
	{
		return Registration.BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
	{
		RegistryObject<T> ret = registerNoItem(name, block);
		Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
		return ret;
	}
	
	static void register() {}
	
	@OnlyIn(Dist.CLIENT)
    public static void registerRenderTypes(FMLClientSetupEvent event) 
	{
		RenderTypeLookup.setRenderLayer(HUMAN_SKELETON_TOP_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(HUMAN_SKELETON_BOTTOM_BLOCK.get(), RenderType.cutout());
//        RenderTypeLookup.setRenderLayer(NETHER_BRICK_TORCH.get(), RenderType.cutout());
//        RenderTypeLookup.setRenderLayer(NETHER_BRICK_WALL_TORCH.get(), RenderType.cutout());
    }
}
