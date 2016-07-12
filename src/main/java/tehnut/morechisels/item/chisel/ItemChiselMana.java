package tehnut.morechisels.item.chisel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemChiselMana extends ItemChiselBase implements IManaUsingItem {

	private static final int MANA_PER_DAMAGE = 30;
	
    public ItemChiselMana(ChiselType type, int durability) {
        super(type);

        this.hasModes = durability>=500;
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
    
    public int getManaPerDmg() {
		return MANA_PER_DAMAGE;
    }
    
    @Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) {
		if(!world.isRemote && player instanceof EntityPlayer && stack.getItemDamage() > 0 && ManaItemHandler.requestManaExactForTool(stack, (EntityPlayer) player, MANA_PER_DAMAGE * 2, true))
			stack.setItemDamage(stack.getItemDamage() - 1);
    }
}
