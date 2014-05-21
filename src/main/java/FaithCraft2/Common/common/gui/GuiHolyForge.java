package FaithCraft2.Common.common.gui;

import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.container.ContainerHolyForge;
import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiHolyForge extends GuiContainer{

	public static final ResourceLocation bground = new ResourceLocation(FaithCraft2.modid, "textures/gui/HolyForgeGUI.png");
	
	public TileEntityHolyForge holyForge;
	
	public GuiHolyForge(InventoryPlayer inventoryPlayer, TileEntityHolyForge entity) {
		super(new ContainerHolyForge(inventoryPlayer, entity));
		
		this.holyForge = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForgroundLayer(int par1, int par2){
		String name = holyForge.hasCustomInventoryName() ? this.holyForge.getInventoryName() : I18n.format(this.holyForge.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 128, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
	}

}
