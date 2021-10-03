package com.deimoshexxus.netherhexedkingdom.entities;

import com.deimoshexxus.netherhexedkingdom.init.SoundsHandler;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
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

public class HexanGuardEntity extends MonsterEntity
	{
	
	public HexanGuardEntity(EntityType<? extends MonsterEntity> type, World worldIn) 
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

	private void applyOpenDoorsAbility() 
	{
		if (GroundPathHelper.hasGroundPathNavigation(this)) 
		{
			((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(true);
		}
	}

	public CreatureAttribute getMobType() 
	{
		return CreatureAttribute.UNDEAD;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundsHandler.ENTITY_HEXAN_GUARD_AMBIENT.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundsHandler.ENTITY_HEXAN_GUARD_HURT.get();
	}

	protected SoundEvent getDeathSound() 
	{
		return SoundsHandler.ENTITY_HEXAN_GUARD_DEATH.get();
	}

	protected SoundEvent getStepSound() 
	{
		return SoundEvents.SKELETON_STEP;
	}
}
