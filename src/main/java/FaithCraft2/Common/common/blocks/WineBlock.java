package FaithCraft2.Common.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;

public class WineBlock extends BlockFluidClassic{
	
	private final String name = "WineBlock";
	
    public WineBlock() {
    		super(FaithCraft2.Wine, Material.water);
            setUnlocalizedName(FaithCraft2.modid + ":" + name);
            this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
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
    public boolean displaceIfPossible(World world, BlockPos pos) {
            if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, pos);
    } 
    
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing facing)
    {
    	int x = pos.getX();
    	int y = pos.getY();
    	int z = pos.getZ();
        return world.getBlockState(new BlockPos(x + -2, y + -1, z + -1)).getBlock().isFlammable(world, pos, facing);
    }
        
}