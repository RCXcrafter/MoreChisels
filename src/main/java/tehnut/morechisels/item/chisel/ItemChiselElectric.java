package tehnut.morechisels.item.chisel;

import java.util.List;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

public class ItemChiselElectric extends ItemChiselBase implements IElectricItem{

	private final int volume;
    
	public ItemChiselElectric() {
        super(ChiselType.ELECTRIC);
        this.volume = 1500;
        setMaxDamage(27);
    }

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
	}

	@Override
	public Item getChargedItem(ItemStack itemStack) {
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) {
		return this;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack) {
		return 10000;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 1;
	}

	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return 100;
	}
    
    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
    	ElectricItem.manager.discharge(chisel, 5, 1, true, false, false);
        return false;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return chisel.getItemDamage() < 26;
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        return player.getHeldItem().getItemDamage() < 26;
    }

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        return chisel.getItemDamage() < 26;
    }
}
