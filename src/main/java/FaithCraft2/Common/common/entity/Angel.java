package FaithCraft2.Common.common.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;

public class Angel extends EntityCreature{

	public Angel(World world) {
		super(world);
	}
	
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
    }

}
