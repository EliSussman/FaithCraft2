package FaithCraft2.Common.common.items;

import java.awt.Event;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.*;

public class HolyGrail extends Item{

	
	public HolyGrail(int id) {
		super();
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	 
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz){
			if(world.getBlock(x, y+1, z) == FaithCraft2.WineBlock){
				world.setBlockToAir(x, y+1, z);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(FaithCraft2.HolyGrailOFWine));
			}
			return true;
	}
	
}
