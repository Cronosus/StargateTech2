package stargatetech2.transport;

import stargatetech2.IContentModule;
import stargatetech2.StargateTech2;
import stargatetech2.core.reference.TileEntityReference;
import stargatetech2.transport.block.BlockInvisible;
import stargatetech2.transport.block.BlockNaquadahRail;
import stargatetech2.transport.block.BlockStargate;
import stargatetech2.transport.block.BlockTransportRing;
import stargatetech2.transport.stargates.StargateNetwork;
import stargatetech2.transport.tileentity.TileStargate;
import stargatetech2.transport.tileentity.TileStargateBase;
import stargatetech2.transport.tileentity.TileStargateRing;
import stargatetech2.transport.tileentity.TileTransportRing;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModuleTransport implements IContentModule {
	public static BlockNaquadahRail naquadahRail;
	public static BlockTransportRing transportRing;
	public static BlockInvisible invisible;
	public static BlockStargate stargate;
	
	@Override
	public void preInit(){
		naquadahRail = new BlockNaquadahRail();
		transportRing = new BlockTransportRing();
		invisible = new BlockInvisible();
		stargate = new BlockStargate();
	}

	@Override
	public void init(){
		naquadahRail.registerBlock();
		transportRing.registerBlock();
		invisible.registerBlock();
		stargate.registerBlock();
		
		GameRegistry.registerTileEntity(TileTransportRing.class, TileEntityReference.TILE_TRANSPORT_RING);
		GameRegistry.registerTileEntity(TileStargate.class, TileEntityReference.TILE_STARGATE);
		GameRegistry.registerTileEntity(TileStargateRing.class, TileEntityReference.TILE_STARGATE_RING);
		GameRegistry.registerTileEntity(TileStargateBase.class, TileEntityReference.TILE_STARGATE_BASE);
	}

	@Override
	public void postInit(){
		LanguageRegistry.addName(naquadahRail, "Naquadah Rail");
		LanguageRegistry.addName(transportRing, "Transport Ring");
		LanguageRegistry.addName(invisible, "Invisible Block");
		LanguageRegistry.addName(stargate, "Stargate");
		
		//GameRegistry.addShapedRecipe(new ItemStack(naquadahRail), "NSN", "NSN", "NSN", 'N', naqBar, 'S', stick);
		//GameRegistry.addShapedRecipe(new ItemStack(transportRing), "NPN", "NBN", "NPN", 'N', naqPlate, 'P', pearl, 'B', ironBlock);
		
		StargateTech2.proxy.registerRenderers(Module.TRANSPORT);
	}

	@Override public void onServerStart(){
		StargateNetwork.instance().load();
	}
	
	@Override public void onServerStop(){
		StargateNetwork.instance().unload();
	}

	@Override
	public String getModuleName(){
		return "Transport";
	}
}