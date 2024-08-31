package net.ohl.godblocks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.block.ModBlocks;
import net.ohl.godblocks.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GodBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .addTag(Tags.Blocks.ORES);

        this.tag(ModTags.Blocks.NEEDS_AMETHYST_TOOL)
                .add(ModBlocks.GODBLOCK_T1.get());


//        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.HIMALAYAN_SALT_ORE.get());
//        this.tag(BlockTags.MINEABLE_WITH_AXE)
//                .add(ModBlocks.HIMALAYAN_SALT_BLOCK.get());
//
//        this.tag(BlockTags.FENCES)
//                .add(ModBlocks.AMETHYST_FENCE.get());
//        this.tag(BlockTags.FENCE_GATES)
//                .add(ModBlocks.AMETHYST_FENCE_GATE.get());
//        this.tag(BlockTags.WALLS)
//                .add(ModBlocks.AMETHYST_WALL.get());
    }
}
