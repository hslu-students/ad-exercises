package ch.hslu.ad.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * BubbleSort
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list) {
        IntStream.range(0, (list.size() - 1))
            .forEach((i) -> {

                IntStream.range(0, (list.size() - (i + 1)))
                    .forEach((j) -> {

                        if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                            Collections.swap(list, j, j + 1);
                        }

                    });

            });
        return list;
    }


}