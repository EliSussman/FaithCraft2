package FaithCraft2.Common.common.items;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import FaithCraft2.Common.common.FaithCraft2;

public class BodyOFChrist extends ItemFood{
	
	private final String name = "BodyOFChrist";
	
	public BodyOFChrist(int healAmount, float saturationModifier, boolean wolvesFavorite, PotionEffect... effects){
		super(healAmount, saturationModifier, wolvesFavorite);
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