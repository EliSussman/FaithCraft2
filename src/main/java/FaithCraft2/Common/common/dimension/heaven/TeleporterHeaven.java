package FaithCraft2.Common.common.dimension.heaven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import FaithCraft2.Common.common.*;
import FaithCraft2.Common.common.blocks.HeavenPortal;

public class TeleporterHeaven extends Teleporter{
	private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    private final List destinationCoordinateKeys = Lists.newArrayList();
	
    public TeleporterHeaven(WorldServer worldIn){
        super(worldIn);
        this.worldServerInstance = worldIn;
        this.random = new Random(worldIn.getSeed());
    }
    
    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw){
	    if (this.worldServerInstance.provider.getDimensionId() != 1){
    		if (!placeInExistingPortal(entityIn, rotationYaw)){
    			int i = MathHelper.floor_double(entityIn.posX);
    			int j = MathHelper.floor_double(entityIn.posY)-1;
    			int k = MathHelper.floor_double(entityIn.posZ);
    			HeavenPortal.bottom = true;
    			HeavenPortal.makePortal(worldServerInstance, entityIn);
	    		placeInExistingPortal(entityIn, rotationYaw);
	    		entityIn.setLocationAndAngles((double) i, (double) j, (double) k,entityIn.rotationYaw, 0.0F);
	    		entityIn.motionX = entityIn.motionY = entityIn.motionZ = 0.0D;
	    	}
	    }
    }
    
    private boolean func_180265_a(BlockPos p_180265_1_)
    {
        return !this.worldServerInstance.isAirBlock(p_180265_1_) || !this.worldServerInstance.isAirBlock(p_180265_1_.up());
    }
    
    @Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw){
    	boolean flag = true;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(entityIn.posX);
        int j = MathHelper.floor_double(entityIn.posZ);
        boolean flag1 = true;
        Object object = BlockPos.ORIGIN;
        long k = ChunkCoordIntPair.chunkXZ2Int(i, j);

        if (this.destinationCoordinateCache.containsItem(k))
        {
            TeleporterHeaven.PortalPosition portalposition = (TeleporterHeaven.PortalPosition)this.destinationCoordinateCache.getValueByKey(k);
            d0 = 0.0D;
            object = portalposition;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag1 = false;
        }
        else
        {
            BlockPos blockpos4 = new BlockPos(entityIn);

            for (int l = -128; l <= 128; ++l)
            {
                BlockPos blockpos1;

                for (int i1 = -128; i1 <= 128; ++i1)
                {
                    for (BlockPos blockpos = blockpos4.add(l, this.worldServerInstance.getActualHeight() - 1 - blockpos4.getY(), i1); blockpos.getY() >= 0; blockpos = blockpos1)
                    {
                        blockpos1 = blockpos.down();

                        if (this.worldServerInstance.getBlockState(blockpos).getBlock() == FaithCraft2.HeavenPortal)
                        {
                            while (this.worldServerInstance.getBlockState(blockpos1 = blockpos.down()).getBlock() == FaithCraft2.HeavenPortal)
                            {
                                blockpos = blockpos1;
                            }

                            double d1 = blockpos.distanceSq(blockpos4);

                            if (d0 < 0.0D || d1 < d0)
                            {
                                d0 = d1;
                                object = blockpos;
                            }
                        }
                    }
                }
            }
        }

        if (d0 >= 0.0D)
        {
            if (flag1)
            {
                this.destinationCoordinateCache.add(k, new TeleporterHeaven.PortalPosition((BlockPos)object, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(k));
            }

            double d4 = (double)((BlockPos)object).getX() + 5.5D;
            double d5 = (double)((BlockPos)object).getY() + 0.5D;
            double d6 = (double)((BlockPos)object).getZ() + 5.5D;
            EnumFacing enumfacing = null;
            entityIn.setLocationAndAngles(d4, d5, d6, entityIn.rotationYaw, entityIn.rotationPitch);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void removeStalePortalLocations(long p_85189_1_)
    {
        if (p_85189_1_ % 100L == 0L)
        {
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = p_85189_1_ - 600L;

            while (iterator.hasNext())
            {
                Long olong = (Long)iterator.next();
                TeleporterHeaven.PortalPosition portalposition = (TeleporterHeaven.PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());

                if (portalposition == null || portalposition.lastUpdateTime < j)
                {
                    iterator.remove();
                    this.destinationCoordinateCache.remove(olong.longValue());
                }
            }
        }
    }

    public class PortalPosition extends BlockPos
    {
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long p_i45747_3_)
        {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.lastUpdateTime = p_i45747_3_;
        }
    }
}