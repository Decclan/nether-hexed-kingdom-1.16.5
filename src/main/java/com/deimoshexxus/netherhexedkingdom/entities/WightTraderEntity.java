package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.INPC;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class WightTraderEntity extends WightEntity implements INPC, IMerchant 
{
//	   private static final DataParameter<Integer> DATA_UNHAPPY_COUNTER = EntityDataManager.defineId(AbstractVillagerEntity.class, DataSerializers.INT);
	   @Nullable
	   private PlayerEntity tradingPlayer;
	   @Nullable
	   protected MerchantOffers offers;
	   private final Inventory inventory = new Inventory(8);


	public WightTraderEntity(EntityType<? extends WightEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.applyOpenDoorsAbility();
	    this.setCanPickUpLoot(true);
	    this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 8.0F);
	    this.removeVehicle();
	}


	
	protected void registerGoals() 
	{
		super.registerGoals();
		this.goalSelector.addGoal(2, new RestrictSunGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombifiedPiglinEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.addBehaviourGoals();
	}
	
   protected void addBehaviourGoals() 
   {
	   	this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
	    this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
	    this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(WightEntity.class));
	}

//	public static AttributeModifierMap.MutableAttribute createAttributes() 
//	{
//		return MonsterEntity.createMonsterAttributes()
//		.add(Attributes.FOLLOW_RANGE, 24.0D)
//		.add(Attributes.ATTACK_KNOCKBACK, 6.0D)
//		.add(Attributes.MOVEMENT_SPEED, 0.3D)
//		.add(Attributes.ATTACK_DAMAGE, 4.5D)
//		.add(Attributes.ARMOR, 2.0D)
//		.add(Attributes.MAX_HEALTH, 24.0D);
//	}
	

	   public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		      ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
