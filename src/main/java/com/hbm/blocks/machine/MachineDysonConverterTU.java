package com.hbm.blocks.machine;

import com.hbm.blocks.BlockDummyable;
import com.hbm.tileentity.TileEntityProxyCombo;
import com.hbm.tileentity.machine.TileEntityDysonConverterTU;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MachineDysonConverterTU extends BlockDummyable {

	public MachineDysonConverterTU(Material mat) {
		super(mat);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		if(meta >= 12) return new TileEntityDysonConverterTU();
		if(meta >= 6) return new TileEntityProxyCombo().heatSource();
		return null;
	}

	@Override
	public int[] getDimensions() {
		return new int[] {2, 0, 1, 6, 1, 1};
	}

	@Override
	public int getOffset() {
		return 6;
	}

	@Override
	public void fillSpace(World world, int x, int y, int z, ForgeDirection dir, int o) {
		super.fillSpace(world, x, y, z, dir, o);

		x = x + dir.offsetX * o;
		z = z + dir.offsetZ * o;

		this.makeExtra(world, x, y + 1, z);
		this.makeExtra(world, x, y + 2, z);
	}

}
