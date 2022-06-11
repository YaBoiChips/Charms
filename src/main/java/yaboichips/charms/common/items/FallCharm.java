package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import yaboichips.charms.util.CharmsConfig;

public class FallCharm extends CharmItem implements ICurioItem {
    public FallCharm(Properties properties) {
        super(properties, null, 0);
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
        LivingEntity player = slotContext.entity();
        player.fallDistance = 0.0F;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity player, int i, boolean bool) {
        if (!CharmsConfig.getInstance().allowFallCharm()){
            stack.shrink(stack.getCount());
        }
    }
}