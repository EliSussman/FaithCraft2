/*package FaithCraft2.Common.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAngel extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Halo1;
    ModelRenderer Halo2;
    ModelRenderer Halo3;
    ModelRenderer Halo4;
    ModelRenderer wingLeft1;
    ModelRenderer wingRight1;
  
  public ModelAngel()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(128, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(128, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(128, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(128, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Halo1 = new ModelRenderer(this, 36, 0);
      Halo1.addBox(0F, 0F, 0F, 8, 1, 1);
      Halo1.setRotationPoint(-4F, -11F, 3F);
      Halo1.setTextureSize(128, 128);
      Halo1.mirror = true;
      setRotation(Halo1, 0F, 0F, 0F);
      Halo2 = new ModelRenderer(this, 60, 0);
      Halo2.addBox(0F, 0F, 0F, 1, 1, 8);
      Halo2.setRotationPoint(-4F, -11F, -4F);
      Halo2.setTextureSize(128, 128);
      Halo2.mirror = true;
      setRotation(Halo2, 0F, 0F, 0F);
      Halo3 = new ModelRenderer(this, 35, 8);
      Halo3.addBox(0F, 0F, 0F, 8, 1, 1);
      Halo3.setRotationPoint(-4F, -11F, -4F);
      Halo3.setTextureSize(128, 128);
      Halo3.mirror = true;
      setRotation(Halo3, 0F, 0F, 0F);
      Halo4 = new ModelRenderer(this, 59, 12);
      Halo4.addBox(0F, 0F, 0F, 1, 1, 8);
      Halo4.setRotationPoint(3F, -11F, -4F);
      Halo4.setTextureSize(128, 128);
      Halo4.mirror = true;
      setRotation(Halo4, 0F, 0F, 0F);
      wingLeft1 = new ModelRenderer(this, 85, 0);
      wingLeft1.addBox(0F, 0F, 0F, 11, 14, 0);
      wingLeft1.setRotationPoint(-11F, -2F, 2F);
      wingLeft1.setTextureSize(128, 128);
      wingLeft1.mirror = true;
      setRotation(wingLeft1, 0.0349066F, 0F, 0.2268928F);
      wingRight1 = new ModelRenderer(this, 83, 20);
      wingRight1.addBox(0F, 0F, 0F, 11, 14, 0);
      wingRight1.setRotationPoint(0F, 0.5F, 2F);
      wingRight1.setTextureSize(128, 128);
      wingRight1.mirror = true;
      setRotation(wingRight1, 0.0349066F, 0F, -0.2268928F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Halo1.render(f5);
    Halo2.render(f5);
    Halo3.render(f5);
    Halo4.render(f5);
    wingLeft1.render(f5);
    wingRight1.render(f5);
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
*/