package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.render.FaceEaterEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.TestEntityFourRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WightEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WightKnightEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WightTraderEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.TestEntityThreeRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.TestEntityTwoRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WitherSkeletonHorseRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WitherSkeletonHorseRiderRenderer;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NetherHexedKingdomMain.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NetherHexedKingdomMain.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, NetherHexedKingdomMain.MOD_ID);
	
	
	public static void register() 
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		ENTITY_TYPES.register(modEventBus);
		
		ModItems.register();
		ModBlocks.register();
		ModEntities.register();
//		ModStructures.register();
		

	}
	
	public static void registerRenderers()
	{
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WIGHT_ENTITY.get(), WightEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WIGHT_KNIGHT_ENTITY.get(), WightKnightEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WIGHT_TRADER_ENTITY.get(), WightTraderEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FACE_EATER_ENTITY.get(), FaceEaterEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TEST_ENTITY_TWO.get(), TestEntityTwoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TEST_ENTITY_THREE.get(), TestEntityThreeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TEST_ENTITY_FOUR.get(), TestEntityFourRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), WitherSkeletonHorseRiderRenderer::new);

	}

}
