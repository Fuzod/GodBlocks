package net.ohl.godblocks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
//    private static final List<ItemLike> HIMALAYAN_SMELTABLES = List.of(ModBlocks.HIMALAYAN_SALT_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
//        oreSmelting(pRecipeOutput, HIMALAYAN_SMELTABLES, RecipeCategory.MISC, ModItems.HIMALAYAN_SALT.get(), 0.25f, 200, "himalyan_salt");
//        oreBlasting(pRecipeOutput, HIMALAYAN_SMELTABLES, RecipeCategory.MISC, ModItems.HIMALAYAN_SALT.get(), 0.25f, 100, "himalyan_salt");

//        ShapedRecipeBuilder.shaped(
//                        RecipeCategory.MISC,
//                        ModBlocks.HIMALAYAN_SALT_FULL_BLOCK.get())
//                .pattern("###")
//                .pattern("###")
//                .pattern("###")
//                .define('#', ModItems.HIMALAYAN_SALT.get())
//                .unlockedBy(getHasName(ModItems.HIMALAYAN_SALT.get()), has(ModItems.HIMALAYAN_SALT.get()))
//                .save(pRecipeOutput);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HIMALAYAN_SALT_FULL_BLOCK.get(), 9)
//                .requires(ModBlocks.HIMALAYAN_SALT_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.HIMALAYAN_SALT_BLOCK.get()), has(ModBlocks.HIMALAYAN_SALT_BLOCK.get()))
//                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID,
//                        getConversionRecipeName(
//                                ModBlocks.HIMALAYAN_SALT_FULL_BLOCK.get(),
//                                ModBlocks.HIMALAYAN_SALT_BLOCK.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.STRAWBERRY_CAKE.get(), 3)
                .requires(ModItems.STRAWBERRY.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(ModItems.STRAWBERRY.get()), has(ModItems.STRAWBERRY.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COCONUT_HALF.get(), 2)
                .requires(ModItems.COCONUT.get())
                .unlockedBy(getHasName(ModItems.COCONUT.get()), has(ModItems.COCONUT.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COCONUT_MILK.get())
                .requires(ModItems.COCONUT_HALF.get())
                .requires(Items.STICK)
                .unlockedBy(getHasName(ModItems.COCONUT_HALF.get()), has(ModItems.COCONUT_HALF.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.COMBAT,
                        ModItems.AMETHYST_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.COMBAT,
                        ModItems.AMETHYST_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.COMBAT,
                        ModItems.AMETHYST_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.COMBAT,
                        ModItems.AMETHYST_BOOTS.get())
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.COMBAT,
                        ModItems.AMETHYST_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_STAFF.get())
                .pattern(" # ")
                .pattern("#S#")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_PICKAXE.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_PAXEL.get())
                .pattern("#D#")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.AMETHYST_HAMMER.get())
                .pattern("#D#")
                .pattern("#S#")
                .pattern(" S ")
                .define('#', Items.AMETHYST_SHARD)
                .define('S', Items.STICK)
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.TOOLS,
                        ModItems.METAL_DETECTOR.get())
                .pattern("  i")
                .pattern("SRS")
                .pattern("iii")
                .define('i', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);
    }

    protected static void oreSmelting(
            @NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            @NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, GodBlocks.MOD_ID + ':' + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
