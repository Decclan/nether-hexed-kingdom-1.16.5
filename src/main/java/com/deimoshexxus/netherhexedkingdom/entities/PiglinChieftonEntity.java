package com.deimoshexxus.netherhexedkingdom.entities;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinAction;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//import net.minecraft.entity.monster.piglin.PiglinEntity;
//import net.minecraft.entity.monster.piglin.PiglinBruteEntity;

public class PiglinChieftonEntity extends AbstractPiglinEntity
{
	protected static final ImmutableList<SensorType<? extends Sensor<? super PiglinChieftonEntity>>> SENSOR_TYPES = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.NEAREST_ITEMS, SensorType.HURT_BY, SensorType.PIGLIN_BRUTE_SPECIFIC_SENSOR);
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.LIVING_ENTITIES, MemoryModuleType.VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS, MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH, MemoryModuleType.ANGRY_AT, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.HOME);


	public PiglinChieftonEntity(EntityType<? extends AbstractPiglinEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.xpReward = 30;
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 70.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.38F)
				.add(Attributes.ATTACK_DAMAGE, 8.0D);
	}

	   @Nullable
	   public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
	      PiglinChieftonBrain.initMemories(this);
	      this.populateDefaultEquipmentSlots(p_213386_2_);
	      return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
	   }
	   
	   protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_) 
	   {
			int chance = 1 + (int) (Math.random() * 10);
			if (chance >= 8)
			{
				this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.CROSSBOW));
			} else if (chance <= 3)
			{
				this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
			} else {
				this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
			}
			if (chance >= 2)
			{
				this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.GOLDEN_HELMET));
			}
			if (chance >= 7)
			{
				
				this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
//				this.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
//				this.setItemSlot(EquipmentSlotType.FEET, new ItemStack(Items.GOLDEN_BOOTS));
			}
			

	   }
	   
	   protected Brain.BrainCodec<PiglinChieftonEntity> brainProvider() {
		      return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
		   }

		   protected Brain<?> makeBrain(Dynamic<?> p_213364_1_) {
		      return PiglinChieftonBrain.makeBrain(this, this.brainProvider().makeBrain(p_213364_1_));
		   }

		   @SuppressWarnings("unchecked")
		public Brain<PiglinChieftonEntity> getBrain() {
		      return (Brain<PiglinChieftonEntity>)super.getBrain();
		   }

		   public boolean canHunt() {
		      return false;
		   }

		   public boolean wantsToPickUp(ItemStack p_230293_1_) {
		      return p_230293_1_.getItem() == Items.GOLDEN_AXE ? super.wantsToPickUp(p_230293_1_) : false;
		   }

		   protected void customServerAiStep() {
		      this.level.getProfiler().push("PiglinChieftonBrain");
		      this.getBrain().tick((ServerWorld)this.level, this);
		      this.level.getProfiler().pop();
		      PiglinChieftonBrain.updateActivity(this);
		      PiglinChieftonBrain.maybePlayActivitySound(this);
		      super.customServerAiStep();
		   }

		   @OnlyIn(Dist.CLIENT)
		   public PiglinAction getArmPose() {
		      return this.isAggressive() && this.isHoldingMeleeWeapon() ? PiglinAction.ATTACKING_WITH_MELEE_WEAPON : PiglinAction.DEFAULT;
		   }

		   public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
		      boolean flag = super.hurt(p_70097_1_, p_70097_2_);
		      if (this.level.isClientSide) {
		         return false;
		      } else {
		         if (flag && p_70097_1_.getEntity() instanceof LivingEntity) {
		            PiglinChieftonBrain.wasHurtBy(this, (LivingEntity)p_70097_1_.getEntity());
		         }

		         return flag;
		      }
		   }

		   protected SoundEvent getAmbientSound() {
		      return SoundEvents.PIGLIN_BRUTE_AMBIENT;
		   }

		   protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
		      return SoundEvents.PIGLIN_BRUTE_HURT;
		   }

		   protected SoundEvent getDeathSound() {
		      return SoundEvents.PIGLIN_BRUTE_DEATH;
		   }

		   protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
		      this.playSound(SoundEvents.PIGLIN_BRUTE_STEP, 0.15F, 1.0F);
		   }

		   protected void playAngrySound() {
		      this.playSound(SoundEvents.PIGLIN_BRUTE_ANGRY, 1.0F, this.getVoicePitch());
		   }

		   protected void playConvertedSound() {
		      this.playSound(SoundEvents.PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED, 1.0F, this.getVoicePitch());
		   }

}
