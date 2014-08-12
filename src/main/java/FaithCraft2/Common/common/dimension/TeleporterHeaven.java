package FaithCraft2.Common.common.dimension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.Event;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.HolyBlock;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.Teleporter.PortalPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent;

public class TeleporterHeaven extends Teleporter{

	private final WorldServer worldServerInstance;
    /**
     * A private Random() function in Teleporter
     */
    private final Random random;
    /**
     * Stores successful portal placement locations for rapid lookup.
     */
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    /**
     * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
     * location.
     */
    private final List destinationCoordinateKeys = new ArrayList();

    private final WorldServer currentWorld;
    
    public TeleporterHeaven(WorldServer worldserver){
        super(worldserver);
        this.worldServerInstance = worldserver;
        this.random = new Random(worldserver.getSeed());
        this.currentWorld = worldserver;
    }
    
    public void createHeavenPortal(int x2, int z2, World world){
		int x = x2 = 0;
		int z = z2 = 0;

		int y = world.getHeightValue(x,z)-1;
		
    	world.setBlock(x + 0, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 1, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 2, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 3, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 0, y + 1, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 1, y + 1, z, FaithCraft2.HeavenPortal, 0, 3);
    	world.setBlock(x + 2, y + 1, z, FaithCraft2.HeavenPortal, 0, 3);
    	world.setBlock(x + 1, y + 2, z, FaithCraft2.HeavenPortal, 0, 3);
    	world.setBlock(x + 2, y + 2, z, FaithCraft2.HeavenPortal, 0, 3);
    	world.setBlock(x + 1, y + 3, z, FaithCraft2.HeavenPortal, 0, 3);
    	world.setBlock(x + 2, y + 3, z, FaithCraft2.HeavenPortal, 0, 3);
		world.setBlock(x + 3, y + 1, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 0, y + 2, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 3, y + 2, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 0, y + 3, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 3, y + 3, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 0, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 1, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 2, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		world.setBlock(x + 3, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
    }
    
    
    public void placeInPortal(Entity entity, double par2, double par4, double par6, float par8){
    	if(this.currentWorld.provider.dimensionId == FaithCraft2.HeavenId){
    		
    		int x = 0;
    		int z = 0;
    		int y = worldServerInstance.getHeightValue(x, z);
    		
    		this.createHeavenPortal(x, z, worldServerInstance);
    		entity.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
    		System.out.println("Hello");
    	}
    }
    
    
   
    
    
    
public boolean placeInExistingPortal(Entity entity, double par2, double par4, double par6, float par8){
		
	int x = 0;
	int z = 0;
	int y = worldServerInstance.getHeightValue(x,z);
	
	EntityPlayerMP	EMPlayer = (EntityPlayerMP) entity;
	int dimension = 0;
    WorldServer worldserver = EMPlayer.mcServer.worldServerForDimension(dimension);
	
		if(entity.dimension == FaithCraft2.HeavenId){
			EMPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(EMPlayer, dimension, this);
			if(worldserver.getBlock(x, y, z) instanceof HeavenPortal){
				EMPlayer.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
				System.out.println("Hello2");
			}else{
			this.createHeavenPortal(x, z, worldserver);
			EMPlayer.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
			System.out.println("Hello3");
			}
		}
    	return true;
    }
    
    /*public boolean placeInExistingPortal(Entity entity, double par2, double par4, double par6, float par8){
		
		int x = 0;
		int z = 0;
		int y = worldServerInstance.getHeightValue(x,z);
		
		EntityPlayerMP	EMPlayer = (EntityPlayerMP) entity;
    	int dimension = 0;
        WorldServer worldserver = EMPlayer.mcServer.worldServerForDimension(dimension);
        
      if(entity.dimension == FaithCraft2.HeavenId){
        EMPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(EMPlayer, dimension, this);
        if(
        		worldserver.getBlock(x, y, z) instanceof HolyBlock &&
				worldserver.getBlock(x + 1, y + 0, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 2, y + 0, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 3, y + 0, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 3, y + 1, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 3, y + 2, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 3, y + 3, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 3, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 2, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 1, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 0, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 0, y + 3, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 0, y + 2, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 0, y + 1, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x + 1, y + 1, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x + 2, y + 1, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x + 1, y + 2, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x + 2, y + 2, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x + 1, y + 3, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x + 2, y + 3, z + 0) instanceof HeavenPortal ||
				
				worldserver.getBlock(x, y, z) instanceof HolyBlock &&
				worldserver.getBlock(x - 1, y + 0, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 2, y + 0, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 3, y + 0, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 3, y + 1, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 3, y + 2, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 3, y + 3, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 3, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 2, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 1, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 0, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 0, y + 3, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 0, y + 2, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 0, y + 1, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x - 1, y + 1, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x - 2, y + 1, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x - 1, y + 2, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x - 2, y + 2, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x - 1, y + 3, z + 0) instanceof HeavenPortal &&
				worldserver.getBlock(x - 2, y + 3, z + 0) instanceof HeavenPortal ||
				
				worldserver.getBlock(x, y, z) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 0, z + 1) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 0, z + 2) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 0, z + 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 1, z + 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 2, z + 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 3, z + 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z + 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z + 2) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z + 1) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 3, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 2, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 1, z + 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 1, z + 1) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 1, z + 2) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 2, z + 1) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 2, z + 2) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 3, z + 1) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 3, z + 2) instanceof HeavenPortal ||
				
				worldserver.getBlock(x, y, z) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 0, z - 1) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 0, z - 2) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 0, z - 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 1, z - 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 2, z - 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 3, z - 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z - 3) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z - 2) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z - 1) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 4, z - 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 3, z - 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 2, z - 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 1, z - 0) instanceof HolyBlock &&
				worldserver.getBlock(x, y + 1, z - 1) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 1, z - 2) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 2, z - 1) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 2, z - 2) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 3, z - 1) instanceof HeavenPortal &&
				worldserver.getBlock(x, y + 3, z - 2) instanceof HeavenPortal
        		){
        	entity.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
			System.out.println("Hello2");
		}else{
			this.createHeavenPortal(x, z, worldserver);
			entity.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
			System.out.println("Hello3");
		}
      }
    	return true;
    	
    }*/
    
    
    
    
}