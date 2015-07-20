package FaithCraft2.Common.common.armor;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyArmor extends ItemArmor{
	
	public HolyArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int type) {
	    super(material, renderIndex, type);
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) {
		list.add("\u00A7eFULL SET BONUS: FLYING");
		if (itemStack.hasTagCompound() == false){
			list.add("\u00A7cRIGHT CLICK TO INITIALIZE");
		}
	}
	
	@Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
	
	@Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
		if (this.isWearingFullSetHoly(player, FaithCraft2.HolyHelmet, FaithCraft2.HolyChestplate, FaithCraft2.HolyLeggings, FaithCraft2.HolyBoots)){
			if(player.capabilities.allowFlying == false){
				player.capabilities.allowFlying = true;
			}
		}else{
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
		}
	}
	
	public static boolean isWearingFullSetHoly(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		world.addWeatherEffect(new EntityLightningBolt(world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()));
		if (stack.hasTagCompound() == false){
			if (this == FaithCraft2.HolyHelmet){
				stack.addEnchantment(Enchantment.respiration, 1);
				stack.addEnchantment(Enchantment.protection, 10);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
			if (this == FaithCraft2.HolyChestplate){
				stack.addEnchantment(Enchantment.blastProtection, 10);
				stack.addEnchantment(Enchantment.protection, 10);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
			if (this == FaithCraft2.HolyLeggings){
				stack.addEnchantment(Enchantment.projectileProtection, 10);
				stack.addEnchantment(Enchantment.protection, 10);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
			if (this == FaithCraft2.HolyBoots){
				stack.addEnchantment(Enchantment.featherFalling, 5);
				stack.addEnchantment(Enchantment.protection, 10);
				stack.setTagInfo("Initiated", new NBTTagString("Enchanted"));
			}
		}
		return true;
	}
}
