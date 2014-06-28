package FaithCraft2.Common.common.items;

import FaithCraft2.Common.common.FaithCraft2;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bible extends Item{

	public Bible(int i){
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
}
