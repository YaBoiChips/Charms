package yaboichips.charms.properties;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CuriosProperties{

//        public static ICapabilityProvider initCapabilities() {
//
//            ICurio curio = new ICurio() {
//                @Override
//                public boolean canRightClickEquip() {
//                    return true;
//                }
//
//                @Override
//                public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
//                    return true;
//                }
//
//                @Override
//                public void playRightClickEquipSound(LivingEntity entityLivingBase) {
//                    entityLivingBase.level.playSound(null, entityLivingBase.blockPosition(),
//                            SoundEvents.ARMOR_EQUIP_ELYTRA, SoundSource.NEUTRAL,
//                            1.0F, 1.0F);
//                }
//            };
//
//            return new ICapabilityProvider() {
//                private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);
//
//                @Nonnull
//                @Override
//                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
//                                                         @Nullable Direction side) {
//
//                    return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
//                }
//            };
//        }
//
//    public static boolean isRingInCuriosSlot(ItemStack charm, LivingEntity player)
//    {
//        return CuriosApi.getCuriosHelper().findEquippedCurio(charm.getItem(), player).isPresent();
//    }
}
