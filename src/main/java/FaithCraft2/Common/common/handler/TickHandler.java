package FaithCraft2.Common.common.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.armor.HolyArmor;

public class TickHandler {
	
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event){
		if (event.entityLiving != null){
			if(event.entityLiving instanceof EntityPlayer){ 
				EntityPlayer player = ((EntityPlayer)event.entityLiving);
				if (HolyArmor.isWearingFullSetHoly(player, FaithCraft2.HolyHelmet, FaithCraft2.HolyChestplate, FaithCraft2.HolyLeggings, FaithCraft2.HolyBoots) != true){
					if(player.capabilities.allowFlying == true && !player.capabilities.isCreativeMode){
						player.capabilities.allowFlying = false;
						player.capabilities.isFlying = false;
					}
				}
			}
		}
	 }
}
