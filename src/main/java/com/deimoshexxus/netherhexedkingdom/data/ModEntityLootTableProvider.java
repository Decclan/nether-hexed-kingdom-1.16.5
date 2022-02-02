package com.deimoshexxus.netherhexedkingdom.data;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;
import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.LootingEnchantBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityLootTableProvider extends EntityLootTables
{

	@Override
	protected void addTables()
	{
		this.add(ModEntities.VOLCAN_DAEMON_ENTITY.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
	    			.setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.GUNPOWDER)
	    			.apply(SetCount.setCount(RandomValueRange.between(3.0F, 6.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.COAL)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.GOLD_NUGGET)
	    			.apply(SetCount.setCount(RandomValueRange.between(2.0F, 6.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.BLAZE_POWDER)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));
	
		this.add(ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
	    			.setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.IMPERIAL_COINS.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.MILITUS_ALLOY_NUGGET.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.BONE)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));

		this.add(ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
	    			.setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.IMPERIAL_COINS.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.MILITUS_ALLOY_NUGGET.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 2.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.BONE)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.ARROW)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 6.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));

		
		this.add(ModEntities.HEXAN_GUARD_ENTITY.get(), LootTable.lootTable());
//		this.add(ModEntities.WIGHT_ENTITY.get(), LootTable.lootTable());
//		this.add(ModEntities.WIGHT_KNIGHT_ENTITY.get(), LootTable.lootTable());
//		this.add(ModEntities.WIGHT_TRADER_ENTITY.get(), LootTable.lootTable());
		
		this.add(ModEntities.WITHER_SKELETON_HORSE.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
					.setRolls(ConstantRange.exactly(1))
					.add(ItemLootEntry.lootTableItem(Items.COAL))
					.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
					));
		
		this.add(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
	    			.setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.IMPERIAL_COINS.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(2.0F, 6.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.COAL)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.GOLD_NUGGET)
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));

		this.add(ModEntities.UNDEAD_HORSE.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
					.setRolls(ConstantRange.exactly(1))
					.add(ItemLootEntry.lootTableItem(Items.ROTTEN_FLESH))
					.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
					));
		this.add(ModEntities.UNDEAD_HORSE_RIDER.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
					.setRolls(ConstantRange.exactly(1))
					.add(ItemLootEntry.lootTableItem(Items.ROTTEN_FLESH))
					.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
					));
		this.add(ModEntities.PIGLIN_BESERKER_ENTITY.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
	    			.setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.IMPERIAL_COINS.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(3.0F, 9.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.LEATHER)
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.GOLD_INGOT)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.PORKCHOP)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.BONE)
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));
		
		this.add(ModEntities.PIGLIN_CHIEFTON_ENTITY.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
	    			.setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(ModItems.IMPERIAL_COINS.get())
	    			.apply(SetCount.setCount(RandomValueRange.between(3.0F, 9.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.LEATHER)
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.GOLD_INGOT)
	    			.apply(SetCount.setCount(RandomValueRange.between(2.0F, 6.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.PORKCHOP)
	    			.apply(SetCount.setCount(RandomValueRange.between(1.0F, 3.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
				.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
	    			.add(ItemLootEntry.lootTableItem(Items.BONE)
	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))
	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));

//	    this.add(EntityType.SKELETON, LootTable.lootTable()
//	    		.withPool(LootPool.lootPool()
//	    			.setRolls(ConstantRange.exactly(1))
//	    			.add(ItemLootEntry.lootTableItem(Items.ARROW)
//	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
//	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))))
//	    		.withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1))
//	    			.add(ItemLootEntry.lootTableItem(Items.BONE)
//	    			.apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
//	    			.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))));
		
//		this.add(EntityType.BLAZE, LootTable.lootTable()
//				.withPool(LootPool.lootPool()
//				.setRolls(ConstantRange.exactly(1))
//				.add(ItemLootEntry.lootTableItem(Items.BLAZE_ROD)
//				.apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))
//				.apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F))))
//				.when(KilledByPlayer.killedByPlayer())));
	}

	@Override
	protected Iterable<EntityType<?>> getKnownEntities() 
	{
		return StreamSupport.stream(ForgeRegistries.ENTITIES.spliterator(), false)
				.filter(entry -> entry.getRegistryName() != null && entry.getRegistryName().getNamespace().equals(NetherHexedKingdomMain.MOD_ID))
				.collect(Collectors.toSet());
	}
}
