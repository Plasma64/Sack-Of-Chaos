package net.plasma.sack_of_chaos.Events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;

public class CommonEvents {

    @SubscribeEvent
    public void onPlayerDeath(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.getEntity().level().isClientSide && event.getEntity() instanceof ServerPlayer player) {
            Optional<GlobalPos> optionalDeathPos = player.getLastDeathLocation();
            if (optionalDeathPos.isPresent()) {
                GlobalPos globalPos = optionalDeathPos.get();
                BlockPos deathPos = globalPos.pos();

                CompoundTag deathPosTag = new CompoundTag();
                deathPosTag.putInt("x", deathPos.getX());
                deathPosTag.putInt("y", deathPos.getY());
                deathPosTag.putInt("z", deathPos.getZ());
                player.getPersistentData().put("lastDeathPos", deathPosTag);
            }
        }
    }
}