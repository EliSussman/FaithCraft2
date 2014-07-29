package FaithCraft2.Common.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import FaithCraft2.Common.common.CommonProxy;
import FaithCraft2.Common.common.entity.Jesus;
import FaithCraft2.Common.common.entity.ModelJesus;
import FaithCraft2.Common.common.entity.RenderJesus;
import FaithCraft2.Common.common.renderers.RenderAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;

public class ClientProxy extends CommonProxy{

public static void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(Jesus.class, new RenderJesus(new ModelJesus(), 0));
	}

	public static void registerTileEntitySpecialRenderer(){
		
	}
}
