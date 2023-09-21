package cz.pisekpiskovec.piseksutilities.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ASH_EXPLODES;
	public static final ForgeConfigSpec.ConfigValue<Double> ASH_EXPLODE_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ROTTEN_TRANSFORMS;
	public static final ForgeConfigSpec.ConfigValue<Double> ROTTEN_TRANSFORM_CHANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ROTTEN_TRANSFORM_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_DAMAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> DAMAGE;
	static {
		BUILDER.push("Storage Blocks");
		ASH_EXPLODES = BUILDER.comment("Enable Ash block exploding when mining?").define("Ash Explodes", true);
		ASH_EXPLODE_CHANCE = BUILDER.comment("Chance for Ash block to explode").define("Ash Explode Chance", (double) 0.05);
		ROTTEN_TRANSFORMS = BUILDER.comment("Enable Rotten Flesh block transforming to dirt").define("Rotten Flesh Block Transforms", true);
		ROTTEN_TRANSFORM_CHANCE = BUILDER.comment("Chance for Rotten Flesh block to transform to dirt").define("Rotten Flesh Block Transfom Chance",
				(double) 0.35);
		ROTTEN_TRANSFORM_SPAWN = BUILDER.comment("Enable Rotten Flesh block spawn zombies after transforming").define("Rotten Flesh Block Spawn",
				false);
		BUILDER.pop();
		BUILDER.push("Soul Glass");
		ENABLE_DAMAGE = BUILDER.define("Enable Damage", false);
		DAMAGE = BUILDER.define("Damage", (double) 1);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
