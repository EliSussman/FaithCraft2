package FaithCraft2.Common.common.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.container.ContainerAltar;
import FaithCraft2.Common.common.gui.GuiAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;

public class GuiHandler implements IGuiHandler{
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		if (!player.isSneaking()) {
			
			TileEntity entity = world.getTileEntity(new BlockPos(x,y,z));
	
			if(entity != null) {
				switch(ID) {
				case FaithCraft2.guiIDAltar:
					if (entity instanceof TileEntityAltar) {
						return new ContainerAltar(player.inventory, (TileEntityAltar) entity);
					}
				default:
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		if(!player.isSneaking() && world.isRemote){
			
			TileEntity entity = world.getTileEntity(new BlockPos(x,y,z));
			
			if(entity != null) {
				switch(ID) {
				case FaithCraft2.guiIDAltar:
					if (entity instanceof TileEntityAltar) {
						return new GuiAltar(player.inventory, (TileEntityAltar) entity);
					}
				default:
					return null;
				}
			}
		}
		return null;
	}
}