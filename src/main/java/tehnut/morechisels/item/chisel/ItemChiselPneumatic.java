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
import pneumaticCraft.api.item.IPressurizable;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

public class ItemChiselPneumatic extends ItemChiselBase implements IPressurizable{
	
	private static IIcon iconFlipped;
	
    public ItemChiselPneumatic(ChiselType type) {
        super(type);
    }

	@Override
	public float getPressure(ItemStack iStack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAir(ItemStack iStack, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float maxPressure(ItemStack iStack) {
		// TODO Auto-generated method stub
		return 0;
	}
 
}
