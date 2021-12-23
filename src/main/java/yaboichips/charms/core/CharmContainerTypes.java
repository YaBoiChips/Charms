package yaboichips.charms.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import yaboichips.charms.Charms;
import yaboichips.charms.common.container.*;

import java.util.ArrayList;
import java.util.List;

public class CharmContainerTypes {

    public static List<MenuType<?>> menus = new ArrayList<>();


    public static final MenuType<CharmContainer> CHARM_CONTAINER = register("charm_container", CharmContainer::new);

    public static final MenuType<UltimateCharmContainer> ULTIMATE_CHARM_CONTAINER = register("ultimate_charm_container", UltimateCharmContainer::new);

    public static final MenuType<AdvancedCharmContainer> ADVANCED_CHARM_CONTAINER = register("advanced_charm_container", AdvancedCharmContainer::new);


    private static <T extends AbstractContainerMenu> MenuType<T> register(String key, MenuType.MenuSupplier<T> builder) {
        MenuType<T> menuType = new MenuType<>(builder);
        menuType.setRegistryName(new ResourceLocation(Charms.MOD_ID, key));
        menus.add(menuType);
        return menuType;
    }

    public static void init() {

    }


}
