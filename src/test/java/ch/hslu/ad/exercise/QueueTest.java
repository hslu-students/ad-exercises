package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class QueueTest {

    @Test
    void testQueueInitialization() {
        final Queue queue = new Queue();
        assertTrue(queue.get() == ' ');
    }

    @Test
    void testQueue() {
        final Queue queue = new Queue();
        queue.put('h');
        queue.put('o');
        queue.put('o');
        queue.put('i');
        assertTrue(queue.get() == 'h');
        assertTrue(queue.get() == 'o');
        assertTrue(queue.get() == 'o');
        assertTrue(queue.get() == 'i');
        assertTrue(queue.get() == ' ');
    }

    @Test
    void testQueuePrint() {
        final Queue queue = new Queue();
        queue.put('h');
        queue.put('o');
        queue.put('o');
        queue.put('i');
        queue.toString();
        assertTrue(queue.get() == 'h');
    }
}
