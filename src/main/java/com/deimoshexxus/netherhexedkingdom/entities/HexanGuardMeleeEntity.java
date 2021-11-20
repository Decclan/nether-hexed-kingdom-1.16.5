package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.Random;

import javax.annotation.Nullable;

import com.deimoshexxus.netherhexedkingdom.init.ModItems;
import com.deimoshexxus.netherhexedkingdom.init.SoundsHandler;

import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
//import net.minecraft.entity.monster.WitherSkeletonEntity;
//import net.minecraft.entity.monster.MagmaCubeEntity;
//import net.minecraft.entity.passive.StriderEntity;
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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
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
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class HexanGuardMeleeEntity extends AbstractSkeletonEntity
	{

	public HexanGuardMeleeEntity(EntityType<? extends AbstractSkeletonEntity> type, World worldIn) 
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

	public CreatureAttribute getMobType() 
	{
		return CreatureAttribute.UNDEAD;
	}
	
	@Override
	protected int getExperienceReward(PlayerEntity player) 
	{
		return 3 + this.random.nextInt(5);
	}
	
	private void applyOpenDoorsAbility() 
	{
		if (GroundPathHelper.hasGroundPathNavigation(this)) 
		{
			((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(true);
		}
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_)
	{
		super.populateDefaultEquipmentSlots(p_180481_1_);
		int chance = 1 + (int) (Math.random() * 10);
		if (chance >= 8)
		{
			this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
		} else if (chance <= 3)
		{
			this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_AXE));
		} else {
			this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_SWORD));
		}
		if (chance >= 3)
		{
			this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(ModItems.MILITUS_ALLOY_HELMET.get()));
		}
		this.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(ModItems.MILITUS_ALLOY_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlotType.LEGS, new ItemStack(ModItems.MILITUS_ALLOY_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlotType.FEET, new ItemStack(ModItems.MILITUS_ALLOY_BOOTS.get()));
		this.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(ModItems.MILITUS_ALLOY_SHIELD.get()));
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
	
	public static boolean checkGuardSpawnRules(EntityType<HexanGuardMeleeEntity> entity, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) 
	{
	      BlockPos.Mutable blockpos$mutable = pos.mutable();

	      do {
	         blockpos$mutable.move(Direction.DOWN);
	      } while(!world.getFluidState(blockpos$mutable).is(FluidTags.LAVA)); //&& !world.getBlockState(blockpos$mutable).is(Blocks.AIR)

	      return world.getBlockState(blockpos$mutable).is(Blocks.NETHER_BRICKS);
	   }
	
	   public boolean checkSpawnObstruction(IWorldReader p_205019_1_) {
		      return p_205019_1_.isUnobstructed(this) && !p_205019_1_.containsAnyLiquid(this.getBoundingBox());
		   }
//		return serverWorld.getDifficulty() != Difficulty.PEACEFUL 
//				&& serverWorld.getBlockState(pos.below()).getBlock() == Blocks.NETHER_BRICKS
//				|| serverWorld.getBlockState(pos.below()).getBlock() == Blocks.NETHERRACK
//				&& serverWorld.getBlockState(pos.below()).getBlock() != Blocks.AIR 
//				&& isDarkEnoughToSpawn(serverWorld, pos, random) 
//				&& checkMobSpawnRules(entity, serverWorld, spawnReason, pos, random)
//				&& checkAnyLightMonsterSpawnRules(entity, serverWorld, spawnReason, pos, random)
//				&& checkMonsterSpawnRules(entity, serverWorld, spawnReason, pos, random);
//	}
	
