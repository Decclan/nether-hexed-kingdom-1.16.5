package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.render.VolcanDaemonEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.HexanGuardMeleeEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WightEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WightKnightEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.WightTraderEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.HexanGuardRangedEntityRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.HexedUndeadHorseRenderer;
import com.deimoshexxus.netherhexedkingdom.entities.render.HexanGuardEntityRenderer;
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
		SoundsHandler.SOUND_EVENTS.register(modEventBus);
		

	}
	
	public static void registerRenderers()
	{
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WIGHT_ENTITY.get(), WightEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WIGHT_KNIGHT_ENTITY.get(), WightKnightEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WIGHT_TRADER_ENTITY.get(), WightTraderEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.VOLCAN_DAEMON_ENTITY.get(), VolcanDaemonEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEXAN_GUARD_ENTITY.get(), HexanGuardEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(), HexanGuardRangedEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(), HexanGuardMeleeEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), WitherSkeletonHorseRiderRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.UNDEAD_HORSE.get(), HexedUndeadHorseRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.UNDEAD_HORSE_RIDER.get(), HexedUndeadHorseRenderer::new);
	}
}
