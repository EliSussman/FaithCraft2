package FaithCraft2.Common.common.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;

public class Angel extends EntityVillager implements INpc, IMerchant{

	 private boolean isLookingForHome;
	 Village villageObj;
	 private EntityPlayer buyingPlayer;
	 private MerchantRecipeList buyingList;
	 private int timeUntilReset;
	 private boolean needsInitilization;
	 private int wealth;
	 private String lastBuyingPlayer;
	 private float field_82191_bN;
	 public static final Map angelSellingList = new HashMap();
	 private int randomTickDivider;
	 private IMerchant field_147037_w;
	
	public Angel(World world) {
		super(world);
		this.tasks.addTask(1, new EntityAITradePlayer(this));
	}
	
	public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;

        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !player.isSneaking())
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(player);
                player.displayVillagerTradeGui(this);
            }

            return true;
        }
        else
        {
            return super.interact(player);
        }
    }
	
	@Override
	public IChatComponent getDisplayName(){
		return new ChatComponentText("Angel");
	}
	
	@Override
	protected void updateAITick()
    {
        if (--this.randomTickDivider <= 0)
        {
            this.worldObj.villageCollectionObj.addToVillagerPositionList(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)));
            this.randomTickDivider = 70 + this.rand.nextInt(50);
        }

        if (!this.isTrading() && this.timeUntilReset > 0)
        {
            --this.timeUntilReset;

            if (this.timeUntilReset <= 0)
            {
                if (this.needsInitilization)
                {
                    if (this.buyingList.size() > 1)
                    {
                        Iterator iterator = this.buyingList.iterator();

                        while (iterator.hasNext())
                        {
                            MerchantRecipe MerchantRecipe = (MerchantRecipe)iterator.next();

                            if (MerchantRecipe.isRecipeDisabled())
                            {
                                MerchantRecipe.increaseMaxTradeUses(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                    }

                    this.addDefaultEquipmentAndRecipies(1);
                    this.needsInitilization = false;

                    if (this.villageObj != null && this.lastBuyingPlayer != null)
                    {
                        this.worldObj.setEntityState(this, (byte)14);
                        this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
                    }
                }

                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }

        super.updateAITick();
    }
	
	@Override
	protected String getLivingSound()
    {
        return null;
    }
	
	@Override
    protected String getHurtSound()
    {
		return null;
    }
    
    @Override
    protected String getDeathSound()
    {
    	return null;
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
    }
	
	@Override
	public MerchantRecipeList getRecipes(EntityPlayer entityPlayer){
		if (this.buyingList == null)
        {
            this.addDefaultEquipmentAndRecipies(1);
        }

        return this.buyingList;
		
	}
	
	public boolean isAIEnabled()
    {
        return true;
    }
	
	protected boolean canDespawn()
    {
        return false;
    }

	public void setCustomer(EntityPlayer p_70932_1_) {
		this.buyingPlayer = p_70932_1_;
	}


	public EntityPlayer getCustomer() {
		return this.buyingPlayer;
	}
	
	public boolean isTrading()
    {
        return this.buyingPlayer != null;
    }

	public static void func_146091_a(MerchantRecipeList p_146091_0_, Item p_146091_1_, Random p_146091_2_, float p_146091_3_)
    {
        if (p_146091_2_.nextFloat() < p_146091_3_)
        {
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyCross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyCross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyCross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyCross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Cross));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.Bible));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyBoots));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyChestplate));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyLeggings));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyHelmet));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyGrail));
            p_146091_0_.add(new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), FaithCraft2.HolyGrail));
        }
    }

    private static ItemStack func_146088_a(Item p_146088_0_, Random p_146088_1_)
    {
        return new ItemStack(p_146088_0_, func_146092_b(p_146088_0_, p_146088_1_), 0);
    }

    private static int func_146092_b(Item p_146092_0_, Random p_146092_1_)
    {
        Tuple tuple = (Tuple)angelSellingList.get(p_146092_0_);
        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + p_146092_1_.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
    }

    private static int func_146090_c(Item p_146090_0_, Random p_146090_1_)
    {
        Tuple tuple = (Tuple)angelSellingList.get(p_146090_0_);
        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + p_146090_1_.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
    }

	private void addDefaultEquipmentAndRecipies(int p_70950_1_) {
		if (this.buyingList != null)
        {
            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
        }
        else
        {
            this.field_82191_bN = 0.0F;
        }

        MerchantRecipeList MerchantRecipeList;
        MerchantRecipeList = new MerchantRecipeList();
        int k;

        switch (this.getProfession())
        {
            case 0:
                
                func_146091_a(MerchantRecipeList, Items.emerald, this.rand, this.adjustProbability(1.0F));
                
        }

        if (MerchantRecipeList.isEmpty())
        {
        	func_146091_a(MerchantRecipeList, Items.emerald, this.rand, 1.0F);
        }

        Collections.shuffle(MerchantRecipeList);

        if (this.buyingList == null)
        {
            this.buyingList = new MerchantRecipeList();
        }

        for (int l = 0; l < p_70950_1_ && l < MerchantRecipeList.size(); ++l)
        {
            this.buyingList.add(MerchantRecipeList.get(1));
        }
	}


	private float adjustProbability(float p_82188_1_)
    {
        float f1 = p_82188_1_ + this.field_82191_bN;
        return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
    }

	public void func_110297_a_(ItemStack p_110297_1_) {
		if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20)
        {
            this.livingSoundTime = -this.getTalkInterval();

            if (p_110297_1_ != null)
            {
                this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
            }
            else
            {
                this.playSound("mob.villager.no", this.getSoundVolume(), this.getSoundPitch());
            }
        }
	}

	@Override
	public Angel createChild(EntityAgeable p_90011_1_)
    {
        return null;
    }

    public boolean allowLeashing()
    {
        return true;
    }
	
}