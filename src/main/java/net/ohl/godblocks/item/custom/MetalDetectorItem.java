package net.ohl.godblocks.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.ohl.godblocks.sound.ModSounds;
import net.ohl.godblocks.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (! pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if (isValuableBlock(state)) {
                    outputValuableCoordinate(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    pContext.getLevel().playSeededSound(null, positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                            ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.BLOCKS, 1f, 1f, 0);
                    break;
                }
            }
            if (! foundBlock) {
                assert player != null;
                player.sendSystemMessage(Component.literal("Nothing found"));
            }
        }
        pContext.getItemInHand().hurtAndBreak(
                1,
                Objects.requireNonNull(pContext.getPlayer()),
                LivingEntity.getSlotForHand(pContext.getHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinate(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(
                Component.literal(
                        "Found " + I18n.get(block.getDescriptionId()) +
                                " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + blockPos.getZ() + ")"
                ));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
