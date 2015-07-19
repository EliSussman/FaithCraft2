package FaithCraft2.Common.common.items;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyStaffOFPower extends ItemPickaxe{

	private final String name = "HolyStaffOFPower";
	
	public HolyStaffOFPower(Item.ToolMaterial toolMaterial){
		super(toolMaterial);
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
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker){
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL2){
			target.addPotionEffect(new PotionEffect(Potion.poison.id, 500, 2));
		}
		return true;
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add("\u00A7eHanded Down From GOD!");
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL1){
			list.add("\u00A7cTier 2");
			list.add("\u00A7cFire Aspect");
		}
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL2){
			list.add("\u00A7cTier 3");
			list.add("\u00A7cFire Aspect");
			list.add("\u00A72Poison");
			list.add("\u00A77Knockback");
			list.add("\u00A75Looting");
		}
	}
	
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL1){
			stack.addEnchantment(Enchantment.fireAspect, 10);
		}
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL2){
			stack.addEnchantment(Enchantment.fireAspect, 3);
			stack.addEnchantment(Enchantment.knockback, 3);
			stack.addEnchantment(Enchantment.looting, 3);
		}
	}
}