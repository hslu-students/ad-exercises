package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class StackTest {

    @Test
    void testStackInitialization() {
        final Stack stack = new Stack(2);
        assertTrue(stack.pop() == null);
    }

    @Test
    void testStackPush() {
        final Stack stack = new Stack(2);
        stack.push("HOOI");
        assertTrue(stack.size() == 1);
    }

    @Test
    void testStackPop() {
        final Stack stack = new Stack(2);
        stack.push("HOOI");
        final String element = stack.pop();
        assertTrue(stack.size() == 0);
        assertTrue(element == "HOOI");
    }

    @Test
    void testStackFull() {
        final Stack stack = new Stack(1);
        stack.push("HOOI");
        assertTrue(stack.isFull());
    }

    @Test
    void testStackMessage() {
      final Stack stack = new Stack(3);
      stack.push("toll");
      stack.push("sind");
      stack.push("Datenstrukturen");
      assertTrue(stack.pop() == "Datenstrukturen");
      assertTrue(stack.pop() == "sind");
      assertTrue(stack.pop() == "toll");
    }
}
