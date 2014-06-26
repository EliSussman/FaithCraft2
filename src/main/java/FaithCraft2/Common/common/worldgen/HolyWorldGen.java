package FaithCraft2.Common.common.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import FaithCraft2.Common.common.blocks.*;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider){	
		switch (world.provider.dimensionId){
		case -1 : generateNether(world, random, chunkX*16, chunkZ*16);
		case 0 : generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	public void generateSurface(World world, Random random, int x, int z) {
		for(int i = 0; i < 10; i++){
			int Xcoords = x + random.nextInt(16);
			int Ycoords = random.nextInt(256);
			int Zcoords = z + random.nextInt(16);
			new WorldGenMinable(FaithCraft2.HolyOre, 3).generate(world, random, Xcoords, Ycoords, Zcoords);
		}
		
		for(int i = 0; i < 100; i++){
			int Xcoords = x + random.nextInt(16);
			int Ycoords = random.nextInt(256);
			int Zcoords = z + random.nextInt(16);
			new WorldGenMinable(FaithCraft2.HolyCobbleStone, 50).generate(world, random, Xcoords, Ycoords, Zcoords);
		}
	}

	public void generateNether(World world, Random random, int x, int z) {
		
	}
}
