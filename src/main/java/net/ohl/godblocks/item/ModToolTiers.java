package net.ohl.godblocks.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.ohl.godblocks.util.ModTags;

public class ModToolTiers {
    public static final Tier AMETHYST =
            new ForgeTier(1800, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_AMETHYST_TOOL, () -> Ingredient.of(Items.AMETHYST_SHARD),
                    Tags.Blocks.NEEDS_NETHERITE_TOOL);
}
