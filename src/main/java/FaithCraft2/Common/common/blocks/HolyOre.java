package FaithCraft2.Common.common.blocks;

import FaithCraft2.Common.common.FaithCraft2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class HolyOre extends Block{

	private final String name = "HolyOre";
	
	public HolyOre(int i, Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(5F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	public String getName(){
		return name;
	}

}