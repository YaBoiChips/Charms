package yaboichips.charms.classes;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.charms.Charms;
import yaboichips.charms.container.AdvancedCharmContainer;
import yaboichips.charms.container.CharmContainer;
import yaboichips.charms.container.UltimateCharmContainer;

public class ModContainerTypes {
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Charms.CHARMS);

    public static final RegistryObject<MenuType<CharmContainer>> CHARM_CONTAINER = CONTAINER_TYPES
            .register("charm_container", () -> IForgeContainerType.create(CharmContainer::new));

    public static final RegistryObject<MenuType<UltimateCharmContainer>> ULTIMATE_CHARM_CONTAINER = CONTAINER_TYPES
            .register("ultimate_charm_container", () -> IForgeContainerType.create(UltimateCharmContainer::new));

    public static final RegistryObject<MenuType<AdvancedCharmContainer>> ADVANCED_CHARM_CONTAINER = CONTAINER_TYPES
            .register("advanced_charm_container", () -> IForgeContainerType.create(AdvancedCharmContainer::new));


}
