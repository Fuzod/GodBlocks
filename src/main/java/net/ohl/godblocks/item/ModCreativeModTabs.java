package net.ohl.godblocks.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GodBlocks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AMETHYST_ITEMS_TAB = CREATIVE_MODE_TABS.register("amethyst_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.AMETHYST_SHARD))
                    .title(Component.translatable("creativetab.godblocks.amethyst_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.AMETHYST_PICKAXE.get());
                        output.accept(ModItems.AMETHYST_AXE.get());
                        output.accept(ModItems.AMETHYST_SHOVEL.get());
                        output.accept(ModItems.AMETHYST_HOE.get());
                        output.accept(ModItems.AMETHYST_STAFF.get());
                        output.accept(ModItems.AMETHYST_SWORD.get());
                        output.accept(ModItems.AMETHYST_HELMET.get());
                        output.accept(ModItems.AMETHYST_CHESTPLATE.get());
                        output.accept(ModItems.AMETHYST_LEGGINGS.get());
                        output.accept(ModItems.AMETHYST_BOOTS.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> FOOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("food_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRAWBERRY_CAKE.get()))
                    .withTabsBefore(AMETHYST_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.godblocks.food_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COCONUT.get());
                        output.accept(ModItems.COCONUT_HALF.get());
                        output.accept(ModItems.COCONUT_MILK.get());
                        output.accept(ModItems.STRAWBERRY_SEEDS.get());
                        output.accept(ModItems.STRAWBERRY.get());
                        output.accept(ModItems.STRAWBERRY_CAKE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> TOOLS_ITEMS_TAB = CREATIVE_MODE_TABS.register("tools_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.METAL_DETECTOR.get()))
                    .withTabsBefore(FOOD_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.godblocks.tool_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AMETHYST_STAFF.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModBlocks.GODBLOCK_T1.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> SPAWN_EGGS_TAB = CREATIVE_MODE_TABS.register("spawn_eggs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RHINO_SPAWN_EGG.get()))
                    .withTabsBefore(TOOLS_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.godblocks.spawn_eggs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RHINO_SPAWN_EGG.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
