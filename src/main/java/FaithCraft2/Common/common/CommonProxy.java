package FaithCraft2.Common.common;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
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

public class CommonProxy{

	public static void registerRenderThings(){
		//TileEntitySpecialRenderer render = new RenderAltar();
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, render);
		
		/*RenderingRegistry.registerEntityRenderingHandler(Jesus.class, new RenderJesus(new ModelJesus(), 0));
		RenderingRegistry.registerEntityRenderingHandler(Angel.class, new RenderAngel(new ModelAngel(), 0));
		RenderingRegistry.registerEntityRenderingHandler(Demon.class, new RenderDemon(new ModelDemon(), 0));
		*/
	}
	
	public static void registerTileEntitySpecialRenderer(){
		
	}
	
}