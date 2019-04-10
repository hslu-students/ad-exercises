package ch.hslu.ad.sw07.ex03;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.BeforeAll;;
import org.junit.jupiter.api.Test;;

public class ProofUnsafeCounterBroken {

    private static final int TASKS_PER_COUNTER = 10;
    private static final int DURATION_IN_SECS = 5;

    private Counter unsynchronizedCounter;

    private int init;
    private long increments = 0;

    @BeforeAll
    public void init() {
        Random random = new Random(System.currentTimeMillis());
        init = random.nextInt(Integer.MAX_VALUE);
        unsynchronizedCounter = new UnsynchronizedCounter(init);
    }

    @Test
    public void testOneThread() {
        Thread counter = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                unsynchronizedCounter.increment();
                increments++;
            }
        });
        counter.start();
        try {
            Thread.sleep(DURATION_IN_SECS * 1_000);
            counter.interrupt();
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
        assertEquals(init + increments, unsynchronizedCounter.get());
    }

    @Test
    public void testBreakUnsynchronizedCounter() {
        ExecutorService counter = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int n = 0; n < TASKS_PER_COUNTER; n++) {
            counter.submit(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    unsynchronizedCounter.increment();
                    increments++;
                }
            });
        }
        counter.shutdownNow();
        System.out.println(String.format("%10d init", init));
        System.out.println(String.format("%10d increments", increments));
        System.out.println(String.format("%10d expected", init + increments));
        System.out.println(String.format("%10d but was", unsynchronizedCounter.get()));

        assertNotEquals(init + increments, unsynchronizedCounter.get());
    }

}
