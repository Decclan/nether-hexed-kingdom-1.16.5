package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class VolcanDaemon extends PhantomEntity 
{
	private static final DataParameter<Boolean> DATA_IS_CHARGING = EntityDataManager.defineId(VolcanDaemon.class, DataSerializers.BOOLEAN);
	private BlockPos anchorPoint = BlockPos.ZERO;
	private int explosionPower = 2;

	public VolcanDaemon(EntityType<? extends PhantomEntity> type, World world) 
	{
		super(type, world);
		this.goalSelector.addGoal(7, new VolcanDaemon.FireballAttackGoal(this));
//		this.setPersistenceRequired();
	}
	
   public CreatureAttribute getMobType() 
   {
	    return CreatureAttribute.UNDEAD;
   }
   protected void defineSynchedData() 
   {
      super.defineSynchedData();
      this.entityData.define(DATA_IS_CHARGING, false);
   }

	public static AttributeModifierMap.MutableAttribute createAttributes() 
	{
		return MonsterEntity.createMonsterAttributes()
		.add(Attributes.FOLLOW_RANGE, 128.0D)
		.add(Attributes.ATTACK_KNOCKBACK, 2.2D)
		.add(Attributes.MOVEMENT_SPEED, 0.3D)
		.add(Attributes.ATTACK_DAMAGE, 6.0D)
		.add(Attributes.ARMOR, 3.0D)
		.add(Attributes.MAX_HEALTH, 26.0D)
		.add(Attributes.FLYING_SPEED, 6.0D);
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
		               fireballentity.setPos(this.daemon.getX() + vector3d.x * 4.0D, this.daemon.getY(0.5D) + 0.5D, fireballentity.getZ() + vector3d.z * 4.0D);
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
		            ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.CONFUSION, 200));
		         }

		         return true;
		      }
	   }
   
	   public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
		      super.readAdditionalSaveData(p_70037_1_);
		      if (p_70037_1_.contains("AX")) {
		         this.anchorPoint = new BlockPos(p_70037_1_.getInt("AX"), p_70037_1_.getInt("AY"), p_70037_1_.getInt("AZ"));
		      }

		      this.setPhantomSize(p_70037_1_.getInt("Size"));
		   }

		   public void addAdditionalSaveData(CompoundNBT p_213281_1_) 
		   {
		      super.addAdditionalSaveData(p_213281_1_);
		      p_213281_1_.putInt("AX", this.anchorPoint.getX());
		      p_213281_1_.putInt("AY", this.anchorPoint.getY());
		      p_213281_1_.putInt("AZ", this.anchorPoint.getZ());
		      p_213281_1_.putInt("Size", this.getPhantomSize());
		   }
		   
	public static boolean canSpawn(EntityType<VolcanDaemon> type, IServerWorld world, 
			SpawnReason spawnReason, BlockPos pos, Random random)
	{
		if (MonsterEntity.isDarkEnoughToSpawn(world, pos, random))
		{
			AxisAlignedBB box = new AxisAlignedBB(pos).inflate(128);
			List<VolcanDaemon> entities = world.getEntitiesOfClass(VolcanDaemon.class, box, (entity) -> {return true;});
			int place = world.getChunk(pos).getHeight(Type.WORLD_SURFACE, pos.getX() & 15, pos.getY() & 15);
			if (place > 64 && pos.getZ() >= 96 && entities.size() < 3)
			{
				return true;
			}
			
//			int y = world.getChunk(pos).getHeight(Type.MOTION_BLOCKING, pos.getX() & 15, pos.getY() & 15);
//			return y > 92 && pos.getY() >= 96 && entities.size() < 3;
		}
		return false;
	}
	
	public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) 
	{
	this.anchorPoint = this.blockPosition().above(16);
	//this.setPhantomSize(0);
	return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
	}
}