//	   public static boolean checkMobSpawnRules(EntityType<? extends MobEntity> p_223315_0_, IWorld p_223315_1_, SpawnReason p_223315_2_, BlockPos p_223315_3_, Random p_223315_4_) {
//		      BlockPos blockpos = p_223315_3_.below();
//		      return p_223315_2_ == SpawnReason.SPAWNER || p_223315_1_.getBlockState(blockpos).isValidSpawn(p_223315_1_, blockpos, p_223315_0_);
//		   }
//
//	   
//	   
//		   public boolean checkSpawnRules(IWorld p_213380_1_, SpawnReason p_213380_2_) {
//		      return true;
//		   }
//
//	
//	
//	   public boolean checkSpawnObstruction(IWorldReader serverWorld) {
//		      return !serverWorld.containsAnyLiquid(this.getBoundingBox()) && serverWorld.isUnobstructed(this);
//		   }
//	
//	   public static boolean isDarkEnoughToSpawn(IServerWorld serverWorld, BlockPos pos, Random random) {
//		      if (serverWorld.getBrightness(LightType.SKY, pos) > random.nextInt(32)) {
//		         return false;
//		      } else {
//		         int i = serverWorld.getLevel().isThundering() ? serverWorld.getMaxLocalRawBrightness(pos, 10) : serverWorld.getMaxLocalRawBrightness(pos);
//		         return i <= random.nextInt(8);
//		      }
//		   }
//
//		   public static boolean checkMonsterSpawnRules(EntityType<? extends MonsterEntity> entity, IServerWorld serverWorld, SpawnReason spawnReason, BlockPos pos, Random random) {
//		      return serverWorld.getDifficulty() != Difficulty.PEACEFUL 
//		    		  && isDarkEnoughToSpawn(serverWorld, pos, random) 
//		    		  && checkMobSpawnRules(entity, serverWorld, spawnReason, pos, random);
//		   }
//
//		   public static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends MonsterEntity> p_223324_0_, IWorld p_223324_1_, SpawnReason p_223324_2_, BlockPos p_223324_3_, Random p_223324_4_) {
//		      return p_223324_1_.getDifficulty() != Difficulty.PEACEFUL 
//		    		  && checkMobSpawnRules(p_223324_0_, p_223324_1_, p_223324_2_, p_223324_3_, p_223324_4_);
//		   }
	
//	   private static List<MobSpawnInfo.Spawners> mobsAt(ServerWorld p_241463_0_, StructureManager p_241463_1_, ChunkGenerator p_241463_2_, EntityClassification p_241463_3_, BlockPos p_241463_4_, @Nullable Biome p_241463_5_) {
//		      return p_241463_3_ == EntityClassification.MONSTER && p_241463_0_.getBlockState(p_241463_4_.below()).getBlock() == Blocks.NETHER_BRICKS && p_241463_1_.getStructureAt(p_241463_4_, false, Structure.NETHER_BRIDGE).isValid() ? Structure.NETHER_BRIDGE.getSpecialEnemies() : p_241463_2_.getMobsAt(p_241463_5_ != null ? p_241463_5_ : p_241463_0_.getBiome(p_241463_4_), p_241463_1_, p_241463_3_, p_241463_4_);
//		   }
	
//	   public static boolean checkMobSpawnRules(EntityType<? extends MobEntity> p_223315_0_, IWorld p_223315_1_, SpawnReason p_223315_2_, BlockPos p_223315_3_, Random p_223315_4_) {
//		      BlockPos blockpos = p_223315_3_.below();
//		      return p_223315_2_ == SpawnReason.SPAWNER || p_223315_1_.getBlockState(blockpos).isValidSpawn(p_223315_1_, blockpos, p_223315_0_);
//		   }
	
//	public static boolean canSpawn(EntityType<HexanGuardMeleeEntity> type, IServerWorld world, 
//			SpawnReason spawnReason, BlockPos pos, Random random)
//	{
//		if (checkMonsterSpawnRules(type, world, spawnReason, pos, random));
//		{
//			int x = pos.getX();
//			int z = pos.getZ();
//			int height = world.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX(), pos.getZ());
//			BlockPos blockpos = new BlockPos(x, height, z);
//			AxisAlignedBB box = new AxisAlignedBB(pos).inflate(8);
//			List<HexanGuardMeleeEntity> entities = world.getEntitiesOfClass(HexanGuardMeleeEntity.class, box, (entity) -> {return true;});
//			
//			if ((world.getBlockState(blockpos.below()).getBlock() == Blocks.AIR) && (world.getBlockState(blockpos).getBlock() == Blocks.AIR))
//			{
//				return false;
//			}else {
//				return entities.size() < 3;
//			}
//		}
//		
//	}

	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData livingDat, @Nullable CompoundNBT compNBT) 
	{
		ILivingEntityData ilivingentitydata = super.finalizeSpawn(world, difficulty, spawnReason, livingDat, compNBT);
		this.reassessWeaponGoal();
		return ilivingentitydata;
	}
}
