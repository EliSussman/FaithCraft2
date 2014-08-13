package FaithCraft2.Common.common.dimension;

import java.util.List;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import FaithCraft2.Common.common.FaithCraft2;

public class HeavenPortal extends BlockBreakable
{
	public int timeUntilPortal;
	public boolean inPortal;
	protected int teleportDirection;
	
    public HeavenPortal(int id, Material material)
    {
        super("HeavenPortal", material, true);
        this.setBlockName("HeavenPortal");
        setCreativeTab(FaithCraft2.FaithCraft2Tab);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    
    public static int func_149999_b(int p_149999_0_)
    {
        return p_149999_0_ & 3;
    }
    
    public int getPortalCooldown()
    {
        return 300;
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {	
    	double par2 = 0;
    	double par4 = 0;
    	double par6 = 0;
    	float par8 = 0;
    	if (entity instanceof EntityPlayerMP)  {
    	EntityPlayerMP	EMPlayer = (EntityPlayerMP) entity;
    	int dimensionHeaven = FaithCraft2.HeavenId;
        WorldServer worldserver = EMPlayer.mcServer.worldServerForDimension(dimensionHeaven);
    	TeleporterHeaven teleporterHeaven = new TeleporterHeaven (worldserver);
    	
    	if(world.provider.dimensionId == 0){
    		
    		EMPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(EMPlayer, dimensionHeaven, teleporterHeaven);
    		entity.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
    		(teleporterHeaven).placeInExistingPortal(entity, par2, par4, par6, par8);
    		
    	}else if(world.provider.dimensionId == FaithCraft2.HeavenId){
    		int dimension = 0;
    		EMPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(EMPlayer, dimension, teleporterHeaven);
    		entity.setLocationAndAngles(x + 3, y, z + 3, entity.rotationYaw, entity.rotationPitch);
    		(teleporterHeaven).placeInPortal(entity, par2, par4, par6, par8);
    	}
    	}
    	
    }
    	
    
    
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        int l = func_149999_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));

        if (l == 0)
        {
            if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) != this && p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) != this)
            {
                l = 2;
            }
            else
            {
                l = 1;
            }

            if (p_149719_1_ instanceof World && !((World)p_149719_1_).isRemote)
            {
                ((World)p_149719_1_).setBlockMetadataWithNotify(p_149719_2_, p_149719_3_, p_149719_4_, l, 2);
            }
        }

        float f = 0.125F;
        float f1 = 0.125F;

        if (l == 1)
        {
            f = 0.5F;
        }

        if (l == 2)
        {
            f1 = 0.5F;
        }

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		blockIcon = par1IconRegister.registerIcon(FaithCraft2.modid + ":" + "HeavenPortal");
	} 
}