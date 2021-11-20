package com.deimoshexxus.netherhexedkingdom.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigHandler 
{
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static ForgeConfigSpec COMMON_CONFIG;
	//Structures
	public static final ForgeConfigSpec.BooleanValue NETHER_WATCH_TOWER_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_PRISON_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_GREED_MINES_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_LOOKOUT_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_OUTPOST_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_BULLION_TEMPLE_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_IRON_CLAD_SPAWN;
	public static final ForgeConfigSpec.BooleanValue NETHER_RED_SUN_TOWER_SPAWN;
	
	//Entities
	public static final ForgeConfigSpec.BooleanValue WILD_WITHER_SKELETON_SPAWN;
	public static final ForgeConfigSpec.BooleanValue WILD_WITHER_SKELETON_HORSE_SPAWN;
	public static final ForgeConfigSpec.BooleanValue WILD_WITHER_SKELETON_DEATH_RIDER_SPAWN;
	public static final ForgeConfigSpec.BooleanValue WILD_HEXED_UNDEAD_HORSE_SPAWN;
	public static final ForgeConfigSpec.BooleanValue WILD_HEXED_UNDEAD_HORSE_RIDER_SPAWN;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> WEIGHT_WITHER_SKELETON_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> WEIGHT_WITHER_SKELETON_HORSE_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> WEIGHT_WITHER_SKELETON_DEATH_RIDER_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> WEIGHT_HEXED_UNDEAD_HORSE_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> WEIGHT_HEXED_UNDEAD_HORSE_RIDER_SPAWN;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> MIN_WITHER_SKELETON_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MIN_WITHER_SKELETON_HORSE_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MIN_WITHER_SKELETON_DEATH_RIDER_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MIN_HEXED_UNDEAD_HORSE_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MIN_HEXED_UNDEAD_HORSE_RIDER_SPAWN;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_WITHER_SKELETON_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_WITHER_SKELETON_HORSE_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_WITHER_SKELETON_DEATH_RIDER_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_HEXED_UNDEAD_HORSE_SPAWN;
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_HEXED_UNDEAD_HORSE_RIDER_SPAWN;
	
	static
	{
		BUILDER.push("Nether Hexed Kingdom Mod Settings");
		
		BUILDER.comment("\nEnable/disable generation of each structure:"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+ "\nGenerate nether watch tower? \nDefault value: true");
		NETHER_WATCH_TOWER_SPAWN = BUILDER.define("Nether watch tower?", true);
		
		BUILDER.comment("\nGenerate nether prison? \nDefault value: true");
		NETHER_PRISON_SPAWN = BUILDER.define("Nether prison", true);
		
		BUILDER.comment("\nGenerate nether mines? \nDefault value: true");
		NETHER_GREED_MINES_SPAWN = BUILDER.define("Nether mines", true);
		
		BUILDER.comment("\nGenerate nether lookout? \nDefault value: true");
		NETHER_LOOKOUT_SPAWN = BUILDER.define("Nether lookout", true);
		
		BUILDER.comment("\nGenerate nether outpost? \nDefault value: true");
		NETHER_OUTPOST_SPAWN = BUILDER.define("Nether outpost", true);
		
		BUILDER.comment("\nGenerate nether bullion temple? \nDefault value: true");
		NETHER_BULLION_TEMPLE_SPAWN = BUILDER.define("Bullion temple", true);
		
		BUILDER.comment("\nGenerate nether iron clad? \nDefault value: true");
		NETHER_IRON_CLAD_SPAWN = BUILDER.define("Iron clad", true);
		
		BUILDER.comment("\nGenerate nether tower of red sun? \nDefault value: true");
		NETHER_RED_SUN_TOWER_SPAWN = BUILDER.define("Tower of red sun?", true);

		BUILDER.comment("\nEnable/disable each entity to the natural generation list in the nether:"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+ "\nAdd wither skeletons to the nether wastes? \nDefault value: true");
		WILD_WITHER_SKELETON_SPAWN = BUILDER.define("Add wither skeletons", true);
		
		BUILDER.comment("\nAdd wither skeleton horses to the nether wastes? Default value: true");
		WILD_WITHER_SKELETON_HORSE_SPAWN = BUILDER.define("Add wither skeleton horses", true);
		
		BUILDER.comment("\nAdd wither skeleton death riders to the nether wastes? Default value: true");
		WILD_WITHER_SKELETON_DEATH_RIDER_SPAWN = BUILDER.define("Add wither skeleton death riders", true);
		
		BUILDER.comment("\nAdd hexed undead horses to the crimson forests? Default value: true");
		WILD_HEXED_UNDEAD_HORSE_SPAWN = BUILDER.define("Add hexed undead horses", true);
		
		BUILDER.comment("\nAdd hexed undead horse riders to the soul sand valleys?");
		WILD_HEXED_UNDEAD_HORSE_RIDER_SPAWN = BUILDER.define("Add hexed undead horse riders", true);

		BUILDER.comment("\nNatural generation spawn weight for each entity:"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+"\nSpawn weight for wither skeletons. \nDefault value: 30");
		WEIGHT_WITHER_SKELETON_SPAWN = BUILDER.define("Wither skeletons weight", 30);
		
		BUILDER.comment("\npawn weight for wither skeleton horses. Default value: 20");
		WEIGHT_WITHER_SKELETON_HORSE_SPAWN = BUILDER.define("Wither skeleton horse weight", 20);
		
		BUILDER.comment("\nSpawn weight for wither skeleton death riders. Default value: 30");
		WEIGHT_WITHER_SKELETON_DEATH_RIDER_SPAWN = BUILDER.define("Wither skeleton death rider weight", 30);
		
		BUILDER.comment("\nSpawn weight for hexed undead horses. Default value: 5");
		WEIGHT_HEXED_UNDEAD_HORSE_SPAWN = BUILDER.define("Hexed undead horse weight", 5);
		
		BUILDER.comment("\nSpawn weight for hexed undead horse riders. Default value: 10");
		WEIGHT_HEXED_UNDEAD_HORSE_RIDER_SPAWN = BUILDER.define("Hexed undead horse rider weight", 10);
		
		BUILDER.comment("\nMinimum spawn number for each entity:"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+"\nMinimum spawn count for wither skeletons. \nDefault value: 0");
		MIN_WITHER_SKELETON_SPAWN = BUILDER.define("Min wither skeletons", 0);
		
		BUILDER.comment("\nMinimum spawn count for wither skeleton horses. Default value: 0");
		MIN_WITHER_SKELETON_HORSE_SPAWN = BUILDER.define("Min wither skeleton horses", 0);
		
		BUILDER.comment("\nMinimum spawn count for wither skeleton death riders. Default value: 0");
		MIN_WITHER_SKELETON_DEATH_RIDER_SPAWN = BUILDER.define("Min wither skeleton death riders", 0);
		
		BUILDER.comment("\nMinimum spawn count for hexed undead horses. Default value: 0");
		MIN_HEXED_UNDEAD_HORSE_SPAWN = BUILDER.define("Min hexed undead horses", 0);
		
		BUILDER.comment("\nMinimum spawn count for hexed undead horse riders. Default value: 0");
		MIN_HEXED_UNDEAD_HORSE_RIDER_SPAWN = BUILDER.define("Minimum spawn count for hexed undead horse riders", 0);
		
		BUILDER.comment("\nMax spawn number for each entity, must be larger than minimum:"
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
				+"\nMax spawn count for wither skeletons. \nDefault value: 3");
		MAX_WITHER_SKELETON_SPAWN = BUILDER.define("Max wither skeletons", 3);
		
		BUILDER.comment("\nMax spawn count for wither skeleton horses. Default value: 1");
		MAX_WITHER_SKELETON_HORSE_SPAWN = BUILDER.define("Max wither skeleton horses", 1);
		
		BUILDER.comment("\nMax spawn count for wither skeleton death riders. Default value: 3");
		MAX_WITHER_SKELETON_DEATH_RIDER_SPAWN = BUILDER.define("Max wither skeleton death riders", 3);
		
		BUILDER.comment("\nMax spawn count for hexed undead horses. Default value: 2");
		MAX_HEXED_UNDEAD_HORSE_SPAWN = BUILDER.define("Max hexed undead horses", 2);
		
		BUILDER.comment("\nMax spawn count for hexed undead horse riders. Default value: 3");
		MAX_HEXED_UNDEAD_HORSE_RIDER_SPAWN = BUILDER.define("Max hexed undead horse riders", 3);
		
		BUILDER.pop();
		
		COMMON_CONFIG = BUILDER.build();
	}
	
}
