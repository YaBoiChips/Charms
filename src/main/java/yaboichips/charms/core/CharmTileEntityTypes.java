package yaboichips.charms.core;

import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import yaboichips.charms.Charms;
import yaboichips.charms.tileentitys.AdvancedCharmTE;
import yaboichips.charms.tileentitys.CharmContainerTE;
import yaboichips.charms.tileentitys.UltimateCharmTE;

import java.util.ArrayList;
import java.util.List;

public class CharmTileEntityTypes {

    public static List<BlockEntityType<?>> blockentity = new ArrayList<>();

    public static final BlockEntityType<CharmContainerTE> CHARM_CONTAINER = register("charm_container", BlockEntityType.Builder.of(CharmContainerTE::new, CharmBlocks.CHARM_CONTAINER));

    public static final BlockEntityType<UltimateCharmTE> ULTAMITE_CHARM_CONTAINER = register("ultamite_charm_container", BlockEntityType.Builder.of(UltimateCharmTE::new, CharmBlocks.ULTIMATE_CHARM_CONTAINER));

    public static final BlockEntityType<AdvancedCharmTE> ADVANCED_CHARM_CONTAINER = register("advanced_charm_container", BlockEntityType.Builder.of(AdvancedCharmTE::new, CharmBlocks.ADVANCED_CHARM_CONTAINER));


    private static <T extends BlockEntity> BlockEntityType<T> register(String key, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        BlockEntityType<T> blockEntityType = builder.build(type);
        blockEntityType.setRegistryName(new ResourceLocation(Charms.MOD_ID, key));
        blockentity.add(blockEntityType);
        return blockEntityType;
    }


    public static void init() {
    }
}
