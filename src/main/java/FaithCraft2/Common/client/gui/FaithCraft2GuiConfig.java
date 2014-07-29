package FaithCraft2.Common.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import FaithCraft2.Common.common.handler.ConfigHandler;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import FaithCraft2.Common.common.FaithCraft2;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;

public class FaithCraft2GuiConfig extends GuiConfig{
	public FaithCraft2GuiConfig(GuiScreen guiScreen)
	{
		super (guiScreen,
				new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
					FaithCraft2.modid,
					false,
					false,
					GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}

}
