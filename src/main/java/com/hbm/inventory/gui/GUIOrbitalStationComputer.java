package com.hbm.inventory.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.hbm.dim.orbit.OrbitalStation;
import com.hbm.inventory.container.ContainerOrbitalStationComputer;
import com.hbm.lib.RefStrings;
import com.hbm.packet.toserver.NBTControlPacket;
import com.hbm.packet.PacketDispatcher;
import com.hbm.tileentity.machine.TileEntityOrbitalStationComputer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GUIOrbitalStationComputer extends GuiInfoContainer {

	private static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/machine/gui_ship_computer.png");

	private TileEntityOrbitalStationComputer computer;

	private GuiTextField stationName;
	

	public GUIOrbitalStationComputer(TileEntityOrbitalStationComputer station) {
		super(new ContainerOrbitalStationComputer());
		this.computer = station;

		xSize = 198;
		ySize = 135;
	}

	@Override
	public void initGui() {
		super.initGui();
		
		Keyboard.enableRepeatEvents(true);
		stationName = new GuiTextField(this.fontRendererObj, guiLeft + 52, guiTop + 26, 136, 12);
		stationName.setTextColor(0xffffff);
		stationName.setDisabledTextColour(0xdddddd);
		stationName.setEnableBackgroundDrawing(false);
		stationName.setText(OrbitalStation.clientStation.name);
		stationName.setFocused(true);
	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if(OrbitalStation.clientStation.gravityMultiplier > 0) {
			drawTexturedModalRect(guiLeft + 36, guiTop + 84, xSize, 0, 29, 5);
		}

		stationName.drawTextBox();
	}

	@Override
	protected void mouseClicked(int x, int y, int i) {
		super.mouseClicked(x, y, i);
		
		// Toggle gravity
		if(checkClick(x, y, 36, 84, 29, 5)) {
			mc.getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
			setGravity(OrbitalStation.clientStation.gravityMultiplier == 0);
		}
	}

	@Override
	protected void keyTyped(char c, int key) {
		if(stationName.textboxKeyTyped(c, key)) {
			setName(stationName.getText());
		} else {
			super.keyTyped(c, key);
		}

		if(key == 1) {
			mc.thePlayer.closeScreen();
		}
	}

	private void setName(String name) {
		NBTTagCompound data = new NBTTagCompound();
		data.setString("name", name);
		PacketDispatcher.wrapper.sendToServer(new NBTControlPacket(data, computer.xCoord, computer.yCoord, computer.zCoord));
	}

	private void setGravity(boolean enabled) {
		NBTTagCompound data = new NBTTagCompound();
		data.setBoolean("gravity", enabled);
		PacketDispatcher.wrapper.sendToServer(new NBTControlPacket(data, computer.xCoord, computer.yCoord, computer.zCoord));
	}
	
}
