package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.piseksutilities.item.PlayItem;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class ThePlayProcedure {
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
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure ThePlay!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ThePlay!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double numDamage = 0;
		double numMultiplicator = 0;
		double numChance = 0;
		if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == PlayItem.block) {
			numDamage = (MathHelper.nextInt(new Random(), 1, 6));
			numMultiplicator = (MathHelper.nextInt(new Random(), 1, 6));
			numChance = (MathHelper.nextInt(new Random(), 1, 2));
			if (numChance == 1) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(new StringTextComponent(("Damage: " + new java.text.DecimalFormat("##").format(numDamage)
									+ " | Multiplicator: " + new java.text.DecimalFormat("##").format(numMultiplicator) + " | Total: "
									+ new java.text.DecimalFormat("##").format(numDamage * numMultiplicator) + " | Destination: "
									+ entity.getDisplayName().getString())), (true));
				}
				entity.attackEntityFrom(DamageSource.MAGIC, (float) (numDamage * numMultiplicator));
			} else if (numChance == 2) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(new StringTextComponent(("Damage: " + new java.text.DecimalFormat("##").format(numDamage)
									+ " | Multiplicator: " + new java.text.DecimalFormat("##").format(numMultiplicator) + " | Total: "
									+ new java.text.DecimalFormat("##").format(numDamage * numMultiplicator) + " | Destination: "
									+ sourceentity.getDisplayName().getString())), (true));
				}
				sourceentity.attackEntityFrom(DamageSource.MAGIC, (float) (numDamage * numMultiplicator));
			} else {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(
									new StringTextComponent(("Damage: " + new java.text.DecimalFormat("##").format(numDamage) + " | Multiplicator: "
											+ new java.text.DecimalFormat("##").format(numMultiplicator) + " | Total: "
											+ new java.text.DecimalFormat("##").format(numDamage * numMultiplicator) + " | Destination: None")),
									(true));
				}
			}
		}
	}
}
