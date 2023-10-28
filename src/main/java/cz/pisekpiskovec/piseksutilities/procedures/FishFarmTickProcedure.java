package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class FishFarmTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure FishFarmTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure FishFarmTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure FishFarmTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure FishFarmTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		ItemStack rolledItem = ItemStack.EMPTY;
		double roll = 0;
		double maxStack = 0;
		double slotID = 0;
		double slotCount = 0;
		double rollAdd = 0;
		if (new Object() {
			public boolean get(BlockState _bs, String _property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(_property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get((world.getBlockState(new BlockPos(x, y, z))), "waterlogged")) {
			roll = (MathHelper.nextInt(new Random(), 1, 20));
			if (roll >= 1 && roll <= 17) {
				roll = (MathHelper.nextInt(new Random(), 1, 100));
				slotID = 0;
				slotCount = 2;
				maxStack = 64;
				rollAdd = 1;
				if (roll >= 1 && roll <= 60) {
					rolledItem = new ItemStack(Items.COD);
				} else if (roll >= 61 && roll <= 85) {
					rolledItem = new ItemStack(Items.SALMON);
				} else if (roll >= 86 && roll <= 87) {
					rolledItem = new ItemStack(Items.TROPICAL_FISH);
				} else if (roll >= 88 && roll <= 100) {
					rolledItem = new ItemStack(Items.PUFFERFISH);
				}
			} else if (roll == 18) {
				roll = (MathHelper.nextInt(new Random(), 1, 6));
				slotID = 2;
				slotCount = 3;
				rollAdd = 1;
				if (roll == 1) {
					rolledItem = (EnchantmentHelper.addRandomEnchantment(new Random(), new ItemStack(Items.BOW),
							(int) (MathHelper.nextInt(new Random(), 22, 30)), (true)));
					{
						ItemStack _ist = (rolledItem);
						if (_ist.attemptDamageItem((int) 307, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					maxStack = 1;
				} else if (roll == 2) {
					rolledItem = (EnchantmentHelper.addRandomEnchantment(new Random(), new ItemStack(Items.BOOK), (int) 30, (true)));
					maxStack = 1;
				} else if (roll == 3) {
					rolledItem = (EnchantmentHelper.addRandomEnchantment(new Random(), new ItemStack(Items.FISHING_ROD),
							(int) (MathHelper.nextInt(new Random(), 22, 30)), (true)));
					{
						ItemStack _ist = (rolledItem);
						if (_ist.attemptDamageItem((int) 51, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					maxStack = 1;
				} else if (roll == 4) {
					rolledItem = new ItemStack(Items.NAME_TAG);
					maxStack = 64;
				} else if (roll == 5) {
					rolledItem = new ItemStack(Items.NAUTILUS_SHELL);
					maxStack = 64;
				} else if (roll == 6) {
					rolledItem = new ItemStack(Items.SADDLE);
					maxStack = 64;
				}
			} else if (roll >= 19 && roll <= 20) {
				roll = (MathHelper.nextInt(new Random(), 1, 100));
				slotID = 5;
				slotCount = 6;
				if (roll >= 1 && roll <= 17) {
					rolledItem = new ItemStack(Blocks.LILY_PAD);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 18 && roll <= 27) {
					rolledItem = new ItemStack(Items.BOWL);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 28 && roll <= 29) {
					rolledItem = new ItemStack(Items.FISHING_ROD);
					{
						ItemStack _ist = (rolledItem);
						if (_ist.attemptDamageItem((int) (MathHelper.nextInt(new Random(), (int) 6.4, 64)), new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					maxStack = 1;
					rollAdd = 1;
				} else if (roll >= 30 && roll <= 39) {
					rolledItem = new ItemStack(Items.LEATHER);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 40 && roll <= 49) {
					rolledItem = new ItemStack(Items.LEATHER_BOOTS);
					{
						ItemStack _ist = (rolledItem);
						if (_ist.attemptDamageItem((int) (MathHelper.nextInt(new Random(), (int) 6.5, 65)), new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					maxStack = 1;
					rollAdd = 1;
				} else if (roll >= 50 && roll <= 59) {
					rolledItem = new ItemStack(Items.ROTTEN_FLESH);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 60 && roll <= 64) {
					rolledItem = new ItemStack(Items.STICK);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 65 && roll <= 69) {
					rolledItem = new ItemStack(Items.STRING);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 70 && roll <= 79) {
					rolledItem = new ItemStack(Items.POTION);
					(rolledItem).getOrCreateTag().putString("Potion", "minecraft:water");
					maxStack = 1;
					rollAdd = 1;
				} else if (roll >= 80 && roll <= 89) {
					rolledItem = new ItemStack(Items.BONE);
					maxStack = 64;
					rollAdd = 1;
				} else if (roll >= 90) {
					rolledItem = new ItemStack(Items.INK_SAC);
					maxStack = 64;
					rollAdd = 10;
				} else if (roll >= 91 && roll <= 100) {
					rolledItem = new ItemStack(Items.INK_SAC);
					maxStack = 64;
					rollAdd = 1;
				}
			}
		}
		for (int index0 = 0; index0 < (int) (slotCount); index0++) {
			if ((rolledItem).getItem() == (new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos(x, y, z), (int) (slotID))).getItem() && new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos(x, y, z), (int) (slotID)) <= maxStack - rollAdd || new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos(x, y, z), (int) (slotID)) == 0) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z));
					if (_ent != null) {
						final int _sltid = (int) (slotID);
						final ItemStack _setstack = (rolledItem);
						_setstack.setCount((int) (new Object() {
							public int getAmount(IWorld world, BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(world, new BlockPos(x, y, z), (int) (slotID)) + rollAdd));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				break;
			} else {
				slotID = (slotID + 1);
			}
		}
	}
}
