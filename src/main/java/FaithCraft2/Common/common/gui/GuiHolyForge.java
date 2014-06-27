package FaithCraft2.Common.common.gui;

import org.lwjgl.opengl.GL11;

import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.container.ContainerHolyForge;
import FaithCraft2.Common.common.tileEntity.TileEntityHolyForge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiHolyForge extends GuiContainer{

	public static final ResourceLocation bground = new ResourceLocation(FaithCraft2.modid + ":" + "textures/gui/HolyForgeGUI.png");
	
	public TileEntityHolyForge holyForge;
	
	public GuiHolyForge(InventoryPlayer inventoryPlayer, TileEntityHolyForge entity) {
		super(new ContainerHolyForge(inventoryPlayer, entity));

		this.holyForge = entity;

		this.xSize = 176;
		this.ySize = 166;
	}


	public void drawGuiContainerForegroundLayer(int par1, int par2) {

		String name = this.holyForge.hasCustomInventoryName() ? this.holyForge.getInventoryName() : I18n.format(this.holyForge.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.holyForge.isBurning()) {
			int k = this.holyForge.getBurnTimeRemainingScaled(45);
			int j = 45 - k;
			drawTexturedModalRect(guiLeft + 24, guiTop + 57, 176, 0, 45 - j, 16);
		}

		int k = this.holyForge.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 35, 176, 16, k + 1, 16);
	}

}
