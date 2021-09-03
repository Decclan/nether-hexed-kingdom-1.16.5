package com.deimoshexxus.netherhexedkingdom.data;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;
import com.deimoshexxus.netherhexedkingdom.init.ModItems;

import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityLootTableProvider extends EntityLootTables
{

	@Override
	protected void addTables()
	{
		this.add(ModEntities.FACE_EATER_ENTITY.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
				.setRolls(ConstantRange.exactly(1))
				.add(ItemLootEntry.lootTableItem(ModItems.MILITUS_ALLOY_INGOT.get()))
				.apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))
				));
		
		this.add(ModEntities.TEST_ENTITY_FOUR.get(), LootTable.lootTable());
		this.add(ModEntities.TEST_ENTITY_THREE.get(), LootTable.lootTable());
		this.add(ModEntities.TEST_ENTITY_TWO.get(), LootTable.lootTable());
		this.add(ModEntities.WIGHT_ENTITY.get(), LootTable.lootTable());
		this.add(ModEntities.WIGHT_KNIGHT_ENTITY.get(), LootTable.lootTable());
		this.add(ModEntities.WIGHT_TRADER_ENTITY.get(), LootTable.lootTable());
		this.add(ModEntities.WITHER_SKELETON_HORSE.get(), LootTable.lootTable());
		this.add(ModEntities.WITHER_SKELETON_HORSE_RIDER.get(), LootTable.lootTable());
		
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
