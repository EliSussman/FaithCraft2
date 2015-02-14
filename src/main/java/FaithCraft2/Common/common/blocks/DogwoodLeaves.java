/*package FaithCraft2.Common.common.blocks;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.worldgen.ColorizeLeaves;

public class DogwoodLeaves extends BlockLeaves implements IShearable{

	@SideOnly(Side.CLIENT)
    private IIcon dogwoodLeaves;
	
	public DogwoodLeaves(int id) {
		super();
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		dogwoodLeaves = iconRegister.registerIcon(FaithCraft2.modid + ":" + "DogwoodLeaves");
	}

	@Override
	public int getRenderColor(int par1){
		return ColorizeLeaves.getFoliageColorHeaven();
	}
	
	@Override
    public int getBlockColor()
    {
		double d0 = 0.5D;
        double d1 = 1.0D;
		return ColorizeLeaves.getFoliageColorHeaven();
    }
	
	@Override
    public boolean isLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
	
	@Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
	
	@Override
	public IIcon getIcon(int side, int metadata) {
		return dogwoodLeaves;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
	return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
	return false;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world,
			int x, int y, int z, int fortune) {
		return null;
	}

	@Override
	public String[] func_150125_e() {
		return null;
	}
	
	 
	
}
*/