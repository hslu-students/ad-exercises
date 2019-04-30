package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class ParallelFibonacciTest {

    @Test
    void testParallelFibonacciWith5() {
        final var fibonacciComputer = new ParallelFibonacci(5);
        final var result = fibonacciComputer.invoke();
        assertTrue(result == 5);
    }

    @Test
    void testParallelFibonacciWith14() {
        final var fibonacciComputer = new ParallelFibonacci(14);
        final var result = fibonacciComputer.invoke();
        assertTrue(result == 377);
    }
}