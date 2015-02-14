package FaithCraft2.Common.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import FaithCraft2.Common.common.FaithCraft2;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HolyCobbleStone extends Block{
	
	private final String name = "HolyCobbleStone";
	
	public HolyCobbleStone(int i, Material material) {
		super(material);
		setUnlocalizedName(FaithCraft2.modid + ":" + name);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(5F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
	}
	
	public String getName(){
		return name;
	}
	
	/*public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);

        if (plant == Blocks.cactus && this == Blocks.cactus)
        {
            return true;
        }

        if (plant == Blocks.reeds && this == Blocks.reeds)
        {
            return true;
        }
		return true;
    }*/
}