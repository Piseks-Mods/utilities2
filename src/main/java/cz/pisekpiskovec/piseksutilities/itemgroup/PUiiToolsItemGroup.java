
package cz.pisekpiskovec.piseksutilities.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import cz.pisekpiskovec.piseksutilities.block.IronDrillHeadBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class PUiiToolsItemGroup extends PiseksUtilitiesIiModElements.ModElement {
	public PUiiToolsItemGroup(PiseksUtilitiesIiModElements instance) {
		super(instance, 123);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabp_uii_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(IronDrillHeadBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
