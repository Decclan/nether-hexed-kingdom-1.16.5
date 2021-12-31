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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_WATCH_TOWER_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_PRISON_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_GREED_MINES_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_LOOKOUT_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_OUTPOST_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_BULLION_TEMPLE_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_IRON_CLAD_MAX;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_RED_SUN_TOWER_MAX;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_WATCH_TOWER_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_PRISON_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_GREED_MINES_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_LOOKOUT_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_OUTPOST_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_BULLION_TEMPLE_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_IRON_CLAD_MIN;
	public static final ForgeConfigSpec.ConfigValue<Integer> NETHER_RED_SUN_TOWER_MIN;
	
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
		NETHER_WATCH_TOWER_SPAWN = BUILDER.define("Generate nether watch tower?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 10");
		NETHER_WATCH_TOWER_MAX = BUILDER.define("Watch tower max", 10);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 3");
		NETHER_WATCH_TOWER_MIN = BUILDER.define("Watch tower min", 3);
		
		BUILDER.comment("\nGenerate nether prison? \nDefault value: true");
		NETHER_PRISON_SPAWN = BUILDER.define("Generate nether prison?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 15");
		NETHER_PRISON_MAX = BUILDER.define("Nether prison max", 15);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 5");
		NETHER_PRISON_MIN = BUILDER.define("Nether prison min", 5);
		
		BUILDER.comment("\nGenerate nether mines? \nDefault value: true");
		NETHER_GREED_MINES_SPAWN = BUILDER.define("Generate nether mines?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 16");
		NETHER_GREED_MINES_MAX = BUILDER.define("Nether mines max", 16);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 8");
		NETHER_GREED_MINES_MIN = BUILDER.define("Nether mines min", 8);
		
		BUILDER.comment("\nGenerate nether lookout? \nDefault value: true");
		NETHER_LOOKOUT_SPAWN = BUILDER.define("Generate nether lookout?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 18");
		NETHER_LOOKOUT_MAX = BUILDER.define("Nether lookout max", 18);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 8");
		NETHER_LOOKOUT_MIN = BUILDER.define("Nether lookout min", 8);
		
		BUILDER.comment("\nGenerate nether outpost? \nDefault value: true");
		NETHER_OUTPOST_SPAWN = BUILDER.define("Generate nether outpost?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 12");
		NETHER_OUTPOST_MAX = BUILDER.define("Nether outpost max", 12);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 6");
		NETHER_OUTPOST_MIN = BUILDER.define("Nether outpost min", 6);
		
		BUILDER.comment("\nGenerate nether bullion temple? \nDefault value: true");
		NETHER_BULLION_TEMPLE_SPAWN = BUILDER.define("Generate bullion temple?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 16");
		NETHER_BULLION_TEMPLE_MAX = BUILDER.define("Bullion temple max", 16);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 7");
		NETHER_BULLION_TEMPLE_MIN = BUILDER.define("Bullion temple min", 7);
		
		BUILDER.comment("\nGenerate nether iron clad? \nDefault value: true");
		NETHER_IRON_CLAD_SPAWN = BUILDER.define("Generate iron clad?", true);
		
		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 10");
		NETHER_IRON_CLAD_MAX = BUILDER.define("Iron clad max", 10);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 5");
		NETHER_IRON_CLAD_MIN = BUILDER.define("Iron clad min", 5);
		
		BUILDER.comment("\nGenerate nether tower of red sun? \nDefault value: true");
		NETHER_RED_SUN_TOWER_SPAWN = BUILDER.define("Generate tower of red sun?", true);

		BUILDER.comment("\nMaximum chunk distance spawn attempt \nDefault value: 24");
		NETHER_RED_SUN_TOWER_MAX = BUILDER.define("Tower of red sun max", 24);
		
		BUILDER.comment("\nMinimum chunk distance spawn attempt \nDefault value: 12");
		NETHER_RED_SUN_TOWER_MIN = BUILDER.define("Tower of red sun min", 12);
		
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
				+"\nSpawn weight for wither skeletons. \nDefault value: 15");
		WEIGHT_WITHER_SKELETON_SPAWN = BUILDER.define("Wither skeletons weight", 15);
		
		BUILDER.comment("\npawn weight for wither skeleton horses. Default value: 12");
		WEIGHT_WITHER_SKELETON_HORSE_SPAWN = BUILDER.define("Wither skeleton horse weight", 12);
		
		BUILDER.comment("\nSpawn weight for wither skeleton death riders. Default value: 20");
		WEIGHT_WITHER_SKELETON_DEATH_RIDER_SPAWN = BUILDER.define("Wither skeleton death rider weight", 20);
		
		BUILDER.comment("\nSpawn weight for hexed undead horses. Default value: 5");
		WEIGHT_HEXED_UNDEAD_HORSE_SPAWN = BUILDER.define("Hexed undead horse weight", 5);
		
		BUILDER.comment("\nSpawn weight for hexed undead horse riders. Default value: 8");
		WEIGHT_HEXED_UNDEAD_HORSE_RIDER_SPAWN = BUILDER.define("Hexed undead horse rider weight", 8);
		
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
