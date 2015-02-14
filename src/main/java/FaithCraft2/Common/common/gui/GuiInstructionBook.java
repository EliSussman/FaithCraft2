/*package FaithCraft2.Common.common.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import FaithCraft2.Common.common.FaithCraft2;
import FaithCraft2.Common.common.items.InstructionBook;

public class GuiInstructionBook extends GuiScreen{
	
    private int bookTotalPages = 2;
    public int currPage;
    private NBTTagList bookPages;
	private boolean field_146480_s;
    private ItemStack bookStack;
    private NBTTagCompound bookInfo;
	private int bookImageWidth = 166;
	private int bookImageHeight = 185;
	private static final ResourceLocation FaithCraft2InstructionBookTextureP1 = new ResourceLocation(FaithCraft2.modid + ":" + "textures/gui/bookPage1.png");
	private static final ResourceLocation FaithCraft2InstructionBookTextureP2 = new ResourceLocation(FaithCraft2.modid + ":" + "textures/gui/bookPage2.png");
	
	public void updateScreen() {
		
	}
	
	public void initGui(){
		 super.initGui();
		 this.buttonList.add(new GuiButton(5, 300, 200, 100, 20, "Next"));
		 this.buttonList.add(new GuiButton(6, 50, 200, 100, 20, "Back"));
	}
	
	 @Override
	 protected void actionPerformed(GuiButton button)
	 {
		 if(button.id == 5){
			 this.currPage = 1;
		 }else if(button.id == 6){
			 this.currPage = 0;
		 }
	 }
	
	
	public GuiInstructionBook() {
		super();
	}
    
    @Override
    public void drawDefaultBackground()
    {
    	super.drawDefaultBackground();
    }
    
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
       drawDefaultBackground();
       if(currPage > 0){
			this.mc.getTextureManager().bindTexture(FaithCraft2InstructionBookTextureP2);
		}else{
			this.mc.getTextureManager().bindTexture(FaithCraft2InstructionBookTextureP1);
		}
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int k = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
        super.drawScreen(par1, par2, par3);
    }
    
    public void chooseDrawScreen(int par1, int par2, float par3){
    	drawScreen(par1, par2, par3);
    }
    
    @Override
	public boolean doesGuiPauseGame()
    {
        return true;
    }
}
*/
