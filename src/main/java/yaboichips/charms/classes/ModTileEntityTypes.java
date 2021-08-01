package yaboichips.charms.classes;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.BlockList;
import yaboichips.charms.tileentitys.AdvancedCharmTE;
import yaboichips.charms.tileentitys.CharmContainerTE;
import yaboichips.charms.tileentitys.UltimateCharmTE;

public class ModTileEntityTypes<T extends BlockEntity> extends net.minecraftforge.registries.ForgeRegistryEntry<BlockEntityType<?>> {

        public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
                ForgeRegistries.BLOCK_ENTITIES, Charms.CHARMS);


        public static final RegistryObject<BlockEntityType<CharmContainerTE>> CHARM_CONTAINER = TILE_ENTITY_TYPES
                .register("charm_container", () -> BlockEntityType.Builder
                        .of(CharmContainerTE::new, BlockList.CHARM_CONTAINER).build(null));

        public static final RegistryObject<BlockEntityType<UltimateCharmTE>> ULTAMITE_CHARM_CONTAINER = TILE_ENTITY_TYPES
                .register("ultamite_charm_container", () -> BlockEntityType.Builder
                        .of(UltimateCharmTE::new, BlockList.ULTIMATE_CHARM_CONTAINER).build(null));

        public static final RegistryObject<BlockEntityType<AdvancedCharmTE>> ADVANCED_CHARM_CONTAINER = TILE_ENTITY_TYPES
                .register("advanced_charm_container", () -> BlockEntityType.Builder
                        .of(AdvancedCharmTE::new, BlockList.ADVANCED_CHARM_CONTAINER).build(null));
}
