package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselUnbreakable extends ItemChiselBase {

    public ItemChiselUnbreakable(ChiselType type) {
        super(type);

        this.canChiselBlock = true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return false;
    }
}
