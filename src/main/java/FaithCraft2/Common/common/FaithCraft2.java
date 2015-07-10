package FaithCraft2.Common.common;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import FaithCraft2.Common.common.biome.HeavenBiome;
//import FaithCraft2.Common.common.biome.HellBiome;
//import FaithCraft2.Common.common.blocks.Altar;
import FaithCraft2.Common.common.blocks.HolyCobbleStone;
//import FaithCraft2.Common.common.blocks.HolyForge;
import FaithCraft2.Common.common.blocks.HolyOre;
import FaithCraft2.Common.common.blocks.HolyStone;
import FaithCraft2.Common.common.handler.BucketHandler;
import FaithCraft2.Common.common.handler.GuiHandler;
import FaithCraft2.Common.common.dimension.heaven.WorldProviderHeaven;
import FaithCraft2.Common.common.entity.Demon;
//import FaithCraft2.Common.common.dimension.hell.WorldProviderHell;
import FaithCraft2.Common.common.entity.EntityMobRegistry;
//import FaithCraft2.Common.common.handler.ConfigHandler;
//import FaithCraft2.Common.common.handler.CraftingHandler;
//import FaithCraft2.Common.common.handler.GuiHandler;
//import FaithCraft2.Common.common.handler.PlayerSpawnHandler;
import FaithCraft2.Common.common.items.Bible;
import FaithCraft2.Common.common.items.BodyOFChrist;
import FaithCraft2.Common.common.items.Cross;
import FaithCraft2.Common.common.items.HolyCross;
import FaithCraft2.Common.common.items.GoldenDogwoodStick;
//import FaithCraft2.Common.common.items.HolyGrail;
//import FaithCraft2.Common.common.items.HolyGrailOFWine;
import FaithCraft2.Common.common.items.DogwoodStick;
import FaithCraft2.Common.common.items.Quran;
import FaithCraft2.Common.common.items.Torah;
import net.minecraft.client.resources.model.ModelManager;
import FaithCraft2.Common.common.items.WineBucket;
import FaithCraft2.Common.common.blocks.FaithCraftLeavesBase;
//import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
//import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
//import FaithCraft2.Common.common.worldgen.HolyWorldGen;
//import FaithCraft2.Common.common.worldgen.WorldGenChurch;
//import FaithCraft2.Common.common.worldgen.WorldGenTemple;
import FaithCraft2.Common.common.blocks.HolyBlock;
//import FaithCraft2.Common.common.entity.Angel;
import FaithCraft2.Common.common.blocks.FaithCraftLeaves;
import FaithCraft2.Common.common.blocks.FaithCraftLog;
import FaithCraft2.Common.common.blocks.FaithCraftSapling;
import FaithCraft2.Common.common.blocks.FaithCraftPlanks;
//import FaithCraft2.Common.common.items.InstructionBook;
import FaithCraft2.Common.common.blocks.HellRock;
//import FaithCraft2.Common.common.blocks.HellCobbleStone;
import FaithCraft2.Common.common.blocks.Altar;
import FaithCraft2.Common.common.fluids.WineBlock;
import FaithCraft2.Common.common.fluids.WineFluid;
import FaithCraft2.Common.common.blocks.HeavenPortal;

import com.google.common.base.Throwables;
import com.google.common.collect.ObjectArrays;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import FaithCraft2.Common.common.items.DemonicCreeperSkullItem;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;
import FaithCraft2.Common.common.tileEntity.TileEntityHeavenPortal;
import FaithCraft2.Common.common.blocks.DemonicCreeperSkull;

