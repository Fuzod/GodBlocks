package net.ohl.godblocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.ohl.godblocks.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GodBlock extends Block {
    private static final Map<Integer, List<ItemStack>> GODBLOCK_T1_LOOT = Map.of(
            60, List.of(
                    new ItemStack(Items.STICK),
                    new ItemStack(Items.IRON_INGOT),
                    new ItemStack(Items.APPLE),
                    new ItemStack(Items.FLINT_AND_STEEL)
            ),
            100, List.of(
                    new ItemStack(Items.NETHERITE_SWORD)
//                    new ItemStack(ModItems.STRAWBERRY_SEEDS.get())
            )
    );
    public GodBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_BANJO.get(), SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void playerDestroy(@NotNull Level pLevel, Player pPlayer, @NotNull BlockPos pPos, @NotNull BlockState pState, @Nullable BlockEntity pBlockEntity, @NotNull ItemStack pTool) {
        pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
        pPlayer.causeFoodExhaustion(0.005F);
        Random random = new Random();
        int randomNum = random.ints(1, 100)
                .findFirst()
                .getAsInt();

        int closestKey = findClosestKey(
                GODBLOCK_T1_LOOT.keySet().stream()
                        .sorted()
                        .collect(Collectors.toList()),
                randomNum
        );

        pPlayer.sendSystemMessage(Component.literal("Random: " + randomNum + "Rounded to: " + closestKey));

        GODBLOCK_T1_LOOT.get(closestKey).forEach(itemStack -> popResource(pLevel, pPos, itemStack));
    }

    private static int findClosestKey(List<Integer> sortedKeys, int target) {
        int closestKey = sortedKeys.getFirst();
        int minDifference = Math.abs(target - closestKey);

        for (int key : sortedKeys) {
            int difference = Math.abs(target - key);
            if (difference < minDifference) {
                minDifference = difference;
                closestKey = key;
            }
        }

        return closestKey;
    }
}