package yaboichips.charms.classes.blocks;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import yaboichips.charms.classes.ModTileEntityTypes;
import yaboichips.charms.tileentitys.AdvancedCharmTE;
import yaboichips.charms.tileentitys.CharmContainerTE;

import javax.annotation.Nullable;
import java.util.Random;

public class CharmContainerBlock extends BaseEntityBlock {

    public CharmContainerBlock(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult result) {
        if (!worldIn.isClientSide) {
            BlockEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof CharmContainerTE) {
                NetworkHooks.openGui((ServerPlayer) player, (CharmContainerTE) tile, pos);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof CharmContainerTE) {
                Containers.dropContents(worldIn, pos, ((CharmContainerTE) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel p_60463_, BlockPos pos, Random p_60465_) {
        CharmContainerTE tile = new CharmContainerTE(pos, state);
        tile.addEffectsToPlayers();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ModTileEntityTypes.CHARM_CONTAINER.get().create(blockPos, blockState);
    }
}
