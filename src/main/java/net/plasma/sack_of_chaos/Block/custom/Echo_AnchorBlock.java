package net.plasma.sack_of_chaos.Block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.plasma.sack_of_chaos.Util.ModSchedulerHandler;

public class Echo_AnchorBlock extends Block {
    public Echo_AnchorBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND) {
            ItemStack itemStack = pPlayer.getItemInHand(pHand);

            if (itemStack.getItem() == Items.ECHO_SHARD && !pPlayer.isCreative() && pPlayer instanceof ServerPlayer player) {
                CompoundTag persistentData = player.getPersistentData();
                if (persistentData.contains("lastDeathPos")) {
                    CompoundTag deathPosTag = persistentData.getCompound("lastDeathPos");

                    if (deathPosTag.contains("x") && deathPosTag.contains("y") && deathPosTag.contains("z")) {
                        int x = deathPosTag.getInt("x");
                        int y = deathPosTag.getInt("y");
                        int z = deathPosTag.getInt("z");

                        if (pPlayer.getCooldowns().isOnCooldown(Items.ECHO_SHARD)) {
                            return InteractionResult.FAIL;
                        } else {
                            pPlayer.getCooldowns().addCooldown(Items.ECHO_SHARD, 200);
                            pLevel.playSound(null, pPos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 5.0f, 1.0f);
                            itemStack.shrink(1);
                            ModSchedulerHandler.getScheduler().schedule(100, () -> {
                                if (player.isAlive()) {
                                    player.teleportTo(x, y, z);
                                    pLevel.playSound(null, pPos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 5.0f, 1.0f);
                                }
                            });
                            return InteractionResult.SUCCESS;

                        }
                    }
                }
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}