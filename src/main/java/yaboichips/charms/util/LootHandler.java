package yaboichips.charms.util;


import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;

public final class LootHandler {
	public static final ResourceLocation table = new ResourceLocation("charms", "inject");

	public static void lootLoad(LootTableLoadEvent evt) {
		if (ConfigHandler.COMMON.charmLootTables.get().contains(evt.getName().toString())) {
			evt.getTable().addPool(LootPool.builder()
					.addEntry(TableLootEntry.builder(new ResourceLocation("charms", "inject"))
							.weight(ConfigHandler.COMMON.lootWeight.get()))
					.bonusRolls(ConfigHandler.COMMON.lootBonusMin.get(), ConfigHandler.COMMON.lootBonusMax.get())
					.name("charms_inject").build());
		}
	}

}
