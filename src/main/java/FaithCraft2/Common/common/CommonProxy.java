package FaithCraft2.Common.common;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import FaithCraft2.Common.common.renderers.RenderAltar;
import FaithCraft2.Common.common.tileEntity.*;

public class CommonProxy{

	public static void registerRenderThings(){
		TileEntitySpecialRenderer render = new RenderAltar();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, render);
	}
	
	public static void registerTileEntitySpecialRenderer(){
		
	}
	
}
