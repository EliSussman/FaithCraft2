/*package FaithCraft2.Common.common.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import FaithCraft2.Common.common.*;

public class PlayerSpawnHandler {

	public static PlayerSpawnHandler INSTANCE = new PlayerSpawnHandler();
	
	private static final String NBT_KEY = "firstJoin";
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer EPlayer = (EntityPlayer) event.entity;
			ItemStack stack = new ItemStack (FaithCraft2.InstructionBook);
			NBTTagCompound data = EPlayer.getEntityData();
			NBTTagCompound persistent;
			if (!data.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
				data.setTag(EntityPlayer.PERSISTED_NBT_TAG, (persistent = new NBTTagCompound()));
			} else {
				persistent = data.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
			}
			if (!persistent.hasKey(NBT_KEY)) {
				persistent.setBoolean(NBT_KEY, true);
				EPlayer.inventory.addItemStackToInventory(stack);
			}
		}
	}
}
*/