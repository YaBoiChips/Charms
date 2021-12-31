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
    public boolean allowed;


    public CharmItem(Properties properties, MobEffect effects, boolean allowed) {
        super(properties);
        this.effect = effects;
        this.allowed = allowed;
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

    public boolean isAllowed(){
        return this.allowed;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof CharmItem) {
            slotContext.entity().addEffect(new MobEffectInstance(((CharmItem) item).getCharmEffect(), 100));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if (!this.isAllowed()){
            stack.shrink(stack.getCount());
        }
    }
}