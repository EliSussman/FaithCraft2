package FaithCraft2.Common.common.blocks;

import FaithCraft2.Common.common.FaithCraft2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class Altar extends Block{
	
	private final String name = "Altar";
	
	public Altar(Material material) {
		super(material);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(7F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
	}
	
	public String getName(){
		return name;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(!worldIn.isRemote && isMultiBlockStructure(worldIn, x, y, z)){
			System.out.println("Hello1");
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
																																z + 1)).getBlock() == Blocks.water) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x
																																			+ -1,
																																	y
																																			+ -1,
																																	z + 0)).getBlock() == Blocks.water) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x
																																				+ -1,
																																		y
																																				+ -1,
																																		z
																																				+ -1)).getBlock() == Blocks.water) {
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
																																																									z + 1)).getBlock() == Blocks.water) {
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
																																																													+ -1)).getBlock() == Blocks.water) {
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
																																																																																	z + 1)).getBlock() == Blocks.water) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x + 1,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 0)).getBlock() == Blocks.water) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x + 1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z
																																																																																					+ -1)).getBlock() == Blocks.water) {
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
																																		+ -1)).getBlock() == Blocks.water) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x + 0,
																																	y
																																			+ -1,
																																	z
																																			+ -1)).getBlock() == Blocks.water) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x + 1,
																																		y
																																				+ -1,
																																		z
																																				+ -1)).getBlock() == Blocks.water) {
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
																																																									z + 0)).getBlock() == Blocks.water) {
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
																																																											z + 0)).getBlock() == Blocks.water) {
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
																																																																																	z + 1)).getBlock() == Blocks.water) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x + 0,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 1)).getBlock() == Blocks.water) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x + 1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z + 1)).getBlock() == Blocks.water) {
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
																																		+ -1)).getBlock() == Blocks.water) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x + 1,
																																	y
																																			+ -1,
																																	z + 0)).getBlock() == Blocks.water) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x + 1,
																																		y
																																				+ -1,
																																		z + 1)).getBlock() == Blocks.water) {
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
																																																											+ -1)).getBlock() == Blocks.water) {
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
																																																											z + 1)).getBlock() == Blocks.water) {
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
																																																																																			+ -1)).getBlock() == Blocks.water) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x
																																																																																				+ -1,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 0)).getBlock() == Blocks.water) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x
																																																																																					+ -1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z + 1)).getBlock() == Blocks.water) {
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
																																z + 1)).getBlock() == Blocks.water) {
																													if (world
																															.getBlockState(new BlockPos(
																																	x + 0,
																																	y
																																			+ -1,
																																	z + 1)).getBlock() == Blocks.water) {
																														if (world
																																.getBlockState(new BlockPos(
																																		x
																																				+ -1,
																																		y
																																				+ -1,
																																		z + 1)).getBlock() == Blocks.water) {
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
																																																									z + 0)).getBlock() == Blocks.water) {
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
																																																											z + 0)).getBlock() == Blocks.water) {
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
																																																																																			+ -1)).getBlock() == Blocks.water) {
																																																																														if (world
																																																																																.getBlockState(new BlockPos(
																																																																																		x + 0,
																																																																																		y
																																																																																				+ -1,
																																																																																		z
																																																																																				+ -1)).getBlock() == Blocks.water) {
																																																																															if (world
																																																																																	.getBlockState(new BlockPos(
																																																																																			x
																																																																																					+ -1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z
																																																																																					+ -1)).getBlock() == Blocks.water) {
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
	
}