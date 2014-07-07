package FaithCraft2.Common.common.blocks;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;

public class Altar extends BlockContainer{

	public Altar(Material material) {
		super(material);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(5F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
	}
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote && isMultiBlockStructure(world, x, y, z)) {
			FMLNetworkHandler.openGui(player, FaithCraft2.instance, FaithCraft2.guiIDAltar, world, x, y, z);
			System.out.println("Hello Eli");
		}
		return true;
	}
	
	public void onBlockAdded(World world, int x,int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if(b1.func_149730_j() && b2.func_149730_j()) {
				b0 = 3;
			}
			
			if(b2.func_149730_j() && b1.func_149730_j()) {
				b0 = 2;
			}
			
			if(b3.func_149730_j() && b4.func_149730_j()) {
				b0 = 5;
			}
			
			if(b4.func_149730_j() && b3.func_149730_j()) {
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAltar();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(l == 0){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if(l == 1){
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		
		if(l == 2){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(l == 3){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

	}
	
	public boolean isMultiBlockStructure(World world, int x, int y, int z) {
		if (checkNorth(world, x, y, z))/* North */
			return true;
		if (checkEast(world, x, y, z))/* East */
			return true;
		if (checkSouth(world, x, y, z))/* South */
			return true;
		if (checkWest(world, x, y, z))/* West */
			return true;
		return false;
	}

	private static boolean checkNorth(World world, int x, int y, int z) {
		if (world.getBlock(x + -2, y + -1, z + 2) == FaithCraft2.HolyBlock) {
			if (world.getBlock(x + -2, y + -1, z + 1) == FaithCraft2.HolyBlock) {
				if (world.getBlock(x + -2, y + -1, z + 0) == FaithCraft2.HolyBlock) {
					if (world.getBlock(x + -2, y + -1, z + -1) == FaithCraft2.HolyBlock) {
						if (world.getBlock(x + -2, y + -1, z + -2) == FaithCraft2.HolyBlock) {
							if (world.getBlock(x + -2, y + 0, z + 2) == Blocks.air) {
								if (world.getBlock(x + -2, y + 0, z + 1) == Blocks.air) {
									if (world.getBlock(x + -2, y + 0, z + 0) == Blocks.air) {
										if (world.getBlock(x + -2, y + 0, z
												+ -1) == Blocks.air) {
											if (world.getBlock(x + -2, y + 0,
													z + -2) == Blocks.air) {
												if (world.getBlock(x + -2,
														y + 1, z + 2) == Blocks.air) {
													if (world.getBlock(
															x + -2, y + 1,
															z + 1) == Blocks.air) {
														if (world.getBlock(x
																+ -2, y + 1,
																z + 0) == Blocks.air) {
															if (world
																	.getBlock(
																			x
																					+ -2,
																			y + 1,
																			z
																					+ -1) == Blocks.air) {
																if (world
																		.getBlock(
																				x
																						+ -2,
																				y + 1,
																				z
																						+ -2) == Blocks.air) {
																	if (world
																			.getBlock(
																					x
																							+ -2,
																					y + 2,
																					z + 2) == Blocks.air) {
																		if (world
																				.getBlock(
																						x
																								+ -2,
																						y + 2,
																						z + 1) == Blocks.air) {
																			if (world
																					.getBlock(
																							x
																									+ -2,
																							y + 2,
																							z + 0) == Blocks.air) {
																				if (world
																						.getBlock(
																								x
																										+ -2,
																								y + 2,
																								z
																										+ -1) == Blocks.air) {
																					if (world
																							.getBlock(
																									x
																											+ -2,
																									y + 2,
																									z
																											+ -2) == Blocks.air) {
																						if (world
																								.getBlock(
																										x
																												+ -2,
																										y + 3,
																										z + 2) == Blocks.air) {
																							if (world
																									.getBlock(
																											x
																													+ -2,
																											y + 3,
																											z + 1) == Blocks.air) {
																								if (world
																										.getBlock(
																												x
																														+ -2,
																												y + 3,
																												z + 0) == Blocks.air) {
																									if (world
																											.getBlock(
																													x
																															+ -2,
																													y + 3,
																													z
																															+ -1) == Blocks.air) {
																										if (world
																												.getBlock(
																														x
																																+ -2,
																														y + 3,
																														z
																																+ -2) == Blocks.air) {
																											if (world
																													.getBlock(
																															x
																																	+ -1,
																															y
																																	+ -1,
																															z + 2) == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlock(
																																x
																																		+ -1,
																																y
																																		+ -1,
																																z + 1) == FaithCraft2.WineBlock) {
																													if (world
																															.getBlock(
																																	x
																																			+ -1,
																																	y
																																			+ -1,
																																	z + 0) == FaithCraft2.WineBlock) {
																														if (world
																																.getBlock(
																																		x
																																				+ -1,
																																		y
																																				+ -1,
																																		z
																																				+ -1) == FaithCraft2.WineBlock) {
																															if (world
																																	.getBlock(
																																			x
																																					+ -1,
																																			y
																																					+ -1,
																																			z
																																					+ -2) == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlock(
																																				x
																																						+ -1,
																																				y + 0,
																																				z + 2) == Blocks.air) {
																																	if (world
																																			.getBlock(
																																					x
																																							+ -1,
																																					y + 0,
																																					z + 1) == Blocks.air) {
																																		if (world
																																				.getBlock(
																																						x
																																								+ -1,
																																						y + 0,
																																						z + 0) == Blocks.air) {
																																			if (world
																																					.getBlock(
																																							x
																																									+ -1,
																																							y + 0,
																																							z
																																									+ -1) == Blocks.air) {
																																				if (world
																																						.getBlock(
																																								x
																																										+ -1,
																																								y + 0,
																																								z
																																										+ -2) == Blocks.air) {
																																					if (world
																																							.getBlock(
																																									x
																																											+ -1,
																																									y + 1,
																																									z + 2) == Blocks.air) {
																																						if (world
																																								.getBlock(
																																										x
																																												+ -1,
																																										y + 1,
																																										z + 1) == Blocks.air) {
																																							if (world
																																									.getBlock(
																																											x
																																													+ -1,
																																											y + 1,
																																											z + 0) == Blocks.air) {
																																								if (world
																																										.getBlock(
																																												x
																																														+ -1,
																																												y + 1,
																																												z
																																														+ -1) == Blocks.air) {
																																									if (world
																																											.getBlock(
																																													x
																																															+ -1,
																																													y + 1,
																																													z
																																															+ -2) == Blocks.air) {
																																										if (world
																																												.getBlock(
																																														x
																																																+ -1,
																																														y + 2,
																																														z + 2) == Blocks.air) {
																																											if (world
																																													.getBlock(
																																															x
																																																	+ -1,
																																															y + 2,
																																															z + 1) == Blocks.air) {
																																												if (world
																																														.getBlock(
																																																x
																																																		+ -1,
																																																y + 2,
																																																z + 0) == Blocks.air) {
																																													if (world
																																															.getBlock(
																																																	x
																																																			+ -1,
																																																	y + 2,
																																																	z
																																																			+ -1) == Blocks.air) {
																																														if (world
																																																.getBlock(
																																																		x
																																																				+ -1,
																																																		y + 2,
																																																		z
																																																				+ -2) == Blocks.air) {
																																															if (world
																																																	.getBlock(
																																																			x
																																																					+ -1,
																																																			y + 3,
																																																			z + 2) == Blocks.air) {
																																																if (world
																																																		.getBlock(
																																																				x
																																																						+ -1,
																																																				y + 3,
																																																				z + 1) == Blocks.air) {
																																																	if (world
																																																			.getBlock(
																																																					x
																																																							+ -1,
																																																					y + 3,
																																																					z + 0) == Blocks.air) {
																																																		if (world
																																																				.getBlock(
																																																						x
																																																								+ -1,
																																																						y + 3,
																																																						z
																																																								+ -1) == Blocks.air) {
																																																			if (world
																																																					.getBlock(
																																																							x
																																																									+ -1,
																																																							y + 3,
																																																							z
																																																									+ -2) == Blocks.air) {
																																																				if (world
																																																						.getBlock(
																																																								x + 0,
																																																								y
																																																										+ -1,
																																																								z + 2) == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlock(
																																																									x + 0,
																																																									y
																																																											+ -1,
																																																									z + 1) == FaithCraft2.WineBlock) {
																																																						if (world
																																																								.getBlock(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0) == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlock(
																																																											x + 0,
																																																											y
																																																													+ -1,
																																																											z
																																																													+ -1) == FaithCraft2.WineBlock) {
																																																								if (world
																																																										.getBlock(
																																																												x + 0,
																																																												y
																																																														+ -1,
																																																												z
																																																														+ -2) == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlock(
																																																													x + 0,
																																																													y + 0,
																																																													z + 2) == Blocks.air) {
																																																										if (world
																																																												.getBlock(
																																																														x + 0,
																																																														y + 0,
																																																														z + 1) == Blocks.air) {
																																																											if (world
																																																													.getBlock(
																																																															x + 0,
																																																															y + 0,
																																																															z
																																																																	+ -1) == Blocks.air) {
																																																												if (world
																																																														.getBlock(
																																																																x + 0,
																																																																y + 0,
																																																																z
																																																																		+ -2) == Blocks.air) {
																																																													if (world
																																																															.getBlock(
																																																																	x + 0,
																																																																	y + 1,
																																																																	z + 2) == Blocks.air) {
																																																														if (world
																																																																.getBlock(
																																																																		x + 0,
																																																																		y + 1,
																																																																		z + 1) == Blocks.air) {
																																																															if (world
																																																																	.getBlock(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0) == Blocks.air) {
																																																																if (world
																																																																		.getBlock(
																																																																				x + 0,
																																																																				y + 1,
																																																																				z
																																																																						+ -1) == Blocks.air) {
																																																																	if (world
																																																																			.getBlock(
																																																																					x + 0,
																																																																					y + 1,
																																																																					z
																																																																							+ -2) == Blocks.air) {
																																																																		if (world
																																																																				.getBlock(
																																																																						x + 0,
																																																																						y + 2,
																																																																						z + 2) == Blocks.air) {
																																																																			if (world
																																																																					.getBlock(
																																																																							x + 0,
																																																																							y + 2,
																																																																							z + 1) == Blocks.air) {
																																																																				if (world
																																																																						.getBlock(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0) == Blocks.air) {
																																																																					if (world
																																																																							.getBlock(
																																																																									x + 0,
																																																																									y + 2,
																																																																									z
																																																																											+ -1) == Blocks.air) {
																																																																						if (world
																																																																								.getBlock(
																																																																										x + 0,
																																																																										y + 2,
																																																																										z
																																																																												+ -2) == Blocks.air) {
																																																																							if (world
																																																																									.getBlock(
																																																																											x + 0,
																																																																											y + 3,
																																																																											z + 2) == Blocks.air) {
																																																																								if (world
																																																																										.getBlock(
																																																																												x + 0,
																																																																												y + 3,
																																																																												z + 1) == Blocks.air) {
																																																																									if (world
																																																																											.getBlock(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0) == Blocks.air) {
																																																																										if (world
																																																																												.getBlock(
																																																																														x + 0,
																																																																														y + 3,
																																																																														z
																																																																																+ -1) == Blocks.air) {
																																																																											if (world
																																																																													.getBlock(
																																																																															x + 0,
																																																																															y + 3,
																																																																															z
																																																																																	+ -2) == Blocks.air) {
																																																																												if (world
																																																																														.getBlock(
																																																																																x + 1,
																																																																																y
																																																																																		+ -1,
																																																																																z + 2) == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlock(
																																																																																	x + 1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z + 1) == FaithCraft2.WineBlock) {
																																																																														if (world
																																																																																.getBlock(
																																																																																		x + 1,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 0) == FaithCraft2.WineBlock) {
																																																																															if (world
																																																																																	.getBlock(
																																																																																			x + 1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z
																																																																																					+ -1) == FaithCraft2.WineBlock) {
																																																																																if (world
																																																																																		.getBlock(
																																																																																				x + 1,
																																																																																				y
																																																																																						+ -1,
																																																																																				z
																																																																																						+ -2) == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlock(
																																																																																					x + 1,
																																																																																					y + 0,
																																																																																					z + 2) == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlock(
																																																																																						x + 1,
																																																																																						y + 0,
																																																																																						z + 1) == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlock(
																																																																																							x + 1,
																																																																																							y + 0,
																																																																																							z + 0) == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlock(
																																																																																								x + 1,
																																																																																								y + 0,
																																																																																								z
																																																																																										+ -1) == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlock(
																																																																																									x + 1,
																																																																																									y + 0,
																																																																																									z
																																																																																											+ -2) == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlock(
																																																																																										x + 1,
																																																																																										y + 1,
																																																																																										z + 2) == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlock(
																																																																																											x + 1,
																																																																																											y + 1,
																																																																																											z + 1) == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlock(
																																																																																												x + 1,
																																																																																												y + 1,
																																																																																												z + 0) == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlock(
																																																																																													x + 1,
																																																																																													y + 1,
																																																																																													z
																																																																																															+ -1) == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlock(
																																																																																														x + 1,
																																																																																														y + 1,
																																																																																														z
																																																																																																+ -2) == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlock(
																																																																																															x + 1,
																																																																																															y + 2,
																																																																																															z + 2) == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlock(
																																																																																																x + 1,
																																																																																																y + 2,
																																																																																																z + 1) == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlock(
																																																																																																	x + 1,
																																																																																																	y + 2,
																																																																																																	z + 0) == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlock(
																																																																																																		x + 1,
																																																																																																		y + 2,
																																																																																																		z
																																																																																																				+ -1) == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlock(
																																																																																																			x + 1,
																																																																																																			y + 2,
																																																																																																			z
																																																																																																					+ -2) == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlock(
																																																																																																				x + 1,
																																																																																																				y + 3,
																																																																																																				z + 2) == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlock(
																																																																																																					x + 1,
																																																																																																					y + 3,
																																																																																																					z + 1) == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlock(
																																																																																																						x + 1,
																																																																																																						y + 3,
																																																																																																						z + 0) == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlock(
																																																																																																							x + 1,
																																																																																																							y + 3,
																																																																																																							z
																																																																																																									+ -1) == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlock(
																																																																																																								x + 1,
																																																																																																								y + 3,
																																																																																																								z
																																																																																																										+ -2) == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlock(
																																																																																																									x + 2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z + 2) == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlock(
																																																																																																										x + 2,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z + 1) == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlock(
																																																																																																											x + 2,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z + 0) == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlock(
																																																																																																												x + 2,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z
																																																																																																														+ -1) == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlock(
																																																																																																													x + 2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z
																																																																																																															+ -2) == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlock(
																																																																																																														x + 2,
																																																																																																														y + 0,
																																																																																																														z + 2) == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlock(
																																																																																																															x + 2,
																																																																																																															y + 0,
																																																																																																															z + 1) == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlock(
																																																																																																																x + 2,
																																																																																																																y + 0,
																																																																																																																z + 0) == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlock(
																																																																																																																	x + 2,
																																																																																																																	y + 0,
																																																																																																																	z
																																																																																																																			+ -1) == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlock(
																																																																																																																		x + 2,
																																																																																																																		y + 0,
																																																																																																																		z
																																																																																																																				+ -2) == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlock(
																																																																																																																			x + 2,
																																																																																																																			y + 1,
																																																																																																																			z + 2) == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlock(
																																																																																																																				x + 2,
																																																																																																																				y + 1,
																																																																																																																				z + 1) == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlock(
																																																																																																																					x + 2,
																																																																																																																					y + 1,
																																																																																																																					z + 0) == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlock(
																																																																																																																						x + 2,
																																																																																																																						y + 1,
																																																																																																																						z
																																																																																																																								+ -1) == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlock(
																																																																																																																							x + 2,
																																																																																																																							y + 1,
																																																																																																																							z
																																																																																																																									+ -2) == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlock(
																																																																																																																								x + 2,
																																																																																																																								y + 2,
																																																																																																																								z + 2) == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlock(
																																																																																																																									x + 2,
																																																																																																																									y + 2,
																																																																																																																									z + 1) == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlock(
																																																																																																																										x + 2,
																																																																																																																										y + 2,
																																																																																																																										z + 0) == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlock(
																																																																																																																											x + 2,
																																																																																																																											y + 2,
																																																																																																																											z
																																																																																																																													+ -1) == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlock(
																																																																																																																												x + 2,
																																																																																																																												y + 2,
																																																																																																																												z
																																																																																																																														+ -2) == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlock(
																																																																																																																													x + 2,
																																																																																																																													y + 3,
																																																																																																																													z + 2) == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlock(
																																																																																																																														x + 2,
																																																																																																																														y + 3,
																																																																																																																														z + 1) == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlock(
																																																																																																																															x + 2,
																																																																																																																															y + 3,
																																																																																																																															z + 0) == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlock(
																																																																																																																																x + 2,
																																																																																																																																y + 3,
																																																																																																																																z
																																																																																																																																		+ -1) == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlock(
																																																																																																																																	x + 2,
																																																																																																																																	y + 3,
																																																																																																																																	z
																																																																																																																																			+ -2) == Blocks.air) {
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
		if (world.getBlock(x + -2, y + -1, z + -2) == FaithCraft2.HolyBlock) {
			if (world.getBlock(x + -1, y + -1, z + -2) == FaithCraft2.HolyBlock) {
				if (world.getBlock(x + 0, y + -1, z + -2) == FaithCraft2.HolyBlock) {
					if (world.getBlock(x + 1, y + -1, z + -2) == FaithCraft2.HolyBlock) {
						if (world.getBlock(x + 2, y + -1, z + -2) == FaithCraft2.HolyBlock) {
							if (world.getBlock(x + -2, y + 0, z + -2) == Blocks.air) {
								if (world.getBlock(x + -1, y + 0, z + -2) == Blocks.air) {
									if (world.getBlock(x + 0, y + 0, z + -2) == Blocks.air) {
										if (world.getBlock(x + 1, y + 0, z
												+ -2) == Blocks.air) {
											if (world.getBlock(x + 2, y + 0,
													z + -2) == Blocks.air) {
												if (world.getBlock(x + -2,
														y + 1, z + -2) == Blocks.air) {
													if (world.getBlock(
															x + -1, y + 1, z
																	+ -2) == Blocks.air) {
														if (world.getBlock(
																x + 0, y + 1, z
																		+ -2) == Blocks.air) {
															if (world
																	.getBlock(
																			x + 1,
																			y + 1,
																			z
																					+ -2) == Blocks.air) {
																if (world
																		.getBlock(
																				x + 2,
																				y + 1,
																				z
																						+ -2) == Blocks.air) {
																	if (world
																			.getBlock(
																					x
																							+ -2,
																					y + 2,
																					z
																							+ -2) == Blocks.air) {
																		if (world
																				.getBlock(
																						x
																								+ -1,
																						y + 2,
																						z
																								+ -2) == Blocks.air) {
																			if (world
																					.getBlock(
																							x + 0,
																							y + 2,
																							z
																									+ -2) == Blocks.air) {
																				if (world
																						.getBlock(
																								x + 1,
																								y + 2,
																								z
																										+ -2) == Blocks.air) {
																					if (world
																							.getBlock(
																									x + 2,
																									y + 2,
																									z
																											+ -2) == Blocks.air) {
																						if (world
																								.getBlock(
																										x
																												+ -2,
																										y + 3,
																										z
																												+ -2) == Blocks.air) {
																							if (world
																									.getBlock(
																											x
																													+ -1,
																											y + 3,
																											z
																													+ -2) == Blocks.air) {
																								if (world
																										.getBlock(
																												x + 0,
																												y + 3,
																												z
																														+ -2) == Blocks.air) {
																									if (world
																											.getBlock(
																													x + 1,
																													y + 3,
																													z
																															+ -2) == Blocks.air) {
																										if (world
																												.getBlock(
																														x + 2,
																														y + 3,
																														z
																																+ -2) == Blocks.air) {
																											if (world
																													.getBlock(
																															x
																																	+ -2,
																															y
																																	+ -1,
																															z
																																	+ -1) == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlock(
																																x
																																		+ -1,
																																y
																																		+ -1,
																																z
																																		+ -1) == FaithCraft2.WineBlock) {
																													if (world
																															.getBlock(
																																	x + 0,
																																	y
																																			+ -1,
																																	z
																																			+ -1) == FaithCraft2.WineBlock) {
																														if (world
																																.getBlock(
																																		x + 1,
																																		y
																																				+ -1,
																																		z
																																				+ -1) == FaithCraft2.WineBlock) {
																															if (world
																																	.getBlock(
																																			x + 2,
																																			y
																																					+ -1,
																																			z
																																					+ -1) == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlock(
																																				x
																																						+ -2,
																																				y + 0,
																																				z
																																						+ -1) == Blocks.air) {
																																	if (world
																																			.getBlock(
																																					x
																																							+ -1,
																																					y + 0,
																																					z
																																							+ -1) == Blocks.air) {
																																		if (world
																																				.getBlock(
																																						x + 0,
																																						y + 0,
																																						z
																																								+ -1) == Blocks.air) {
																																			if (world
																																					.getBlock(
																																							x + 1,
																																							y + 0,
																																							z
																																									+ -1) == Blocks.air) {
																																				if (world
																																						.getBlock(
																																								x + 2,
																																								y + 0,
																																								z
																																										+ -1) == Blocks.air) {
																																					if (world
																																							.getBlock(
																																									x
																																											+ -2,
																																									y + 1,
																																									z
																																											+ -1) == Blocks.air) {
																																						if (world
																																								.getBlock(
																																										x
																																												+ -1,
																																										y + 1,
																																										z
																																												+ -1) == Blocks.air) {
																																							if (world
																																									.getBlock(
																																											x + 0,
																																											y + 1,
																																											z
																																													+ -1) == Blocks.air) {
																																								if (world
																																										.getBlock(
																																												x + 1,
																																												y + 1,
																																												z
																																														+ -1) == Blocks.air) {
																																									if (world
																																											.getBlock(
																																													x + 2,
																																													y + 1,
																																													z
																																															+ -1) == Blocks.air) {
																																										if (world
																																												.getBlock(
																																														x
																																																+ -2,
																																														y + 2,
																																														z
																																																+ -1) == Blocks.air) {
																																											if (world
																																													.getBlock(
																																															x
																																																	+ -1,
																																															y + 2,
																																															z
																																																	+ -1) == Blocks.air) {
																																												if (world
																																														.getBlock(
																																																x + 0,
																																																y + 2,
																																																z
																																																		+ -1) == Blocks.air) {
																																													if (world
																																															.getBlock(
																																																	x + 1,
																																																	y + 2,
																																																	z
																																																			+ -1) == Blocks.air) {
																																														if (world
																																																.getBlock(
																																																		x + 2,
																																																		y + 2,
																																																		z
																																																				+ -1) == Blocks.air) {
																																															if (world
																																																	.getBlock(
																																																			x
																																																					+ -2,
																																																			y + 3,
																																																			z
																																																					+ -1) == Blocks.air) {
																																																if (world
																																																		.getBlock(
																																																				x
																																																						+ -1,
																																																				y + 3,
																																																				z
																																																						+ -1) == Blocks.air) {
																																																	if (world
																																																			.getBlock(
																																																					x + 0,
																																																					y + 3,
																																																					z
																																																							+ -1) == Blocks.air) {
																																																		if (world
																																																				.getBlock(
																																																						x + 1,
																																																						y + 3,
																																																						z
																																																								+ -1) == Blocks.air) {
																																																			if (world
																																																					.getBlock(
																																																							x + 2,
																																																							y + 3,
																																																							z
																																																									+ -1) == Blocks.air) {
																																																				if (world
																																																						.getBlock(
																																																								x
																																																										+ -2,
																																																								y
																																																										+ -1,
																																																								z + 0) == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlock(
																																																									x
																																																											+ -1,
																																																									y
																																																											+ -1,
																																																									z + 0) == FaithCraft2.WineBlock) {
																																																						if (world
																																																								.getBlock(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0) == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlock(
																																																											x + 1,
																																																											y
																																																													+ -1,
																																																											z + 0) == FaithCraft2.WineBlock) {
																																																								if (world
																																																										.getBlock(
																																																												x + 2,
																																																												y
																																																														+ -1,
																																																												z + 0) == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlock(
																																																													x
																																																															+ -2,
																																																													y + 0,
																																																													z + 0) == Blocks.air) {
																																																										if (world
																																																												.getBlock(
																																																														x
																																																																+ -1,
																																																														y + 0,
																																																														z + 0) == Blocks.air) {
																																																											if (world
																																																													.getBlock(
																																																															x + 1,
																																																															y + 0,
																																																															z + 0) == Blocks.air) {
																																																												if (world
																																																														.getBlock(
																																																																x + 2,
																																																																y + 0,
																																																																z + 0) == Blocks.air) {
																																																													if (world
																																																															.getBlock(
																																																																	x
																																																																			+ -2,
																																																																	y + 1,
																																																																	z + 0) == Blocks.air) {
																																																														if (world
																																																																.getBlock(
																																																																		x
																																																																				+ -1,
																																																																		y + 1,
																																																																		z + 0) == Blocks.air) {
																																																															if (world
																																																																	.getBlock(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0) == Blocks.air) {
																																																																if (world
																																																																		.getBlock(
																																																																				x + 1,
																																																																				y + 1,
																																																																				z + 0) == Blocks.air) {
																																																																	if (world
																																																																			.getBlock(
																																																																					x + 2,
																																																																					y + 1,
																																																																					z + 0) == Blocks.air) {
																																																																		if (world
																																																																				.getBlock(
																																																																						x
																																																																								+ -2,
																																																																						y + 2,
																																																																						z + 0) == Blocks.air) {
																																																																			if (world
																																																																					.getBlock(
																																																																							x
																																																																									+ -1,
																																																																							y + 2,
																																																																							z + 0) == Blocks.air) {
																																																																				if (world
																																																																						.getBlock(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0) == Blocks.air) {
																																																																					if (world
																																																																							.getBlock(
																																																																									x + 1,
																																																																									y + 2,
																																																																									z + 0) == Blocks.air) {
																																																																						if (world
																																																																								.getBlock(
																																																																										x + 2,
																																																																										y + 2,
																																																																										z + 0) == Blocks.air) {
																																																																							if (world
																																																																									.getBlock(
																																																																											x
																																																																													+ -2,
																																																																											y + 3,
																																																																											z + 0) == Blocks.air) {
																																																																								if (world
																																																																										.getBlock(
																																																																												x
																																																																														+ -1,
																																																																												y + 3,
																																																																												z + 0) == Blocks.air) {
																																																																									if (world
																																																																											.getBlock(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0) == Blocks.air) {
																																																																										if (world
																																																																												.getBlock(
																																																																														x + 1,
																																																																														y + 3,
																																																																														z + 0) == Blocks.air) {
																																																																											if (world
																																																																													.getBlock(
																																																																															x + 2,
																																																																															y + 3,
																																																																															z + 0) == Blocks.air) {
																																																																												if (world
																																																																														.getBlock(
																																																																																x
																																																																																		+ -2,
																																																																																y
																																																																																		+ -1,
																																																																																z + 1) == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlock(
																																																																																	x
																																																																																			+ -1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z + 1) == FaithCraft2.WineBlock) {
																																																																														if (world
																																																																																.getBlock(
																																																																																		x + 0,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 1) == FaithCraft2.WineBlock) {
																																																																															if (world
																																																																																	.getBlock(
																																																																																			x + 1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z + 1) == FaithCraft2.WineBlock) {
																																																																																if (world
																																																																																		.getBlock(
																																																																																				x + 2,
																																																																																				y
																																																																																						+ -1,
																																																																																				z + 1) == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlock(
																																																																																					x
																																																																																							+ -2,
																																																																																					y + 0,
																																																																																					z + 1) == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlock(
																																																																																						x
																																																																																								+ -1,
																																																																																						y + 0,
																																																																																						z + 1) == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlock(
																																																																																							x + 0,
																																																																																							y + 0,
																																																																																							z + 1) == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlock(
																																																																																								x + 1,
																																																																																								y + 0,
																																																																																								z + 1) == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlock(
																																																																																									x + 2,
																																																																																									y + 0,
																																																																																									z + 1) == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlock(
																																																																																										x
																																																																																												+ -2,
																																																																																										y + 1,
																																																																																										z + 1) == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlock(
																																																																																											x
																																																																																													+ -1,
																																																																																											y + 1,
																																																																																											z + 1) == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlock(
																																																																																												x + 0,
																																																																																												y + 1,
																																																																																												z + 1) == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlock(
																																																																																													x + 1,
																																																																																													y + 1,
																																																																																													z + 1) == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlock(
																																																																																														x + 2,
																																																																																														y + 1,
																																																																																														z + 1) == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlock(
																																																																																															x
																																																																																																	+ -2,
																																																																																															y + 2,
																																																																																															z + 1) == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlock(
																																																																																																x
																																																																																																		+ -1,
																																																																																																y + 2,
																																																																																																z + 1) == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlock(
																																																																																																	x + 0,
																																																																																																	y + 2,
																																																																																																	z + 1) == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlock(
																																																																																																		x + 1,
																																																																																																		y + 2,
																																																																																																		z + 1) == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlock(
																																																																																																			x + 2,
																																																																																																			y + 2,
																																																																																																			z + 1) == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlock(
																																																																																																				x
																																																																																																						+ -2,
																																																																																																				y + 3,
																																																																																																				z + 1) == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlock(
																																																																																																					x
																																																																																																							+ -1,
																																																																																																					y + 3,
																																																																																																					z + 1) == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlock(
																																																																																																						x + 0,
																																																																																																						y + 3,
																																																																																																						z + 1) == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlock(
																																																																																																							x + 1,
																																																																																																							y + 3,
																																																																																																							z + 1) == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlock(
																																																																																																								x + 2,
																																																																																																								y + 3,
																																																																																																								z + 1) == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlock(
																																																																																																									x
																																																																																																											+ -2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z + 2) == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlock(
																																																																																																										x
																																																																																																												+ -1,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z + 2) == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlock(
																																																																																																											x + 0,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z + 2) == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlock(
																																																																																																												x + 1,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z + 2) == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlock(
																																																																																																													x + 2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z + 2) == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlock(
																																																																																																														x
																																																																																																																+ -2,
																																																																																																														y + 0,
																																																																																																														z + 2) == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlock(
																																																																																																															x
																																																																																																																	+ -1,
																																																																																																															y + 0,
																																																																																																															z + 2) == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlock(
																																																																																																																x + 0,
																																																																																																																y + 0,
																																																																																																																z + 2) == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlock(
																																																																																																																	x + 1,
																																																																																																																	y + 0,
																																																																																																																	z + 2) == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlock(
																																																																																																																		x + 2,
																																																																																																																		y + 0,
																																																																																																																		z + 2) == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlock(
																																																																																																																			x
																																																																																																																					+ -2,
																																																																																																																			y + 1,
																																																																																																																			z + 2) == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlock(
																																																																																																																				x
																																																																																																																						+ -1,
																																																																																																																				y + 1,
																																																																																																																				z + 2) == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlock(
																																																																																																																					x + 0,
																																																																																																																					y + 1,
																																																																																																																					z + 2) == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlock(
																																																																																																																						x + 1,
																																																																																																																						y + 1,
																																																																																																																						z + 2) == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlock(
																																																																																																																							x + 2,
																																																																																																																							y + 1,
																																																																																																																							z + 2) == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlock(
																																																																																																																								x
																																																																																																																										+ -2,
																																																																																																																								y + 2,
																																																																																																																								z + 2) == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlock(
																																																																																																																									x
																																																																																																																											+ -1,
																																																																																																																									y + 2,
																																																																																																																									z + 2) == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlock(
																																																																																																																										x + 0,
																																																																																																																										y + 2,
																																																																																																																										z + 2) == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlock(
																																																																																																																											x + 1,
																																																																																																																											y + 2,
																																																																																																																											z + 2) == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlock(
																																																																																																																												x + 2,
																																																																																																																												y + 2,
																																																																																																																												z + 2) == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlock(
																																																																																																																													x
																																																																																																																															+ -2,
																																																																																																																													y + 3,
																																																																																																																													z + 2) == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlock(
																																																																																																																														x
																																																																																																																																+ -1,
																																																																																																																														y + 3,
																																																																																																																														z + 2) == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlock(
																																																																																																																															x + 0,
																																																																																																																															y + 3,
																																																																																																																															z + 2) == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlock(
																																																																																																																																x + 1,
																																																																																																																																y + 3,
																																																																																																																																z + 2) == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlock(
																																																																																																																																	x + 2,
																																																																																																																																	y + 3,
																																																																																																																																	z + 2) == Blocks.air) {
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
		if (world.getBlock(x + 2, y + -1, z + -2) == FaithCraft2.HolyBlock) {
			if (world.getBlock(x + 2, y + -1, z + -1) == FaithCraft2.HolyBlock) {
				if (world.getBlock(x + 2, y + -1, z + 0) == FaithCraft2.HolyBlock) {
					if (world.getBlock(x + 2, y + -1, z + 1) == FaithCraft2.HolyBlock) {
						if (world.getBlock(x + 2, y + -1, z + 2) == FaithCraft2.HolyBlock) {
							if (world.getBlock(x + 2, y + 0, z + -2) == Blocks.air) {
								if (world.getBlock(x + 2, y + 0, z + -1) == Blocks.air) {
									if (world.getBlock(x + 2, y + 0, z + 0) == Blocks.air) {
										if (world.getBlock(x + 2, y + 0,
												z + 1) == Blocks.air) {
											if (world.getBlock(x + 2, y + 0,
													z + 2) == Blocks.air) {
												if (world.getBlock(x + 2,
														y + 1, z + -2) == Blocks.air) {
													if (world.getBlock(x + 2,
															y + 1, z + -1) == Blocks.air) {
														if (world.getBlock(
																x + 2, y + 1,
																z + 0) == Blocks.air) {
															if (world
																	.getBlock(
																			x + 2,
																			y + 1,
																			z + 1) == Blocks.air) {
																if (world
																		.getBlock(
																				x + 2,
																				y + 1,
																				z + 2) == Blocks.air) {
																	if (world
																			.getBlock(
																					x + 2,
																					y + 2,
																					z
																							+ -2) == Blocks.air) {
																		if (world
																				.getBlock(
																						x + 2,
																						y + 2,
																						z
																								+ -1) == Blocks.air) {
																			if (world
																					.getBlock(
																							x + 2,
																							y + 2,
																							z + 0) == Blocks.air) {
																				if (world
																						.getBlock(
																								x + 2,
																								y + 2,
																								z + 1) == Blocks.air) {
																					if (world
																							.getBlock(
																									x + 2,
																									y + 2,
																									z + 2) == Blocks.air) {
																						if (world
																								.getBlock(
																										x + 2,
																										y + 3,
																										z
																												+ -2) == Blocks.air) {
																							if (world
																									.getBlock(
																											x + 2,
																											y + 3,
																											z
																													+ -1) == Blocks.air) {
																								if (world
																										.getBlock(
																												x + 2,
																												y + 3,
																												z + 0) == Blocks.air) {
																									if (world
																											.getBlock(
																													x + 2,
																													y + 3,
																													z + 1) == Blocks.air) {
																										if (world
																												.getBlock(
																														x + 2,
																														y + 3,
																														z + 2) == Blocks.air) {
																											if (world
																													.getBlock(
																															x + 1,
																															y
																																	+ -1,
																															z
																																	+ -2) == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlock(
																																x + 1,
																																y
																																		+ -1,
																																z
																																		+ -1) == FaithCraft2.WineBlock) {
																													if (world
																															.getBlock(
																																	x + 1,
																																	y
																																			+ -1,
																																	z + 0) == FaithCraft2.WineBlock) {
																														if (world
																																.getBlock(
																																		x + 1,
																																		y
																																				+ -1,
																																		z + 1) == FaithCraft2.WineBlock) {
																															if (world
																																	.getBlock(
																																			x + 1,
																																			y
																																					+ -1,
																																			z + 2) == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlock(
																																				x + 1,
																																				y + 0,
																																				z
																																						+ -2) == Blocks.air) {
																																	if (world
																																			.getBlock(
																																					x + 1,
																																					y + 0,
																																					z
																																							+ -1) == Blocks.air) {
																																		if (world
																																				.getBlock(
																																						x + 1,
																																						y + 0,
																																						z + 0) == Blocks.air) {
																																			if (world
																																					.getBlock(
																																							x + 1,
																																							y + 0,
																																							z + 1) == Blocks.air) {
																																				if (world
																																						.getBlock(
																																								x + 1,
																																								y + 0,
																																								z + 2) == Blocks.air) {
																																					if (world
																																							.getBlock(
																																									x + 1,
																																									y + 1,
																																									z
																																											+ -2) == Blocks.air) {
																																						if (world
																																								.getBlock(
																																										x + 1,
																																										y + 1,
																																										z
																																												+ -1) == Blocks.air) {
																																							if (world
																																									.getBlock(
																																											x + 1,
																																											y + 1,
																																											z + 0) == Blocks.air) {
																																								if (world
																																										.getBlock(
																																												x + 1,
																																												y + 1,
																																												z + 1) == Blocks.air) {
																																									if (world
																																											.getBlock(
																																													x + 1,
																																													y + 1,
																																													z + 2) == Blocks.air) {
																																										if (world
																																												.getBlock(
																																														x + 1,
																																														y + 2,
																																														z
																																																+ -2) == Blocks.air) {
																																											if (world
																																													.getBlock(
																																															x + 1,
																																															y + 2,
																																															z
																																																	+ -1) == Blocks.air) {
																																												if (world
																																														.getBlock(
																																																x + 1,
																																																y + 2,
																																																z + 0) == Blocks.air) {
																																													if (world
																																															.getBlock(
																																																	x + 1,
																																																	y + 2,
																																																	z + 1) == Blocks.air) {
																																														if (world
																																																.getBlock(
																																																		x + 1,
																																																		y + 2,
																																																		z + 2) == Blocks.air) {
																																															if (world
																																																	.getBlock(
																																																			x + 1,
																																																			y + 3,
																																																			z
																																																					+ -2) == Blocks.air) {
																																																if (world
																																																		.getBlock(
																																																				x + 1,
																																																				y + 3,
																																																				z
																																																						+ -1) == Blocks.air) {
																																																	if (world
																																																			.getBlock(
																																																					x + 1,
																																																					y + 3,
																																																					z + 0) == Blocks.air) {
																																																		if (world
																																																				.getBlock(
																																																						x + 1,
																																																						y + 3,
																																																						z + 1) == Blocks.air) {
																																																			if (world
																																																					.getBlock(
																																																							x + 1,
																																																							y + 3,
																																																							z + 2) == Blocks.air) {
																																																				if (world
																																																						.getBlock(
																																																								x + 0,
																																																								y
																																																										+ -1,
																																																								z
																																																										+ -2) == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlock(
																																																									x + 0,
																																																									y
																																																											+ -1,
																																																									z
																																																											+ -1) == FaithCraft2.WineBlock) {
																																																						if (world
																																																								.getBlock(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0) == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlock(
																																																											x + 0,
																																																											y
																																																													+ -1,
																																																											z + 1) == FaithCraft2.WineBlock) {
																																																								if (world
																																																										.getBlock(
																																																												x + 0,
																																																												y
																																																														+ -1,
																																																												z + 2) == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlock(
																																																													x + 0,
																																																													y + 0,
																																																													z
																																																															+ -2) == Blocks.air) {
																																																										if (world
																																																												.getBlock(
																																																														x + 0,
																																																														y + 0,
																																																														z
																																																																+ -1) == Blocks.air) {
																																																											if (world
																																																													.getBlock(
																																																															x + 0,
																																																															y + 0,
																																																															z + 1) == Blocks.air) {
																																																												if (world
																																																														.getBlock(
																																																																x + 0,
																																																																y + 0,
																																																																z + 2) == Blocks.air) {
																																																													if (world
																																																															.getBlock(
																																																																	x + 0,
																																																																	y + 1,
																																																																	z
																																																																			+ -2) == Blocks.air) {
																																																														if (world
																																																																.getBlock(
																																																																		x + 0,
																																																																		y + 1,
																																																																		z
																																																																				+ -1) == Blocks.air) {
																																																															if (world
																																																																	.getBlock(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0) == Blocks.air) {
																																																																if (world
																																																																		.getBlock(
																																																																				x + 0,
																																																																				y + 1,
																																																																				z + 1) == Blocks.air) {
																																																																	if (world
																																																																			.getBlock(
																																																																					x + 0,
																																																																					y + 1,
																																																																					z + 2) == Blocks.air) {
																																																																		if (world
																																																																				.getBlock(
																																																																						x + 0,
																																																																						y + 2,
																																																																						z
																																																																								+ -2) == Blocks.air) {
																																																																			if (world
																																																																					.getBlock(
																																																																							x + 0,
																																																																							y + 2,
																																																																							z
																																																																									+ -1) == Blocks.air) {
																																																																				if (world
																																																																						.getBlock(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0) == Blocks.air) {
																																																																					if (world
																																																																							.getBlock(
																																																																									x + 0,
																																																																									y + 2,
																																																																									z + 1) == Blocks.air) {
																																																																						if (world
																																																																								.getBlock(
																																																																										x + 0,
																																																																										y + 2,
																																																																										z + 2) == Blocks.air) {
																																																																							if (world
																																																																									.getBlock(
																																																																											x + 0,
																																																																											y + 3,
																																																																											z
																																																																													+ -2) == Blocks.air) {
																																																																								if (world
																																																																										.getBlock(
																																																																												x + 0,
																																																																												y + 3,
																																																																												z
																																																																														+ -1) == Blocks.air) {
																																																																									if (world
																																																																											.getBlock(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0) == Blocks.air) {
																																																																										if (world
																																																																												.getBlock(
																																																																														x + 0,
																																																																														y + 3,
																																																																														z + 1) == Blocks.air) {
																																																																											if (world
																																																																													.getBlock(
																																																																															x + 0,
																																																																															y + 3,
																																																																															z + 2) == Blocks.air) {
																																																																												if (world
																																																																														.getBlock(
																																																																																x
																																																																																		+ -1,
																																																																																y
																																																																																		+ -1,
																																																																																z
																																																																																		+ -2) == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlock(
																																																																																	x
																																																																																			+ -1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z
																																																																																			+ -1) == FaithCraft2.WineBlock) {
																																																																														if (world
																																																																																.getBlock(
																																																																																		x
																																																																																				+ -1,
																																																																																		y
																																																																																				+ -1,
																																																																																		z + 0) == FaithCraft2.WineBlock) {
																																																																															if (world
																																																																																	.getBlock(
																																																																																			x
																																																																																					+ -1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z + 1) == FaithCraft2.WineBlock) {
																																																																																if (world
																																																																																		.getBlock(
																																																																																				x
																																																																																						+ -1,
																																																																																				y
																																																																																						+ -1,
																																																																																				z + 2) == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlock(
																																																																																					x
																																																																																							+ -1,
																																																																																					y + 0,
																																																																																					z
																																																																																							+ -2) == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlock(
																																																																																						x
																																																																																								+ -1,
																																																																																						y + 0,
																																																																																						z
																																																																																								+ -1) == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlock(
																																																																																							x
																																																																																									+ -1,
																																																																																							y + 0,
																																																																																							z + 0) == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlock(
																																																																																								x
																																																																																										+ -1,
																																																																																								y + 0,
																																																																																								z + 1) == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlock(
																																																																																									x
																																																																																											+ -1,
																																																																																									y + 0,
																																																																																									z + 2) == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlock(
																																																																																										x
																																																																																												+ -1,
																																																																																										y + 1,
																																																																																										z
																																																																																												+ -2) == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlock(
																																																																																											x
																																																																																													+ -1,
																																																																																											y + 1,
																																																																																											z
																																																																																													+ -1) == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlock(
																																																																																												x
																																																																																														+ -1,
																																																																																												y + 1,
																																																																																												z + 0) == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlock(
																																																																																													x
																																																																																															+ -1,
																																																																																													y + 1,
																																																																																													z + 1) == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlock(
																																																																																														x
																																																																																																+ -1,
																																																																																														y + 1,
																																																																																														z + 2) == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlock(
																																																																																															x
																																																																																																	+ -1,
																																																																																															y + 2,
																																																																																															z
																																																																																																	+ -2) == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlock(
																																																																																																x
																																																																																																		+ -1,
																																																																																																y + 2,
																																																																																																z
																																																																																																		+ -1) == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlock(
																																																																																																	x
																																																																																																			+ -1,
																																																																																																	y + 2,
																																																																																																	z + 0) == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlock(
																																																																																																		x
																																																																																																				+ -1,
																																																																																																		y + 2,
																																																																																																		z + 1) == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlock(
																																																																																																			x
																																																																																																					+ -1,
																																																																																																			y + 2,
																																																																																																			z + 2) == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlock(
																																																																																																				x
																																																																																																						+ -1,
																																																																																																				y + 3,
																																																																																																				z
																																																																																																						+ -2) == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlock(
																																																																																																					x
																																																																																																							+ -1,
																																																																																																					y + 3,
																																																																																																					z
																																																																																																							+ -1) == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlock(
																																																																																																						x
																																																																																																								+ -1,
																																																																																																						y + 3,
																																																																																																						z + 0) == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlock(
																																																																																																							x
																																																																																																									+ -1,
																																																																																																							y + 3,
																																																																																																							z + 1) == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlock(
																																																																																																								x
																																																																																																										+ -1,
																																																																																																								y + 3,
																																																																																																								z + 2) == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlock(
																																																																																																									x
																																																																																																											+ -2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z
																																																																																																											+ -2) == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlock(
																																																																																																										x
																																																																																																												+ -2,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z
																																																																																																												+ -1) == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlock(
																																																																																																											x
																																																																																																													+ -2,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z + 0) == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlock(
																																																																																																												x
																																																																																																														+ -2,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z + 1) == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlock(
																																																																																																													x
																																																																																																															+ -2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z + 2) == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlock(
																																																																																																														x
																																																																																																																+ -2,
																																																																																																														y + 0,
																																																																																																														z
																																																																																																																+ -2) == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlock(
																																																																																																															x
																																																																																																																	+ -2,
																																																																																																															y + 0,
																																																																																																															z
																																																																																																																	+ -1) == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlock(
																																																																																																																x
																																																																																																																		+ -2,
																																																																																																																y + 0,
																																																																																																																z + 0) == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlock(
																																																																																																																	x
																																																																																																																			+ -2,
																																																																																																																	y + 0,
																																																																																																																	z + 1) == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlock(
																																																																																																																		x
																																																																																																																				+ -2,
																																																																																																																		y + 0,
																																																																																																																		z + 2) == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlock(
																																																																																																																			x
																																																																																																																					+ -2,
																																																																																																																			y + 1,
																																																																																																																			z
																																																																																																																					+ -2) == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlock(
																																																																																																																				x
																																																																																																																						+ -2,
																																																																																																																				y + 1,
																																																																																																																				z
																																																																																																																						+ -1) == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlock(
																																																																																																																					x
																																																																																																																							+ -2,
																																																																																																																					y + 1,
																																																																																																																					z + 0) == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlock(
																																																																																																																						x
																																																																																																																								+ -2,
																																																																																																																						y + 1,
																																																																																																																						z + 1) == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlock(
																																																																																																																							x
																																																																																																																									+ -2,
																																																																																																																							y + 1,
																																																																																																																							z + 2) == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlock(
																																																																																																																								x
																																																																																																																										+ -2,
																																																																																																																								y + 2,
																																																																																																																								z
																																																																																																																										+ -2) == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlock(
																																																																																																																									x
																																																																																																																											+ -2,
																																																																																																																									y + 2,
																																																																																																																									z
																																																																																																																											+ -1) == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlock(
																																																																																																																										x
																																																																																																																												+ -2,
																																																																																																																										y + 2,
																																																																																																																										z + 0) == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlock(
																																																																																																																											x
																																																																																																																													+ -2,
																																																																																																																											y + 2,
																																																																																																																											z + 1) == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlock(
																																																																																																																												x
																																																																																																																														+ -2,
																																																																																																																												y + 2,
																																																																																																																												z + 2) == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlock(
																																																																																																																													x
																																																																																																																															+ -2,
																																																																																																																													y + 3,
																																																																																																																													z
																																																																																																																															+ -2) == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlock(
																																																																																																																														x
																																																																																																																																+ -2,
																																																																																																																														y + 3,
																																																																																																																														z
																																																																																																																																+ -1) == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlock(
																																																																																																																															x
																																																																																																																																	+ -2,
																																																																																																																															y + 3,
																																																																																																																															z + 0) == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlock(
																																																																																																																																x
																																																																																																																																		+ -2,
																																																																																																																																y + 3,
																																																																																																																																z + 1) == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlock(
																																																																																																																																	x
																																																																																																																																			+ -2,
																																																																																																																																	y + 3,
																																																																																																																																	z + 2) == Blocks.air) {
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
		if (world.getBlock(x + 2, y + -1, z + 2) == FaithCraft2.HolyBlock) {
			if (world.getBlock(x + 1, y + -1, z + 2) == FaithCraft2.HolyBlock) {
				if (world.getBlock(x + 0, y + -1, z + 2) == FaithCraft2.HolyBlock) {
					if (world.getBlock(x + -1, y + -1, z + 2) == FaithCraft2.HolyBlock) {
						if (world.getBlock(x + -2, y + -1, z + 2) == FaithCraft2.HolyBlock) {
							if (world.getBlock(x + 2, y + 0, z + 2) == Blocks.air) {
								if (world.getBlock(x + 1, y + 0, z + 2) == Blocks.air) {
									if (world.getBlock(x + 0, y + 0, z + 2) == Blocks.air) {
										if (world.getBlock(x + -1, y + 0,
												z + 2) == Blocks.air) {
											if (world.getBlock(x + -2, y + 0,
													z + 2) == Blocks.air) {
												if (world.getBlock(x + 2,
														y + 1, z + 2) == Blocks.air) {
													if (world.getBlock(x + 1,
															y + 1, z + 2) == Blocks.air) {
														if (world.getBlock(
																x + 0, y + 1,
																z + 2) == Blocks.air) {
															if (world
																	.getBlock(
																			x
																					+ -1,
																			y + 1,
																			z + 2) == Blocks.air) {
																if (world
																		.getBlock(
																				x
																						+ -2,
																				y + 1,
																				z + 2) == Blocks.air) {
																	if (world
																			.getBlock(
																					x + 2,
																					y + 2,
																					z + 2) == Blocks.air) {
																		if (world
																				.getBlock(
																						x + 1,
																						y + 2,
																						z + 2) == Blocks.air) {
																			if (world
																					.getBlock(
																							x + 0,
																							y + 2,
																							z + 2) == Blocks.air) {
																				if (world
																						.getBlock(
																								x
																										+ -1,
																								y + 2,
																								z + 2) == Blocks.air) {
																					if (world
																							.getBlock(
																									x
																											+ -2,
																									y + 2,
																									z + 2) == Blocks.air) {
																						if (world
																								.getBlock(
																										x + 2,
																										y + 3,
																										z + 2) == Blocks.air) {
																							if (world
																									.getBlock(
																											x + 1,
																											y + 3,
																											z + 2) == Blocks.air) {
																								if (world
																										.getBlock(
																												x + 0,
																												y + 3,
																												z + 2) == Blocks.air) {
																									if (world
																											.getBlock(
																													x
																															+ -1,
																													y + 3,
																													z + 2) == Blocks.air) {
																										if (world
																												.getBlock(
																														x
																																+ -2,
																														y + 3,
																														z + 2) == Blocks.air) {
																											if (world
																													.getBlock(
																															x + 2,
																															y
																																	+ -1,
																															z + 1) == FaithCraft2.HolyBlock) {
																												if (world
																														.getBlock(
																																x + 1,
																																y
																																		+ -1,
																																z + 1) == FaithCraft2.WineBlock) {
																													if (world
																															.getBlock(
																																	x + 0,
																																	y
																																			+ -1,
																																	z + 1) == FaithCraft2.WineBlock) {
																														if (world
																																.getBlock(
																																		x
																																				+ -1,
																																		y
																																				+ -1,
																																		z + 1) == FaithCraft2.WineBlock) {
																															if (world
																																	.getBlock(
																																			x
																																					+ -2,
																																			y
																																					+ -1,
																																			z + 1) == FaithCraft2.HolyBlock) {
																																if (world
																																		.getBlock(
																																				x + 2,
																																				y + 0,
																																				z + 1) == Blocks.air) {
																																	if (world
																																			.getBlock(
																																					x + 1,
																																					y + 0,
																																					z + 1) == Blocks.air) {
																																		if (world
																																				.getBlock(
																																						x + 0,
																																						y + 0,
																																						z + 1) == Blocks.air) {
																																			if (world
																																					.getBlock(
																																							x
																																									+ -1,
																																							y + 0,
																																							z + 1) == Blocks.air) {
																																				if (world
																																						.getBlock(
																																								x
																																										+ -2,
																																								y + 0,
																																								z + 1) == Blocks.air) {
																																					if (world
																																							.getBlock(
																																									x + 2,
																																									y + 1,
																																									z + 1) == Blocks.air) {
																																						if (world
																																								.getBlock(
																																										x + 1,
																																										y + 1,
																																										z + 1) == Blocks.air) {
																																							if (world
																																									.getBlock(
																																											x + 0,
																																											y + 1,
																																											z + 1) == Blocks.air) {
																																								if (world
																																										.getBlock(
																																												x
																																														+ -1,
																																												y + 1,
																																												z + 1) == Blocks.air) {
																																									if (world
																																											.getBlock(
																																													x
																																															+ -2,
																																													y + 1,
																																													z + 1) == Blocks.air) {
																																										if (world
																																												.getBlock(
																																														x + 2,
																																														y + 2,
																																														z + 1) == Blocks.air) {
																																											if (world
																																													.getBlock(
																																															x + 1,
																																															y + 2,
																																															z + 1) == Blocks.air) {
																																												if (world
																																														.getBlock(
																																																x + 0,
																																																y + 2,
																																																z + 1) == Blocks.air) {
																																													if (world
																																															.getBlock(
																																																	x
																																																			+ -1,
																																																	y + 2,
																																																	z + 1) == Blocks.air) {
																																														if (world
																																																.getBlock(
																																																		x
																																																				+ -2,
																																																		y + 2,
																																																		z + 1) == Blocks.air) {
																																															if (world
																																																	.getBlock(
																																																			x + 2,
																																																			y + 3,
																																																			z + 1) == Blocks.air) {
																																																if (world
																																																		.getBlock(
																																																				x + 1,
																																																				y + 3,
																																																				z + 1) == Blocks.air) {
																																																	if (world
																																																			.getBlock(
																																																					x + 0,
																																																					y + 3,
																																																					z + 1) == Blocks.air) {
																																																		if (world
																																																				.getBlock(
																																																						x
																																																								+ -1,
																																																						y + 3,
																																																						z + 1) == Blocks.air) {
																																																			if (world
																																																					.getBlock(
																																																							x
																																																									+ -2,
																																																							y + 3,
																																																							z + 1) == Blocks.air) {
																																																				if (world
																																																						.getBlock(
																																																								x + 2,
																																																								y
																																																										+ -1,
																																																								z + 0) == FaithCraft2.HolyBlock) {
																																																					if (world
																																																							.getBlock(
																																																									x + 1,
																																																									y
																																																											+ -1,
																																																									z + 0) == FaithCraft2.WineBlock) {
																																																						if (world
																																																								.getBlock(
																																																										x + 0,
																																																										y
																																																												+ -1,
																																																										z + 0) == FaithCraft2.HolyBlock) {
																																																							if (world
																																																									.getBlock(
																																																											x
																																																													+ -1,
																																																											y
																																																													+ -1,
																																																											z + 0) == FaithCraft2.WineBlock) {
																																																								if (world
																																																										.getBlock(
																																																												x
																																																														+ -2,
																																																												y
																																																														+ -1,
																																																												z + 0) == FaithCraft2.HolyBlock) {
																																																									if (world
																																																											.getBlock(
																																																													x + 2,
																																																													y + 0,
																																																													z + 0) == Blocks.air) {
																																																										if (world
																																																												.getBlock(
																																																														x + 1,
																																																														y + 0,
																																																														z + 0) == Blocks.air) {
																																																											if (world
																																																													.getBlock(
																																																															x
																																																																	+ -1,
																																																															y + 0,
																																																															z + 0) == Blocks.air) {
																																																												if (world
																																																														.getBlock(
																																																																x
																																																																		+ -2,
																																																																y + 0,
																																																																z + 0) == Blocks.air) {
																																																													if (world
																																																															.getBlock(
																																																																	x + 2,
																																																																	y + 1,
																																																																	z + 0) == Blocks.air) {
																																																														if (world
																																																																.getBlock(
																																																																		x + 1,
																																																																		y + 1,
																																																																		z + 0) == Blocks.air) {
																																																															if (world
																																																																	.getBlock(
																																																																			x + 0,
																																																																			y + 1,
																																																																			z + 0) == Blocks.air) {
																																																																if (world
																																																																		.getBlock(
																																																																				x
																																																																						+ -1,
																																																																				y + 1,
																																																																				z + 0) == Blocks.air) {
																																																																	if (world
																																																																			.getBlock(
																																																																					x
																																																																							+ -2,
																																																																					y + 1,
																																																																					z + 0) == Blocks.air) {
																																																																		if (world
																																																																				.getBlock(
																																																																						x + 2,
																																																																						y + 2,
																																																																						z + 0) == Blocks.air) {
																																																																			if (world
																																																																					.getBlock(
																																																																							x + 1,
																																																																							y + 2,
																																																																							z + 0) == Blocks.air) {
																																																																				if (world
																																																																						.getBlock(
																																																																								x + 0,
																																																																								y + 2,
																																																																								z + 0) == Blocks.air) {
																																																																					if (world
																																																																							.getBlock(
																																																																									x
																																																																											+ -1,
																																																																									y + 2,
																																																																									z + 0) == Blocks.air) {
																																																																						if (world
																																																																								.getBlock(
																																																																										x
																																																																												+ -2,
																																																																										y + 2,
																																																																										z + 0) == Blocks.air) {
																																																																							if (world
																																																																									.getBlock(
																																																																											x + 2,
																																																																											y + 3,
																																																																											z + 0) == Blocks.air) {
																																																																								if (world
																																																																										.getBlock(
																																																																												x + 1,
																																																																												y + 3,
																																																																												z + 0) == Blocks.air) {
																																																																									if (world
																																																																											.getBlock(
																																																																													x + 0,
																																																																													y + 3,
																																																																													z + 0) == Blocks.air) {
																																																																										if (world
																																																																												.getBlock(
																																																																														x
																																																																																+ -1,
																																																																														y + 3,
																																																																														z + 0) == Blocks.air) {
																																																																											if (world
																																																																													.getBlock(
																																																																															x
																																																																																	+ -2,
																																																																															y + 3,
																																																																															z + 0) == Blocks.air) {
																																																																												if (world
																																																																														.getBlock(
																																																																																x + 2,
																																																																																y
																																																																																		+ -1,
																																																																																z
																																																																																		+ -1) == FaithCraft2.HolyBlock) {
																																																																													if (world
																																																																															.getBlock(
																																																																																	x + 1,
																																																																																	y
																																																																																			+ -1,
																																																																																	z
																																																																																			+ -1) == FaithCraft2.WineBlock) {
																																																																														if (world
																																																																																.getBlock(
																																																																																		x + 0,
																																																																																		y
																																																																																				+ -1,
																																																																																		z
																																																																																				+ -1) == FaithCraft2.WineBlock) {
																																																																															if (world
																																																																																	.getBlock(
																																																																																			x
																																																																																					+ -1,
																																																																																			y
																																																																																					+ -1,
																																																																																			z
																																																																																					+ -1) == FaithCraft2.WineBlock) {
																																																																																if (world
																																																																																		.getBlock(
																																																																																				x
																																																																																						+ -2,
																																																																																				y
																																																																																						+ -1,
																																																																																				z
																																																																																						+ -1) == FaithCraft2.HolyBlock) {
																																																																																	if (world
																																																																																			.getBlock(
																																																																																					x + 2,
																																																																																					y + 0,
																																																																																					z
																																																																																							+ -1) == Blocks.air) {
																																																																																		if (world
																																																																																				.getBlock(
																																																																																						x + 1,
																																																																																						y + 0,
																																																																																						z
																																																																																								+ -1) == Blocks.air) {
																																																																																			if (world
																																																																																					.getBlock(
																																																																																							x + 0,
																																																																																							y + 0,
																																																																																							z
																																																																																									+ -1) == Blocks.air) {
																																																																																				if (world
																																																																																						.getBlock(
																																																																																								x
																																																																																										+ -1,
																																																																																								y + 0,
																																																																																								z
																																																																																										+ -1) == Blocks.air) {
																																																																																					if (world
																																																																																							.getBlock(
																																																																																									x
																																																																																											+ -2,
																																																																																									y + 0,
																																																																																									z
																																																																																											+ -1) == Blocks.air) {
																																																																																						if (world
																																																																																								.getBlock(
																																																																																										x + 2,
																																																																																										y + 1,
																																																																																										z
																																																																																												+ -1) == Blocks.air) {
																																																																																							if (world
																																																																																									.getBlock(
																																																																																											x + 1,
																																																																																											y + 1,
																																																																																											z
																																																																																													+ -1) == Blocks.air) {
																																																																																								if (world
																																																																																										.getBlock(
																																																																																												x + 0,
																																																																																												y + 1,
																																																																																												z
																																																																																														+ -1) == Blocks.air) {
																																																																																									if (world
																																																																																											.getBlock(
																																																																																													x
																																																																																															+ -1,
																																																																																													y + 1,
																																																																																													z
																																																																																															+ -1) == Blocks.air) {
																																																																																										if (world
																																																																																												.getBlock(
																																																																																														x
																																																																																																+ -2,
																																																																																														y + 1,
																																																																																														z
																																																																																																+ -1) == Blocks.air) {
																																																																																											if (world
																																																																																													.getBlock(
																																																																																															x + 2,
																																																																																															y + 2,
																																																																																															z
																																																																																																	+ -1) == Blocks.air) {
																																																																																												if (world
																																																																																														.getBlock(
																																																																																																x + 1,
																																																																																																y + 2,
																																																																																																z
																																																																																																		+ -1) == Blocks.air) {
																																																																																													if (world
																																																																																															.getBlock(
																																																																																																	x + 0,
																																																																																																	y + 2,
																																																																																																	z
																																																																																																			+ -1) == Blocks.air) {
																																																																																														if (world
																																																																																																.getBlock(
																																																																																																		x
																																																																																																				+ -1,
																																																																																																		y + 2,
																																																																																																		z
																																																																																																				+ -1) == Blocks.air) {
																																																																																															if (world
																																																																																																	.getBlock(
																																																																																																			x
																																																																																																					+ -2,
																																																																																																			y + 2,
																																																																																																			z
																																																																																																					+ -1) == Blocks.air) {
																																																																																																if (world
																																																																																																		.getBlock(
																																																																																																				x + 2,
																																																																																																				y + 3,
																																																																																																				z
																																																																																																						+ -1) == Blocks.air) {
																																																																																																	if (world
																																																																																																			.getBlock(
																																																																																																					x + 1,
																																																																																																					y + 3,
																																																																																																					z
																																																																																																							+ -1) == Blocks.air) {
																																																																																																		if (world
																																																																																																				.getBlock(
																																																																																																						x + 0,
																																																																																																						y + 3,
																																																																																																						z
																																																																																																								+ -1) == Blocks.air) {
																																																																																																			if (world
																																																																																																					.getBlock(
																																																																																																							x
																																																																																																									+ -1,
																																																																																																							y + 3,
																																																																																																							z
																																																																																																									+ -1) == Blocks.air) {
																																																																																																				if (world
																																																																																																						.getBlock(
																																																																																																								x
																																																																																																										+ -2,
																																																																																																								y + 3,
																																																																																																								z
																																																																																																										+ -1) == Blocks.air) {
																																																																																																					if (world
																																																																																																							.getBlock(
																																																																																																									x + 2,
																																																																																																									y
																																																																																																											+ -1,
																																																																																																									z
																																																																																																											+ -2) == FaithCraft2.HolyBlock) {
																																																																																																						if (world
																																																																																																								.getBlock(
																																																																																																										x + 1,
																																																																																																										y
																																																																																																												+ -1,
																																																																																																										z
																																																																																																												+ -2) == FaithCraft2.HolyBlock) {
																																																																																																							if (world
																																																																																																									.getBlock(
																																																																																																											x + 0,
																																																																																																											y
																																																																																																													+ -1,
																																																																																																											z
																																																																																																													+ -2) == FaithCraft2.HolyBlock) {
																																																																																																								if (world
																																																																																																										.getBlock(
																																																																																																												x
																																																																																																														+ -1,
																																																																																																												y
																																																																																																														+ -1,
																																																																																																												z
																																																																																																														+ -2) == FaithCraft2.HolyBlock) {
																																																																																																									if (world
																																																																																																											.getBlock(
																																																																																																													x
																																																																																																															+ -2,
																																																																																																													y
																																																																																																															+ -1,
																																																																																																													z
																																																																																																															+ -2) == FaithCraft2.HolyBlock) {
																																																																																																										if (world
																																																																																																												.getBlock(
																																																																																																														x + 2,
																																																																																																														y + 0,
																																																																																																														z
																																																																																																																+ -2) == Blocks.air) {
																																																																																																											if (world
																																																																																																													.getBlock(
																																																																																																															x + 1,
																																																																																																															y + 0,
																																																																																																															z
																																																																																																																	+ -2) == Blocks.air) {
																																																																																																												if (world
																																																																																																														.getBlock(
																																																																																																																x + 0,
																																																																																																																y + 0,
																																																																																																																z
																																																																																																																		+ -2) == Blocks.air) {
																																																																																																													if (world
																																																																																																															.getBlock(
																																																																																																																	x
																																																																																																																			+ -1,
																																																																																																																	y + 0,
																																																																																																																	z
																																																																																																																			+ -2) == Blocks.air) {
																																																																																																														if (world
																																																																																																																.getBlock(
																																																																																																																		x
																																																																																																																				+ -2,
																																																																																																																		y + 0,
																																																																																																																		z
																																																																																																																				+ -2) == Blocks.air) {
																																																																																																															if (world
																																																																																																																	.getBlock(
																																																																																																																			x + 2,
																																																																																																																			y + 1,
																																																																																																																			z
																																																																																																																					+ -2) == Blocks.air) {
																																																																																																																if (world
																																																																																																																		.getBlock(
																																																																																																																				x + 1,
																																																																																																																				y + 1,
																																																																																																																				z
																																																																																																																						+ -2) == Blocks.air) {
																																																																																																																	if (world
																																																																																																																			.getBlock(
																																																																																																																					x + 0,
																																																																																																																					y + 1,
																																																																																																																					z
																																																																																																																							+ -2) == Blocks.air) {
																																																																																																																		if (world
																																																																																																																				.getBlock(
																																																																																																																						x
																																																																																																																								+ -1,
																																																																																																																						y + 1,
																																																																																																																						z
																																																																																																																								+ -2) == Blocks.air) {
																																																																																																																			if (world
																																																																																																																					.getBlock(
																																																																																																																							x
																																																																																																																									+ -2,
																																																																																																																							y + 1,
																																																																																																																							z
																																																																																																																									+ -2) == Blocks.air) {
																																																																																																																				if (world
																																																																																																																						.getBlock(
																																																																																																																								x + 2,
																																																																																																																								y + 2,
																																																																																																																								z
																																																																																																																										+ -2) == Blocks.air) {
																																																																																																																					if (world
																																																																																																																							.getBlock(
																																																																																																																									x + 1,
																																																																																																																									y + 2,
																																																																																																																									z
																																																																																																																											+ -2) == Blocks.air) {
																																																																																																																						if (world
																																																																																																																								.getBlock(
																																																																																																																										x + 0,
																																																																																																																										y + 2,
																																																																																																																										z
																																																																																																																												+ -2) == Blocks.air) {
																																																																																																																							if (world
																																																																																																																									.getBlock(
																																																																																																																											x
																																																																																																																													+ -1,
																																																																																																																											y + 2,
																																																																																																																											z
																																																																																																																													+ -2) == Blocks.air) {
																																																																																																																								if (world
																																																																																																																										.getBlock(
																																																																																																																												x
																																																																																																																														+ -2,
																																																																																																																												y + 2,
																																																																																																																												z
																																																																																																																														+ -2) == Blocks.air) {
																																																																																																																									if (world
																																																																																																																											.getBlock(
																																																																																																																													x + 2,
																																																																																																																													y + 3,
																																																																																																																													z
																																																																																																																															+ -2) == Blocks.air) {
																																																																																																																										if (world
																																																																																																																												.getBlock(
																																																																																																																														x + 1,
																																																																																																																														y + 3,
																																																																																																																														z
																																																																																																																																+ -2) == Blocks.air) {
																																																																																																																											if (world
																																																																																																																													.getBlock(
																																																																																																																															x + 0,
																																																																																																																															y + 3,
																																																																																																																															z
																																																																																																																																	+ -2) == Blocks.air) {
																																																																																																																												if (world
																																																																																																																														.getBlock(
																																																																																																																																x
																																																																																																																																		+ -1,
																																																																																																																																y + 3,
																																																																																																																																z
																																																																																																																																		+ -2) == Blocks.air) {
																																																																																																																													if (world
																																																																																																																															.getBlock(
																																																																																																																																	x
																																																																																																																																			+ -2,
																																																																																																																																	y + 3,
																																																																																																																																	z
																																																																																																																																			+ -2) == Blocks.air) {
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
