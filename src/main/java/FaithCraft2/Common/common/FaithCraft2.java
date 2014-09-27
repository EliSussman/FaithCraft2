package FaithCraft2.Common.common;

import java.lang.reflect.Field;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import FaithCraft2.Common.common.biome.HeavenBiome;
import FaithCraft2.Common.common.biome.HellBiome;
import FaithCraft2.Common.common.blocks.Altar;
import FaithCraft2.Common.common.blocks.HolyCobbleStone;
import FaithCraft2.Common.common.blocks.HolyForge;
import FaithCraft2.Common.common.blocks.HolyOre;
import FaithCraft2.Common.common.blocks.HolyStone;
import FaithCraft2.Common.common.blocks.WineBlock;
import FaithCraft2.Common.common.dimension.heaven.WorldProviderHeaven;
import FaithCraft2.Common.common.dimension.hell.WorldProviderHell;
import FaithCraft2.Common.common.entity.EntityMobRegistry;
import FaithCraft2.Common.common.handler.BucketHandler;
import FaithCraft2.Common.common.handler.ConfigHandler;
import FaithCraft2.Common.common.handler.CraftingHandler;
import FaithCraft2.Common.common.handler.GuiHandler;
import FaithCraft2.Common.common.handler.PlayerSpawnHandler;
import FaithCraft2.Common.common.items.Bible;
import FaithCraft2.Common.common.items.BodyOFChrist;
import FaithCraft2.Common.common.items.Cross;
import FaithCraft2.Common.common.items.HolyCross;
import FaithCraft2.Common.common.items.GoldenDogwoodStick;
import FaithCraft2.Common.common.items.HolyGrail;
import FaithCraft2.Common.common.items.HolyGrailOFWine;
import FaithCraft2.Common.common.items.DogwoodStick;
import FaithCraft2.Common.common.items.Quran;
import FaithCraft2.Common.common.items.Torah;
import FaithCraft2.Common.common.items.WineBucket;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;
import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
import FaithCraft2.Common.common.worldgen.HolyWorldGen;
import FaithCraft2.Common.common.worldgen.WorldGenChurch;
import FaithCraft2.Common.common.worldgen.WorldGenTemple;
import FaithCraft2.Common.common.blocks.HolyBlock;
import FaithCraft2.Common.common.entity.Angel;
import FaithCraft2.Common.common.blocks.DogwoodLeaves;
import FaithCraft2.Common.common.blocks.DogwoodLog;
import FaithCraft2.Common.common.blocks.DogwoodSapling;
import FaithCraft2.Common.common.blocks.DogwoodPlank;
import FaithCraft2.Common.common.items.InstructionBook;
import FaithCraft2.Common.common.blocks.HellRock;
import FaithCraft2.Common.common.handler.PlayerInteractWithHell;
import FaithCraft2.Common.common.blocks.HellCobbleStone;

import com.google.common.base.Throwables;
import com.google.common.collect.ObjectArrays;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid = FaithCraft2.modid, version = FaithCraft2.version, guiFactory = FaithCraft2.guiFactory)
public class FaithCraft2{
	public static final String modid = "FaithCraft2";
	public static final String version = "2.0 Alpha";
	public static final String guiFactory = "FaithCraft2.Common.client.gui.GuiFactory";

public static HolyWorldGen worldgen1 = new HolyWorldGen();

public static ToolMaterial Christianity = EnumHelper.addToolMaterial("CHRISTIANITY", 1, 1, 1.0F, 10, 10);
public static ToolMaterial Holy = EnumHelper.addToolMaterial("HOLY", 2, 3, 2.0F, 20, 20);

public static CreativeTabs FaithCraft2Tab = new FaithCraft2Tab(CreativeTabs.getNextID(), "FaithCraft 2.0 Tab");

@Instance(modid)
public static FaithCraft2 instance;

public static final int guiIDInstructionBook = 2;

public static final int guiIDAltar = 1;
public static Block Altar;

public static final int guiIDHolyForge = 0;
public static Block HolyForgeIdle;
public static Block HolyForgeActive;

public static Block HolyOre;
public static Block HolyStone;
public static Block HolyCobbleStone;
public static Block WineBlock;
public static Block HeavenPortal;
public static Block HolyBlock;
public static Block AltarMB;
public static Block DogwoodLeaves;
public static Block DogwoodLog;
public static Block DogwoodSapling;
public static Block DogwoodPlank;
public static Block HellRock;
public static Block HellCobbleStone;

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

public static Fluid Wine;

public static BiomeGenBase HeavenBiome;

public static BiomeGenBase HellBiome;

public static IWorldGenerator genTemple;
public static IWorldGenerator genChurch;

public static int HeavenId = 10;

public static int HellId = 11;

public static MerchantRecipeList merchantRecipeList;
public static Angel angel;
public static Random rand;

@SidedProxy(clientSide = "FaithCraft2.Common.client.ClientProxy", serverSide = "FaithCraft2.Common.common.CommonProxy")
public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		EntityMobRegistry.mainRegistry();
		
