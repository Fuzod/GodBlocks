package net.ohl.godblocks.item;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.block.ModBlocks;
import net.ohl.godblocks.entity.ModEntities;
import net.ohl.godblocks.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GodBlocks.MOD_ID);

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY_CAKE)));

    public static final RegistryObject<Item> COCONUT_HALF = ITEMS.register("coconut_half",
            () -> new Item(new Item.Properties().food(ModFoods.COCONUT_HALF)));
    public static final RegistryObject<Item> COCONUT_MILK = ITEMS.register("coconut_milk",
            () -> new CoconutMilkItem(new Item.Properties().food(ModFoods.COCONUT_MILK).stacksTo(16)));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut",
            () -> new CoconutItem(new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_STAFF = ITEMS.register("amethyst_staff",
            () -> new AmethystStaffItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.AMETHYST, 4, - 2.0F))));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.AMETHYST, 2F, - 2.5F))));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 1.5F, - 2.0F))));
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.AMETHYST, 5.5F, - 2.5F))));
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.AMETHYST, - 2.5F, 0.0F))));
    public static final RegistryObject<Item> AMETHYST_PAXEL = ITEMS.register("amethyst_paxel",
            () -> new PaxelItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 2.0F, - 2.0F))));
    public static final RegistryObject<Item> AMETHYST_HAMMER = ITEMS.register("amethyst_hammer",
            () -> new HammerItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7.0F, - 3.5F))));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));
    // TODO: Item and Recipe
    public static final RegistryObject<Item> MAGICAL_SWORD = ITEMS.register("magical_sword",
            () -> new SwordItem(ModToolTiers.AMETHYST, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.AMETHYST, 4, - 2.0F))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
