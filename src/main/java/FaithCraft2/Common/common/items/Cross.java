package FaithCraft2.Common.common.items;

import FaithCraft2.Common.common.FaithCraft2;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class Cross extends ItemSword{
	
	public Cross(int i, ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}

	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
}
