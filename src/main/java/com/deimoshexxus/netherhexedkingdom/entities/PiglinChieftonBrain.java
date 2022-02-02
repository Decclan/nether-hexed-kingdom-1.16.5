package com.deimoshexxus.netherhexedkingdom.entities;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import java.util.Optional;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.ai.brain.task.AttackStrafingTask;
import net.minecraft.entity.ai.brain.task.AttackTargetTask;
import net.minecraft.entity.ai.brain.task.DummyTask;
import net.minecraft.entity.ai.brain.task.FindInteractionAndLookTargetTask;
import net.minecraft.entity.ai.brain.task.FindNewAttackTargetTask;
import net.minecraft.entity.ai.brain.task.FirstShuffledTask;
import net.minecraft.entity.ai.brain.task.ForgetAttackTargetTask;
import net.minecraft.entity.ai.brain.task.GetAngryTask;
import net.minecraft.entity.ai.brain.task.InteractWithDoorTask;
import net.minecraft.entity.ai.brain.task.InteractWithEntityTask;
import net.minecraft.entity.ai.brain.task.LookAtEntityTask;
import net.minecraft.entity.ai.brain.task.LookTask;
import net.minecraft.entity.ai.brain.task.MoveToTargetTask;
import net.minecraft.entity.ai.brain.task.PredicateTask;
import net.minecraft.entity.ai.brain.task.SupplementedTask;
import net.minecraft.entity.ai.brain.task.WalkRandomlyTask;
import net.minecraft.entity.ai.brain.task.WalkToTargetTask;
import net.minecraft.entity.ai.brain.task.WalkTowardsPosTask;
import net.minecraft.entity.ai.brain.task.WorkTask;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.GlobalPos;

//import net.minecraft.entity.monster.piglin.PiglinTasks;
//import net.minecraft.entity.monster.piglin.PiglinEntity;

public class PiglinChieftonBrain {
   protected static Brain<?> makeBrain(PiglinChieftonEntity p_242354_0_, Brain<PiglinChieftonEntity> p_242354_1_) {
      initCoreActivity(p_242354_0_, p_242354_1_);
      initIdleActivity(p_242354_0_, p_242354_1_);
      initFightActivity(p_242354_0_, p_242354_1_);
      p_242354_1_.setCoreActivities(ImmutableSet.of(Activity.CORE));
      p_242354_1_.setDefaultActivity(Activity.IDLE);
      p_242354_1_.useDefaultActivity();
      return p_242354_1_;
   }

   protected static void initMemories(PiglinChieftonEntity p_242352_0_) {
      GlobalPos globalpos = GlobalPos.of(p_242352_0_.level.dimension(), p_242352_0_.blockPosition());
      p_242352_0_.getBrain().setMemory(MemoryModuleType.HOME, globalpos);
   }

   private static void initCoreActivity(PiglinChieftonEntity p_242359_0_, Brain<PiglinChieftonEntity> p_242359_1_) {
      p_242359_1_.addActivity(Activity.CORE, 0, ImmutableList.of(new LookTask(45, 90), new WalkToTargetTask(), new InteractWithDoorTask(), new GetAngryTask<>()));
   }

   private static void initIdleActivity(PiglinChieftonEntity p_242362_0_, Brain<PiglinChieftonEntity> p_242362_1_) {
      p_242362_1_.addActivity(Activity.IDLE, 10, ImmutableList.of(new ForgetAttackTargetTask<>(PiglinChieftonBrain::findNearestValidAttackTarget), createIdleLookBehaviors(), createIdleMovementBehaviors(), new FindInteractionAndLookTargetTask(EntityType.PLAYER, 4)));
   }

//   private static void initFightActivity(PiglinChieftonEntity p_242364_0_, Brain<PiglinChieftonEntity> p_242364_1_) {
//      p_242364_1_.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10, ImmutableList.of(new FindNewAttackTargetTask<>((p_242361_1_) -> {
//         return !isNearestValidAttackTarget(p_242364_0_, p_242361_1_);
//      }), new MoveToTargetTask(1.0F), new AttackTargetTask(20)), MemoryModuleType.ATTACK_TARGET);
//   }


