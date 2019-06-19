package ch.hslu.ad.concurreny;

/**
 * Semaphore
 */
public class Semaphore {

    private int count = 0;

    public Semaphore(final int init) {
        this.count = init;
    }

    public synchronized void acquire() throws InterruptedException {
        while (count == 0) {
            this.wait();
        }
        count--;
    }

    public synchronized void release() throws InterruptedException {
        count++;
        this.notifyAll();
    }
}