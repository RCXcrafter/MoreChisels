package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityAetherII {

    public static Item chiselSkyroot;
    public static Item chiselHolystone;
    public static Item chiselZanite;
    public static Item chiselGravitite;

    static {
        LogHelper.info("Aether II compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSkyroot = new ItemChiselBase(ChiselType.SKYROOT);
        ItemRegistry.registerCompatItem(chiselSkyroot, "ItemChiselSkyroot", chiselSkyrootEnabled);

        chiselHolystone = new ItemChiselBase(ChiselType.HOLYSTONE);
        ItemRegistry.registerCompatItem(chiselHolystone, "ItemChiselHolystone", chiselHolystoneEnabled);

        chiselZanite = new ItemChiselBase(ChiselType.ZANITE);
        ItemRegistry.registerCompatItem(chiselZanite, "ItemChiselZanite", chiselZaniteEnabled);

        chiselGravitite = new ItemChiselBase(ChiselType.GRAVITITE);
        ItemRegistry.registerCompatItem(chiselGravitite, "ItemChiselGravitite", chiselGravititeEnabled);

    }

    private static void registerRecipes() {
        Item skyrootStick = GameRegistry.findItem("aether", "skyrootStick");
        Item skyroot = GameRegistry.findItem("aether", "skyrootPlank");
        Item holystone = GameRegistry.findItem("aether", "holystone");
        Item zanite = GameRegistry.findItem("aether", "zaniteGemstone");
        Item gravitite = GameRegistry.findItem("aether", "enchantedGravitite");

        RecipeRegistry.addThemedChiselRecipe(chiselSkyroot, skyroot, skyrootStick, chiselSkyrootEnabled);
        RecipeRegistry.addThemedChiselRecipe(chiselHolystone, holystone, skyrootStick, chiselHolystoneEnabled);
        RecipeRegistry.addThemedChiselRecipe(chiselZanite, zanite, skyrootStick, chiselZaniteEnabled);
        RecipeRegistry.addThemedChiselRecipe(chiselGravitite, gravitite, skyrootStick, chiselGravititeEnabled);
    }
}
