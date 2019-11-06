package com.psychward.sisser;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod("sisser")
public class Sisser {

    public Sisser() {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, com.psychward.sisser.ConfigHandler.spec);
        MinecraftForge.EVENT_BUS.register(new SisserHandler());
    }
}
