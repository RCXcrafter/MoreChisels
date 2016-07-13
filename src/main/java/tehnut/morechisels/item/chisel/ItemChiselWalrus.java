package tehnut.morechisels.item.chisel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

public class ItemChiselWalrus extends ItemChiselBase {
	
	private static IIcon iconFlipped;
	
    public ItemChiselWalrus() {
        super(ChiselType.WALRUS);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_walrus");
        iconFlipped = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_walrus_flipped");
    }
    
    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		return iconFlipped;
    }
}
