/*package FaithCraft2.Common.common.dimension.hell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterHell extends Teleporter{

	private final WorldServer worldServerInstance;
    private final Random random;

    private final WorldServer currentWorld;
    
    public TeleporterHell(WorldServer worldserver){
        super(worldserver);
        this.worldServerInstance = worldserver;
        this.random = new Random(worldserver.getSeed());
        this.currentWorld = worldserver;
    }
    
    public void placeInPortal(Entity entity, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_)
    {
        if (this.worldServerInstance.provider.dimensionId != 1)
        {
            if (!this.placeInExistingPortal(entity, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_))
            {
   
                this.placeInExistingPortal(entity, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
            }
        }
        else
        {
            
        }
    }

    public boolean placeInExistingPortal(Entity entity, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_)
    {
    	
		return true;
    }
}
*/