
package cz.pisekpiskovec.piseksutilities.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import cz.pisekpiskovec.piseksutilities.itemgroup.PUiiFoodItemGroup;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class PancakeItem extends PiseksUtilitiesIiModElements.ModElement {
	@ObjectHolder("piseks_utilities_ii:pancake")
	public static final Item block = null;

	public PancakeItem(PiseksUtilitiesIiModElements instance) {
		super(instance, 204);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PUiiFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(8).saturation(4f)

							.build()));
			setRegistryName("pancake");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
