package yaboichips.charms.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.classes.items.CharmItem;
import yaboichips.charms.lists.BlockList;
import yaboichips.charms.lists.ItemList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemList.saturation_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("saturation_charm"),
                ItemList.speed_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("speed_charm"),
                ItemList.speed_2_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("speed_2_charm"),
                ItemList.haste_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("haste_charm"),
                ItemList.haste_2_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("haste_2_charm"),
                ItemList.strength_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("strength_charm"),
                ItemList.strength_2_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("strength_2_charm"),
                ItemList.absorption_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("absorption_charm"),
                ItemList.glowing_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("glowing_charm"),
                ItemList.dolphin_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("dolphin_charm"),
                ItemList.blindness_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("blindness_charm"),
                ItemList.nausea_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("nausea_charm"),
                ItemList.invisibility_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("invisibility_charm"),
                ItemList.luck_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("luck_charm"),
                ItemList.levitation_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("levitation_charm"),
                ItemList.charm_base = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("charm_base"),
                ItemList.slowness_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("slowness_charm"),
                ItemList.slow_falling_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("slow_falling_charm"),
                ItemList.absorption_2_charm= new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("absorption_2_charm"),
                ItemList.fire_resistance_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("fire_resistance_charm"),
                ItemList.water_breathing_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("water_breathing_charm"),
                ItemList.mining_fatigue_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("mining_fatigue_charm"),
                ItemList.night_vision_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("night_vision_charm"),
                ItemList.resistance_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("resistance_charm"),
                ItemList.resistance_2_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("resistance_2_charm"),
                ItemList.jump_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("jump_charm"),
                ItemList.jump_2_charm = new CharmItem(new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName("jump_2_charm"),
        ItemList.charm_container = new BlockItem(BlockList.CHARM_CONTAINER, new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName(BlockList.CHARM_CONTAINER.getRegistryName()),
        ItemList.advanced_charm_container = new BlockItem(BlockList.ADVANCED_CHARM_CONTAINER, new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName(BlockList.ADVANCED_CHARM_CONTAINER.getRegistryName()),
        ItemList.ultimate_charm_container = new BlockItem(BlockList.ULTIMATE_CHARM_CONTAINER, new Item.Properties().tab(Charms.CHARMSTAB)).setRegistryName(BlockList.ULTIMATE_CHARM_CONTAINER.getRegistryName()));

    }
}