package ch.hslu.ad.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * InsertSort
 */
public class InsertSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list) {
        IntStream.range(0, list.size())
            .forEach((i) -> {
                int swap = i;
                T element = list.get(i);
                while ((swap > 0) && (element.compareTo(list.get(swap - 1)) < 0)) {
                    Collections.swap(list, (swap - 1), swap);
                    swap--;
                }
            });
        return list;
    }
}