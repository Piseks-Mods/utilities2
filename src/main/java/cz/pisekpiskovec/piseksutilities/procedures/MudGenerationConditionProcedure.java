package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.block.MudBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class MudGenerationConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure MudGenerationCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure MudGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure MudGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure MudGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double reach = 0;
		reach = 1;
		for (int index0 = 0; index0 < (int) (2); index0++) {
			if ((world.getFluidState(new BlockPos(x + reach, y, z)).getBlockState()).getMaterial() == net.minecraft.block.material.Material.WATER
					|| (world.getFluidState(new BlockPos(x, y + reach, z)).getBlockState())
							.getMaterial() == net.minecraft.block.material.Material.WATER
					|| (world.getFluidState(new BlockPos(x, y, z + reach)).getBlockState())
							.getMaterial() == net.minecraft.block.material.Material.WATER
					|| (world.getFluidState(new BlockPos(x - reach, y, z)).getBlockState())
							.getMaterial() == net.minecraft.block.material.Material.WATER
					|| (world.getFluidState(new BlockPos(x, y - reach, z)).getBlockState())
							.getMaterial() == net.minecraft.block.material.Material.WATER
					|| (world.getFluidState(new BlockPos(x, y, z - reach)).getBlockState())
							.getMaterial() == net.minecraft.block.material.Material.WATER
					|| (world.getFluidState(new BlockPos(x + reach, y, z)).getBlockState()).getBlock() == MudBlock.block
					|| (world.getFluidState(new BlockPos(x, y + reach, z)).getBlockState()).getBlock() == MudBlock.block
					|| (world.getFluidState(new BlockPos(x, y, z + reach)).getBlockState()).getBlock() == MudBlock.block
					|| (world.getFluidState(new BlockPos(x - reach, y, z)).getBlockState()).getBlock() == MudBlock.block
					|| (world.getFluidState(new BlockPos(x, y - reach, z)).getBlockState()).getBlock() == MudBlock.block
					|| (world.getFluidState(new BlockPos(x, y, z - reach)).getBlockState()).getBlock() == MudBlock.block) {
				return true;
			} else {
				reach = (reach + 1);
			}
		}
		return false;
	}
}
