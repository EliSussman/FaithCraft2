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
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

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
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + 1 * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
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
        if (slot == 0) {
            this.holyForge.cookTime = newValue;
        }

        if (slot == 1) {
            this.holyForge.burnTime = newValue;
        }

        if (slot == 2) {
            this.holyForge.currentItemBurnTime = newValue;
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2){
                if (!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0){
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1)){
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)){
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false)){
                return null;
            }

            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }
            else{
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize){
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
	
}
