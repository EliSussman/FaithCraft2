package FaithCraft2.Common.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;

public class HolyGrailOFWine extends ItemFood{
	
	public static final String name = "HolyGrailOFWine";
	
	public HolyGrailOFWine(int x, float y, boolean alwaysEdible) {
		super(x, y, alwaysEdible);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		if (!worldIn.isRemote){
			worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), FaithCraftBlocks.wineBlock.getDefaultState(), 0);
			playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, new ItemStack(FaithCraft2.HolyGrail));
		}
		return true;
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.DRINK;
    }
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        if (!player.capabilities.isCreativeMode)
        {
            stack.stackSize = 0;
        }
        if (!worldIn.isRemote)
        {
        	player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
        	player.addPotionEffect(new PotionEffect(Potion.absorption.id, 600, 4));
        	player.addPotionEffect(new PotionEffect(Potion.confusion.id, 500, 1));
        	player.addPotionEffect(new PotionEffect(Potion.hunger.id, 500, 2));
        }
    }
}