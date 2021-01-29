package yaboichips.charms.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosUtil {
    public static ItemStack findItem(Item item, PlayerEntity player)
    {
        return CuriosApi.getCuriosHelper().findEquippedCurio(item, player)
                .map(ImmutableTriple::getRight)
                .orElse(ItemStack.EMPTY);
    }
}
