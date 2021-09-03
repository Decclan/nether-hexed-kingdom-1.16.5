package com.deimoshexxus.netherhexedkingdom.data;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.data.client.ModBlockStateProvider;
import com.deimoshexxus.netherhexedkingdom.data.client.ModItemModelProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators
{
	private DataGenerators() {}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event)
	{
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
		gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
		
		ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, existingFileHelper);
		gen.addProvider(blockTags);
		gen.addProvider(new ModItemTagsProvider(gen, blockTags, existingFileHelper));
		
		gen.addProvider(new ModLootTableProvider(gen));
		
//		gen.addProvider(new ModEntityLootTableProvider(gen));
		
		gen.addProvider(new ModRecipeProvider(gen));
	}

}
