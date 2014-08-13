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
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
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
    
    public void createHeavenPortal(Entity entity){

    	int x = MathHelper.floor_double(entity.posX);
        int y = MathHelper.floor_double(entity.posY);
        int z = MathHelper.floor_double(entity.posZ);
		
    	worldServerInstance.setBlock(x + 0, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 1, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 2, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 3, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 0, y + 1, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 1, y + 1, z, FaithCraft2.HeavenPortal, 0, 3);
    	worldServerInstance.setBlock(x + 2, y + 1, z, FaithCraft2.HeavenPortal, 0, 3);
    	worldServerInstance.setBlock(x + 1, y + 2, z, FaithCraft2.HeavenPortal, 0, 3);
    	worldServerInstance.setBlock(x + 2, y + 2, z, FaithCraft2.HeavenPortal, 0, 3);
    	worldServerInstance.setBlock(x + 1, y + 3, z, FaithCraft2.HeavenPortal, 0, 3);
    	worldServerInstance.setBlock(x + 2, y + 3, z, FaithCraft2.HeavenPortal, 0, 3);
		worldServerInstance.setBlock(x + 3, y + 1, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 0, y + 2, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 3, y + 2, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 0, y + 3, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 3, y + 3, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 0, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 1, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 2, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldServerInstance.setBlock(x + 3, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
    }
    
    
    public void placeInPortal(Entity entity, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_)
    {
        if (this.worldServerInstance.provider.dimensionId != 1)
        {
            if (!this.placeInExistingPortal(entity, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_))
            {
            	this.placeInExistingPortal(entity, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
            }
            this.createHeavenPortal(entity);
        }
        else
        {
            int i = MathHelper.floor_double(entity.posX);
            int j = MathHelper.floor_double(entity.posY) - 1;
            int k = MathHelper.floor_double(entity.posZ);
            byte b0 = 1;
            byte b1 = 0;

            for (int l = -2; l <= 2; ++l)
            {
                for (int i1 = -2; i1 <= 2; ++i1)
                {
                    for (int j1 = -1; j1 < 3; ++j1)
                    {
                        int k1 = i + i1 * b0 + l * b1;
                        int l1 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean flag = j1 < 0;
                        this.worldServerInstance.setBlock(k1, l1, i2, flag ? FaithCraft2.HolyBlock : Blocks.air);
                    }
                }
            }
            entity.setLocationAndAngles((double)i, (double)j, (double)k, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        }
    }
    
    public boolean placeInExistingPortal(Entity entity, double p_77185_2_, double p_771845_4_, double p_77185_6_, float p_77185_8_)
    {
        short short1 = 128;
        double d3 = -1.0D;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = MathHelper.floor_double(entity.posX);
        int i1 = MathHelper.floor_double(entity.posZ);
        long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
        boolean flag = true;
        double d7;
        int l3;

        if (this.destinationCoordinateCache.containsItem(j1))
        {
            Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(j1);
            d3 = 0.0D;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else
        {
            for (l3 = l - short1; l3 <= l + short1; ++l3)
            {
                double d4 = (double)l3 + 0.5D - entity.posX;

                for (int l1 = i1 - short1; l1 <= i1 + short1; ++l1)
                {
                    double d5 = (double)l1 + 0.5D - entity.posZ;

                    for (int i2 = this.worldServerInstance.getActualHeight() - 1; i2 >= 0; --i2)
                    {
                        if (this.worldServerInstance.getBlock(l3, i2, l1) == FaithCraft2.HeavenPortal)
                        {
                            while (this.worldServerInstance.getBlock(l3, i2 - 1, l1) == FaithCraft2.HeavenPortal)
                            {
                                --i2;
                            }

                            d7 = (double)i2 + 0.5D - entity.posY;
                            double d8 = d4 * d4 + d7 * d7 + d5 * d5;

                            if (d3 < 0.0D || d8 < d3)
                            {
                                d3 = d8;
                                i = l3;
                                j = i2;
                                k = l1;
                            }
                        }
                    }
                }
            }
        }

        if (d3 >= 0.0D)
        {
            if (flag)
            {
                this.destinationCoordinateCache.add(j1, new Teleporter.PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(j1));
            }

            double d11 = (double)i + 0.5D;
            double d6 = (double)j + 0.5D;
            d7 = (double)k + 0.5D;
            int i4 = -1;

            if (this.worldServerInstance.getBlock(i - 1, j, k) == FaithCraft2.HeavenPortal)
            {
                i4 = 2;
            }

            if (this.worldServerInstance.getBlock(i + 1, j, k) == FaithCraft2.HeavenPortal)
            {
                i4 = 0;
            }

            if (this.worldServerInstance.getBlock(i, j, k - 1) == FaithCraft2.HeavenPortal)
            {
                i4 = 3;
            }

            if (this.worldServerInstance.getBlock(i, j, k + 1) == FaithCraft2.HeavenPortal)
            {
                i4 = 1;
            }

            int j2 = entity.getTeleportDirection();

            if (i4 > -1)
            {
                int k2 = Direction.rotateLeft[i4];
                int l2 = Direction.offsetX[i4];
                int i3 = Direction.offsetZ[i4];
                int j3 = Direction.offsetX[k2];
                int k3 = Direction.offsetZ[k2];
                boolean flag1 = !this.worldServerInstance.isAirBlock(i + l2 + j3, j, k + i3 + k3) || !this.worldServerInstance.isAirBlock(i + l2 + j3, j + 1, k + i3 + k3);
                boolean flag2 = !this.worldServerInstance.isAirBlock(i + l2, j, k + i3) || !this.worldServerInstance.isAirBlock(i + l2, j + 1, k + i3);
                if (flag1 && flag2)
                {
                    i4 = Direction.rotateOpposite[i4];
                    k2 = Direction.rotateOpposite[k2];
                    l2 = Direction.offsetX[i4];
                    i3 = Direction.offsetZ[i4];
                    j3 = Direction.offsetX[k2];
                    k3 = Direction.offsetZ[k2];
                    l3 = i - j3;
                    d11 -= (double)j3;
                    int k1 = k - k3;
                    d7 -= (double)k3;
                    flag1 = !this.worldServerInstance.isAirBlock(l3 + l2 + j3, j, k1 + i3 + k3) || !this.worldServerInstance.isAirBlock(l3 + l2 + j3, j + 1, k1 + i3 + k3);
                    flag2 = !this.worldServerInstance.isAirBlock(l3 + l2, j, k1 + i3) || !this.worldServerInstance.isAirBlock(l3 + l2, j + 1, k1 + i3);
                }

                float f1 = 0.5F;
                float f2 = 0.5F;

                if (!flag1 && flag2)
                {
                    f1 = 1.0F;
                    
                    
                }
                else if (flag1 && !flag2)
                {
                    f1 = 0.0F;
                    
                    
                }
                else if (flag1 && flag2)
                {
                    f2 = 0.0F;
                    
                    
                }

                d11 += (double)((float)j3 * f1 + f2 * (float)l2);
                d7 += (double)((float)k3 * f1 + f2 * (float)i3);
                float f3 = 0.0F;
                float f4 = 0.0F;
                float f5 = 0.0F;
                float f6 = 0.0F;

                if (i4 == j2)
                {
                    f3 = 1.0F;
                    f4 = 1.0F;
                    
                    
                }
                else if (i4 == Direction.rotateOpposite[j2])
                {
                    f3 = -1.0F;
                    f4 = -1.0F;
                    
                    
                }
                else if (i4 == Direction.rotateRight[j2])
                {
                    f5 = 1.0F;
                    f6 = -1.0F;
                    
                    
                }
                else
                {
                    f5 = -1.0F;
                    f6 = 1.0F;
                    
                    
                }

                double d9 = entity.motionX;
                double d10 = entity.motionZ;
                entity.motionX = d9 * (double)f3 + d10 * (double)f6;
                entity.motionZ = d9 * (double)f5 + d10 * (double)f4;
                entity.rotationYaw = p_77185_8_ - (float)(j2 * 90) + (float)(i4 * 90);
                
                
            }
            else
            {
                entity.motionX = entity.motionY = entity.motionZ = 0.0D;
                
                
            }
            entity.timeUntilPortal = 10;
            entity.setLocationAndAngles(i + 3, j + 3, k + 3, entity.rotationYaw, entity.rotationPitch);
            return true;
        }
        else
        {
            return true;
        }
    }
    
    
    /*if(entity.dimension == FaithCraft2.HeavenId){
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
    	return true;*/
    
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
    
public void removeStalePortalLocations(long p_85189_1_)
{
    if (p_85189_1_ % 100L == 0L)
    {
        Iterator iterator = this.destinationCoordinateKeys.iterator();
        long j = p_85189_1_ - 600L;

        while (iterator.hasNext())
        {
            Long olong = (Long)iterator.next();
            Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());

            if (portalposition == null || portalposition.lastUpdateTime < j)
            {
                iterator.remove();
                this.destinationCoordinateCache.remove(olong.longValue());
            }
        }
    }
}

public class PortalPosition extends ChunkCoordinates
{
    /** The worldtime at which this PortalPosition was last verified */
    public long lastUpdateTime;

    public PortalPosition(int p_i1962_2_, int p_i1962_3_, int p_i1962_4_, long p_i1962_5_)
    {
        super(p_i1962_2_, p_i1962_3_, p_i1962_4_);
        this.lastUpdateTime = p_i1962_5_;
    }
}
    
    
}