package ch.hslu.ad.concurreny;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

/**
 * ExecutorsDemo
 */
public class ExecutorsDemo {

    private static Executor exc;

    public static void main(String[] args) {

        final var task = new FutureTask<Integer>(() -> {
            return 1 + 1;
        });
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // caches threads for 60 seconds
        exc = Executors.newCachedThreadPool();

        // holds n number of threads all the time
        exc = Executors.newFixedThreadPool(1);

        // holds 1 thread
        exc = Executors.newSingleThreadExecutor();

        // executes reoccuring tasks
        exc = Executors.newScheduledThreadPool(1);

        executorPlayground();
        // customThreadFactory();
        // fixedSizedTest();
    }

    private static void executorPlayground() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            System.out.println("Bli blah blub");
        });

        Future<Integer> future = executor.submit(() -> {
            return 1 + 1;
        });
        try {
            System.out.println("Got future:" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Runnable task = () -> {
            // broken code, throws an exception
            System.out.println("Do the math: " + (1 / 0));
        };

        try {
            // will throw an exception (NOT immediately dough!!)
            // this try catch does nothing ... because it is concurent
            executor.execute(task);
        } catch (ArithmeticException e) {
            System.out.println("Failed to execute(task)");
        }

        // will not throw an exceptoin
        Future<?> result = executor.submit(task);
        try {
            // now the exception will be thrown (wrapped in an ExecutionExceptoin)
            result.get();
        } catch (InterruptedException | ExecutionException e) {
             System.out.println("Failed to submit(task).get()");
        }

        executor.shutdown();
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