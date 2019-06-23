package ch.hslu.ad.concurreny;

import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoinDemo
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final SimpleForkJoinTask rootTask = new SimpleForkJoinTask();
        forkJoinPool.invoke(rootTask);

        // or with a common pool
        rootTask.invoke();
    }
}