package FaithCraft2.Common.common.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;

import java.awt.List;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;
import net.minecraftforge.event.terraingen.TerrainGen;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Angel;
import FaithCraft2.Common.common.worldgen.WorldGenDogwoodTrees;

public class HeavenBiome extends BiomeGenBase{
	
	/** The world the BiomeDecorator is currently decorating */
    public World currentWorld;
    /** The Biome Decorator's random number generator. */
    public Random randomGenerator;
    /** The X-coordinate of the chunk currently being decorated */
    public int chunk_X;
    /** The Z-coordinate of the chunk currently being decorated */
    public int chunk_Z;
	
	public HeavenBiome(int par1) {
		super(par1);
		topBlock = FaithCraft2.HolyStone;
		fillerBlock = FaithCraft2.HolyCobbleStone;
		this.theBiomeDecorator.bigMushroomsPerChunk = 30;
		this.waterColorMultiplier = 0xFFFFFF;
		this.heightVariation = 0;
		this.enableSnow = true;
		this.enableRain = false;
		this.spawnableCreatureList.clear();
		this.setTemperatureRainfall(0.8F, 0.4F);
		this.setColor(0xFFFFFF);
		this.height_LowPlains.rootHeight = -2;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.spawnableCreatureList.add(new SpawnListEntry(Angel.class, 3, 4, 4));
		this.theBiomeDecorator.generateLakes = false;
		
	}
	
	public void addDefaultFlowers()
    {
        this.flowers.add(new FlowerEntry(Blocks.yellow_flower, 0, 20));
        this.flowers.add(new FlowerEntry(Blocks.red_flower,    0, 10));
    }
	
	public void decorate(World world, Random random, int par3, int par4)
    {
        super.decorate(world, random, par3, par4);
        
        for (int c = 60; c > 0; c--){
        int j2 = par3 + random.nextInt(16) + 8;
        int l3 = random.nextInt(120);
        int j5 = par4 + random.nextInt(16) + 8;
        if (world.getBlock(j2, l3 - 1, j5) == FaithCraft2.HolyStone)
        {
        new WorldGenDogwoodTrees(true, 4 + random.nextInt(8), 0, 0, false).generate(world, random, j2, l3, j5);
        }
        }

        if (random.nextInt(10) == 0)
        {
            int k = par3 + random.nextInt(16) + 8;
            int l = par4 + random.nextInt(16) + 8;
            WorldGenLakes worldGenlakes = new WorldGenLakes(FaithCraft2.WineBlock);
            worldGenlakes.generate(world, random, k, world.getHeightValue(k, l) + 1, l);
        }
    }
	
	 public int getBiomeFoliageColor(int x, int y, int z)
	    {
			return 0xFFFFFF;
		}
	
}
