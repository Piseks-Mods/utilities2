package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.block.AshBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class LauncherLaunchProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure LauncherLaunch!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure LauncherLaunch!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure LauncherLaunch!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure LauncherLaunch!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure LauncherLaunch!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double power = 0;
		power = ((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "launcherStrength"))
				/ (16 - ((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) : 0)));
		if (((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) : 0) != 0) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == AshBlock.block) {
				world.destroyBlock(new BlockPos(x, y - 1, z), false);
				entity.setMotion((entity.getMotion().getX()), power, (entity.getMotion().getZ()));
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.BLOCKS, (float) ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(x, y, z), "launcherStrength"))
									/ ((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) : 0)),
							(float) ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(x, y, z), "launcherStrength"))
									/ ((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) : 0)));
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.BLOCKS, (float) ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(x, y, z), "launcherStrength"))
									/ ((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) : 0)),
							(float) ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(x, y, z), "launcherStrength"))
									/ ((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) : 0)),
							false);
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Missing fuel!"), (true));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No Redstone power!"), (true));
			}
		}
	}
}
