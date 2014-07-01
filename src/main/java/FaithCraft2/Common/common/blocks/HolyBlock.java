package FaithCraft2.Common.common.blocks;

import FaithCraft2.Common.common.FaithCraft2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class HolyBlock extends Block{
	public HolyBlock(int i, Material material) {
		super(material);
		this.setCreativeTab(FaithCraft2.FaithCraft2Tab);
		this.setHardness(6F);
		this.setResistance(11.0F);
		this.setLightLevel(1.0F);
	}
	
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
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
    }
}
