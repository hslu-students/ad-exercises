package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class QuickSortTest {

    @Test
    void testQuickSort() {
        var a = new char[] {
            'c', 'f', 'e', 'g', 's', 'd', 'f'
        };
        final QuickSort sort = new QuickSort();
        System.out.println(a);
        sort.quickSort(a, 0, (a.length - 1));
        System.out.println(a);
        assertTrue(true);
    }
}
