package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//private final TriggerSkeletonTrapGoal skeletonTrapGoal = new TriggerSkeletonTrapGoal(this);

public class WitherSkeletonHorseRider extends WitherSkeletonHorseEntity
{
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");

//	private static final DataParameter<Integer> DATA_ID_TYPE_VARIANT = EntityDataManager.defineId(HorseEntity.class, DataSerializers.INT);
	
	public WitherSkeletonHorseRider(EntityType<? extends WitherSkeletonHorseEntity> type, World worldIn) 
	{
		super(type, worldIn);
	}

	public boolean canBeControlledByRider(boolean controlBool) 
	{
		return this.getControllingPassenger() instanceof MonsterEntity;
	}
	
	   protected void registerGoals() 
	   {
		   this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		   this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.0D));
		   this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		   this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		   this.addBehaviourGoals();
//		   this.registerGoals();
	   }
	   
	   public boolean isSaddled()
	   {
		   return this.getFlag(4);
	   }
	
		public void setTamed(boolean tameBool) 
		{
			this.setFlag(2, tameBool);
		}
		
		public boolean isTamed() 
		{
			return this.getFlag(2);
		}
		
	   public boolean isPushable() 
	   {
		      return !this.isVehicle();
	   }

	   public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		      ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		      if (!this.isBaby()) {
		         if (this.isTamed() && p_230254_1_.isSecondaryUseActive()) {
		            this.openInventory(p_230254_1_);
		            return ActionResultType.sidedSuccess(this.level.isClientSide);
		         }

		         if (this.isVehicle()) {
		            return super.mobInteract(p_230254_1_, p_230254_2_);
		         }
		      }

		      if (!itemstack.isEmpty()) {
//		         if (this.isFood(itemstack)) {
//		            return this.fedFood(p_230254_1_, itemstack);
//		         }

		         ActionResultType actionresulttype = itemstack.interactLivingEntity(p_230254_1_, this, p_230254_2_);
		         if (actionresulttype.consumesAction()) {
		            return actionresulttype;
		         }

		         if (!this.isTamed()) {
		            this.makeMad();
		            return ActionResultType.sidedSuccess(this.level.isClientSide);
		         }

		         boolean flag = !this.isBaby() && !this.isSaddled() && itemstack.getItem() == Items.SADDLE;
		         if (this.isArmor(itemstack) || flag) {
		            this.openInventory(p_230254_1_);
		            return ActionResultType.sidedSuccess(this.level.isClientSide);
		         }
		      }

		      if (this.isBaby()) {
		         return super.mobInteract(p_230254_1_, p_230254_2_);
		      } else {
		         this.doPlayerRide(p_230254_1_);
		         return ActionResultType.sidedSuccess(this.level.isClientSide);
		      }
		   }

   	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return createBaseHorseAttributes().add(Attributes.MAX_HEALTH, 17.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.3F)
				.add(Attributes.JUMP_STRENGTH, 1.2D);
	}
   	
    public void addAdditionalSaveData(CompoundNBT p_213281_1_) 
    {
        super.addAdditionalSaveData(p_213281_1_);
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
   
//   protected boolean canAddPassenger(Entity p_184219_1_) 
//   {
//	      return this.getPassengers().size() < 2;
//   }
//    

   public boolean tameWithName(PlayerEntity p_110263_1_) 
   {
	      this.setOwnerUUID(p_110263_1_.getUUID());
//	      this.setTamed(true);
	      if (p_110263_1_ instanceof ServerPlayerEntity) {
	         CriteriaTriggers.TAME_ANIMAL.trigger((ServerPlayerEntity)p_110263_1_, this);
	      }

	      this.level.broadcastEntityEvent(this, (byte)7);
	      return true;
	   }

   
   protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) 
   {
	      return MathHelper.ceil((p_225508_1_ * 0.5F - 2.0F) * p_225508_2_);
   }
   
//   public boolean hasPassenger(Entity p_184196_1_) 
//   {
//      for(Entity entity : this.getPassengers()) 
//      {
//         if (entity.equals(p_184196_1_)) 
//         {
//            return true;
//         }
//      }
//	return false;
//   }
   
//   protected boolean shouldPassengersInheritMalus() { //?????? in MobEntity
//	      return false;
//	   }
   
   @OnlyIn(Dist.CLIENT)
   public boolean showVehicleHealth() 
   {
      return this instanceof WitherSkeletonHorseEntity;
   }
   
   @Nullable
   public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficulty, SpawnReason spawnR, @Nullable ILivingEntityData livingDat, @Nullable CompoundNBT nbtDat) 
   {
      livingDat = super.finalizeSpawn(serverWorld, difficulty, spawnR, livingDat, nbtDat);
      //if (serverWorld.getRandom().nextInt(100) == 0) 
      {
         WitherSkeletonEntity skeletonentity = EntityType.WITHER_SKELETON.create(this.level);
         skeletonentity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
         skeletonentity.finalizeSpawn(serverWorld, difficulty, spawnR, (ILivingEntityData)null, (CompoundNBT)null);
         skeletonentity.startRiding(this);
//         skeletonentity.isPassenger();
         skeletonentity.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.IRON_HELMET));
         skeletonentity.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_AXE));
         skeletonentity.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.SHIELD));
         skeletonentity.canPickUpLoot();
         skeletonentity.fireImmune();
      }
      this.setTamed(true);
      this.inventory.setItem(1, new ItemStack(Items.LEATHER_HORSE_ARMOR));
//      this.isSaddleable();
//      this.isSaddled();
//      this.calculateFallDamage(p_225508_1_, p_225508_2_);
//      this.isVehicle();
//      this.showVehicleHealth();
//      this.getPassengers();
//    this.inventory.setItem(0, new ItemStack(Items.SADDLE));
      this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
      this.getAttributes();
      this.getControllingPassenger();
      return livingDat;
   }
}
