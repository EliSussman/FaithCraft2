package FaithCraft2.Common.common.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

public class ContainerHolyForge extends Container{
	
	private TileEntityHolyForge holyForge;
	
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	
	public ContainerHolyForge(InventoryPlayer inventory, TileEntityHolyForge tileentity){
		this.holyForge = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 61, 35));
		this.addSlotToContainer(new Slot(tileentity, 1, 5, 57));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 9; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 94 + 1 * 18));
			}
		}
		
		for(int i = 0; 1 < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.holyForge.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.holyForge.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.holyForge.currentItemBurnTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.holyForge.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.holyForge.cookTime);
			}
			if(this.lastBurnTime != this.holyForge.burnTime){
				icrafting.sendProgressBarUpdate(this, 1, this.holyForge.burnTime);
			}
			if(this.lastCurrentItemBurnTime != this.holyForge.currentItemBurnTime){
				icrafting.sendProgressBarUpdate(this, 2, this.holyForge.currentItemBurnTime);
			}
		}
		this.lastCookTime = this.holyForge.cookTime;
		this.lastBurnTime = this.holyForge.burnTime;
		this.lastCurrentItemBurnTime = this.holyForge.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue){
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
