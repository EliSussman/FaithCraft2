package FaithCraft2.Common.common.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyCross extends ItemSword{

	private final String name = "HolyCross";
	
	public HolyCross(int i, ToolMaterial j){
		super(j);
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