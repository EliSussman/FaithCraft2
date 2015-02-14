/*package FaithCraft2.Common.common.blockmodels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAltar extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape31;
    ModelRenderer Shape11;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
  
  public ModelAltar()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 14, 1, 14);
      Shape1.setRotationPoint(-7F, 23F, -7F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 19);
      Shape2.addBox(0F, 0F, 0F, 6, 1, 7);
      Shape2.setRotationPoint(-3F, 22F, -3F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 28, 19);
      Shape3.addBox(0F, 0F, 0F, 4, 1, 3);
      Shape3.setRotationPoint(-2F, 21F, -1F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 28);
      Shape4.addBox(0F, 0F, 0F, 2, 9, 1);
      Shape4.setRotationPoint(-1F, 12F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape31 = new ModelRenderer(this, 8, 28);
      Shape31.addBox(0F, 0F, 0F, 4, 1, 3);
      Shape31.setRotationPoint(-2F, 11F, -1F);
      Shape31.setTextureSize(64, 64);
      Shape31.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 39);
      Shape11.addBox(0F, 0F, 0F, 15, 1, 15);
      Shape11.setRotationPoint(-8F, 10F, -8F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 28, 26);
      Shape5.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape5.setRotationPoint(-8F, 9F, 5F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 30, 30);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(6F, 8F, 6F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 45, 31);
      Shape7.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape7.setRotationPoint(-8F, 8F, 6F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 42, 26);
      Shape8.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape8.setRotationPoint(5F, 9F, 5F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape31.render(f5);
    Shape11.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
  }
  
  public void renderModel(float f){
	  	Shape1.render(f);
	    Shape2.render(f);
	    Shape3.render(f);
	    Shape4.render(f);
	    Shape31.render(f);
	    Shape11.render(f);
	    Shape5.render(f);
	    Shape6.render(f);
	    Shape7.render(f);
	    Shape8.render(f);
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