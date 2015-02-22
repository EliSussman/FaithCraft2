package FaithCraft2.Common.common.items;

import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.blocks.DemonicCreeperSkull;
import FaithCraft2.Common.common.tileEntity.TileEntityDemonicCreeperSkull;

import com.mojang.authlib.GameProfile;

public class DemonicCreeperSkullItem extends Item{
	private final String name = "DemonicCreeperSkullItem";
	
	public DemonicCreeperSkullItem()
    {
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
        this.setMaxDamage(0);
    }
	
	public String getName(){
		return name;
	}

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && side != EnumFacing.DOWN)
        {
            side = EnumFacing.UP;
            pos = pos.down();
        }
        if (side == EnumFacing.DOWN)
        {
            return false;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            boolean flag = block.isReplaceable(worldIn, pos);

            if (!flag)
            {
                if (!worldIn.isSideSolid(pos, side, true))
                {
                    return false;
                }

                pos = pos.offset(side);
            }

            if (!playerIn.canPlayerEdit(pos, side, stack))
            {
                return false;
            }
            else if (!FaithCraft2.DemonicCreeperSkull.canPlaceBlockAt(worldIn, pos))
            {
                return false;
            }
            else
            {
                if (!worldIn.isRemote)
                {
                    if (!FaithCraft2.DemonicCreeperSkull.canPlaceBlockOnSide(worldIn, pos, side)) return false;
                    worldIn.setBlockState(pos, FaithCraft2.DemonicCreeperSkull.getDefaultState().withProperty(DemonicCreeperSkull.FACING, side), 3);
                    int i = 0;

                    if (side == EnumFacing.UP)
                    {
                        i = MathHelper.floor_double((double)(playerIn.rotationYaw * 16.0F / 360.0F) + 0.5D) & 15;
                    }

                    TileEntityDemonicCreeperSkull tileentity = (TileEntityDemonicCreeperSkull) worldIn.getTileEntity(pos);

                    if (tileentity instanceof TileEntityDemonicCreeperSkull)
                    {
                    	TileEntityDemonicCreeperSkull tileentityskull = (TileEntityDemonicCreeperSkull)tileentity;

                        if (stack.getMetadata() == 3)
                        {
                            GameProfile gameprofile = null;

                            if (stack.hasTagCompound())
                            {
                                NBTTagCompound nbttagcompound = stack.getTagCompound();

                                if (nbttagcompound.hasKey("SkullOwner", 10))
                                {
                                    gameprofile = NBTUtil.readGameProfileFromNBT(nbttagcompound.getCompoundTag("SkullOwner"));
                                }
                                else if (nbttagcompound.hasKey("SkullOwner", 8) && nbttagcompound.getString("SkullOwner").length() > 0)
                                {
                                    gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
                                }
                            }

                            tileentityskull.setPlayerProfile(gameprofile);
                        }
                        else
                        {
                            tileentityskull.setType(stack.getMetadata());
                        }

                        tileentityskull.setSkullRotation(i);
                        DemonicCreeperSkull.checkDemonSpawn(worldIn, pos, tileentityskull);
                    }

                    --stack.stackSize;
                }

                return true;
            }
        }
    }

    public int getMetadata(int damage)
    {
        return damage;
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return "Demonic Creeper Skull";
    }

    public boolean updateItemStackNBT(NBTTagCompound nbt)
    {
        super.updateItemStackNBT(nbt);

        if (nbt.hasKey("SkullOwner", 8) && nbt.getString("SkullOwner").length() > 0)
        {
            GameProfile gameprofile = new GameProfile((UUID)null, nbt.getString("SkullOwner"));
            gameprofile = TileEntityDemonicCreeperSkull.updateGameprofile(gameprofile);
            nbt.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), gameprofile));
            return true;
        }
        else
        {
            return false;
        }
    }
}
