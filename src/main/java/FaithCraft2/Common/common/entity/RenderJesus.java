package FaithCraft2.Common.common.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Jesus;;

@SideOnly(Side.CLIENT)
public class RenderJesus extends RenderLiving
{
    private static final ResourceLocation jesusTextures = new ResourceLocation("faithcraft2:textures/entity/Jesus.png");

    public RenderJesus(ModelJesus jesus, float p_i1253_2_)
    {
        super(new ModelJesus(), 1.0F);
        
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Jesus p_110775_1_)
    {
        return jesusTextures;
    }
    
    @Override
	public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		BossStatus.setBossStatus((IBossDisplayData) par1EntityLiving, false);

		super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
	}
    
    public void doRender(Jesus entity, double blarg1, double blarg2, double blarg3, float blarg4, float blarg5) {
		BossStatus.setBossStatus((Jesus) entity, false);
		super.doRender(entity, blarg1, blarg2, blarg3, blarg4, blarg5);
	}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((Jesus)p_110775_1_);
    }
    
    
}
