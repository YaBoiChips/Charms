package yaboichips.charms.classes.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import yaboichips.charms.properties.CuriosProperties;
import yaboichips.charms.util.CuriosModCheck;

import java.util.List;

import javax.annotation.Nullable;

public class CharmItem extends Item {
	static final String TAG_POTION_EFFECTS = "effects";

	public CharmItem(Properties properties) {
        super(properties);
    }
    
	   /**
	    * Returns true if this item has an enchantment glint. By default, this returns <code>stack.isItemEnchanted()</code>,
	    * but other items can override it (for instance, written books always return true).
	    *  
	    * Note that if you override this method, you generally want to also call the super version (on {@link Item}) to get
	    * the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
	    */
	@Override
	public boolean hasEffect(ItemStack stack) {
		return stack.isEnchanted() || stack.getTag()!=null;
	}
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        if (CuriosModCheck.CURIOS.isLoaded()){
            return CuriosProperties.initCapabilities();
        }
        else return super.initCapabilities(stack, nbt);
    }
    
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		if (stack.getTag()==null || stack.getTag().get("effects") == null) {
			return new StringTextComponent("Empty ").append(new TranslationTextComponent(this.getTranslationKey(stack)));
		} else if (stack.getTag().get("effects") != null) {
			
			if (((ListNBT)stack.getTag().get("effects")).size()>1) {
				return new TranslationTextComponent(this.getTranslationKey(stack)).append(new StringTextComponent(" Amalgam"));
			}
			else {
				return new TranslationTextComponent(((ListNBT)stack.getTag().get("effects")).getString(0).split(",")[0]).append(new StringTextComponent(" ")).append(new TranslationTextComponent(this.getTranslationKey(stack)));
			}
		}
		return new StringTextComponent("dude idfk how this happens");
		}

	   @OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		   if(Screen.hasShiftDown()){
			   if (stack.getTag()==null) return;
			((ListNBT)stack.getTag().get("effects")).forEach((p) -> {
				String asd = p.toString().replace("\"", "");
				String name = asd.split(",")[0];
				int lvl = Integer.parseInt(asd.split(",")[2])-1;
			   tooltip.add(new TranslationTextComponent(name).mergeStyle(TextFormatting.GRAY).appendString(" ").append(new TranslationTextComponent("potion.potency." + lvl)));
		   });}
	   }
	
}
