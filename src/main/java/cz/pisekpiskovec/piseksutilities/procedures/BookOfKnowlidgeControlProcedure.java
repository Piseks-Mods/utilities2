package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class BookOfKnowlidgeControlProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure BookOfKnowlidgeControl!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency itemstack for procedure BookOfKnowlidgeControl!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double change = 0;
		if (entity.isSneaking() && itemstack.getOrCreateTag().getDouble("bokExp") >= 1) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) 1);
			itemstack.getOrCreateTag().putDouble("bokExp", (itemstack.getOrCreateTag().getDouble("bokExp") - 1));
		} else if (!entity.isSneaking() && 1 <= ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).giveExperiencePoints((int) -1);
			}
			itemstack.getOrCreateTag().putDouble("bokExp", (itemstack.getOrCreateTag().getDouble("bokExp") + 1));
		}
	}
}
