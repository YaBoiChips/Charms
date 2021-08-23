package yaboichips.charms.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosUtil {
    public static ItemStack findItem(Item item, LivingEntity player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(item, player).map(ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
    }
}
