package FaithCraft2.Common.common.blocks;

import java.util.Iterator;
import java.util.List;

import FaithCraft2.Common.common.FaithCraft2;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FaithCraftLog extends BlockRotatedPillar
{
	 public static final PropertyEnum LOG_AXIS = PropertyEnum.create("axis", FaithCraftLog.EnumAxis.class);
	 public static final PropertyEnum VARIANT = PropertyEnum.create("variant", FaithCraftPlanks.EnumType.class);
    
    public FaithCraftLog()
    {
    	super(Material.wood);
    	this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, FaithCraftLog.EnumAxis.Y).withProperty(VARIANT, FaithCraftPlanks.EnumType.DOGWOOD));
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, FaithCraftPlanks.EnumType.DOGWOOD.getMetadata()));
    }
    
    @Override public boolean canSustainLeaves(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }
    @Override public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, FaithCraftPlanks.EnumType.byMetadata((meta & 3) + 4));

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, FaithCraftLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, FaithCraftLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, FaithCraftLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, FaithCraftLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata();

        switch (FaithCraftLog.SwitchEnumAxis.AXIS_LOOKUP[((FaithCraftLog.EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
        {
            case 1:
                i |= 4;
                break;
            case 2:
                i |= 8;
                break;
            case 3:
                i |= 12;
        }

        return i;
    }

    public BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LOG_AXIS, VARIANT});
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata() - 4);
    }

    public int damageDropped(IBlockState state)
    {
        return ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata() - 4;
    }
    
    public static enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");
        private final String name;

        private EnumAxis(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public static FaithCraftLog.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (FaithCraftLog.SwitchEnumAxis.AXIS_LOOKUP[axis.ordinal()])
            {
                case 1:
                    return X;
                case 2:
                    return Y;
                case 3:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String getName()
        {
            return this.name;
        }
    }

    static final class SwitchEnumAxis
        {
            static final int[] AXIS_LOOKUP = new int[BlockLog.EnumAxis.values().length];

            static
            {
                try
                {
                    AXIS_LOOKUP[BlockLog.EnumAxis.X.ordinal()] = 1;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    AXIS_LOOKUP[BlockLog.EnumAxis.Z.ordinal()] = 2;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    AXIS_LOOKUP[BlockLog.EnumAxis.NONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
}