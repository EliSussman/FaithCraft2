package FaithCraft2.Common.common.tileEntity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityHolyForge extends TileEntity{

	private String localizedName;
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}

}
