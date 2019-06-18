package ch.hslu.ad.concurrency;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * TestRunnable
 */
public class TestRunnable {

    @Test
    public void testRunnable() {
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println("Hello from the paralell world");
            System.out.println(Thread.currentThread().getName());
        }).start();

        assertTrue(true);
    }
}