package yaboichips.charms.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import yaboichips.charms.Charms;
import yaboichips.charms.container.AdvancedCharmContainer;

public class AdvancedContainerScreen extends AbstractContainerScreen<AdvancedCharmContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Charms.CHARMS, "textures/gui/advanced_container.png");


    public AdvancedContainerScreen(AdvancedCharmContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 183;
        this.inventoryLabelY = this.imageHeight - 94;
    }


    @Override
    public void render(PoseStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack,mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack,mouseX, mouseY);
    }


    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.clearColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindForSetup(BACKGROUND_TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack ,x, y, 0, 0, this.imageWidth, this.imageHeight);
    }
}