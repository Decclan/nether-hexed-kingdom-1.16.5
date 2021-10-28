package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
//import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
//import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
//import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class WightEntity extends CreatureEntity
	{

	public WightEntity(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.applyOpenDoorsAbility();
	    this.setCanPickUpLoot(true);
	    this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 8.0F);
	}
	
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(2, new RestrictSunGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombifiedPiglinEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
//		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.addBehaviourGoals();
	}
	
   protected void addBehaviourGoals() 
   {
	   	this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
	    this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
	    this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(WightEntity.class));
//	    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
//	    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
//	    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
//	    this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PiglinBruteEntity.class, true));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return CreatureEntity.createLivingAttributes()
		.add(Attributes.FOLLOW_RANGE, 16.0D)
		.add(Attributes.ATTACK_KNOCKBACK, 2.0D)
		.add(Attributes.MOVEMENT_SPEED, 0.3D)
		.add(Attributes.ATTACK_DAMAGE, 4.2D)
		.add(Attributes.ARMOR, 2.0D)
		.add(Attributes.MAX_HEALTH, 24.0D);
	}

	private void applyOpenDoorsAbility() 
	{
		if (GroundPathHelper.hasGroundPathNavigation(this)) 
		{
			((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(true);
		}
	}

	@Nullable
	public void ILivingEntityData(DifficultyInstance p_180481_1_) 
	{
		this.populateDefaultEquipmentSlots(p_180481_1_);
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_)
	{
		super.populateDefaultEquipmentSlots(p_180481_1_);
	}

	protected boolean isSunSensitive() 
	{
		return true;
	}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return SoundEvents.SKELETON_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundEvents.GENERIC_HURT;
	}

	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.SKELETON_DEATH;
	}

	protected SoundEvent getStepSound() 
	{
		return SoundEvents.STONE_STEP;
	}
	
	public static boolean canSpawn(EntityType<WightEntity> type, IServerWorld world, 
			SpawnReason spawnReason, BlockPos pos, Random random)
	{
		if (MonsterEntity.isDarkEnoughToSpawn(world, pos, random))
		{
			AxisAlignedBB box = new AxisAlignedBB(pos).inflate(16);
			List<WightEntity> entities = world.getEntitiesOfClass(WightEntity.class, box, (entity) -> {return true;});
			return entities.size() < 6;
		}
		return false;
	}
	
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
		ILivingEntityData ilivingentitydata = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
//		this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_SWORD));
//		this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
//		this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.LEATHER_HELMET));
		return ilivingentitydata;
	}
}
