package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardMeleeEntity;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardRangedEntity;
import com.deimoshexxus.netherhexedkingdom.entities.HexedUndeadRiderEntity;
import com.deimoshexxus.netherhexedkingdom.entities.PiglinBeserkerEntity;
import com.deimoshexxus.netherhexedkingdom.entities.PiglinPrisonerEntity;
import com.deimoshexxus.netherhexedkingdom.entities.VolcanDaemon;
import com.deimoshexxus.netherhexedkingdom.entities.HexedUndeadHorseEntity;
import com.deimoshexxus.netherhexedkingdom.entities.HexanGuardEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseRider;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;

@Mod.EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Bus.MOD)
public class ModEntities
{
//	public static final RegistryObject<EntityType<WightEntity>> WIGHT_ENTITY = Registration.ENTITY_TYPES.register("wight_entity", 
//			() -> EntityType.Builder.<WightEntity>of(WightEntity::new, EntityClassification.CREATURE).sized(0.5f, 1.85f).clientTrackingRange(8).
//			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wight_entity").toString()));
//	
//	public static final RegistryObject<EntityType<WightKnightEntity>> WIGHT_KNIGHT_ENTITY = Registration.ENTITY_TYPES.register("wight_knight_entity", 
//			() -> EntityType.Builder.<WightKnightEntity>of(WightKnightEntity::new, EntityClassification.CREATURE).sized(0.5f, 1.85f).clientTrackingRange(8).
//			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wight_knight_entity").toString()));
//	
//	public static final RegistryObject<EntityType<WightTraderEntity>> WIGHT_TRADER_ENTITY = Registration.ENTITY_TYPES.register("wight_trader_entity", 
//			() -> EntityType.Builder.<WightTraderEntity>of(WightTraderEntity::new, EntityClassification.CREATURE).sized(0.5f, 1.85f).clientTrackingRange(8).
//			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wight_trader_entity").toString()));
	
