package FaithCraft2.Common.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDemonicCreeper extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer horn1;
    ModelRenderer horn1part2;
    ModelRenderer horn2;
    ModelRenderer horn2part2;
  
  public ModelDemonicCreeper()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 6F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 6F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-2F, 18F, -4F);
      leg3.setTextureSize(64, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(2F, 18F, -4F);
      leg4.setTextureSize(64, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(0F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-4F, 18F, 4F);
      leg1.setTextureSize(64, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(2F, 18F, 4F);
      leg2.setTextureSize(64, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      horn1 = new ModelRenderer(this, 6, 42);
      horn1.addBox(0F, 0F, 0F, 3, 1, 1);
      horn1.setRotationPoint(4F, -1F, 0F);
      horn1.setTextureSize(64, 64);
      horn1.mirror = true;
      setRotation(horn1, 0F, 0F, 0F);
      horn1part2 = new ModelRenderer(this, 0, 41);
      horn1part2.addBox(0F, 0F, 0F, 1, 4, 1);
      horn1part2.setRotationPoint(6F, -5F, 0F);
      horn1part2.setTextureSize(64, 64);
      horn1part2.mirror = true;
      setRotation(horn1part2, 0F, 0F, 0F);
      horn2 = new ModelRenderer(this, 6, 49);
      horn2.addBox(0F, 0F, 0F, 3, 1, 1);
      horn2.setRotationPoint(-7F, -1F, 0F);
      horn2.setTextureSize(64, 64);
      horn2.mirror = true;
      setRotation(horn2, 0F, 0F, 0F);
      horn2part2 = new ModelRenderer(this, 0, 0);
      horn2part2.addBox(0F, 0F, 0F, 1, 4, 1);
      horn2part2.setRotationPoint(-7F, -5F, 0F);
      horn2part2.setTextureSize(64, 64);
      horn2part2.mirror = true;
      setRotation(horn2part2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	super.render(entity, f, f1, f2, f3, f4, f5);
	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    horn1.render(f5);
    horn1part2.render(f5);
    horn2.render(f5);
    horn2part2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
