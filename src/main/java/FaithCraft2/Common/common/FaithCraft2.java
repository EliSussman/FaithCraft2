package FaithCraft2.Common.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import FaithCraft2.Common.common.armor.HolyArmor;
import FaithCraft2.Common.common.biome.HeavenBiome;
//import FaithCraft2.Common.common.blocks.HellCobbleStone;
import FaithCraft2.Common.common.blocks.Altar;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;
import FaithCraft2.Common.common.blocks.HeavenPortal;
//import FaithCraft2.Common.common.items.InstructionBook;
import FaithCraft2.Common.common.blocks.HellRock;
//import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
//import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
//import FaithCraft2.Common.common.worldgen.HolyWorldGen;
//import FaithCraft2.Common.common.worldgen.WorldGenChurch;
//import FaithCraft2.Common.common.worldgen.WorldGenTemple;
import FaithCraft2.Common.common.blocks.HolyBlock;
//import FaithCraft2.Common.common.biome.HellBiome;
//import FaithCraft2.Common.common.blocks.Altar;
import FaithCraft2.Common.common.blocks.HolyCobbleStone;
import FaithCraft2.Common.common.blocks.HolyController;
//import FaithCraft2.Common.common.blocks.HolyForge;
import FaithCraft2.Common.common.blocks.HolyOre;
import FaithCraft2.Common.common.blocks.HolyStone;
import FaithCraft2.Common.common.dimension.heaven.WorldProviderHeaven;
//import FaithCraft2.Common.common.dimension.hell.WorldProviderHell;
import FaithCraft2.Common.common.entity.EntityMobRegistry;
import FaithCraft2.Common.common.handler.BucketHandler;
import FaithCraft2.Common.common.handler.FaithCraftEventHandler;
import FaithCraft2.Common.common.handler.GuiHandler;
//import FaithCraft2.Common.common.handler.ConfigHandler;
//import FaithCraft2.Common.common.handler.CraftingHandler;
//import FaithCraft2.Common.common.handler.GuiHandler;
//import FaithCraft2.Common.common.handler.PlayerSpawnHandler;
import FaithCraft2.Common.common.items.Bible;
import FaithCraft2.Common.common.items.BodyOFChrist;
import FaithCraft2.Common.common.items.Cross;
import FaithCraft2.Common.common.items.DemonicCreeperSkullItem;
//import FaithCraft2.Common.common.items.HolyGrail;
//import FaithCraft2.Common.common.items.HolyGrailOFWine;
import FaithCraft2.Common.common.items.DogwoodStick;
import FaithCraft2.Common.common.items.GoldenDogwoodStick;
import FaithCraft2.Common.common.items.HolyCross;
import FaithCraft2.Common.common.items.HolyGrail;
import FaithCraft2.Common.common.items.HolyGrailOFWine;
//import FaithCraft2.Common.common.entity.Angel;
import FaithCraft2.Common.common.items.HolyIngot;
import FaithCraft2.Common.common.items.HolyStaffOFPower;
import FaithCraft2.Common.common.items.Quran;
import FaithCraft2.Common.common.items.Torah;
import FaithCraft2.Common.common.items.WineBucket;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;

