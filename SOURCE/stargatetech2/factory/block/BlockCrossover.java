package stargatetech2.factory.block;

import stargatetech2.core.machine.BlockMachine;
import stargatetech2.core.machine.TileEntityMachine;
import stargatetech2.core.reference.BlockReference;
import stargatetech2.core.util.GUIHandler.Screen;
import stargatetech2.factory.tileentity.TileCrossover;

public class BlockCrossover extends BlockMachine {

	public BlockCrossover() {
		super(BlockReference.CROSSOVER, false, Screen.CROSSOVER);
	}

	@Override
	protected TileEntityMachine createTileEntity(int metadata) {
		return new TileCrossover();
	}
}