@Mod(modid = FaithCraft2.modid, version = FaithCraft2.version, name = FaithCraft2.name ,guiFactory = FaithCraft2.guiFactory)
public class FaithCraft2{
	public static final String modid = "faithcraft2";
	public static final String version = "2.2 Alpha";
	public static final String name = "FaithCraft2";
	public static final String guiFactory = "FaithCraft2.Common.client.gui.GuiFactory";

//public static HolyWorldGen worldgen1 = new HolyWorldGen();

public static ToolMaterial Christianity = EnumHelper.addToolMaterial("CHRISTIANITY", 1, 1, 1.0F, 10, 10);
public static ToolMaterial Holy = EnumHelper.addToolMaterial("HOLY", 2, 3, 2.0F, 20, 20);

public static CreativeTabs FaithCraft2Tab = new FaithCraft2Tab(CreativeTabs.getNextID(), "FaithCraft 2.0 Tab");

@Instance(modid)
public static FaithCraft2 instance;

public static final int guiIDInstructionBook = 2;

public static Fluid Wine;

public static final int guiIDAltar = 1;
public static Block Altar;
 
public static final int guiIDHolyForge = 0;
public static Block HolyForgeIdle;
public static Block HolyForgeActive;

public static Block HolyOre;
public static Block HolyStone;
public static Block HolyCobbleStone;
public static Block HeavenPortal;
public static Block HolyBlock;
public static Block AltarMB;
public static Block HellRock;
public static Block HellCobbleStone;
public static Block wineBlock;
public static Block DogwoodLog;
public static Block DogwoodPlanks;
public static Block DogwoodLeaves;
public static Block DogwoodSapling;
public static Block FaithCraftLog1;
public static Block FaithCraftPlanks1;
public static Block FaithCraftLeaves1;
public static Block FaithCraftSapling1;
public static Block DemonicCreeperSkull;

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

public static ResourceLocation still = new ResourceLocation("faithcraft2:blocks/WineStill");
public static ResourceLocation flowing = new ResourceLocation("faithcraft2:blocks/WineFlow");

@SidedProxy(clientSide = "FaithCraft2.Common.client.ClientProxy", serverSide = "FaithCraft2.Common.common.CommonProxy")
public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		EntityMobRegistry.mainRegistry();
		
		//ConfigHandler.init(preEvent.getSuggestedConfigurationFile());
		//FMLCommonHandler.instance().bus().register(new ConfigHandler());
		
		Wine = new Fluid("Wine", still, flowing);
		FluidRegistry.registerFluid(Wine);
		wineBlock = new WineBlock(Wine, Material.water);
		
		Altar = new Altar(Material.rock).setUnlocalizedName("Altar"); 

		//HolyForgeIdle = new HolyForge(false).setBlockName("HolyForgeIdle").setCreativeTab(FaithCraft2.FaithCraft2Tab).setHardness(3.5F);
		//HolyForgeActive = new HolyForge(true).setBlockName("HolyForgeActive").setLightLevel(0.625F).setHardness(3.6F);
		
		HolyOre= new HolyOre(3006, Material.rock).setUnlocalizedName("HolyOre");
		HolyStone = new HolyStone(3010, Material.rock).setUnlocalizedName("HolyStone");
		HolyCobbleStone = new HolyCobbleStone(3011, Material.rock).setUnlocalizedName("HolyCobbleStone");
		HolyBlock = new HolyBlock(3015, Material.rock).setUnlocalizedName("HolyBlock");
		DemonicCreeperSkull = new DemonicCreeperSkull().setUnlocalizedName("DemonicCreeperSkull");
		DogwoodLog = new FaithCraftLog().setUnlocalizedName("DogwoodLog");
		DogwoodPlanks = new FaithCraftPlanks().setUnlocalizedName("DogwoodPlanks");
		DogwoodLeaves = new FaithCraftLeaves().setUnlocalizedName("DogwoodLeaves");
		DogwoodSapling = new FaithCraftSapling().setUnlocalizedName("DogwoodSapling");
		FaithCraftLog1 = new FaithCraftLog();
		FaithCraftPlanks1 = new FaithCraftPlanks();
		FaithCraftLeaves1 = new FaithCraftLeaves();
		FaithCraftSapling1 = new FaithCraftSapling();
		HellRock = new HellRock(3021, Material.rock).setUnlocalizedName("HellRock");
		HeavenPortal = new HeavenPortal().setUnlocalizedName("HeavenPortal");
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
		WineBucket = new WineBucket(wineBlock).setUnlocalizedName("WineBucket").setContainerItem(Items.bucket);
		//HolyGrail = new HolyGrail(3012).setUnlocalizedName("HolyGrail").setTextureName("FaithCraft2:HolyGrail");
		//HolyGrailOFWine = new HolyGrailOFWine(0, 0.0F, true).setAlwaysEdible().setUnlocalizedName("HolyGrailOFWine").setTextureName("FaithCraft2:HolyGrailOFWine");
		//InstructionBook = new InstructionBook(3020).setUnlocalizedName("InstructionBook").setTextureName("FaithCraft2:InstructionBook");
		HeavenBiome = new HeavenBiome(245).setBiomeName("Heaven").setDisableRain();
		
		//HellBiome = new HellBiome(246).setBiomeName("Hell").setDisableRain();
		
