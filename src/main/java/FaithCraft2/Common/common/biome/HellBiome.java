package FaithCraft2.Common.common.biome;

import java.util.Random;

import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Angel;
import FaithCraft2.Common.common.entity.Demon;
import FaithCraft2.Common.common.worldgen.WorldGenDogwoodTrees;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class HellBiome extends BiomeGenBase{
	/** The world the BiomeDecorator is currently decorating */
    public World currentWorld;
    /** The Biome Decorator's random number generator. */
    public Random randomGenerator;
    /** The X-coordinate of the chunk currently being decorated */
    public int chunk_X;
    /** The Z-coordinate of the chunk currently being decorated */
    public int chunk_Z;
    
    public HellBiome(int par1) {
		super(par1);
		topBlock = FaithCraft2.HellRock;
		fillerBlock = FaithCraft2.HellCobbleStone;
		this.theBiomeDecorator.bigMushroomsPerChunk = -999;
		this.waterColorMultiplier = 0x000000;
		this.heightVariation = 0;
		this.enableSnow = false;
		this.enableRain = false;
		this.spawnableCreatureList.clear();
		this.setTemperatureRainfall(0.8F, 0.4F);
		this.setColor(0x000000);
		this.height_LowPlains.rootHeight = -2;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.spawnableCreatureList.add(new SpawnListEntry(Demon.class, 4, 4, 4));
		this.theBiomeDecorator.generateLakes = false;
	}
	
	 public int getBiomeFoliageColor(int x, int y, int z)
	    {
			return 0x000000;
		}
	
}
