package FaithCraft2.Common.common.handler;

import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import FaithCraft2.Common.common.FaithCraft2;

public class FaithCraftEventHandler {
	public static FaithCraftEventHandler INSTANCE = new FaithCraftEventHandler();
	
	@SubscribeEvent
	public void fogColors(EntityViewRenderEvent.FogColors event){
		if (event.block == FaithCraft2.wineBlock){
			event.red = 0.5F;
		}
	}
}
