package com.hbm.blocks.machine;

import com.hbm.blocks.BlockDummyable;
import com.hbm.tileentity.machine.TileEntityMachineIntake;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MachineIntake extends BlockDummyable {

	public MachineIntake() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		if(meta >= 12) return new TileEntityMachineIntake();
		return null;
	}

	@Override public int[] getDimensions() { return new int[] {0, 0, 1, 0, 1, 0}; }
	@Override public int getOffset() { return 0; }

}