@Mod(modid = FaithCraft2.modid, version = FaithCraft2.version, name = FaithCraft2.name ,guiFactory = FaithCraft2.guiFactory)
public class FaithCraft2{
	public static final String modid = "faithcraft2";
	public static final String version = "2.2 Alpha";
	public static final String name = "FaithCraft2";
	public static final String guiFactory = "FaithCraft2.Common.client.gui.GuiFactory";

//public static HolyWorldGen worldgen1 = new HolyWorldGen();

public static ToolMaterial Christianity = EnumHelper.addToolMaterial("CHRISTIANITY", 1, 1, 1.0F, 10, 10);
public static ToolMaterial Holy = EnumHelper.addToolMaterial("HOLY", 2, 3, 2.0F, 20, 20);
public static ToolMaterial HolyWood = EnumHelper.addToolMaterial("HOLYWOOD", 0, 60, 2.0F, 5.0F, 30);
public static ToolMaterial HolyStone = EnumHelper.addToolMaterial("HOLYSTONE", 1, 150, 4.0F, 7.0F, 30);
public static ToolMaterial HolyIron = EnumHelper.addToolMaterial("HOLYIRON", 2, 300, 6.0F, 12.0F, 30);
public static ToolMaterial HolyDiamond = EnumHelper.addToolMaterial("HOLYDIAMOND", 3, 1333, 9.0F, 17.0F, 30);
public static ArmorMaterial HolyArmorType = EnumHelper.addArmorMaterial("HolyArmor", modid + ":HolyArmor", 50, new int[]{3, 8, 6, 3}, 30);

public static CreativeTabs FaithCraft2Tab = new FaithCraft2Tab(CreativeTabs.getNextID(), "FaithCraft 2.0 Tab");

@Instance(modid)
public static FaithCraft2 instance;

public static final int guiIDInstructionBook = 2;

public static final int guiIDAltar = 1;
 
public static final int guiIDHolyForge = 0;
public static Block HolyForgeIdle;
public static Block HolyForgeActive;

public static Item Bible;
public static Item BodyOFChrist;
public static Item Cross;
public static Item Quran;
public static Item Torah;
public static Item HolyCross;
public static Item DogwoodStick;
public static Item GoldenDogwoodStick;
public static Item WineBucket;
public static Item HolyGrail;
public static Item HolyGrailOFWine;
public static Item InstructionBook;
public static Item DemonicCreeperSkullItem;
public static Item HolyIngot;
public static Item HolyStaffOFPower;
public static Item HolyStaffOFPower_LEVEL1;
public static Item HolyStaffOFPower_LEVEL2;
public static Item HolyStaffOFPower_LEVEL3;
public static Item HolyHelmet;
public static Item HolyChestplate;
public static Item HolyLeggings;
public static Item HolyBoots;

public static Block block1;

public static BiomeGenBase HeavenBiome;

public static BiomeGenBase HellBiome;

public static IWorldGenerator genTemple;
public static IWorldGenerator genChurch;

public static int HeavenId = 10;

public static int HellId = 11;

public static MerchantRecipeList merchantRecipeList;
//public static Angel angel;
public static Random rand;

@SidedProxy(clientSide = "FaithCraft2.Common.client.ClientProxy", serverSide = "FaithCraft2.Common.common.CommonProxy")
public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		EntityMobRegistry.mainRegistry();
		
		FaithCraftBlocks.init();
		//ConfigHandler.init(preEvent.getSuggestedConfigurationFile());
		//FMLCommonHandler.instance().bus().register(new ConfigHandler());
		
		//HolyForgeIdle = new HolyForge(false).setBlockName("HolyForgeIdle").setCreativeTab(FaithCraft2.FaithCraft2Tab).setHardness(3.5F);
		//HolyForgeActive = new HolyForge(true).setBlockName("HolyForgeActive").setLightLevel(0.625F).setHardness(3.6F);
		//HellCobbleStone = new HellCobbleStone(3022, Material.rock).setBlockName("HellCobbleStone").setBlockTextureName("FaithCraft2:HellCobbleStone");
		Bible = new Bible(3001).setUnlocalizedName("Bible");
		BodyOFChrist = new BodyOFChrist(3002).setUnlocalizedName("BodyOFChrist");
		Cross = new Cross(3003, Christianity).setUnlocalizedName("Cross");
		Quran = new Quran(3004).setUnlocalizedName("Quran");
		Torah = new Torah(3005).setUnlocalizedName("Torah");
		HolyCross = new HolyCross(3007, Holy).setUnlocalizedName("HolyCross");
		DogwoodStick = new DogwoodStick(3008).setUnlocalizedName("DogwoodStick");
		GoldenDogwoodStick = new GoldenDogwoodStick(3009).setUnlocalizedName("GoldenDogwoodStick");
		DemonicCreeperSkullItem = new DemonicCreeperSkullItem().setUnlocalizedName("DemonicCreeperSkullItem");
		WineBucket = new WineBucket(FaithCraftBlocks.wineBlock).setUnlocalizedName("WineBucket").setContainerItem(Items.bucket);
		HolyIngot = new HolyIngot().setUnlocalizedName("HolyIngot");
		HolyGrail = new HolyGrail(3012).setUnlocalizedName("HolyGrail");
		HolyGrailOFWine = new HolyGrailOFWine(0, 0.0F, true).setAlwaysEdible().setUnlocalizedName("HolyGrailOFWine");
		HolyStaffOFPower = new HolyStaffOFPower(HolyWood).setUnlocalizedName("HolyStaffOFPower");
		HolyStaffOFPower_LEVEL1 = new HolyStaffOFPower(HolyStone).setUnlocalizedName("HolyStaffOFPower_LEVEL1");
		HolyStaffOFPower_LEVEL2 = new HolyStaffOFPower(HolyIron).setUnlocalizedName("HolyStaffOFPower_LEVEL2");
		HolyStaffOFPower_LEVEL3 = new HolyStaffOFPower(HolyDiamond).setUnlocalizedName("HolyStaffOFPower_LEVEL3");
		HolyHelmet = new HolyArmor("HolyHelmet", HolyArmorType, 1, 0).setUnlocalizedName("HolyHelmet");
		HolyChestplate = new HolyArmor("HolyChestplate", HolyArmorType, 1, 1).setUnlocalizedName("HolyChestplate");
		HolyLeggings = new HolyArmor("HolyLeggings", HolyArmorType, 2, 2).setUnlocalizedName("HolyLeggings");
		HolyBoots = new HolyArmor("HolyBoots", HolyArmorType, 1, 3).setUnlocalizedName("HolyBoots");
		//InstructionBook = new InstructionBook(3020).setUnlocalizedName("InstructionBook").setTextureName("FaithCraft2:InstructionBook");
		HeavenBiome = new HeavenBiome(245).setBiomeName("Heaven").setDisableRain();
		
