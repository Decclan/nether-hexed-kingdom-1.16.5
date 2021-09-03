package com.deimoshexxus.netherhexedkingdom.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

import com.deimoshexxus.netherhexedkingdom.item.MilitusAlloyShield;
import com.deimoshexxus.netherhexedkingdom.item.SkeletonBoneShield;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ShieldItem;

public class ModItems {
	public static final RegistryObject<Item> MILITUS_ALLOY_INGOT = Registration.ITEMS.register("militus_alloy_ingot", () -> 
			new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static final RegistryObject<Item> MILITUS_ALLOY_NUGGET = Registration.ITEMS.register("militus_alloy_nugget", () -> 
			new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static final RegistryObject<MilitusAlloyShield> MILITUS_ALLOY_SHIELD = Registration.ITEMS.register("militus_alloy_shield", () -> 
			new MilitusAlloyShield(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)
					.durability(366)
					.fireResistant()));
	
	public static final RegistryObject<SkeletonBoneShield> SKELETON_BONE_SHIELD = Registration.ITEMS.register("skeleton_bone_shield", () -> 
			new SkeletonBoneShield(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)
					.durability(188)
					.fireResistant()));

	
	static void register() {}
}
