package cz.pisekpiskovec.piseksutilities.procedures;

import java.util.Map;

import cz.pisekpiskovec.piseksutilities.configuration.ConfigConfiguration;

public class ThermoemittorEnabledProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		return ConfigConfiguration.ENABLE_THERMOEMITTOR.get();
	}
}
