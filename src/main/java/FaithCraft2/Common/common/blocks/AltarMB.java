package FaithCraft2.Common.common.blocks;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import FaithCraft2.Common.common.*;
import FaithCraft2.Common.common.tileEntity.TileEntityAltarMB;

public class AltarMB extends BlockContainer{
	
	public AltarMB(int id, Material material){
		super(material);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		TileEntityAltarMB tile = new TileEntityAltarMB();
		if(!tile.shouldRender){
			if(world.getBlock(x, y, z) == Blocks.stone
    			&& world.getBlock(x+1, y, z) == Blocks.stone
    			&& world.getBlock(x+2, y, z) == Blocks.stone
    			&& world.getBlock(x, y+1, z) == Blocks.stone
    			&& world.getBlock(x, y+2, z) == Blocks.stone
    			&& world.getBlock(x+1, y+1, z) == Blocks.stone
    			&& world.getBlock(x+1, y+2, z) == Blocks.stone
    			&& world.getBlock(x+2, y+1, z) == Blocks.stone
    			&& world.getBlock(x+2, y+2, z) == Blocks.stone){
				System.out.println("HelloEli");
	    		((TileEntityAltarMB)tile).shouldRender = true;
	    		world.setTileEntity(x, y, z, tile);
			}
		}
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAltarMB();
	}
}
