package FaithCraft2.Common.common.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import FaithCraft2.Common.common.*;

public class DogwoodPlank extends Block{
	
	@SideOnly(Side.CLIENT)
    private IIcon dogwoodPlank;
	
	public DogwoodPlank(int id, Material material){
		super(material);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
		dogwoodPlank = iconRegister.registerIcon(FaithCraft2.modid + ":" + "DogwoodPlank");
    }
	
	@Override
	public IIcon getIcon(int side, int metadata) {
		return dogwoodPlank;
	}
}
