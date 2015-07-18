package FaithCraft2.Common.common.dimension.heaven;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.NETHER_CAVE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.QUARTZ;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.FIRE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.GLOWSTONE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.NETHER_LAVA;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.NETHER_LAVA2;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.GeneratorBushFeature;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import FaithCraft2.Common.common.blocks.FaithCraftBlocks;

public class ChunkProviderHeaven implements IChunkProvider
{private final World worldObj;
private final boolean field_177466_i;
private final Random heavenRNG;
private double[] slowsandNoise = new double[256];
private double[] gravelNoise = new double[256];
private double[] netherrackExclusivityNoise = new double[256];
private double[] noiseField;
private final NoiseGeneratorOctaves netherNoiseGen1;
private final NoiseGeneratorOctaves netherNoiseGen2;
private final NoiseGeneratorOctaves netherNoiseGen3;
private final NoiseGeneratorOctaves slowsandGravelNoiseGen;
private final NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
public final NoiseGeneratorOctaves netherNoiseGen6;
public final NoiseGeneratorOctaves netherNoiseGen7;
private final WorldGenFire field_177470_t = new WorldGenFire();
private final WorldGenGlowStone1 field_177469_u = new WorldGenGlowStone1();
private final WorldGenGlowStone2 field_177468_v = new WorldGenGlowStone2();
private final WorldGenerator field_177467_w;
private final WorldGenHellLava field_177473_x;
private final WorldGenHellLava field_177472_y;
private final GeneratorBushFeature field_177471_z;
private final GeneratorBushFeature field_177465_A;
private final MapGenBase netherCaveGenerator;
double[] noiseData1;
double[] noiseData2;
double[] noiseData3;
double[] noiseData4;
double[] noiseData5;

public ChunkProviderHeaven(World worldIn, boolean p_i45637_2_, long p_i45637_3_)
{
    this.field_177467_w = new WorldGenMinable(Blocks.diamond_ore.getDefaultState(), 14, BlockHelper.forBlock(FaithCraftBlocks.HolyCobbleStone));
    this.field_177473_x = new WorldGenHellLava(FaithCraftBlocks.wineBlock, true);
    this.field_177472_y = new WorldGenHellLava(FaithCraftBlocks.wineBlock, false);
    this.field_177471_z = new GeneratorBushFeature(Blocks.red_flower);
    this.field_177465_A = new GeneratorBushFeature(Blocks.yellow_flower);
    this.netherCaveGenerator = TerrainGen.getModdedMapGen(new MapGenCavesHell(), NETHER_CAVE);
    this.worldObj = worldIn;
    this.field_177466_i = p_i45637_2_;
    this.heavenRNG = new Random(p_i45637_3_);

    NoiseGenerator[] noiseGens =
    {
            new NoiseGeneratorOctaves(this.heavenRNG, 16),
            new NoiseGeneratorOctaves(this.heavenRNG, 16),
            new NoiseGeneratorOctaves(this.heavenRNG, 8),
            new NoiseGeneratorOctaves(this.heavenRNG, 4),
            new NoiseGeneratorOctaves(this.heavenRNG, 4),
            new NoiseGeneratorOctaves(this.heavenRNG, 10),
            new NoiseGeneratorOctaves(this.heavenRNG, 16)
    };
    noiseGens = TerrainGen.getModdedNoiseGenerators(worldIn, this.heavenRNG, noiseGens);
    this.netherNoiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
    this.netherNoiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
    this.netherNoiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
    this.slowsandGravelNoiseGen = (NoiseGeneratorOctaves)noiseGens[3];
    this.netherrackExculsivityNoiseGen = (NoiseGeneratorOctaves)noiseGens[4];
    this.netherNoiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
    this.netherNoiseGen7 = (NoiseGeneratorOctaves)noiseGens[6];
}

public void func_180515_a(int p_180515_1_, int p_180515_2_, ChunkPrimer p_180515_3_)
{
    byte b0 = 4;
    byte b1 = 32;
    int k = b0 + 1;
    byte b2 = 17;
    int l = b0 + 1;
    this.noiseField = this.initializeNoiseField(this.noiseField, p_180515_1_ * b0, 0, p_180515_2_ * b0, k, b2, l);

    for (int i1 = 0; i1 < b0; ++i1)
    {
        for (int j1 = 0; j1 < b0; ++j1)
        {
            for (int k1 = 0; k1 < 16; ++k1)
            {
                double d0 = 0.125D;
                double d1 = this.noiseField[((i1 + 0) * l + j1 + 0) * b2 + k1 + 0];
                double d2 = this.noiseField[((i1 + 0) * l + j1 + 1) * b2 + k1 + 0];
                double d3 = this.noiseField[((i1 + 1) * l + j1 + 0) * b2 + k1 + 0];
                double d4 = this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 0];
                double d5 = (this.noiseField[((i1 + 0) * l + j1 + 0) * b2 + k1 + 1] - d1) * d0;
                double d6 = (this.noiseField[((i1 + 0) * l + j1 + 1) * b2 + k1 + 1] - d2) * d0;
                double d7 = (this.noiseField[((i1 + 1) * l + j1 + 0) * b2 + k1 + 1] - d3) * d0;
                double d8 = (this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 1] - d4) * d0;

                for (int l1 = 0; l1 < 8; ++l1)
                {
                    double d9 = 0.25D;
                    double d10 = d1;
                    double d11 = d2;
                    double d12 = (d3 - d1) * d9;
                    double d13 = (d4 - d2) * d9;

                    for (int i2 = 0; i2 < 4; ++i2)
                    {
                        double d14 = 0.25D;
                        double d15 = d10;
                        double d16 = (d11 - d10) * d14;

                        for (int j2 = 0; j2 < 4; ++j2)
                        {
                            IBlockState iblockstate = null;

                            if (k1 * 8 + l1 < b1)
                            {
                                iblockstate = FaithCraftBlocks.wineBlock.getDefaultState();
                            }

                            if (d15 > 0.0D)
                            {
                                iblockstate = FaithCraftBlocks.HolyCobbleStone.getDefaultState();
                            }

                            int k2 = i2 + i1 * 4;
                            int l2 = l1 + k1 * 8;
                            int i3 = j2 + j1 * 4;
                            p_180515_3_.setBlockState(k2, l2, i3, iblockstate);
                            d15 += d16;
                        }

                        d10 += d12;
                        d11 += d13;
                    }

                    d1 += d5;
                    d2 += d6;
                    d3 += d7;
                    d4 += d8;
                }
            }
        }
    }
}

