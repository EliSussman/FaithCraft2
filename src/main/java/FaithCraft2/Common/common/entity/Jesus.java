package FaithCraft2.Common.common.entity;

import java.util.Random;

import net.minecraft.block.BlockEndPortal;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class Jesus extends EntityCreature implements IBossDisplayData{

	public int deathTicks;
	
	public Jesus(World world) {
		super(world);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
    }
	
	protected void onDeathUpdate()
    {
        ++this.deathTicks;

        if (this.deathTicks >= 180 && this.deathTicks <= 200)
        {
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
        }

        int i;
        int j;

        if (!this.worldObj.isRemote)
        {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0)
            {
                i = 1000;

                while (i > 0)
                {
                    j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
            }

            if (this.deathTicks == 1)
            {
                this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }

        this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.worldObj.isRemote)
        {
            i = 2000;

            while (i > 0)
            {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
            }

            createHeavenPortal(chunkCoordX * 16, chunkCoordZ * 16);
            this.setDead();
        }
    }

    /**
     * Creates the Heaven portal leading to Heaven after defeating Jesus.
     */
	private void createHeavenPortal(int x2, int z2){
		int x = x2 + rand.nextInt(15);
		int z = z2 + rand.nextInt(15);

		int y = worldObj.getHeightValue(x,z)-1;
		
    	worldObj.setBlock(x + 0, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 1, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 2, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 3, y + 0, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 0, y + 1, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 1, y + 1, z + 0, FaithCraft2.WineBlock, 0, 3);
		worldObj.setBlock(x + 3, y + 1, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 0, y + 2, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 3, y + 2, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 0, y + 3, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 3, y + 3, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 0, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 1, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 2, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
		worldObj.setBlock(x + 3, y + 4, z + 0, FaithCraft2.HolyBlock, 0, 3);
    }

}
