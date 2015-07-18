package FaithCraft2.Common.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import FaithCraft2.Common.common.fluids.WineBlock;

public class FaithCraftBlocks {

	public static Fluid Wine;
	
	public static Block HolyOre;
	public static Block HolyStone;
	public static Block HolyCobbleStone;
	public static Block HeavenPortal;
	public static Block HolyBlock;
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
	
	public static Block HolyController;
	public static Block Altar;
	
	public static ResourceLocation still = new ResourceLocation("faithcraft2:blocks/WineStill");
	public static ResourceLocation flowing = new ResourceLocation("faithcraft2:blocks/WineFlow");
	
	public static void init(){
		Wine = new Fluid("Wine", still, flowing);
		FluidRegistry.registerFluid(Wine);
		wineBlock = new WineBlock(Wine, Material.water); 
		
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
		
		HolyController = new HolyController(Material.iron).setUnlocalizedName("HolyController");
		Altar = new Altar(Material.rock).setUnlocalizedName("Altar");
	}
}
