package FaithCraft2.Common.common.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.HolyBlock;
import net.minecraft.block.BlockLiquid;

public class WineBlock extends BlockFluidClassic{
	
	private final String name = "WineBlock";
	
    public WineBlock(Fluid fluid) {
    		super(fluid, Material.water);
            setUnlocalizedName(FaithCraft2.modid + ":" + name);
            this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
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
    
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing facing)
    {
    	int x = pos.getX();
    	int y = pos.getY();
    	int z = pos.getZ();
        return world.getBlockState(new BlockPos(x + -2, y + -1, z + -1)).getBlock().isFlammable(world, pos, facing);
    }
}