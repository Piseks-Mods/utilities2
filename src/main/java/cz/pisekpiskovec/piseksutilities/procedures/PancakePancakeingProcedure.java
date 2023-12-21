package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.client.Minecraft;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class PancakePancakeingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure PancakePancakeing!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency itemstack for procedure PancakePancakeing!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((itemstack).getCount() > 1) {
			(itemstack).setDisplayName(new StringTextComponent("\u00A7f\u00A7rPancakes"));
			if (world.isRemote()) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("piseks_utilities_ii:textures/items/pancakes.png"));
				Minecraft.getInstance().getTextureManager().loadTexture(new ResourceLocation("piseks_utilities_ii:textures/items/pancake.png"),
						Minecraft.getInstance().getTextureManager()
								.getTexture(new ResourceLocation("piseks_utilities_ii:textures/items/pancakes.png")));
			}
		} else {
			(itemstack).setDisplayName(new StringTextComponent("\u00A7f\u00A7rPancake"));
			if (world.isRemote()) {
				Minecraft.getInstance().getTextureManager().deleteTexture(new ResourceLocation("piseks_utilities_ii:textures/items/pancake.png"));
			}
		}
	}
}
