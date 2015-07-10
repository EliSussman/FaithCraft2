package FaithCraft2.Common.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class WineFluid extends Fluid{

	public static ResourceLocation still = new ResourceLocation("faithcraft2:blocks/WineStill");
	public static ResourceLocation flowing = new ResourceLocation("faithcraft2:blocks/WineFlow");
	
	public WineFluid(String fluidName, ResourceLocation still, ResourceLocation flowing){
		super("Wine", still, flowing);
		still = this.still;
		flowing = this.flowing;
	}
	
	@Override
	public ResourceLocation getStill(){
		return this.still;
	}
	
	@Override
	public ResourceLocation getFlowing(){
		return this.flowing;
	}
}
