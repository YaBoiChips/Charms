package yaboichips.charms.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.ItemList;

public final class AnvilUpdateEventHandler {

	@SubscribeEvent
	public static void onAnvilUpdate(AnvilUpdateEvent event) {

		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();

		ItemStack charm = (left.getItem()==ItemList.charm)?left:((right.getItem()==ItemList.charm)?right:null);
		ItemStack potion = (left.getItem()==Items.POTION)?left:((right.getItem()==Items.POTION)?right:null);

		Boolean doubleCharm = (left.getItem()==ItemList.charm&&right.getItem()==ItemList.charm);

		if(charm !=null && potion!=null) {
			if (charm.getTag()!=null) return;
			event.setCost(ConfigHandler.COMMON.xpValueCreate.get());
			ItemStack output = new ItemStack(ItemList.charm);
			ListNBT effectList = output.getOrCreateTag().getList("effects", 10);
			PotionUtils.getEffectsFromStack(potion).forEach((k) -> {
				if (ConfigHandler.COMMON.charmPotionBlacklist.get().contains(k.getPotion().getEffect().getName())) {return;}
				effectList.add(StringNBT.valueOf(k.getPotion().getEffect().getName()+","+Effect.getId(k.getPotion())+","+(k.getAmplifier()+1)));});
			output.getOrCreateTag().put("effects",effectList);
			event.setOutput(output);
		} else
		
		if(doubleCharm) {
			if (left.getTag()==null || right.getTag()==null) return;
			event.setCost(ConfigHandler.COMMON.xpValueCombine.get());
			
			ItemStack output = new ItemStack(ItemList.charm);
			ListNBT effectList = output.getOrCreateTag().getList("effects", 10);
			final Map<String, Integer> leftPot = new HashMap<>();
			final Map<String, Integer> rightPot = new HashMap<>();
			((ListNBT)left.getTag().get("effects")).forEach((p) -> {String asd = p.toString().replace("\"", "");leftPot.put(asd.split(",")[0]+","+asd.split(",")[1], Integer.parseInt(asd.split(",")[2]));});
			((ListNBT)right.getTag().get("effects")).forEach((p) -> {String asd = p.toString().replace("\"", "");rightPot.put(asd.split(",")[0]+","+asd.split(",")[1], Integer.parseInt(asd.split(",")[2]));});	
			leftPot.forEach((k, v) -> rightPot.merge(k, v, Integer::sum));
			for(Map.Entry<String, Integer> entry : rightPot.entrySet()) {
				if (ConfigHandler.COMMON.charmPotionBlacklist.get().contains(entry.getKey())) {return;}
			    effectList.add(StringNBT.valueOf(entry.getKey()+","+((entry.getValue()>=ConfigHandler.COMMON.maxPotionPotency.get())?ConfigHandler.COMMON.maxPotionPotency.get():entry.getValue())));
			}
			output.getOrCreateTag().put("effects",effectList);			
			event.setOutput(output);
		}

	}

}
