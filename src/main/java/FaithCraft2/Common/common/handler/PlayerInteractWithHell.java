package FaithCraft2.Common.common.handler;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Demon;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlayerInteractWithHell{
	
	public static PlayerInteractWithHell INSTANCE = new PlayerInteractWithHell();
	
	@SubscribeEvent
	public void onPlayerInteracts(PlayerInteractEvent event){
		Demon entityDemon = new Demon(event.world);
		if (event.action == Action.RIGHT_CLICK_BLOCK && 
				event.world.getBlock(event.x, event.y, event.z) == FaithCraft2.HellRock && 
				event.world.getBlock(event.x, event.y + 1, event.z) == FaithCraft2.HellRock && 
				!event.entityPlayer.capabilities.isCreativeMode) {
			event.world.spawnEntityInWorld(entityDemon);
			entityDemon.setPosition(event.x, event.y + 1, event.z);
			event.world.setBlockToAir(event.x, event.y, event.z);
			event.world.setBlockToAir(event.x, event.y + 1, event.z);
		}
	}
}
