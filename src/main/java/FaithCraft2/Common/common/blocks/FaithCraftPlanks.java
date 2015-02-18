package FaithCraft2.Common.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;

public class FaithCraftPlanks extends Block{

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", FaithCraftPlanks.EnumType.class);
	
	public FaithCraftPlanks() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, FaithCraftPlanks.EnumType.DOGWOOD));
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
	}
	
	 public int damageDropped(IBlockState state)
	    {
	        return ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata();
	    }

	    @SideOnly(Side.CLIENT)
	    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	    {
	    	FaithCraftPlanks.EnumType[] aenumtype = FaithCraftPlanks.EnumType.values();
	        int i = aenumtype.length;

	        for (int j = 0; j < i; ++j)
	        {
	        	FaithCraftPlanks.EnumType enumtype = aenumtype[j];
	            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
	        }
	    }

	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(VARIANT, FaithCraftPlanks.EnumType.byMetadata(meta));
	    }

	    public int getMetaFromState(IBlockState state)
	    {
	        return ((FaithCraftPlanks.EnumType)state.getValue(VARIANT)).getMetadata();
	    }

	    protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {VARIANT});
	    }

	    public static enum EnumType implements IStringSerializable
	    {
	        DOGWOOD(0, "dogwood");
	        private static final FaithCraftPlanks.EnumType[] META_LOOKUP = new FaithCraftPlanks.EnumType[values().length];
	        private final int meta;
	        private final String name;
	        private final String unlocalizedName;

	        private EnumType(int meta, String name)
	        {
	            this(meta, name, name);
	        }

	        private EnumType(int meta, String name, String unlocalizedName)
	        {
	            this.meta = meta;
	            this.name = name;
	            this.unlocalizedName = unlocalizedName;
	        }

	        public int getMetadata()
	        {
	            return this.meta;
	        }

	        public String toString()
	        {
	            return this.name;
	        }

	        public static FaithCraftPlanks.EnumType byMetadata(int meta)
	        {
	            if (meta < 0 || meta >= META_LOOKUP.length)
	            {
	                meta = 0;
	            }

	            return META_LOOKUP[meta];
	        }

	        public String getName()
	        {
	            return this.name;
	        }

	        public String getUnlocalizedName()
	        {
	            return this.unlocalizedName;
	        }

	        static
	        {
	        	FaithCraftPlanks.EnumType[] var0 = values();
	            int var1 = var0.length;

	            for (int var2 = 0; var2 < var1; ++var2)
	            {
	            	FaithCraftPlanks.EnumType var3 = var0[var2];
	                META_LOOKUP[var3.getMetadata()] = var3;
	            }
	        }
	    }
	
}
