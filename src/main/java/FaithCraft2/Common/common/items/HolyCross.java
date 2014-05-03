package FaithCraft2.Common.common.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyCross extends ItemSword{
	
	public HolyCross(int i, ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}

	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
}
