package FaithCraft2.Common.common.tileEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAltar extends TileEntity{
	private String localizedName;
	
	private ItemStack[] slots = new ItemStack [9];
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}
	
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.localizedName : "container.altar";
	}

	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public String setCustomInventoryName(String name){
		return "Altar";
	}
}