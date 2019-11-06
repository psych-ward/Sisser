package com.psychward.sisser;

import net.minecraftforge.common.ForgeConfigSpec;

class ConfigHandler {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    static final General GENERAL = new General(BUILDER);
    static final ForgeConfigSpec spec = BUILDER.build();

    public static class General {
        final ForgeConfigSpec.ConfigValue<Boolean> DamagePlayers;
        final ForgeConfigSpec.ConfigValue<Boolean> DamageBlocks;

        General(ForgeConfigSpec.Builder builder) {
            builder.push("General");
            DamagePlayers = builder
                    .comment("Creeper Explosions Damage Players [false/true|default:false]")
                    .translation("damageplayers.sisser.config")
                    .define("damagePlayers", false);
            DamageBlocks = builder
                    .comment("Creeper Explosions Damage Blocks [false/true|default:false]")
                    .translation("damageblocks.sisser.config")
                    .define("damageBlocks", true);
            builder.pop();
        }
    }
}
