package ch.hslu.ad.sw07.ex03;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;;
import org.junit.jupiter.api.Test;;

public class CounterComparison {

    private static final int TASKS_PER_COUNTER = 10;
    private static final int DURATION_IN_SECS = 5;

    private int init;

    private Counter atomicCounter;
    private Counter synchronizedCounter;

    @BeforeAll
    public void init() {
        Random random = new Random(System.currentTimeMillis());
        init = random.nextInt(Integer.MAX_VALUE);
        atomicCounter = new AtomicCounter(init);
        synchronizedCounter = new SynchronizedCounter(init);
    }

    @Test
    public void testInit() {
        assertEquals(init, atomicCounter.get());
        assertEquals(init, synchronizedCounter.get());
    }

    @Test
    public void testIncrement() {
        ExecutorService counting = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int n = 0; n < TASKS_PER_COUNTER; n++) {
            counting.submit(() -> {
                while (true) {
                    atomicCounter.increment();
                }
            });
            counting.submit(() -> {
                while (true) {
                    synchronizedCounter.increment();
                }
            });
        }
        try {
            counting.awaitTermination(DURATION_IN_SECS, TimeUnit.SECONDS);
            System.out.println(String.format("%10d (init testIncrement())", init));
            assertTrue(atomicCounter.get() > init);
            assertTrue(synchronizedCounter.get() > init);
            assertTrue(atomicCounter.get() > synchronizedCounter.get());
            System.out.println(String.format("%10d (atomic)", atomicCounter.get()));
            System.out.println(String.format("%10d (synchronized)", synchronizedCounter.get()));
            float ratio = (float) atomicCounter.get() / synchronizedCounter.get();
            System.out.println(String.format("%.2f ratio (atomic/synchronized)", ratio));
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIncIncDec() {
        ExecutorService counting = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int n = 0; n < TASKS_PER_COUNTER; n++) {
            counting.submit(() -> {
                while (true) {
                    atomicCounter.increment();
                    atomicCounter.increment();
                    atomicCounter.decrement();
                }
            });
            counting.submit(() -> {
                while (true) {
                    synchronizedCounter.increment();
                    synchronizedCounter.increment();
                    synchronizedCounter.decrement();
                }
            });
        }
        try {
            counting.awaitTermination(DURATION_IN_SECS, TimeUnit.SECONDS);
            System.out.println(String.format("%10d (init testIncIncDec())", init));
            assertTrue(atomicCounter.get() > init);
            assertTrue(synchronizedCounter.get() > init);
            assertTrue(atomicCounter.get() > synchronizedCounter.get());
            System.out.println(String.format("%10d (atomic)", atomicCounter.get()));
            System.out.println(String.format("%10d (synchronized)", synchronizedCounter.get()));
            float ratio = (float) atomicCounter.get() / synchronizedCounter.get();
            System.out.println(String.format("%.2f ratio (atomic/synchronized)", ratio));
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }
}
