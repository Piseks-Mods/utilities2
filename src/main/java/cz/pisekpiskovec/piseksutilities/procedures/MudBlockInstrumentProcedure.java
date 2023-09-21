package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.piseksutilities.block.MudBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class MudBlockInstrumentProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
			Entity entity = event.getEntity();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("placedagainst", event.getPlacedAgainst());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure MudBlockInstrument!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure MudBlockInstrument!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure MudBlockInstrument!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure MudBlockInstrument!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState noteblockProperty = Blocks.AIR.getDefaultState();
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.NOTE_BLOCK
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == MudBlock.block) {
			noteblockProperty = Blocks.NOTE_BLOCK.getDefaultState();
			noteblockProperty = (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof IntegerProperty && _prop.getAllowedValues().contains(_newValue)
							? _bs.with((IntegerProperty) _prop, _newValue)
							: _bs;
				}
			}.with((noteblockProperty), "note", new Object() {
				public int get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
				}
			}.get((world.getBlockState(new BlockPos(x, y + 1, z))), "note")));
			noteblockProperty = (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof EnumProperty && _prop.parseValue(_newValue).isPresent()
							? _bs.with((EnumProperty) _prop, (Enum) _prop.parseValue(_newValue).get())
							: _bs;
				}
			}.with((noteblockProperty), "instrument", "flute"));
			{
				BlockPos _bp = new BlockPos(x, y + 1, z);
				BlockState _bs = (noteblockProperty);
				world.setBlockState(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.NOTE_BLOCK
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == MudBlock.block) {
			noteblockProperty = Blocks.NOTE_BLOCK.getDefaultState();
			noteblockProperty = (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof IntegerProperty && _prop.getAllowedValues().contains(_newValue)
							? _bs.with((IntegerProperty) _prop, _newValue)
							: _bs;
				}
			}.with((noteblockProperty), "note", new Object() {
				public int get(BlockState _bs, String _property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
				}
			}.get((world.getBlockState(new BlockPos(x, y, z))), "note")));
			noteblockProperty = (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
					return _prop instanceof EnumProperty && _prop.parseValue(_newValue).isPresent()
							? _bs.with((EnumProperty) _prop, (Enum) _prop.parseValue(_newValue).get())
							: _bs;
				}
			}.with((noteblockProperty), "instrument", "flute"));
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = (noteblockProperty);
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
