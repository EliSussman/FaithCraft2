package FaithCraft2.Common.common.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;
import FaithCraft2.Common.common.fluids.WineBlock;

public class HolyGrail extends Item{

	public static final String name = "HolyGrail";
	WineBlock wb = new WineBlock(FaithCraftBlocks.Wine, Material.water);
	
	public HolyGrail(int id) {
		super();
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
	public String getName(){
		return name;
	}
	 
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote){
			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ())) == FaithCraftBlocks.wineBlock.getDefaultState()){
				worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
				playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, new ItemStack(FaithCraft2.HolyGrailOFWine));
			}	
		}
		return true;
	}
	
}