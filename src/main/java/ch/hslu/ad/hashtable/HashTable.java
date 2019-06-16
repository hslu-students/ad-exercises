package ch.hslu.ad.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * HashTable
 */
public class HashTable<T> {

    private int size;
    private List<T>[] table; 
    private int count;

    public HashTable() {
        this(10); // default size is 10
    }

    public HashTable(int size) {
        this.size = size;
        table = (ArrayList<T>[])new ArrayList[size];
    }

    public void add(T element) {
        int hash = getHash(element);
        if (table[hash] == null) {
            table[hash] = new ArrayList<T>() {{
                add(element);
            }};
        } else {
            // hash collision
            table[hash].add(element);
        }
        this.count++;
    }

    public void remove(T element) {
        int hash = getHash(element);
        if (table[hash] == null) {
            // nothing to do
            return;
        }
        table[hash].remove(element);
        this.count--;
    }

    public int count() {
        return this.count;
    }

    private int getHash(T element) {
        return element.hashCode() % size;
    }
}