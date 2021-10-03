package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WightKnightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WightTraderEntity;
import com.deimoshexxus.netherhexedkingdom.entities.VolcanDaemon;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardMeleeEntity;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardRangedEntity;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseRider;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;

@Mod.EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Bus.MOD)
public class ModEntities
{
	public static final RegistryObject<EntityType<WightEntity>> WIGHT_ENTITY = Registration.ENTITY_TYPES.register("wight_entity", 
			() -> EntityType.Builder.<WightEntity>of(WightEntity::new, EntityClassification.CREATURE).sized(0.5f, 1.85f).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wight_entity").toString()));
	
	public static final RegistryObject<EntityType<WightKnightEntity>> WIGHT_KNIGHT_ENTITY = Registration.ENTITY_TYPES.register("wight_knight_entity", 
			() -> EntityType.Builder.<WightKnightEntity>of(WightKnightEntity::new, EntityClassification.CREATURE).sized(0.5f, 1.85f).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wight_knight_entity").toString()));
	
	public static final RegistryObject<EntityType<WightTraderEntity>> WIGHT_TRADER_ENTITY = Registration.ENTITY_TYPES.register("wight_trader_entity", 
			() -> EntityType.Builder.<WightTraderEntity>of(WightTraderEntity::new, EntityClassification.CREATURE).sized(0.5f, 1.85f).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wight_trader_entity").toString()));
	
	public static final RegistryObject<EntityType<VolcanDaemon>> VOLCAN_DAEMON_ENTITY = Registration.ENTITY_TYPES.register("volcan_daemon_entity", 
			() -> EntityType.Builder.<VolcanDaemon>of(VolcanDaemon::new, EntityClassification.MONSTER).fireImmune().
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "volcan_daemon_entity").toString()));

	public static final RegistryObject<EntityType<HexanGuardEntity>> HEXAN_GUARD_ENTITY = Registration.ENTITY_TYPES.register("hexan_guard_entity", 
			() -> EntityType.Builder.<HexanGuardEntity>of(HexanGuardEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.6f, 1.95f).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexan_guard_entity").toString()));

	public static final RegistryObject<EntityType<HexanGuardRangedEntity>> HEXAN_GUARD_RANGED_ENTITY  = Registration.ENTITY_TYPES.register("hexan_guard_ranged_entity", 
			() -> EntityType.Builder.<HexanGuardRangedEntity>of(HexanGuardRangedEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.6f, 1.95f).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexan_guard_ranged_entity").toString()));

	public static final RegistryObject<EntityType<HexanGuardMeleeEntity>> HEXAN_GUARD_MELEE_ENTITY = Registration.ENTITY_TYPES.register("hexan_guard_melee_entity", 
			() -> EntityType.Builder.<HexanGuardMeleeEntity>of(HexanGuardMeleeEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.6f, 1.95f).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexan_guard_melee_entity").toString()));

	public static final RegistryObject<EntityType<WitherSkeletonHorseEntity>> WITHER_SKELETON_HORSE = Registration.ENTITY_TYPES.register("wither_skeleton_horse",  
			() -> EntityType.Builder.<WitherSkeletonHorseEntity>of(WitherSkeletonHorseEntity::new, EntityClassification.CREATURE).fireImmune().sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wither_skeleton_horse").toString()));

	public static final RegistryObject<EntityType<WitherSkeletonHorseRider>> WITHER_SKELETON_HORSE_RIDER = Registration.ENTITY_TYPES.register("wither_skeleton_horse_rider",  
			() -> EntityType.Builder.<WitherSkeletonHorseRider>of(WitherSkeletonHorseRider::new, EntityClassification.CREATURE).fireImmune().sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wither_skeleton_horse_rider").toString()));
	
//	public static final RegistryObject<EntityType<SkeletonEntity>> SKELETON = register("skeleton", 
//			EntityType.Builder.<SkeletonEntity>of(SkeletonEntity::new, EntityClassification.MONSTER)
//			.sized(0.6F, 1.99F).clientTrackingRange(8));
	
	

	
	@SubscribeEvent
	public static void registerGlobalEntityAttributes(EntityAttributeCreationEvent event)
	{
		event.put(ModEntities.WIGHT_ENTITY.get(), WightEntity.createAttributes().build());
		event.put(ModEntities.WIGHT_KNIGHT_ENTITY.get(), WightKnightEntity.createAttributes().build());
		event.put(ModEntities.WIGHT_TRADER_ENTITY.get(), WightTraderEntity.createAttributes().build());
		event.put(ModEntities.VOLCAN_DAEMON_ENTITY.get(), VolcanDaemon.createAttributes().build());
		event.put(ModEntities.HEXAN_GUARD_ENTITY.get(), HexanGuardEntity.createAttributes().build());
		event.put(ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(), HexanGuardRangedEntity.createAttributes().build());
		event.put(ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(), HexanGuardMeleeEntity.createAttributes().build());
		event.put(ModEntities.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseEntity.createAttributes().build());
		event.put(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), WitherSkeletonHorseRider.createAttributes().build());
	}
	
	static void register() {}

}