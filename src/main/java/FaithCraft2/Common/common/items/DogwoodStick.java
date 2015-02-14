package FaithCraft2.Common.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import FaithCraft2.Common.common.FaithCraft2;

public class DogwoodStick extends Item{

	private final String name = "DogwoodStick";
	
	public DogwoodStick(int i){
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