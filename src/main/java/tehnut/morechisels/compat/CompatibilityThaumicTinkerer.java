package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselUnbreakable;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselIchoriumAwakened;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselIchoriumEnabled;

public class CompatibilityThaumicTinkerer {

    public static Item chiselIchorium;
    public static Item chiselIchoriumAwakened;

    static {
        LogHelper.info("Thaumic Tinkerer compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselIchorium = new ItemChiselUnbreakable(ChiselType.ICHORIUM);
        ItemRegistry.registerCompatItem(chiselIchorium, "ItemChiselIchorium", chiselIchoriumEnabled);

        chiselIchoriumAwakened = new ItemChiselIchoriumAwakened();
        ItemRegistry.registerCompatItem(chiselIchoriumAwakened, "ItemChiselIchoriumAwakened", chiselIchoriumEnabled);
    }

    private static void registerRecipes() {
        RecipeRegistry.addConfiguredChiselRecipe(chiselIchorium, "ingotIchorium", chiselIchoriumEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselIchoriumAwakened, "ingotVoid", chiselIchoriumEnabled);
    }
}
