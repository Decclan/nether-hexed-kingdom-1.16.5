package com.deimoshexxus.netherhexedkingdom.item;

import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup 
{
	public static final ItemGroup NETHER_HEXED_GROUP = new ItemGroup("netherhexedmodtab")
	{
		@Override
		public ItemStack makeIcon() 
		{
			return new ItemStack(ModItems.MILITUS_ALLOY_HELMET.get());
		}
	};
}
