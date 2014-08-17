package FaithCraft2.Common.common.items;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import FaithCraft2.Common.common.*;
import FaithCraft2.Common.common.handler.PlayerSpawnHandler;

public class InstructionBook extends ItemEditableBook{

	public InstructionBook(int id){
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return true;
    }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		int x = 0;
		int y = 0;
		int z = 0;
		player.openGui(FaithCraft2.instance, FaithCraft2.guiIDAltar, world, x, y, z);
		
		return stack;
		
	}
	
}