		//genTemple = new WorldGenTemple();
		//genChurch = new WorldGenChurch();
		//GameRegistry.registerBlock(HolyForgeIdle, "HolyForgeIdle");
		//GameRegistry.registerBlock(HolyForgeActive, "HolyForgeActive");
		GameRegistry.registerBlock(Altar, "Altar");
		GameRegistry.registerBlock(HolyOre, "HolyOre");
		GameRegistry.registerBlock(HolyStone, "HolyStone");
		GameRegistry.registerBlock(HolyCobbleStone, "HolyCobbleStone");
		GameRegistry.registerBlock(HolyBlock, "HolyBlock");
		GameRegistry.registerBlock(DogwoodLog, "DogwoodLog");
		GameRegistry.registerBlock(DogwoodPlanks, "DogwoodPlanks");
		GameRegistry.registerBlock(DogwoodLeaves, "DogwoodLeaves");
		GameRegistry.registerBlock(DogwoodSapling, "DogwoodSapling");
		GameRegistry.registerBlock(DemonicCreeperSkull, "DemonicCreeperSkull");
		GameRegistry.registerBlock(HellRock, "HellRock");
		GameRegistry.registerBlock(HeavenPortal, "HeavenPortal");
		GameRegistry.registerBlock(wineBlock, "WineBlock");
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
		//GameRegistry.registerItem(HolyGrail, "HolyGrail");
		//GameRegistry.registerItem(HolyGrailOFWine, "HolyGrailOFWine");
		//GameRegistry.registerItem(InstructionBook, "InstructionBook");
		  
		GameRegistry.registerTileEntity(TileEntityDemonicCreeperSkull.class, "DemonicCreeperSkull");
		
		//GameRegistry.registerWorldGenerator(worldgen1, 1);
		
		FluidContainerRegistry.registerFluidContainer(new FluidStack(Wine, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(WineBucket), new ItemStack(Items.bucket));
		
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
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(HolyStone), 0, new ModelResourceLocation(modid + ":" + ((HolyStone) HolyStone).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(HolyCobbleStone), 0, new ModelResourceLocation(modid + ":" + ((HolyCobbleStone) HolyCobbleStone).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(Altar), 0, new ModelResourceLocation(modid + ":" + ((Altar) Altar).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(HolyBlock), 0, new ModelResourceLocation(modid + ":" + ((HolyBlock) HolyBlock).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(HolyOre), 0, new ModelResourceLocation(modid + ":" + ((HolyOre) HolyOre).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(DogwoodLog), 0, new ModelResourceLocation("faithcraft2:DogwoodLog", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(DogwoodPlanks), 0, new ModelResourceLocation("faithcraft2:DogwoodPlanks", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(DogwoodLeaves), 0, new ModelResourceLocation("faithcraft2:DogwoodLeaves", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(DogwoodSapling), 0, new ModelResourceLocation("faithcraft2:DogwoodSapling", "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(HellRock), 0, new ModelResourceLocation(modid + ":" + ((HellRock) HellRock).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(HeavenPortal), 0, new ModelResourceLocation(modid + ":" + ((HeavenPortal) HeavenPortal).getName(), "inventory"));
		    	
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
		    	
		}
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(FaithCraft2.HolyCobbleStone),
		    	"GGG",
		    	"GSG",
		    	"GGG",
		    	'S', Blocks.cobblestone, 'G', Items.gold_nugget
		    	);
		GameRegistry.addRecipe(new ItemStack(FaithCraft2.HolyBlock),
		    	"HHH",
		    	"HGH",
		    	"HHH",
		    	'H', FaithCraft2.HolyStone, 'S', Blocks.gold_block
		    	);
		GameRegistry.addRecipe(new ItemStack(FaithCraft2.Altar),
		    	"NWN",
		    	" S ",
		    	"PPP",
		    	'N', Items.gold_nugget, 'W', Blocks.wool, 'S', FaithCraft2.DogwoodStick, 'P', FaithCraft2.DogwoodPlanks
		    	);
		GameRegistry.addSmelting(FaithCraft2.HolyCobbleStone, new ItemStack(FaithCraft2.HolyStone,1), 1F);
		
		GameRegistry.registerTileEntity(TileEntityAltar.class, "Altar");
		//GameRegistry.registerTileEntity(TileEntityHolyForge.class, "HolyForge");
		//FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(HeavenBiome, 100));
		//MinecraftForge.EVENT_BUS.register(PlayerSpawnHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		BucketHandler.INSTANCE.buckets.put(wineBlock, WineBucket);
		proxy.registerRenderThings();
		proxy.registerTileEntitySpecialRenderer();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postevent){
		
	}
	
}
