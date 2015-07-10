package FaithCraft2.Common.common.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.blocks.*;
import FaithCraft2.Common.common.items.*;
import FaithCraft2.Common.common.*;
import net.minecraft.block.BlockLiquid;

public class WineBlock extends BlockFluidClassic{
	
	public final static String name = "WineBlock";
	public static final WineBlock instance = new WineBlock(FaithCraft2.Wine, Material.water);
	
    public WineBlock(Fluid fluid, Material material) {
    		super(fluid, material);
            setUnlocalizedName(FaithCraft2.modid + ":" + name);
            this.setDefaultState(blockState.getBaseState().withProperty(LEVEL, 0));
    }
    
    @Override
	public Fluid getFluid()
	{
		return FaithCraft2.Wine;
	}
    
    @Override
    protected void flowIntoBlock(World world, BlockPos pos, int meta)
    {
        if (meta < 0) return;
        if (displaceIfPossible(world, pos))
        {
           world.setBlockState(pos, this.getBlockState().getBaseState().withProperty(LEVEL, meta), 3);
        }
    }
    
    public String getName(){
		return name;
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
            if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
            return super.canDisplace(world, pos);
    }
    
    
    
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn){
    	if (entityIn instanceof EntityItem){
    		EntityItem eItem = (EntityItem) entityIn;
    		if (eItem.getEntityItem().getItem() == FaithCraft2.HolyCross){
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraft2.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraft2.wineBlock){
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraft2.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraft2.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraft2.HolyBlock){
    					HeavenPortal.makePortal(worldIn,eItem);
    					eItem.setDead();
    				}
    			}
    		}
    	}
    }
}