package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.block.SafeNetBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class SafeNetGrowProcedure {

	public static ActionResultType executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure SafeNetGrow!");
			return ActionResultType.PASS;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure SafeNetGrow!");
			return ActionResultType.PASS;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure SafeNetGrow!");
			return ActionResultType.PASS;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure SafeNetGrow!");
			return ActionResultType.PASS;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure SafeNetGrow!");
			return ActionResultType.PASS;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(SafeNetBlock.block)) : false) {
			if ((entity.getHorizontalFacing()) == Direction.NORTH) {
				if (world.isAirBlock(new BlockPos(x, y, z - 1))) {
					world.setBlockState(new BlockPos(x, y, z - 1), SafeNetBlock.block.getDefaultState(), 3);
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SafeNetBlock.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					return ActionResultType.SUCCESS;
				}
			} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
				if (world.isAirBlock(new BlockPos(x, y, z + 1))) {
					world.setBlockState(new BlockPos(x, y, z + 1), SafeNetBlock.block.getDefaultState(), 3);
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SafeNetBlock.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					return ActionResultType.SUCCESS;
				}
			} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
				if (world.isAirBlock(new BlockPos(x - 1, y, z))) {
					world.setBlockState(new BlockPos(x - 1, y, z), SafeNetBlock.block.getDefaultState(), 3);
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SafeNetBlock.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					return ActionResultType.SUCCESS;
				}
			} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
				if (world.isAirBlock(new BlockPos(x + 1, y, z))) {
					world.setBlockState(new BlockPos(x + 1, y, z), SafeNetBlock.block.getDefaultState(), 3);
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SafeNetBlock.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					return ActionResultType.SUCCESS;
				}
			}
			return ActionResultType.PASS;
		}
		return ActionResultType.FAIL;
	}
}
