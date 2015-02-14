package FaithCraft2.Common.common.items;

import FaithCraft2.Common.common.FaithCraft2;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Torah extends Item{
	
	private final String name = "Torah";
	
	public Torah(int i){
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
	public String getName(){
		return name;
	}
	
}