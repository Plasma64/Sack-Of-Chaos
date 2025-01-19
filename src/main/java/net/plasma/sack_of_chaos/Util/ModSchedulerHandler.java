package net.plasma.sack_of_chaos.Util;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModSchedulerHandler {
    private static final ModScheduler scheduler = new ModScheduler();

    public static ModScheduler getScheduler() {
        return scheduler;
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            scheduler.tick();
        }
    }
}