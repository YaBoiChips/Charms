package yaboichips.charms;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import yaboichips.charms.classes.items.CharmColors;
import yaboichips.charms.lists.ItemList;
import yaboichips.charms.util.ConfigHandler;
import yaboichips.charms.util.AnvilUpdateEventHandler;
import yaboichips.charms.util.CuriosModCheck;
import yaboichips.charms.util.LootHandler;
import net.minecraftforge.fml.config.ModConfig;


@Mod("charms")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Charms {
    public static final String CHARMS = "charms";
    public static Logger LOGGER = LogManager.getLogger(CHARMS);
	public static volatile boolean configLoaded = false;

    public Charms() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::enqueueIMC); 
        MinecraftForge.EVENT_BUS.addListener(LootHandler::lootLoad);
        MinecraftForge.EVENT_BUS.register(new AnvilUpdateEventHandler());
        MinecraftForge.EVENT_BUS.addListener(AnvilUpdateEventHandler::onAnvilUpdate);
    }

    public static void register() {
        Minecraft minecraftClient = Minecraft.getInstance();
    }
    

    private void enqueueIMC(final InterModEnqueueEvent e) {
        {

            if (CuriosModCheck.CURIOS.isLoaded()) {
                InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm").size(3).build());
            }
        }
    }

    public static final ItemGroup CHARMSTAB = new ItemGroup("charmsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemList.charm);
        }
    };
    
    @SubscribeEvent
    public static void onColorHandlerEvent(ColorHandlerEvent.Item event)
    {
      // the LiquidColour lambda function is used to change the rendering colour of the liquid in the bottle
      // i.e.: when vanilla wants to know what colour to render our itemVariants instance, it calls the LiquidColour lambda function
      event.getItemColors().register(new CharmColors(), ItemList.charm);
    }
    
}