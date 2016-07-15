package tehnut.morechisels.item.chisel;

import java.util.List;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import pneumaticCraft.api.item.IPressurizable;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

public class ItemChiselPneumatic extends ItemChiselBase implements IPressurizable{

	private final int volume;
    
	public ItemChiselPneumatic() {
        super(ChiselType.PNEUMATIC);
        boolean canChiselBlock = true;
        boolean hasModes = true;
        setNoRepair();
        setMaxDamage(ChiselType.PNEUMATIC.durability * 100);
        this.volume = 1500;
    }

	@Override
	public float getPressure(ItemStack iStack) {
		return (float)(getMaxDamage() - iStack.getItemDamage()) / (float)volume;
	}

	@Override
	public void addAir(ItemStack iStack, int amount) {
		iStack.setItemDamage(iStack.getItemDamage() - amount);
	}

	@Override
	public float maxPressure(ItemStack iStack) {
		return 10F;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		String base = "item.chisel.chisel.desc.";
		String gui = I18n.format(base + "gui");
		String lc1 = I18n.format(base + "lc1");
		String lc2 = I18n.format(base + "lc2");
		String modes = I18n.format(base + "modes");
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        list.add("Pressure: " + Math.round(getPressure(stack) * 10D) / 10D + " bar");
		list.add(gui);
		list.add(lc1);
		list.add(lc2);
		list.add("");
		list.add(modes);
    }
    
    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
    	chisel.setItemDamage(chisel.getItemDamage() + 100);
        return false;
    }
    
    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return getPressure(chisel) > 0.5F;
    }
    
    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        return getPressure(player.getHeldItem()) > 0.5F;
    }
    
    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        return getPressure(chisel) > 0.5F;
    }
}
