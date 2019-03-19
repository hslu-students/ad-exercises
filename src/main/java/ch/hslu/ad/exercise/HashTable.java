package ch.hslu.ad.exercise;

public class HashTable {
  private Integer length = 10;
  private Integer size = 0;
  private Integer[] table = new Integer[length];

  /**
   * Adds a new element to the hashtable
   */
  public void add(int value) {
    if (table[getIndex(value)] != null) {
      throw new IllegalArgumentException("Entry in hashtable already exists");
    }
    table[getIndex(value)] = value;
    size++;
  }

  /**
   * Removes an element from the hashtable
   */
  public void remove(int value) {
    table[getIndex(value)] = null;
    size--;
  }

  /**
   * Searches an element in the hashtable
   */
  public boolean search(int value) {
    return table[getIndex(value)] != null && table[getIndex(value)] == value;
  }

  public int getSize() {
    return this.size;
  }

  private int getIndex(int value) {
    return value % length;
  }
}