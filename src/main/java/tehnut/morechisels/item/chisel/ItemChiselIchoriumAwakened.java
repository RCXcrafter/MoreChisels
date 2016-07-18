package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselIchoriumAwakened extends ItemChiselBase {

    private static IIcon gemNone;
    private static IIcon gemGreen;
    private static IIcon gemRed;
    private static IIcon gemBlue;
    
    public ItemChiselIchoriumAwakened() {
        super(ChiselType.ICHORIUM);
        setUnlocalizedName(ModInformation.ID + ".chisel.ichoriumawakened");
        this.hasModes = true;
        this.canChiselBlock = true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return false;
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_ichorium");
        gemGreen = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_ichorium_gem_0");
        gemRed = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_ichorium_gem_1");
        gemBlue = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_ichorium_gem_2");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (stack.stackTagCompound == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag.getString("chiselMode") != null){
            if (tag.getString("chiselMode").toString() == "PANEL")
            return gemGreen;
        else if (tag.getString("chiselMode").toString() == "COLUMN")
            return gemRed;
        else if (tag.getString("chiselMode").toString() == "ROW")
            return gemBlue;
        else
            return itemIcon;
        }
        else
        	return itemIcon;

    }
}
