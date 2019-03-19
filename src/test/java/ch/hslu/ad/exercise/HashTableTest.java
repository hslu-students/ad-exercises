package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HashTableTest {

  @Test
  void testHashTableCreation() {
    final var table = new HashTable();
    assertTrue(table != null);
  }

  @Test
  void testHashTableInsertion() {
    final var table = new HashTable();
    table.add(1);
    table.add(4);
    try {
      final var field = table.getClass().getDeclaredField("table");
      field.setAccessible(true);
      Integer[] array = (Integer[])field.get(table);
      assertTrue(array[1] == 1);
      assertTrue(array[4] == 4);
    } catch(Exception e) {
      assertTrue(false);
    }

    assertTrue(table != null);
  }

  @Test
  void testHashTableSearch() {
    final var table = new HashTable();

    table.add(5);

    assertTrue(table.search(5));
    assertFalse(table.search(4));
  }

  @Test
  void testHashAddCollision() {
    final var table = new HashTable();

    table.add(5);
    assertThrows(IllegalArgumentException.class, () -> {
      table.add(5);
    });
  }
}
