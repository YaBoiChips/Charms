package yaboichips.charms.registries;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.Rarity;

import yaboichips.charms.Charms;
import yaboichips.charms.classes.items.CharmItem;
import yaboichips.charms.lists.ItemList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemList.charm = new CharmItem(new Item.Properties().group(Charms.CHARMSTAB).rarity(Rarity.RARE).maxStackSize(1)).setRegistryName("charm")
        );
    }
}