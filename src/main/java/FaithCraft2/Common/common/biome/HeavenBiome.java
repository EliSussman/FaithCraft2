package FaithCraft2.Common.common.biome;

import java.awt.List;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Angel;

public class HeavenBiome extends BiomeGenBase{
	
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

        if (random.nextInt(10) == 0)
        {
            int k = par3 + random.nextInt(16) + 8;
            int l = par4 + random.nextInt(16) + 8;
            WorldGenLakes worldgenlakes = new WorldGenLakes(FaithCraft2.WineBlock);
            worldgenlakes.generate(world, random, k, world.getHeightValue(k, l) + 1, l);
        }
    }
	
	 public int getBiomeFoliageColor(int x, int y, int z)
	    {
			return 0xFFFFFF;
		}
	
}
