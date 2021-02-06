package yaboichips.charms.properties;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import yaboichips.charms.Charms;
import yaboichips.charms.lists.ItemList;
import yaboichips.charms.util.CuriosUtil;

@Mod.EventBusSubscriber(modid = Charms.CHARMS, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CharmProperties {

	@SubscribeEvent
    public static void doCharms(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        
        ItemStack charmItem;
      if (player.getHeldItemOffhand().getItem() == ItemList.charm) {
    	 charmItem = player.getHeldItemOffhand();
      }
      else if (CuriosUtil.findItem(ItemList.charm, player) != ItemStack.EMPTY) {
    	charmItem = CuriosUtil.findItem(ItemList.charm, player);
      }
      else {return;}
	
  		if (charmItem.getTag()==null || charmItem.getTag().get("effects") == null) {return;}
  		((ListNBT)charmItem.getTag().get("effects")).forEach((p) -> {
			String asd = p.toString().replace("\"", "");
			int id = Integer.parseInt(asd.split(",")[1]);
			int lvl = Integer.parseInt(asd.split(",")[2])-1;
			player.addPotionEffect(new EffectInstance(Effect.get(id),200,lvl,true,true));
  		});

}}