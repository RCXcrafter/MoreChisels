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

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityTropicraft {

    public static Item chiselZircon;
    public static Item chiselEudialyte;
    public static Item chiselZirconium;

    static {
        LogHelper.info("Tropicraft compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselZircon = new ItemChiselBase(ChiselType.ZIRCON);
        ItemRegistry.registerCompatItem(chiselZircon, "ItemChiselZircon", chiselZirconEnabled);

        chiselEudialyte = new ItemChiselBase(ChiselType.EUDIALYTE);
        ItemRegistry.registerCompatItem(chiselEudialyte, "ItemChiselEudialyte", chiselEudialyteEnabled);

        chiselZirconium = new ItemChiselBase(ChiselType.ZIRCONIUM);
        ItemRegistry.registerCompatItem(chiselZirconium, "ItemChiselZirconium", chiselZirconiumEnabled);

    }

    private static void registerRecipes() {
        Item bambooStick = GameRegistry.findItem("tropicraft", "bambooStick");
        Item tropicGem = GameRegistry.findItem("tropicraft", "ore");

        GameRegistry.addRecipe(new ShapedOreRecipe(chiselZircon, " I", "S ", 'I', new ItemStack(tropicGem, 1, 1), 'S', bambooStick));
        RecipeRegistry.addThemedChiselRecipe(chiselEudialyte, tropicGem, bambooStick, chiselHolystoneEnabled);
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselZirconium, " I", "S ", 'I', new ItemStack(tropicGem, 1, 3), 'S', bambooStick));
    }
}
