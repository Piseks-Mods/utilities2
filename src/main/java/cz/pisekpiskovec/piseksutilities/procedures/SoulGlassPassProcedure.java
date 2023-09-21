package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.configuration.ConfigConfiguration;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class SoulGlassPassProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure SoulGlassPass!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (ConfigConfiguration.ENABLE_DAMAGE.get()) {
			entity.attackEntityFrom(DamageSource.WITHER, (float) (double) ConfigConfiguration.DAMAGE.get());
		}
	}
}
