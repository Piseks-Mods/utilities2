package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.util.Direction;
import net.minecraft.state.Property;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.BooleanProperty;
import net.minecraft.server.MinecraftServer;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.block.MagmaCreamBlockBlock;
import cz.pisekpiskovec.piseksutilities.block.AmberLampBlock;
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
		BlockState getBlock = Blocks.AIR.getDefaultState();
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
			getBlock = (world.getBlockState(new BlockPos(x, y, z - 1)));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty("facing");
				if (_prop instanceof DirectionProperty)
					return _bs.get((DirectionProperty) _prop);
				_prop = _bs.getBlock().getStateContainer().getProperty("axis");
				return _prop instanceof EnumProperty && _prop.getAllowedValues().toArray()[0] instanceof Direction.Axis
						? Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _prop), Direction.AxisDirection.POSITIVE)
						: Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH) {
			getBlock = (world.getBlockState(new BlockPos(x, y, z + 1)));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty("facing");
				if (_prop instanceof DirectionProperty)
					return _bs.get((DirectionProperty) _prop);
				_prop = _bs.getBlock().getStateContainer().getProperty("axis");
				return _prop instanceof EnumProperty && _prop.getAllowedValues().toArray()[0] instanceof Direction.Axis
						? Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _prop), Direction.AxisDirection.POSITIVE)
						: Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.WEST) {
			getBlock = (world.getBlockState(new BlockPos(x - 1, y, z)));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty("facing");
				if (_prop instanceof DirectionProperty)
					return _bs.get((DirectionProperty) _prop);
				_prop = _bs.getBlock().getStateContainer().getProperty("axis");
				return _prop instanceof EnumProperty && _prop.getAllowedValues().toArray()[0] instanceof Direction.Axis
						? Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _prop), Direction.AxisDirection.POSITIVE)
						: Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.EAST) {
			getBlock = (world.getBlockState(new BlockPos(x + 1, y, z)));
		}
		if ((getBlock).getBlock() == Blocks.LAVA) {
			return 15;
		} else if ((getBlock).getBlock() == Blocks.LAVA) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent((new java.text.DecimalFormat("##.########").format(14 - (14 * (15 - (new Object() {
								public int get(BlockState _bs, String _property) {
									Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
									return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
								}
							}.get((getBlock), "level")))) / 15))), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			return 14 - (14 * (15 - (new Object() {
				public int get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
				}
			}.get((getBlock), "level")))) / 15;
		} else if ((getBlock).getBlock() == AmberLampBlock.block) {
			return 14;
		} else if ((getBlock).getBlock() == Blocks.BLAST_FURNACE && (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((getBlock), "lit"))) {
			return 13;
		} else if ((getBlock).getBlock() == Blocks.MAGMA_BLOCK || (getBlock).getBlock() == MagmaCreamBlockBlock.block) {
			return 12;
		} else if ((getBlock).getBlock() == Blocks.SOUL_CAMPFIRE && (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((getBlock), "lit"))) {
			return 11;
		} else if ((getBlock).getBlock() == Blocks.SOUL_FIRE) {
			return 10;
		} else if ((getBlock).getBlock() == Blocks.CAMPFIRE && (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((getBlock), "lit"))) {
			return 9;
		} else if ((getBlock).getBlock() == Blocks.FIRE) {
			return 8;
		} else if ((getBlock).getBlock() == Blocks.FURNACE && (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((getBlock), "lit"))) {
			return 7;
		} else if ((getBlock).getBlock() == Blocks.BUBBLE_COLUMN && (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((getBlock), "drag"))) {
			return 6;
		} else if ((getBlock).getBlock() == Blocks.SOUL_LANTERN) {
			return 5;
		} else if ((getBlock).getBlock() == Blocks.SMOKER && (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((getBlock), "lit"))) {
			return 4;
		} else if ((getBlock).getBlock() == Blocks.LANTERN || (getBlock).getBlock() == Blocks.SOUL_TORCH
				|| (getBlock).getBlock() == Blocks.SOUL_WALL_TORCH) {
			return 3;
		} else if ((getBlock).getBlock() == Blocks.BREWING_STAND) {
			return 2;
		} else if ((getBlock).getBlock() == Blocks.JACK_O_LANTERN || (getBlock).getBlock() == Blocks.TORCH
				|| (getBlock).getBlock() == Blocks.WALL_TORCH) {
			return 1;
		}
		return 0;
	}
}
