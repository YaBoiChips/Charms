package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.HashMap;

public class StepUpCharm extends CharmItem implements ICurioItem {
    public StepUpCharm(Properties properties) {
        super(properties, null, 0);
    }

    public static HashMap<Entity, Boolean> STEP_MAP = new HashMap<>();

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        STEP_MAP.put(slotContext.entity(), true);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        STEP_MAP.put(slotContext.entity(), false);
    }

    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity entity, int p_41407_, boolean p_41408_) {
        if (STEP_MAP.get(entity) != null && STEP_MAP.get(entity)) {
            entity.maxUpStep = 1.0f;
        }else{
            entity.maxUpStep = 0.6f;
        }
        super.inventoryTick(p_41404_, p_41405_, entity, p_41407_, p_41408_);
    }

    @Override
    public void playRightClickEquipSound(LivingEntity livingEntity, ItemStack stack) {
        livingEntity.level.playSound(null, livingEntity.blockPosition(),
                SoundEvents.ARMOR_EQUIP_ELYTRA, SoundSource.NEUTRAL,
                1.0F, 1.0F);
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }
}
