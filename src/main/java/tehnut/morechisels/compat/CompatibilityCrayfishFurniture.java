package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselAutoRepair;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityCrayfishFurniture {

    public static Item chiselSoap;

    static {
        LogHelper.info("MrCrayfish' Furniture Mod compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {

        chiselSoap = new ItemChiselAutoRepair(ChiselType.SOAP);
        ItemRegistry.registerCompatItem(chiselSoap, "ItemChiselSoap", chiselSoapEnabled);
    }

    private static void registerRecipes() {
        Item soap = GameRegistry.findItem("cfm", "ItemSoap");

        RecipeRegistry.addConfiguredChiselRecipe(chiselSoap, soap, chiselSoapEnabled);

    }
}
