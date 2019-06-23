package ch.hslu.ad.concurreny;

import java.util.concurrent.RecursiveAction;

/**
 * SimpleForkJoinTask
 */
public class SimpleForkJoinTask extends RecursiveAction {

    @Override
    protected void compute() {
        final var task1 = new SimpleForkJoinTask();
        final var task2 = new SimpleForkJoinTask();
        final var task3 = new SimpleForkJoinTask();

        invokeAll(task1, task2, task3);
    }
}