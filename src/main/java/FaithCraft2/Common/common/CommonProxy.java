package FaithCraft2.Common.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import FaithCraft2.Common.common.entity.Demon;
import FaithCraft2.Common.common.entity.DemonicCreeper;
import FaithCraft2.Common.common.entity.ModelDemon;
import FaithCraft2.Common.common.entity.RenderDemon;
import FaithCraft2.Common.common.entity.RenderDemonicCreeper;
import FaithCraft2.Common.common.renderers.TileEntityDemonicCreeperSkullRenderer;
import FaithCraft2.Common.common.renderers.TileEntityHeavenPortalSpecialRenderer;
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
import FaithCraft2.Common.common.tileEntity.*;
import FaithCraft2.Common.common.entity.RenderDemon;

public class CommonProxy{
	
	public static void registerRenderThings(){
		//TileEntitySpecialRenderer render = new RenderAltar();
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, render);
		
		//RenderingRegistry.registerEntityRenderingHandler(Jesus.class, new RenderJesus(new ModelJesus(), 0));
		//RenderingRegistry.registerEntityRenderingHandler(Angel.class, new RenderAngel(new ModelAngel(), 0));
		RenderingRegistry.registerEntityRenderingHandler(Demon.class, new RenderDemon(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(DemonicCreeper.class, new RenderDemonicCreeper(Minecraft.getMinecraft().getRenderManager()));
	}
	
	public static void registerTileEntitySpecialRenderer(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonicCreeperSkull.class, new TileEntityDemonicCreeperSkullRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeavenPortal.class, new TileEntityHeavenPortalSpecialRenderer());
	}
	
}