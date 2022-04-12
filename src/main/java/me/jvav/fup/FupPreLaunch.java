package me.jvav.fup;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.Mixins;

public class FupPreLaunch implements PreLaunchEntrypoint {

    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();
        if (loader.getModContainer(Constant.XAERO_MINIMAP).isPresent()) {
            Mixins.addConfiguration("xaero_minimap.fup.mixins.json");
        }
        if (loader.getModContainer(Constant.XAERO_WORLD_MAP).isPresent()) {
            Mixins.addConfiguration("xaero_world_map.fup.mixins.json");
        }
        if (loader.getModContainer(Constant.LITEMATICA_PRINTER).isPresent()) {
            Mixins.addConfiguration("litematica_printer.fup.mixins.json");
        }
    }
}
