package ch.hslu.ad.concurreny;

import java.util.ArrayDeque;

/**
 * RoundedBuffer
 */
public class RoundedBuffer<T> {

    private final ArrayDeque<T> queue;
    private final Semaphore putLock;
    private final Semaphore getLock;

    public RoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putLock = new Semaphore(n);
        getLock = new Semaphore(0);
    }

    public void put(T element) throws InterruptedException {
        putLock.acquire();
        synchronized (queue) {
            queue.push(element);
        }
        getLock.release();
    }

    public T get() throws InterruptedException {
        getLock.acquire();
        T element;
        synchronized (queue) {
            element = queue.poll();
        }
        putLock.release();
        return element;
    }

}