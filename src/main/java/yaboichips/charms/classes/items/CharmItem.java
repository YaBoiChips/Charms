package yaboichips.charms.classes.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import yaboichips.charms.properties.CuriosProperties;
import yaboichips.charms.util.CuriosModCheck;

import javax.annotation.Nullable;

public class CharmItem extends Item {
    public CharmItem(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        if (CuriosModCheck.CURIOS.isLoaded()){
            return CuriosProperties.initCapabilities();
        }
        else return super.initCapabilities(stack, nbt);
    }
}
