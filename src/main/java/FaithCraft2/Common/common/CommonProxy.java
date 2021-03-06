package FaithCraft2.Common.common;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import FaithCraft2.Common.common.entity.Angel;
import FaithCraft2.Common.common.entity.Demon;
import FaithCraft2.Common.common.entity.DemonicCreeper;
import FaithCraft2.Common.common.entity.RenderAngel;
import FaithCraft2.Common.common.entity.RenderDemon;
import FaithCraft2.Common.common.entity.RenderDemonicCreeper;
import FaithCraft2.Common.common.renderers.RenderAltar;
import FaithCraft2.Common.common.renderers.TileEntityDemonicCreeperSkullRenderer;
import FaithCraft2.Common.common.renderers.TileEntityHeavenPortalSpecialRenderer;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
//import FaithCraft2.Common.common.entity.Angel;
//import FaithCraft2.Common.common.entity.Demon;
//import FaithCraft2.Common.common.entity.Jesus;
//import FaithCraft2.Common.common.entity.ModelAngel;
//import FaithCraft2.Common.common.entity.ModelDemon;
//import FaithCraft2.Common.common.entity.ModelJesus;
//import FaithCraft2.Common.common.entity.RenderAngel;
//import FaithCraft2.Common.common.entity.RenderDemon;
//import FaithCraft2.Common.common.entity.RenderJesus;
//import FaithCraft2.Common.common.renderers.RenderAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;
import FaithCraft2.Common.common.tileEntity.TileEntityHeavenPortal;

public class CommonProxy{
	
	public static void registerRenderThings(){
		
		//RenderingRegistry.registerEntityRenderingHandler(Jesus.class, new RenderJesus(new ModelJesus(), 0));
		//RenderingRegistry.registerEntityRenderingHandler(Angel.class, new RenderAngel(new ModelAngel(), 0));
		RenderingRegistry.registerEntityRenderingHandler(Demon.class, new RenderDemon(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(Angel.class, new RenderAngel(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(DemonicCreeper.class, new RenderDemonicCreeper(Minecraft.getMinecraft().getRenderManager()));
	}
	
	public static void registerTileEntitySpecialRenderer(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonicCreeperSkull.class, new TileEntityDemonicCreeperSkullRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeavenPortal.class, new TileEntityHeavenPortalSpecialRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new RenderAltar());
	}
	
	public void preInit(FMLPreInitializationEvent event)
    {
		
    }
	
	public void init(){
		
	}
}