//		      if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.isTrading() && !this.isBaby()) {

		      if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.isBaby()) {
		         if (p_230254_2_ == Hand.MAIN_HAND) {
		            p_230254_1_.awardStat(Stats.TALKED_TO_VILLAGER);
		         }

		         if (this.getOffers().isEmpty()) {
		            return ActionResultType.sidedSuccess(this.level.isClientSide);
		         } else {
		            if (!this.level.isClientSide) {
		               this.setTradingPlayer(p_230254_1_);
		               this.openTradingScreen(p_230254_1_, this.getDisplayName(), 1);
		            }

		            return ActionResultType.sidedSuccess(this.level.isClientSide);
		         }
		      } 
		      	else {
		         return super.mobInteract(p_230254_1_, p_230254_2_);
		      }
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
	public void setTradingPlayer(PlayerEntity p_70932_1_) 
	{
		this.tradingPlayer = p_70932_1_;
	}



	@Override
	public PlayerEntity getTradingPlayer() {
		return this.tradingPlayer;
	}

	public boolean canBeLeashed(PlayerEntity p_184652_1_) 
	{
	    return false;
	}

   protected void stopTrading() 
   {
	      this.setTradingPlayer((PlayerEntity)null);
   }
	
	
	@Override
	public MerchantOffers getOffers() {
	      if (this.offers == null) 
	      {
	          this.offers = new MerchantOffers();
	          this.updateTrades();
	       }

	       return this.offers;
	}

	   public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
		      super.addAdditionalSaveData(p_213281_1_);
		      MerchantOffers merchantoffers = this.getOffers();
		      if (!merchantoffers.isEmpty()) {
		         p_213281_1_.put("Offers", merchantoffers.createTag());
		      }

		      p_213281_1_.put("Inventory", this.inventory.createTag());
		   }

		   public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
		      super.readAdditionalSaveData(p_70037_1_);
		      if (p_70037_1_.contains("Offers", 10)) {
		         this.offers = new MerchantOffers(p_70037_1_.getCompound("Offers"));
		      }

		      this.inventory.fromTag(p_70037_1_.getList("Inventory", 10));
		   }

	
	//VillagerTrades.ITrade[] handles trade list
	
	   protected void addOffersFromItemListings(MerchantOffers p_213717_1_, VillagerTrades.ITrade[] p_213717_2_, int p_213717_3_) {
		      Set<Integer> set = Sets.newHashSet();
		      if (p_213717_2_.length > p_213717_3_) {
		         while(set.size() < p_213717_3_) {
		            set.add(this.random.nextInt(p_213717_2_.length));
		         }
		      } else {
		         for(int i = 0; i < p_213717_2_.length; ++i) {
		            set.add(i);
		         }
		      }

		      for(Integer integer : set) {
		         VillagerTrades.ITrade villagertrades$itrade = p_213717_2_[integer];
		         MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.random);
		         if (merchantoffer != null) {
		            p_213717_1_.add(merchantoffer);
		         }
		      }

		   }
	   
	   protected void updateTrades() {
		      VillagerTrades.ITrade[] avillagertrades$itrade = VillagerTrades.WANDERING_TRADER_TRADES.get(1);
		      VillagerTrades.ITrade[] avillagertrades$itrade1 = VillagerTrades.WANDERING_TRADER_TRADES.get(2);
		      if (avillagertrades$itrade != null && avillagertrades$itrade1 != null) {
		         MerchantOffers merchantoffers = this.getOffers();
		         this.addOffersFromItemListings(merchantoffers, avillagertrades$itrade, 5);
		         int i = this.random.nextInt(avillagertrades$itrade1.length);
		         VillagerTrades.ITrade villagertrades$itrade = avillagertrades$itrade1[i];
		         MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.random);
		         if (merchantoffer != null) {
		            merchantoffers.add(merchantoffer);
		         }

		      }
		   }

	   public Inventory getInventory() {
		      return this.inventory;
		   }

		   public boolean setSlot(int p_174820_1_, ItemStack p_174820_2_) {
		      if (super.setSlot(p_174820_1_, p_174820_2_)) {
		         return true;
		      } else {
		         int i = p_174820_1_ - 300;
		         if (i >= 0 && i < this.inventory.getContainerSize()) {
		            this.inventory.setItem(i, p_174820_2_);
		            return true;
		         } else {
		            return false;
		         }
		      }
		   }
	   
	@Override
	public void overrideOffers(MerchantOffers p_213703_1_) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifyTrade(MerchantOffer p_213704_1_) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifyTradeUpdated(ItemStack p_110297_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public World getLevel() {
		return this.level;
	}

	@Override
	public int getVillagerXp() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void overrideXp(int p_213702_1_) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean showProgressBar() 
	{
		return false;
	}

	@Override
	public SoundEvent getNotifyTradeSound() 
	{
		return null;
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
	
	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficulty, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
		ILivingEntityData ilivingentitydata = super.finalizeSpawn(serverWorld, difficulty, p_213386_3_, p_213386_4_, p_213386_5_);
//		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
//		this.getVehicle();

//		{
//			SkeletonHorseEntity skeletonhorseentity = EntityType.SKELETON_HORSE.create(this.level);
//		      skeletonhorseentity.finalizeSpawn((ServerWorld)this.level, difficulty, SpawnReason.TRIGGERED, (ILivingEntityData)null, (CompoundNBT)null);
//		      skeletonhorseentity.setPos(this.getX(), this.getY(), this.getZ());
//		      skeletonhorseentity.setPersistenceRequired();
//		      skeletonhorseentity.setTamed(true);
//		      skeletonhorseentity.setAge(0);
//		      skeletonhorseentity.isVehicle();
////		      skeletonhorseentity.getControllingPassenger();
//		}
		
//		this.getVehicle();
//		this.startRiding(SkeletonHorseEntity, p_184205_2_);
//		this.startRiding(vehicle);
//		this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_SWORD));
//		this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
//		this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.LEATHER_HELMET));
		return ilivingentitydata;
	}
}
