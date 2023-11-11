
package cz.pisekpiskovec.piseksutilities.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import cz.pisekpiskovec.piseksutilities.item.MudBallItem;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class PUiiMiscItemGroup extends PiseksUtilitiesIiModElements.ModElement {
	public PUiiMiscItemGroup(PiseksUtilitiesIiModElements instance) {
		super(instance, 121);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabp_uii_misc") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MudBallItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
