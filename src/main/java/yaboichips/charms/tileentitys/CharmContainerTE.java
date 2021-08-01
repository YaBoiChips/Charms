package yaboichips.charms.tileentitys;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;
import yaboichips.charms.classes.blocks.CharmContainerBlock;
import yaboichips.charms.classes.ModTileEntityTypes;
import yaboichips.charms.container.CharmContainer;
import yaboichips.charms.lists.ItemList;

import javax.annotation.Nonnull;
import java.util.List;

public class CharmContainerTE extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(1, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private final IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);


    public CharmContainerTE(BlockPos pos, BlockState state) {
        super(ModTileEntityTypes.ADVANCED_CHARM_CONTAINER.get(), pos, state);
    }



    @Override
    public int getContainerSize() {
        return 1;
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
    public CompoundTag save(CompoundTag compound) {
        super.save(compound);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.chestContents);
        }
        return compound;
    }



    private void playSound(SoundEvent sound) {
        double dx = (double) this.worldPosition.getX() + 0.5D;
        double dy = (double) this.worldPosition.getY() + 0.5D;
        double dz = (double) this.worldPosition.getZ() + 0.5D;
        this.level.playSound(null, dx, dy, dz, sound, SoundSource.BLOCKS, 0.5f,
                this.level.random.nextFloat() * 0.1f + 0.9f);
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


    public void addEffectsToPlayers() {
        if (!this.level.isClientSide) {
            for (int i = 0; i < this.getContainerSize(); i++) {
                AABB axisalignedbb = (new AABB(this.worldPosition)).inflate(15).expandTowards(0.0D, this.level.getMaxBuildHeight(), 0.0D);
                ItemStack itemInSlot = this.getItem(i);
                List<Player> list = this.level.getEntitiesOfClass(Player.class, axisalignedbb);
                for (Player playerentity : list) {
                    if (itemInSlot.getItem() == ItemList.haste_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.speed_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.speed_2_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.haste_2_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 10, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.saturation_charm) {
                        if (playerentity.level.isClientSide) {
                            if (playerentity.getFoodData().getSaturationLevel() <= 2){
                                playerentity.getFoodData().setSaturation(2);
                            }
                        }
                    } else if (itemInSlot.getItem() == ItemList.strength_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.strength_2_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.jump_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.jump_2_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.nausea_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.slowness_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.mining_fatigue_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 50, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.blindness_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.levitation_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.resistance_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.resistance_2_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.night_vision_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 270, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.invisibility_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.water_breathing_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.dolphin_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.glowing_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.luck_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.LUCK, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.slow_falling_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.absorption_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10, 0, false, false));
                    } else if (itemInSlot.getItem() == ItemList.absorption_2_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10, 1, false, false));
                    } else if (itemInSlot.getItem() == ItemList.fire_resistance_charm) {
                        playerentity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10, 0, false, false));
                    }
                }
            }
        }
    }
}