		proxy.registerRenderThings();
		
		ConfigHandler.init(preEvent.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());
		
		Wine = new Fluid("Wine").setViscosity(900).setTemperature(250);
		FluidRegistry.registerFluid(Wine);
		
		Altar = new Altar(Material.rock).setBlockName("Altar").setBlockTextureName("FaithCraft2:Altar"); 

		HolyForgeIdle = new HolyForge(false).setBlockName("HolyForgeIdle").setCreativeTab(FaithCraft2.FaithCraft2Tab).setHardness(3.5F);
		HolyForgeActive = new HolyForge(true).setBlockName("HolyForgeActive").setLightLevel(0.625F).setHardness(3.6F);
		
		HolyOre= new HolyOre(3006, Material.rock).setBlockName("HolyOre").setBlockTextureName("FaithCraft2:HolyOre");
		HolyStone = new HolyStone(3010, Material.rock).setBlockName("HolyStone").setBlockTextureName("FaithCraft2:HolyStone");
		HolyCobbleStone = new HolyCobbleStone(3011, Material.rock).setBlockName("HolyCobbleStone").setBlockTextureName("FaithCraft2:HolyCobbleStone");
		WineBlock = new WineBlock(Wine, Material.water).setBlockName("Wine");
		HolyBlock = new HolyBlock(3015, Material.rock).setBlockName("HolyBlock");
		DogwoodLeaves = new DogwoodLeaves(3016).setBlockName("DogwoodLeaves");
		DogwoodLog = new DogwoodLog(3017, Material.wood).setBlockName("DogwoodLog");
		DogwoodSapling = new DogwoodSapling(3018).setBlockName("DogwoodSapling");
		DogwoodPlank = new DogwoodPlank(3019, Material.wood).setBlockName("DogwoodPlank");
		HellRock = new HellRock(3021, Material.rock).setBlockName("HellRock").setBlockTextureName("FaithCraft2:HellRock");
		HellCobbleStone = new HellCobbleStone(3022, Material.rock).setBlockName("HellCobbleStone").setBlockTextureName("FaithCraft2:HellCobbleStone");
		
		Bible = new Bible(3001).setUnlocalizedName("Bible").setTextureName("FaithCraft2:Bible");
		BodyOFChrist = new BodyOFChrist(3002).setUnlocalizedName("BodyOFChrist").setTextureName("FaithCraft2:BodyOFChrist");
		Cross = new Cross(3003, Christianity).setUnlocalizedName("Cross").setTextureName("FaithCraft2:Cross");
		Quran = new Quran(3004).setUnlocalizedName("Quran").setTextureName("FaithCraft2:Quran");
		Torah = new Torah(3005).setUnlocalizedName("Torah").setTextureName("FaithCraft2:Torah");
		HolyCross = new HolyCross(3007, Holy).setUnlocalizedName("HolyCross").setTextureName("FaithCraft2:HolyCross");
		DogwoodStick = new DogwoodStick(3008).setUnlocalizedName("DogwoodStick").setTextureName("FaithCraft2:DogwoodStick");
		GoldenDogwoodStick = new GoldenDogwoodStick(3009).setUnlocalizedName("GoldenDogwoodStick").setTextureName("FaithCraft2:GoldenDogwoodStick");
		WineBucket = new WineBucket(WineBlock).setUnlocalizedName("WineBucket").setTextureName("FaithCraft2:WineBucket").setContainerItem(Items.bucket);
		HolyGrail = new HolyGrail(3012).setUnlocalizedName("HolyGrail").setTextureName("FaithCraft2:HolyGrail");
		HolyGrailOFWine = new HolyGrailOFWine(0, 0.0F, true).setAlwaysEdible().setUnlocalizedName("HolyGrailOFWine").setTextureName("FaithCraft2:HolyGrailOFWine");
		InstructionBook = new InstructionBook(3020).setUnlocalizedName("InstructionBook").setTextureName("FaithCraft2:InstructionBook");
		
