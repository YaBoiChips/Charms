package yaboichips.charms.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import yaboichips.charms.Charms;
import yaboichips.charms.common.items.*;
import yaboichips.charms.util.CharmsConfig;


import java.util.ArrayList;
import java.util.List;

public class CharmItems {
    public static List<Item> items = new ArrayList<>();


    public static Item SATURATION_CHARM = createItem(new SaturationCharm(new Item.Properties().tab(Charms.CHARMSTAB)), ("saturation_charm"));
    public static Item SPEED_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.MOVEMENT_SPEED, CharmsConfig.getInstance().allowSpeedCharm()), ("speed_charm"));
    public static Item SPEED_2_CHARM = createItem(new UpgradedCharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.MOVEMENT_SPEED, CharmsConfig.getInstance().allowSpeed2Charm()), ("speed_2_charm"));
    public static Item HASTE_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DIG_SPEED, CharmsConfig.getInstance().allowHasteCharm()), ("haste_charm"));
    public static Item HASTE_2_CHARM = createItem(new UpgradedCharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DIG_SPEED, CharmsConfig.getInstance().allowHaste2Charm()), ("haste_2_charm"));
    public static Item STRENGTH_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DAMAGE_BOOST, CharmsConfig.getInstance().allowStrengthCharm()), ("strength_charm"));
    public static Item STRENGTH_2_CHARM = createItem(new UpgradedCharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DAMAGE_BOOST, CharmsConfig.getInstance().allowStrength2Charm()), ("strength_2_charm"));
    public static Item ABSORPTION_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.ABSORPTION, CharmsConfig.getInstance().allowAbsorptionCharm()), ("absorption_charm"));
    public static Item GLOWING_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.GLOWING, CharmsConfig.getInstance().allowGlowingCharm()), ("glowing_charm"));
    public static Item DOLPHIN_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DOLPHINS_GRACE, CharmsConfig.getInstance().allowDolphinCharm()), ("dolphin_charm"));
    public static Item BLINDNESS_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.BLINDNESS, CharmsConfig.getInstance().allowBlindnessCharm()), ("blindness_charm"));
    public static Item NAUSEA_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.CONFUSION, CharmsConfig.getInstance().allowNauseaCharm()), ("nausea_charm"));
    public static Item INVISIBILITY_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.INVISIBILITY, CharmsConfig.getInstance().allowInvisCharm()), ("invisibility_charm"));
    public static Item LUCK_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.LUCK, CharmsConfig.getInstance().allowLuckCharm()), ("luck_charm"));
    public static Item LEVITATION_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.LEVITATION, CharmsConfig.getInstance().allowLevitationCharm()), ("levitation_charm"));
    public static Item CHARM_BASE = createItem(new Item(new Item.Properties().tab(Charms.CHARMSTAB)), ("charm_base"));
    public static Item SLOWNESS_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.MOVEMENT_SLOWDOWN, CharmsConfig.getInstance().allowSlownessCharm()), ("slowness_charm"));
    public static Item SLOW_FALLING_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.SLOW_FALLING, CharmsConfig.getInstance().allowSlowFallingCharm()), ("slow_falling_charm"));
    public static Item ABSORPTION_2_CHARM = createItem(new UpgradedCharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.ABSORPTION, CharmsConfig.getInstance().allowAbsorption2Charm()), ("absorption_2_charm"));
    public static Item FIRE_RESISTANCE_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.FIRE_RESISTANCE, CharmsConfig.getInstance().allowFireResistanceCharm()), ("fire_resistance_charm"));
    public static Item WATER_BREATHING_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.WATER_BREATHING, CharmsConfig.getInstance().allowWaterBreathingCharm()), ("water_breathing_charm"));
    public static Item MINING_FATIGUE_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DIG_SLOWDOWN, CharmsConfig.getInstance().allowMiningFatigueCharm()), ("mining_fatigue_charm"));
    public static Item NIGHT_VISION_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.NIGHT_VISION, CharmsConfig.getInstance().allowNightVisionCharm()), ("night_vision_charm"));
    public static Item RESISTANCE_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DAMAGE_RESISTANCE, CharmsConfig.getInstance().allowResistanceCharm()), ("resistance_charm"));
    public static Item RESISTANCE_2_CHARM = createItem(new UpgradedCharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.DAMAGE_RESISTANCE, CharmsConfig.getInstance().allowResistance2Charm()), ("resistance_2_charm"));
    public static Item JUMP_CHARM = createItem(new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.JUMP, CharmsConfig.getInstance().allowJumpCharm()), ("jump_charm"));
    public static Item JUMP_2_CHARM = createItem(new UpgradedCharmItem(new Item.Properties().tab(Charms.CHARMSTAB), MobEffects.JUMP, CharmsConfig.getInstance().allowJump2Charm()), ("jump_2_charm"));
    public static Item SPIDER_CHARM = createItem(new SpiderCharm(new Item.Properties().tab(Charms.CHARMSTAB)), "spider_charm");
    public static Item FALL_CHARM = createItem(new FallCharm(new Item.Properties().tab(Charms.CHARMSTAB)), "fall_charm");
    public static Item BOUNCE_CHARM = createItem(new BounceCharm(new Item.Properties().tab(Charms.CHARMSTAB)), "bounce_charm");
    public static Item STEEL_TOED_CHARM = createItem(new SteelToedCharm(new Item.Properties().tab(Charms.CHARMSTAB)), "steel_toed_charm");

    public static Item CHARM_CONTAINER = createItem(new BlockItem(CharmBlocks.CHARM_CONTAINER, new Item.Properties().tab(Charms.CHARMSTAB)), (CharmBlocks.CHARM_CONTAINER.getRegistryName()));
    public static Item ADVANCED_CHARM_CONTAINER = createItem(new BlockItem(CharmBlocks.ADVANCED_CHARM_CONTAINER, new Item.Properties().tab(Charms.CHARMSTAB)), (CharmBlocks.ADVANCED_CHARM_CONTAINER.getRegistryName()));
    public static Item ULTIMATE_CHARM_CONTAINER = createItem(new BlockItem(CharmBlocks.ULTIMATE_CHARM_CONTAINER, new Item.Properties().tab(Charms.CHARMSTAB)), (CharmBlocks.ULTIMATE_CHARM_CONTAINER.getRegistryName()));

    public static Item createItem(Item item, String id) {
        return createItem(item, new ResourceLocation(Charms.MOD_ID, id));
    }

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            item.setRegistryName(id);

            items.add(item);

            return item;
        } else return null;
    }

    public static void init() {
    }
}