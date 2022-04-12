package me.jvav.fup.mixin.litematica_printer;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "me.aleksilassila.litematica.printer.printer.UpdateChecker", remap = false)
public class MixinUpdateChecker {
    @Final
    @Shadow
    public static String version;

    @Inject(method = "getPrinterVersion", at = @At("HEAD"), cancellable = true)
    private static void onGetPrinterVersion(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(version);
    }
}
