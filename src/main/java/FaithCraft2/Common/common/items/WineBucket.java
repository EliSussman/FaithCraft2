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
import net.minecraftforge.fluids.Fluid;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.fluids.WineBlock;

public class WineBucket extends ItemBucket{
	
	private final String name = "WineBucket";
	
	public WineBucket(Block fluidBlock) {
		super(FaithCraft2.wineBlock);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public String getName(){
		return name;
	}

}