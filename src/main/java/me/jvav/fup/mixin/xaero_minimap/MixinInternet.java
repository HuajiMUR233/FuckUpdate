package me.jvav.fup.mixin.xaero_minimap;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.common.AXaeroMinimap;
import xaero.common.misc.Internet;

@Mixin(value = Internet.class, remap = false)
public class MixinInternet {
    @Inject(method = "checkModVersion", at = @At("HEAD"), cancellable = true)
    private static void dontCheckModVersion(AXaeroMinimap modMain, CallbackInfo ci) {
        modMain.setOutdated(false);
        ci.cancel();
    }
}