		//HellBiome = new HellBiome(246).setBiomeName("Hell").setDisableRain();
		
		//genTemple = new WorldGenTemple();
		//genChurch = new WorldGenChurch();
		//GameRegistry.registerBlock(HolyForgeIdle, "HolyForgeIdle");
		//GameRegistry.registerBlock(HolyForgeActive, "HolyForgeActive");
		GameRegistry.registerBlock(FaithCraftBlocks.Altar, "Altar");
		GameRegistry.registerBlock(FaithCraftBlocks.HolyController, "HolyController");
		GameRegistry.registerBlock(FaithCraftBlocks.HolyOre, "HolyOre");
		GameRegistry.registerBlock(FaithCraftBlocks.HolyStone, "HolyStone");
		GameRegistry.registerBlock(FaithCraftBlocks.HolyCobbleStone, "HolyCobbleStone");
		GameRegistry.registerBlock(FaithCraftBlocks.HolyBlock, "HolyBlock");
		GameRegistry.registerBlock(FaithCraftBlocks.DogwoodLog, "DogwoodLog");
		GameRegistry.registerBlock(FaithCraftBlocks.DogwoodPlanks, "DogwoodPlanks");
		GameRegistry.registerBlock(FaithCraftBlocks.DogwoodLeaves, "DogwoodLeaves");
		GameRegistry.registerBlock(FaithCraftBlocks.DogwoodSapling, "DogwoodSapling");
		GameRegistry.registerBlock(FaithCraftBlocks.DemonicCreeperSkull, "DemonicCreeperSkull");
		GameRegistry.registerBlock(FaithCraftBlocks.HellRock, "HellRock");
		GameRegistry.registerBlock(FaithCraftBlocks.HeavenPortal, "HeavenPortal");
		GameRegistry.registerBlock(FaithCraftBlocks.wineBlock, "WineBlock");
		//GameRegistry.registerBlock(HellCobbleStone, "HellCobbleStone");
		
