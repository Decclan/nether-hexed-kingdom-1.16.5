package com.deimoshexxus.netherhexedkingdom.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PatrolVillageGoal;
import net.minecraft.entity.ai.goal.ReturnToVillageGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class WightKnightEntity extends WightEntity {

	public WightKnightEntity(EntityType<? extends WightEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() 
	{
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 16.0F));
      this.goalSelector.addGoal(3, new ReturnToVillageGoal(this, 0.6D, false));
      this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombifiedPiglinEntity.class, 6.0F, 1.0D, 1.2D));
      this.goalSelector.addGoal(4, new PatrolVillageGoal(this, 0.6D));
      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
//      this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
      this.addBehaviourGoals();
	}
	
   protected void addBehaviourGoals() 
   {
	   	this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
	    this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
	    this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(WightKnightEntity.class));
	    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 5, false, false, (p_234199_0_) -> 
	    {
	    	return p_234199_0_ instanceof IMob && !(p_234199_0_ instanceof ZombifiedPiglinEntity);
	//	         return p_234199_0_ instanceof IMob && !(p_234199_0_ instanceof ZombifiedPiglinEntity) && !(p_234199_0_ instanceof WightKnightEntity);
	    }));
	}
   
   public boolean canBeLeashed(PlayerEntity p_184652_1_) 
   {
	   return true;
   }
   
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
		ILivingEntityData ilivingentitydata = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);

		ItemStack colourLeather = new ItemStack(Items.LEATHER_CHESTPLATE, 1);
		((DyeableArmorItem) colourLeather.getItem()).setColor(colourLeather, 234445);
		this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_SWORD));
		this.setItemSlot(EquipmentSlotType.CHEST, colourLeather);
		this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.LEATHER_HELMET));
		return ilivingentitydata;
	}
}
