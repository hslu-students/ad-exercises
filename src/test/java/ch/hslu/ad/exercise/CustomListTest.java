package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.hslu.ad.exercise.e0.Allocation;


class CustomListTest {

    @Test
    void testListInitialization() {
        CustomList list = new CustomList();
        assertTrue(list != null);
    }

    @Test
    void testAddingOfElement() {
        CustomList list = new CustomList();
        list.add(new Allocation(0, 0));
        assertTrue(list.size() == 1);
    }

    @Test
    void testAddingOfTwoElements() {
        CustomList list = new CustomList();
        list.add(new Allocation(0, 0));
        list.add(new Allocation(0, 0));
        assertTrue(list.size() == 2);
    }

    @Test
    void testIterationCount() {
        CustomList list = new CustomList();
        list.add(new Allocation(0, 0));
        list.add(new Allocation(0, 0));
        int size = 0;
        for (Object o : list) {
            size++;
        }
        assertTrue(size == 2);
    }

    @Test
    void testIterationElements() {
        CustomList list = new CustomList();
        var o0 = new Allocation(0, 0);
        var o1 = new Allocation(1, 0);
        list.add(o0);
        list.add(o1);
        int count = 0;
        for (Object o : list) {
            if (count == 0) {
                assertEquals(o1, o);
            }
            if (count == 1) {
                assertEquals(o0, o);
            }
            count++;
        }
        assertTrue(count == 2);
    }
}
