package FaithCraft2.Common.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;

public class WineBucket extends ItemBucket{
	
	private final String name = "WineBucket";
	
	public WineBucket(Block fluidBlock) {
		super(FaithCraftBlocks.wineBlock);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public String getName(){
		return name;
	}

}