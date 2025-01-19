package net.plasma.sack_of_chaos.Util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ModScheduler {
    private final Map<Integer, Runnable> tasks = new HashMap<>();
    private int currentTick = 0;

    public void schedule(int delay, Runnable task) {
        tasks.put(currentTick + delay, task);
    }

    public void tick() {
        currentTick++;
        Iterator<Map.Entry<Integer, Runnable>> iterator = tasks.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Runnable> entry = iterator.next();
            if (entry.getKey() <= currentTick) {
                entry.getValue().run();
                iterator.remove();
            }
        }
    }
}
