package me.jvav.fup;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.Mixins;

public class FupPreLaunch implements PreLaunchEntrypoint {

    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();
        if (loader.getModContainer(Constant.XAERO_MINIMAP).isPresent()) {
            Mixins.addConfiguration("xaero_minimap.mixins.json");
        }
        if (loader.getModContainer(Constant.XAERO_WORLD_MAP).isPresent()) {
            Mixins.addConfiguration("xaero_world_map.mixins.json");
        }
    }
}
