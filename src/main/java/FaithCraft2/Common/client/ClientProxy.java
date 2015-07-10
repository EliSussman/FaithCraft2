package FaithCraft2.Common.client;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import FaithCraft2.Common.common.CommonProxy;
import FaithCraft2.Common.common.blocks.DemonicCreeperSkull;
import FaithCraft2.Common.common.entity.Demon;
import FaithCraft2.Common.common.entity.DemonicCreeper;
import FaithCraft2.Common.common.entity.ModelDemon;
import FaithCraft2.Common.common.entity.RenderDemon;
import FaithCraft2.Common.common.entity.RenderDemonicCreeper;
import FaithCraft2.Common.common.renderers.RenderAltar;
import FaithCraft2.Common.common.renderers.TileEntityDemonicCreeperSkullRenderer;
import FaithCraft2.Common.common.renderers.TileEntityHeavenPortalSpecialRenderer;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;
import FaithCraft2.Common.common.tileEntity.TileEntityHeavenPortal;
import FaithCraft2.Common.common.FaithCraft2;

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
        Item fluid = Item.getItemFromBlock(FaithCraft2.wineBlock);
        ModelBakery.addVariantName(fluid);
        ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition()
        {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return fluidLocation;
            }
        });
        ModelLoader.setCustomStateMapper(FaithCraft2.wineBlock, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return fluidLocation;
            }
        });
    }

}