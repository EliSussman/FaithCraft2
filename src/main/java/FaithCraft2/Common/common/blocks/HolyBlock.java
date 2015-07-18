package FaithCraft2.Common.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyBlock extends Block{
	
	private final String name = "HolyBlock";
	
	public HolyBlock(int i, Material material) {
		super(material);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(6F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
	}
	
	public String getName(){
		return name;
	}
	
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		for (int i=pos.getX()-4;i<pos.getX()+4;i++){
			for (int k=pos.getZ()-4;k<pos.getZ()+4;k++){
				if (worldIn.getBlockState(new BlockPos(i,pos.getY(),k)).getBlock() == FaithCraftBlocks.HeavenPortal){
					worldIn.setBlockToAir(new BlockPos(i,pos.getY(),k));
				}
			}
		}
	}
	
}