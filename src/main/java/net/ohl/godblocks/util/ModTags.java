package net.ohl.godblocks.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.ohl.godblocks.GodBlocks;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_AMETHYST_TOOL = tag("need_amethyst_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(GodBlocks.MOD_ID, name);
        }
    }
    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(GodBlocks.MOD_ID, name);
        }
    }

}
