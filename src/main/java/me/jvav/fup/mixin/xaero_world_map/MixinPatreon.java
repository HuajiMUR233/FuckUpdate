package me.jvav.fup.mixin.xaero_world_map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.map.patreon.Patreon;

import java.util.ArrayList;
import java.util.HashMap;

@Mixin(value = Patreon.class, remap = false)
public class MixinPatreon {
    @Shadow private static HashMap<Integer, ArrayList<String>> patrons;

    @Shadow private static HashMap<String, Object> mods;

    @Shadow private static boolean loaded;

    @Inject(method = "checkPatreon", at = @At("HEAD"), cancellable = true)
    private static void dontCheckPatreon(CallbackInfo ci) {
        patrons.clear();
        mods.clear();
        loaded = true;
        ci.cancel();
    }
}
