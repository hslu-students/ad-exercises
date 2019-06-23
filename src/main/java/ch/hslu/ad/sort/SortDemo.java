package ch.hslu.ad.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.concurreny.ForkJoinDemo;

/**
 * SortDemo
 */
public class SortDemo {

    public static void main(String[] args) {

        Arrays.asList(
            new InsertSort<Integer>(),
            new BubbleSort<Integer>(),
            new QuickSort<Integer>(),
            new MergeSort<Integer>()
        ).forEach((sort) -> {

            long start = System.currentTimeMillis();

            System.out.printf("SORT USING [%s]", sort.getClass());
            System.out.println(sort.sort(
                Arrays.asList(1,3,4,9,0,2,7,8,5,6)
            ));

            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Time needed: " + elapsed + "ms");
        });

        // concurrent deomo
        final ForkJoinPool pool = new ForkJoinPool();
        final ConcurrentMergeSort<Integer> task = new ConcurrentMergeSort<Integer>(
            Arrays.asList(1,3,4,9,0,2,7,8,5,6)
        );
        pool.execute(task);
        System.out.printf("SORT USING [class ch.hslu.ad.sort.ConcurentMergeSort]");
        try {
			System.out.println(task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
        }
        pool.shutdown();
    }
}