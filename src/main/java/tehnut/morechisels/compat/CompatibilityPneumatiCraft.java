package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselPneumatic;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselPneumaticEnabled;
import static tehnut.morechisels.ConfigHandler.durabilityPneumatic;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityPneumatiCraft {

    public static Item chiselPneumatic;

    static {
        LogHelper.info("PneumaticCraft compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselPneumatic = new ItemChiselPneumatic();
        ItemRegistry.registerCompatItem(chiselPneumatic, "ItemChiselPneumatic", chiselPneumaticEnabled);
    }

    private static void registerRecipes() {
        Item airCanister =GameRegistry.findItem("PneumaticCraft", "airCanister");
        int airCanisterMeta = 30000;
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chiselPneumatic, 1, durabilityPneumatic * 100), " I", "S ", 'I', "ingotIronCompressed", 'S', new ItemStack(airCanister, 1, airCanisterMeta)));
    }
}
