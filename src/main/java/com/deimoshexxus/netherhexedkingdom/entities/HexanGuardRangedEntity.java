package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.deimoshexxus.netherhexedkingdom.init.ModItems;
import com.deimoshexxus.netherhexedkingdom.init.SoundsHandler;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class HexanGuardRangedEntity extends AbstractSkeletonEntity
	{

	public HexanGuardRangedEntity(EntityType<? extends AbstractSkeletonEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.setPathfindingMalus(PathNodeType.LAVA, 10.0F);
		this.applyOpenDoorsAbility();
	}

	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(3, new RestrictSunGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, ZombifiedPiglinEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(HexanGuardMeleeEntity.class));
	    this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(HexanGuardRangedEntity.class));
	    this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setAlertOthers(WitherSkeletonEntity.class));
	    this.addBehaviourGoals();
	}
	
	protected void addBehaviourGoals() 
	{
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, WightEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractPiglinEntity.class, true));
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MonsterEntity.createMonsterAttributes()
		.add(Attributes.FOLLOW_RANGE, 24.0D)
		.add(Attributes.ATTACK_KNOCKBACK, 3.0D)
		.add(Attributes.MOVEMENT_SPEED, 0.28D)
		.add(Attributes.ATTACK_DAMAGE, 4.5D)
//		.add(Attributes.ARMOR, 2.0D)
		.add(Attributes.MAX_HEALTH, 26.0D);
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
	protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_)
	{
		super.populateDefaultEquipmentSlots(p_180481_1_);
		int chance = 1 + (int) (Math.random() * 10);
		this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
		if (chance >= 7)
		{
			this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(ModItems.MILITUS_ALLOY_HELMET.get()));
		}
		this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(ModItems.MILITUS_ALLOY_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(ModItems.MILITUS_ALLOY_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlotType.FEET, new ItemStack(ModItems.MILITUS_ALLOY_BOOTS.get()));
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
	
	public static boolean canSpawn(EntityType<HexanGuardRangedEntity> type, IServerWorld world, 
			SpawnReason spawnReason, BlockPos pos, Random random)
	{
		if (MonsterEntity.isDarkEnoughToSpawn(world, pos, random))
		{
			AxisAlignedBB box = new AxisAlignedBB(pos).inflate(8);
			List<HexanGuardRangedEntity> entities = world.getEntitiesOfClass(HexanGuardRangedEntity.class, box, (entity) -> {return true;});
			return entities.size() < 3;
		}
		return false;
	}
	
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
		ILivingEntityData ilivingentitydata = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
		this.reassessWeaponGoal();
		return ilivingentitydata;
	}
}
