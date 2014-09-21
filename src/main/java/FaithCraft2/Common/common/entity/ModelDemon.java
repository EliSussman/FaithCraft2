package FaithCraft2.Common.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDemon extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer HornLeft1;
    ModelRenderer HornLeft2;
    ModelRenderer HornLeft3;
    ModelRenderer HornLeft4;
    ModelRenderer HornRIght1;
    ModelRenderer HornRight2;
    ModelRenderer HornRIght3;
    ModelRenderer HornRight4;
  
  public ModelDemon()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 4F, 0F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 8, 4);
      body.setRotationPoint(0F, 4F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 6F, 0F);
      rightarm.setTextureSize(128, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -3F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 7F, 0F);
      leftarm.setTextureSize(128, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(128, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(128, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      HornLeft1 = new ModelRenderer(this, 34, 0);
      HornLeft1.addBox(0F, 0F, 0F, 4, 1, 1);
      HornLeft1.setRotationPoint(-8F, -2F, 0F);
      HornLeft1.setTextureSize(128, 64);
      HornLeft1.mirror = true;
      setRotation(HornLeft1, 0F, 0F, 0F);
      HornLeft2 = new ModelRenderer(this, 46, 0);
      HornLeft2.addBox(0F, 0F, 0F, 1, 5, 1);
      HornLeft2.setRotationPoint(-8F, -7F, 0F);
      HornLeft2.setTextureSize(128, 64);
      HornLeft2.mirror = true;
      setRotation(HornLeft2, 0F, 0F, 0F);
      HornLeft3 = new ModelRenderer(this, 52, 0);
      HornLeft3.addBox(0F, 0F, 0F, 3, 1, 1);
      HornLeft3.setRotationPoint(-8F, -7F, 0F);
      HornLeft3.setTextureSize(128, 64);
      HornLeft3.mirror = true;
      setRotation(HornLeft3, 0F, 0F, 0F);
      HornLeft4 = new ModelRenderer(this, 62, 0);
      HornLeft4.addBox(0F, 0F, 0F, 1, 2, 1);
      HornLeft4.setRotationPoint(-6F, -7F, 0F);
      HornLeft4.setTextureSize(128, 64);
      HornLeft4.mirror = true;
      setRotation(HornLeft4, 0F, 0F, 0F);
      HornRIght1 = new ModelRenderer(this, 33, 3);
      HornRIght1.addBox(0F, 0F, 0F, 4, 1, 1);
      HornRIght1.setRotationPoint(4F, -2F, 0F);
      HornRIght1.setTextureSize(128, 64);
      HornRIght1.mirror = true;
      setRotation(HornRIght1, 0F, 0F, 0F);
      HornRight2 = new ModelRenderer(this, 35, 7);
      HornRight2.addBox(0F, 0F, 0F, 1, 6, 1);
      HornRight2.setRotationPoint(7F, -7F, 0F);
      HornRight2.setTextureSize(128, 64);
      HornRight2.mirror = true;
      setRotation(HornRight2, 0F, 0F, 0F);
      HornRIght3 = new ModelRenderer(this, 43, 8);
      HornRIght3.addBox(0F, 0F, 0F, 3, 1, 1);
      HornRIght3.setRotationPoint(5F, -7F, 0F);
      HornRIght3.setTextureSize(128, 64);
      HornRIght3.mirror = true;
      setRotation(HornRIght3, 0F, 0F, 0F);
      HornRight4 = new ModelRenderer(this, 45, 11);
      HornRight4.addBox(0F, 0F, 0F, 1, 2, 1);
      HornRight4.setRotationPoint(5F, -7F, 0F);
      HornRight4.setTextureSize(128, 64);
      HornRight4.mirror = true;
      setRotation(HornRight4, 0F, 0F, 0F);
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
    HornLeft1.render(f5);
    HornLeft2.render(f5);
    HornLeft3.render(f5);
    HornLeft4.render(f5);
    HornRIght1.render(f5);
    HornRight2.render(f5);
    HornRIght3.render(f5);
    HornRight4.render(f5);
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
