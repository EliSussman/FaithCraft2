package FaithCraft2.Common.common;

import FaithCraft2.Common.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import FaithCraft2.Common.common.items.*;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.worldgen.HolyWorldGen;
import FaithCraft2.Common.common.fluids.*;

@Mod(modid = "faithcraft2", name = "FaithCraft 2.0", version = "2.0 Alpha")
public class FaithCraft2{
@SidedProxy(clientSide = "FaithCraft2.Common.client.ClientProxy", serverSide = "FaithCraft2.Common.common.CommonProxy")
public static CommonProxy proxy;

public static HolyWorldGen worldgen1 = new HolyWorldGen();

public static ToolMaterial Christianity = EnumHelper.addToolMaterial("CHRISTIANITY", 1, 3, 1.0F, 10, 10);
public static ToolMaterial Holy = EnumHelper.addToolMaterial("HOLY", 2, 1, 2.0F, 20, 20);

public static CreativeTabs FaithCraft2Tab = new FaithCraft2Tab(CreativeTabs.getNextID(), "FaithCraft 2.0 Tab");

public static Block Altar = new Altar(Material.rock).setBlockName("Altar").setBlockTextureName("FaithCraft2:Altar");
public static Block HolyOre= new HolyOre(3006, Material.rock).setBlockName("HolyOre").setBlockTextureName("FaithCraft2:HolyOre");

public static Item Bible = new Bible(3001).setUnlocalizedName("Bible").setTextureName("FaithCraft2:Bible");
public static Item BodyOFChrist = new BodyOFChrist(3002).setUnlocalizedName("BodyOFChrist").setTextureName("FaithCraft2:BodyOFChrist");
public static Item Cross = new Cross(3003, Christianity).setUnlocalizedName("Cross").setTextureName("FaithCraft2:Cross");
public static Item Quran = new Quran(3004).setUnlocalizedName("Quran").setTextureName("FaithCraft2:Quran");
public static Item Torah = new Torah(3005).setUnlocalizedName("Torah").setTextureName("FaithCraft2:Torah");
public static Item HolyCross = new HolyCross(3007, Holy).setUnlocalizedName("HolyCross").setTextureName("FaithCraft2:HolyCross");
	
	public FaithCraft2(){
		GameRegistry.registerBlock(Altar, "Altar");
		GameRegistry.registerBlock(HolyOre, "HolyOre");
		
		GameRegistry.registerItem(Bible, "Bible");
		GameRegistry.registerItem(BodyOFChrist, "BodyOFChrist");
		GameRegistry.registerItem(Cross, "Cross");
		GameRegistry.registerItem(Quran, "Quran");
		GameRegistry.registerItem(Torah, "Torah");
		GameRegistry.registerItem(HolyCross, "HolyCross");
		
		GameRegistry.registerWorldGenerator(worldgen1, 1);
		
		GameRegistry.registerTileEntity(TileEntityAltar.class, "Altar");
		
		proxy.registerRenderThings();
	}
}
