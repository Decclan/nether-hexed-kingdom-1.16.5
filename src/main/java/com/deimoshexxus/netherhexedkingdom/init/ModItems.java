package com.deimoshexxus.netherhexedkingdom.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import com.deimoshexxus.netherhexedkingdom.item.MilitusAlloyShield;
import com.deimoshexxus.netherhexedkingdom.item.ModItemGroupIcon;
import com.deimoshexxus.netherhexedkingdom.item.SkeletonBoneShield;
//import com.deimoshexxus.netherhexedkingdom.item.WitheredDeathShield;
import com.deimoshexxus.netherhexedkingdom.item.material.ModArmorMaterial;

public class ModItems {
	public static final RegistryObject<Item> MILITUS_ALLOY_INGOT = Registration.ITEMS.register("militus_alloy_ingot", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	public static final RegistryObject<Item> MILITUS_ALLOY_NUGGET = Registration.ITEMS.register("militus_alloy_nugget", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
//	public static final RegistryObject<Item> GOLD_CLUMP = Registration.ITEMS.register("gold_clump", () -> 
//			new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static final RegistryObject<Item> IRON_CLUMP = Registration.ITEMS.register("iron_clump", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	public static final RegistryObject<Item> NETHERITE_FRAGMENT_BUNDLE = Registration.ITEMS.register("netherite_fragment_bundle", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)
					.fireResistant()));
	
	public static final RegistryObject<Item> NETHERITE_FRAGMENT = Registration.ITEMS.register("netherite_fragment", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)
					.fireResistant()));
	
	public static final RegistryObject<Item> NETHERITE_OXIDE = Registration.ITEMS.register("netherite_oxide", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)
					.fireResistant()));
	
	public static final RegistryObject<Item> IMPERIAL_COINS = Registration.ITEMS.register("imperial_coins", () -> 
			new Item(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	public static final RegistryObject<MilitusAlloyShield> MILITUS_ALLOY_SHIELD = Registration.ITEMS.register("militus_alloy_shield", () -> 
			new MilitusAlloyShield(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)
					.durability(366)));
	
	public static final RegistryObject<SkeletonBoneShield> SKELETON_BONE_SHIELD = Registration.ITEMS.register("skeleton_bone_shield", () -> 
			new SkeletonBoneShield(new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)
					.durability(188)));

//	public static final RegistryObject<WitheredDeathShield> WITHERED_DEATH_SHIELD = Registration.ITEMS.register("withered_death_shield", () -> 
//			new WitheredDeathShield(new Item.Properties().tab(ModItemGroup.NETHER_HEXED_GROUP)
//					.durability(433)));
	
	public static final RegistryObject<Item> MILITUS_ALLOY_BOOTS = Registration.ITEMS.register("militus_alloy_boots", () -> 
			new ArmorItem(ModArmorMaterial.MILITUS_ALLOY, EquipmentSlotType.FEET,
					new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	public static final RegistryObject<Item> MILITUS_ALLOY_CHESTPLATE = Registration.ITEMS.register("militus_alloy_chestplate", () -> 
	new ArmorItem(ModArmorMaterial.MILITUS_ALLOY, EquipmentSlotType.CHEST,
			new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	public static final RegistryObject<Item> MILITUS_ALLOY_LEGGINGS = Registration.ITEMS.register("militus_alloy_leggings", () -> 
	new ArmorItem(ModArmorMaterial.MILITUS_ALLOY, EquipmentSlotType.LEGS,
			new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	public static final RegistryObject<Item> MILITUS_ALLOY_HELMET = Registration.ITEMS.register("militus_alloy_helmet", () -> 
	new ArmorItem(ModArmorMaterial.MILITUS_ALLOY, EquipmentSlotType.HEAD,
			new Item.Properties().tab(ModItemGroupIcon.NETHER_HEXED_GROUP)));
	
	static void register() {}
	

		
}
