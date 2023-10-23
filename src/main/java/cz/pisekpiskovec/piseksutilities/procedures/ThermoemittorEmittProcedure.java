package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.Property;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class ThermoemittorEmittProcedure {

	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure ThermoemittorEmitt!");
			return 0;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure ThermoemittorEmitt!");
			return 0;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure ThermoemittorEmitt!");
			return 0;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure ThermoemittorEmitt!");
			return 0;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency blockstate for procedure ThermoemittorEmitt!");
			return 0;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty("facing");
				if (_prop instanceof DirectionProperty)
					return _bs.get((DirectionProperty) _prop);
				_prop = _bs.getBlock().getStateContainer().getProperty("axis");
				return _prop instanceof EnumProperty && _prop.getAllowedValues().toArray()[0] instanceof Direction.Axis
						? Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _prop), Direction.AxisDirection.POSITIVE)
						: Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.NORTH) {
			if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.LAVA) {
				return 15;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.LAVA) {
				return 14;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BLAST_FURNACE && (new Object() {
				public boolean get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
				}
			}.get((world.getBlockState(new BlockPos(x, y, z - 1))), "lit"))) {
				return 13;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.MAGMA_BLOCK) {
				return 12;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SOUL_CAMPFIRE && (new Object() {
				public boolean get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
				}
			}.get((world.getBlockState(new BlockPos(x, y, z - 1))), "lit"))) {
				return 11;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SOUL_FIRE) {
				return 10;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.CAMPFIRE && (new Object() {
				public boolean get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
				}
			}.get((world.getBlockState(new BlockPos(x, y, z - 1))), "lit"))) {
				return 9;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.FIRE) {
				return 8;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.FURNACE && (new Object() {
				public boolean get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
				}
			}.get((world.getBlockState(new BlockPos(x, y, z - 1))), "lit"))) {
				return 7;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BUBBLE_COLUMN && (new Object() {
				public boolean get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
				}
			}.get((world.getBlockState(new BlockPos(x, y, z - 1))), "drag"))) {
				return 6;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SOUL_LANTERN) {
				return 5;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SMOKER) {
				return 4;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.LANTERN
					|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SOUL_TORCH
					|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SOUL_WALL_TORCH) {
				return 3;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BREWING_STAND) {
				return 2;
			} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.JACK_O_LANTERN
					|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.TORCH
					|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.WALL_TORCH) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
}
