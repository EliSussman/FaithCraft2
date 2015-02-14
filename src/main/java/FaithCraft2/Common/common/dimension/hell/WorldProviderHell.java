/*package FaithCraft2.Common.common.dimension.hell;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import FaithCraft2.Common.common.*;

public class WorldProviderHell extends WorldProvider{

	@Override
	public String getDimensionName() {
		return "Hell";
	}

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(FaithCraft2.HellBiome, 0.8F);
		this.dimensionId = FaithCraft2.HellId;
	}
	
	public IChunkProvider createChunkGenerator(){
		return new ChunkProviderHell(worldObj, worldObj.getSeed(), true);
	}
	
	public String getWelcomeMessage()
	{
		return "Entering Hell";
	}
	public boolean canRespawnHere()
	{
		return false;
	}
}
*/