package yaboichips.charms;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import yaboichips.charms.client.gui.AdvancedContainerScreen;
import yaboichips.charms.client.gui.CharmContainerScreen;
import yaboichips.charms.client.gui.UltamiteContainerScreen;
import yaboichips.charms.core.CharmBlocks;
import yaboichips.charms.core.CharmContainerTypes;
import yaboichips.charms.core.CharmItems;
import yaboichips.charms.core.CharmTileEntityTypes;
import yaboichips.charms.properties.CharmProperties;
import yaboichips.charms.util.CuriosModCheck;


@Mod("charms")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Charms {
    public static final String MOD_ID = "charms";
    public static Logger LOGGER = LogManager.getLogger();

    public Charms() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CharmProperties());


    }

    public static void register() {
        LOGGER.info("Charms: register");
        Minecraft minecraftClient = Minecraft.getInstance();
    }

    private void commonSetup(FMLCommonSetupEvent e) {
        LOGGER.debug("Charms: Common Setup event starting...");
        LOGGER.info("Charms: Common Setup event finished.");
    }

    private void clientSetup(FMLClientSetupEvent e) {
        LOGGER.debug("Charms: Client Setup event starting...");
        MenuScreens.register(CharmContainerTypes.CHARM_CONTAINER, CharmContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ULTIMATE_CHARM_CONTAINER, UltamiteContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ADVANCED_CHARM_CONTAINER, AdvancedContainerScreen::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent e) {
        {
            InterModComms.sendTo("charms", "helloworld", () -> {
                LOGGER.info("Hello world from Charms");
                return "Hello world";
            });

            if (CuriosModCheck.CURIOS.isLoaded()) {
                InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm").size(2).build());
            }
        }
    }

    public static final CreativeModeTab CHARMSTAB = new CreativeModeTab("charmsTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CharmItems.CHARM_BASE);
        }
    };

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerTileEntities(RegistryEvent.Register<BlockEntityType<?>> event) {
            Charms.LOGGER.debug("Charms: Registering block entities...");
            CharmTileEntityTypes.init();
            CharmTileEntityTypes.blockentity.forEach(entityType -> event.getRegistry().register(entityType));
            CharmTileEntityTypes.blockentity.clear();
            CharmTileEntityTypes.blockentity = null;
            Charms.LOGGER.info("Charms: Block Entities registered!");
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            LOGGER.info("HELLO from Register Items");
            CharmItems.init();
            CharmItems.items.forEach(item -> event.getRegistry().register(item));
            CharmItems.items.clear();
            CharmItems.items = null;
            LOGGER.info("BYE from Register Items");
        }
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            LOGGER.info("HELLO from Register Blocks");
            CharmBlocks.init();
            CharmBlocks.blocks.forEach(block -> event.getRegistry().register(block));
            CharmBlocks.blocks.clear();
            CharmBlocks.blocks = null;
            LOGGER.info("BYE from Register Blocks");
        }
        @SubscribeEvent
        public static void onMenuRegistry(final RegistryEvent.Register<MenuType<?>> event) {
            LOGGER.info("HELLO from Register Blocks");
            CharmContainerTypes.init();
            CharmContainerTypes.menus.forEach(menu -> event.getRegistry().register(menu));
            CharmContainerTypes.menus.clear();
            CharmContainerTypes.menus = null;
            LOGGER.info("BYE from Register Blocks");
        }
    }
}