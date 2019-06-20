package ch.hslu.ad.sort;

import java.util.List;

/**
 * Sort
 */
public interface Sort<T extends Comparable<T>> {

    public List<T> sort(List<T> list);

}