package io.barrowisp.craftastrophe;

import io.barrowisp.craftastrophe.capabilities.ModCapabilities;
import io.barrowisp.craftastrophe.items.ModItem;
import io.barrowisp.craftastrophe.recipes.RecipeHandler;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class Craftastrophe {
@Mod(modid = Craftastrophe.MOD_ID, name = Craftastrophe.NAME, version = Craftastrophe.VERSION)

    @Mod.Instance
    public static Craftastrophe instance;

    public static final String MOD_ID = "craftastrophe";
    public static final String NAME = "Craftastrophe";
    public static final String VERSION = "0.1";

    /**
     *  Create a new creative tab to be displayed in-game for our mod.
     *  By overriding {@code getTabIconItem} we are able to return our own
     *  item stack which the game will use to show a tab picture.
     */
    public static final net.minecraft.creativetab.CreativeTabs tabCraftastrophe =
            (new net.minecraft.creativetab.CreativeTabs("tabCraftastrophe") {

            @Override @NotNull
            public net.minecraft.item.ItemStack createIcon() {
                return new net.minecraft.item.ItemStack(Items.WRITABLE_BOOK);
            }
        });

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        /* Make sure we initialize the logging system before doing
         * anything else that might produce logs
         */
        CFLogger.init();

        CFLogger.info("Pre-initializing " + NAME + " mod...");

        ModItem.init();
//        ModAdvancementTriggers.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        CFLogger.info("Initializing " + NAME + " mod...");

        ModCapabilities.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        CFLogger.info("Post-initializing " + NAME + " mod...");

        RecipeHandler.init();
    }
}
