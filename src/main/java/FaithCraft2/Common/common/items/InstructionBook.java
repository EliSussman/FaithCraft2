package FaithCraft2.Common.common.items;

import java.util.List;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;
import FaithCraft2.Common.common.*;
import FaithCraft2.Common.common.gui.GuiInstructionBook;
import FaithCraft2.Common.common.handler.PlayerSpawnHandler;

public class InstructionBook extends ItemBook{
	
	public InstructionBook(int id){
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		Minecraft.getMinecraft().displayGuiScreen(new GuiInstructionBook());
		return stack;
	}
	
}
