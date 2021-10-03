package com.deimoshexxus.netherhexedkingdom.data.client;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{

	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) 
	{
		super(gen, NetherHexedKingdomMain.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() 
	{
		simpleBlock(ModBlocks.MILITUS_ALLOY_BLOCK.get());
		simpleBlock(ModBlocks.MILITUS_ALLOY_ORE.get());
		simpleBlock(ModBlocks.IRON_PLATE_BLOCK.get());
		axisBlock(ModBlocks.ETERNAL_LIGHT_BLOCK.get(), modLoc("block/eternal_light_side"), modLoc("block/eternal_light_end"));

		getVariantBuilder(ModBlocks.HUMAN_SKELETON_TOP_BLOCK.get())		
			.forAllStates(state -> ConfiguredModel.builder()
					.modelFile(existingModelFile("human_skeleton_top_block"))
					.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() - 90)
					.build());

		getVariantBuilder(ModBlocks.HUMAN_SKELETON_BOTTOM_BLOCK.get())		
			.forAllStates(state -> ConfiguredModel.builder()
					.modelFile(existingModelFile("human_skeleton_bottom_block"))
					.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() - 90)
					.build());
		
		simpleBlock(ModBlocks.BACKSTONE_FIRESTAND_BLOCK.get(), models().getExistingFile(modLoc("block/blackstone_firestand_block")));
		
		getVariantBuilder(ModBlocks.GARGOYLE_GOLD_BLOCK.get())		
		.forAllStates(state -> ConfiguredModel.builder()
				.modelFile(existingModelFile("gargoyle_gold_block"))
				.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() + 90)
				.build());
		
		getVariantBuilder(ModBlocks.GARGOYLE_BLACKSTONE_BLOCK.get())		
		.forAllStates(state -> ConfiguredModel.builder()
				.modelFile(existingModelFile("gargoyle_blackstone_block"))
				.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() + 90)
				.build());
		
		getVariantBuilder(ModBlocks.GARGOYLE_QUARTZ_BLOCK.get())		
		.forAllStates(state -> ConfiguredModel.builder()
				.modelFile(existingModelFile("gargoyle_quartz_block"))
				.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() + 90)
				.build());
		
		getVariantBuilder(ModBlocks.GARGOYLE_BASALT_BLOCK.get())		
		.forAllStates(state -> ConfiguredModel.builder()
				.modelFile(existingModelFile("gargoyle_basalt_block"))
				.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() + 90)
				.build());
		
		getVariantBuilder(ModBlocks.GARGOYLE_OBSIDIAN_BLOCK.get())		
		.forAllStates(state -> ConfiguredModel.builder()
				.modelFile(existingModelFile("gargoyle_obsidian_block"))
				.rotationY((int) state.getValue(BlockStateProperties.FACING).toYRot() + 90)
				.build());
		
//		simpleBlock(ModBlocks.NETHER_BRICK_PRESSURE_PLATE.get(), models().withExistingParent("nether_brick_pressure_plate", mcLoc("block/stone_pressure_plate")));

		//		simpleBlock(ModBlocks.NETHER_BRICK_TORCH.get(), models().torch("nether_brick_torch", modLoc("block/nether_brick_torch")));
//		getVariantBuilder(ModBlocks.NETHER_BRICK_WALL_TORCH.get())
//		.forAllStates(state -> ConfiguredModel.builder()
//				.modelFile(wallTorch("nether_brick_wall_torch", modLoc("block/nether_brick_torch")))
//				.rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90)
//				.build());


	}
	
	//e.g simpleBlock(ModBlocks.CUSTOM_BLOCK.get(), getExistingModel("string_name_of_block"));
//	private ModelFile.ExistingModelFile getExistingModel(String name)
//	{
//		return models().getExistingFile(modLoc(name));
//	}
	
	public ModelFile.ExistingModelFile existingModelFile(String name) 
	{
		return models().getExistingFile(modLoc(name));
	}   //(name, parent, textureKey, texture)
}
