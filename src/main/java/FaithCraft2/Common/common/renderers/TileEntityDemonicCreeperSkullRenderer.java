package FaithCraft2.Common.common.renderers;

import java.util.Map;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

@SideOnly(Side.CLIENT)
public class TileEntityDemonicCreeperSkullRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("faithcraft2:textures/entity/DemonicCreeper.png");
    public static TileEntityDemonicCreeperSkullRenderer instance;
    private ModelSkeletonHead skeletonHead = new ModelSkeletonHead(0, 0, 64, 64);
    
    public void renderTileEntityDemonicCreeperSkull(TileEntityDemonicCreeperSkull p_180542_1_, double p_180542_2_, double p_180542_4_, double p_180542_6_, float p_180542_8_, int p_180542_9_)
    {
        EnumFacing enumfacing = EnumFacing.getFront(p_180542_1_.getBlockMetadata() & 7);
        this.renderSkull((float)p_180542_2_, (float)p_180542_4_, (float)p_180542_6_, enumfacing, (float)(p_180542_1_.getSkullRotation() * 360) / 16.0F, p_180542_1_.getSkullType(), p_180542_1_.getPlayerProfile(), p_180542_9_);
    }

    public void setRendererDispatcher(TileEntityRendererDispatcher p_147497_1_)
    {
        super.setRendererDispatcher(p_147497_1_);
        instance = this;
    }

    public void renderSkull(float p_180543_1_, float p_180543_2_, float p_180543_3_, EnumFacing p_180543_4_, float p_180543_5_, int p_180543_6_, GameProfile p_180543_7_, int p_180543_8_)
    {
        ModelSkeletonHead modelskeletonhead = this.skeletonHead;

        if (p_180543_8_ >= 0)
        {
            this.bindTexture(DESTROY_STAGES[p_180543_8_]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 2.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            switch (p_180543_6_)
            {
                case 0:
                default:
                    this.bindTexture(TEXTURE);
                    break;
            }
        }

        GlStateManager.pushMatrix();
        GlStateManager.disableCull();

        if (p_180543_4_ != EnumFacing.UP)
        {
            switch (TileEntityDemonicCreeperSkullRenderer.SwitchEnumFacing.field_178458_a[p_180543_4_.ordinal()])
            {
                case 1:
                    GlStateManager.translate(p_180543_1_ + 0.5F, p_180543_2_ + 0.25F, p_180543_3_ + 0.74F);
                    break;
                case 2:
                    GlStateManager.translate(p_180543_1_ + 0.5F, p_180543_2_ + 0.25F, p_180543_3_ + 0.26F);
                    p_180543_5_ = 180.0F;
                    break;
                case 3:
                    GlStateManager.translate(p_180543_1_ + 0.74F, p_180543_2_ + 0.25F, p_180543_3_ + 0.5F);
                    p_180543_5_ = 270.0F;
                    break;
                case 4:
                default:
                    GlStateManager.translate(p_180543_1_ + 0.26F, p_180543_2_ + 0.25F, p_180543_3_ + 0.5F);
                    p_180543_5_ = 90.0F;
            }
        }
        else
        {
            GlStateManager.translate(p_180543_1_ + 0.5F, p_180543_2_, p_180543_3_ + 0.5F);
        }

        float f4 = 0.0625F;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        GlStateManager.enableAlpha();
        modelskeletonhead.render((Entity)null, 0.0F, 0.0F, 0.0F, p_180543_5_, 0.0F, f4);
        GlStateManager.popMatrix();

        if (p_180543_8_ >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }

    public void renderTileEntityAt(TileEntity p_180535_1_, double posX, double posZ, double p_180535_6_, float p_180535_8_, int p_180535_9_)
    {
        this.renderTileEntityDemonicCreeperSkull((TileEntityDemonicCreeperSkull)p_180535_1_, posX, posZ, p_180535_6_, p_180535_8_, p_180535_9_);
    }

    @SideOnly(Side.CLIENT)

    static final class SwitchEnumFacing
        {
            static final int[] field_178458_a = new int[EnumFacing.values().length];

            static
            {
                try
                {
                    field_178458_a[EnumFacing.NORTH.ordinal()] = 1;
                }
                catch (NoSuchFieldError var4)
                {
                    ;
                }

                try
                {
                    field_178458_a[EnumFacing.SOUTH.ordinal()] = 2;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    field_178458_a[EnumFacing.WEST.ordinal()] = 3;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    field_178458_a[EnumFacing.EAST.ordinal()] = 4;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
}