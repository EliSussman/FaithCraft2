package FaithCraft2.Common.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyGrailOFWine extends Item{
	
	public HolyGrailOFWine(int id) {
		super();
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz){
		player.inventory.consumeInventoryItem(FaithCraft2.HolyGrailOFWine);
		world.setBlock(x, y+1, z, FaithCraft2.WineBlock, 0, 3);
		player.inventory.setInventorySlotContents(0, new ItemStack(FaithCraft2.HolyGrail));
		return true;
	}

	
}