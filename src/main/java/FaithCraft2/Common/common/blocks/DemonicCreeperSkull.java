package FaithCraft2.Common.common.blocks;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.entity.Demon;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;

public class DemonicCreeperSkull extends BlockContainer{
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool NODROP = PropertyBool.create("nodrop");

    private static BlockPattern demonPattern;
    
    private final String name = "DemonicCreeperSkull";

    public DemonicCreeperSkull()
    {
        super(Material.circuits);
        setUnlocalizedName(FaithCraft2.modid + ":" + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(NODROP, Boolean.valueOf(false)));
        this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
    }

    public String getName(){
    	return this.name;
    }
    
    protected static BlockPattern getDemonPattern()
    {
        if (DemonicCreeperSkull.demonPattern == null)
        {
        	DemonicCreeperSkull.demonPattern = FactoryBlockPattern.start().aisle(new String[] {"~^~", "~#~", "~#~"}).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(FaithCraftBlocks.HellRock))).where('^', BlockWorldState.hasState(BlockStateHelper.forBlock(FaithCraftBlocks.DemonicCreeperSkull))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }

        return DemonicCreeperSkull.demonPattern;
    }
    
    public static void checkDemonSpawn(World worldIn, BlockPos pos, TileEntityDemonicCreeperSkull te)
    {
        if (pos.getY() >= 2 && worldIn.getDifficulty() != EnumDifficulty.PEACEFUL && !worldIn.isRemote)
        {
            BlockPattern blockpattern = DemonicCreeperSkull.getDemonPattern();
            BlockPattern.PatternHelper patternhelper = blockpattern.match(worldIn, pos);

            if (patternhelper != null)
            {
                int i;

                /*for (i = 0; i < 3; ++i)
                {
                    BlockWorldState blockworldstate = patternhelper.translateOffset(i, 0, 0);
                    worldIn.setBlockState(blockworldstate.getPos(), blockworldstate.getBlockState().withProperty(NODROP, Boolean.valueOf(true)), 2);
                }*/

                for (i = 0; i < blockpattern.getPalmLength(); ++i)
                {
                    for (int j = 0; j < blockpattern.getThumbLength(); ++j)
                    {
                        BlockWorldState blockworldstate1 = patternhelper.translateOffset(i, j, 0);
                        worldIn.setBlockState(blockworldstate1.getPos(), Blocks.air.getDefaultState(), 2);
                    }
                }

                BlockPos blockpos1 = patternhelper.translateOffset(1, 0, 0).getPos();
                Demon demon = new Demon(worldIn);
                BlockPos blockpos2 = patternhelper.translateOffset(1, 2, 0).getPos();
                demon.setLocationAndAngles((double)blockpos2.getX() + 0.5D, (double)blockpos2.getY() + 0.55D, (double)blockpos2.getZ() + 0.5D, patternhelper.getFinger().getAxis() == EnumFacing.Axis.X ? 0.0F : 90.0F, 0.0F);
                demon.renderYawOffset = patternhelper.getFinger().getAxis() == EnumFacing.Axis.X ? 0.0F : 90.0F;
                Iterator iterator = worldIn.getEntitiesWithinAABB(EntityPlayer.class, demon.getEntityBoundingBox().expand(50.0D, 50.0D, 50.0D)).iterator();

                /*while (iterator.hasNext())
                {
                    EntityPlayer entityplayer = (EntityPlayer)iterator.next();
                    //entityplayer.triggerAchievement(AchievementList.spawnWither);
                }*/

                worldIn.spawnEntityInWorld(demon);
                int k;

                for (k = 0; k < 120; ++k)
                {
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)blockpos1.getX() + worldIn.rand.nextDouble(), (double)(blockpos1.getY() - 2) + worldIn.rand.nextDouble() * 3.9D, (double)blockpos1.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
                }

                for (k = 0; k < blockpattern.getPalmLength(); ++k)
                {
                    for (int l = 0; l < blockpattern.getThumbLength(); ++l)
                    {
                        BlockWorldState blockworldstate2 = patternhelper.translateOffset(k, l, 0);
                        worldIn.notifyNeighborsRespectDebug(blockworldstate2.getPos(), Blocks.air);
                    }
                }
            }
        }
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        switch (DemonicCreeperSkull.SwitchEnumFacing.FACING_LOOKUP[((EnumFacing)worldIn.getBlockState(pos).getValue(FACING)).ordinal()])
        {
            case 1:
            default:
                this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
                break;
            case 2:
                this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
                break;
            case 3:
                this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
                break;
            case 4:
                this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
                break;
            case 5:
                this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
        }
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setBlockBoundsBasedOnState(worldIn, pos);
        return super.getCollisionBoundingBox(worldIn, pos, state);
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing()).withProperty(NODROP, Boolean.valueOf(false));
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityDemonicCreeperSkull();
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return FaithCraft2.DemonicCreeperSkullItem;
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (player.capabilities.isCreativeMode)
        {
            state = state.withProperty(NODROP, Boolean.valueOf(true));
            worldIn.setBlockState(pos, state, 4);
        }
        this.dropBlockAsItem(worldIn, pos, state, 0);

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
    }
    public java.util.List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune)
    {
        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        {
            if (!((Boolean)state.getValue(NODROP)).booleanValue())
            {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntitySkull)
                {
                    TileEntitySkull tileentityskull = (TileEntitySkull)tileentity;
                    ItemStack itemstack = new ItemStack(Items.skull, 1, tileentityskull.getSkullType());

                    if (tileentityskull.getSkullType() == 3 && tileentityskull.getPlayerProfile() != null)
                    {
                        itemstack.setTagCompound(new NBTTagCompound());
                        NBTTagCompound nbttagcompound = new NBTTagCompound();
                        NBTUtil.writeGameProfile(nbttagcompound, tileentityskull.getPlayerProfile());
                        itemstack.getTagCompound().setTag("SkullOwner", nbttagcompound);
                    }

                    ret.add(itemstack);
                }
            }
        }
        return ret;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return FaithCraft2.DemonicCreeperSkullItem;
    }

    public boolean canDispenserPlace(World worldIn, BlockPos pos, ItemStack stack)
    {
        return stack.getMetadata() == 1 && pos.getY() >= 2 && worldIn.getDifficulty() != EnumDifficulty.PEACEFUL && !worldIn.isRemote;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(NODROP, Boolean.valueOf((meta & 8) > 0));
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((EnumFacing)state.getValue(FACING)).getIndex();

        if (((Boolean)state.getValue(NODROP)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, NODROP});
    }

    static final class SwitchEnumFacing
        {
            static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];

            static
            {
                try
                {
                    FACING_LOOKUP[EnumFacing.UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError var5)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 2;
                }
                catch (NoSuchFieldError var4)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 3;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 4;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 5;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
	
}