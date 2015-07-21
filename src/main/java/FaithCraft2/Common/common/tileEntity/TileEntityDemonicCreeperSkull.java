package FaithCraft2.Common.common.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class TileEntityDemonicCreeperSkull extends TileEntity{
    private static int skullRotation;
    private GameProfile playerProfile = null;
    
    private int skullType = 0;
    
    public int getSkullType(){
    	return this.skullType;
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setByte("Rot", (byte)(this.skullRotation & 255));

        if (this.playerProfile != null)
        {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            NBTUtil.writeGameProfile(nbttagcompound1, this.playerProfile);
            compound.setTag("Owner", nbttagcompound1);
        }
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.skullRotation = compound.getByte("Rot");
    }

    public GameProfile getPlayerProfile()
    {
        return this.playerProfile;
    }

    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.pos, 4, nbttagcompound);
    }

    public void setType(int type)
    {
        this.playerProfile = null;
    }

    public void setPlayerProfile(GameProfile playerProfile)
    {
        this.playerProfile = playerProfile;
        this.updatePlayerProfile();
    }

    private void updatePlayerProfile()
    {
        this.playerProfile = updateGameprofile(this.playerProfile);
        this.markDirty();
    }

    public static GameProfile updateGameprofile(GameProfile input)
    {
        if (input != null && !StringUtils.isNullOrEmpty(input.getName()))
        {
            if (input.isComplete() && input.getProperties().containsKey("textures"))
            {
                return input;
            }
            else if (MinecraftServer.getServer() == null)
            {
                return input;
            }
            else
            {
                GameProfile gameprofile1 = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername(input.getName());

                if (gameprofile1 == null)
                {
                    return input;
                }
                else
                {
                    Property property = (Property)Iterables.getFirst(gameprofile1.getProperties().get("textures"), (Object)null);

                    if (property == null)
                    {
                        gameprofile1 = MinecraftServer.getServer().getMinecraftSessionService().fillProfileProperties(gameprofile1, true);
                    }

                    return gameprofile1;
                }
            }
        }
        else
        {
            return input;
        }
    }

    @SideOnly(Side.CLIENT)
    public static int getSkullRotation()
    {
        return skullRotation;
    }

    public void setSkullRotation(int rotation)
    {
        this.skullRotation = rotation;
    }
}
