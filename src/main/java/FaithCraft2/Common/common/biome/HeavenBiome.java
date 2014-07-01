package FaithCraft2.Common.common.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;
import FaithCraft2.Common.common.FaithCraft2;

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
		this.theBiomeDecorator.treesPerChunk = 0;
		this.spawnableCreatureList.clear();
		this.setTemperatureRainfall(0.8F, 0.4F);
		
		
	}
	
	public void addDefaultFlowers()
    {
        this.flowers.add(new FlowerEntry(Blocks.yellow_flower, 0, 20));
        this.flowers.add(new FlowerEntry(Blocks.red_flower,    0, 10));
    }
	
}
