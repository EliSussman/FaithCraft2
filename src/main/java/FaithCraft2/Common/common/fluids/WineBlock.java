package FaithCraft2.Common.common.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;
import FaithCraft2.Common.common.blocks.HeavenPortal;
import FaithCraft2.Common.common.blocks.HolyController;

public class WineBlock extends BlockFluidClassic{
	
	public final static String name = "WineBlock";
	public static final WineBlock instance = new WineBlock(FaithCraftBlocks.Wine, Material.water);
	HolyController holyController = new HolyController(Material.iron);
	public boolean staffInForge = false;
	
    public WineBlock(Fluid fluid, Material material) {
    		super(fluid, material);
            setUnlocalizedName(FaithCraft2.modid + ":" + name);
            this.setDefaultState(blockState.getBaseState().withProperty(LEVEL, 0));
    }
    
    @Override
	public Fluid getFluid()
	{
		return FaithCraftBlocks.Wine;
	}
    
    @Override
    protected void flowIntoBlock(World world, BlockPos pos, int meta)
    {
        if (meta < 0) return;
        if (displaceIfPossible(world, pos))
        {
           world.setBlockState(pos, this.getBlockState().getBaseState().withProperty(LEVEL, meta), 3);
        }
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
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn){
    	if (entityIn instanceof EntityItem){
    		EntityItem eItem = (EntityItem) entityIn;
    		if (eItem.getEntityItem().getItem() == new ItemStack(FaithCraftBlocks.HolyOre).getItem()){
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()+2, new ItemStack(FaithCraft2.HolyIngot));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()-2, new ItemStack(FaithCraft2.HolyIngot));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX()+2, (double)pos.getY(), (double)pos.getZ(), new ItemStack(FaithCraft2.HolyIngot));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX()-2, (double)pos.getY(), (double)pos.getZ(), new ItemStack(FaithCraft2.HolyIngot));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    		}
    		if (eItem.getEntityItem().getItem() == new ItemStack(FaithCraft2.HolyStaffOFPower).getItem()){
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()+2, new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL1));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()-2, new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL1));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX()+2, (double)pos.getY(), (double)pos.getZ(), new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL1));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX()-2, (double)pos.getY(), (double)pos.getZ(), new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL1));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    				}
    			}
    		}
    		if (eItem.getEntityItem().getItem() == FaithCraft2.HolyStaffOFPower_LEVEL2){
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					staffInForge = true;
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					staffInForge = true;
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					staffInForge = true;
    					eItem.setDead();
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					staffInForge = true;
    					eItem.setDead();
    				}
    			}
    		}
    		if (eItem.getEntityItem().getItem() == Items.diamond && staffInForge == true){
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()+2, new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL3));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    					staffInForge = false;
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()-2, new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL3));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    					staffInForge = false;
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX()+2, (double)pos.getY(), (double)pos.getZ(), new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL3));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    					staffInForge = false;
    				}
    			}
    			if (worldIn.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() == FaithCraftBlocks.HolyController){
    				if ((!worldIn.isRemote) && (holyController.isHolyForge == true)){
    					EntityItem dropItem = new EntityItem(worldIn, (double)pos.getX()-2, (double)pos.getY(), (double)pos.getZ(), new ItemStack(FaithCraft2.HolyStaffOFPower_LEVEL3));
    					worldIn.spawnEntityInWorld(dropItem);
    					eItem.setDead();
    					staffInForge = false;
    				}
    			}
    		}
    		if (eItem.getEntityItem().getItem() == FaithCraft2.HolyCross){
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraftBlocks.wineBlock)
    			if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraftBlocks.wineBlock){
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()-1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraftBlocks.HolyBlock)
    				if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX(),entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+1,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-2)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()-1)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ())).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+1)).getBlock() == FaithCraftBlocks.HolyBlock)
    	    		if (worldIn.getBlockState(new BlockPos(entityIn.getPosition().getX()+2,entityIn.getPosition().getY(),entityIn.getPosition().getZ()+2)).getBlock() == FaithCraftBlocks.HolyBlock){
    					HeavenPortal.makePortal(worldIn,eItem);
    					eItem.setDead();
    				}
    			}
    		}
    	}
    }
}