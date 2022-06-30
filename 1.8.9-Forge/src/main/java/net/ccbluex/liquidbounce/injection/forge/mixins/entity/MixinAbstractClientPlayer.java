/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.injection.forge.mixins.entity;

import net.ccbluex.liquidbounce.LiquidBounce;
import net.ccbluex.liquidbounce.ui.cape.GuiCapeManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

import static net.minecraft.realms.Realms.getName;

@Mixin(AbstractClientPlayer.class)
@SideOnly(Side.CLIENT)
public abstract class MixinAbstractClientPlayer extends MixinEntityPlayer {

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    private void getCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if(!getUniqueID().equals(Minecraft.getMinecraft().thePlayer.getUniqueID()))
            return;

        if(GuiCapeManager.INSTANCE.getNowCape()!=null)
            callbackInfoReturnable.setReturnValue(GuiCapeManager.INSTANCE.getNowCape().getResource());
    }

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    private void geCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if(!getUniqueID().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())){
            return;
        }

        if(GuiCapeManager.INSTANCE.getNowCape()!=null)
            callbackInfoReturnable.setReturnValue(GuiCapeManager.INSTANCE.getNowCape().getResource());
    }
}
