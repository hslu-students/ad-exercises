package ch.hslu.ad.search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.hslu.ad.exercise.search.ANANASSearchState;
import ch.hslu.ad.exercise.search.OptimizedSearch;


class OptimizedSearchTest {

    @Test
    void testSearchANANAS() {
        final boolean found = OptimizedSearch.search("ANANAS", ANANASSearchState.Start);
        assertTrue(found);
    }

    @Test
    void testSearchANANASNotFound() {
        final boolean found = OptimizedSearch.search("BANANA", ANANASSearchState.Start);
        assertTrue(!found);
    }

    @Test
    void testSearchANANASLongString() {
        final boolean found = OptimizedSearch.search("NANANANANANANANANAS BATMAAAAN!!", ANANASSearchState.Start);
        assertTrue(found);
    }

    @Test
    void testSearchANANASPadding() {
        final boolean found = OptimizedSearch.search("ASDFANANASASDF", ANANASSearchState.Start);
        assertTrue(found);
    }

    @Test
    void testSearchANANASPaddingAN() {
        final boolean found = OptimizedSearch.search("ANANANAS", ANANASSearchState.Start);
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
    void testQuickSearchYxx() {
        final int found = OptimizedSearch.quickSearch(
            "yxx",
            "you"
        );
        assertTrue(found == -1);
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
