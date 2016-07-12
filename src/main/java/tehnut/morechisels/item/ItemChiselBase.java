package tehnut.morechisels.item;

import java.util.List;

import com.cricketcraft.chisel.api.ChiselTabs;
import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;

public class ItemChiselBase extends Item implements IChiselItem {

	private ChiselType type;
    protected boolean hasModes = false;
    protected boolean canChiselBlock = true;
    protected int attackDamage = 2;

    /**
     *
     * @param name - Unlocalized name for chisel.
     * @param durability - Effective durability of chisel.
     */
    public ItemChiselBase(String name, int durability) {
        super();

        setUnlocalizedName(ModInformation.ID + ".chisel." + name.toLowerCase());
        setTextureName(ModInformation.TEXLOC + "chisel_" + name.toLowerCase());
        setCreativeTab(ChiselTabs.tabChisel);
        setMaxStackSize(1);
        setMaxDamage(durability);
        this.hasModes = durability>=500;
        this.canChiselBlock = durability>=50;
    }

    /**
     *
     * @param type - Pre-defined chisel type from {@link tehnut.morechisels.item.ChiselType}
     */
    public ItemChiselBase(ChiselType type) {
        this(type.name(), type.durability);

        this.type = type;
    }

    /**
     * @return - Returns the {@link tehnut.morechisels.item.ChiselType} of the given Chisel.
     */
    public ChiselType getType() {
        return this.type;
    }

    /**
     * @return - Returns whether the chisel should be rendered like a tool in third persson.
     */
	public boolean isFull3D() {
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Chisel Damage", attackDamage, 0));
		return multimap;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		return super.hitEntity(stack, attacker, target);
}
	
    // Start Chisel API

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        return true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return true;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return true;
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        return canChiselBlock;
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return hasModes;
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean held) {
		String base = "item.chisel.chisel.desc.";
		String gui = I18n.format(base + "gui");
		String lc1 = I18n.format(base + "lc1");
		String lc2 = I18n.format(base + "lc2");
		String modes = I18n.format(base + "modes");
		list.add(gui);
		if (canChiselBlock) {
			list.add(lc1);
			list.add(lc2);
		}
		if (hasModes) {
			list.add("");
			list.add(modes);
		}
	}
}
