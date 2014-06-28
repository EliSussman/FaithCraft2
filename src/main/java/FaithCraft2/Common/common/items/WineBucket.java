package FaithCraft2.Common.common.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class WineBucket extends ItemBucket{

	public WineBucket(Block fluidBlock) {
		super(fluidBlock);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 600, 4));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 4));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 600, 4));
        }

        return par1ItemStack.stackSize <= 0 ? new ItemStack(Items.bucket) : par1ItemStack;
    }

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

}
