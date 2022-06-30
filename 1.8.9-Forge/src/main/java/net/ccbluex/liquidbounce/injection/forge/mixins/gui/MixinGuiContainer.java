/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.injection.forge.mixins.gui;

import net.ccbluex.liquidbounce.utils.render.Translate;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiContainer.class)
public abstract class MixinGuiContainer extends GuiScreen {
    private boolean translated=false;

    @Inject(method = "initGui", at = @At("RETURN"))
    private void initGui(CallbackInfo callbackInfo) {
        this.translate = new Translate(0, 0);
    }

    Translate translate;

    @Inject(method = "drawScreen", at = @At("RETURN"))
    private void drawScreenReturn(CallbackInfo callbackInfo){

        if(translated){
            GL11.glPopMatrix();
            translated=false;
        }
    }
}