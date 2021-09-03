package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.entities.WightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WightKnightEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WightTraderEntity;
import com.deimoshexxus.netherhexedkingdom.entities.FaceEaterEntity;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityFour;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityThree;
import com.deimoshexxus.netherhexedkingdom.entities.TestEntityTwo;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseEntity;
import com.deimoshexxus.netherhexedkingdom.entities.WitherSkeletonHorseRider;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
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
	
	public static final RegistryObject<EntityType<FaceEaterEntity>> FACE_EATER_ENTITY = Registration.ENTITY_TYPES.register("face_eater_entity", 
			() -> EntityType.Builder.<FaceEaterEntity>of(FaceEaterEntity::new, EntityClassification.MONSTER).fireImmune().
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "face_eater_entity").toString()));

	public static final RegistryObject<EntityType<TestEntityTwo>> TEST_ENTITY_TWO = Registration.ENTITY_TYPES.register("test_entity_two", 
			() -> EntityType.Builder.<TestEntityTwo>of(TestEntityTwo::new, EntityClassification.MONSTER).fireImmune().sized(0.6f, 1.95f).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "test_entity_two").toString()));

	public static final RegistryObject<EntityType<TestEntityThree>> TEST_ENTITY_THREE = Registration.ENTITY_TYPES.register("test_entity_three", 
			() -> EntityType.Builder.<TestEntityThree>of(TestEntityThree::new, EntityClassification.MONSTER).fireImmune().sized(0.6f, 1.95f).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "test_entity_three").toString()));

	public static final RegistryObject<EntityType<TestEntityFour>> TEST_ENTITY_FOUR = Registration.ENTITY_TYPES.register("test_entity_four", 
			() -> EntityType.Builder.<TestEntityFour>of(TestEntityFour::new, EntityClassification.MONSTER).fireImmune().sized(0.6f, 1.95f).clientTrackingRange(8).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "test_entity_four").toString()));

	public static final RegistryObject<EntityType<WitherSkeletonHorseEntity>> WITHER_SKELETON_HORSE = Registration.ENTITY_TYPES.register("wither_skeleton_horse",  
			() -> EntityType.Builder.<WitherSkeletonHorseEntity>of(WitherSkeletonHorseEntity::new, EntityClassification.CREATURE).fireImmune().sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wither_skeleton_horse").toString()));

	public static final RegistryObject<EntityType<WitherSkeletonHorseRider>> WITHER_SKELETON_HORSE_RIDER = Registration.ENTITY_TYPES.register("wither_skeleton_horse_rider",  
			() -> EntityType.Builder.<WitherSkeletonHorseRider>of(WitherSkeletonHorseRider::new, EntityClassification.CREATURE).fireImmune().sized(1.41F, 1.7F).clientTrackingRange(10).
			build(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "wither_skeleton_horse_rider").toString()));
	
//	public static final RegistryObject<EntityType<SkeletonEntity>> SKELETON = register("skeleton", 
//			EntityType.Builder.<SkeletonEntity>of(SkeletonEntity::new, EntityClassification.MONSTER)
//			.sized(0.6F, 1.99F).clientTrackingRange(8));
	
	
	@SuppressWarnings("deprecation")
	public static void registerGlobalEntityAttributes()
	{
		GlobalEntityTypeAttributes.put(ModEntities.WIGHT_ENTITY.get(), WightEntity.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.WIGHT_KNIGHT_ENTITY.get(), WightKnightEntity.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.WIGHT_TRADER_ENTITY.get(), WightTraderEntity.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.FACE_EATER_ENTITY.get(), FaceEaterEntity.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.TEST_ENTITY_TWO.get(), TestEntityTwo.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.TEST_ENTITY_THREE.get(), TestEntityThree.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.TEST_ENTITY_FOUR.get(), TestEntityFour.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseEntity.createAttributes().build());
		GlobalEntityTypeAttributes.put(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), WitherSkeletonHorseRider.createAttributes().build());

	}
	
	

	
	

//	private static final Map<EntityType<? extends LivingEntity>, AttributeModifierMap> SUPPLIERS = ImmutableMap.<EntityType<? extends LivingEntity>, AttributeModifierMap>builder().put(EntityType.ARMOR_STAND, LivingEntity.createLivingAttributes().build());
	
//	net.minecraftforge.event.entity.EntityAttributeCreationEvent
//	@SubscribeEvent
//	public static void registerGlobalEntityAttributes(EntityAttributeCreationEvent event)
//	{
//		event.put(ModEntities.TEST_ENTITY.get(), TestEntity.createAttributes().build());
//	}
	
//	private static void registerEntityGoals()
//	{
//		TestEntity.re
//	}
//   private static Attribute register(String p_233831_0_, Attribute p_233831_1_) {
//	      return Registry.register(Registry.ATTRIBUTE, p_233831_0_, p_233831_1_);
	
	static void register() {}
}