package yaboichips.charms.common.tileentitys;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;
import yaboichips.charms.common.blocks.CharmContainerBlock;
import yaboichips.charms.common.container.CharmContainer;
import yaboichips.charms.common.items.CharmItem;
import yaboichips.charms.common.items.UpgradedCharmItem;
import yaboichips.charms.core.CharmTileEntityTypes;

import javax.annotation.Nonnull;
import java.util.List;

public class CharmContainerTE extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(1, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private final IItemHandlerModifiable items = createHandler();
    private final LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);


    public CharmContainerTE(BlockPos pos, BlockState state) {
        super(CharmTileEntityTypes.CHARM_CONTAINER, pos, state);
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    public void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.charm_container");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new CharmContainer(id, player, this);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.chestContents);
        }
    }

    public void load(CompoundTag p_155055_) {
        super.load(p_155055_);
        this.chestContents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(p_155055_)) {
            ContainerHelper.loadAllItems(p_155055_, this.chestContents);
        }
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }

    @Override
    public void startOpen(Player player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    @Override
    public void stopOpen(Player player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof CharmContainerBlock) {
            this.level.blockEvent(this.worldPosition, block, 1, this.numPlayersUsing);
            this.level.updateNeighborsAt(this.worldPosition, block);
        }
    }


    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return super.getCapability(cap);
    }

    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        if (itemHandler != null) {
            itemHandler.invalidate();
        }
    }

    public static void tick(Level world, BlockPos pos, BlockState state, CharmContainerTE tile) {
        tile.addEffectsToPlayers(world);
    }

    public void addEffectsToPlayers(Level world) {
        if (!world.isClientSide) {
            for (int i = 0; i < this.getContainerSize(); i++) {
                AABB axisalignedbb = (new AABB(this.worldPosition)).inflate(10).expandTowards(0.0D, world.getMaxBuildHeight(), 0.0D);
                Item itemInSlot = this.getItem(i).getItem();
                List<Player> list = world.getEntitiesOfClass(Player.class, axisalignedbb);
                for (Player playerentity : list) {
                    if (itemInSlot instanceof CharmItem charm) {
                        if (charm.getCharmEffect() != null) {
                            playerentity.addEffect(new MobEffectInstance(charm.getCharmEffect(), charm.length));
                        }
                        if (itemInSlot instanceof UpgradedCharmItem upcharm) {
                            if (charm.getCharmEffect() != null) {
                                playerentity.addEffect(new MobEffectInstance(upcharm.getCharmEffect(), upcharm.length, 1));
                            }
                        }
                    }
                }
            }
        }
    }
}


