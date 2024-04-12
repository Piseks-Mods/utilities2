package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import cz.pisekpiskovec.piseksutilities.item.BookOfKnowlidgeItem;
import cz.pisekpiskovec.piseksutilities.item.AnimosityItem;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class TooltipRenderProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void onItemTooltip(ItemTooltipEvent event) {
			if (event != null && event.getPlayer() != null) {
				Entity entity = event.getPlayer();
				ItemStack itemStack = event.getItemStack();
				List<ITextComponent> tooltip = event.getToolTip();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("tooltip", tooltip);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				dependencies.put("itemstack", itemStack);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency itemstack for procedure TooltipRender!");
			return;
		}
		if (dependencies.get("tooltip") == null) {
			if (!dependencies.containsKey("tooltip"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency tooltip for procedure TooltipRender!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		List<ITextComponent> tooltip = (List<ITextComponent>) dependencies.get("tooltip");
		if (itemstack.getItem() == AnimosityItem.block) {
			tooltip.add(
					new StringTextComponent(("Cycles: " + new java.text.DecimalFormat("#").format(itemstack.getOrCreateTag().getDouble("echo")))));
		}
		if (itemstack.getItem() == BookOfKnowlidgeItem.block) {
			tooltip.add(
					new StringTextComponent(("Stored: " + new java.text.DecimalFormat("#").format(itemstack.getOrCreateTag().getDouble("bokExp")))));
		}
	}
}