public void func_180516_b(int p_180516_1_, int p_180516_2_, ChunkPrimer p_180516_3_)
{
    ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_180516_1_, p_180516_2_, p_180516_3_, this.worldObj);
    MinecraftForge.EVENT_BUS.post(event);
    if (event.getResult() == Result.DENY) return;

    byte b0 = 64;
    double d0 = 0.03125D;
    this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, p_180516_1_ * 16, p_180516_2_ * 16, 0, 16, 16, 1, d0, d0, 1.0D);
    this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, p_180516_1_ * 16, 109, p_180516_2_ * 16, 16, 1, 16, d0, 1.0D, d0);
    this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.netherrackExclusivityNoise, p_180516_1_ * 16, p_180516_2_ * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);

    for (int k = 0; k < 16; ++k)
    {
        for (int l = 0; l < 16; ++l)
        {
            boolean flag = this.slowsandNoise[k + l * 16] + this.heavenRNG.nextDouble() * 0.2D > 0.0D;
            boolean flag1 = this.gravelNoise[k + l * 16] + this.heavenRNG.nextDouble() * 0.2D > 0.0D;
            int i1 = (int)(this.netherrackExclusivityNoise[k + l * 16] / 3.0D + 3.0D + this.heavenRNG.nextDouble() * 0.25D);
            int j1 = -1;
            IBlockState iblockstate = FaithCraftBlocks.HolyCobbleStone.getDefaultState();
            IBlockState iblockstate1 = FaithCraftBlocks.HolyCobbleStone.getDefaultState();

            for (int k1 = 127; k1 >= 0; --k1)
            {
                if (k1 < 127 - this.heavenRNG.nextInt(5) && k1 > this.heavenRNG.nextInt(5))
                {
                    IBlockState iblockstate2 = p_180516_3_.getBlockState(l, k1, k);

                    if (iblockstate2.getBlock() != null && iblockstate2.getBlock().getMaterial() != Material.air)
                    {
                        if (iblockstate2.getBlock() == FaithCraftBlocks.HolyCobbleStone)
                        {
                            if (j1 == -1)
                            {
                                if (i1 <= 0)
                                {
                                    iblockstate = null;
                                    iblockstate1 = FaithCraftBlocks.HolyCobbleStone.getDefaultState();
                                }
                                else if (k1 >= b0 - 4 && k1 <= b0 + 1)
                                {
                                    iblockstate = FaithCraftBlocks.HolyCobbleStone.getDefaultState();
                                    iblockstate1 = FaithCraftBlocks.HolyCobbleStone.getDefaultState();

                                    if (flag1)
                                    {
                                        iblockstate = FaithCraftBlocks.HolyOre.getDefaultState();
                                        iblockstate1 = FaithCraftBlocks.HolyCobbleStone.getDefaultState();
                                    }

                                    if (flag)
                                    {
                                        iblockstate = FaithCraftBlocks.HolyStone.getDefaultState();
                                        iblockstate1 = FaithCraftBlocks.HolyStone.getDefaultState();
                                    }
                                }

                                if (k1 < b0 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air))
                                {
                                    iblockstate = FaithCraftBlocks.wineBlock.getDefaultState();
                                }

                                j1 = i1;

                                if (k1 >= b0 - 1)
                                {
                                    p_180516_3_.setBlockState(l, k1, k, iblockstate);
                                }
                                else
                                {
                                    p_180516_3_.setBlockState(l, k1, k, iblockstate1);
                                }
                            }
                            else if (j1 > 0)
                            {
                                --j1;
                                p_180516_3_.setBlockState(l, k1, k, iblockstate1);
                            }
                        }
                    }
                    else
                    {
                        j1 = -1;
                    }
                }
                else
                {
                    p_180516_3_.setBlockState(l, k1, k, Blocks.bedrock.getDefaultState());
                }
            }
        }
    }
}

