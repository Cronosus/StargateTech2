package stargatetech2.transport.rendering;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import stargatetech2.core.base.BaseISBRH;
import stargatetech2.transport.block.BlockStargate;

public class RenderStargateBlock extends BaseISBRH {
	private static final RenderStargateBlock INSTANCE = new RenderStargateBlock();
	
	public static RenderStargateBlock instance(){
		return INSTANCE;
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		BlockStargate sg = (BlockStargate) block;
		if(world.getBlockMetadata(x, y, z) != BlockStargate.META_RING){
			sg.setBaseOverride();
			renderer.renderStandardBlock(sg, x, y, z);
			sg.restoreTextures();
		}
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(){
		return false;
	}
}