package yaboichips.charms.tileentitys;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;
import yaboichips.charms.classes.ModTileEntityTypes;
import yaboichips.charms.classes.UltimateCharmBlock;
import yaboichips.charms.container.UltimateCharmContainer;
import yaboichips.charms.lists.ItemList;

import javax.annotation.Nonnull;
import java.util.List;

public class UltimateCharmTE extends LockableLootTileEntity implements ITickableTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(36, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

    public UltimateCharmTE(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public UltimateCharmTE() {
        this(ModTileEntityTypes.ULTAMITE_CHARM_CONTAINER.get());
    }

    @Override
    public int getSizeInventory() {
        return 36;
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
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.ultamite_charm_container");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new UltimateCharmContainer(id, player, this);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.chestContents);
        }
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.chestContents);

        }

    }


    private void playSound(SoundEvent sound) {
        double dx = (double) this.pos.getX() + 0.5D;
        double dy = (double) this.pos.getY() + 0.5D;
        double dz = (double) this.pos.getZ() + 0.5D;
        this.world.playSound((PlayerEntity) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f,
                this.world.rand.nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof UltimateCharmBlock) {
            this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }

    public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
        BlockState blockstate = reader.getBlockState(pos);
        if (blockstate.hasTileEntity()) {
            TileEntity tileentity = reader.getTileEntity(pos);
            if (tileentity instanceof UltimateCharmTE) {
                return ((UltimateCharmTE) tileentity).numPlayersUsing;
            }
        }
        return 0;
    }

    public static void swapContents(UltimateCharmTE te, UltimateCharmTE otherTe) {
        NonNullList<ItemStack> list = te.getItems();
        te.setItems(otherTe.getItems());
        otherTe.setItems(list);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
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
    public void remove() {
        super.remove();
        if (itemHandler != null) {
            itemHandler.invalidate();
        }
    }

    @Override
    public void tick() {
        this.addEffectsToPlayers();
    }


    private void addEffectsToPlayers() {
        if (!this.world.isRemote) {
            for (int i = 0; i < this.getSizeInventory(); i++) {
                AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.pos)).grow(60).expand(0.0D, (double) this.world.getHeight(), 0.0D);
                ItemStack itemInSlot = this.getStackInSlot(i);
                List<PlayerEntity> list = this.world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);
                for (PlayerEntity playerentity : list) {
                    if (itemInSlot.getItem() == ItemList.haste_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.HASTE, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.speed_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.speed_2_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 1, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.haste_2_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.HASTE, 10, 1, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.saturation_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.healing_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.strength_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.strength_2_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.jump_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.jump_2_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 1, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.nausea_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.slowness_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.mining_fatigue_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.blindness_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.levitation_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.LEVITATION, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.resistance_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.resistance_2_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 10, 1, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.night_vision_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.invisibility_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.water_breathing_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.dolphin_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.glowing_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.GLOWING, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.luck_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.LUCK, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.slow_falling_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.absorption_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10, 0, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.absorption_2_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 10, 1, false, false));
                    }
                    if (itemInSlot.getItem() == ItemList.fire_resistance_charm) {
                        playerentity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10, 0, false, false));
                    }
                }
            }
        }
    }
}
