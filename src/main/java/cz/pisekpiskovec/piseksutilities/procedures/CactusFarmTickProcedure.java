package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
import java.util.Map;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class CactusFarmTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency world for procedure CactusFarmTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency x for procedure CactusFarmTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency y for procedure CactusFarmTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency z for procedure CactusFarmTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double generate = 0;
		generate = (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
						.equals(new ResourceLocation("desert"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z)))
								.equals(new ResourceLocation("badlands"))
										? MathHelper.nextInt(new Random(), 1, 8)
										: MathHelper.nextInt(new Random(), 1, 4));
		if (new Object() {
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
		}.getAmount(world, new BlockPos(x, y, z), (int) (0)) <= 64 - generate) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					final ItemStack _setstack = new ItemStack(Blocks.CACTUS);
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
					}.getAmount(world, new BlockPos(x, y, z), (int) (0)) + generate));
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
		}
	}
}
