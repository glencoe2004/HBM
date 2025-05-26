package com.hbm.dim.tekto;

import java.util.Random;

import com.hbm.config.SpaceConfig;
import com.hbm.dim.CelestialBody;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGeneratorTekto implements IWorldGenerator {


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.dimensionId == SpaceConfig.tektoDimension) {
			generateTekto(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateTekto(World world, Random rand, int i, int j) {
		int meta = CelestialBody.getMeta(world);
	}
}
