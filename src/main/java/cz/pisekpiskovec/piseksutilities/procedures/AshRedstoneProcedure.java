package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class AshRedstoneProcedure {

	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure AshRedstone!");
			return 0;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure AshRedstone!");
			return 0;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure AshRedstone!");
			return 0;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure AshRedstone!");
			return 0;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.FIRE) {
			return 15;
		}
		return 0;
	}
}
