package FaithCraft2.Common.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.dimension.heaven.TeleporterHeaven;
import FaithCraft2.Common.common.tileEntity.TileEntityHeavenPortal;

public class HeavenPortal extends BlockContainer{
	
	private final String name = "HeavenPortal";
	public static boolean bottom = false;
	
	public HeavenPortal() {
		super(Material.portal);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    
    public int quantityDropped(Random random)
    {
        return 0;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        float f = 0.0625F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.DOWN ? super.shouldSideBeRendered(worldIn, pos, side) : false;
    }
	
	public static void makePortal(World world, Entity entityIn){
		world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()), FaithCraftBlocks.HeavenPortal.getDefaultState());
		world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1), FaithCraftBlocks.HeavenPortal.getDefaultState());
		if (bottom = true){
			world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()-1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()+1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()-1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()+1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()-1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY()-1,entityIn.getPosition().getZ()+1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1), FaithCraftBlocks.HolyBlock.getDefaultState());
			world.setBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2), FaithCraftBlocks.HolyBlock.getDefaultState());
		}
	}

	public static boolean makePortalBottom(){
		return bottom;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityHeavenPortal();
	}
	
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		for (int i=pos.getX()-2;i<pos.getX()+2;i++){
			for (int k=pos.getZ()-2;k<pos.getZ()+2;k++){
				if (worldIn.getBlockState(new BlockPos(i,pos.getY(),k)).getBlock() == FaithCraftBlocks.HeavenPortal){
					worldIn.setBlockToAir(new BlockPos(i,pos.getY(),k));
				}
			}
		}
	}
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityPlayerMP){
			EntityPlayerMP player = (EntityPlayerMP) entityIn;
			if (player.timeUntilPortal > 0)
			{
				player.timeUntilPortal = 10;
			}
			else if (worldIn.provider.getDimensionId() != FaithCraft2.HeavenId){
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, FaithCraft2.HeavenId, new TeleporterHeaven(player.mcServer.worldServerForDimension(FaithCraft2.HeavenId)));
			}else{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterHeaven(player.mcServer.worldServerForDimension(1)));
			}
		}
	}
}