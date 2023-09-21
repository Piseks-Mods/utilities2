package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.piseksutilities.configuration.ConfigConfiguration;
import cz.pisekpiskovec.piseksutilities.block.RottenFleshBlockBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class RottenFleshBlockTransformProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure RottenFleshBlockTransform!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure RottenFleshBlockTransform!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure RottenFleshBlockTransform!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure RottenFleshBlockTransform!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sX = 0;
		double sY = 0;
		double sZ = 0;
		if (ConfigConfiguration.ROTTEN_TRANSFORMS.get() && Math.random() < (double) ConfigConfiguration.ROTTEN_TRANSFORM_CHANCE.get()) {
			world.playEvent(2001, new BlockPos(x, y, z), Block.getStateId(RottenFleshBlockBlock.block.getDefaultState()));
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = Blocks.DIRT.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			for (int index0 = 0; index0 < (int) (MathHelper.nextInt(new Random(), 1, 5)); index0++) {
				sX = (MathHelper.nextInt(new Random(), -1, 1));
				sZ = (MathHelper.nextInt(new Random(), -1, 1));
				if (ConfigConfiguration.ROTTEN_TRANSFORM_SPAWN.get()) {
					if (world.isAirBlock(new BlockPos(sX, y, sZ)) && world.isAirBlock(new BlockPos(sX, y + 1, sZ))
							&& world.getLight(new BlockPos(sX, y, sX)) < 7) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new ZombieEntity(EntityType.ZOMBIE, (World) world);
							entityToSpawn.setLocationAndAngles(sX, y, sZ, (float) (MathHelper.nextInt(new Random(), -180, 180)), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -180, 180)));
							entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -180, 180)));
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
