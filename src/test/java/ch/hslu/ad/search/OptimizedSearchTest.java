package ch.hslu.ad.search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.hslu.ad.exercise.search.OptimizedSearch;


class OptimizedSearchTest {

    @Test
    void testSearch() {
        final boolean found = OptimizedSearch.search("ANANAS");
        assertTrue(found);
    }

    @Test
    void testQuickSearch() {
        final int found = OptimizedSearch.quickSearch(
            "I am searching for you!!",
            "you"
        );
        assertTrue(found == 19);
    }

    @Test
    void testQuickSearchNotFound() {
        final int found = OptimizedSearch.quickSearch(
            "Who am I searching for?!!",
            "you"
        );
        assertTrue(found == -1);
    }
}
