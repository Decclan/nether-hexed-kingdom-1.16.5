//package com.deimoshexxus.netherhexedkingdom.item;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.function.Supplier;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;
//
//import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
//
//import net.minecraft.block.DispenserBlock;
//import net.minecraft.dispenser.DefaultDispenseItemBehavior;
//import net.minecraft.dispenser.IBlockSource;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.SpawnReason;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.SpawnEggItem;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.util.Direction;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
//import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//
//@EventBusSubscriber(modid = NetherHexedKingdomMain.MOD_ID, bus = Bus.MOD)
//public class ModSpawnEggItem extends SpawnEggItem {
//
//	private static final Map<Supplier<EntityType<?>>, SpawnEggItem> MOD_EGGS = new HashMap<>();
//
//	private static final DefaultDispenseItemBehavior SPAWN_EGG_BEHAVIOR = new DefaultDispenseItemBehavior() 
//	{
//		public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
//			Direction direction = source.getBlockState().get(DispenserBlock.FACING);
//			((SpawnEggItem) stack.getItem()).getType(stack.getTag()).spawn(source.getLevel(), stack, null,
//					source.getPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
//			stack.shrink(1);
//			return stack;
//		}
//	};
//
//	private Supplier<EntityType<?>> type;
//
//	public ModSpawnEggItem(Supplier<EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn,
//			Properties builder) {
//		super(null, primaryColorIn, secondaryColorIn, builder);
//		this.type = typeIn;
//		DispenserBlock.registerBehavior(this, SPAWN_EGG_BEHAVIOR);
//		MOD_EGGS.put(typeIn, this);
//	}
//
//	@Override
//	public EntityType<?> getType(CompoundNBT nbt) {
//		if (nbt != null && nbt.contains("EntityTag", 10)) {
//			CompoundNBT compoundnbt = nbt.getCompound("EntityTag");
//			if (compoundnbt.contains("id", 8)) {
//				return EntityType.byString(compoundnbt.getString("id")).orElse(type.get());
//			}
//		}
//		return type.get();
//	}
//
//	@SubscribeEvent
//	public static void setup(FMLCommonSetupEvent event) {
//		event.enqueueWork(() -> {
//			try {
//			Map<EntityType<?>, SpawnEggItem> eggs = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class,
//					null, "field_195987_b");
//			for (Entry<Supplier<EntityType<?>>, SpawnEggItem> entry : MOD_EGGS.entrySet())
//				eggs.put(entry.getKey().get(), entry.getValue());
//			} catch (Exception e) {
//				NetherHexedKingdomMain.LOGGER.warn("Unable to access SpawnEggItem.EGGS");
//			} 
//		});
//	}
//}
//
////public class ModSpawnEggItem  extends SpawnEggItem
////{
////	protected static final List<ModSpawnEggItem> EGGS_TO_ADD = new ArrayList<>();
////	
////	private final Lazy<? extends EntityType<?>> lazyEntity;
////	
////	public ModSpawnEggItem(EntityType<?> entity, final int primaryColor, final int secondaryColor, final Item.Properties properties) 
////	{
////		super(null, primaryColor, secondaryColor, properties);
////		this.lazyEntity = Lazy.of(null);
////		EGGS_TO_ADD.add(this);
////	}
////
////	@Override
////	public EntityType<?> getType(CompoundNBT nbt) 
////	{
////		return this.lazyEntity.get();
////	}
////}
