package yaboichips.charms.util;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import yaboichips.charms.Charms;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ConfigHandler {

	public static class Common {
		// charm potion blacklist
		// charm loot table list

		public final ForgeConfigSpec.IntValue lootWeight;
		public final ForgeConfigSpec.IntValue lootBonusMin;
		public final ForgeConfigSpec.IntValue lootBonusMax;
		
		public final ForgeConfigSpec.IntValue xpValueCreate;
		public final ForgeConfigSpec.IntValue xpValueCombine;
		
		public final ForgeConfigSpec.IntValue maxPotionPotency;

		public final ForgeConfigSpec.ConfigValue<List<? extends String>> charmLootTables;

		public final ForgeConfigSpec.ConfigValue<List<? extends String>> charmPotionBlacklist;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("loot");
			lootWeight = builder.comment("The weight of charms in loot pools").defineInRange("lootWeight", 1, 0,
					Integer.MAX_VALUE);
			lootBonusMin = builder.comment("Minimum ammount of bonus rolls").defineInRange("lootBonusMin", 0, 1,
					Integer.MAX_VALUE);
			lootBonusMax = builder.comment("Maximum ammount of bonus rolls").defineInRange("lootBonusMax", 1, 1,
					Integer.MAX_VALUE);
			builder.pop();

			builder.push("crafting");
			xpValueCreate = builder.comment("How much experience should it cost to create a charm?").defineInRange("xpValueCreate", 30, 1,
					Integer.MAX_VALUE);
			xpValueCombine = builder.comment("How much experience should it cost to combine charms?").defineInRange("xpValueCombine", 60, 1,
					Integer.MAX_VALUE);
			builder.pop();
			
			maxPotionPotency = builder.comment("What should be the maximum potion level on the potions?").defineInRange("xpValueCombine", 255, 1,
					255);
			
			charmLootTables = builder.comment("List of loot tables that charms can come in.").defineList(
					"charmLootTables",
					Arrays.asList("minecraft:chests/abandomed_mineshaft", "minecraft:chests/bastion_bridge",
							"minecraft:chests/bastion_hoglin_stable", "minecraft:chests/bastion_other",
							"minecraft:chests/bastion_treasure", "minecraft:chests/buried_treasure",
							"minecraft:chests/desert_pyramid", "minecraft:chests/igloo_chest",
							"minecraft:chests/jungle_temple", "minecraft:chests/nether_bridge",
							"minecraft:chests/pillager_outpost", "minecraft:chests/simple_dungeon",
							"minecraft:chests/stronghold_corridor", "minecraft:chests/stronghold_crossing",
							"minecraft:chests/stronghold_library", "minecraft:chests/underwater_ruin_big"),
					s -> s instanceof String && ResourceLocation.tryCreate((String) s) != null);
			charmPotionBlacklist = builder.comment("List of potions that you'd rather not have on a charm").defineList(
					"charmPotionBlacklist", Collections.emptyList(),
					s -> s instanceof String && ResourceLocation.tryCreate(s + ":test") != null);
		}
	}

	public static final Common COMMON;
	public static final ForgeConfigSpec COMMON_SPEC;
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static Set<String> charmLootTables;
	public static Set<String> charmPotionBlacklist;

	public static void onConfigLoad() {
		charmLootTables = new HashSet<>(COMMON.charmLootTables.get());
		charmPotionBlacklist = new HashSet<>(COMMON.charmPotionBlacklist.get());
		Charms.configLoaded = true;
	}
}