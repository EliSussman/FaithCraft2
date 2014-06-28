package FaithCraft2.Common.common;

import FaithCraft2.Common.common.blocks.*;
import FaithCraft2.Common.common.crafting.AltarCraftingManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import FaithCraft2.Common.common.handler.BucketHandler;
import FaithCraft2.Common.common.handler.CraftingHandler;
import FaithCraft2.Common.common.handler.GuiHandler;
import FaithCraft2.Common.common.items.*;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
import FaithCraft2.Common.common.worldgen.HolyWorldGen;

@Mod(modid = FaithCraft2.modid, version = FaithCraft2.version)
public class FaithCraft2{
	public static final String modid = "FaithCraft2";
	public static final String version = "2.0 Alpha";

public static HolyWorldGen worldgen1 = new HolyWorldGen();

public static ToolMaterial Christianity = EnumHelper.addToolMaterial("CHRISTIANITY", 1, 1, 1.0F, 10, 10);
public static ToolMaterial Holy = EnumHelper.addToolMaterial("HOLY", 2, 3, 2.0F, 20, 20);

public static CreativeTabs FaithCraft2Tab = new FaithCraft2Tab(CreativeTabs.getNextID(), "FaithCraft 2.0 Tab");

@Instance(modid)
public static FaithCraft2 instance;

public static final int guiIDAltar = 1;
public static Block Altar;

public static final int guiIDHolyForge = 0;
public static Block HolyForgeIdle;
public static Block HolyForgeActive;

public static Block HolyOre;
public static Block HolyStone;
public static Block HolyCobbleStone;
public static Block WineBlock;

public static Item Bible;
public static Item BodyOFChrist;
public static Item Cross;
public static Item Quran;
public static Item Torah;
public static Item HolyCross;
public static Item HolyStick;
public static Item HolyGoldenStick;
public static Item WineBucket;
public static Item HolyGrail;
public static Item HolyGrailOFWine;

public static Fluid Wine;
	
@SidedProxy(clientSide = "FaithCraft2.Common.client.ClientProxy", serverSide = "FaithCraft2.Common.common.CommonProxy")
public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		proxy.registerRenderThings();
		
		Wine = new Fluid("Wine").setViscosity(900).setTemperature(250);
		FluidRegistry.registerFluid(Wine);
		
		Altar = new Altar(Material.rock).setBlockName("Altar").setBlockTextureName("FaithCraft2:Altar"); 

		HolyForgeIdle = new HolyForge(false).setBlockName("HolyForgeIdle").setCreativeTab(FaithCraft2.FaithCraft2Tab).setHardness(3.5F);
		HolyForgeActive = new HolyForge(true).setBlockName("HolyForgeActive").setLightLevel(0.625F).setHardness(3.6F);
		
		HolyOre= new HolyOre(3006, Material.rock).setBlockName("HolyOre").setBlockTextureName("FaithCraft2:HolyOre");
		HolyStone = new HolyStone(3010, Material.rock).setBlockName("HolyStone").setBlockTextureName("FaithCraft2:HolyStone");
		HolyCobbleStone = new HolyCobbleStone(3011, Material.rock).setBlockName("HolyCobbleStone").setBlockTextureName("FaithCraft2:HolyCobbleStone");
		WineBlock = new WineBlock(Wine, Material.water).setBlockName("Wine");
		
		Bible = new Bible(3001).setUnlocalizedName("Bible").setTextureName("FaithCraft2:Bible");
		BodyOFChrist = new BodyOFChrist(3002).setUnlocalizedName("BodyOFChrist").setTextureName("FaithCraft2:BodyOFChrist");
		Cross = new Cross(3003, Christianity).setUnlocalizedName("Cross").setTextureName("FaithCraft2:Cross");
		Quran = new Quran(3004).setUnlocalizedName("Quran").setTextureName("FaithCraft2:Quran");
		Torah = new Torah(3005).setUnlocalizedName("Torah").setTextureName("FaithCraft2:Torah");
		HolyCross = new HolyCross(3007, Holy).setUnlocalizedName("HolyCross").setTextureName("FaithCraft2:HolyCross");
		HolyStick = new HolyStick(3008).setUnlocalizedName("HolyStick").setTextureName("FaithCraft2:HolyStick");
		HolyGoldenStick = new HolyGoldenStick(3009).setUnlocalizedName("HolyGoldenStick").setTextureName("FaithCraft2:HolyGoldenStick");
		WineBucket = new WineBucket(WineBlock).setUnlocalizedName("WineBucket").setTextureName("FaithCraft2:WineBucket").setContainerItem(Items.bucket);
		HolyGrail = new HolyGrail(3012).setUnlocalizedName("HolyGrail").setTextureName("FaithCraft2:HolyGrail");
		HolyGrailOFWine = new HolyGrailOFWine(0, 0.0F, true).setAlwaysEdible().setUnlocalizedName("HolyGrailOFWine").setTextureName("FaithCraft2:HolyGrailOFWine");
		
		GameRegistry.registerBlock(HolyForgeIdle, "HolyForgeIdle");
		GameRegistry.registerBlock(HolyForgeActive, "HolyForgeActive");
		GameRegistry.registerBlock(Altar, "Altar");
		GameRegistry.registerBlock(HolyOre, "HolyOre");
		GameRegistry.registerBlock(HolyStone, "HolyStone");
		GameRegistry.registerBlock(HolyCobbleStone, "HolyCobbleStone");
		GameRegistry.registerBlock(WineBlock, "WineBlock");
		
		GameRegistry.registerItem(Bible, "Bible");
		GameRegistry.registerItem(BodyOFChrist, "BodyOFChrist");
		GameRegistry.registerItem(Cross, "Cross");
		GameRegistry.registerItem(Quran, "Quran");
		GameRegistry.registerItem(Torah, "Torah");
		GameRegistry.registerItem(HolyCross, "HolyCross");
		GameRegistry.registerItem(HolyStick, "HolyStick");
		GameRegistry.registerItem(HolyGoldenStick, "HolyGoldenStick");
		GameRegistry.registerItem(WineBucket, "WineBucket");
		GameRegistry.registerItem(HolyGrail, "HolyGrail");
		GameRegistry.registerItem(HolyGrailOFWine, "HolyGrailOFWine");
		
		GameRegistry.registerWorldGenerator(worldgen1, 1);
		
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("wine", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(WineBucket), new ItemStack(Items.bucket));
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		
		GameRegistry.registerTileEntity(TileEntityAltar.class, "Altar");
		GameRegistry.registerTileEntity(TileEntityHolyForge.class, "HolyForge");
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		BucketHandler.INSTANCE.buckets.put(WineBlock, WineBucket);
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postevent){
	}
	
}
