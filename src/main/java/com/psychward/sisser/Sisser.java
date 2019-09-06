package com.psychward.sisser;

import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod("sisser")
public class Sisser {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Sisser() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onDetonate(ExplosionEvent.Detonate event) {
        World world = event.getWorld();
        if (world.isRemote) {
            return;
        }
        Explosion explosion = event.getExplosion();
        if (explosion.getExplosivePlacedBy() instanceof CreeperEntity) {
            List blocks = event.getAffectedBlocks();
            blocks.clear();
        }
    }
}
