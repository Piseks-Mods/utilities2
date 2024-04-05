package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.enchantment.NightRoseEnchantment;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class NightRoseBloomProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure NightRoseBloom!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((EnchantmentHelper.getEnchantmentLevel(NightRoseEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("nightRoseBlooming",
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("nightRoseBlooming")
									+ ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel(-((int) ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		} else if ((EnchantmentHelper.getEnchantmentLevel(NightRoseEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)) != 0)) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("nightRoseBlooming",
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("nightRoseBlooming")
									+ ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel(-((int) ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		}
	}
}
