package tehnut.morechisels.item.chisel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

public class ItemChiselFire extends ItemChiselBase {

    public ItemChiselFire(ChiselType type) {
        super(type);
    }
    
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.setFire( 8 );
		return super.hitEntity(stack, attacker, target);
	}
}
