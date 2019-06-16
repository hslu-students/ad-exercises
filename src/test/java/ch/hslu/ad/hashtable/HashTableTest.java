package ch.hslu.ad.hashtable;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * HashTableTest
 */
public class HashTableTest {

    @Test
    public void testHashTableAdd() {
        final var table = new HashTable<Integer>();

        table.add(1);
        table.add(11); // collision -> 11 = 1 mod 10

        assertTrue(table.count() == 2);
    }

    @Test
    public void testHashTableRemove() {
        final var table = new HashTable<Integer>();

        table.add(1);
        table.add(11);

        table.remove(1);
        table.remove(2); // nonexistent
        table.remove(11); // collision -> 11 = 1 mod 10

        assertTrue(table.count() == 0);
    }
}