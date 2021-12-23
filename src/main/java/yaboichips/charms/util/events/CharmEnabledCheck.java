package yaboichips.charms.util.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.common.items.CharmItem;
import yaboichips.charms.common.items.UpgradedCharmItem;

@Mod.EventBusSubscriber(modid = Charms.MOD_ID)
public class CharmEnabledCheck {

    @SubscribeEvent
    public static void checkCharmConfig(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        for (int i = 0; i <= player.getInventory().getContainerSize(); i++) {
            Item item = player.getInventory().getItem(i).getItem();
            if (item instanceof CharmItem) {
                if (!((CharmItem) item).isAllowed()) {
                    player.getInventory().removeItem(item.getDefaultInstance());
                }
            }
            else if (item instanceof UpgradedCharmItem) {
                if (!((UpgradedCharmItem) item).isAllowed()) {
                    player.getInventory().removeItem(item.getDefaultInstance());
                }
            }
        }
    }
}
