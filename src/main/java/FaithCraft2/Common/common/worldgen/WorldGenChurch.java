package FaithCraft2.Common.common.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenChurch implements IWorldGenerator{
	
	public boolean generate(World world, Random par2Random, int i2, int k2) {
		new ChurchBuild().generate(world, par2Random, i2, k2);
		return true;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()){
			case -1:
			break;
			case 0:
			generate(world, random, chunkX*16, chunkZ*16);
			break;
			case 1:
			break;
			case 10:
			generate(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}
}
