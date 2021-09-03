package com.deimoshexxus.netherhexedkingdom.data.client;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) 
	{
		super(generator, NetherHexedKingdomMain.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		withExistingParent("militus_alloy_block", modLoc("block/militus_alloy_block"));
		withExistingParent("militus_alloy_ore", modLoc("block/militus_alloy_ore"));
		
		withExistingParent("iron_plate_block", modLoc("block/iron_plate_block"));
		withExistingParent("eternal_light_block", modLoc("block/eternal_light_block"));
		
		withExistingParent("human_skeleton_top_block", modLoc("block/human_skeleton_top_block"));
		withExistingParent("human_skeleton_bottom_block", modLoc("block/human_skeleton_bottom_block"));

		withExistingParent("blackstone_firestand_block", modLoc("block/blackstone_firestand_block"));
		withExistingParent("gargoyle_gold_block", modLoc("block/gargoyle_gold_block"));
		withExistingParent("gargoyle_blackstone_block", modLoc("block/gargoyle_blackstone_block"));

		
//		withExistingParent("nether_brick_pressure_plate", modLoc("block/nether_brick_pressure_plate"));
//		withExistingParent("nether_brick_torch", modLoc("block/nether_brick_torch"));

		
		
		ModelFile militusShieldModel = getExistingFile(modLoc("block/militus_alloy_shield"));
		
		ModelFile boneShieldModel = getExistingFile(modLoc("block/skeleton_bone_shield"));
		
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		
		builder(itemGenerated, "militus_alloy_ingot");  //extracted method of get builder
		builder(itemGenerated, "militus_alloy_nugget");
		
		builderCustom(militusShieldModel, "militus_alloy_shield");
		builderCustom(boneShieldModel, "skeleton_bone_shield");

	}

	private void builderCustom(ModelFile itemGenerated, String name) {
		getBuilder(name).parent(itemGenerated);
	}
	
	private void builder(ModelFile itemGenerated, String name) {
		getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
	}
}
