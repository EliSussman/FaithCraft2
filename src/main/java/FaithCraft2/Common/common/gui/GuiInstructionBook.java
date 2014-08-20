package FaithCraft2.Common.common.gui;

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
	
	private NextPageButton prevPage;
	private NextPageButton nextPage;
    private int bookTotalPages = 2;
    public int currPage;
    private NBTTagList bookPages;
	private boolean field_146480_s;
    private GuiInstructionBook.NextPageButton buttonNextPage;
    private GuiInstructionBook.NextPageButton buttonPreviousPage;
    private ItemStack bookStack;
    private NBTTagCompound bookInfo;
	private int bookImageWidth = 166;
	private int bookImageHeight = 185;
	private static final ResourceLocation FaithCraft2InstructionBookTextureP1 = new ResourceLocation(FaithCraft2.modid + ":" + "textures/gui/bookPage1.png");
	private static final ResourceLocation FaithCraft2InstructionBookTextureP2 = new ResourceLocation(FaithCraft2.modid + ":" + "textures/gui/bookPage2.png");
	
	public void updateScreen() {
		
	}
	
	/*public void initGui(){
		this.buttonList.clear();
        int i = (this.width - this.bookImageWidth) / 2;
        int b0 = (this.height - this.bookImageHeight) / 2;
        this.buttonList.add(this.nextPage = new NextPageButton(0, 10, 100, 50, 20, "Next"));
        this.buttonList.add(this.prevPage = new NextPageButton(1, 10, 130, 50, 20, "Previous"));
        this.updateButtons();
	}*/
	
	 public void updateButtons()
	    {
		 	this.buttonNextPage.visible = (this.currPage < this.bookTotalPages - 1);
		 	this.buttonPreviousPage.visible = this.currPage > 0;
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
    
    @Override
    public void actionPerformed(GuiButton nextPage){
		if(nextPage.mousePressed(Minecraft.getMinecraft(), nextPage.xPosition, nextPage.yPosition)){
			++this.currPage;
			this.updateScreen();
		}
    }
    
    @SideOnly(Side.CLIENT)
    public static class NextPageButton extends GuiButton
        {
            private final boolean field_146151_o;
            private int bookTotalPages = 2;
            private NextPageButton prevPage;
        	private NextPageButton nextPage;
        	private GuiInstructionBook gib;
        	private NBTTagList bookPages;
            
            public NextPageButton(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_)
            {
            	super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 33, "");
                this.field_146151_o = p_i1079_4_;
                
            }

			/**
             * Draws this button to the screen.
             */
            public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
            {
                if (this.visible)
                {
                    boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition + 20 && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height + 20;
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    p_146112_1_.getTextureManager().bindTexture(GuiInstructionBook.FaithCraft2InstructionBookTextureP1);
                    int k = 0;
                    int l = 192;

                    if (flag)
                    {
                        k += 23;
                    }

                    if (!this.field_146151_o)
                    {
                        l += 33;
                    }

                    this.drawTexturedModalRect(this.xPosition, this.yPosition + 20, k, l, 23, 13);
                }
            }
        }
}
