package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class GloveOfWorldWrappingWrapProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency entity for procedure GloveOfWorldWrappingWrap!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(((entity.getHorizontalFacing()).getXOffset() * 0.3), ((entity.getHorizontalFacing()).getYOffset() * 0.75),
				((entity.getHorizontalFacing()).getZOffset() * 0.3));
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((new java.text.DecimalFormat("##.##").format((entity.getHorizontalFacing()).getYOffset()))), (false));
		}
	}
}
