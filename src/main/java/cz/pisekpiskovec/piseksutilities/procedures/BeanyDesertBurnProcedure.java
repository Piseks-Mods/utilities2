package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class BeanyDesertBurnProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure BeanyDesertBurn!");
			return false;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure BeanyDesertBurn!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY)
				.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
						.getKey(world.getBiome(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())))
						.equals(new ResourceLocation("desert"))) {
			return true;
		}
		return false;
	}
}
