package yaboichips.charms.registries;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.BlockList;
import yaboichips.charms.lists.ItemList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemList.saturation_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("saturation_charm"),
                ItemList.speed_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("speed_charm"),
                ItemList.speed_2_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("speed_2_charm"),
                ItemList.haste_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("haste_charm"),
                ItemList.haste_2_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("haste_2_charm"),
                ItemList.strength_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("strength_charm"),
                ItemList.strength_2_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("strength_2_charm"),
                ItemList.absorption_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("absorption_charm"),
                ItemList.glowing_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("glowing_charm"),
                ItemList.dolphin_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("dolphin_charm"),
                ItemList.blindness_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("blindness_charm"),
                ItemList.nausea_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("nausea_charm"),
                ItemList.invisibility_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("invisibility_charm"),
                ItemList.luck_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("luck_charm"),
                ItemList.levitation_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("levitation_charm"),
                ItemList.charm_base = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("charm_base"),
                ItemList.slowness_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("slowness_charm"),
                ItemList.slow_falling_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("slow_falling_charm"),
                ItemList.absorption_2_charm= new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("absorption_2_charm"),
                ItemList.fire_resistance_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("fire_resistance_charm"),
                ItemList.water_breathing_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("water_breathing_charm"),
                ItemList.mining_fatigue_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("mining_fatigue_charm"),
                ItemList.night_vision_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("night_vision_charm"),
                ItemList.resistance_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("resistance_charm"),
                ItemList.resistance_2_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("resistance_2_charm"),
                ItemList.jump_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("jump_charm"),
                ItemList.jump_2_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("jump_2_charm"),
                ItemList.healing_charm = new Item(new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName("healing_charm"),
        ItemList.charm_container = new BlockItem(BlockList.charm_container, new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName(BlockList.charm_container.getRegistryName()),
        ItemList.advanced_charm_container = new BlockItem(BlockList.advanced_charm_container, new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName(BlockList.advanced_charm_container.getRegistryName()),
        ItemList.ultimate_charm_container = new BlockItem(BlockList.ultimate_charm_container, new Item.Properties().group(Charms.CHARMSTAB)).setRegistryName(BlockList.ultimate_charm_container.getRegistryName()));

    }
}