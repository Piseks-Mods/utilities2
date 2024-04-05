
package cz.pisekpiskovec.piseksutilities.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import java.util.List;
import java.util.ArrayList;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiModElements;

@PiseksUtilitiesIiModElements.ModElement.Tag
public class NightRoseEnchantment extends PiseksUtilitiesIiModElements.ModElement {
	@ObjectHolder("piseks_utilities_ii:night_rose")
	public static final Enchantment enchantment = null;

	public NightRoseEnchantment(PiseksUtilitiesIiModElements instance) {
		super(instance, 322);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("night_rose"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			List<Enchantment> compatibleEnchantments = new ArrayList<>();
			compatibleEnchantments.add(CopperVeinEnchantment.enchantment);
			compatibleEnchantments.add(Enchantments.SHARPNESS);
			compatibleEnchantments.add(Enchantments.SMITE);
			compatibleEnchantments.add(Enchantments.BANE_OF_ARTHROPODS);
			compatibleEnchantments.add(Enchantments.FIRE_ASPECT);
			compatibleEnchantments.add(Enchantments.SWEEPING);
			compatibleEnchantments.add(Enchantments.IMPALING);
			return !compatibleEnchantments.contains(ench);
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return false;
		}
	}
}
