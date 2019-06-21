package ch.hslu.ad.sort;

import java.util.Arrays;
import java.util.List;

/**
 * SortDemo
 */
public class SortDemo {

    public static void main(String[] args) {

        Arrays.asList(
            new InsertSort<Integer>(),
            new BubbleSort<Integer>(),
            new QuickSort<Integer>()
        ).forEach((sort) -> {

            long start = System.currentTimeMillis();

            System.out.printf("SORT USING [%s]", sort.getClass());
            System.out.println(sort.sort(
                Arrays.asList(1,3,4,9,0,2,7,8,5,6)
            ));

            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Time needed: " + elapsed + "ms");
        });

    }
}