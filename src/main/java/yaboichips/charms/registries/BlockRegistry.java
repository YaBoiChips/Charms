package yaboichips.charms.registries;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.classes.AdvancedCharmBlock;
import yaboichips.charms.classes.CharmContainerBlock;
import yaboichips.charms.classes.UltimateCharmBlock;
import yaboichips.charms.lists.BlockList;

import static net.minecraft.block.Block.Properties.create;
import static net.minecraft.block.material.Material.WOOD;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public class BlockRegistry {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    BlockList.charm_container = new CharmContainerBlock(create(WOOD).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("charm_container"),
                    BlockList.advanced_charm_container = new AdvancedCharmBlock(create(WOOD).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("advanced_charm_container"),
                    BlockList.ultimate_charm_container = new UltimateCharmBlock(create(WOOD).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("ultimate_charm_container"));
        }
    }

