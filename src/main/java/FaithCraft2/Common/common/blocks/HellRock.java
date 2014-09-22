package FaithCraft2.Common.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import FaithCraft2.Common.common.*;

public class HellRock extends Block{

	private IIcon hellRock;
	
	public HellRock(int id, Material material) {
		super(material);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		hellRock = iconRegister.registerIcon(FaithCraft2.modid + ":" + "HellRock");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata) {
		return hellRock;
	}

}
