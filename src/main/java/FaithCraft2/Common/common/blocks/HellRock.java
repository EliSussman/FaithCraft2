package FaithCraft2.Common.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import FaithCraft2.Common.common.FaithCraft2;

public class HellRock extends Block{
	
	private final String name = "HellRock";
	
	public HellRock(int id, Material material) {
		super(material);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(1.0F);
		this.setLightLevel(1.5F);
	}
	
	public String getName(){
		return name;
	}
	
	public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
}