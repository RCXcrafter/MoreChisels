package tehnut.morechisels.item.chisel;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.TextureStitchEvent;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.util.Utils;

import java.awt.*;

public class ItemChiselOredict extends ItemChiselBase {

    boolean setDisplayName;
    boolean slumdank;
    String name;
    String hexColor;
    IIcon overlayIcon;
    static TextureMap textureMap= null;
    
	public ItemChiselOredict(String name, int durability, String hexColor, boolean setDisplayName) {
        super(name, durability);

        if (textureMap==null)
        	textureMap= new TextureMap(1, ModInformation.ID);
        
        this.setDisplayName = setDisplayName;
        this.name = name;
        this.hexColor = hexColor;

        GameRegistry.registerItem(this, "ItemChiselOredict" + name);
        RecipeRegistry.addConfiguredChiselRecipe(this, name, true);  
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureStitch(TextureStitchEvent.Pre event) {
        TextureMap textureMap = event.map;

                // name of custom icon ( must equal getIconName() )
                String neam = ModInformation.TEXLOC + "chisel_" + name.toLowerCase();
                // see if there's already an icon of that name
                TextureAtlasSprite texture = textureMap.getTextureExtry(neam);
                if (texture == null) {
                    // if not create one and put it in the register
                    slumdank = true;
                }
                else slumdank = false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	
    	TextureAtlasSprite sprite= textureMap.getTextureExtry(ModInformation.TEXLOC + "chisel_" + name.toLowerCase());
    	
    	System.out.println("chisel_" + name.toLowerCase());
    	
        if (slumdank = true){
    		this.itemIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_base");
    		this.overlayIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_overlay");
    	}
    	else{
        	System.out.println("sprite=" + sprite);
    		this.itemIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_" + name.toLowerCase());
    		this.overlayIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "void");
    	}
    	
    }
    
    

    @SideOnly(Side.CLIENT)
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
    	
    	String capName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
    	
        String materialUnloc = "material." + ModInformation.ID + "." + name.toLowerCase() + ".name";

        if (StatCollector.canTranslate(materialUnloc))
            return StatCollector.translateToLocalFormatted("item.morechisels.chisel.oredict.name", StatCollector.translateToLocal(materialUnloc));
        else
            return Utils.splitAtCapital(StatCollector.translateToLocalFormatted("item.morechisels.chisel.oredict.name", capName)).substring(Utils.splitAtCapital(capName).lastIndexOf(' ') + 1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        return pass == 1 ? Color.decode(hexColor).getRGB() : super.getColorFromItemStack(stack, pass);
    }

    @Override
    public int getRenderPasses(int metadata) {
        return requiresMultipleRenderPasses() ? 2 : 1;
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return setDisplayName;
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        return pass == 0 ? this.itemIcon : this.overlayIcon;
    }
}
