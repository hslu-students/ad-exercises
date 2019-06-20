package ch.hslu.ad.concurreny;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

/**
 * ExecutorsDemo
 */
public class ExecutorsDemo {

    private static Executor exc;

    public static void main(String[] args) {

        // caches threads for 60 seconds
        exc = Executors.newCachedThreadPool();

        // holds n number of threads all the time
        exc = Executors.newFixedThreadPool(1);

        // holds 1 thread
        exc = Executors.newSingleThreadExecutor();

        // executes reoccuring tasks
        exc = Executors.newScheduledThreadPool(1);

        customThreadFactory();
        //fixedSizedTest();
    }

    private static void customThreadFactory() {
        ExecutorService executor = Executors.newFixedThreadPool(2, new ThreadFactory(){

            @Override
            public Thread newThread(Runnable r) {
                final var t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        executor.submit(() -> {
            String thread = Thread.currentThread().getName();
            System.out.println("HELLO!! " + thread);
        });
        executor.submit(() -> {
            String thread = Thread.currentThread().getName();
            System.out.println("its me!!" + thread);
        });
        executor.submit(() -> {
            String thread = Thread.currentThread().getName();
            System.out.println("its me!!" + thread);
        });
    }

    public static void fixedSizedTest() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 20)
            .forEach((i) -> {
                executor.execute(() -> {
                    String thread = Thread.currentThread().getName();
                    IntStream.range(0, 20)
                        .forEach((j) -> {
                            System.out.println("Thread: " + thread + ", Number: " + j);
                        });
                });
            });
        executor.shutdown();
    }
}