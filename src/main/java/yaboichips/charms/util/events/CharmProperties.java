package yaboichips.charms.util.events;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.common.items.*;
import yaboichips.charms.core.CharmItems;

@Mod.EventBusSubscriber(modid = Charms.MOD_ID)
public class CharmProperties {

    @SubscribeEvent
    public void doCharms(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Item offhandItem = player.getOffhandItem().getItem();
        if (offhandItem instanceof CharmItem) {
            player.addEffect(new MobEffectInstance(((CharmItem) offhandItem).getCharmEffect(), 100));
        }
        if (offhandItem instanceof UpgradedCharmItem) {
            player.addEffect(new MobEffectInstance(((UpgradedCharmItem) offhandItem).getCharmEffect(), 50, 1));
        }
        if (player.getInventory().isEmpty()){
            player.maxUpStep = 0.6f;
        }
    }

    @SubscribeEvent
    public void checkDrop(ItemTossEvent event) {
        Player player = event.getPlayer();
        if (event.getEntityItem().getItem().getItem() == CharmItems.STEP_UP_CHARM){
            player.maxUpStep = 0.6f;
        }
    }

}