/*package FaithCraft2.Common.common.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAngel extends RenderLiving{
	
    private static final ResourceLocation angelTextures = new ResourceLocation("faithcraft2:textures/entity/Angel.png");

    public RenderAngel(ModelAngel angel, float p_i1253_2_)
    {
        super(new ModelAngel(), 1.0F);
        
    }
    
    @Override
	public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
		super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);
	}
    
    public void doRender(Jesus entity, double blarg1, double blarg2, double blarg3, float blarg4, float blarg5) {
		super.doRender(entity, blarg1, blarg2, blarg3, blarg4, blarg5);
	}
    
    protected ResourceLocation getEntityTexture(Angel angel)
    {
        return angelTextures;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((Angel)entity);
    }
	
}
*/