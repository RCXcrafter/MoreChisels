package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselMana;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityBotania {

    public static Item chiselManasteel;
    public static Item chiselElementium;
    public static Item chiselTerrasteel;

    static {
        LogHelper.info("Botania compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {

        chiselManasteel = new ItemChiselMana(ChiselType.MANASTEEL, durabilityManasteel);
        ItemRegistry.registerCompatItem(chiselManasteel, "ItemChiselManasteel", chiselManasteelEnabled);

        chiselElementium = new ItemChiselMana(ChiselType.ELEMENTIUM, durabilityElementium);
        ItemRegistry.registerCompatItem(chiselElementium, "ItemChiselElementium", chiselElementiumEnabled);

        chiselTerrasteel = new ItemChiselMana(ChiselType.TERRASTEEL, durabilityTerrasteel);
        ItemRegistry.registerCompatItem(chiselTerrasteel, "ItemChiselTerrasteel", chiselTerrasteelEnabled);
    }

    private static void registerRecipes() {

        RecipeRegistry.addThemedChiselRecipe(chiselManasteel, "ingotManasteel", "livingwoodTwig", chiselManasteelEnabled);
        RecipeRegistry.addThemedChiselRecipe(chiselElementium, "ingotElvenElementium", "dreamwoodTwig", chiselElementiumEnabled);
        RecipeRegistry.addThemedChiselRecipe(chiselTerrasteel, "ingotTerrasteel", "livingwoodTwig", chiselTerrasteelEnabled);

    }
}
