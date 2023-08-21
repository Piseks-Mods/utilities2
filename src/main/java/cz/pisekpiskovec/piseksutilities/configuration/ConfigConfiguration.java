package cz.pisekpiskovec.piseksutilities.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ASH_EXPLODES;
	static {
		BUILDER.push("Storage Blocks");
		ASH_EXPLODES = BUILDER.comment("Enable Ash block exploding when mining?").define("Ash Explodes", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