		GameRegistry.registerItem(Bible, "Bible");
		GameRegistry.registerItem(BodyOFChrist, "BodyOFChrist");
		GameRegistry.registerItem(Cross, "Cross");
		GameRegistry.registerItem(Quran, "Quran");
		GameRegistry.registerItem(Torah, "Torah");
		GameRegistry.registerItem(HolyCross, "HolyCross");
		GameRegistry.registerItem(DogwoodStick, "DogwoodStick");
		GameRegistry.registerItem(GoldenDogwoodStick, "GoldenDogwoodStick");
		GameRegistry.registerItem(WineBucket, "WineBucket");
		GameRegistry.registerItem(DemonicCreeperSkullItem, "DemonicCreeperSkullItem");
		GameRegistry.registerItem(HolyIngot, "HolyIngot");
		GameRegistry.registerItem(HolyGrail, "HolyGrail");
		GameRegistry.registerItem(HolyGrailOFWine, "HolyGrailOFWine");
		GameRegistry.registerItem(HolyStaffOFPower, "HolyStaffOFPower");
		GameRegistry.registerItem(HolyStaffOFPower_LEVEL1, "HolyStaffOFPower_LEVEL1");
		GameRegistry.registerItem(HolyStaffOFPower_LEVEL2, "HolyStaffOFPower_LEVEL2");
		GameRegistry.registerItem(HolyStaffOFPower_LEVEL3, "HolyStaffOFPower_LEVEL3");
		GameRegistry.registerItem(HolyHelmet, "HolyHelmet");
		GameRegistry.registerItem(HolyChestplate, "HolyChestplate");
		GameRegistry.registerItem(HolyLeggings, "HolyLeggings");
		GameRegistry.registerItem(HolyBoots, "HolyBoots");
		//GameRegistry.registerItem(InstructionBook, "InstructionBook");
		  
		GameRegistry.registerTileEntity(TileEntityDemonicCreeperSkull.class, "DemonicCreeperSkull");
		
		//GameRegistry.registerWorldGenerator(worldgen1, 1);
		
		FluidContainerRegistry.registerFluidContainer(new FluidStack(FaithCraftBlocks.Wine, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(WineBucket), new ItemStack(Items.bucket));
		
		//GameRegistry.registerWorldGenerator(genTemple, 1);
		//GameRegistry.registerWorldGenerator(genChurch, 1);
		
		DimensionManager.registerProviderType(HeavenId, WorldProviderHeaven.class, true);
		DimensionManager.registerDimension(HeavenId, HeavenId);
		
		//DimensionManager.registerProviderType(HellId, WorldProviderHell.class, true);
		//DimensionManager.registerDimension(HellId, HellId);*/
		
		proxy.preInit(preEvent);
	}

	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		if(event.getSide() == Side.CLIENT)
		{
		    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		    	
		    	//blocks
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HolyStone), 0, new ModelResourceLocation(modid + ":" + ((HolyStone) FaithCraftBlocks.HolyStone).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HolyCobbleStone), 0, new ModelResourceLocation(modid + ":" + ((HolyCobbleStone) FaithCraftBlocks.HolyCobbleStone).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.Altar), 0, new ModelResourceLocation(modid + ":" + ((Altar) FaithCraftBlocks.Altar).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HolyBlock), 0, new ModelResourceLocation(modid + ":" + ((HolyBlock) FaithCraftBlocks.HolyBlock).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HolyOre), 0, new ModelResourceLocation(modid + ":" + ((HolyOre) FaithCraftBlocks.HolyOre).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.DogwoodLog), 0, new ModelResourceLocation("faithcraft2:DogwoodLog", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.DogwoodPlanks), 0, new ModelResourceLocation("faithcraft2:DogwoodPlanks", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.DogwoodLeaves), 0, new ModelResourceLocation("faithcraft2:DogwoodLeaves", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.DogwoodSapling), 0, new ModelResourceLocation("faithcraft2:DogwoodSapling", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HellRock), 0, new ModelResourceLocation(modid + ":" + ((HellRock) FaithCraftBlocks.HellRock).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HeavenPortal), 0, new ModelResourceLocation(modid + ":" + ((HeavenPortal) FaithCraftBlocks.HeavenPortal).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(FaithCraftBlocks.HolyController), 0, new ModelResourceLocation(modid + ":" + ((HolyController) FaithCraftBlocks.HolyController).getName(), "inventory"));
		    	
