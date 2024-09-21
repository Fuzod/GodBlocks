package net.ohl.godblocks.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.block.custom.*;
import net.ohl.godblocks.item.ModItems;
import net.ohl.godblocks.sound.ModSounds;

import java.util.function.Supplier;

public class ModBlocks {
//    public static final BlockSetType AMETHYST = BlockSetType.register(
//            new BlockSetType(
//                    "amethyst",
//                    true,
//                    false,
//                    true,
//                    BlockSetType.PressurePlateSensitivity.MOBS,
//                    SoundType.AMETHYST,
//                    SoundEvents.IRON_DOOR_CLOSE,
//                    SoundEvents.IRON_DOOR_OPEN,
//                    SoundEvents.IRON_TRAPDOOR_CLOSE,
//                    SoundEvents.IRON_TRAPDOOR_OPEN,
//                    SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF,
//                    SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON,
//                    SoundEvents.STONE_BUTTON_CLICK_OFF,
//                    SoundEvents.STONE_BUTTON_CLICK_ON
//            )
//    );

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GodBlocks.MOD_ID);

    public static final RegistryObject<Block> GODBLOCK_T1 = registerBlock(GodBlockT1.name, GodBlockT1::new);
    public static final RegistryObject<Block> GODBLOCK_T2 = registerBlock(GodBlockT2.name, GodBlockT2::new);
    public static final RegistryObject<Block> GODBLOCK_T3 = registerBlock(GodBlockT3.name, GodBlockT3::new);

    public static final RegistryObject<Block> AMETHYST_LAMP = registerBlock("amethyst_lamp",
            () -> new AmethystLampBlock(BlockBehaviour.Properties.of().strength(3f).lightLevel(state -> state.getValue(AmethystLampBlock.CLICKED) ? 15 : 0)
            ));


    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, registeredBlock);
        return registeredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
