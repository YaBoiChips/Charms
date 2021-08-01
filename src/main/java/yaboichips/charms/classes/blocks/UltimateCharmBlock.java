package yaboichips.charms.classes.blocks;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import yaboichips.charms.classes.ModTileEntityTypes;
import yaboichips.charms.tileentitys.AdvancedCharmTE;
import yaboichips.charms.tileentitys.UltimateCharmTE;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import javax.annotation.Nullable;
import java.util.Random;

public class UltimateCharmBlock extends BaseEntityBlock {

    public UltimateCharmBlock(Properties properties) {
        super(properties);
    }



    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
                                             InteractionHand handIn, BlockHitResult result) {
        if (!worldIn.isClientSide) {
            BlockEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof UltimateCharmTE) {
                NetworkHooks.openGui((ServerPlayer) player, (UltimateCharmTE) tile, pos);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
   

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof UltimateCharmTE) {
                Containers.dropContents(worldIn, pos, ((UltimateCharmTE) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ModTileEntityTypes.ULTAMITE_CHARM_CONTAINER.get().create(blockPos, blockState);

    }

    @Override
    public void tick(BlockState state, ServerLevel p_60463_, BlockPos pos, Random p_60465_) {
        UltimateCharmTE tile = new UltimateCharmTE(pos, state);
        tile.addEffectsToPlayers();
    }
}

