package FaithCraft2.Common.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2Tab;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Demon;

public class HellRock extends Block{

	private Demon demon;
	
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
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
	    boolean isShape = world.getBlock(x, y, z) == this &&
	    		world.getBlock(x, y + 1, z) == this;

	    if (isShape) {
	        Demon entity = new Demon(world);
	        entity.setPosition(x, y, z);
	        world.spawnEntityInWorld(entity);
	        world.setBlock(x, y, z, Blocks.air);
	        world.setBlock(x, y + 1, z, Blocks.air);
	    }
	}

}
