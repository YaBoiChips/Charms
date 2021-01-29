package yaboichips.charms;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import yaboichips.charms.classes.ModContainerTypes;
import yaboichips.charms.classes.ModTileEntityTypes;
import yaboichips.charms.client.gui.AdvancedContainerScreen;
import yaboichips.charms.client.gui.CharmContainerScreen;
import yaboichips.charms.client.gui.UltamiteContainerScreen;
import yaboichips.charms.lists.ItemList;
import yaboichips.charms.util.CuriosModCheck;


@Mod("charms")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Charms {
    public static final String CHARMS = "charms";
    public static Logger LOGGER = LogManager.getLogger();

    public Charms() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
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
        ScreenManager.registerFactory(ModContainerTypes.CHARM_CONTAINER.get(), CharmContainerScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.ULTIMATE_CHARM_CONTAINER.get(), UltamiteContainerScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.ADVANCED_CHARM_CONTAINER.get(), AdvancedContainerScreen::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent e) {
        {
            InterModComms.sendTo("charms", "helloworld", () -> {
                LOGGER.info("Hello world from Charms");
                return "Hello world";
            });

            if (CuriosModCheck.CURIOS.isLoaded()) {
                InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm").size(1).build());
            }
        }
    }

    public static final ItemGroup CHARMSTAB = new ItemGroup("charmsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.charm_base);
        }
    };
}