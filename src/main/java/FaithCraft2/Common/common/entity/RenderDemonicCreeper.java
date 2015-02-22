package FaithCraft2.Common.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDemonicCreeper extends RenderLiving{

	private static final ResourceLocation demonicCreeperTextures = new ResourceLocation("faithcraft2:textures/entity/DemonicCreeper.png");
	
	public RenderDemonicCreeper(RenderManager manager) {
		super(manager, new ModelDemonicCreeper(), 1.0F);
	}

	protected ResourceLocation getEntityTexture(DemonicCreeper demonicCreeper)
    {
        return demonicCreeperTextures;
    }
	
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((DemonicCreeper)p_110775_1_);
    }

}