		HeavenBiome = new HeavenBiome(245).setBiomeName("Heaven").setDisableRain();
		HellBiome = new HellBiome(246).setBiomeName("Hell").setDisableRain();
		
		genTemple = new WorldGenTemple();
		genChurch = new WorldGenChurch();
		
		GameRegistry.registerBlock(HolyForgeIdle, "HolyForgeIdle");
		GameRegistry.registerBlock(HolyForgeActive, "HolyForgeActive");
		GameRegistry.registerBlock(Altar, "Altar");
		GameRegistry.registerBlock(HolyOre, "HolyOre");
		GameRegistry.registerBlock(HolyStone, "HolyStone");
		GameRegistry.registerBlock(HolyCobbleStone, "HolyCobbleStone");
		GameRegistry.registerBlock(WineBlock, "WineBlock");
		GameRegistry.registerBlock(HolyBlock, "HolyBlock");
		GameRegistry.registerBlock(DogwoodLeaves, "DogwoodLeaves");
		GameRegistry.registerBlock(DogwoodLog, "DogwoodLog");
		GameRegistry.registerBlock(DogwoodSapling, "DogwoodSapling");
		GameRegistry.registerBlock(DogwoodPlank, "DogwoodPlank");
		GameRegistry.registerBlock(HellRock, "HellRock");
		GameRegistry.registerBlock(HellCobbleStone, "HellCobbleStone");
		
		GameRegistry.registerItem(Bible, "Bible");
		GameRegistry.registerItem(BodyOFChrist, "BodyOFChrist");
		GameRegistry.registerItem(Cross, "Cross");
		GameRegistry.registerItem(Quran, "Quran");
		GameRegistry.registerItem(Torah, "Torah");
		GameRegistry.registerItem(HolyCross, "HolyCross");
		GameRegistry.registerItem(DogwoodStick, "DogwoodStick");
		GameRegistry.registerItem(GoldenDogwoodStick, "GoldenDogwoodStick");
		GameRegistry.registerItem(WineBucket, "WineBucket");
		GameRegistry.registerItem(HolyGrail, "HolyGrail");
		GameRegistry.registerItem(HolyGrailOFWine, "HolyGrailOFWine");
		GameRegistry.registerItem(InstructionBook, "InstructionBook");
		
		GameRegistry.registerWorldGenerator(worldgen1, 1);
		
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("wine", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(WineBucket), new ItemStack(Items.bucket));
		
		GameRegistry.registerWorldGenerator(genTemple, 1);
		GameRegistry.registerWorldGenerator(genChurch, 1);
		
		DimensionManager.registerProviderType(HeavenId, WorldProviderHeaven.class, true);
		DimensionManager.registerDimension(HeavenId, HeavenId);
		
		DimensionManager.registerProviderType(HellId, WorldProviderHell.class, true);
		DimensionManager.registerDimension(HellId, HellId);
	}

	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		
		GameRegistry.registerTileEntity(TileEntityAltar.class, "Altar");
		GameRegistry.registerTileEntity(TileEntityHolyForge.class, "HolyForge");
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		MinecraftForge.EVENT_BUS.register(PlayerSpawnHandler.INSTANCE);
		
		MinecraftForge.EVENT_BUS.register(PlayerInteractWithHell.INSTANCE);
		
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		BucketHandler.INSTANCE.buckets.put(WineBlock, WineBucket);
		
		GameRegistry.addShapelessRecipe(new ItemStack(FaithCraft2.DogwoodPlank, 2), new ItemStack(FaithCraft2.DogwoodLog));
		GameRegistry.addRecipe(new ItemStack(FaithCraft2.DogwoodStick, 2), new Object[] {"D", "D", 'D', FaithCraft2.DogwoodPlank});
		GameRegistry.addRecipe(new ItemStack(FaithCraft2.HellRock, 2), new Object[] {"NNN", "NGN", "NNN", 'N', Blocks.netherrack, 'G', Items.gold_ingot});
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postevent){
	}
	
}
