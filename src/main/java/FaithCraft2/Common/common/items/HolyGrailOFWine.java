package FaithCraft2.Common.common.items;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyGrailOFWine extends ItemFood{
	
	public HolyGrailOFWine(int x, float y, boolean alwaysEdible) {
		super(x, y, alwaysEdible);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz){
		world.setBlock(x, y+1, z, FaithCraft2.WineBlock, 0, 3);
		player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(FaithCraft2.HolyGrail));
		return true;
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            //par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.blindness.id, 600, 0));
            //par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
            //par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 1));
        	par3EntityPlayer.travelToDimension(FaithCraft2.HeavenId);
        }

        return par1ItemStack.stackSize <= 0 ? new ItemStack(FaithCraft2.HolyGrail) : par1ItemStack;
    }
}