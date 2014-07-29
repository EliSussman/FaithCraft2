package FaithCraft2.Common.common.handler;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import FaithCraft2.Common.common.FaithCraft2;

public class ConfigHandler 
{	
	public static Configuration config;
	public static boolean testValue = false;
	
	public static void init(File configFile)
	{	
		if (config == null)
		{	
			config = new Configuration(configFile);
			loadConfiguration();
		}
	}
	
	public static void loadConfiguration()
	{
		config.load();
		
		testValue = config.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is just a test value");
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{	
		if(event.modID.equalsIgnoreCase(FaithCraft2.modid))
		{
			loadConfiguration();
		}
	}
}
