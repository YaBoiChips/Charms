package yaboichips.charms.properties;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.ItemList;
import yaboichips.charms.registries.ItemRegistry;
import yaboichips.charms.util.CuriosUtil;

@Mod.EventBusSubscriber(modid = Charms.CHARMS, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CharmProperties {

    @SubscribeEvent
    public static void doCharms(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;

        if (player.getHeldItemOffhand().getItem() == ItemList.saturation_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SATURATION, 10));
        }else if (CuriosUtil.findItem(ItemList.saturation_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.SATURATION, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.speed_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10));
        }else if (CuriosUtil.findItem(ItemList.speed_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.speed_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 1));
        }else if (CuriosUtil.findItem(ItemList.speed_2_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 1));

        if (player.getHeldItemOffhand().getItem() == ItemList.haste_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1));
        }else if (CuriosUtil.findItem(ItemList.haste_2_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1));

        if (player.getHeldItemOffhand().getItem() == ItemList.haste_charm) {
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 10));
        }else if (CuriosUtil.findItem(ItemList.haste_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.jump_charm) {
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10));
        }else if (CuriosUtil.findItem(ItemList.jump_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.nausea_charm) {
            player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 30, 1));
        }else if (CuriosUtil.findItem(ItemList.nausea_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 30, 1));

        if (player.getHeldItemOffhand().getItem() == ItemList.slowness_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10));
        }else if (CuriosUtil.findItem(ItemList.slowness_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.blindness_charm) {
            player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 10));
        }else if (CuriosUtil.findItem(ItemList.blindness_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.levitation_charm) {
            player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 10));
        }else if (CuriosUtil.findItem(ItemList.levitation_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.dolphin_charm) {
            player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 10));
        }else if (CuriosUtil.findItem(ItemList.dolphin_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.invisibility_charm) {
            player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 10));
        }else if (CuriosUtil.findItem(ItemList.invisibility_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.night_vision_charm) {
            player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 20));
        }else if (CuriosUtil.findItem(ItemList.night_vision_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 20));

        if (player.getHeldItemOffhand().getItem() == ItemList.mining_fatigue_charm) {
            player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 10));
        }else if (CuriosUtil.findItem(ItemList.mining_fatigue_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.strength_charm) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10));
        }else if (CuriosUtil.findItem(ItemList.strength_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.water_breathing_charm) {
            player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 10));
        }else if (CuriosUtil.findItem(ItemList.water_breathing_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.strength_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10, 1));
        }else if (CuriosUtil.findItem(ItemList.strength_2_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10,1));

        if (player.getHeldItemOffhand().getItem() == ItemList.resistance_charm) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10));
        }else if (CuriosUtil.findItem(ItemList.resistance_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.resistance_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, 1));
        }else if (CuriosUtil.findItem(ItemList.resistance_2_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, 1));

        if (player.getHeldItemOffhand().getItem() == ItemList.fire_resistance_charm) {
            player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10));
        }else if (CuriosUtil.findItem(ItemList.fire_resistance_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.glowing_charm) {
            player.addPotionEffect(new EffectInstance(Effects.GLOWING, 10));
        }else if (CuriosUtil.findItem(ItemList.glowing_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.GLOWING, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.slow_falling_charm) {
            player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10));
        }else if (CuriosUtil.findItem(ItemList.slow_falling_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.absorption_charm) {
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10));
        }else if (CuriosUtil.findItem(ItemList.absorption_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.absorption_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10,1));
        }else if (CuriosUtil.findItem(ItemList.absorption_2_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10, 1));

        if (player.getHeldItemOffhand().getItem() == ItemList.luck_charm) {
            player.addPotionEffect(new EffectInstance(Effects.LUCK, 10));
        } else if (CuriosUtil.findItem(ItemList.luck_charm, player) != ItemStack.EMPTY)
            player.addPotionEffect(new EffectInstance(Effects.LUCK, 10));

        if (player.getHeldItemOffhand().getItem() == ItemList.jump_2_charm) {
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 1));
        } else if (CuriosUtil.findItem(ItemList.jump_2_charm, player) != ItemStack.EMPTY){
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 1));
        }
    }

}

