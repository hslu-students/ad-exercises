package ch.hslu.ad.search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.hslu.ad.exercise.search.OptimizedSearch;


class OptimizedSearchTest {

    @Test
    void testSearch() {
        final boolean found = OptimizedSearch.search("ANANAS");
        assertTrue(found);
    }
}
