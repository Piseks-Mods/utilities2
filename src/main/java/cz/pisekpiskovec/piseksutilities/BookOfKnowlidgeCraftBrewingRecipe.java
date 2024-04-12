
package cz.pisekpiskovec.piseksutilities;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import cz.pisekpiskovec.piseksutilities.item.BookOfKnowlidgeItem;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class BookOfKnowlidgeCraftBrewingRecipe extends PiseksUtilitiesIiModElements.ModElement {
	public BookOfKnowlidgeCraftBrewingRecipe(PiseksUtilitiesIiModElements instance) {
		super(instance, 358);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Blocks.BOOKSHELF.asItem();
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.EXPERIENCE_BOTTLE;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(BookOfKnowlidgeItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
