package com.psychward.sisser;

import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class SisserHandler {

    @SubscribeEvent
    public void onDetonate(ExplosionEvent.Detonate event) {
        World world = event.getWorld();
        if (world.isRemote) {
            return;
        }
        Explosion explosion = event.getExplosion();
        if (explosion.getExplosivePlacedBy() instanceof CreeperEntity) {
            List blocks = event.getAffectedBlocks();
            List entities = event.getAffectedEntities();
            if (!ConfigHandler.GENERAL.DamageBlocks.get()) {
                blocks.clear();
            }
            if (!ConfigHandler.GENERAL.DamagePlayers.get()) {
                entities.clear();
            }
        }
    }
}
