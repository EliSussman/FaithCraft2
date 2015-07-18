package FaithCraft2.Common.client;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import FaithCraft2.Common.common.CommonProxy;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;
import FaithCraft2.Common.common.entity.Demon;
import FaithCraft2.Common.common.entity.DemonicCreeper;
import FaithCraft2.Common.common.entity.RenderDemon;
import FaithCraft2.Common.common.entity.RenderDemonicCreeper;
import FaithCraft2.Common.common.renderers.RenderAltar;
import FaithCraft2.Common.common.renderers.TileEntityDemonicCreeperSkullRenderer;
import FaithCraft2.Common.common.renderers.TileEntityHeavenPortalSpecialRenderer;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;
import FaithCraft2.Common.common.tileEntity.TileEntityHeavenPortal;

public class ClientProxy extends CommonProxy{
	
public static void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(Demon.class, new RenderDemon(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(DemonicCreeper.class, new RenderDemonicCreeper(Minecraft.getMinecraft().getRenderManager()));
}

	public static void registerTileEntitySpecialRenderer(){
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonicCreeperSkull.class, new TileEntityDemonicCreeperSkullRenderer());
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeavenPortal.class, new TileEntityHeavenPortalSpecialRenderer());
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new RenderAltar());
	}
	
	private static ModelResourceLocation fluidLocation = new ModelResourceLocation(FaithCraft2.modid.toLowerCase() + ":" + "fluids", "fluid");
	
	@Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        Item fluid = Item.getItemFromBlock(FaithCraftBlocks.wineBlock);
        ModelBakery.addVariantName(fluid);
        ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition()
        {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return fluidLocation;
            }
        });
        ModelLoader.setCustomStateMapper(FaithCraftBlocks.wineBlock, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return fluidLocation;
            }
        });
    }

}