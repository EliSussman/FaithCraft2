package FaithCraft2.Common.common.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import FaithCraft2.Common.common.FaithCraft2;

public class HeavenBiome extends BiomeGenBase{
	
	public HeavenBiome(int par1) {
		super(par1);
		topBlock = FaithCraft2.HolyStone;
		fillerBlock = FaithCraft2.HolyCobbleStone;
		this.theBiomeDecorator.bigMushroomsPerChunk = 30;
	}

}
