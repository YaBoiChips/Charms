package yaboichips.charms.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.charms.Charms;
import yaboichips.charms.common.blocks.*;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static yaboichips.charms.Charms.MOD_ID;


public class CharmBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static RegistryObject<Block> CHARM_CONTAINER = BLOCKS.register("charm_container", () -> new CharmContainerBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> ADVANCED_CHARM_CONTAINER = BLOCKS.register("advanced_charm_container", () -> new AdvancedCharmBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD)));
    public static RegistryObject<Block> ULTIMATE_CHARM_CONTAINER = BLOCKS.register("ultimate_charm_container", () -> new UltimateCharmBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD)));

}


