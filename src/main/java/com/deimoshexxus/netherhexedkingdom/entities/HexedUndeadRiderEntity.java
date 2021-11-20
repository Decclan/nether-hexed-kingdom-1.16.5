package com.deimoshexxus.netherhexedkingdom.entities;

import java.util.Random;

import javax.annotation.Nullable;

import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
//import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeableArmorItem;
//import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class HexedUndeadRiderEntity extends HexedUndeadHorseEntity {

	public HexedUndeadRiderEntity(EntityType<? extends HexedUndeadHorseEntity> p_i50238_1_, World p_i50238_2_) 
	{
		super(p_i50238_1_, p_i50238_2_);
	}
	
	public static boolean checkSpawnRules(EntityType<? extends HexedUndeadHorseEntity> p_234361_0_, IWorld world, SpawnReason p_234361_2_, BlockPos pos, Random p_234361_4_) 
	{
		return !world.getBlockState(pos.below()).is(Blocks.NETHER_WART_BLOCK) && !world.getBlockState(pos.below()).is(Blocks.AIR) && !world.getBlockState(pos.below()).is(Blocks.LAVA);
	}

	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficulty, SpawnReason spawnR, @Nullable ILivingEntityData livingDat, @Nullable CompoundNBT nbtDat) 
	{
	livingDat = super.finalizeSpawn(serverWorld, difficulty, spawnR, livingDat, nbtDat); 
	{
		SkeletonEntity skeletonentity = EntityType.SKELETON.create(this.level);
 		ItemStack colourLeatherHelmet = new ItemStack(Items.LEATHER_HELMET, 1);
 		((DyeableArmorItem) colourLeatherHelmet.getItem()).setColor(colourLeatherHelmet, 11276561);
        skeletonentity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
        skeletonentity.startRiding(this);
        skeletonentity.finalizeSpawn(serverWorld, difficulty, spawnR, (ILivingEntityData)null, (CompoundNBT)null);
        skeletonentity.setItemSlot(EquipmentSlotType.HEAD, colourLeatherHelmet);
		int chance = 1 + (int) (Math.random() * 10);
		if (chance >= 8)
		{
			skeletonentity.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
			skeletonentity.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(ModItems.SKELETON_BONE_SHIELD.get()));
		} else if (chance <= 3)
		{
			skeletonentity.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
		} else {
			skeletonentity.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_SWORD));
			skeletonentity.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(ModItems.SKELETON_BONE_SHIELD.get()));
		}
        skeletonentity.setItemSlot(EquipmentSlotType.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
        skeletonentity.canPickUpLoot();
	}
//	ItemStack colourLeatherHarmor = new ItemStack(Items.LEATHER_HORSE_ARMOR);
//	((DyeableHorseArmorItem) colourLeatherHarmor.getItem()).setColor(colourLeatherHarmor, 3420722);
//	this.inventory.setItem(1, colourLeatherHarmor);
//	this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
	this.getAttributes();
	this.getControllingPassenger();
    this.setBaby(false);
	return livingDat;
	}
}
