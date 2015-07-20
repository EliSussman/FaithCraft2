package FaithCraft2.Common.common.items;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
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
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL3){
			target.addPotionEffect(new PotionEffect(Potion.poison.id, 500, 2));
		}
		return true;
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add("\u00A7eHanded Down From GOD!");
		if (itemStack.hasTagCompound() == false){
			list.add("\u00A7cRIGHT CLICK TO INITIALIZE");
		}
		if (this == FaithCraft2.HolyStaffOFPower){
			list.add("\u00A7cTier 1");
		}
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL1){
			list.add("\u00A7cTier 2");
		}
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL2){
			list.add("\u00A7cTier 3");
			if (itemStack.hasTagCompound() == true){
				list.add("\u00A72Poison");
			}
		}
		if (this == FaithCraft2.HolyStaffOFPower_LEVEL3){
			list.add("\u00A7cTier 4");
			if (itemStack.hasTagCompound() == true){
				list.add("\u00A72Poison");
			}
		}
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		world.addWeatherEffect(new EntityLightningBolt(world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()));
		if (stack.hasTagCompound() == false){
			if (this == FaithCraft2.HolyStaffOFPower_LEVEL1){
				stack.addEnchantment(Enchantment.fireAspect, 3);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
			if (this == FaithCraft2.HolyStaffOFPower_LEVEL2){
				stack.addEnchantment(Enchantment.fireAspect, 3);
				stack.addEnchantment(Enchantment.knockback, 3);
				stack.addEnchantment(Enchantment.looting, 3);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
			if (this == FaithCraft2.HolyStaffOFPower_LEVEL3){
				stack.addEnchantment(Enchantment.fireAspect, 3);
				stack.addEnchantment(Enchantment.knockback, 3);
				stack.addEnchantment(Enchantment.looting, 3);
				stack.addEnchantment(Enchantment.sharpness, 10);
				stack.addEnchantment(Enchantment.fortune, 3);
				stack.addEnchantment(Enchantment.efficiency, 10);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
		}
		return true;
	}
}