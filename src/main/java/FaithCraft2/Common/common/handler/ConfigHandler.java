package FaithCraft2.Common.common.handler;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import FaithCraft2.Common.common.FaithCraft2;

public class ConfigHandler {
	
	public static Configuration configuration;
	public static boolean testValue = false;
	
	
	public static void init(File configFile){
		if (configuration == null){
		Configuration configuration = new Configuration(configFile);
		}
	}
		
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equalsIgnoreCase(FaithCraft2.modid)){
			loadConfiguration();
		}
	}
	
	public void loadConfiguration(){
		testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "Example");
	}
}
