package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.piseksutilities.enchantment.RecycleEnchantment;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class RecycleTriggerProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onItemDestroyed(PlayerDestroyItemEvent event) {
			Entity entity = event.getPlayer();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			ItemStack itemstack = event.getOriginal();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			dependencies.put("itemstack", itemstack);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure RecycleTrigger!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure RecycleTrigger!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency itemstack for procedure RecycleTrigger!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = ((world instanceof World
					&& ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(itemstack), ((World) world)).isPresent())
							? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(itemstack), (World) world).get()
									.getRecipeOutput().copy()
							: ItemStack.EMPTY);
			_setstack.setCount((int) (EnchantmentHelper.getEnchantmentLevel(RecycleEnchantment.enchantment, itemstack)));
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
