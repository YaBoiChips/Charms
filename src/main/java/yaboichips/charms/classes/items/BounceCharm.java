package yaboichips.charms.classes.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BounceCharm extends Item implements ICurioItem {
    public BounceCharm(Properties properties) {
        super(properties);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
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

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (entity.isOnGround()) {
            if (!entity.isCrouching()) {
                double f = 0.91d + 0.04d;
                entity.setDeltaMovement(entity.getDeltaMovement().x() / f, -entity.getDeltaMovement().y() + 1, entity.getDeltaMovement().z() / f);
                entity.setOnGround(false);
                entity.playSound(SoundEvents.SLIME_SQUISH, 1f, 1f);
            }
        }
    }
}