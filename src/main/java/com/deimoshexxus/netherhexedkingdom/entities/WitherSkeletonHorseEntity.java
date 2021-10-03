package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class WitherSkeletonHorseEntity extends HorseEntity
{
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
	
	
	
	public WitherSkeletonHorseEntity(EntityType<? extends HorseEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 0.0F);
	}
	
//  public void equipSaddle() //BREAKS ENTITY RIDING
//  {
//	   this.inventory.setItem(0, new ItemStack(Items.SADDLE));
//  }
	
	public void setTamed(boolean tameBool) 
	{
		this.setFlag(2, tameBool);
	}
	
	public boolean isTamed() 
	{
		return this.getFlag(2);
	}
	
   protected void registerGoals() 
   {
	   this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	   this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.0D));
	   this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
	   this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	   this.addBehaviourGoals();
//	   this.registerGoals();
   }
   protected void addBehaviourGoals() 
   {
      this.goalSelector.addGoal(0, new SwimGoal(this));
   }
	
	   public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
		      ItemStack itemstack = player.getItemInHand(hand);
		      if (!this.isTamed()) {
		         return ActionResultType.PASS;
		      } else if (this.isBaby()) {
		         return super.mobInteract(player, hand);
		      } else if (player.isSecondaryUseActive()) {
		         this.openInventory(player);
		         return ActionResultType.sidedSuccess(this.level.isClientSide);
		      } else if (this.isVehicle()) {
		         return super.mobInteract(player, hand);
		      } else {
		         if (!itemstack.isEmpty()) {
		            if (itemstack.getItem() == Items.SADDLE && !this.isSaddled()) {
		               this.openInventory(player);
		               return ActionResultType.sidedSuccess(this.level.isClientSide);
		            }

		            ActionResultType actionresulttype = itemstack.interactLivingEntity(player, this, hand);
		            if (actionresulttype.consumesAction()) {
		               return actionresulttype;
		            }
		         }

		         this.doPlayerRide(player);
		         return ActionResultType.sidedSuccess(this.level.isClientSide);
		      }
		   }

	public CreatureAttribute getMobType() 
	{
		return CreatureAttribute.UNDEAD;
	}
	
	public boolean canEatGrass() 
	{
		return false;
	}
	
//	public boolean isFood(ItemStack p_70877_1_) 
//	{
//		return p_70877_1_.getItem() == Items.ROTTEN_FLESH;
//	}
	
	public boolean canBeControlledByRider(boolean controlBool) 
	{
		return this.getControllingPassenger() instanceof LivingEntity;
		//return this.getControllingPassenger() instanceof PlayerEntity; //change24/06/21
	}
	
	public boolean canWearArmor(boolean armorBool) 
	{
		return false;
	}

	public boolean isWearingArmor() 
	{
		return this.getItemBySlot(EquipmentSlotType.CHEST).isEmpty();
		//return !this.getItemBySlot(EquipmentSlotType.CHEST).isEmpty();
	}

	public boolean isArmor(ItemStack itemStack) 
	{
		return itemStack.getItem() instanceof HorseArmorItem;
	}
	
	public ItemStack getArmor() 
	{
		return this.getItemBySlot(EquipmentSlotType.CHEST);
	}

	private void setArmor(ItemStack itemStack) 
	{
		this.setItemSlot(EquipmentSlotType.CHEST, itemStack);
		this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
	}
	

	protected void updateContainerEquipment() 
	{
		if (!this.level.isClientSide) 
		{
			super.updateContainerEquipment();
			this.setArmorEquipment(this.inventory.getItem(1));
			this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
		}
	}
	   
   private void setArmorEquipment(ItemStack itemStack) 
   {
	   this.setArmor(itemStack);
	   if (!this.level.isClientSide) 
	   {
		   this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
		   if (this.isArmor(itemStack)) 
		   {
			   int i = ((HorseArmorItem)itemStack.getItem()).getProtection();
			   if (i != 0) 
			   {
				   this.getAttribute(Attributes.ARMOR).addTransientModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", (double)i, AttributeModifier.Operation.ADDITION));
			   }
		   }
	   }
   }
	
   public void containerChanged(IInventory p_76316_1_) 
   {
	      ItemStack itemstack = this.getArmor();
	      super.containerChanged(p_76316_1_);
	      ItemStack itemstack1 = this.getArmor();
	      if (this.tickCount > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) 
	      {
	         this.playSound(SoundEvents.HORSE_ARMOR, 0.5F, 1.0F);
	      }
   }
   
   	public double getPassengersRidingOffset() 
	{
   		return super.getPassengersRidingOffset() - 0.0D;
	}
   
   	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return createBaseHorseAttributes().add(Attributes.MAX_HEALTH, 17.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.3F)
				.add(Attributes.JUMP_STRENGTH, 1.2D);
	}
   	
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return this.isEyeInFluid(FluidTags.WATER) ? SoundEvents.SKELETON_HORSE_AMBIENT_WATER : SoundEvents.SKELETON_HORSE_AMBIENT;
     }

     protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.SKELETON_HORSE_DEATH;
     }

     protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        super.getHurtSound(p_184601_1_);
        return SoundEvents.SKELETON_HORSE_HURT;
     }

     protected SoundEvent getSwimSound() {
        if (this.onGround) {
           if (!this.isVehicle()) {
              return SoundEvents.SKELETON_HORSE_STEP_WATER;
           }

           ++this.gallopSoundCounter;
           if (this.gallopSoundCounter > 5 && this.gallopSoundCounter % 3 == 0) {
              return SoundEvents.SKELETON_HORSE_GALLOP_WATER;
           }

           if (this.gallopSoundCounter <= 5) {
              return SoundEvents.SKELETON_HORSE_STEP_WATER;
           }
        }

        return SoundEvents.SKELETON_HORSE_SWIM;
     }
	
     public boolean rideableUnderWater() 
     {
    	 return true;
     }

     protected float getWaterSlowDown() 
     {
    	 return 0.96F;
     }
    
    
	public boolean canMate()
	{
		return false;
	}

	   @Nullable
	   public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficulty, SpawnReason spawnR, @Nullable ILivingEntityData livingDat, @Nullable CompoundNBT nbtDat) 
	   {
	      livingDat = super.finalizeSpawn(serverWorld, difficulty, spawnR, livingDat, nbtDat);

	      this.setTamed(false);

	      return livingDat;
	   }
}
