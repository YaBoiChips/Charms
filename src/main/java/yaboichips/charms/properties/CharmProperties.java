package yaboichips.charms.properties;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.ItemList;

@Mod.EventBusSubscriber(modid = Charms.CHARMS, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CharmProperties {

    @SubscribeEvent
    public static void doHeal(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.healing_charm) {
            player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 10));
        }
    }

    @SubscribeEvent
    public static void doFood(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.saturation_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SATURATION, 10));
        }
    }

    @SubscribeEvent
    public static void doSpeed(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.speed_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10));
        }
    }

    @SubscribeEvent
    public static void doSpeed2(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.speed_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 1));
        }
    }

    @SubscribeEvent
    public static void doHaste2(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.haste_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1));
        }
    }

    @SubscribeEvent
    public static void doHaste(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.haste_charm) {
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 10));
        }
    }

    @SubscribeEvent
    public static void doJump(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.jump_charm) {
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10));
        }
    }

    @SubscribeEvent
    public static void doNausea(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.nausea_charm) {
            player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 30, 1));
        }
    }

    @SubscribeEvent
    public static void doSlowness(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.slowness_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10));
        }
    }
    @SubscribeEvent
    public static void doBlindness(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.blindness_charm) {
            player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 10));
        }
    }
    @SubscribeEvent
    public static void doLevitate(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.levitation_charm) {
            player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 10));
        }
    }
    @SubscribeEvent
    public static void doDolphin(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.dolphin_charm) {
            player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 10));
        }
    }
    @SubscribeEvent
    public static void doInvis(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.invisibility_charm) {
            player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 10));
        }
    }
    @SubscribeEvent
    public static void doBadMining(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.mining_fatigue_charm) {
            player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 10));
        }
    }
    @SubscribeEvent
    public static void doStrength(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.strength_charm) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10));
        }
    }
    @SubscribeEvent
    public static void doResistance(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.resistance_charm) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10));
        }
    }
    @SubscribeEvent
    public static void doResistance2(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.resistance_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, 1));
        }
    }
    @SubscribeEvent
    public static void doFireRes(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.fire_resistance_charm) {
            player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10));
        }
    }
    @SubscribeEvent
    public static void doGlow(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.glowing_charm) {
            player.addPotionEffect(new EffectInstance(Effects.GLOWING, 10));
        }
    }
    @SubscribeEvent
    public static void doSlowFall(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.slow_falling_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10));
        }
    }
    @SubscribeEvent
    public static void doAbsorption(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.absorption_charm) {
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10));
        }
    }
    @SubscribeEvent
    public static void doAbsorption2(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.absorption_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10,1));
        }
    }
    @SubscribeEvent
    public static void doLuck(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.luck_charm) {
            player.addPotionEffect(new EffectInstance(Effects.LUCK, 10));
        }
    }
    @SubscribeEvent
    public static void doJump2(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.getHeldItemOffhand().getItem() == ItemList.jump_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 1));
        }
    }
}
