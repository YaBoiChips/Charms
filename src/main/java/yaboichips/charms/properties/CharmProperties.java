package yaboichips.charms.properties;


import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.ItemList;
import yaboichips.charms.util.CuriosUtil;

@Mod.EventBusSubscriber(modid = Charms.CHARMS, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CharmProperties {

    @SubscribeEvent
    public static void doCharms(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player.getOffhandItem().getItem() == ItemList.saturation_charm) {
            if (player.level.isClientSide) {
                player.getFoodData().setSaturation(2);
            }
        }//else if (CuriosUtil.findItem(ItemList.saturation_charm, player) != ItemStack.EMPTY)
//                if (player.level.isClientSide) {
//                    if (player.getFoodData().getSaturationLevel() <= 2){
//                        player.getFoodData().setSaturation(2);
//                    }
//                }

        if (player.getOffhandItem().getItem() == ItemList.speed_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.speed_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10));

        if (player.getOffhandItem().getItem() == ItemList.speed_2_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.speed_2_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1));

        if (player.getOffhandItem().getItem() == ItemList.haste_2_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.haste_2_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10, 1));

        if (player.getOffhandItem().getItem() == ItemList.haste_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.haste_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10));

        if (player.getOffhandItem().getItem() == ItemList.jump_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.jump_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10));

        if (player.getOffhandItem().getItem() == ItemList.nausea_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.nausea_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1));

        if (player.getOffhandItem().getItem() == ItemList.slowness_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50));
        }
//        else if (CuriosUtil.findItem(ItemList.slowness_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50));

        if (player.getOffhandItem().getItem() == ItemList.blindness_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50));
        }
//        else if (CuriosUtil.findItem(ItemList.blindness_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50));

        if (player.getOffhandItem().getItem() == ItemList.levitation_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.levitation_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10));

        if (player.getOffhandItem().getItem() == ItemList.dolphin_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.dolphin_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10));

        if (player.getOffhandItem().getItem() == ItemList.invisibility_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.invisibility_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10));

        if (player.getOffhandItem().getItem() == ItemList.night_vision_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 270));
        }
//        else if (CuriosUtil.findItem(ItemList.night_vision_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 270));

        if (player.getOffhandItem().getItem() == ItemList.mining_fatigue_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 50, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.mining_fatigue_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 50, 1));

        if (player.getOffhandItem().getItem() == ItemList.strength_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.strength_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10));

        if (player.getOffhandItem().getItem() == ItemList.water_breathing_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.water_breathing_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 10));

        if (player.getOffhandItem().getItem() == ItemList.strength_2_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.strength_2_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1));

        if (player.getOffhandItem().getItem() == ItemList.resistance_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.resistance_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10));

        if (player.getOffhandItem().getItem() == ItemList.resistance_2_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.resistance_2_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 1));

        if (player.getOffhandItem().getItem() == ItemList.fire_resistance_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.fire_resistance_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10));

        if (player.getOffhandItem().getItem() == ItemList.glowing_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.glowing_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10));

        if (player.getOffhandItem().getItem() == ItemList.slow_falling_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.slow_falling_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10));

        if (player.getOffhandItem().getItem() == ItemList.absorption_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.absorption_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10));

        if (player.getOffhandItem().getItem() == ItemList.absorption_2_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10,1));
        }
//        else if (CuriosUtil.findItem(ItemList.absorption_2_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10, 1));

        if (player.getOffhandItem().getItem() == ItemList.luck_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 10));
        }
//        else if (CuriosUtil.findItem(ItemList.luck_charm, player) != ItemStack.EMPTY)
//            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 10));

        if (player.getOffhandItem().getItem() == ItemList.jump_2_charm) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 1));
        }
//        else if (CuriosUtil.findItem(ItemList.jump_2_charm, player) != ItemStack.EMPTY){
//            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 1));
//        }
    }

}

