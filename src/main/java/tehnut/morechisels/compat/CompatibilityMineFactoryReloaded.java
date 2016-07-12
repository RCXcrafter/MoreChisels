package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselPrecision;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityMineFactoryReloaded {

    public static Item chiselPrecision;

    static {
        LogHelper.info("Minefactory Reloaded compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselPrecision = new ItemChiselPrecision();
        ItemRegistry.registerCompatItem(chiselPrecision, "ItemChiselPrecision", chiselPrecisionEnabled);
    }

    private static void registerRecipes() {
        RecipeRegistry.addConfiguredChiselRecipe(chiselPrecision, "sheetPlastic", chiselPrecisionEnabled);
    }
}
