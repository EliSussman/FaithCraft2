package FaithCraft2.Common.common.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;

import java.awt.List;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
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
import FaithCraft2.Common.common.worldgen.WorldGenDogwoodTrees;

public class HeavenBiome extends BiomeGenBase{
    public World currentWorld;
    public Random randomGenerator;
    public int chunk_X;
    public int chunk_Z;
	
	public HeavenBiome(int par1) {
		super(par1);
		topBlock = FaithCraft2.HolyStone.getDefaultState();
		fillerBlock = FaithCraft2.HolyCobbleStone.getDefaultState();
		this.theBiomeDecorator.bigMushroomsPerChunk = 30;
		this.waterColorMultiplier = 0xFFFFFF;
		this.enableSnow = true;
		this.enableRain = false;
		this.spawnableCreatureList.clear();
		this.setTemperatureRainfall(0.8F, 0.4F);
		this.setColor(0xFFFFFF);
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;
	}
	
	public void addDefaultFlowers()
    {
        this.flowers.add(new FlowerEntry(Blocks.yellow_flower.getDefaultState(), 20));
        this.flowers.add(new FlowerEntry(Blocks.red_flower.getDefaultState(), 10));
    }
	
	public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        if (world.getBlockState(pos) == FaithCraft2.HolyStone)
        {
        new WorldGenDogwoodTrees(true).generate(world, random, pos);
        }

        if (random.nextInt(10) == 0)
        {
            WorldGenLakes worldGenlakes = new WorldGenLakes(FaithCraft2.WineBlock);
            worldGenlakes.generate(world, random, pos);
        }
    }
	
	 public int getBiomeFoliageColor(int x, int y, int z)
	    {
			return 0xFFFFFF;
		}
	
}