		    	//items
		    	renderItem.getItemModelMesher().register(Bible, 0, new ModelResourceLocation(modid + ":" + ((Bible) Bible).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(BodyOFChrist, 0, new ModelResourceLocation(modid + ":" + ((BodyOFChrist) BodyOFChrist).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Cross, 0, new ModelResourceLocation(modid + ":" + ((Cross) Cross).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Quran, 0, new ModelResourceLocation(modid + ":" + ((Quran) Quran).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Torah, 0, new ModelResourceLocation(modid + ":" + ((Torah) Torah).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(HolyCross, 0, new ModelResourceLocation(modid + ":" + ((HolyCross) HolyCross).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(DogwoodStick, 0, new ModelResourceLocation(modid + ":" + ((DogwoodStick) DogwoodStick).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(GoldenDogwoodStick, 0, new ModelResourceLocation(modid + ":" + ((GoldenDogwoodStick) GoldenDogwoodStick).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(WineBucket, 0, new ModelResourceLocation(modid + ":" + ((WineBucket) WineBucket).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(DemonicCreeperSkullItem, 0, new ModelResourceLocation(modid + ":" + ((DemonicCreeperSkullItem) DemonicCreeperSkullItem).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(HolyIngot, 0, new ModelResourceLocation(modid + ":" + ((HolyIngot) HolyIngot).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(HolyGrail, 0, new ModelResourceLocation(modid + ":" + ((HolyGrail) HolyGrail).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(HolyGrailOFWine, 0, new ModelResourceLocation(modid + ":" + ((HolyGrailOFWine) HolyGrailOFWine).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(HolyStaffOFPower, 0, new ModelResourceLocation(modid + ":" + ((HolyStaffOFPower) HolyStaffOFPower).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(HolyStaffOFPower_LEVEL1, 0, new ModelResourceLocation("faithcraft2:HolyStaffOFPower_LEVEL1", "inventory"));
		    	renderItem.getItemModelMesher().register(HolyStaffOFPower_LEVEL2, 0, new ModelResourceLocation("faithcraft2:HolyStaffOFPower_LEVEL2", "inventory"));
		    	renderItem.getItemModelMesher().register(HolyStaffOFPower_LEVEL3, 0, new ModelResourceLocation("faithcraft2:HolyStaffOFPower_LEVEL3", "inventory"));
		    	renderItem.getItemModelMesher().register(HolyHelmet, 0, new ModelResourceLocation("faithcraft2:HolyHelmet", "inventory"));
		    	renderItem.getItemModelMesher().register(HolyChestplate, 0, new ModelResourceLocation("faithcraft2:HolyChestplate", "inventory"));
		    	renderItem.getItemModelMesher().register(HolyLeggings, 0, new ModelResourceLocation("faithcraft2:HolyLeggings", "inventory"));
		    	renderItem.getItemModelMesher().register(HolyBoots, 0, new ModelResourceLocation("faithcraft2:HolyBoots", "inventory"));
		}
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(FaithCraftBlocks.HolyCobbleStone),
		    	"GGG",
		    	"GSG",
		    	"GGG",
		    	'S', Blocks.cobblestone, 'G', Items.gold_nugget
		    	);
		GameRegistry.addRecipe(new ItemStack(FaithCraftBlocks.HolyBlock),
		    	"HHH",
		    	"HGH",
		    	"HHH",
		    	'H', FaithCraftBlocks.HolyStone, 'S', Blocks.gold_block
		    	);
		GameRegistry.addRecipe(new ItemStack(FaithCraftBlocks.Altar),
		    	"NWN",
		    	" S ",
		    	"PPP",
		    	'N', Items.gold_nugget, 'W', Blocks.wool, 'S', FaithCraft2.DogwoodStick, 'P', FaithCraftBlocks.DogwoodPlanks
		    	);
		GameRegistry.addSmelting(FaithCraftBlocks.HolyCobbleStone, new ItemStack(FaithCraftBlocks.HolyStone,1), 1F);
		
		GameRegistry.registerTileEntity(TileEntityAltar.class, "Altar");
		//GameRegistry.registerTileEntity(TileEntityHolyForge.class, "HolyForge");
		//FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(HeavenBiome, 10));
		//MinecraftForge.EVENT_BUS.register(PlayerSpawnHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(FaithCraftEventHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		BucketHandler.INSTANCE.buckets.put(FaithCraftBlocks.wineBlock, WineBucket);
		proxy.registerRenderThings();
		proxy.registerTileEntitySpecialRenderer();
		proxy.init();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postevent){
		
	}
	
}
