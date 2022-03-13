package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.deimoshexxus.netherhexedkingdom.init.SoundsHandler;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


//import net.minecraft.entity.monster.PhantomEntity;
//import net.minecraft.entity.projectile.WitherSkullEntity;
//import net.minecraft.entity.projectile.;

public class VolcanDaemon extends FlyingEntity 
{
	private static final DataParameter<Boolean> DATA_IS_CHARGING = EntityDataManager.defineId(VolcanDaemon.class, DataSerializers.BOOLEAN);
	//private BlockPos anchorPoint = BlockPos.ZERO;
	private int explosionPower = 2;

	public VolcanDaemon(EntityType<? extends FlyingEntity> type, World world) 
	{
		super(type, world);
		this.xpReward = 10;
	    this.goalSelector.addGoal(5, new VolcanDaemon.RandomFlyGoal(this));
	    this.goalSelector.addGoal(7, new VolcanDaemon.LookAroundGoal(this));
		this.goalSelector.addGoal(7, new VolcanDaemon.FireballAttackGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 12, true, false, (p_213812_1_) -> {
			return Math.abs(p_213812_1_.getY() - this.getY()) <= 4.0D;
		}));
	}
	
   public CreatureAttribute getMobType() 
   {
	    return CreatureAttribute.UNDEAD;
   }
   
   protected boolean shouldDespawnInPeaceful() 
   {
	   return true;
   }
   
   protected void defineSynchedData() 
   {
      super.defineSynchedData();
      this.entityData.define(DATA_IS_CHARGING, false);
   }

	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MonsterEntity.createMonsterAttributes()
		.add(Attributes.FOLLOW_RANGE, 96.0D)
		.add(Attributes.ATTACK_KNOCKBACK, 2.2D)
		.add(Attributes.MOVEMENT_SPEED, 0.2D)
		.add(Attributes.ATTACK_DAMAGE, 3.0D)
		.add(Attributes.ARMOR, 1.0D)
		.add(Attributes.MAX_HEALTH, 26.0D)
		.add(Attributes.FLYING_SPEED, 3.0D);
	}
	   
	   //Firecharge attack goal start//
	   @OnlyIn(Dist.CLIENT)
	   public boolean isCharging() {
	      return this.entityData.get(DATA_IS_CHARGING);
	   }

	   public void setCharging(boolean p_175454_1_) {
	      this.entityData.set(DATA_IS_CHARGING, p_175454_1_);
	   }
	   
	   public int getExplosionPower() 
	   {
		   return this.explosionPower;
	   }
	   
	   static class FireballAttackGoal extends Goal {
		      private final VolcanDaemon daemon;
		      public int chargeTime;

		      public FireballAttackGoal(VolcanDaemon p_i45837_1_) {
		         this.daemon = p_i45837_1_;
		      }

		      public boolean canUse() {
		         return this.daemon.getTarget() != null;
		      }

		      public void start() {
		         this.chargeTime = 0;
		      }

		      public void stop() {
		         this.daemon.setCharging(false);
		      }

		      public void tick() {
		         LivingEntity livingentity = this.daemon.getTarget();
//		         double d0 = 64.0D;
		         if (livingentity.distanceToSqr(this.daemon) < 4096.0D && this.daemon.canSee(livingentity)) {
		            World world = this.daemon.level;
		            ++this.chargeTime;
		            if (this.chargeTime == 10 && !this.daemon.isSilent()) {
		               world.levelEvent((PlayerEntity)null, 1015, this.daemon.blockPosition(), 0);
		            }

		            if (this.chargeTime == 30) {
//		               double d1 = 4.0D;
		               Vector3d vector3d = this.daemon.getViewVector(1.0F);
		               double d2 = livingentity.getX() - (this.daemon.getX() + vector3d.x * 4.0D);
		               double d3 = livingentity.getY(0.5D) - (0.5D + this.daemon.getY(0.5D));
		               double d4 = livingentity.getZ() - (this.daemon.getZ() + vector3d.z * 4.0D);
		               if (!this.daemon.isSilent()) {
		                  world.levelEvent((PlayerEntity)null, 1016, this.daemon.blockPosition(), 0);
		               }

		               FireballEntity fireballentity = new FireballEntity(world, this.daemon, d2, d3, d4);
//		               fireballentity.doEnchantDamageEffects(livingentity, this.daemon);
		               fireballentity.explosionPower = this.daemon.getExplosionPower();
		               fireballentity.setPos(this.daemon.getX() + vector3d.x * 4.0D, this.daemon.getY(), fireballentity.getZ() + vector3d.z * 4.0D);
		               world.addFreshEntity(fireballentity);
		               this.chargeTime = -40;
		            }
		         } else if (this.chargeTime > 0) {
		            --this.chargeTime;
		         }

		         this.daemon.setCharging(this.chargeTime > 10);
		      }
		   }
	   //Firecharge attack goal end//
	   
	   public boolean doHurtTarget(Entity p_70652_1_) 
	   {
		      if (!super.doHurtTarget(p_70652_1_)) {
		         return false;
		      } else {
		         if (p_70652_1_ instanceof LivingEntity) {
		            ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.CONFUSION, 300));
		            ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.HUNGER, 100));
		         }

		         return true;
		      }
	   }
	   
	   //FlyGoal
	   static class RandomFlyGoal extends Goal {
		      private final VolcanDaemon ghast;

		      public RandomFlyGoal(VolcanDaemon p_i45836_1_) {
		         this.ghast = p_i45836_1_;
		         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		      }

		      public boolean canUse() {
		         MovementController movementcontroller = this.ghast.getMoveControl();
		         if (!movementcontroller.hasWanted()) {
		            return true;
		         } else {
		            double d0 = movementcontroller.getWantedX() - this.ghast.getX();
		            double d1 = movementcontroller.getWantedY() - this.ghast.getY();
		            double d2 = movementcontroller.getWantedZ() - this.ghast.getZ();
		            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
		            return d3 < 1.0D || d3 > 3600.0D;
		         }
		      }

		      public boolean canContinueToUse() {
		         return false;
		      }

		      public void start() {
		         Random random = this.ghast.getRandom();
		         double d0 = this.ghast.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
		         double d1 = this.ghast.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
		         double d2 = this.ghast.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
		         this.ghast.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
		      }
		   }
   
	   //Look Goal
	   static class LookAroundGoal extends Goal {
		      private final VolcanDaemon ghast;

		      public LookAroundGoal(VolcanDaemon p_i45839_1_) {
		         this.ghast = p_i45839_1_;
		         this.setFlags(EnumSet.of(Goal.Flag.LOOK));
		      }

		      public boolean canUse() {
		         return true;
		      }

		      public void tick() {
		         if (this.ghast.getTarget() == null) {
		            Vector3d vector3d = this.ghast.getDeltaMovement();
		            this.ghast.yRot = -((float)MathHelper.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI);
		            this.ghast.yBodyRot = this.ghast.yRot;
		         } else {
		            LivingEntity livingentity = this.ghast.getTarget();
		            //double d0 = 64.0D;
		            if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
		               double d1 = livingentity.getX() - this.ghast.getX();
		               double d2 = livingentity.getZ() - this.ghast.getZ();
		               this.ghast.yRot = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
		               this.ghast.yBodyRot = this.ghast.yRot;
		            }
		         }

		      }
		   }
	   
	   
	   public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
		      super.readAdditionalSaveData(p_70037_1_);
