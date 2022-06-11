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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryBuilder;
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
import yaboichips.charms.util.CharmsConfig;
import yaboichips.charms.util.CuriosModCheck;
import yaboichips.charms.util.events.CharmProperties;


@Mod("charms")
public class Charms {
    public static final String MOD_ID = "charms";
    public static Logger LOGGER = LogManager.getLogger();

    public Charms() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CharmProperties());
        CharmBlocks.BLOCKS.register(bus);
        CharmContainerTypes.MENUS.register(bus);
        CharmItems.ITEMS.register(bus);
        CharmTileEntityTypes.BLOCK_ENTITY.register(bus);
        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::enqueueIMC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CharmsConfig.getConfigSpec(), "charms.toml");
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
        MenuScreens.register(CharmContainerTypes.CHARM_CONTAINER.get(), CharmContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ULTIMATE_CHARM_CONTAINER.get(), UltamiteContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ADVANCED_CHARM_CONTAINER.get(), AdvancedContainerScreen::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent e) {
        {
            InterModComms.sendTo("charms", "helloworld", () -> {
                LOGGER.info("Hello world from Charms");
                return "Hello world";
            });
            if (CuriosModCheck.CURIOS.isLoaded()) {
                InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm").size(CharmsConfig.getInstance().charmSlots()).build());
            }
        }
    }

    public static final CreativeModeTab CHARMSTAB = new CreativeModeTab("charmsTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CharmItems.CHARM_BASE.get());
        }
    };
}