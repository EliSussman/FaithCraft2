/*package FaithCraft2.Common.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.dimension.heaven.TeleporterHeaven;

public class Demon extends EntityMob{

	public int deathTicks;
	
	public Demon(World world) {
		super(world);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
    }
	
	protected void onDeathUpdate()
	{
		this.setDead();
		
		Entity entity = attackingPlayer;
		if (entity instanceof EntityPlayerMP){
			EntityPlayerMP player = (EntityPlayerMP) entity;
            if (entity.dimension != FaithCraft2.HeavenId){
            	player.timeUntilPortal = 10;
            	{
            		 player.mcServer.getConfigurationManager().transferPlayerToDimension(player, FaithCraft2.HeavenId, new TeleporterHeaven(player.mcServer.worldServerForDimension(FaithCraft2.HeavenId)));
            	}
            }
        }
    }
}
*/