package yaboichips.charms.classes.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import yaboichips.charms.properties.CuriosProperties;
import yaboichips.charms.util.CuriosModCheck;

import javax.annotation.Nullable;

import net.minecraft.world.item.Item.Properties;

public class CharmItem extends Item {
    public CharmItem(Properties properties) {
        super(properties);
    }

//    @Nullable
//    @Override
//    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
//        if (CuriosModCheck.CURIOS.isLoaded()){
//            return CuriosProperties.initCapabilities();
//        }
//        else return super.initCapabilities(stack, nbt);
//    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }
}
