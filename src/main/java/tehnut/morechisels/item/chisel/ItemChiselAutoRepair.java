package tehnut.morechisels.item.chisel;

import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

public class ItemChiselAutoRepair extends ItemChiselBase {

    public ItemChiselAutoRepair(ChiselType type) {
        super(type);
    }
    
    @Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) {
		if(!world.isRemote && stack.getItemDamage() > 0 && world.getWorldTime() % 300 == stack.stackTagCompound.getInteger("worldTimeDelay"))
			stack.setItemDamage(stack.getItemDamage() - 1);
    }
}
