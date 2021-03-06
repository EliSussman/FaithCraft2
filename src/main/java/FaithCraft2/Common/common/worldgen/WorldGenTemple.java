/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

/*package FaithCraft2.Common.common.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import FaithCraft2.Common.common.*;

public class WorldGenTemple implements IWorldGenerator{

	protected Block[] GetValidSpawnBlocks()
	{
		return new Block[]
		{
			Blocks.grass,
			Blocks.dirt,
			FaithCraft2.HolyCobbleStone,
			FaithCraft2.HolyStone,
		};
	}
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId)
		{
		case -1:
		generateNether(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 0:
		generateSurface(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 1:
		generateEnd(world, random, chunkX * 16, chunkZ * 16);
		break;
		case 10:
		generateHeaven(world, random, chunkX * 16, chunkZ * 16);
		break;
		}
	}

	private void generateHeaven(World world, Random random, int i2, int k2) {
		int i = i2 + random.nextInt(15);
		int k = k2 + random.nextInt(15);

		int j = world.getHeightValue(i,k)-1;


		if((random.nextInt(1000000)+1)<=100000){
		boolean place = true;
		
		world.setBlock(i + 0, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 2, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 2, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 2, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 2, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 3, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 3, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 3, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 3, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 4, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 4, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 4, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 4, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 5, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 5, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 5, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 5, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 6, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 6, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 6, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 6, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 0, j + 7, k + 0, Blocks.stone_slab);
		world.setBlock(i + 0, j + 7, k + 4, Blocks.stone_slab);
		world.setBlock(i + 0, j + 7, k + 8, Blocks.stone_slab);
		world.setBlock(i + 0, j + 7, k + 12, Blocks.stone_slab);
		world.setBlock(i + 1, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 1, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 1, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 2, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 2, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 2, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 3, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 3, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 3, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 4, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 4, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 4, j + 2, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.chest);
		world.setBlock(i + 4, j + 2, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 2, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 3, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 3, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 3, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 4, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 4, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 4, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 5, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 5, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 5, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 6, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 6, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 6, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 7, k + 0, Blocks.stone_slab);
		world.setBlock(i + 4, j + 7, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 7, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 4, j + 8, k + 11, Blocks.stone_slab);
		world.setBlock(i + 4, j + 8, k + 12, Blocks.stone_slab);
		world.setBlock(i + 5, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 5, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 5, j + 2, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 2, k + 1, Blocks.chest);
		world.setBlock(i + 5, j + 2, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 2, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 3, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 3, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 3, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 4, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 4, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 4, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 5, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 5, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 5, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 6, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 6, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 6, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 7, k + 0, Blocks.stone_slab);
		world.setBlock(i + 5, j + 7, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 7, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 5, j + 8, k + 11, Blocks.stone_slab);
		world.setBlock(i + 5, j + 8, k + 12, Blocks.stone_slab);
		world.setBlock(i + 6, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 6, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 6, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 7, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 7, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 7, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 8, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 14, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 15, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 0, k + 16, Blocks.stone_slab);
		world.setBlock(i + 8, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 13, FaithCraft2.HolyStone);
		world.setBlock(i + 8, j + 1, k + 14, Blocks.stone_slab);
		world.setBlock(i + 9, j + 0, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 0, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 1, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 2, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 3, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 5, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 6, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 7, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 9, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 10, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 11, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 1, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 2, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 2, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 2, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 2, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 3, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 3, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 3, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 3, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 4, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 4, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 4, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 4, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 5, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 5, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 5, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 5, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 6, k + 0, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 6, k + 4, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 6, k + 8, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 6, k + 12, FaithCraft2.HolyStone);
		world.setBlock(i + 9, j + 7, k + 0, Blocks.stone_slab);
		world.setBlock(i + 9, j + 7, k + 4, Blocks.stone_slab);
		world.setBlock(i + 9, j + 7, k + 8, Blocks.stone_slab);
		world.setBlock(i + 9, j + 7, k + 12, Blocks.stone_slab);

		return;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
		
	}

	private void generateSurface(World world, Random random, int i2, int k2) {
	}

	private void generateNether(World world, Random random, int i, int j) {
		
	}

	private boolean LocationIsValidSpawn(World world, int chunkX, int chunkZ) {
		return false;
	}
}
*/