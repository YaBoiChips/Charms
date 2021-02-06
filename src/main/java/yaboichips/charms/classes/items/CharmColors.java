package yaboichips.charms.classes.items;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CharmColors implements IItemColor {

	  @Override
	  public int getColor(ItemStack stack, int tintIndex) {
	    // when rendering, choose the colour multiplier based on the contents
	    // we want layer 0 (the bottle glass) to be unaffected (return white as the multiplier)
	    // layer 1 will change colour depending on the contents, which is stored in NBT.
	    {
	      switch (tintIndex) {
	        case 0: return Color.WHITE.getRGB();
	        case 1: {
	    		if (stack.getTag()==null || stack.getTag().get("effects") == null) {return 0x475CC3;}
				else {
					//PotionUtils.getPotionColorFromEffectList(p_185181_0_);
					//System.out.println(((ListNBT)stack.getTag().get("effects")).getString(0).split(",")[0]);
			        Collection<EffectInstance> effList = new LinkedList<EffectInstance>();
			        ((ListNBT)stack.getTag().get("effects")).forEach((p) -> {
						int id = Integer.parseInt(p.toString().replace("\"", "").split(",")[1]);
//						//new EffectInstance()
						effList.add(new EffectInstance(Effect.get(id)));
						//player.addPotionEffect(new EffectInstance(Effect.get(id),200,lvl,true,true));
//						// System.out.println(Potion.getPotionTypeForName(name).getEffects().get(0).getDuration());
//					   //tooltip.add(new TranslationTextComponent(name).mergeStyle(TextFormatting.GRAY).appendString(" ").append(new TranslationTextComponent("potion.potency." + lvl)));
				   });
			  		
					return PotionUtils.getPotionColorFromEffectList(effList);
				}}
	        default: {
	          // oops! should never get here.
	          return Color.BLACK.getRGB();
	        }
	      }
	    }
	  }
	}