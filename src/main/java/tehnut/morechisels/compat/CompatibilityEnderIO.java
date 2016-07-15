package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselDarksteel;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselDarksteelEnabled;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityEnderIO {

    public static Item chiselDarksteel;

    static {
        LogHelper.info("Ender IO compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselDarksteel = new ItemChiselDarksteel();
        ItemRegistry.registerCompatItem(chiselDarksteel, "ItemChiselDarksteel", chiselDarksteelEnabled);
    }

    private static void registerRecipes() {
    	RecipeRegistry.addConfiguredChiselRecipe(chiselDarksteel, "ingotDarkSteel", chiselDarksteelEnabled);;
    }
}
