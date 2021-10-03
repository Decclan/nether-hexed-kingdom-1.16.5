package com.deimoshexxus.netherhexedkingdom.item;

import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.World;

public class SkeletonBoneShield extends MilitusAlloyShield
{

	public SkeletonBoneShield(Properties prop) 
	{
		super(prop);
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack1, ItemStack stack2) 
	{
		return ItemTags.NON_FLAMMABLE_WOOD.contains(stack2.getItem()) || super.isValidRepairItem(stack1, stack2);
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return 0;
	}
}
