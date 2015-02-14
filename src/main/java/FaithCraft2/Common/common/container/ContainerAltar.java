/*package FaithCraft2.Common.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.crafting.AltarCraftingManager;
import FaithCraft2.Common.common.tileEntity.TileEntityAltar;

public class ContainerAltar extends Container {

	public InventoryCrafting craftMatrix;
	public InventoryCraftResult craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerAltar(InventoryPlayer invPlayer, TileEntity tileEntity) {
		craftMatrix = new InventoryCrafting(this, 3, 3);
		craftResult = new InventoryCraftResult();

		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 124, 35));
        int l;
        int i1;

        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(invPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(invPlayer, l, 8 + l * 18, 142));
        }

        onCraftMatrixChanged(craftMatrix);
    }


	public void onCraftMatrixChanged(IInventory iinventory) {
		craftResult.setInventorySlotContents(0, AltarCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}


	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

	public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        InventoryPlayer inventoryplayer = par1EntityPlayer.inventory;

        if (inventoryplayer.getItemStack() != null)
        {
            par1EntityPlayer.dropPlayerItemWithRandomChoice(inventoryplayer.getItemStack(), false);
            inventoryplayer.setItemStack((ItemStack)null);
        }
    }


	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 >= 10 && par2 < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

}
*/