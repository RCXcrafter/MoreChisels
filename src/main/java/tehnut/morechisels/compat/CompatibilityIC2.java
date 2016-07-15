package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselElectric;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselElectricEnabled;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityIC2 {

    public static Item chiselElectric;

    static {
        LogHelper.info("IC2 compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselElectric = new ItemChiselElectric();
        ItemRegistry.registerCompatItem(chiselElectric, "ItemChiselElectric", chiselElectricEnabled);
    }

    private static void registerRecipes() {
        Item chisel =GameRegistry.findItem("chisel", "chisel");
        Item powerUnit =GameRegistry.findItem("IC2", "itemRecipePart");
        int powerUnitMeta = 3;
        
        GameRegistry.addShapelessRecipe(new ItemStack(chiselElectric, 1, 26), chisel, new ItemStack(powerUnit, 1, powerUnitMeta));
    }
}
