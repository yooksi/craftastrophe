package io.barrowisp.craftastrophe.items;

import io.barrowisp.craftastrophe.CFLogger;
import io.yooksi.commons.define.MethodsNotNull;
import io.yooksi.forgelib.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

@MethodsNotNull
public class Binder extends ItemBase {

    public Binder(String name, io.yooksi.forgelib.ForgeMod mod) {
        super(name, mod);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        CFLogger.debug("Stashing unintelligible blueprints...");
        /*
         *  The following lines are an attempt to separate foundational recipes from more-advanced recipes.
         *  If any of the Blueprints in the player's inventory are of an appropriate tier,
         *  then the player will trigger the Read event and receive a recipe.
         *  Any remaining Blueprints should be archived until the next time the Binder is used.
         */
        /*if (playerIn instanceof EntityPlayerMP) {
            int knowledge = 3;
            ModAdvancementTriggers.readBlueprint.trigger((EntityPlayerMP) playerIn, knowledge);
        }*/
        return super.onItemRightClick(worldIn, playerIn, handIn);
      //need to add else code that makes the loose Blueprints leave the player's inventory in a retrievable way
    }
}
