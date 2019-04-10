package ch.hslu.ad.sw07.ex01;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BlockingQueueTest {

    private static final int CAPACITY = 1_000_000;

    private static Queue<String> queue;

    @BeforeAll
    public static void initQueue() {
        queue = new ArrayBlockingQueue<>(CAPACITY);
    }

    @Test
    public void testMultipleProducersAndConsumers() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final int nProducers = 10;
        final int nConsumers = 10;
        int p = nProducers;
        int c = nConsumers;
        // make sure to mix producers and consumers
        while (p > 0 || c > 0) {
            if (p > 0) {
                final int producerNumber = nProducers - p;
                int toProducce = CAPACITY / nProducers;
                executor.submit(createProducer(toProducce, producerNumber));
                p--;
            }
            if (c > 0) {
                int toConsume = CAPACITY / nConsumers;
                executor.submit(createConsumer(toConsume));
                c--;
            }
        }
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    private Runnable createProducer(int itemsToProduce, int producerNumber) {
        return () -> {
            for (int n = 0; n < itemsToProduce; n++) {
                queue.add(producerNumber + "String" + n);
            }
        };
    }

    private Runnable createConsumer(int itemsToConsume) {
        return () -> {
            int n = itemsToConsume;
            while (n > 0) {
                String str = queue.poll();
                if (str != null) {
                    assertNotNull(str);
                    n--;
                }
            }
        };
    }
}
