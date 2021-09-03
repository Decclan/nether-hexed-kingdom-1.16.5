package com.deimoshexxus.netherhexedkingdom.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.villager.VillagerType;

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
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.World;

public class TestEntityTwo extends MonsterEntity
	{
	//p_i48555_2_ = worldIn
	//p_i48553_1_ = type
	

	public TestEntityTwo(EntityType<? extends MonsterEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.applyOpenDoorsAbility();
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
		
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MonsterEntity.createMonsterAttributes()
		.add(Attributes.FOLLOW_RANGE, 24.0D)
		.add(Attributes.ATTACK_KNOCKBACK, 12.0D)
		.add(Attributes.MOVEMENT_SPEED, 0.15D)
		.add(Attributes.ATTACK_DAMAGE, 4.5D)
		.add(Attributes.ARMOR, 2.0D)
		.add(Attributes.MAX_HEALTH, 25.0D);
	}
	
//	public static AttributeModifierMap.MutableAttribute createMonsterAttributes() 
//	{
//	    return MobEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE);
//	}
	
//	public static AttributeModifierMap.MutableAttribute createAttributes() {
//	      return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
//	   }
//

	private void applyOpenDoorsAbility() 
	{
		if (GroundPathHelper.hasGroundPathNavigation(this)) 
		{
			((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(true);
		}
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
