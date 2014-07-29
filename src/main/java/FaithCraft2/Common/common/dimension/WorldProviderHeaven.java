package FaithCraft2.Common.common.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import FaithCraft2.Common.common.*;

public class WorldProviderHeaven extends WorldProvider{

	@Override
	public String getDimensionName() {
		return "Heaven";
	}

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(FaithCraft2.HeavenBiome, 0.8F);
		this.dimensionId = FaithCraft2.HeavenId;
	}
	
	public IChunkProvider createChunkGenerator(){
		return new ChunkProviderHeaven(worldObj, worldObj.getSeed(), true);
	}
	
	public String getWelcomeMessage()
	{
		return "Entering Heaven";
	}

	/** Can player re-spawn here **/
	public boolean canRespawnHere()
	{
		return false;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
		return "Becoming an Angel";
	}
}
