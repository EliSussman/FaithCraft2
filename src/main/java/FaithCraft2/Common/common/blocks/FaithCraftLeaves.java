package FaithCraft2.Common.common.blocks;

import java.util.List;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;

public class FaithCraftLeaves extends FaithCraftLeavesBase implements IShearable{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", FaithCraftPlanks.EnumType.class);

	public FaithCraftLeaves()
    {
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, FaithCraftPlanks.EnumType.DOGWOOD).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }
	
	 public BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {VARIANT, CHECK_DECAY, DECAYABLE});
	    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, this.getWoodType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata();

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }
    
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
        if (state.getValue(VARIANT) == FaithCraftPlanks.EnumType.DOGWOOD && worldIn.rand.nextInt(chance) == 0)
        {
            spawnAsEntity(worldIn, pos, new ItemStack(Items.apple, 1, 0));
        }
    }

    public int damageDropped(IBlockState state)
    {
        return ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    public int getDamageValue(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock().getMetaFromState(iblockstate) & 3;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
        list.add(new ItemStack(itemIn, 1, 1));
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata() - 4);
    }

    public FaithCraftPlanks.EnumType getWoodType(int meta)
    {
        return FaithCraftPlanks.EnumType.byMetadata((meta & 3) + 4);
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
    {
        {
            super.harvestBlock(worldIn, player, pos, state, te);
        }
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.getBlockState(pos);
        return new java.util.ArrayList(java.util.Arrays.asList(new ItemStack(this, 1, ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata() - 4)));
    }

}
