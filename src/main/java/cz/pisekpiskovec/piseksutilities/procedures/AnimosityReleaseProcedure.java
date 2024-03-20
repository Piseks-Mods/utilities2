package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.piseksutilities.item.AnimosityItem;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class AnimosityReleaseProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure AnimosityRelease!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AnimosityRelease!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double currentDamage = 0;
		double newDamage = 0;
		if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == AnimosityItem.block) {
			if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getDouble("echo") > 0) {
				entity.attackEntityFrom(DamageSource.MAGIC, (float) 12);
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putDouble("echo",
								(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getOrCreateTag().getDouble("echo") - 1));
				if (sourceentity instanceof LivingEntity) {
					((LivingEntity) sourceentity).swing(Hand.MAIN_HAND, true);
				}
				if (0 > (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage()
						- 12) {
					currentDamage = ((((sourceentity instanceof LivingEntity)
							? ((LivingEntity) sourceentity).getHeldItemMainhand()
							: ItemStack.EMPTY)).getDamage());
					newDamage = ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
							.getDamage() - 12);
					{
						ItemStack _ist = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getHeldItemMainhand()
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) (-12), new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					if (sourceentity instanceof LivingEntity)
						((LivingEntity) sourceentity)
								.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
										+ Math.abs(newDamage)));
				} else {
					{
						ItemStack _ist = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getHeldItemMainhand()
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) (-12), new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			} else {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("\u00A7cNot enough cycles."), (true));
				}
			}
		}
	}
}
