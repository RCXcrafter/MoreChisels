package tehnut.morechisels.item.chisel;

import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import thaumcraft.api.IRepairable;

public class ItemChiselPrecision extends ItemChiselBase implements IRepairable {

    public ItemChiselPrecision() {
        super(ChiselType.THAUMIUM);
    }
}
