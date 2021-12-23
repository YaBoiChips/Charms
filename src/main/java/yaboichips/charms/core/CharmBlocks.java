package yaboichips.charms.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import yaboichips.charms.Charms;
import yaboichips.charms.common.blocks.*;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class CharmBlocks {
    public static List<Block> blocks = new ArrayList<>();


    public static Block CHARM_CONTAINER = registerBlock("charm_container", new CharmContainerBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD)));
    public static Block ADVANCED_CHARM_CONTAINER = registerBlock("advanced_charm_container", new AdvancedCharmBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD)));
    public static Block ULTIMATE_CHARM_CONTAINER = registerBlock("ultimate_charm_container", new UltimateCharmBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD)));

    static @Nonnull
    <T extends Block> T registerBlock(String id, @Nonnull T block) {
        block.setRegistryName(new ResourceLocation(Charms.MOD_ID, id));

        blocks.add(block);

        return block;
    }

    public static void init() {
    }
}


