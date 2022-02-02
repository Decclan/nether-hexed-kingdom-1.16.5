package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.List;
import java.util.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.EntityPredicates;
import net.minecraft.world.GameRules;

public class PiglinPublicTasks extends PiglinTasks{
	   //piglin tasks part of brain
	   
	   public static final Item BARTERING_ITEM = Items.GOLD_INGOT;
//	   private static final RangedInteger TIME_BETWEEN_HUNTS = TickRangeConverter.rangeOfSeconds(60, 120);
//	   private static final RangedInteger RIDE_START_INTERVAL = TickRangeConverter.rangeOfSeconds(10, 40);
//	   private static final RangedInteger RIDE_DURATION = TickRangeConverter.rangeOfSeconds(10, 30);
//	   private static final RangedInteger RETREAT_DURATION = TickRangeConverter.rangeOfSeconds(5, 20);
//	   private static final RangedInteger AVOID_ZOMBIFIED_DURATION = TickRangeConverter.rangeOfSeconds(5, 7);
//	   private static final RangedInteger BABY_AVOID_NEMESIS_DURATION = TickRangeConverter.rangeOfSeconds(5, 7);
//	   private static final Set<Item> FOOD_ITEMS = ImmutableSet.of(Items.PORKCHOP, Items.COOKED_PORKCHOP);

	   protected static Brain<?> makeBrain(PiglinEntity p_234469_0_, Brain<PiglinEntity> p_234469_1_) {
	      //initCoreActivity(p_234469_1_);
	      //initIdleActivity(p_234469_1_);
	      //initAdmireItemActivity(p_234469_1_);
	      //initFightActivity(p_234469_0_, p_234469_1_);
	      //initCelebrateActivity(p_234469_1_);
	      //initRetreatActivity(p_234469_1_);
	      //initRideHoglinActivity(p_234469_1_);
	      p_234469_1_.setCoreActivities(ImmutableSet.of(Activity.CORE));
	      p_234469_1_.setDefaultActivity(Activity.IDLE);
	      p_234469_1_.useDefaultActivity();
	      return p_234469_1_;
	   }
	
	   private static List<AbstractPiglinEntity> getAdultPiglins(AbstractPiglinEntity p_234530_0_) {
		      return p_234530_0_.getBrain().getMemory(MemoryModuleType.NEARBY_ADULT_PIGLINS).orElse(ImmutableList.of());
		   }
	   private static boolean isAttackAllowed(LivingEntity p_234506_0_) {
		      return EntityPredicates.ATTACK_ALLOWED.test(p_234506_0_);
		   }
	   private static void setAngerTargetIfCloserThanCurrent(AbstractPiglinEntity p_234513_0_, LivingEntity p_234513_1_) {
		      Optional<LivingEntity> optional = getAngerTarget(p_234513_0_);
		      LivingEntity livingentity = BrainUtil.getNearestTarget(p_234513_0_, optional, p_234513_1_);
		      if (!optional.isPresent() || optional.get() != livingentity) {
		         setAngerTarget(p_234513_0_, livingentity);
		      }
		   }
	   private static Optional<LivingEntity> getAngerTarget(AbstractPiglinEntity p_234532_0_) {
		      return BrainUtil.getLivingEntityFromUUIDMemory(p_234532_0_, MemoryModuleType.ANGRY_AT);
		   }
	   private static void setAngerTargetToNearestTargetablePlayerIfFound(AbstractPiglinEntity abstractEntity, LivingEntity livingEntity) {
		      Optional<PlayerEntity> optional = getNearestVisibleTargetablePlayer(abstractEntity);
		      if (optional.isPresent()) {
		         setAngerTarget(abstractEntity, optional.get());
		      } else {
		         setAngerTarget(abstractEntity, livingEntity);
		      }

		   }
	   
	   protected static void broadcastUniversalAnger(AbstractPiglinEntity p_241430_0_) {
		      getAdultPiglins(p_241430_0_).forEach((p_241419_0_) -> {
		         getNearestVisibleTargetablePlayer(p_241419_0_).ifPresent((p_241421_1_) -> {
		            setAngerTarget(p_241419_0_, p_241421_1_);
		         });
		      });
		   }
	   
	   public boolean canHunt() {
		      return false;
		   }
	   
	   protected static void setAngerTarget(AbstractPiglinEntity abstractEntity, LivingEntity livingEntity) {
		      if (isAttackAllowed(livingEntity)) {
		         abstractEntity.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
		         abstractEntity.getBrain().setMemoryWithExpiry(MemoryModuleType.ANGRY_AT, livingEntity.getUUID(), 600L);
		         if (livingEntity.getType() == EntityType.HOGLIN ) {
		            dontKillAnyMoreHoglinsForAWhile(abstractEntity);
		         }

		         if (livingEntity.getType() == EntityType.PLAYER && abstractEntity.level.getGameRules().getBoolean(GameRules.RULE_UNIVERSAL_ANGER)) {
		            abstractEntity.getBrain().setMemoryWithExpiry(MemoryModuleType.UNIVERSAL_ANGER, true, 600L);
		         }
		      }
		   }
	   
	   protected static void broadcastAngerTarget(AbstractPiglinEntity p_234487_0_, LivingEntity p_234487_1_) {
		      getAdultPiglins(p_234487_0_).forEach((p_234484_1_) -> {
		         if (p_234487_1_.getType() != EntityType.HOGLIN ||  ((HoglinEntity)p_234487_1_).canBeHunted()) {
		            setAngerTargetIfCloserThanCurrent(p_234484_1_, p_234487_1_);
		         }
		      });
		   }
	   
	   protected static void maybeRetaliate(AbstractPiglinEntity p_234509_0_, LivingEntity p_234509_1_) {
		      if (!p_234509_0_.getBrain().isActive(Activity.AVOID)) {
		         if (isAttackAllowed(p_234509_1_)) {
		            if (!BrainUtil.isOtherTargetMuchFurtherAwayThanCurrentAttackTarget(p_234509_0_, p_234509_1_, 4.0D)) {
		               if (p_234509_1_.getType() == EntityType.PLAYER && p_234509_0_.level.getGameRules().getBoolean(GameRules.RULE_UNIVERSAL_ANGER)) {
		                  setAngerTargetToNearestTargetablePlayerIfFound(p_234509_0_, p_234509_1_);
		                  broadcastUniversalAnger(p_234509_0_);
		               } else {
		                  setAngerTarget(p_234509_0_, p_234509_1_);
		                  broadcastAngerTarget(p_234509_0_, p_234509_1_);
		               }

		            }
		         }
		      }
		   }
}
