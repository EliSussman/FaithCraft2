/*package FaithCraft2.Common.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
		this.setHardness(1.0F);
		this.setLightLevel(1.5F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		hellRock = iconRegister.registerIcon(FaithCraft2.modid + ":" + "HellRock");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata) {
		return hellRock;
	}
	
	public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
    	Demon entityDemon = new Demon(world);
    	if(world.getBlock(x, y + 1, z) == this){
    		if(!world.isRemote){
    			entityDemon.setPositionAndRotation(x, y + 1, z, 0.0F, 0.0F);
        		world.setBlockToAir(x, y, z);
        		world.setBlockToAir(x, y + 1, z);
        		world.spawnEntityInWorld(entityDemon);
    		}
    	}
    	return false;
    }
	

}
*/