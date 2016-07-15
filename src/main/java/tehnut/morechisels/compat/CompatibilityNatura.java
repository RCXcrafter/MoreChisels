package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselGhostwoodEnabled;
import static tehnut.morechisels.ConfigHandler.chiselBloodwoodEnabled;
import static tehnut.morechisels.ConfigHandler.chiselDarkwoodEnabled;
import static tehnut.morechisels.ConfigHandler.chiselFusewoodEnabled;

public class CompatibilityNatura {

    public static Item chiselGhostwood;
    public static Item chiselBloodwood;
    public static Item chiselDarkwood;
    public static Item chiselFusewood;

    static {
        LogHelper.info("Natura compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselGhostwood = new ItemChiselBase(ChiselType.GHOSTWOOD);
        ItemRegistry.registerCompatItem(chiselGhostwood, "ItemChiselGhostwood", chiselGhostwoodEnabled);

        chiselBloodwood = new ItemChiselBase(ChiselType.BLOODWOOD);
        ItemRegistry.registerCompatItem(chiselBloodwood, "ItemChiselBloodwood", chiselBloodwoodEnabled);

        chiselDarkwood = new ItemChiselBase(ChiselType.DARKWOOD);
        ItemRegistry.registerCompatItem(chiselDarkwood, "ItemChiselDarkwood", chiselDarkwoodEnabled);

        chiselFusewood = new ItemChiselBase(ChiselType.FUSEWOOD);
        ItemRegistry.registerCompatItem(chiselFusewood, "ItemChiselFusewood", chiselFusewoodEnabled);

    }

    private static void registerRecipes() {
        Item stick = GameRegistry.findItem("Natura", "natura.stick");
        Item planks = GameRegistry.findItem("Natura", "planks");
        int ghostwoodMeta = 2;
        int bloodwoodMeta = 4;
        int darkwoodMeta = 11;
        int fusewoodMeta = 12;

        GameRegistry.addRecipe(new ShapedOreRecipe(chiselGhostwood, " I", "S ", 'I', new ItemStack(planks, 1, ghostwoodMeta), 'S', new ItemStack(stick, 1, ghostwoodMeta)));
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselBloodwood, " I", "S ", 'I', new ItemStack(planks, 1, bloodwoodMeta), 'S', new ItemStack(stick, 1, bloodwoodMeta)));
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselDarkwood, " I", "S ", 'I', new ItemStack(planks, 1, darkwoodMeta), 'S', new ItemStack(stick, 1, darkwoodMeta)));
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselFusewood, " I", "S ", 'I', new ItemStack(planks, 1, fusewoodMeta), 'S', new ItemStack(stick, 1, fusewoodMeta)));
    }
}
