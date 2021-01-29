package yaboichips.charms.properties;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CuriosProperties{

        public static ICapabilityProvider initCapabilities() {

            ICurio curio = new ICurio() {
                @Override
                public boolean canRightClickEquip() {
                    return true;
                }

                @Override
                public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
                    return true;
                }

                @Override
                public void playRightClickEquipSound(LivingEntity entityLivingBase) {
                    entityLivingBase.world.playSound(null, entityLivingBase.getPosition(),
                            SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, SoundCategory.NEUTRAL,
                            1.0F, 1.0F);
                }
            };

            return new ICapabilityProvider() {
                private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

                @Nonnull
                @Override
                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
                                                         @Nullable Direction side) {

                    return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
                }
            };
        }

    public static boolean isRingInCuriosSlot(ItemStack charm, LivingEntity player)
    {
        return CuriosApi.getCuriosHelper().findEquippedCurio(charm.getItem(), player).isPresent();
    }
}
