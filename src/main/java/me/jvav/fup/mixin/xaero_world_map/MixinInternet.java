package me.jvav.fup.mixin.xaero_world_map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.map.misc.Internet;
import xaero.map.WorldMap;

@Mixin(value = Internet.class, remap = false)
public class MixinInternet {
    @Inject(method = "checkModVersion", at = @At("HEAD"), cancellable = true)
    private static void dontCheckModVersion(CallbackInfo ci) {
        WorldMap.isOutdated = false;
        ci.cancel();
    }
}
