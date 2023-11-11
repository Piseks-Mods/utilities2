
package cz.pisekpiskovec.piseksutilities.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import cz.pisekpiskovec.piseksutilities.block.CharcoalBlockBlock;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class PUiiBuildingBlocksItemGroup extends PiseksUtilitiesIiModElements.ModElement {
	public PUiiBuildingBlocksItemGroup(PiseksUtilitiesIiModElements instance) {
		super(instance, 119);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabp_uii_building_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CharcoalBlockBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
