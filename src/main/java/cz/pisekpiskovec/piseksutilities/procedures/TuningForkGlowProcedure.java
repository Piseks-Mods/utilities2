package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class TuningForkGlowProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency itemstack for procedure TuningForkGlow!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		return itemstack.getOrCreateTag().getBoolean("forkTuning");
	}
}
