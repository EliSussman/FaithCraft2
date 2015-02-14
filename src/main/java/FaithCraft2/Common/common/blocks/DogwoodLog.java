/*package FaithCraft2.Common.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import FaithCraft2.Common.common.*;

public class DogwoodLog extends BlockLog{
	
	@SideOnly(Side.CLIENT)
    private IIcon dogwoodLogTop;
	@SideOnly(Side.CLIENT)
    private IIcon dogwoodLogSide;
	
	public DogwoodLog(int id, Material material){
		super();
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
        this.setHardness(3.0F);
        this.setStepSound(soundTypeWood);
	}
	
	public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
    
    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        byte b0 = 4;
        int i1 = b0 + 1;

        if (p_149749_1_.checkChunksExist(p_149749_2_ - i1, p_149749_3_ - i1, p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1, p_149749_4_ + i1))
        {
            for (int j1 = -b0; j1 <= b0; ++j1)
            {
                for (int k1 = -b0; k1 <= b0; ++k1)
                {
                    for (int l1 = -b0; l1 <= b0; ++l1)
                    {
                        Block block = p_149749_1_.getBlock(p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
                        if (block.isLeaves(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1))
                        {
                            block.beginLeavesDecay(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
    
    @Override
	public void registerBlockIcons(IIconRegister iconRegister){
    	this.dogwoodLogSide = iconRegister.registerIcon(FaithCraft2.modid + ":" + "DogwoodLogSide");
		this.dogwoodLogTop = iconRegister.registerIcon(FaithCraft2.modid + ":" + "DogwoodLogTop");
	}
    
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_)
    {
        return this.dogwoodLogSide;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.dogwoodLogTop;
    }
	
}
*/