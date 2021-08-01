package yaboichips.charms.registries;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.classes.blocks.AdvancedCharmBlock;
import yaboichips.charms.classes.blocks.CharmContainerBlock;
import yaboichips.charms.classes.blocks.UltimateCharmBlock;
import yaboichips.charms.lists.BlockList;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public class BlockRegistry {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    BlockList.CHARM_CONTAINER = new CharmContainerBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("charm_container"),
                    BlockList.ADVANCED_CHARM_CONTAINER = new AdvancedCharmBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("advanced_charm_container"),
                    BlockList.ULTIMATE_CHARM_CONTAINER = new UltimateCharmBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.0f, 1.5f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("ultimate_charm_container"));
        }
    }

