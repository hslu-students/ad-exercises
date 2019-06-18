package ch.hslu.ad.concurreny;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public final class BlackHole {
    private final BlockingQueue<String> queue;

    public BlackHole() {
        queue = new LinkedBlockingDeque<>();
    }
    public synchronized void put(final String thing) {
        queue.add(thing);
    }
    public synchronized String get() throws InterruptedException {
        return queue.take();
    }
}