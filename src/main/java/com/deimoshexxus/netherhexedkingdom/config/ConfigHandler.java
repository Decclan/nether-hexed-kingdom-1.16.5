package com.deimoshexxus.netherhexedkingdom.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigHandler 
{
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.BooleanValue NETHER_WATCH_TOWER_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_PRISON_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_GREED_MINES_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_LOOKOUT_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_OUTPOST_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_BULLION_TEMPLE_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_IRON_CLAD_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_RED_SUN_TOWER_SPAWN;

	static
	{
		BUILDER.push("Nether Hexed Kingdom Settings");
		BUILDER.comment("\ntrue/false to generate each structure");
		
		NETHER_WATCH_TOWER_SPAWN = BUILDER.define("Generate nether watch tower?", true);
		NETHER_PRISON_SPAWN = BUILDER.define("Generate nether prison?", true);
		NETHER_GREED_MINES_SPAWN = BUILDER.define("Generate nether mines?", true);
		NETHER_LOOKOUT_SPAWN = BUILDER.define("Generate nether lookout?", true);
		NETHER_OUTPOST_SPAWN = BUILDER.define("Generate nether outpost?", true);
		NETHER_BULLION_TEMPLE_SPAWN = BUILDER.define("Generate nether bullion temple?", true);
		NETHER_IRON_CLAD_SPAWN = BUILDER.define("Generate nether iron clad?", true);
		NETHER_RED_SUN_TOWER_SPAWN = BUILDER.define("Generate nether tower of red sun?", true);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
