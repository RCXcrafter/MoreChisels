package tehnut.morechisels.item;

import java.util.Locale;

import static tehnut.morechisels.ConfigHandler.*;

public enum ChiselType {

    BLOODY(), BOUND(), // Blood Magic
    BEDROCKIUM(Integer.MAX_VALUE), UNSTABLE(durabilityUnstable), // Extra Utilities
    FLUXED(), // RF
    CHEESE(durabilityCheese), DESH(durabilityDesh), //Galacticraft
    IRONWOOD(durabilityIronwood), STEELEAF(durabilitySteeleaf), KNIGHTMETAL(durabilityKnightmetal), FIERY(durabilityFiery), // Twilight Forest
    MANASTEEL(durabilityManasteel), ELEMENTIUM(durabilityElementium), TERRASTEEL(durabilityTerrasteel), // Botania
    SKYROOT(durabilitySkyroot), HOLYSTONE(durabilityHolystone), ZANITE(durabilityZanite), GRAVITITE(durabilityGravitite), // Aether II
//    STEAMPOWERED(durabilitySteam), // Flaxbeard's Steam Power
    SOULIUM(durabilitySoulium), // Soul Shards: The Old Ways
    THAUMIUM(durabilityThaumium), VOIDMETAL(durabilityVoidmetal), // Thaumcraft
    NEPTUNIUM(durabilityNeptunium), // Aquaculture
    INFINITY(0), // Avaritia
    WALRUS(durabilityWalrus), // Extra Cells
    CERTUSQUARTZ(durabilityCertusQuartz), AE(durabilityAE), // Applied Energistics
    REINFORCEDMETAL(durabilityReinforcedMetal), GALGADORIANMETAL(durabilityGalgadorianMetal), // Steve's Carts
    SYRMORITE(durabilitySyrmorite), OCTINE(durabilityOctine), VALONITE(durabilityValonite), // The Betweenlands
    CARDBOARD(durabilityCardboard), // Better Storage
    PRECISION(durabilityPrecision), // Minefactory Reloaded
    SOAP(durabilitySoap), // MrCrayfish' Furniture Mod
    PNEUMATIC(durabilityPneumatic), // PneumaticCraft
    ELECTRIC(durabilityElectric), // IC2
    DARKSTEEL(durabilityDarksteel), // Ender IO
    GHOSTWOOD(durabilityGhostwood), BLOODWOOD(durabilityBloodwood), DARKWOOD(durabilityDarkwood), FUSEWOOD(durabilityFusewood), // Natura
    ICHORIUM(0), // Thaumic Tinkerer
    ZIRCON(durabilityZircon), EUDIALYTE(durabilityEudialyte), ZIRCONIUM(durabilityZirconium); // Tropicraft
 
    /**
     * Used for all types of durability (RF, EU, etc)
     */
    public final int durability;

    ChiselType(int dura) {
        this.durability = dura;
    }

    ChiselType() {
        this(100);
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
