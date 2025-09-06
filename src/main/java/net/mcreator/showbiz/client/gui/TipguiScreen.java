package net.mcreator.showbiz.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.showbiz.world.inventory.TipguiMenu;
import net.mcreator.showbiz.procedures.TiplimitProcedure;
import net.mcreator.showbiz.procedures.TipdisplayProcedure;
import net.mcreator.showbiz.network.TipguiButtonMessage;
import net.mcreator.showbiz.init.ShowbizModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TipguiScreen extends AbstractContainerScreen<TipguiMenu> implements ShowbizModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_tip;

	public TipguiScreen(TipguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("showbiz:textures/screens/tipgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(RenderType::guiTextured, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (TipdisplayProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.showbiz.tipgui.label_on_cooldown_for_30_minutes"), 15, 16, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_tip = Button.builder(Component.translatable("gui.showbiz.tipgui.button_tip"), e -> {
			int x = TipguiScreen.this.x;
			int y = TipguiScreen.this.y;
			if (TiplimitProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new TipguiButtonMessage(0, x, y, z));
				TipguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 70, 46, 20).build();
		this.addRenderableWidget(button_tip);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_tip.visible = TiplimitProcedure.execute(entity);
	}
}