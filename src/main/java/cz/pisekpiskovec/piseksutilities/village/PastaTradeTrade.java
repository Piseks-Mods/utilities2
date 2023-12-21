
package cz.pisekpiskovec.piseksutilities.village;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicTrade;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerProfession;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import cz.pisekpiskovec.piseksutilities.item.PastaItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PastaTradeTrade {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.FARMER) {
			trades.get(4).add(new BasicTrade(new ItemStack(Items.EMERALD, (int) (17)), new ItemStack(Items.WHEAT, (int) (48)),
					new ItemStack(PastaItem.block, (int) (2)), 6, 3, 0.01f));
		}
	}
}
