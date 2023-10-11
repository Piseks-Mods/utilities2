package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Items;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class DiamondDrillHeadBreakProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure DiamondDrillHeadBreak!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure DiamondDrillHeadBreak!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure DiamondDrillHeadBreak!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure DiamondDrillHeadBreak!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos(x, y, z)) : false) && !world.isAirBlock(new BlockPos(x, y + 1, z))
				&& (Items.DIAMOND_SWORD.canHarvestBlock((world.getBlockState(new BlockPos(x, y + 1, z))))
						|| Items.DIAMOND_SHOVEL.canHarvestBlock((world.getBlockState(new BlockPos(x, y + 1, z))))
						|| Items.DIAMOND_PICKAXE.canHarvestBlock((world.getBlockState(new BlockPos(x, y + 1, z))))
						|| Items.DIAMOND_AXE.canHarvestBlock((world.getBlockState(new BlockPos(x, y + 1, z))))
						|| Items.DIAMOND_HOE.canHarvestBlock((world.getBlockState(new BlockPos(x, y + 1, z)))))) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos(x, y + 1, z)), (World) world, new BlockPos(x, y, z));
				world.destroyBlock(new BlockPos(x, y + 1, z), false);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("drillDurability", (new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(x, y, z), "drillDurability") + 1));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "drillDurability") == 1024) {
				world.destroyBlock(new BlockPos(x, y + 0, z), false);
			}
		}
	}
}