public Chunk provideChunk(int x, int z)
{
    this.heavenRNG.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
    ChunkPrimer chunkprimer = new ChunkPrimer();
    this.func_180515_a(x, z, chunkprimer);
    this.func_180516_b(x, z, chunkprimer);
    this.netherCaveGenerator.func_175792_a(this, this.worldObj, x, z, chunkprimer);

    Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
    BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[])null, x * 16, z * 16, 16, 16);
    byte[] abyte = chunk.getBiomeArray();

    for (int k = 0; k < abyte.length; ++k)
    {
        abyte[k] = (byte)abiomegenbase[k].biomeID;
    }

    chunk.resetRelightChecks();
    return chunk;
}

private double[] initializeNoiseField(double[] p_73164_1_, int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_)
{
    ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, p_73164_1_, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_);
    MinecraftForge.EVENT_BUS.post(event);
    if (event.getResult() == Result.DENY) return event.noisefield;

    if (p_73164_1_ == null)
    {
        p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
    }

    double d0 = 684.412D;
    double d1 = 2053.236D;
    this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
    this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100.0D, 0.0D, 100.0D);
    this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0 / 80.0D, d1 / 60.0D, d0 / 80.0D);
    this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
    this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
    int k1 = 0;
    double[] adouble1 = new double[p_73164_6_];
    int l1;

    for (l1 = 0; l1 < p_73164_6_; ++l1)
    {
        adouble1[l1] = Math.cos((double)l1 * Math.PI * 6.0D / (double)p_73164_6_) * 2.0D;
        double d2 = (double)l1;

        if (l1 > p_73164_6_ / 2)
        {
            d2 = (double)(p_73164_6_ - 1 - l1);
        }

        if (d2 < 4.0D)
        {
            d2 = 4.0D - d2;
            adouble1[l1] -= d2 * d2 * d2 * 10.0D;
        }
    }

    for (l1 = 0; l1 < p_73164_5_; ++l1)
    {
        for (int j2 = 0; j2 < p_73164_7_; ++j2)
        {
            double d3 = 0.0D;

            for (int i2 = 0; i2 < p_73164_6_; ++i2)
            {
                double d4 = 0.0D;
                double d5 = adouble1[i2];
                double d6 = this.noiseData2[k1] / 512.0D;
                double d7 = this.noiseData3[k1] / 512.0D;
                double d8 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;

                if (d8 < 0.0D)
                {
                    d4 = d6;
                }
                else if (d8 > 1.0D)
                {
                    d4 = d7;
                }
                else
                {
                    d4 = d6 + (d7 - d6) * d8;
                }

                d4 -= d5;
                double d9;

                if (i2 > p_73164_6_ - 4)
                {
                    d9 = (double)((float)(i2 - (p_73164_6_ - 4)) / 3.0F);
                    d4 = d4 * (1.0D - d9) + -10.0D * d9;
                }

                if ((double)i2 < d3)
                {
                    d9 = (d3 - (double)i2) / 4.0D;
                    d9 = MathHelper.clamp_double(d9, 0.0D, 1.0D);
                    d4 = d4 * (1.0D - d9) + -10.0D * d9;
                }

                p_73164_1_[k1] = d4;
                ++k1;
            }
        }
    }

    return p_73164_1_;
}

