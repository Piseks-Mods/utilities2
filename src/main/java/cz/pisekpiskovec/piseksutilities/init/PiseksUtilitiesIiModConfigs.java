package cz.pisekpiskovec.piseksutilities.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import cz.pisekpiskovec.piseksutilities.configuration.ConfigConfiguration;

@Mod.EventBusSubscriber(modid = "piseks_utilities_ii", bus = Mod.EventBusSubscriber.Bus.MOD)
public class PiseksUtilitiesIiModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigConfiguration.SPEC, "piseks_utilities_ii_conf.toml");
		});
	}
}
