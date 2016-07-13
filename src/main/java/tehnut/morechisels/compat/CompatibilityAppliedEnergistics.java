package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.item.chisel.ItemChiselAEPowered;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityAppliedEnergistics {

    public static Item chiselCertusQuartz;
    //public static Item chiselAE;

    static {
        LogHelper.info("Applied Energistics compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselCertusQuartz = new ItemChiselBase(ChiselType.CERTUSQUARTZ);
        ItemRegistry.registerCompatItem(chiselCertusQuartz, "ItemChiselCertusquartz", chiselCertusQuartzEnabled);
        
        //chiselAE = new ItemChiselAEPowered();
        //ItemRegistry.registerCompatItem(chiselAE, "ItemChiselAE", chiselAEEnabled);
    }

    private static void registerRecipes() {
        RecipeRegistry.addConfiguredChiselRecipe(chiselCertusQuartz, "crystalCertusQuartz", chiselCertusQuartzEnabled);
    }
}
