package FaithCraft2.Common.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.FaithCraft2;

public class HolyController extends Block{
	
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", HolyController.EnumType.class);
	public static boolean isHolyForge = false;
	private final String name = "HolyController";
	
	public HolyController(Material material) {
		super(material);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(6F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, HolyController.EnumType.OFF));
		this.damageDropped(this.getDefaultState());
	}
	
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.isHolyForge = false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
		if ((!worldIn.isRemote) && (isMultiBlockStructure(worldIn, pos.getX(), pos.getY(), pos.getZ()) || isMultiBlockStructure1(worldIn, pos.getX(), pos.getY(), pos.getZ()))){
			this.isHolyForge = true;
			if (isMultiBlockStructure(worldIn, pos.getX(), pos.getY(), pos.getZ())){
				worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), this.getStateFromMeta(1));
			}
			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() == Blocks.redstone_wire){
				worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1), FaithCraftBlocks.wineBlock.getDefaultState());
			}
			if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() == Blocks.redstone_wire){
				worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1), FaithCraftBlocks.wineBlock.getDefaultState());
			}
			if (worldIn.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() == Blocks.redstone_wire){
				worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()), FaithCraftBlocks.wineBlock.getDefaultState());
			}
			if (worldIn.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() == Blocks.redstone_wire){
				worldIn.setBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()), FaithCraftBlocks.wineBlock.getDefaultState());
			}
		}else{
			this.isHolyForge = false;
		}
		return true;
	}
	
	
	
	public String getName(){
		return name;
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, HolyController.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((HolyController.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected net.minecraft.block.state.BlockState createBlockState()
    {
        return new net.minecraft.block.state.BlockState(this, new IProperty[] {VARIANT});
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
    	HolyController.EnumType[] aenumtype = HolyController.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	HolyController.EnumType enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
        }
    }
	
	public static enum EnumType implements IStringSerializable
    {
        OFF(0, "off"),
		ON(1, "on");
        private static final HolyController.EnumType[] META_LOOKUP = new HolyController.EnumType[values().length];
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

        public static HolyController.EnumType byMetadata(int meta)
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
        	HolyController.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	HolyController.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
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
		if (world.getBlockState(new BlockPos(x + -1, y + -1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + -1, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + -1, y + -1, z + -2)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + -1, y + 0, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + -1, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + -1, y + 0, z + -2)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + -1, y + 1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + -1, y + 1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + -1, y + 1, z
												+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + 0, y
														+ -1, z + -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(x + 0,
															y + -1, z + -2)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(
																x + 0, y + 0, z
																+ -1)).getBlock() == Blocks.redstone_wire) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 0,
																			y + 0,
																			z
																			+ -2)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
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
																						+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 1,
																							y
																							+ -1,
																							z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x + 1,
																								y
																								+ -1,
																								z
																								+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x + 1,
																									y
																									+ -1,
																									z
																									+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 1,
																										y + 0,
																										z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x + 1,
																											y + 0,
																											z
																											+ -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 1,
																												y + 0,
																												z
																												+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 1,
																													y + 1,
																													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x + 1,
																														y + 1,
																														z
																														+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x + 1,
																															y + 1,
																															z
																															+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}

	private static boolean checkEast(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 0, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + 1, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + 2, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + 0, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + 1, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + 2, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + 0, y + 1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + 1, y + 1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + 2, y + 1, z
												+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + 1, y
														+ -1, z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(x + 2,
															y + -1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(
																x + 1, y + 0,
																z + 0)).getBlock() == Blocks.redstone_wire) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 2,
																			y + 0,
																			z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																	if (world
																			.getBlockState(new BlockPos(
																					x + 1,
																					y + 1,
																					z + 0)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x + 2,
																						y + 1,
																						z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 0,
																							y
																							+ -1,
																							z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x + 1,
																								y
																								+ -1,
																								z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x + 2,
																									y
																									+ -1,
																									z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 0,
																										y + 0,
																										z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x + 1,
																											y + 0,
																											z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 2,
																												y + 0,
																												z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 0,
																													y + 1,
																													z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x + 1,
																														y + 1,
																														z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x + 2,
																															y + 1,
																															z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}

	private static boolean checkSouth(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + 1, y + 1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + 1, y + 1,
												z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + 0, y
														+ -1, z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(x + 0,
															y + -1, z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(
																x + 0, y + 0,
																z + 1)).getBlock() == Blocks.redstone_wire) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 0,
																			y + 0,
																			z + 2)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																	if (world
																			.getBlockState(new BlockPos(
																					x + 0,
																					y + 1,
																					z + 1)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x + 0,
																						y + 1,
																						z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x
																							+ -1,
																							y
																							+ -1,
																							z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x
																								+ -1,
																								y
																								+ -1,
																								z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x
																									+ -1,
																									y
																									+ -1,
																									z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x
																										+ -1,
																										y + 0,
																										z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x
																											+ -1,
																											y + 0,
																											z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x
																												+ -1,
																												y + 0,
																												z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x
																													+ -1,
																													y + 1,
																													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x
																														+ -1,
																														y + 1,
																														z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x
																															+ -1,
																															y + 1,
																															z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}

	private static boolean checkWest(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 0, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + -1, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + -2, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + 0, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + -1, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + -2, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + 0, y + 1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + -1, y + 1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + -2, y + 1,
												z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + -1, y
														+ -1, z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(
															x + -2, y + -1,
															z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(x
																+ -1, y + 0,
																z + 0)).getBlock() == Blocks.redstone_wire) {
															if (world
																	.getBlockState(new BlockPos(
																			x
																			+ -2,
																			y + 0,
																			z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
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
																						z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 0,
																							y
																							+ -1,
																							z
																							+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x
																								+ -1,
																								y
																								+ -1,
																								z
																								+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x
																									+ -2,
																									y
																									+ -1,
																									z
																									+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 0,
																										y + 0,
																										z
																										+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x
																											+ -1,
																											y + 0,
																											z
																											+ -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x
																												+ -2,
																												y + 0,
																												z
																												+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 0,
																													y + 1,
																													z
																													+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x
																														+ -1,
																														y + 1,
																														z
																														+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x
																															+ -2,
																															y + 1,
																															z
																															+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}
	
	public boolean isMultiBlockStructure1(World world, int x, int y, int z) {
		if (checkNorth1(world, x, y, z))/* North */
			return true;
		if (checkEast1(world, x, y, z))/* East */
			return true;
		if (checkSouth1(world, x, y, z))/* South */
			return true;
		if (checkWest1(world, x, y, z))/* West */
			return true;
		return false;
	}

	private static boolean checkNorth1(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + -1, y + -1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + -1, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + -1, y + -1, z + -2)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + -1, y + 0, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + -1, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + -1, y + 0, z + -2)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + -1, y + 1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + -1, y + 1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + -1, y + 1, z
												+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + 0, y
														+ -1, z + -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(x + 0,
															y + -1, z + -2)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(
																x + 0, y + 0, z
																+ -1)).getBlock() == FaithCraftBlocks.wineBlock) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 0,
																			y + 0,
																			z
																			+ -2)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
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
																						+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 1,
																							y
																							+ -1,
																							z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x + 1,
																								y
																								+ -1,
																								z
																								+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x + 1,
																									y
																									+ -1,
																									z
																									+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 1,
																										y + 0,
																										z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x + 1,
																											y + 0,
																											z
																											+ -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 1,
																												y + 0,
																												z
																												+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 1,
																													y + 1,
																													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x + 1,
																														y + 1,
																														z
																														+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x + 1,
																															y + 1,
																															z
																															+ -2)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}

	private static boolean checkEast1(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 0, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + 1, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + 2, y + -1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + 0, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + 1, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + 2, y + 0, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + 0, y + 1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + 1, y + 1, z + -1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + 2, y + 1, z
												+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + 1, y
														+ -1, z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(x + 2,
															y + -1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(
																x + 1, y + 0,
																z + 0)).getBlock() == FaithCraftBlocks.wineBlock) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 2,
																			y + 0,
																			z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																	if (world
																			.getBlockState(new BlockPos(
																					x + 1,
																					y + 1,
																					z + 0)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x + 2,
																						y + 1,
																						z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 0,
																							y
																							+ -1,
																							z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x + 1,
																								y
																								+ -1,
																								z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x + 2,
																									y
																									+ -1,
																									z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 0,
																										y + 0,
																										z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x + 1,
																											y + 0,
																											z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x + 2,
																												y + 0,
																												z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 0,
																													y + 1,
																													z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x + 1,
																														y + 1,
																														z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x + 2,
																															y + 1,
																															z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}

	private static boolean checkSouth1(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + 1, y + -1, z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + 1, y + 0, z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + 1, y + 1, z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + 1, y + 1,
												z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + 0, y
														+ -1, z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(x + 0,
															y + -1, z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(
																x + 0, y + 0,
																z + 1)).getBlock() == FaithCraftBlocks.wineBlock) {
															if (world
																	.getBlockState(new BlockPos(
																			x + 0,
																			y + 0,
																			z + 2)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																	if (world
																			.getBlockState(new BlockPos(
																					x + 0,
																					y + 1,
																					z + 1)).getBlock() == Blocks.air) {
																		if (world
																				.getBlockState(new BlockPos(
																						x + 0,
																						y + 1,
																						z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x
																							+ -1,
																							y
																							+ -1,
																							z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x
																								+ -1,
																								y
																								+ -1,
																								z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x
																									+ -1,
																									y
																									+ -1,
																									z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x
																										+ -1,
																										y + 0,
																										z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x
																											+ -1,
																											y + 0,
																											z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x
																												+ -1,
																												y + 0,
																												z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x
																													+ -1,
																													y + 1,
																													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x
																														+ -1,
																														y + 1,
																														z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x
																															+ -1,
																															y + 1,
																															z + 2)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}

	private static boolean checkWest1(World world, int x, int y, int z) {
		if (world.getBlockState(new BlockPos(x + 0, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
			if (world.getBlockState(new BlockPos(x + -1, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
				if (world.getBlockState(new BlockPos(x + -2, y + -1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
					if (world.getBlockState(new BlockPos(x + 0, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
						if (world.getBlockState(new BlockPos(x + -1, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyBlock) {
							if (world.getBlockState(new BlockPos(x + -2, y + 0, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
								if (world.getBlockState(new BlockPos(x + 0, y + 1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
									if (world.getBlockState(new BlockPos(x + -1, y + 1, z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
										if (world.getBlockState(new BlockPos(x + -2, y + 1,
												z + 1)).getBlock() == FaithCraftBlocks.HolyStone) {
											if (world.getBlockState(new BlockPos(x + 0, y + -1,
													z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
												if (world.getBlockState(new BlockPos(x + -1, y
														+ -1, z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
													if (world.getBlockState(new BlockPos(
															x + -2, y + -1,
															z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
														if (world.getBlockState(new BlockPos(x
																+ -1, y + 0,
																z + 0)).getBlock() == FaithCraftBlocks.wineBlock) {
															if (world
																	.getBlockState(new BlockPos(
																			x
																			+ -2,
																			y + 0,
																			z + 0)).getBlock() == FaithCraftBlocks.HolyBlock) {
																if (world
																		.getBlockState(new BlockPos(
																				x + 0,
																				y + 1,
																				z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
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
																						z + 0)).getBlock() == FaithCraftBlocks.HolyStone) {
																			if (world
																					.getBlockState(new BlockPos(
																							x + 0,
																							y
																							+ -1,
																							z
																							+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																				if (world
																						.getBlockState(new BlockPos(
																								x
																								+ -1,
																								y
																								+ -1,
																								z
																								+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																					if (world
																							.getBlockState(new BlockPos(
																									x
																									+ -2,
																									y
																									+ -1,
																									z
																									+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																						if (world
																								.getBlockState(new BlockPos(
																										x + 0,
																										y + 0,
																										z
																										+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																							if (world
																									.getBlockState(new BlockPos(
																											x
																											+ -1,
																											y + 0,
																											z
																											+ -1)).getBlock() == FaithCraftBlocks.HolyBlock) {
																								if (world
																										.getBlockState(new BlockPos(
																												x
																												+ -2,
																												y + 0,
																												z
																												+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																									if (world
																											.getBlockState(new BlockPos(
																													x + 0,
																													y + 1,
																													z
																													+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																										if (world
																												.getBlockState(new BlockPos(
																														x
																														+ -1,
																														y + 1,
																														z
																														+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
																											if (world
																													.getBlockState(new BlockPos(
																															x
																															+ -2,
																															y + 1,
																															z
																															+ -1)).getBlock() == FaithCraftBlocks.HolyStone) {
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
		return false;
	}
	
}