public boolean chunkExists(int x, int z)
{
    return true;
}

public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_)
{
    BlockFalling.fallInstantly = true;

    MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(p_73153_1_, worldObj, heavenRNG, p_73153_2_, p_73153_3_, false));

    BlockPos blockpos = new BlockPos(p_73153_2_ * 16, 0, p_73153_3_ * 16);
    ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(p_73153_2_, p_73153_3_);
    int k;

    boolean doGen = TerrainGen.populate(p_73153_1_, worldObj, heavenRNG, p_73153_2_, p_73153_3_, false, NETHER_LAVA);
    for (k = 0; doGen && k < 8; ++k)
    {
        this.field_177472_y.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16) + 8, this.heavenRNG.nextInt(120) + 4, this.heavenRNG.nextInt(16) + 8));
    }

    doGen = TerrainGen.populate(p_73153_1_, worldObj, heavenRNG, p_73153_2_, p_73153_3_, false, FIRE);
    for (k = 0; doGen && k < this.heavenRNG.nextInt(this.heavenRNG.nextInt(10) + 1) + 1; ++k)
    {
        this.field_177470_t.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16) + 8, this.heavenRNG.nextInt(120) + 4, this.heavenRNG.nextInt(16) + 8));
    }

    doGen = TerrainGen.populate(p_73153_1_, worldObj, heavenRNG, p_73153_2_, p_73153_3_, false, GLOWSTONE);
    for (k = 0; doGen && k < this.heavenRNG.nextInt(this.heavenRNG.nextInt(10) + 1); ++k)
    {
        this.field_177469_u.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16) + 8, this.heavenRNG.nextInt(120) + 4, this.heavenRNG.nextInt(16) + 8));
    }

    for (k = 0; doGen && k < 10; ++k)
    {
        this.field_177468_v.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16) + 8, this.heavenRNG.nextInt(128), this.heavenRNG.nextInt(16) + 8));
    }

    MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldObj, heavenRNG, blockpos));

    doGen = TerrainGen.decorate(worldObj, heavenRNG, blockpos, SHROOM);
    if (doGen && this.heavenRNG.nextBoolean())
    {
        this.field_177471_z.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16) + 8, this.heavenRNG.nextInt(128), this.heavenRNG.nextInt(16) + 8));
    }

    if (doGen && this.heavenRNG.nextBoolean())
    {
        this.field_177465_A.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16) + 8, this.heavenRNG.nextInt(128), this.heavenRNG.nextInt(16) + 8));
    }

    doGen = TerrainGen.generateOre(worldObj, heavenRNG, field_177467_w, blockpos, QUARTZ);
    for (k = 0; doGen && k < 16; ++k)
    {
        this.field_177467_w.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16), this.heavenRNG.nextInt(108) + 10, this.heavenRNG.nextInt(16)));
    }

    doGen = TerrainGen.populate(p_73153_1_, worldObj, heavenRNG, p_73153_2_, p_73153_3_, false, NETHER_LAVA2);
    for (k = 0; doGen && k < 16; ++k)
    {
        this.field_177473_x.generate(this.worldObj, this.heavenRNG, blockpos.add(this.heavenRNG.nextInt(16), this.heavenRNG.nextInt(108) + 10, this.heavenRNG.nextInt(16)));
    }

    BlockFalling.fallInstantly = false;
}

public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_)
{
    return false;
}

public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_)
{
    return true;
}

public void saveExtraData() {}

public boolean unloadQueuedChunks()
{
    return false;
}

public boolean canSave()
{
    return true;
}

public String makeString()
{
    return "HeavenRandomLevelSource";
}

public BlockPos getStrongholdGen(World worldIn, String p_180513_2_, BlockPos p_180513_3_)
{
    return null;
}

public int getLoadedChunkCount()
{
    return 0;
}

public Chunk provideChunk(BlockPos blockPosIn)
{
    return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
}

@Override
public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
	return null;
}

@Override
public void recreateStructures(Chunk p_180514_1_, int p_180514_2_,int p_180514_3_) {
	
}
}