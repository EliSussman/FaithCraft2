package FaithCraft2.Common.common.blocks;

import java.util.Random;

import FaithCraft2.Common.common.FaithCraft2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;

public class Altar extends BlockContainer{
	
	private final String name = "Altar";
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public Altar(Material material) {
		super(material);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(7F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote && isMultiBlockStructure(worldIn, pos.getX(), pos.getY(), pos.getZ())){
			playerIn.openGui(FaithCraft2.instance, FaithCraft2.guiIDAltar, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
		
	}
	
	public boolean isMultiBlockStructure(World world, int x, int y, int z) {
		if (checkNorth(world, x, y, z))
			return true;
		if (checkEast(world, x, y, z))
			return true;
		if (checkSouth(world, x, y, z))
			return true;
		if (checkWest(world, x, y, z))
			return true;
		return false;
	}
	
	private static boolean checkNorth(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + -2, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
			if (world.getBlockState(new BlockPos(x + -2, y + -1, z + 1)).getBlock() == FaithCraft2.HolyBlock) {
				if (world.getBlockState(new BlockPos(x + -2, y + -1, z + 0)).getBlock() == FaithCraft2.HolyBlock) {
					if (world.getBlockState(new BlockPos(x + -2, y + -1, z + -1)).getBlock() == FaithCraft2.HolyBlock) {
						if (world.getBlockState(new BlockPos(x + -2, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + -2, y + 0, z + 2)).getBlock() == Blocks.air) {
								if (world.getBlockState(new BlockPos(x + -2, y + 0, z + 1)).getBlock() == Blocks.air) {
									if (world.getBlockState(new BlockPos(x + -2, y + 0, z + 0)).getBlock() == Blocks.air) {
										if (world.getBlockState(new BlockPos(x + -2, y + 0, z
												+ -1)).getBlock() == Blocks.air) {
											if (world.getBlockState(new BlockPos(x + -2, y + 0,
													z + -2)).getBlock() == Blocks.air) {
												if (world.getBlockState(new BlockPos(x + -2,
														y + 1, z + 2)).getBlock() == Blocks.air) {
													if (world.getBlockState(new BlockPos(
															x + -2, y + 1,
															z + 1)).getBlock() == Blocks.air) {
														if (world.getBlockState(new BlockPos(x
																+ -2, y + 1,
																z + 0)).getBlock() == Blocks.air) {
															if (world
																	.getBlockState(new BlockPos(
																			x
																					+ -2,
																			y + 1,
																			z
																					+ -1)).getBlock() == Blocks.air) {
																if (world
																		.getBlockState(new BlockPos(
																				x
																						+ -2,
																				y + 1,
																				z
																						+ -2)).getBlock() == Blocks.air) {
																	if (world
																			.getBlockState(new BlockPos(
																					x
																							+ -2,
																					y + 2,
																					z + 2)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x
																								+ -2,
																						y + 2,
																						z + 1)).getBlock() == Blocks.air) {
																			if (world
																					.getBlockState(new BlockPos(
																							x
																									+ -2,
																							y + 2,
																							z + 0)).getBlock() == Blocks.air) {
																				if (world
																						.getBlockState(new BlockPos(
																								x
																										+ -2,
																								y + 2,
																								z
																										+ -1)).getBlock() == Blocks.air) {
																					if (world
																							.getBlockState(new BlockPos(
																									x
																											+ -2,
																									y + 2,
																									z
																											+ -2)).getBlock() == Blocks.air) {
																						if (world
																								.getBlockState(new BlockPos(
																										x
																												+ -2,
																										y + 3,
																										z + 2)).getBlock() == Blocks.air) {
																							if (world
																									.getBlockState(new BlockPos(
																											x
																													+ -2,
																											y + 3,
																											z + 1)).getBlock() == Blocks.air) {
																								if (world
																										.getBlockState(new BlockPos(
																												x
																														+ -2,
																												y + 3,
																												z + 0)).getBlock() == Blocks.air) {
																									if (world
																											.getBlockState(new BlockPos(
																													x
																															+ -2,
																													y + 3,
																													z
																															+ -1)).getBlock() == Blocks.air) {
																										if (world
																												.getBlockState(new BlockPos(
																														x
																																+ -2,
																														y + 3,
																														z
																																+ -2)).getBlock() == Blocks.air) {
																											if (world
																													.getBlockState(new BlockPos(
																															x
																																	+ -1,
																															y
																																	+ -1,
																															z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlockState(new BlockPos(
																																x
																																		+ -1,
																																y
																																		+ -1,
																																z + 1)).getBlock() == FaithCraft2.wineBlock) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x
																																			+ -1,
																																	y
																																			+ -1,
																																	z + 0)).getBlock() == FaithCraft2.wineBlock) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x
																																				+ -1,
																																		y
																																				+ -1,
																																		z
																																				+ -1)).getBlock() == FaithCraft2.wineBlock) {
																															if (world
																																	.getBlockState(new BlockPos(
																																			x
																																					+ -1,
																																			y
																																					+ -1,
																																			z
																																					+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlockState(new BlockPos(
																																				x
																																						+ -1,
																																				y + 0,
																																				z + 2)).getBlock() == Blocks.air) {
																																	if (world
																																			.getBlockState(new BlockPos(
																																					x
																																							+ -1,
																																					y + 0,
																																					z + 1)).getBlock() == Blocks.air) {
																																		if (world
																																				.getBlockState(new BlockPos(
																																						x
																																								+ -1,
																																						y + 0,
																																						z + 0)).getBlock() == Blocks.air) {
																																			if (world
																																					.getBlockState(new BlockPos(
																																							x
																																									+ -1,
																																							y + 0,
																																							z
																																									+ -1)).getBlock() == Blocks.air) {
																																				if (world
																																						.getBlockState(new BlockPos(
																																								x
																																										+ -1,
																																								y + 0,
																																								z
																																										+ -2)).getBlock() == Blocks.air) {
																																					if (world
																																							.getBlockState(new BlockPos(
																																									x
																																											+ -1,
																																									y + 1,
																																									z + 2)).getBlock() == Blocks.air) {
																																						if (world
																																								.getBlockState(new BlockPos(
																																										x
																																												+ -1,
																																										y + 1,
																																										z + 1)).getBlock() == Blocks.air) {
																																							if (world
																																									.getBlockState(new BlockPos(
																																											x
																																													+ -1,
																																											y + 1,
																																											z + 0)).getBlock() == Blocks.air) {
																																								if (world
																																										.getBlockState(new BlockPos(
																																												x
																																														+ -1,
																																												y + 1,
																																												z
																																														+ -1)).getBlock() == Blocks.air) {
																																									if (world
																																											.getBlockState(new BlockPos(
																																													x
																																															+ -1,
																																													y + 1,
																																													z
																																															+ -2)).getBlock() == Blocks.air) {
																																										if (world
																																												.getBlockState(new BlockPos(
																																														x
																																																+ -1,
																																														y + 2,
																																														z + 2)).getBlock() == Blocks.air) {
																																											if (world
																																													.getBlockState(new BlockPos(
																																															x
																																																	+ -1,
																																															y + 2,
																																															z + 1)).getBlock() == Blocks.air) {
																																												if (world
																																														.getBlockState(new BlockPos(
																																																x
																																																		+ -1,
																																																y + 2,
																																																z + 0)).getBlock() == Blocks.air) {
																																													if (world
																																															.getBlockState(new BlockPos(
																																																	x
																																																			+ -1,
																																																	y + 2,
																																																	z
																																																			+ -1)).getBlock() == Blocks.air) {
																																														if (world
																																																.getBlockState(new BlockPos(
																																																		x
																																																				+ -1,
																																																		y + 2,
																																																		z
																																																				+ -2)).getBlock() == Blocks.air) {
																																															if (world
																																																	.getBlockState(new BlockPos(
																																																			x
																																																					+ -1,
																																																			y + 3,
																																																			z + 2)).getBlock() == Blocks.air) {
																																																if (world
																																																		.getBlockState(new BlockPos(
																																																				x
																																																						+ -1,
																																																				y + 3,
																																																				z + 1)).getBlock() == Blocks.air) {
																																																	if (world
																																																			.getBlockState(new BlockPos(
																																																					x
																																																							+ -1,
																																																					y + 3,
																																																					z + 0)).getBlock() == Blocks.air) {
																																																		if (world
																																																				.getBlockState(new BlockPos(
																																																						x
																																																								+ -1,
																																																						y + 3,
																																																						z
																																																								+ -1)).getBlock() == Blocks.air) {
																																																			if (world
																																																					.getBlockState(new BlockPos(
																																																							x
																																																									+ -1,
																																																							y + 3,
																																																							z
																																																									+ -2)).getBlock() == Blocks.air) {
																																																				if (world
																																																						.getBlockState(new BlockPos(
																																																								x + 0,
																																																								y
																																																										+ -1,
																																																								z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlockState(new BlockPos(
																																																									x + 0,
																																																									y
																																																											+ -1,
																																																									z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																						if (world
																																																								.getBlockState(new BlockPos(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlockState(new BlockPos(
																																																											x + 0,
																																																											y
																																																													+ -1,
																																																											z
																																																													+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																								if (world
																																																										.getBlockState(new BlockPos(
																																																												x + 0,
																																																												y
																																																														+ -1,
																																																												z
																																																														+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlockState(new BlockPos(
																																																													x + 0,
																																																													y + 0,
																																																													z + 2)).getBlock() == Blocks.air) {
																																																										if (world
																																																												.getBlockState(new BlockPos(
																																																														x + 0,
																																																														y + 0,
																																																														z + 1)).getBlock() == Blocks.air) {
																																																											if (world
																																																													.getBlockState(new BlockPos(
																																																															x + 0,
																																																															y + 0,
																																																															z
																																																																	+ -1)).getBlock() == Blocks.air) {
																																																												if (world
																																																														.getBlockState(new BlockPos(
																																																																x + 0,
																																																																y + 0,
																																																																z
																																																																		+ -2)).getBlock() == Blocks.air) {
																																																													if (world
																																																															.getBlockState(new BlockPos(
																																																																	x + 0,
																																																																	y + 1,
																																																																	z + 2)).getBlock() == Blocks.air) {
																																																														if (world
																																																																.getBlockState(new BlockPos(
																																																																		x + 0,
																																																																		y + 1,
																																																																		z + 1)).getBlock() == Blocks.air) {
																																																															if (world
																																																																	.getBlockState(new BlockPos(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0)).getBlock() == Blocks.air) {
																																																																if (world
																																																																		.getBlockState(new BlockPos(
																																																																				x + 0,
																																																																				y + 1,
																																																																				z
																																																																						+ -1)).getBlock() == Blocks.air) {
																																																																	if (world
																																																																			.getBlockState(new BlockPos(
																																																																					x + 0,
																																																																					y + 1,
																																																																					z
																																																																							+ -2)).getBlock() == Blocks.air) {
																																																																		if (world
																																																																				.getBlockState(new BlockPos(
																																																																						x + 0,
																																																																						y + 2,
																																																																						z + 2)).getBlock() == Blocks.air) {
																																																																			if (world
																																																																					.getBlockState(new BlockPos(
																																																																							x + 0,
																																																																							y + 2,
																																																																							z + 1)).getBlock() == Blocks.air) {
																																																																				if (world
																																																																						.getBlockState(new BlockPos(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0)).getBlock() == Blocks.air) {
																																																																					if (world
																																																																							.getBlockState(new BlockPos(
																																																																									x + 0,
																																																																									y + 2,
																																																																									z
																																																																											+ -1)).getBlock() == Blocks.air) {
																																																																						if (world
																																																																								.getBlockState(new BlockPos(
																																																																										x + 0,
																																																																										y + 2,
																																																																										z
																																																																												+ -2)).getBlock() == Blocks.air) {
																																																																							if (world
																																																																									.getBlockState(new BlockPos(
																																																																											x + 0,
																																																																											y + 3,
																																																																											z + 2)).getBlock() == Blocks.air) {
																																																																								if (world
																																																																										.getBlockState(new BlockPos(
																																																																												x + 0,
																																																																												y + 3,
																																																																												z + 1)).getBlock() == Blocks.air) {
																																																																									if (world
																																																																											.getBlockState(new BlockPos(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0)).getBlock() == Blocks.air) {
																																																																										if (world
																																																																												.getBlockState(new BlockPos(
																																																																														x + 0,
																																																																														y + 3,
																																																																														z
																																																																																+ -1)).getBlock() == Blocks.air) {
																																																																											if (world
																																																																													.getBlockState(new BlockPos(
																																																																															x + 0,
																																																																															y + 3,
																																																																															z
																																																																																	+ -2)).getBlock() == Blocks.air) {
																																																																												if (world
																																																																														.getBlockState(new BlockPos(
																																																																																x + 1,
																																																																																y
																																																																																		+ -1,
																																																																																z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlockState(new BlockPos(
																																																																																	x + 1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x + 1,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 0)).getBlock() == FaithCraft2.wineBlock) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x + 1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z
																																																																																					+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																																																if (world
																																																																																		.getBlockState(new BlockPos(
																																																																																				x + 1,
																																																																																				y
																																																																																						+ -1,
																																																																																				z
																																																																																						+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlockState(new BlockPos(
																																																																																					x + 1,
																																																																																					y + 0,
																																																																																					z + 2)).getBlock() == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlockState(new BlockPos(
																																																																																						x + 1,
																																																																																						y + 0,
																																																																																						z + 1)).getBlock() == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlockState(new BlockPos(
																																																																																							x + 1,
																																																																																							y + 0,
																																																																																							z + 0)).getBlock() == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlockState(new BlockPos(
																																																																																								x + 1,
																																																																																								y + 0,
																																																																																								z
																																																																																										+ -1)).getBlock() == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlockState(new BlockPos(
																																																																																									x + 1,
																																																																																									y + 0,
																																																																																									z
																																																																																											+ -2)).getBlock() == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlockState(new BlockPos(
																																																																																										x + 1,
																																																																																										y + 1,
																																																																																										z + 2)).getBlock() == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlockState(new BlockPos(
																																																																																											x + 1,
																																																																																											y + 1,
																																																																																											z + 1)).getBlock() == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlockState(new BlockPos(
																																																																																												x + 1,
																																																																																												y + 1,
																																																																																												z + 0)).getBlock() == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlockState(new BlockPos(
																																																																																													x + 1,
																																																																																													y + 1,
																																																																																													z
																																																																																															+ -1)).getBlock() == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlockState(new BlockPos(
																																																																																														x + 1,
																																																																																														y + 1,
																																																																																														z
																																																																																																+ -2)).getBlock() == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlockState(new BlockPos(
																																																																																															x + 1,
																																																																																															y + 2,
																																																																																															z + 2)).getBlock() == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlockState(new BlockPos(
																																																																																																x + 1,
																																																																																																y + 2,
																																																																																																z + 1)).getBlock() == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlockState(new BlockPos(
																																																																																																	x + 1,
																																																																																																	y + 2,
																																																																																																	z + 0)).getBlock() == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlockState(new BlockPos(
																																																																																																		x + 1,
																																																																																																		y + 2,
																																																																																																		z
																																																																																																				+ -1)).getBlock() == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlockState(new BlockPos(
																																																																																																			x + 1,
																																																																																																			y + 2,
																																																																																																			z
																																																																																																					+ -2)).getBlock() == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlockState(new BlockPos(
																																																																																																				x + 1,
																																																																																																				y + 3,
																																																																																																				z + 2)).getBlock() == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlockState(new BlockPos(
																																																																																																					x + 1,
																																																																																																					y + 3,
																																																																																																					z + 1)).getBlock() == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlockState(new BlockPos(
																																																																																																						x + 1,
																																																																																																						y + 3,
																																																																																																						z + 0)).getBlock() == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlockState(new BlockPos(
																																																																																																							x + 1,
																																																																																																							y + 3,
																																																																																																							z
																																																																																																									+ -1)).getBlock() == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlockState(new BlockPos(
																																																																																																								x + 1,
																																																																																																								y + 3,
																																																																																																								z
																																																																																																										+ -2)).getBlock() == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlockState(new BlockPos(
																																																																																																									x + 2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlockState(new BlockPos(
																																																																																																										x + 2,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z + 1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlockState(new BlockPos(
																																																																																																											x + 2,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlockState(new BlockPos(
																																																																																																												x + 2,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z
																																																																																																														+ -1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlockState(new BlockPos(
																																																																																																													x + 2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z
																																																																																																															+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlockState(new BlockPos(
																																																																																																														x + 2,
																																																																																																														y + 0,
																																																																																																														z + 2)).getBlock() == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlockState(new BlockPos(
																																																																																																															x + 2,
																																																																																																															y + 0,
																																																																																																															z + 1)).getBlock() == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlockState(new BlockPos(
																																																																																																																x + 2,
																																																																																																																y + 0,
																																																																																																																z + 0)).getBlock() == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlockState(new BlockPos(
																																																																																																																	x + 2,
																																																																																																																	y + 0,
																																																																																																																	z
																																																																																																																			+ -1)).getBlock() == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlockState(new BlockPos(
																																																																																																																		x + 2,
																																																																																																																		y + 0,
																																																																																																																		z
																																																																																																																				+ -2)).getBlock() == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlockState(new BlockPos(
																																																																																																																			x + 2,
																																																																																																																			y + 1,
																																																																																																																			z + 2)).getBlock() == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlockState(new BlockPos(
																																																																																																																				x + 2,
																																																																																																																				y + 1,
																																																																																																																				z + 1)).getBlock() == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlockState(new BlockPos(
																																																																																																																					x + 2,
																																																																																																																					y + 1,
																																																																																																																					z + 0)).getBlock() == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlockState(new BlockPos(
																																																																																																																						x + 2,
																																																																																																																						y + 1,
																																																																																																																						z
																																																																																																																								+ -1)).getBlock() == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlockState(new BlockPos(
																																																																																																																							x + 2,
																																																																																																																							y + 1,
																																																																																																																							z
																																																																																																																									+ -2)).getBlock() == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlockState(new BlockPos(
																																																																																																																								x + 2,
																																																																																																																								y + 2,
																																																																																																																								z + 2)).getBlock() == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlockState(new BlockPos(
																																																																																																																									x + 2,
																																																																																																																									y + 2,
																																																																																																																									z + 1)).getBlock() == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlockState(new BlockPos(
																																																																																																																										x + 2,
																																																																																																																										y + 2,
																																																																																																																										z + 0)).getBlock() == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlockState(new BlockPos(
																																																																																																																											x + 2,
																																																																																																																											y + 2,
																																																																																																																											z
																																																																																																																													+ -1)).getBlock() == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlockState(new BlockPos(
																																																																																																																												x + 2,
																																																																																																																												y + 2,
																																																																																																																												z
																																																																																																																														+ -2)).getBlock() == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlockState(new BlockPos(
																																																																																																																													x + 2,
																																																																																																																													y + 3,
																																																																																																																													z + 2)).getBlock() == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlockState(new BlockPos(
																																																																																																																														x + 2,
																																																																																																																														y + 3,
																																																																																																																														z + 1)).getBlock() == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlockState(new BlockPos(
																																																																																																																															x + 2,
																																																																																																																															y + 3,
																																																																																																																															z + 0)).getBlock() == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlockState(new BlockPos(
																																																																																																																																x + 2,
																																																																																																																																y + 3,
																																																																																																																																z
																																																																																																																																		+ -1)).getBlock() == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlockState(new BlockPos(
																																																																																																																																	x + 2,
																																																																																																																																	y + 3,
																																																																																																																																	z
																																																																																																																																			+ -2)).getBlock() == Blocks.air) {
																																																																																																																														return true;
																																																																																																																													}
																																																																																																																												}
																																																																																																																											}
																																																																																																																										}
																																																																																																																									}
																																																																																																																								}
																																																																																																																							}
																																																																																																																						}
																																																																																																																					}
																																																																																																																				}
																																																																																																																			}
																																																																																																																		}
																																																																																																																	}
																																																																																																																}
																																																																																																															}
																																																																																																														}
																																																																																																													}
																																																																																																												}
																																																																																																											}
																																																																																																										}
																																																																																																									}
																																																																																																								}
																																																																																																							}
																																																																																																						}
																																																																																																					}
																																																																																																				}
																																																																																																			}
																																																																																																		}
																																																																																																	}
																																																																																																}
																																																																																															}
																																																																																														}
																																																																																													}
																																																																																												}
																																																																																											}
																																																																																										}
																																																																																									}
																																																																																								}
																																																																																							}
																																																																																						}
																																																																																					}
																																																																																				}
																																																																																			}
																																																																																		}
																																																																																	}
																																																																																}
																																																																															}
																																																																														}
																																																																													}
																																																																												}
																																																																											}
																																																																										}
																																																																									}
																																																																								}
																																																																							}
																																																																						}
																																																																					}
																																																																				}
																																																																			}
																																																																		}
																																																																	}
																																																																}
																																																															}
																																																														}
																																																													}
																																																												}
																																																											}
																																																										}
																																																									}
																																																								}
																																																							}
																																																						}
																																																					}
																																																				}
																																																			}
																																																		}
																																																	}
																																																}
																																															}
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkEast(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + -2, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
			if (world.getBlockState(new BlockPos(x + -1, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
				if (world.getBlockState(new BlockPos(x + 0, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
					if (world.getBlockState(new BlockPos(x + 1, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
						if (world.getBlockState(new BlockPos(x + 2, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + -2, y + 0, z + -2)).getBlock() == Blocks.air) {
								if (world.getBlockState(new BlockPos(x + -1, y + 0, z + -2)).getBlock() == Blocks.air) {
									if (world.getBlockState(new BlockPos(x + 0, y + 0, z + -2)).getBlock() == Blocks.air) {
										if (world.getBlockState(new BlockPos(x + 1, y + 0, z
												+ -2)).getBlock() == Blocks.air) {
											if (world.getBlockState(new BlockPos(x + 2, y + 0,
													z + -2)).getBlock() == Blocks.air) {
												if (world.getBlockState(new BlockPos(x + -2,
														y + 1, z + -2)).getBlock() == Blocks.air) {
													if (world.getBlockState(new BlockPos(
															x + -1, y + 1, z
																	+ -2)).getBlock() == Blocks.air) {
														if (world.getBlockState(new BlockPos(
																x + 0, y + 1, z
																		+ -2)).getBlock() == Blocks.air) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 1,
																			y + 1,
																			z
																					+ -2)).getBlock() == Blocks.air) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 2,
																				y + 1,
																				z
																						+ -2)).getBlock() == Blocks.air) {
																	if (world
																			.getBlockState(new BlockPos(
																					x
																							+ -2,
																					y + 2,
																					z
																							+ -2)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x
																								+ -1,
																						y + 2,
																						z
																								+ -2)).getBlock() == Blocks.air) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 0,
																							y + 2,
																							z
																									+ -2)).getBlock() == Blocks.air) {
																				if (world
																						.getBlockState(new BlockPos(
																								x + 1,
																								y + 2,
																								z
																										+ -2)).getBlock() == Blocks.air) {
																					if (world
																							.getBlockState(new BlockPos(
																									x + 2,
																									y + 2,
																									z
																											+ -2)).getBlock() == Blocks.air) {
																						if (world
																								.getBlockState(new BlockPos(
																										x
																												+ -2,
																										y + 3,
																										z
																												+ -2)).getBlock() == Blocks.air) {
																							if (world
																									.getBlockState(new BlockPos(
																											x
																													+ -1,
																											y + 3,
																											z
																													+ -2)).getBlock() == Blocks.air) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 0,
																												y + 3,
																												z
																														+ -2)).getBlock() == Blocks.air) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 1,
																													y + 3,
																													z
																															+ -2)).getBlock() == Blocks.air) {
																										if (world
																												.getBlockState(new BlockPos(
																														x + 2,
																														y + 3,
																														z
																																+ -2)).getBlock() == Blocks.air) {
																											if (world
																													.getBlockState(new BlockPos(
																															x
																																	+ -2,
																															y
																																	+ -1,
																															z
																																	+ -1)).getBlock() == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlockState(new BlockPos(
																																x
																																		+ -1,
																																y
																																		+ -1,
																																z
																																		+ -1)).getBlock() == FaithCraft2.wineBlock) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x + 0,
																																	y
																																			+ -1,
																																	z
																																			+ -1)).getBlock() == FaithCraft2.wineBlock) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x + 1,
																																		y
																																				+ -1,
																																		z
																																				+ -1)).getBlock() == FaithCraft2.wineBlock) {
																															if (world
																																	.getBlockState(new BlockPos(
																																			x + 2,
																																			y
																																					+ -1,
																																			z
																																					+ -1)).getBlock() == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlockState(new BlockPos(
																																				x
																																						+ -2,
																																				y + 0,
																																				z
																																						+ -1)).getBlock() == Blocks.air) {
																																	if (world
																																			.getBlockState(new BlockPos(
																																					x
																																							+ -1,
																																					y + 0,
																																					z
																																							+ -1)).getBlock() == Blocks.air) {
																																		if (world
																																				.getBlockState(new BlockPos(
																																						x + 0,
																																						y + 0,
																																						z
																																								+ -1)).getBlock() == Blocks.air) {
																																			if (world
																																					.getBlockState(new BlockPos(
																																							x + 1,
																																							y + 0,
																																							z
																																									+ -1)).getBlock() == Blocks.air) {
																																				if (world
																																						.getBlockState(new BlockPos(
																																								x + 2,
																																								y + 0,
																																								z
																																										+ -1)).getBlock() == Blocks.air) {
																																					if (world
																																							.getBlockState(new BlockPos(
																																									x
																																											+ -2,
																																									y + 1,
																																									z
																																											+ -1)).getBlock() == Blocks.air) {
																																						if (world
																																								.getBlockState(new BlockPos(
																																										x
																																												+ -1,
																																										y + 1,
																																										z
																																												+ -1)).getBlock() == Blocks.air) {
																																							if (world
																																									.getBlockState(new BlockPos(
																																											x + 0,
																																											y + 1,
																																											z
																																													+ -1)).getBlock() == Blocks.air) {
																																								if (world
																																										.getBlockState(new BlockPos(
																																												x + 1,
																																												y + 1,
																																												z
																																														+ -1)).getBlock() == Blocks.air) {
																																									if (world
																																											.getBlockState(new BlockPos(
																																													x + 2,
																																													y + 1,
																																													z
																																															+ -1)).getBlock() == Blocks.air) {
																																										if (world
																																												.getBlockState(new BlockPos(
																																														x
																																																+ -2,
																																														y + 2,
																																														z
																																																+ -1)).getBlock() == Blocks.air) {
																																											if (world
																																													.getBlockState(new BlockPos(
																																															x
																																																	+ -1,
																																															y + 2,
																																															z
																																																	+ -1)).getBlock() == Blocks.air) {
																																												if (world
																																														.getBlockState(new BlockPos(
																																																x + 0,
																																																y + 2,
																																																z
																																																		+ -1)).getBlock() == Blocks.air) {
																																													if (world
																																															.getBlockState(new BlockPos(
																																																	x + 1,
																																																	y + 2,
																																																	z
																																																			+ -1)).getBlock() == Blocks.air) {
																																														if (world
																																																.getBlockState(new BlockPos(
																																																		x + 2,
																																																		y + 2,
																																																		z
																																																				+ -1)).getBlock() == Blocks.air) {
																																															if (world
																																																	.getBlockState(new BlockPos(
																																																			x
																																																					+ -2,
																																																			y + 3,
																																																			z
																																																					+ -1)).getBlock() == Blocks.air) {
																																																if (world
																																																		.getBlockState(new BlockPos(
																																																				x
																																																						+ -1,
																																																				y + 3,
																																																				z
																																																						+ -1)).getBlock() == Blocks.air) {
																																																	if (world
																																																			.getBlockState(new BlockPos(
																																																					x + 0,
																																																					y + 3,
																																																					z
																																																							+ -1)).getBlock() == Blocks.air) {
																																																		if (world
																																																				.getBlockState(new BlockPos(
																																																						x + 1,
																																																						y + 3,
																																																						z
																																																								+ -1)).getBlock() == Blocks.air) {
																																																			if (world
																																																					.getBlockState(new BlockPos(
																																																							x + 2,
																																																							y + 3,
																																																							z
																																																									+ -1)).getBlock() == Blocks.air) {
																																																				if (world
																																																						.getBlockState(new BlockPos(
																																																								x
																																																										+ -2,
																																																								y
																																																										+ -1,
																																																								z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlockState(new BlockPos(
																																																									x
																																																											+ -1,
																																																									y
																																																											+ -1,
																																																									z + 0)).getBlock() == FaithCraft2.wineBlock) {
																																																						if (world
																																																								.getBlockState(new BlockPos(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlockState(new BlockPos(
																																																											x + 1,
																																																											y
																																																													+ -1,
																																																											z + 0)).getBlock() == FaithCraft2.wineBlock) {
																																																								if (world
																																																										.getBlockState(new BlockPos(
																																																												x + 2,
																																																												y
																																																														+ -1,
																																																												z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlockState(new BlockPos(
																																																													x
																																																															+ -2,
																																																													y + 0,
																																																													z + 0)).getBlock() == Blocks.air) {
																																																										if (world
																																																												.getBlockState(new BlockPos(
																																																														x
																																																																+ -1,
																																																														y + 0,
																																																														z + 0)).getBlock() == Blocks.air) {
																																																											if (world
																																																													.getBlockState(new BlockPos(
																																																															x + 1,
																																																															y + 0,
																																																															z + 0)).getBlock() == Blocks.air) {
																																																												if (world
																																																														.getBlockState(new BlockPos(
																																																																x + 2,
																																																																y + 0,
																																																																z + 0)).getBlock() == Blocks.air) {
																																																													if (world
																																																															.getBlockState(new BlockPos(
																																																																	x
																																																																			+ -2,
																																																																	y + 1,
																																																																	z + 0)).getBlock() == Blocks.air) {
																																																														if (world
																																																																.getBlockState(new BlockPos(
																																																																		x
																																																																				+ -1,
																																																																		y + 1,
																																																																		z + 0)).getBlock() == Blocks.air) {
																																																															if (world
																																																																	.getBlockState(new BlockPos(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0)).getBlock() == Blocks.air) {
																																																																if (world
																																																																		.getBlockState(new BlockPos(
																																																																				x + 1,
																																																																				y + 1,
																																																																				z + 0)).getBlock() == Blocks.air) {
																																																																	if (world
																																																																			.getBlockState(new BlockPos(
																																																																					x + 2,
																																																																					y + 1,
																																																																					z + 0)).getBlock() == Blocks.air) {
																																																																		if (world
																																																																				.getBlockState(new BlockPos(
																																																																						x
																																																																								+ -2,
																																																																						y + 2,
																																																																						z + 0)).getBlock() == Blocks.air) {
																																																																			if (world
																																																																					.getBlockState(new BlockPos(
																																																																							x
																																																																									+ -1,
																																																																							y + 2,
																																																																							z + 0)).getBlock() == Blocks.air) {
																																																																				if (world
																																																																						.getBlockState(new BlockPos(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0)).getBlock() == Blocks.air) {
																																																																					if (world
																																																																							.getBlockState(new BlockPos(
																																																																									x + 1,
																																																																									y + 2,
																																																																									z + 0)).getBlock() == Blocks.air) {
																																																																						if (world
																																																																								.getBlockState(new BlockPos(
																																																																										x + 2,
																																																																										y + 2,
																																																																										z + 0)).getBlock() == Blocks.air) {
																																																																							if (world
																																																																									.getBlockState(new BlockPos(
																																																																											x
																																																																													+ -2,
																																																																											y + 3,
																																																																											z + 0)).getBlock() == Blocks.air) {
																																																																								if (world
																																																																										.getBlockState(new BlockPos(
																																																																												x
																																																																														+ -1,
																																																																												y + 3,
																																																																												z + 0)).getBlock() == Blocks.air) {
																																																																									if (world
																																																																											.getBlockState(new BlockPos(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0)).getBlock() == Blocks.air) {
																																																																										if (world
																																																																												.getBlockState(new BlockPos(
																																																																														x + 1,
																																																																														y + 3,
																																																																														z + 0)).getBlock() == Blocks.air) {
																																																																											if (world
																																																																													.getBlockState(new BlockPos(
																																																																															x + 2,
																																																																															y + 3,
																																																																															z + 0)).getBlock() == Blocks.air) {
																																																																												if (world
																																																																														.getBlockState(new BlockPos(
																																																																																x
																																																																																		+ -2,
																																																																																y
																																																																																		+ -1,
																																																																																z + 1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlockState(new BlockPos(
																																																																																	x
																																																																																			+ -1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x + 0,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x + 1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																																																if (world
																																																																																		.getBlockState(new BlockPos(
																																																																																				x + 2,
																																																																																				y
																																																																																						+ -1,
																																																																																				z + 1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlockState(new BlockPos(
																																																																																					x
																																																																																							+ -2,
																																																																																					y + 0,
																																																																																					z + 1)).getBlock() == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlockState(new BlockPos(
																																																																																						x
																																																																																								+ -1,
																																																																																						y + 0,
																																																																																						z + 1)).getBlock() == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlockState(new BlockPos(
																																																																																							x + 0,
																																																																																							y + 0,
																																																																																							z + 1)).getBlock() == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlockState(new BlockPos(
																																																																																								x + 1,
																																																																																								y + 0,
																																																																																								z + 1)).getBlock() == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlockState(new BlockPos(
																																																																																									x + 2,
																																																																																									y + 0,
																																																																																									z + 1)).getBlock() == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlockState(new BlockPos(
																																																																																										x
																																																																																												+ -2,
																																																																																										y + 1,
																																																																																										z + 1)).getBlock() == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlockState(new BlockPos(
																																																																																											x
																																																																																													+ -1,
																																																																																											y + 1,
																																																																																											z + 1)).getBlock() == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlockState(new BlockPos(
																																																																																												x + 0,
																																																																																												y + 1,
																																																																																												z + 1)).getBlock() == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlockState(new BlockPos(
																																																																																													x + 1,
																																																																																													y + 1,
																																																																																													z + 1)).getBlock() == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlockState(new BlockPos(
																																																																																														x + 2,
																																																																																														y + 1,
																																																																																														z + 1)).getBlock() == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlockState(new BlockPos(
																																																																																															x
																																																																																																	+ -2,
																																																																																															y + 2,
																																																																																															z + 1)).getBlock() == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlockState(new BlockPos(
																																																																																																x
																																																																																																		+ -1,
																																																																																																y + 2,
																																																																																																z + 1)).getBlock() == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlockState(new BlockPos(
																																																																																																	x + 0,
																																																																																																	y + 2,
																																																																																																	z + 1)).getBlock() == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlockState(new BlockPos(
																																																																																																		x + 1,
																																																																																																		y + 2,
																																																																																																		z + 1)).getBlock() == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlockState(new BlockPos(
																																																																																																			x + 2,
																																																																																																			y + 2,
																																																																																																			z + 1)).getBlock() == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlockState(new BlockPos(
																																																																																																				x
																																																																																																						+ -2,
																																																																																																				y + 3,
																																																																																																				z + 1)).getBlock() == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlockState(new BlockPos(
																																																																																																					x
																																																																																																							+ -1,
																																																																																																					y + 3,
																																																																																																					z + 1)).getBlock() == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlockState(new BlockPos(
																																																																																																						x + 0,
																																																																																																						y + 3,
																																																																																																						z + 1)).getBlock() == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlockState(new BlockPos(
																																																																																																							x + 1,
																																																																																																							y + 3,
																																																																																																							z + 1)).getBlock() == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlockState(new BlockPos(
																																																																																																								x + 2,
																																																																																																								y + 3,
																																																																																																								z + 1)).getBlock() == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlockState(new BlockPos(
																																																																																																									x
																																																																																																											+ -2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlockState(new BlockPos(
																																																																																																										x
																																																																																																												+ -1,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlockState(new BlockPos(
																																																																																																											x + 0,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlockState(new BlockPos(
																																																																																																												x + 1,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlockState(new BlockPos(
																																																																																																													x + 2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlockState(new BlockPos(
																																																																																																														x
																																																																																																																+ -2,
																																																																																																														y + 0,
																																																																																																														z + 2)).getBlock() == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlockState(new BlockPos(
																																																																																																															x
																																																																																																																	+ -1,
																																																																																																															y + 0,
																																																																																																															z + 2)).getBlock() == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlockState(new BlockPos(
																																																																																																																x + 0,
																																																																																																																y + 0,
																																																																																																																z + 2)).getBlock() == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlockState(new BlockPos(
																																																																																																																	x + 1,
																																																																																																																	y + 0,
																																																																																																																	z + 2)).getBlock() == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlockState(new BlockPos(
																																																																																																																		x + 2,
																																																																																																																		y + 0,
																																																																																																																		z + 2)).getBlock() == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlockState(new BlockPos(
																																																																																																																			x
																																																																																																																					+ -2,
																																																																																																																			y + 1,
																																																																																																																			z + 2)).getBlock() == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlockState(new BlockPos(
																																																																																																																				x
																																																																																																																						+ -1,
																																																																																																																				y + 1,
																																																																																																																				z + 2)).getBlock() == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlockState(new BlockPos(
																																																																																																																					x + 0,
																																																																																																																					y + 1,
																																																																																																																					z + 2)).getBlock() == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlockState(new BlockPos(
																																																																																																																						x + 1,
																																																																																																																						y + 1,
																																																																																																																						z + 2)).getBlock() == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlockState(new BlockPos(
																																																																																																																							x + 2,
																																																																																																																							y + 1,
																																																																																																																							z + 2)).getBlock() == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlockState(new BlockPos(
																																																																																																																								x
																																																																																																																										+ -2,
																																																																																																																								y + 2,
																																																																																																																								z + 2)).getBlock() == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlockState(new BlockPos(
																																																																																																																									x
																																																																																																																											+ -1,
																																																																																																																									y + 2,
																																																																																																																									z + 2)).getBlock() == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlockState(new BlockPos(
																																																																																																																										x + 0,
																																																																																																																										y + 2,
																																																																																																																										z + 2)).getBlock() == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlockState(new BlockPos(
																																																																																																																											x + 1,
																																																																																																																											y + 2,
																																																																																																																											z + 2)).getBlock() == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlockState(new BlockPos(
																																																																																																																												x + 2,
																																																																																																																												y + 2,
																																																																																																																												z + 2)).getBlock() == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlockState(new BlockPos(
																																																																																																																													x
																																																																																																																															+ -2,
																																																																																																																													y + 3,
																																																																																																																													z + 2)).getBlock() == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlockState(new BlockPos(
																																																																																																																														x
																																																																																																																																+ -1,
																																																																																																																														y + 3,
																																																																																																																														z + 2)).getBlock() == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlockState(new BlockPos(
																																																																																																																															x + 0,
																																																																																																																															y + 3,
																																																																																																																															z + 2)).getBlock() == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlockState(new BlockPos(
																																																																																																																																x + 1,
																																																																																																																																y + 3,
																																																																																																																																z + 2)).getBlock() == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlockState(new BlockPos(
																																																																																																																																	x + 2,
																																																																																																																																	y + 3,
																																																																																																																																	z + 2)).getBlock() == Blocks.air) {
																																																																																																																														return true;
																																																																																																																													}
																																																																																																																												}
																																																																																																																											}
																																																																																																																										}
																																																																																																																									}
																																																																																																																								}
																																																																																																																							}
																																																																																																																						}
																																																																																																																					}
																																																																																																																				}
																																																																																																																			}
																																																																																																																		}
																																																																																																																	}
																																																																																																																}
																																																																																																															}
																																																																																																														}
																																																																																																													}
																																																																																																												}
																																																																																																											}
																																																																																																										}
																																																																																																									}
																																																																																																								}
																																																																																																							}
																																																																																																						}
																																																																																																					}
																																																																																																				}
																																																																																																			}
																																																																																																		}
																																																																																																	}
																																																																																																}
																																																																																															}
																																																																																														}
																																																																																													}
																																																																																												}
																																																																																											}
																																																																																										}
																																																																																									}
																																																																																								}
																																																																																							}
																																																																																						}
																																																																																					}
																																																																																				}
																																																																																			}
																																																																																		}
																																																																																	}
																																																																																}
																																																																															}
																																																																														}
																																																																													}
																																																																												}
																																																																											}
																																																																										}
																																																																									}
																																																																								}
																																																																							}
																																																																						}
																																																																					}
																																																																				}
																																																																			}
																																																																		}
																																																																	}
																																																																}
																																																															}
																																																														}
																																																													}
																																																												}
																																																											}
																																																										}
																																																									}
																																																								}
																																																							}
																																																						}
																																																					}
																																																				}
																																																			}
																																																		}
																																																	}
																																																}
																																															}
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkSouth(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 2, y + -1, z + -2)).getBlock() == FaithCraft2.HolyBlock) {
			if (world.getBlockState(new BlockPos(x + 2, y + -1, z + -1)).getBlock() == FaithCraft2.HolyBlock) {
				if (world.getBlockState(new BlockPos(x + 2, y + -1, z + 0)).getBlock() == FaithCraft2.HolyBlock) {
					if (world.getBlockState(new BlockPos(x + 2, y + -1, z + 1)).getBlock() == FaithCraft2.HolyBlock) {
						if (world.getBlockState(new BlockPos(x + 2, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + 2, y + 0, z + -2)).getBlock() == Blocks.air) {
								if (world.getBlockState(new BlockPos(x + 2, y + 0, z + -1)).getBlock() == Blocks.air) {
									if (world.getBlockState(new BlockPos(x + 2, y + 0, z + 0)).getBlock() == Blocks.air) {
										if (world.getBlockState(new BlockPos(x + 2, y + 0,
												z + 1)).getBlock() == Blocks.air) {
											if (world.getBlockState(new BlockPos(x + 2, y + 0,
													z + 2)).getBlock() == Blocks.air) {
												if (world.getBlockState(new BlockPos(x + 2,
														y + 1, z + -2)).getBlock() == Blocks.air) {
													if (world.getBlockState(new BlockPos(x + 2,
															y + 1, z + -1)).getBlock() == Blocks.air) {
														if (world.getBlockState(new BlockPos(
																x + 2, y + 1,
																z + 0)).getBlock() == Blocks.air) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 2,
																			y + 1,
																			z + 1)).getBlock() == Blocks.air) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 2,
																				y + 1,
																				z + 2)).getBlock() == Blocks.air) {
																	if (world
																			.getBlockState(new BlockPos(
																					x + 2,
																					y + 2,
																					z
																							+ -2)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x + 2,
																						y + 2,
																						z
																								+ -1)).getBlock() == Blocks.air) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 2,
																							y + 2,
																							z + 0)).getBlock() == Blocks.air) {
																				if (world
																						.getBlockState(new BlockPos(
																								x + 2,
																								y + 2,
																								z + 1)).getBlock() == Blocks.air) {
																					if (world
																							.getBlockState(new BlockPos(
																									x + 2,
																									y + 2,
																									z + 2)).getBlock() == Blocks.air) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 2,
																										y + 3,
																										z
																												+ -2)).getBlock() == Blocks.air) {
																							if (world
																									.getBlockState(new BlockPos(
																											x + 2,
																											y + 3,
																											z
																													+ -1)).getBlock() == Blocks.air) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 2,
																												y + 3,
																												z + 0)).getBlock() == Blocks.air) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 2,
																													y + 3,
																													z + 1)).getBlock() == Blocks.air) {
																										if (world
																												.getBlockState(new BlockPos(
																														x + 2,
																														y + 3,
																														z + 2)).getBlock() == Blocks.air) {
																											if (world
																													.getBlockState(new BlockPos(
																															x + 1,
																															y
																																	+ -1,
																															z
																																	+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlockState(new BlockPos(
																																x + 1,
																																y
																																		+ -1,
																																z
																																		+ -1)).getBlock() == FaithCraft2.wineBlock) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x + 1,
																																	y
																																			+ -1,
																																	z + 0)).getBlock() == FaithCraft2.wineBlock) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x + 1,
																																		y
																																				+ -1,
																																		z + 1)).getBlock() == FaithCraft2.wineBlock) {
																															if (world
																																	.getBlockState(new BlockPos(
																																			x + 1,
																																			y
																																					+ -1,
																																			z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlockState(new BlockPos(
																																				x + 1,
																																				y + 0,
																																				z
																																						+ -2)).getBlock() == Blocks.air) {
																																	if (world
																																			.getBlockState(new BlockPos(
																																					x + 1,
																																					y + 0,
																																					z
																																							+ -1)).getBlock() == Blocks.air) {
																																		if (world
																																				.getBlockState(new BlockPos(
																																						x + 1,
																																						y + 0,
																																						z + 0)).getBlock() == Blocks.air) {
																																			if (world
																																					.getBlockState(new BlockPos(
																																							x + 1,
																																							y + 0,
																																							z + 1)).getBlock() == Blocks.air) {
																																				if (world
																																						.getBlockState(new BlockPos(
																																								x + 1,
																																								y + 0,
																																								z + 2)).getBlock() == Blocks.air) {
																																					if (world
																																							.getBlockState(new BlockPos(
																																									x + 1,
																																									y + 1,
																																									z
																																											+ -2)).getBlock() == Blocks.air) {
																																						if (world
																																								.getBlockState(new BlockPos(
																																										x + 1,
																																										y + 1,
																																										z
																																												+ -1)).getBlock() == Blocks.air) {
																																							if (world
																																									.getBlockState(new BlockPos(
																																											x + 1,
																																											y + 1,
																																											z + 0)).getBlock() == Blocks.air) {
																																								if (world
																																										.getBlockState(new BlockPos(
																																												x + 1,
																																												y + 1,
																																												z + 1)).getBlock() == Blocks.air) {
																																									if (world
																																											.getBlockState(new BlockPos(
																																													x + 1,
																																													y + 1,
																																													z + 2)).getBlock() == Blocks.air) {
																																										if (world
																																												.getBlockState(new BlockPos(
																																														x + 1,
																																														y + 2,
																																														z
																																																+ -2)).getBlock() == Blocks.air) {
																																											if (world
																																													.getBlockState(new BlockPos(
																																															x + 1,
																																															y + 2,
																																															z
																																																	+ -1)).getBlock() == Blocks.air) {
																																												if (world
																																														.getBlockState(new BlockPos(
																																																x + 1,
																																																y + 2,
																																																z + 0)).getBlock() == Blocks.air) {
																																													if (world
																																															.getBlockState(new BlockPos(
																																																	x + 1,
																																																	y + 2,
																																																	z + 1)).getBlock() == Blocks.air) {
																																														if (world
																																																.getBlockState(new BlockPos(
																																																		x + 1,
																																																		y + 2,
																																																		z + 2)).getBlock() == Blocks.air) {
																																															if (world
																																																	.getBlockState(new BlockPos(
																																																			x + 1,
																																																			y + 3,
																																																			z
																																																					+ -2)).getBlock() == Blocks.air) {
																																																if (world
																																																		.getBlockState(new BlockPos(
																																																				x + 1,
																																																				y + 3,
																																																				z
																																																						+ -1)).getBlock() == Blocks.air) {
																																																	if (world
																																																			.getBlockState(new BlockPos(
																																																					x + 1,
																																																					y + 3,
																																																					z + 0)).getBlock() == Blocks.air) {
																																																		if (world
																																																				.getBlockState(new BlockPos(
																																																						x + 1,
																																																						y + 3,
																																																						z + 1)).getBlock() == Blocks.air) {
																																																			if (world
																																																					.getBlockState(new BlockPos(
																																																							x + 1,
																																																							y + 3,
																																																							z + 2)).getBlock() == Blocks.air) {
																																																				if (world
																																																						.getBlockState(new BlockPos(
																																																								x + 0,
																																																								y
																																																										+ -1,
																																																								z
																																																										+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlockState(new BlockPos(
																																																									x + 0,
																																																									y
																																																											+ -1,
																																																									z
																																																											+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																						if (world
																																																								.getBlockState(new BlockPos(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlockState(new BlockPos(
																																																											x + 0,
																																																											y
																																																													+ -1,
																																																											z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																								if (world
																																																										.getBlockState(new BlockPos(
																																																												x + 0,
																																																												y
																																																														+ -1,
																																																												z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlockState(new BlockPos(
																																																													x + 0,
																																																													y + 0,
																																																													z
																																																															+ -2)).getBlock() == Blocks.air) {
																																																										if (world
																																																												.getBlockState(new BlockPos(
																																																														x + 0,
																																																														y + 0,
																																																														z
																																																																+ -1)).getBlock() == Blocks.air) {
																																																											if (world
																																																													.getBlockState(new BlockPos(
																																																															x + 0,
																																																															y + 0,
																																																															z + 1)).getBlock() == Blocks.air) {
																																																												if (world
																																																														.getBlockState(new BlockPos(
																																																																x + 0,
																																																																y + 0,
																																																																z + 2)).getBlock() == Blocks.air) {
																																																													if (world
																																																															.getBlockState(new BlockPos(
																																																																	x + 0,
																																																																	y + 1,
																																																																	z
																																																																			+ -2)).getBlock() == Blocks.air) {
																																																														if (world
																																																																.getBlockState(new BlockPos(
																																																																		x + 0,
																																																																		y + 1,
																																																																		z
																																																																				+ -1)).getBlock() == Blocks.air) {
																																																															if (world
																																																																	.getBlockState(new BlockPos(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0)).getBlock() == Blocks.air) {
																																																																if (world
																																																																		.getBlockState(new BlockPos(
																																																																				x + 0,
																																																																				y + 1,
																																																																				z + 1)).getBlock() == Blocks.air) {
																																																																	if (world
																																																																			.getBlockState(new BlockPos(
																																																																					x + 0,
																																																																					y + 1,
																																																																					z + 2)).getBlock() == Blocks.air) {
																																																																		if (world
																																																																				.getBlockState(new BlockPos(
																																																																						x + 0,
																																																																						y + 2,
																																																																						z
																																																																								+ -2)).getBlock() == Blocks.air) {
																																																																			if (world
																																																																					.getBlockState(new BlockPos(
																																																																							x + 0,
																																																																							y + 2,
																																																																							z
																																																																									+ -1)).getBlock() == Blocks.air) {
																																																																				if (world
																																																																						.getBlockState(new BlockPos(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0)).getBlock() == Blocks.air) {
																																																																					if (world
																																																																							.getBlockState(new BlockPos(
																																																																									x + 0,
																																																																									y + 2,
																																																																									z + 1)).getBlock() == Blocks.air) {
																																																																						if (world
																																																																								.getBlockState(new BlockPos(
																																																																										x + 0,
																																																																										y + 2,
																																																																										z + 2)).getBlock() == Blocks.air) {
																																																																							if (world
																																																																									.getBlockState(new BlockPos(
																																																																											x + 0,
																																																																											y + 3,
																																																																											z
																																																																													+ -2)).getBlock() == Blocks.air) {
																																																																								if (world
																																																																										.getBlockState(new BlockPos(
																																																																												x + 0,
																																																																												y + 3,
																																																																												z
																																																																														+ -1)).getBlock() == Blocks.air) {
																																																																									if (world
																																																																											.getBlockState(new BlockPos(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0)).getBlock() == Blocks.air) {
																																																																										if (world
																																																																												.getBlockState(new BlockPos(
																																																																														x + 0,
																																																																														y + 3,
																																																																														z + 1)).getBlock() == Blocks.air) {
																																																																											if (world
																																																																													.getBlockState(new BlockPos(
																																																																															x + 0,
																																																																															y + 3,
																																																																															z + 2)).getBlock() == Blocks.air) {
																																																																												if (world
																																																																														.getBlockState(new BlockPos(
																																																																																x
																																																																																		+ -1,
																																																																																y
																																																																																		+ -1,
																																																																																z
																																																																																		+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlockState(new BlockPos(
																																																																																	x
																																																																																			+ -1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z
																																																																																			+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x
																																																																																				+ -1,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 0)).getBlock() == FaithCraft2.wineBlock) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x
																																																																																					+ -1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z + 1)).getBlock() == FaithCraft2.wineBlock) {
																																																																																if (world
																																																																																		.getBlockState(new BlockPos(
																																																																																				x
																																																																																						+ -1,
																																																																																				y
																																																																																						+ -1,
																																																																																				z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlockState(new BlockPos(
																																																																																					x
																																																																																							+ -1,
																																																																																					y + 0,
																																																																																					z
																																																																																							+ -2)).getBlock() == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlockState(new BlockPos(
																																																																																						x
																																																																																								+ -1,
																																																																																						y + 0,
																																																																																						z
																																																																																								+ -1)).getBlock() == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlockState(new BlockPos(
																																																																																							x
																																																																																									+ -1,
																																																																																							y + 0,
																																																																																							z + 0)).getBlock() == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlockState(new BlockPos(
																																																																																								x
																																																																																										+ -1,
																																																																																								y + 0,
																																																																																								z + 1)).getBlock() == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlockState(new BlockPos(
																																																																																									x
																																																																																											+ -1,
																																																																																									y + 0,
																																																																																									z + 2)).getBlock() == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlockState(new BlockPos(
																																																																																										x
																																																																																												+ -1,
																																																																																										y + 1,
																																																																																										z
																																																																																												+ -2)).getBlock() == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlockState(new BlockPos(
																																																																																											x
																																																																																													+ -1,
																																																																																											y + 1,
																																																																																											z
																																																																																													+ -1)).getBlock() == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlockState(new BlockPos(
																																																																																												x
																																																																																														+ -1,
																																																																																												y + 1,
																																																																																												z + 0)).getBlock() == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlockState(new BlockPos(
																																																																																													x
																																																																																															+ -1,
																																																																																													y + 1,
																																																																																													z + 1)).getBlock() == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlockState(new BlockPos(
																																																																																														x
																																																																																																+ -1,
																																																																																														y + 1,
																																																																																														z + 2)).getBlock() == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlockState(new BlockPos(
																																																																																															x
																																																																																																	+ -1,
																																																																																															y + 2,
																																																																																															z
																																																																																																	+ -2)).getBlock() == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlockState(new BlockPos(
																																																																																																x
																																																																																																		+ -1,
																																																																																																y + 2,
																																																																																																z
																																																																																																		+ -1)).getBlock() == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlockState(new BlockPos(
																																																																																																	x
																																																																																																			+ -1,
																																																																																																	y + 2,
																																																																																																	z + 0)).getBlock() == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlockState(new BlockPos(
																																																																																																		x
																																																																																																				+ -1,
																																																																																																		y + 2,
																																																																																																		z + 1)).getBlock() == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlockState(new BlockPos(
																																																																																																			x
																																																																																																					+ -1,
																																																																																																			y + 2,
																																																																																																			z + 2)).getBlock() == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlockState(new BlockPos(
																																																																																																				x
																																																																																																						+ -1,
																																																																																																				y + 3,
																																																																																																				z
																																																																																																						+ -2)).getBlock() == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlockState(new BlockPos(
																																																																																																					x
																																																																																																							+ -1,
																																																																																																					y + 3,
																																																																																																					z
																																																																																																							+ -1)).getBlock() == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlockState(new BlockPos(
																																																																																																						x
																																																																																																								+ -1,
																																																																																																						y + 3,
																																																																																																						z + 0)).getBlock() == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlockState(new BlockPos(
																																																																																																							x
																																																																																																									+ -1,
																																																																																																							y + 3,
																																																																																																							z + 1)).getBlock() == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlockState(new BlockPos(
																																																																																																								x
																																																																																																										+ -1,
																																																																																																								y + 3,
																																																																																																								z + 2)).getBlock() == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlockState(new BlockPos(
																																																																																																									x
																																																																																																											+ -2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z
																																																																																																											+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlockState(new BlockPos(
																																																																																																										x
																																																																																																												+ -2,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z
																																																																																																												+ -1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlockState(new BlockPos(
																																																																																																											x
																																																																																																													+ -2,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlockState(new BlockPos(
																																																																																																												x
																																																																																																														+ -2,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z + 1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlockState(new BlockPos(
																																																																																																													x
																																																																																																															+ -2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z + 2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlockState(new BlockPos(
																																																																																																														x
																																																																																																																+ -2,
																																																																																																														y + 0,
																																																																																																														z
																																																																																																																+ -2)).getBlock() == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlockState(new BlockPos(
																																																																																																															x
																																																																																																																	+ -2,
																																																																																																															y + 0,
																																																																																																															z
																																																																																																																	+ -1)).getBlock() == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlockState(new BlockPos(
																																																																																																																x
																																																																																																																		+ -2,
																																																																																																																y + 0,
																																																																																																																z + 0)).getBlock() == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlockState(new BlockPos(
																																																																																																																	x
																																																																																																																			+ -2,
																																																																																																																	y + 0,
																																																																																																																	z + 1)).getBlock() == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlockState(new BlockPos(
																																																																																																																		x
																																																																																																																				+ -2,
																																																																																																																		y + 0,
																																																																																																																		z + 2)).getBlock() == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlockState(new BlockPos(
																																																																																																																			x
																																																																																																																					+ -2,
																																																																																																																			y + 1,
																																																																																																																			z
																																																																																																																					+ -2)).getBlock() == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlockState(new BlockPos(
																																																																																																																				x
																																																																																																																						+ -2,
																																																																																																																				y + 1,
																																																																																																																				z
																																																																																																																						+ -1)).getBlock() == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlockState(new BlockPos(
																																																																																																																					x
																																																																																																																							+ -2,
																																																																																																																					y + 1,
																																																																																																																					z + 0)).getBlock() == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlockState(new BlockPos(
																																																																																																																						x
																																																																																																																								+ -2,
																																																																																																																						y + 1,
																																																																																																																						z + 1)).getBlock() == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlockState(new BlockPos(
																																																																																																																							x
																																																																																																																									+ -2,
																																																																																																																							y + 1,
																																																																																																																							z + 2)).getBlock() == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlockState(new BlockPos(
																																																																																																																								x
																																																																																																																										+ -2,
																																																																																																																								y + 2,
																																																																																																																								z
																																																																																																																										+ -2)).getBlock() == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlockState(new BlockPos(
																																																																																																																									x
																																																																																																																											+ -2,
																																																																																																																									y + 2,
																																																																																																																									z
																																																																																																																											+ -1)).getBlock() == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlockState(new BlockPos(
																																																																																																																										x
																																																																																																																												+ -2,
																																																																																																																										y + 2,
																																																																																																																										z + 0)).getBlock() == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlockState(new BlockPos(
																																																																																																																											x
																																																																																																																													+ -2,
																																																																																																																											y + 2,
																																																																																																																											z + 1)).getBlock() == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlockState(new BlockPos(
																																																																																																																												x
																																																																																																																														+ -2,
																																																																																																																												y + 2,
																																																																																																																												z + 2)).getBlock() == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlockState(new BlockPos(
																																																																																																																													x
																																																																																																																															+ -2,
																																																																																																																													y + 3,
																																																																																																																													z
																																																																																																																															+ -2)).getBlock() == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlockState(new BlockPos(
																																																																																																																														x
																																																																																																																																+ -2,
																																																																																																																														y + 3,
																																																																																																																														z
																																																																																																																																+ -1)).getBlock() == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlockState(new BlockPos(
																																																																																																																															x
																																																																																																																																	+ -2,
																																																																																																																															y + 3,
																																																																																																																															z + 0)).getBlock() == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlockState(new BlockPos(
																																																																																																																																x
																																																																																																																																		+ -2,
																																																																																																																																y + 3,
																																																																																																																																z + 1)).getBlock() == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlockState(new BlockPos(
																																																																																																																																	x
																																																																																																																																			+ -2,
																																																																																																																																	y + 3,
																																																																																																																																	z + 2)).getBlock() == Blocks.air) {
																																																																																																																														return true;
																																																																																																																													}
																																																																																																																												}
																																																																																																																											}
																																																																																																																										}
																																																																																																																									}
																																																																																																																								}
																																																																																																																							}
																																																																																																																						}
																																																																																																																					}
																																																																																																																				}
																																																																																																																			}
																																																																																																																		}
																																																																																																																	}
																																																																																																																}
																																																																																																															}
																																																																																																														}
																																																																																																													}
																																																																																																												}
																																																																																																											}
																																																																																																										}
																																																																																																									}
																																																																																																								}
																																																																																																							}
																																																																																																						}
																																																																																																					}
																																																																																																				}
																																																																																																			}
																																																																																																		}
																																																																																																	}
																																																																																																}
																																																																																															}
																																																																																														}
																																																																																													}
																																																																																												}
																																																																																											}
																																																																																										}
																																																																																									}
																																																																																								}
																																																																																							}
																																																																																						}
																																																																																					}
																																																																																				}
																																																																																			}
																																																																																		}
																																																																																	}
																																																																																}
																																																																															}
																																																																														}
																																																																													}
																																																																												}
																																																																											}
																																																																										}
																																																																									}
																																																																								}
																																																																							}
																																																																						}
																																																																					}
																																																																				}
																																																																			}
																																																																		}
																																																																	}
																																																																}
																																																															}
																																																														}
																																																													}
																																																												}
																																																											}
																																																										}
																																																									}
																																																								}
																																																							}
																																																						}
																																																					}
																																																				}
																																																			}
																																																		}
																																																	}
																																																}
																																															}
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkWest(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 2, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
			if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
				if (world.getBlockState(new BlockPos(x + 0, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
					if (world.getBlockState(new BlockPos(x + -1, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
						if (world.getBlockState(new BlockPos(x + -2, y + -1, z + 2)).getBlock() == FaithCraft2.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + 2, y + 0, z + 2)).getBlock() == Blocks.air) {
								if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 2)).getBlock() == Blocks.air) {
									if (world.getBlockState(new BlockPos(x + 0, y + 0, z + 2)).getBlock() == Blocks.air) {
										if (world.getBlockState(new BlockPos(x + -1, y + 0,
												z + 2)).getBlock() == Blocks.air) {
											if (world.getBlockState(new BlockPos(x + -2, y + 0,
													z + 2)).getBlock() == Blocks.air) {
												if (world.getBlockState(new BlockPos(x + 2,
														y + 1, z + 2)).getBlock() == Blocks.air) {
													if (world.getBlockState(new BlockPos(x + 1,
															y + 1, z + 2)).getBlock() == Blocks.air) {
														if (world.getBlockState(new BlockPos(
																x + 0, y + 1,
																z + 2)).getBlock() == Blocks.air) {
															if (world
																	.getBlockState(new BlockPos(
																			x
																					+ -1,
																			y + 1,
																			z + 2)).getBlock() == Blocks.air) {
																if (world
																		.getBlockState(new BlockPos(
																				x
																						+ -2,
																				y + 1,
																				z + 2)).getBlock() == Blocks.air) {
																	if (world
																			.getBlockState(new BlockPos(
																					x + 2,
																					y + 2,
																					z + 2)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x + 1,
																						y + 2,
																						z + 2)).getBlock() == Blocks.air) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 0,
																							y + 2,
																							z + 2)).getBlock() == Blocks.air) {
																				if (world
																						.getBlockState(new BlockPos(
																								x
																										+ -1,
																								y + 2,
																								z + 2)).getBlock() == Blocks.air) {
																					if (world
																							.getBlockState(new BlockPos(
																									x
																											+ -2,
																									y + 2,
																									z + 2)).getBlock() == Blocks.air) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 2,
																										y + 3,
																										z + 2)).getBlock() == Blocks.air) {
																							if (world
																									.getBlockState(new BlockPos(
																											x + 1,
																											y + 3,
																											z + 2)).getBlock() == Blocks.air) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 0,
																												y + 3,
																												z + 2)).getBlock() == Blocks.air) {
																									if (world
																											.getBlockState(new BlockPos(
																													x
																															+ -1,
																													y + 3,
																													z + 2)).getBlock() == Blocks.air) {
																										if (world
																												.getBlockState(new BlockPos(
																														x
																																+ -2,
																														y + 3,
																														z + 2)).getBlock() == Blocks.air) {
																											if (world
																													.getBlockState(new BlockPos(
																															x + 2,
																															y
																																	+ -1,
																															z + 1)).getBlock() == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlockState(new BlockPos(
																																x + 1,
																																y
																																		+ -1,
																																z + 1)).getBlock() == FaithCraft2.wineBlock) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x + 0,
																																	y
																																			+ -1,
																																	z + 1)).getBlock() == FaithCraft2.wineBlock) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x
																																				+ -1,
																																		y
																																				+ -1,
																																		z + 1)).getBlock() == FaithCraft2.wineBlock) {
																															if (world
																																	.getBlockState(new BlockPos(
																																			x
																																					+ -2,
																																			y
																																					+ -1,
																																			z + 1)).getBlock() == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlockState(new BlockPos(
																																				x + 2,
																																				y + 0,
																																				z + 1)).getBlock() == Blocks.air) {
																																	if (world
																																			.getBlockState(new BlockPos(
																																					x + 1,
																																					y + 0,
																																					z + 1)).getBlock() == Blocks.air) {
																																		if (world
																																				.getBlockState(new BlockPos(
																																						x + 0,
																																						y + 0,
																																						z + 1)).getBlock() == Blocks.air) {
																																			if (world
																																					.getBlockState(new BlockPos(
																																							x
																																									+ -1,
																																							y + 0,
																																							z + 1)).getBlock() == Blocks.air) {
																																				if (world
																																						.getBlockState(new BlockPos(
																																								x
																																										+ -2,
																																								y + 0,
																																								z + 1)).getBlock() == Blocks.air) {
																																					if (world
																																							.getBlockState(new BlockPos(
																																									x + 2,
																																									y + 1,
																																									z + 1)).getBlock() == Blocks.air) {
																																						if (world
																																								.getBlockState(new BlockPos(
																																										x + 1,
																																										y + 1,
																																										z + 1)).getBlock() == Blocks.air) {
																																							if (world
																																									.getBlockState(new BlockPos(
																																											x + 0,
																																											y + 1,
																																											z + 1)).getBlock() == Blocks.air) {
																																								if (world
																																										.getBlockState(new BlockPos(
																																												x
																																														+ -1,
																																												y + 1,
																																												z + 1)).getBlock() == Blocks.air) {
																																									if (world
																																											.getBlockState(new BlockPos(
																																													x
																																															+ -2,
																																													y + 1,
																																													z + 1)).getBlock() == Blocks.air) {
																																										if (world
																																												.getBlockState(new BlockPos(
																																														x + 2,
																																														y + 2,
																																														z + 1)).getBlock() == Blocks.air) {
																																											if (world
																																													.getBlockState(new BlockPos(
																																															x + 1,
																																															y + 2,
																																															z + 1)).getBlock() == Blocks.air) {
																																												if (world
																																														.getBlockState(new BlockPos(
																																																x + 0,
																																																y + 2,
																																																z + 1)).getBlock() == Blocks.air) {
																																													if (world
																																															.getBlockState(new BlockPos(
																																																	x
																																																			+ -1,
																																																	y + 2,
																																																	z + 1)).getBlock() == Blocks.air) {
																																														if (world
																																																.getBlockState(new BlockPos(
																																																		x
																																																				+ -2,
																																																		y + 2,
																																																		z + 1)).getBlock() == Blocks.air) {
																																															if (world
																																																	.getBlockState(new BlockPos(
																																																			x + 2,
																																																			y + 3,
																																																			z + 1)).getBlock() == Blocks.air) {
																																																if (world
																																																		.getBlockState(new BlockPos(
																																																				x + 1,
																																																				y + 3,
																																																				z + 1)).getBlock() == Blocks.air) {
																																																	if (world
																																																			.getBlockState(new BlockPos(
																																																					x + 0,
																																																					y + 3,
																																																					z + 1)).getBlock() == Blocks.air) {
																																																		if (world
																																																				.getBlockState(new BlockPos(
																																																						x
																																																								+ -1,
																																																						y + 3,
																																																						z + 1)).getBlock() == Blocks.air) {
																																																			if (world
																																																					.getBlockState(new BlockPos(
																																																							x
																																																									+ -2,
																																																							y + 3,
																																																							z + 1)).getBlock() == Blocks.air) {
																																																				if (world
																																																						.getBlockState(new BlockPos(
																																																								x + 2,
																																																								y
																																																										+ -1,
																																																								z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlockState(new BlockPos(
																																																									x + 1,
																																																									y
																																																											+ -1,
																																																									z + 0)).getBlock() == FaithCraft2.wineBlock) {
																																																						if (world
																																																								.getBlockState(new BlockPos(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlockState(new BlockPos(
																																																											x
																																																													+ -1,
																																																											y
																																																													+ -1,
																																																											z + 0)).getBlock() == FaithCraft2.wineBlock) {
																																																								if (world
																																																										.getBlockState(new BlockPos(
																																																												x
																																																														+ -2,
																																																												y
																																																														+ -1,
																																																												z + 0)).getBlock() == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlockState(new BlockPos(
																																																													x + 2,
																																																													y + 0,
																																																													z + 0)).getBlock() == Blocks.air) {
																																																										if (world
																																																												.getBlockState(new BlockPos(
																																																														x + 1,
																																																														y + 0,
																																																														z + 0)).getBlock() == Blocks.air) {
																																																											if (world
																																																													.getBlockState(new BlockPos(
																																																															x
																																																																	+ -1,
																																																															y + 0,
																																																															z + 0)).getBlock() == Blocks.air) {
																																																												if (world
																																																														.getBlockState(new BlockPos(
																																																																x
																																																																		+ -2,
																																																																y + 0,
																																																																z + 0)).getBlock() == Blocks.air) {
																																																													if (world
																																																															.getBlockState(new BlockPos(
																																																																	x + 2,
																																																																	y + 1,
																																																																	z + 0)).getBlock() == Blocks.air) {
																																																														if (world
																																																																.getBlockState(new BlockPos(
																																																																		x + 1,
																																																																		y + 1,
																																																																		z + 0)).getBlock() == Blocks.air) {
																																																															if (world
																																																																	.getBlockState(new BlockPos(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0)).getBlock() == Blocks.air) {
																																																																if (world
																																																																		.getBlockState(new BlockPos(
																																																																				x
																																																																						+ -1,
																																																																				y + 1,
																																																																				z + 0)).getBlock() == Blocks.air) {
																																																																	if (world
																																																																			.getBlockState(new BlockPos(
																																																																					x
																																																																							+ -2,
																																																																					y + 1,
																																																																					z + 0)).getBlock() == Blocks.air) {
																																																																		if (world
																																																																				.getBlockState(new BlockPos(
																																																																						x + 2,
																																																																						y + 2,
																																																																						z + 0)).getBlock() == Blocks.air) {
																																																																			if (world
																																																																					.getBlockState(new BlockPos(
																																																																							x + 1,
																																																																							y + 2,
																																																																							z + 0)).getBlock() == Blocks.air) {
																																																																				if (world
																																																																						.getBlockState(new BlockPos(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0)).getBlock() == Blocks.air) {
																																																																					if (world
																																																																							.getBlockState(new BlockPos(
																																																																									x
																																																																											+ -1,
																																																																									y + 2,
																																																																									z + 0)).getBlock() == Blocks.air) {
																																																																						if (world
																																																																								.getBlockState(new BlockPos(
																																																																										x
																																																																												+ -2,
																																																																										y + 2,
																																																																										z + 0)).getBlock() == Blocks.air) {
																																																																							if (world
																																																																									.getBlockState(new BlockPos(
																																																																											x + 2,
																																																																											y + 3,
																																																																											z + 0)).getBlock() == Blocks.air) {
																																																																								if (world
																																																																										.getBlockState(new BlockPos(
																																																																												x + 1,
																																																																												y + 3,
																																																																												z + 0)).getBlock() == Blocks.air) {
																																																																									if (world
																																																																											.getBlockState(new BlockPos(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0)).getBlock() == Blocks.air) {
																																																																										if (world
																																																																												.getBlockState(new BlockPos(
																																																																														x
																																																																																+ -1,
																																																																														y + 3,
																																																																														z + 0)).getBlock() == Blocks.air) {
																																																																											if (world
																																																																													.getBlockState(new BlockPos(
																																																																															x
																																																																																	+ -2,
																																																																															y + 3,
																																																																															z + 0)).getBlock() == Blocks.air) {
																																																																												if (world
																																																																														.getBlockState(new BlockPos(
																																																																																x + 2,
																																																																																y
																																																																																		+ -1,
																																																																																z
																																																																																		+ -1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlockState(new BlockPos(
																																																																																	x + 1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z
																																																																																			+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x + 0,
																																																																																		y
																																																																																				+ -1,
																																																																																		z
																																																																																				+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x
																																																																																					+ -1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z
																																																																																					+ -1)).getBlock() == FaithCraft2.wineBlock) {
																																																																																if (world
																																																																																		.getBlockState(new BlockPos(
																																																																																				x
																																																																																						+ -2,
																																																																																				y
																																																																																						+ -1,
																																																																																				z
																																																																																						+ -1)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlockState(new BlockPos(
																																																																																					x + 2,
																																																																																					y + 0,
																																																																																					z
																																																																																							+ -1)).getBlock() == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlockState(new BlockPos(
																																																																																						x + 1,
																																																																																						y + 0,
																																																																																						z
																																																																																								+ -1)).getBlock() == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlockState(new BlockPos(
																																																																																							x + 0,
																																																																																							y + 0,
																																																																																							z
																																																																																									+ -1)).getBlock() == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlockState(new BlockPos(
																																																																																								x
																																																																																										+ -1,
																																																																																								y + 0,
																																																																																								z
																																																																																										+ -1)).getBlock() == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlockState(new BlockPos(
																																																																																									x
																																																																																											+ -2,
																																																																																									y + 0,
																																																																																									z
																																																																																											+ -1)).getBlock() == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlockState(new BlockPos(
																																																																																										x + 2,
																																																																																										y + 1,
																																																																																										z
																																																																																												+ -1)).getBlock() == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlockState(new BlockPos(
																																																																																											x + 1,
																																																																																											y + 1,
																																																																																											z
																																																																																													+ -1)).getBlock() == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlockState(new BlockPos(
																																																																																												x + 0,
																																																																																												y + 1,
																																																																																												z
																																																																																														+ -1)).getBlock() == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlockState(new BlockPos(
																																																																																													x
																																																																																															+ -1,
																																																																																													y + 1,
																																																																																													z
																																																																																															+ -1)).getBlock() == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlockState(new BlockPos(
																																																																																														x
																																																																																																+ -2,
																																																																																														y + 1,
																																																																																														z
																																																																																																+ -1)).getBlock() == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlockState(new BlockPos(
																																																																																															x + 2,
																																																																																															y + 2,
																																																																																															z
																																																																																																	+ -1)).getBlock() == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlockState(new BlockPos(
																																																																																																x + 1,
																																																																																																y + 2,
																																																																																																z
																																																																																																		+ -1)).getBlock() == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlockState(new BlockPos(
																																																																																																	x + 0,
																																																																																																	y + 2,
																																																																																																	z
																																																																																																			+ -1)).getBlock() == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlockState(new BlockPos(
																																																																																																		x
																																																																																																				+ -1,
																																																																																																		y + 2,
																																																																																																		z
																																																																																																				+ -1)).getBlock() == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlockState(new BlockPos(
																																																																																																			x
																																																																																																					+ -2,
																																																																																																			y + 2,
																																																																																																			z
																																																																																																					+ -1)).getBlock() == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlockState(new BlockPos(
																																																																																																				x + 2,
																																																																																																				y + 3,
																																																																																																				z
																																																																																																						+ -1)).getBlock() == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlockState(new BlockPos(
																																																																																																					x + 1,
																																																																																																					y + 3,
																																																																																																					z
																																																																																																							+ -1)).getBlock() == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlockState(new BlockPos(
																																																																																																						x + 0,
																																																																																																						y + 3,
																																																																																																						z
																																																																																																								+ -1)).getBlock() == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlockState(new BlockPos(
																																																																																																							x
																																																																																																									+ -1,
																																																																																																							y + 3,
																																																																																																							z
																																																																																																									+ -1)).getBlock() == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlockState(new BlockPos(
																																																																																																								x
																																																																																																										+ -2,
																																																																																																								y + 3,
																																																																																																								z
																																																																																																										+ -1)).getBlock() == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlockState(new BlockPos(
																																																																																																									x + 2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z
																																																																																																											+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlockState(new BlockPos(
																																																																																																										x + 1,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z
																																																																																																												+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlockState(new BlockPos(
																																																																																																											x + 0,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z
																																																																																																													+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlockState(new BlockPos(
																																																																																																												x
																																																																																																														+ -1,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z
																																																																																																														+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlockState(new BlockPos(
																																																																																																													x
																																																																																																															+ -2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z
																																																																																																															+ -2)).getBlock() == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlockState(new BlockPos(
																																																																																																														x + 2,
																																																																																																														y + 0,
																																																																																																														z
																																																																																																																+ -2)).getBlock() == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlockState(new BlockPos(
																																																																																																															x + 1,
																																																																																																															y + 0,
																																																																																																															z
																																																																																																																	+ -2)).getBlock() == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlockState(new BlockPos(
																																																																																																																x + 0,
																																																																																																																y + 0,
																																																																																																																z
																																																																																																																		+ -2)).getBlock() == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlockState(new BlockPos(
																																																																																																																	x
																																																																																																																			+ -1,
																																																																																																																	y + 0,
																																																																																																																	z
																																																																																																																			+ -2)).getBlock() == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlockState(new BlockPos(
																																																																																																																		x
																																																																																																																				+ -2,
																																																																																																																		y + 0,
																																																																																																																		z
																																																																																																																				+ -2)).getBlock() == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlockState(new BlockPos(
																																																																																																																			x + 2,
																																																																																																																			y + 1,
																																																																																																																			z
																																																																																																																					+ -2)).getBlock() == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlockState(new BlockPos(
																																																																																																																				x + 1,
																																																																																																																				y + 1,
																																																																																																																				z
																																																																																																																						+ -2)).getBlock() == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlockState(new BlockPos(
																																																																																																																					x + 0,
																																																																																																																					y + 1,
																																																																																																																					z
																																																																																																																							+ -2)).getBlock() == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlockState(new BlockPos(
																																																																																																																						x
																																																																																																																								+ -1,
																																																																																																																						y + 1,
																																																																																																																						z
																																																																																																																								+ -2)).getBlock() == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlockState(new BlockPos(
																																																																																																																							x
																																																																																																																									+ -2,
																																																																																																																							y + 1,
																																																																																																																							z
																																																																																																																									+ -2)).getBlock() == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlockState(new BlockPos(
																																																																																																																								x + 2,
																																																																																																																								y + 2,
																																																																																																																								z
																																																																																																																										+ -2)).getBlock() == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlockState(new BlockPos(
																																																																																																																									x + 1,
																																																																																																																									y + 2,
																																																																																																																									z
																																																																																																																											+ -2)).getBlock() == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlockState(new BlockPos(
																																																																																																																										x + 0,
																																																																																																																										y + 2,
																																																																																																																										z
																																																																																																																												+ -2)).getBlock() == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlockState(new BlockPos(
																																																																																																																											x
																																																																																																																													+ -1,
																																																																																																																											y + 2,
																																																																																																																											z
																																																																																																																													+ -2)).getBlock() == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlockState(new BlockPos(
																																																																																																																												x
																																																																																																																														+ -2,
																																																																																																																												y + 2,
																																																																																																																												z
																																																																																																																														+ -2)).getBlock() == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlockState(new BlockPos(
																																																																																																																													x + 2,
																																																																																																																													y + 3,
																																																																																																																													z
																																																																																																																															+ -2)).getBlock() == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlockState(new BlockPos(
																																																																																																																														x + 1,
																																																																																																																														y + 3,
																																																																																																																														z
																																																																																																																																+ -2)).getBlock() == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlockState(new BlockPos(
																																																																																																																															x + 0,
																																																																																																																															y + 3,
																																																																																																																															z
																																																																																																																																	+ -2)).getBlock() == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlockState(new BlockPos(
																																																																																																																																x
																																																																																																																																		+ -1,
																																																																																																																																y + 3,
																																																																																																																																z
																																																																																																																																		+ -2)).getBlock() == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlockState(new BlockPos(
																																																																																																																																	x
																																																																																																																																			+ -2,
																																																																																																																																	y + 3,
																																																																																																																																	z
																																																																																																																																			+ -2)).getBlock() == Blocks.air) {
																																																																																																																														return true;
																																																																																																																													}
																																																																																																																												}
																																																																																																																											}
																																																																																																																										}
																																																																																																																									}
																																																																																																																								}
																																																																																																																							}
																																																																																																																						}
																																																																																																																					}
																																																																																																																				}
																																																																																																																			}
																																																																																																																		}
																																																																																																																	}
																																																																																																																}
																																																																																																															}
																																																																																																														}
																																																																																																													}
																																																																																																												}
																																																																																																											}
																																																																																																										}
																																																																																																									}
																																																																																																								}
																																																																																																							}
																																																																																																						}
																																																																																																					}
																																																																																																				}
																																																																																																			}
																																																																																																		}
																																																																																																	}
																																																																																																}
																																																																																															}
																																																																																														}
																																																																																													}
																																																																																												}
																																																																																											}
																																																																																										}
																																																																																									}
																																																																																								}
																																																																																							}
																																																																																						}
																																																																																					}
																																																																																				}
																																																																																			}
																																																																																		}
																																																																																	}
																																																																																}
																																																																															}
																																																																														}
																																																																													}
																																																																												}
																																																																											}
																																																																										}
																																																																									}
																																																																								}
																																																																							}
																																																																						}
																																																																					}
																																																																				}
																																																																			}
																																																																		}
																																																																	}
																																																																}
																																																															}
																																																														}
																																																													}
																																																												}
																																																											}
																																																										}
																																																									}
																																																								}
																																																							}
																																																						}
																																																					}
																																																				}
																																																			}
																																																		}
																																																	}
																																																}
																																															}
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAltar();
	}
	
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
	
	public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityAltar)
            {
                ((TileEntityAltar)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(FaithCraft2.Altar);
    }
	
	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.north()).getBlock();
            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(FaithCraft2.Altar);
    }
	
	 @SideOnly(Side.CLIENT)

	    static final class SwitchEnumFacing
	        {
	            static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];

	            static
	            {
	                try
	                {
	                    FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 1;
	                }
	                catch (NoSuchFieldError var4)
	                {
	                    ;
	                }

	                try
	                {
	                    FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
	                }
	                catch (NoSuchFieldError var3)
	                {
	                    ;
	                }

	                try
	                {
	                    FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
	                }
	                catch (NoSuchFieldError var2)
	                {
	                    ;
	                }

	                try
	                {
	                    FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
	                }
	                catch (NoSuchFieldError var1)
	                {
	                    ;
	                }
	            }
	        }
	
}