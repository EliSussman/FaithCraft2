package FaithCraft2.Common.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDemon extends RenderLiving{

	private static final ResourceLocation demonTextures = new ResourceLocation("faithcraft2:textures/entity/Demon.png");
	
	public RenderDemon(ModelDemon demon, float p_i1262_2_) {
		super(new ModelDemon(), 1.0F);
	}

	protected ResourceLocation getEntityTexture(Demon demon)
    {
        return demonTextures;
    }
	
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((Demon)p_110775_1_);
    }

}
