package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CharmItem extends Item implements ICurioItem {
    public MobEffect effect;


    public CharmItem(Properties properties, MobEffect effects) {
        super(properties);
        this.effect = effects;
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
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    public MobEffect getCharmEffect() {
        return this.effect;
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof CharmItem) {
            if(getCharmEffect() != null) {
                slotContext.entity().addEffect(new MobEffectInstance(((CharmItem) item).getCharmEffect(), 100));
            }
        }
    }
}