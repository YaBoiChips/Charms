package yaboichips.charms.classes;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.BlockList;
import yaboichips.charms.tileentitys.AdvancedCharmTE;
import yaboichips.charms.tileentitys.CharmContainerTE;
import yaboichips.charms.tileentitys.UltimateCharmTE;

public class ModTileEntityTypes {

        public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
                ForgeRegistries.TILE_ENTITIES, Charms.CHARMS);


        public static final RegistryObject<TileEntityType<CharmContainerTE>> CHARM_CONTAINER = TILE_ENTITY_TYPES
                .register("charm_container", () -> TileEntityType.Builder
                        .create(() -> new CharmContainerTE(), BlockList.charm_container).build(null));

        public static final RegistryObject<TileEntityType<UltimateCharmTE>> ULTAMITE_CHARM_CONTAINER = TILE_ENTITY_TYPES
                .register("ultamite_charm_container", () -> TileEntityType.Builder
                        .create(() -> new UltimateCharmTE(), BlockList.ultimate_charm_container).build(null));

        public static final RegistryObject<TileEntityType<AdvancedCharmTE>> ADVANCED_CHARM_CONTAINER = TILE_ENTITY_TYPES
                .register("advanced_charm_container", () -> TileEntityType.Builder
                        .create(() -> new AdvancedCharmTE(), BlockList.advanced_charm_container).build(null));
}
