package net.ohl.godblocks.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

public class AmethystStaffItem extends Item {
    private static final Map<Block, Block> TRANSMUTATION_MAP = Map.of(
            Blocks.DIRT, Blocks.STONE,
            Blocks.GRASS_BLOCK, Blocks.STONE,
            Blocks.STONE, Blocks.COAL_ORE,
            Blocks.COAL_ORE, Blocks.IRON_ORE,
            Blocks.IRON_ORE, Blocks.GOLD_ORE,
            Blocks.GOLD_BLOCK, Blocks.DIAMOND_ORE,
            Blocks.DIAMOND_BLOCK, Blocks.ANCIENT_DEBRIS
    );

    public AmethystStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlocked = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (TRANSMUTATION_MAP.containsKey(clickedBlocked) && !level.isClientSide()) {
            Player player = pContext.getPlayer();
            assert player != null;
            Inventory inventory = player.getInventory();
            int amethystItemSlot = inventory.findSlotMatchingItem(Items.AMETHYST_SHARD.getDefaultInstance());

            if (amethystItemSlot >= 0) {
                inventory.getItem(amethystItemSlot).consume(1, player);

                level.setBlockAndUpdate(pContext.getClickedPos(), TRANSMUTATION_MAP.get(clickedBlocked).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) player),
                        item -> Objects.requireNonNull(player).onEquippedItemBroken(item, EquipmentSlot.MAINHAND)
                );
                level.playSound(null, pContext.getClickedPos(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS);
            }
            else {
                player.sendSystemMessage(Component.literal("Missing Amethyst"));
                level.playSound(null, pContext.getClickedPos(), SoundEvents.ITEM_BREAK, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
