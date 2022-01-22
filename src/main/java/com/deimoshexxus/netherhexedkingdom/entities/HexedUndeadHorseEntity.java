package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.Random;
import java.util.UUID;
import javax.annotation.Nullable;

import net.minecraft.block.Blocks;
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
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
//import net.minecraft.entity.passive.horse.ZombieHorseEntity;

public class HexedUndeadHorseEntity extends HorseEntity {
   private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");

   public HexedUndeadHorseEntity(EntityType<? extends HorseEntity> p_i50238_1_, World p_i50238_2_) {
      super(p_i50238_1_, p_i50238_2_);
   }

   protected void registerGoals() 
   {
	   this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	   this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.0D));
	   this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
	   this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	   this.addBehaviourGoals();
   }
   
   protected void addBehaviourGoals() 
   {
      this.goalSelector.addGoal(0, new SwimGoal(this));
   }
   
  	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return createBaseHorseAttributes()
				.add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.3F)
				.add(Attributes.JUMP_STRENGTH, 1.2D);
	}
  	
  	
//    protected void randomizeAttributes() {
//        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double)this.generateRandomMaxHealth());
//        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.generateRandomSpeed());
//        this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(this.generateRandomJumpStrength());
//     }
    
   protected void randomizeAttributes() {
      this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double)20.0D);
      this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3F);
      this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.2D);
   }
   
	public CreatureAttribute getMobType() 
	{
		return CreatureAttribute.UNDEAD;
	}
	
	public boolean canBeControlledByRider(boolean controlBool) 
	{
		return this.getControllingPassenger() instanceof LivingEntity; //changed from Living to monster 6/11/21
	}

   public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
      super.addAdditionalSaveData(p_213281_1_);

      if (!this.inventory.getItem(1).isEmpty()) {
         p_213281_1_.put("ArmorItem", this.inventory.getItem(1).save(new CompoundNBT()));
      }

   }

   public ItemStack getArmor() {
      return this.getItemBySlot(EquipmentSlotType.CHEST);
   }

   private void setArmor(ItemStack p_213805_1_) {
      this.setItemSlot(EquipmentSlotType.CHEST, p_213805_1_);
      this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
   }

   public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
      super.readAdditionalSaveData(p_70037_1_);

      if (p_70037_1_.contains("ArmorItem", 10)) {
         ItemStack itemstack = ItemStack.of(p_70037_1_.getCompound("ArmorItem"));
         if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
            this.inventory.setItem(1, itemstack);
         }
      }

      this.updateContainerEquipment();
   }

   protected void updateContainerEquipment() {
      if (!this.level.isClientSide) {
         super.updateContainerEquipment();
         this.setArmorEquipment(this.inventory.getItem(1));
         this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
      }
   }

   private void setArmorEquipment(ItemStack p_213804_1_) {
      this.setArmor(p_213804_1_);
      if (!this.level.isClientSide) {
         this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
         if (this.isArmor(p_213804_1_)) {
            int i = ((HorseArmorItem)p_213804_1_.getItem()).getProtection();
            if (i != 0) {
               this.getAttribute(Attributes.ARMOR).addTransientModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", (double)i, AttributeModifier.Operation.ADDITION));
            }
         }
      }

   }

   public void containerChanged(IInventory p_76316_1_) {
      ItemStack itemstack = this.getArmor();
      super.containerChanged(p_76316_1_);
      ItemStack itemstack1 = this.getArmor();
      if (this.tickCount > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
         this.playSound(SoundEvents.HORSE_ARMOR, 0.5F, 1.0F);
      }

   }



   protected SoundEvent getAmbientSound() {
       super.getAmbientSound();
       return this.isEyeInFluid(FluidTags.WATER) ? SoundEvents.SKELETON_HORSE_AMBIENT_WATER : SoundEvents.ZOMBIE_HORSE_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
       super.getDeathSound();
       return SoundEvents.ZOMBIE_HORSE_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
       super.getHurtSound(p_184601_1_);
       return SoundEvents.ZOMBIE_HORSE_HURT;
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

	public boolean isFood(ItemStack stack) 
	{
		return stack.getItem() == Items.CRIMSON_FUNGUS || stack.getItem() == Items.NETHER_WART;
	}
    
   public ActionResultType mobInteract(PlayerEntity player, Hand stack) {
      ItemStack itemstack = player.getItemInHand(stack);
      if (!this.isBaby()) {
         if (this.isTamed() && player.isSecondaryUseActive()) {
            this.openInventory(player);
            return ActionResultType.sidedSuccess(this.level.isClientSide);
         }

         if (this.isVehicle()) {
            return super.mobInteract(player, stack);
         }
      }

      if (!itemstack.isEmpty()) {
         if (this.isFood(itemstack)) {
            return this.fedFood(player, itemstack);
         }

         ActionResultType actionresulttype = itemstack.interactLivingEntity(player, this, stack);
         if (actionresulttype.consumesAction()) {
            return actionresulttype;
         }

         if (!this.isTamed()) {
            this.makeMad();
            return ActionResultType.sidedSuccess(this.level.isClientSide);
         }

         boolean flag = !this.isBaby() && !this.isSaddled() && itemstack.getItem() == Items.SADDLE;
         if (this.isArmor(itemstack) || flag) {
            this.openInventory(player);
            return ActionResultType.sidedSuccess(this.level.isClientSide);
         }
      }

      if (this.isBaby()) {
         return super.mobInteract(player, stack);
      } else {
         this.doPlayerRide(player);
         return ActionResultType.sidedSuccess(this.level.isClientSide);
      }
   }

	public boolean canEatGrass() 
	{
		return false;
	}
	
   public boolean canMate(AnimalEntity p_70878_1_) {
	   return false;
   }

	@Override
	public boolean canBreed() 
	{
		return false;
	}
   
	public boolean isBaby() 
	{
		return false;
	}
	
   public boolean canWearArmor() {
      return true;
   }

   public boolean isArmor(ItemStack p_190682_1_) {
      return p_190682_1_.getItem() instanceof HorseArmorItem;
   }

   public boolean rideableUnderWater() 
   {
  	 return true;
   }

   protected float getWaterSlowDown() 
   {
  	 return 0.96F;
   }
   
   protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) 
   {
	      return MathHelper.ceil((p_225508_1_ * 0.5F - 2.0F) * p_225508_2_);
   }
   
	public static boolean checkDeadHorseSpawnRules(EntityType<HexedUndeadHorseEntity> p_234361_0_, IWorld world, SpawnReason p_234361_2_, BlockPos pos, Random p_234361_4_) 
	{
		return world.getBlockState(pos.below()).is(Blocks.CRIMSON_NYLIUM);
		//return !world.getBlockState(pos.below()).is(Blocks.NETHER_WART_BLOCK) && !world.getBlockState(pos.below()).is(Blocks.AIR) && !world.getBlockState(pos.below()).is(Blocks.LAVA);
	}
	
	public boolean removeWhenFarAway(double p_213397_1_) 
	{
		return !this.isPersistenceRequired();
	}
	
	public float getWalkTargetValue(BlockPos pos, IWorldReader worldReader) 
	{
		return worldReader.getBlockState(pos.below()).is(Blocks.CRIMSON_NYLIUM) ? 10.0F : 0.0F;
	}
	
//   	public double getPassengersRidingOffset() 
//	{
//   		return super.getPassengersRidingOffset() - 0.0D;
//	}
   
   @Nullable
   public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficulty, SpawnReason spawnR, @Nullable ILivingEntityData livingDat, @Nullable CompoundNBT nbtDat) 
   {
      livingDat = super.finalizeSpawn(serverWorld, difficulty, spawnR, livingDat, nbtDat);

      this.setBaby(false);

      return livingDat;
   }
}
