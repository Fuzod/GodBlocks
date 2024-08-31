package net.ohl.godblocks.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = GodBlocks.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(), 12),
                    10, 8, 0.02f));
            // Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.COCONUT.get(), 12),
                    10, 8, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.COCONUT.get(), 1),
                    new ItemStack(ModItems.COCONUT_MILK.get(), 4),
                    10, 8, 0.02f));
        }
        if (event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.AMETHYST_SHARD, 1),
                    10, 8, 0.02f));
        }
    }

    @SubscribeEvent
    public  static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 10),
                new ItemStack(ModItems.AMETHYST_SWORD.get(), 1),
                10, 2, 0.2f));
    }

}
