package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class StackTest {

    @Test
    void testStackInitialization() {
        final Stack stack = new Stack();
        assertTrue(stack.pop() == null);
    }
}
