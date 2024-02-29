
package cz.pisekpiskovec.piseksutilities.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import cz.pisekpiskovec.piseksutilities.itemgroup.PUiiMiscItemGroup;
import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class TitaniumChunkItem extends PiseksUtilitiesIiModElements.ModElement {
	@ObjectHolder("piseks_utilities_ii:titanium_chunk")
	public static final Item block = null;

	public TitaniumChunkItem(PiseksUtilitiesIiModElements instance) {
		super(instance, 225);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PUiiMiscItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("titanium_chunk");
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
