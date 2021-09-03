package com.deimoshexxus.netherhexedkingdom.item;

import com.deimoshexxus.netherhexedkingdom.init.ModItems;
import com.deimoshexxus.netherhexedkingdom.init.ModTags;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.UseAction;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MilitusAlloyShield extends Item
{
//	IForgeItem::isShield
	public MilitusAlloyShield(Item.Properties prop) {
		super(prop);
//		this.canBeDepleted();
//		this.showDurabilityBar(getDefaultInstance());
//		this.isDamageable(getDefaultInstance());
//		this.getDamage(getDefaultInstance());
//		this.canBeHurtBy(null);
		
	}
	
	public boolean isValidRepairItem(ItemStack stack1, ItemStack stack2) 
	{
		return ModTags.Items.INGOTS_MILITUS.contains(stack2.getItem()) || super.isValidRepairItem(stack1, stack2);
	}

	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) 
	{
		return true;
	}
	
	@Override
	public boolean isDamageable(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public boolean canBeDepleted() 
	{
		return true;
	}
	
	@Override
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return (double) stack.getDamageValue() / (double) stack.getMaxDamage();
    }
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) 
	{
		return stack.isDamaged();
	}
	
//	@Override
//	public int getEntityLifespan(ItemStack itemStack, World world) 
//	{
//		return 0;
//	}

	@Override
    public boolean isDamaged(ItemStack stack)
    {
		return stack.getDamageValue() > 0;
    }
	
	@Override
    public void setDamage(ItemStack stack, int damage)
    
    {
        stack.getOrCreateTag().putInt("Damage", Math.max(0, damage));
    }
	
	@Override
	public int getUseDuration(ItemStack stack) 
	{
		return 82000;
	}
	
//	private void canBeRepaired() 
//	{
//
//	}
//	public boolean isValidRepairItem(ItemStack stack1, ItemStack stack2) 
//	{
//	      return ItemTags.createOptional(ModItems.MILITUS_ALLOY_INGOT.getId()).contains(stack2.getItem()) || super.isValidRepairItem(stack1, stack2);
//	}

	public ActionResult<ItemStack> use(World world, PlayerEntity pEntity, Hand hand) 
	{
		ItemStack itemstack = pEntity.getItemInHand(hand);
		pEntity.startUsingItem(hand);
			return ActionResult.consume(itemstack);
	}
	   
	public UseAction getUseAnimation(ItemStack stack) 
	{
		return UseAction.BLOCK;
	}
}