	public static final RegistryObject<EntityType<VolcanDaemon>> VOLCAN_DAEMON_ENTITY = Registration.ENTITY_TYPES.register("volcan_daemon_entity", 
			() -> EntityType.Builder.<VolcanDaemon>of(VolcanDaemon::new, EntityClassification.MONSTER).fireImmune().sized(2.5f, 1.5f).
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
			() -> EntityType.Builder.<WitherSkeletonHorseEntity>of(WitherSkeletonHorseEntity::new, EntityClassification.MONSTER).fireImmune().immuneTo(Blocks.WITHER_ROSE).sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wither_skeleton_horse").toString()));

	public static final RegistryObject<EntityType<WitherSkeletonHorseRider>> WITHER_SKELETON_HORSE_RIDER = Registration.ENTITY_TYPES.register("wither_skeleton_horse_rider",  
			() -> EntityType.Builder.<WitherSkeletonHorseRider>of(WitherSkeletonHorseRider::new, EntityClassification.MONSTER).fireImmune().immuneTo(Blocks.WITHER_ROSE).sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wither_skeleton_horse_rider").toString()));
	
	public static final RegistryObject<EntityType<HexedUndeadHorseEntity>> UNDEAD_HORSE = Registration.ENTITY_TYPES.register("hexed_undead_horse",  
			() -> EntityType.Builder.<HexedUndeadHorseEntity>of(HexedUndeadHorseEntity::new, EntityClassification.MONSTER).sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexed_undead_horse").toString()));
	
	public static final RegistryObject<EntityType<HexedUndeadRiderEntity>> UNDEAD_HORSE_RIDER = Registration.ENTITY_TYPES.register("hexed_undead_horse_rider",  
			() -> EntityType.Builder.<HexedUndeadRiderEntity>of(HexedUndeadRiderEntity::new, EntityClassification.MONSTER).sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexed_undead_horse_rider").toString()));
	
	public static final RegistryObject<EntityType<PiglinBeserkerEntity>> PIGLIN_BESERKER_ENTITY = Registration.ENTITY_TYPES.register("piglin_beserker_entity", 
			() -> EntityType.Builder.<PiglinBeserkerEntity>of(PiglinBeserkerEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "piglin_beserker_entity").toString()));

	public static final RegistryObject<EntityType<PiglinPrisonerEntity>> PIGLIN_PRISONER_ENTITY = Registration.ENTITY_TYPES.register("piglin_prisoner_entity", 
			() -> EntityType.Builder.<PiglinPrisonerEntity>of(PiglinPrisonerEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "piglin_prisoner_entity").toString()));

//	public static final RegistryObject<EntityType<SkeletonEntity>> SKELETON = register("skeleton", 
//			EntityType.Builder.<SkeletonEntity>of(SkeletonEntity::new, EntityClassification.MONSTER)
//			.sized(0.6F, 1.99F).clientTrackingRange(8));
	
	@SubscribeEvent
	public static void registerGlobalEntityAttributes(EntityAttributeCreationEvent event)
	{
//		event.put(ModEntities.WIGHT_ENTITY.get(), WightEntity.createAttributes().build());
//		event.put(ModEntities.WIGHT_KNIGHT_ENTITY.get(), WightKnightEntity.createAttributes().build());
//		event.put(ModEntities.WIGHT_TRADER_ENTITY.get(), WightTraderEntity.createAttributes().build());
		event.put(ModEntities.VOLCAN_DAEMON_ENTITY.get(), VolcanDaemon.createAttributes().build());
		event.put(ModEntities.HEXAN_GUARD_ENTITY.get(), HexanGuardEntity.createAttributes().build());
		event.put(ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(), HexanGuardRangedEntity.createAttributes().build());
		event.put(ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(), HexanGuardMeleeEntity.createAttributes().build());
		event.put(ModEntities.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseEntity.createAttributes().build());
		event.put(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), WitherSkeletonHorseRider.createAttributes().build());
		event.put(ModEntities.UNDEAD_HORSE.get(), HexedUndeadHorseEntity.createAttributes().build());
		event.put(ModEntities.UNDEAD_HORSE_RIDER.get(), HexedUndeadRiderEntity.createAttributes().build());
		event.put(ModEntities.PIGLIN_BESERKER_ENTITY.get(), PiglinBeserkerEntity.createAttributes().build());
		event.put(ModEntities.PIGLIN_PRISONER_ENTITY.get(), PiglinPrisonerEntity.createAttributes().build());
	}
	
	public static void registerEntitySpawns()
	{
//		EntitySpawnPlacementRegistry.register(ModEntities.WIGHT_ENTITY.get(),
//				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WightEntity::canSpawn);
		
		EntitySpawnPlacementRegistry.register(ModEntities.HEXAN_GUARD_ENTITY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HexanGuardEntity::checkAnyLightMonsterSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HexanGuardMeleeEntity::checkAnyLightMonsterSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HexanGuardRangedEntity::checkAnyLightMonsterSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.VOLCAN_DAEMON_ENTITY.get(),
				EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, VolcanDaemon::daemonSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.WITHER_SKELETON_HORSE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WitherSkeletonHorseEntity::checkWhorseSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WitherSkeletonHorseRider::checkWhorseSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.UNDEAD_HORSE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HexedUndeadHorseEntity::checkDeadHorseSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.UNDEAD_HORSE_RIDER.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HexedUndeadRiderEntity::checkSpawnRules);
		
		EntitySpawnPlacementRegistry.register(ModEntities.PIGLIN_BESERKER_ENTITY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PiglinBeserkerEntity::checkAnyLightMonsterSpawnRules);
	
		EntitySpawnPlacementRegistry.register(ModEntities.PIGLIN_PRISONER_ENTITY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, 
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PiglinPrisonerEntity::checkAnyLightMonsterSpawnRules);

	}
	
	static void register() {}
}