   private static void initFightActivity(PiglinChieftonEntity p_234488_0_, Brain<PiglinChieftonEntity> p_234488_1_) {
	      p_234488_1_.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10, ImmutableList.<net.minecraft.entity.ai.brain.task.Task<? super PiglinChieftonEntity>>of(new FindNewAttackTargetTask<>((p_234523_1_) -> {
	         return !isNearestValidAttackTarget(p_234488_0_, p_234523_1_);																						//new ShootTargetTask(), new FinishedHuntTask(),							
	      }), new SupplementedTask<>(PiglinChieftonBrain::hasCrossbow, new AttackStrafingTask<>(5, 0.75F)), new MoveToTargetTask(1.0F), new AttackTargetTask(20),  new PredicateTask<>(PiglinChieftonBrain::isNearZombified, MemoryModuleType.ATTACK_TARGET)), MemoryModuleType.ATTACK_TARGET);
	   }
   
   private static FirstShuffledTask<PiglinChieftonEntity> createIdleLookBehaviors() {
      return new FirstShuffledTask<>(ImmutableList.of(Pair.of(new LookAtEntityTask(EntityType.PLAYER, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityType.PIGLIN, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityType.PIGLIN_BRUTE, 8.0F), 1), Pair.of(new LookAtEntityTask(8.0F), 1), Pair.of(new DummyTask(30, 60), 1)));
   }

   private static FirstShuffledTask<PiglinChieftonEntity> createIdleMovementBehaviors() {
      return new FirstShuffledTask<>(ImmutableList.of(Pair.of(new WalkRandomlyTask(0.6F), 2), Pair.of(InteractWithEntityTask.of(EntityType.PIGLIN, 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2), Pair.of(InteractWithEntityTask.of(EntityType.PIGLIN_BRUTE, 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2), Pair.of(new WalkTowardsPosTask(MemoryModuleType.HOME, 0.6F, 2, 100), 2), Pair.of(new WorkTask(MemoryModuleType.HOME, 0.6F, 5), 2), Pair.of(new DummyTask(30, 60), 1)));
   }

   protected static void updateActivity(PiglinChieftonEntity p_242358_0_) {
      Brain<PiglinChieftonEntity> brain = p_242358_0_.getBrain();
      Activity activity = brain.getActiveNonCoreActivity().orElse((Activity)null);
      brain.setActiveActivityToFirstValid(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
      Activity activity1 = brain.getActiveNonCoreActivity().orElse((Activity)null);
      if (activity != activity1) {
         playActivitySound(p_242358_0_);
      }

      p_242358_0_.setAggressive(brain.hasMemoryValue(MemoryModuleType.ATTACK_TARGET));
   }

   private static boolean isNearestValidAttackTarget(AbstractPiglinEntity p_242350_0_, LivingEntity p_242350_1_) {
      return findNearestValidAttackTarget(p_242350_0_).filter((p_242348_1_) -> {
         return p_242348_1_ == p_242350_1_;
      }).isPresent();
   }

   private static Optional<? extends LivingEntity> findNearestValidAttackTarget(AbstractPiglinEntity p_242349_0_) {
      Optional<LivingEntity> optional = BrainUtil.getLivingEntityFromUUIDMemory(p_242349_0_, MemoryModuleType.ANGRY_AT);
      if (optional.isPresent() && isAttackAllowed(optional.get())) {
         return optional;
      }
//      } else {
//         Optional<? extends LivingEntity> optional1 = getTargetIfWithinRange(p_242349_0_, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER);
//         return optional1.isPresent() ? optional1 : p_242349_0_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
//      }
	return optional;
   }

   private static boolean isAttackAllowed(LivingEntity p_242347_0_) {
      return EntityPredicates.ATTACK_ALLOWED.test(p_242347_0_);
   }

//   private static Optional<? extends LivingEntity> getTargetIfWithinRange(AbstractPiglinEntity p_242351_0_, MemoryModuleType<? extends LivingEntity> p_242351_1_) {
//      return p_242351_0_.getBrain().getMemory(p_242351_1_).filter((p_242357_1_) -> {
//         return p_242357_1_.closerThan(p_242351_0_, 12.0D);
//      });
//   }


   
   protected static void wasHurtBy(PiglinChieftonEntity p_242353_0_, LivingEntity p_242353_1_) {
      if (!(p_242353_1_ instanceof AbstractPiglinEntity)) {
         PiglinPublicTasks.maybeRetaliate(p_242353_0_, p_242353_1_);
      }
   }

   protected static void maybePlayActivitySound(PiglinChieftonEntity p_242360_0_) {
      if ((double)p_242360_0_.level.random.nextFloat() < 0.0125D) {
         playActivitySound(p_242360_0_);
      }

   }

   private static void playActivitySound(PiglinChieftonEntity p_242363_0_) {
      p_242363_0_.getBrain().getActiveNonCoreActivity().ifPresent((p_242355_1_) -> {
         if (p_242355_1_ == Activity.FIGHT) {
            p_242363_0_.playAngrySound();
         }

      });
   }
   private static boolean hasCrossbow(LivingEntity p_234494_0_) {
	      return p_234494_0_.isHolding(item -> item instanceof net.minecraft.item.CrossbowItem);
	   }
   
   private static boolean isNearZombified(PiglinChieftonEntity p_234525_0_) {
	      Brain<PiglinChieftonEntity> brain = p_234525_0_.getBrain();
	      if (brain.hasMemoryValue(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED)) {
	         LivingEntity livingentity = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED).get();
	         return p_234525_0_.closerThan(livingentity, 6.0D);
	      } else {
	         return false;
	      }
	   }
}