//		      if (p_70037_1_.contains("AX")) {
//		         this.anchorPoint = new BlockPos(p_70037_1_.getInt("AX"), p_70037_1_.getInt("AY"), p_70037_1_.getInt("AZ"));
//		      }

		      //this.setPhantomSize(p_70037_1_.getInt("Size"));
		   }

		   public void addAdditionalSaveData(CompoundNBT p_213281_1_) 
		   {
		      super.addAdditionalSaveData(p_213281_1_);
//		      p_213281_1_.putInt("AX", this.anchorPoint.getX());
//		      p_213281_1_.putInt("AY", this.anchorPoint.getY());
//		      p_213281_1_.putInt("AZ", this.anchorPoint.getZ());
		      //p_213281_1_.putInt("Size", this.getPhantomSize());
		   }
   
	protected SoundEvent getAmbientSound() 
	{
		return SoundsHandler.ENTITY_VOLCAN_DAEMON_AMBIENT.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
	{
		return SoundsHandler.ENTITY_VOLCAN_DAEMON_ATTACK.get(); //SoundsHandler.ENTITY_HEXAN_GUARD_HURT.get();
	}
		   
	protected SoundEvent getDeathSound() 
	{
		return null; //SoundsHandler.ENTITY_HEXAN_GUARD_DEATH.get();
	}  
   
	public static boolean daemonSpawnRules(EntityType<VolcanDaemon> type, IServerWorld world, 
			SpawnReason spawnReason, BlockPos pos, Random random)
	{
//		return world.getDifficulty() != Difficulty.PEACEFUL 
//				&& checkMobSpawnRules(type, world, spawnReason, pos, random);
//	   
		if (MonsterEntity.isDarkEnoughToSpawn(world, pos, random) && world.getDifficulty() != Difficulty.PEACEFUL)
		{
			AxisAlignedBB box = new AxisAlignedBB(pos).inflate(64);
			List<VolcanDaemon> entities = world.getEntitiesOfClass(VolcanDaemon.class, box, (entity) -> {return true;});
			checkMobSpawnRules(type, world, spawnReason, pos, random);
			return entities.size() < 6;
		}
		return false;
	}
	
	public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
	//this.anchorPoint = this.blockPosition().above(8);
	//this.setPhantomSize(0);
	return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
	}
}
