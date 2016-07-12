package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselBedrockium extends ItemChiselBase {

    public ItemChiselBedrockium() {
        super(ChiselType.BEDROCKIUM);

        this.hasModes = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		String base = "item.chisel.chisel.desc.";
		String gui = I18n.format(base + "gui");
		String lc1 = I18n.format(base + "lc1");
		String lc2 = I18n.format(base + "lc2");
		String modes = I18n.format(base + "modes");
        list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tip.morechisels.unbreakable"));
		list.add(gui);
		list.add(lc1);
		list.add(lc2);
		list.add("");
		list.add(modes);
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return true;
    }
}
