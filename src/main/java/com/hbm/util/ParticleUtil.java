package com.hbm.util;

import java.util.Random;

import com.hbm.handler.threading.PacketThreading;
import com.hbm.main.MainRegistry;
import com.hbm.packet.toclient.AuxParticlePacketNT;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ParticleUtil {

	public static void spawnGasFlame(World world, double x, double y, double z, double mX, double mY, double mZ) {

		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "gasfire");
		data.setDouble("mX", mX);
		data.setDouble("mY", mY);
		data.setDouble("mZ", mZ);

		if(world.isRemote) {
			data.setDouble("posX", x);
			data.setDouble("posY", y);
			data.setDouble("posZ", z);
			MainRegistry.proxy.effectNT(data);
		} else {
			PacketThreading.createAllAroundThreadedPacket(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 150));
		}
	}

	// what in the actual fuck
	public static void spawnJesusFlame(World world, double x, double y, double z) {
		Random rand = new Random();

		if(rand.nextInt(12) == 0) {
		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "duodec");
		if(world.isRemote) {
			data.setDouble("posX", x);
			data.setDouble("posY", y);
			data.setDouble("posZ", z);
			MainRegistry.proxy.effectNT(data);
		} else {
			PacketThreading.createAllAroundThreadedPacket(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 150));
		}
		}
	}

	public static void spawnDroneLine(World world, double x, double y, double z, double x0, double y0, double z0, int color) {

		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "debugdrone");
		data.setDouble("mX", x0);
		data.setDouble("mY", y0);
		data.setDouble("mZ", z0);
		data.setInteger("color", color);
		if(world.isRemote) {
			data.setDouble("posX", x);
			data.setDouble("posY", y);
			data.setDouble("posZ", z);
			MainRegistry.proxy.effectNT(data);
		} else {
			PacketThreading.createAllAroundThreadedPacket(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 150));
		}
	}

	public static void spawnTuneFlame(World world, double x, double y, double z) {
		Random rand = new Random();
		if(rand.nextInt(12) == 0) {
			NBTTagCompound data = new NBTTagCompound();
			data.setString("type", "duoewe");
			if(world.isRemote) {
				data.setDouble("posX", x);
				data.setDouble("posY", y);
				data.setDouble("posZ", z);
				MainRegistry.proxy.effectNT(data);
			} else {
				PacketThreading.createAllAroundThreadedPacket(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 150));
			}
		}
	}

	public static void spawnDustFlame(World world, double x, double y, double z, double mX, double mY, double mZ) {

		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "duststorm");
		data.setDouble("mX", mX);
		data.setDouble("mY", mY);
		data.setDouble("mZ", mZ);
		data.setFloat("scale", 4F);

		if(world.isRemote) {
			data.setDouble("posX", x);
			data.setDouble("posY", y);
			data.setDouble("posZ", z);
			MainRegistry.proxy.effectNT(data);
		} else {
			PacketThreading.createAllAroundThreadedPacket(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 150));
		}
	}

	public static void spawnFlare(World world, double x, double y, double z, double mX, double mY, double mZ, float scale) {

		NBTTagCompound data = new NBTTagCompound();
		data.setString("type", "flare");
		data.setDouble("mX", mX);
		data.setDouble("mY", mY);
		data.setDouble("mZ", mZ);
		data.setFloat("scale", scale);

		if(world.isRemote) {
			data.setDouble("posX", x);
			data.setDouble("posY", y);
			data.setDouble("posZ", z);
			MainRegistry.proxy.effectNT(data);
		} else {
			PacketThreading.createAllAroundThreadedPacket(new AuxParticlePacketNT(data, x, y, z), new TargetPoint(world.provider.dimensionId, x, y, z, 150));
		}
	}

}
