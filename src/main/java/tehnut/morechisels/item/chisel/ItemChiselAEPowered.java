package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import appeng.api.config.AccessRestriction;
import appeng.api.implementations.items.IAEItemPowerStorage;

import java.util.List;

public class ItemChiselAEPowered extends ItemChiselBase implements IAEItemPowerStorage {

    public ItemChiselAEPowered() {
        super(ChiselType.AE);
    }

	@Override
	public double injectAEPower(ItemStack is, double amt) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double extractAEPower(ItemStack is, double amt) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getAEMaxPower(ItemStack is) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getAECurrentPower(ItemStack is) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public AccessRestriction getPowerFlow(ItemStack is) {
		// TODO Auto-generated method stub
		return null;
	}
	//I have no idea what I'm doing
}
