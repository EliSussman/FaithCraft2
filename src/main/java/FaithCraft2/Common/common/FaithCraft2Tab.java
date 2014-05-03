package FaithCraft2.Common.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FaithCraft2Tab extends CreativeTabs{

	public FaithCraft2Tab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	public Item getTabIconItem() {
		return FaithCraft2.Bible;
	}
	
}
