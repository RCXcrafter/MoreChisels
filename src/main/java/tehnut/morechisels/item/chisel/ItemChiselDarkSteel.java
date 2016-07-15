package tehnut.morechisels.item.chisel;

import java.awt.Color;
import java.util.List;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;

import cofh.api.energy.IEnergyContainerItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazypants.enderio.EnderIO;
import crazypants.enderio.config.Config;
import crazypants.enderio.item.darksteel.DarkSteelRecipeManager;
import crazypants.enderio.item.darksteel.IDarkSteelItem;
import crazypants.enderio.item.darksteel.PoweredItemRenderer;
import crazypants.enderio.item.darksteel.upgrade.EnergyUpgrade;
import crazypants.enderio.machine.power.PowerDisplayUtil;

import com.enderio.core.api.client.gui.IAdvancedTooltipProvider;
import com.enderio.core.client.render.ColorUtil;
import com.enderio.core.client.render.RenderUtil;
import com.enderio.core.common.util.ItemUtil;
import com.enderio.core.common.vecmath.Vector4f;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import pneumaticCraft.api.item.IPressurizable;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import static tehnut.morechisels.compat.CompatibilityEnderIO.chiselDarksteel;

public class ItemChiselDarksteel extends ItemChiselBase implements IEnergyContainerItem, IAdvancedTooltipProvider, IDarkSteelItem{

	public ItemChiselDarksteel() {
        super(ChiselType.DARKSTEEL);
        setNoRepair();
    }

	  public static ItemChiselDarksteel create() {
	    ItemChiselDarksteel res = new ItemChiselDarksteel();
	    res.init();
	    MinecraftForge.EVENT_BUS.register(res);
	    return res;
	  }

	  @Override
	  @SideOnly(Side.CLIENT)
	  public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List par3List) {
	    ItemStack is = new ItemStack(this);
	    par3List.add(is);

	    is = new ItemStack(this);
	    EnergyUpgrade.EMPOWERED_FOUR.writeToItem(is);
	    EnergyUpgrade.setPowerFull(is);
	    par3List.add(is);
	  }

	  @Override
	  public int getIngotsRequiredForFullRepair() {
	    return 1;
	  }
	  
	  @Override
	  public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
		    int oldDamage = getDamage(chisel);
		    int newDamage = getDamage(chisel)+1;
		    if (newDamage <= oldDamage) {
		      super.setDamage(chisel, newDamage);
		    } else {
		      int damage = newDamage - oldDamage;
		  
		      if (!absorbDamageWithEnergy(chisel, damage * Config.darkSteelPickPowerUsePerDamagePoint)) {
		        super.setDamage(chisel, newDamage);
		      }
		    }
		  return false;
	  }
	  
	  private boolean absorbDamageWithEnergy(ItemStack stack, int amount) {
	    EnergyUpgrade eu = EnergyUpgrade.loadFromItem(stack);
	    if(eu != null && eu.isAbsorbDamageWithPower(stack) && eu.getEnergy() > 0) {
	      eu.extractEnergy(amount, false);
	      eu.writeToItem(stack);
	      return true;
	    } else {
	      return false;
	    }
	  }

	  protected void init() {
	    GameRegistry.registerItem(this, getUnlocalizedName());
	  }

	  @Override
	  public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
	    return EnergyUpgrade.receiveEnergy(container, maxReceive, simulate);
	  }

	  @Override
	  public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
	    return EnergyUpgrade.extractEnergy(container, maxExtract, simulate);
	  }

	  @Override
	  public int getEnergyStored(ItemStack container) {
	    return EnergyUpgrade.getEnergyStored(container);
	  }

	  @Override
	  public int getMaxEnergyStored(ItemStack container) {
	    return EnergyUpgrade.getMaxEnergyStored(container);
	  }

	  @Override
	  public boolean getIsRepairable(ItemStack i1, ItemStack i2) {
	    return false;
	  }

	  @Override
	  public void addCommonEntries(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag) {
	    DarkSteelRecipeManager.instance.addCommonTooltipEntries(itemstack, entityplayer, list, flag);
	  }

	  @Override
	  public void addBasicEntries(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag) {
	    DarkSteelRecipeManager.instance.addBasicTooltipEntries(itemstack, entityplayer, list, flag);
	  }

	  @Override
	  public void addDetailedEntries(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag) {
	    if(!Config.addDurabilityTootip) {
	      list.add(ItemUtil.getDurabilityString(itemstack));
	    }
	    String str = EnergyUpgrade.getStoredEnergyString(itemstack);
	    if(str != null) {
	      list.add(str);
	    }
	    DarkSteelRecipeManager.instance.addAdvancedTooltipEntries(itemstack, entityplayer, list, flag);
	  }

	  public ItemStack createItemStack() {
	    return new ItemStack(this);
	  }
}
