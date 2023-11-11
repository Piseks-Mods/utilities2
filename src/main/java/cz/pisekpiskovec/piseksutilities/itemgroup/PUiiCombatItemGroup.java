
package cz.pisekpiskovec.piseksutilities.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import cz.pisekpiskovec.piseksutilities.item.ReinforcedItem;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class PUiiCombatItemGroup extends PiseksUtilitiesIiModElements.ModElement {
	public PUiiCombatItemGroup(PiseksUtilitiesIiModElements instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabp_uii_combat") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ReinforcedItem.helmet);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
