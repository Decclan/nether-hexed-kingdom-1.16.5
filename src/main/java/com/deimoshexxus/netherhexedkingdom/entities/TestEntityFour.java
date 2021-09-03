package com.deimoshexxus.netherhexedkingdom.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.passive.horse.ZombieHorseEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class TestEntityFour extends AbstractSkeletonEntity
	{
	   private final RangedBowAttackGoal<AbstractSkeletonEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
	   private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
	      public void stop() {
	         super.stop();
	         TestEntityFour.this.setAggressive(false);
	      }

	      public void start() {
	         super.start();
	         TestEntityFour.this.setAggressive(true);
	      }
	   };


	public TestEntityFour(EntityType<? extends AbstractSkeletonEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.applyOpenDoorsAbility();
		//this.fireImmune();
	}

	
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(2, new RestrictSunGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombifiedPiglinEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));

	}

	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MonsterEntity.createMonsterAttributes()
		.add(Attributes.FOLLOW_RANGE, 24.0D)
		.add(Attributes.ATTACK_KNOCKBACK, 12.0D)
		.add(Attributes.MOVEMENT_SPEED, 0.28D)
		.add(Attributes.ATTACK_DAMAGE, 4.5D)
		.add(Attributes.ARMOR, 2.2D)
		.add(Attributes.MAX_HEALTH, 25.0D);
	}

	private void applyOpenDoorsAbility() 
	{
		if (GroundPathHelper.hasGroundPathNavigation(this)) 
		{
			((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(true);
		}
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_)
	{
		super.populateDefaultEquipmentSlots(p_180481_1_);
		this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_SWORD));
		this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
		this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.LEATHER_HELMET));
		this.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.SHIELD));
	}

	
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
		ILivingEntityData ilivingentitydata = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
//		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.reassessWeaponGoal();
		return ilivingentitydata;
	}
	
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.SKELETON_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundEvents.SKELETON_HURT;
	}

	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.SKELETON_DEATH;
	}

	protected SoundEvent getStepSound() 
	{
		return SoundEvents.SKELETON_STEP;
	}
}
