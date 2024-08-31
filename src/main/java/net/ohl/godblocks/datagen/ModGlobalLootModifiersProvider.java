package net.ohl.godblocks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.loot.AddItemModifier;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, GodBlocks.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.@NotNull Provider registries) {
        add("amethyst_shard_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper")).build()
        }, Items.AMETHYST_SHARD));

        add("amethyst_shard_from_armorer", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_armorer")).build()
        }, Items.AMETHYST_SHARD));
    }
}
