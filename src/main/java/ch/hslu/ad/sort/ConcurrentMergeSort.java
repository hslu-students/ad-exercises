package ch.hslu.ad.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * MergeSort
 */
public class ConcurrentMergeSort<T extends Comparable<T>> extends RecursiveTask<List<T>> {

    private List<T> list;

    public ConcurrentMergeSort(List<T> list) {
        this.list = list;
    }

    @Override
    protected List<T> compute() {

        if (list.size() < 2) {
            return this.list;
        }

        int center = list.size() / 2;
        List<T> left = new ArrayList<T>(list.subList(0, center));
        List<T> right = new ArrayList<T>(list.subList(center, list.size()));

        final var leftTask = new ConcurrentMergeSort<T>(left);
        final var rightTask = new ConcurrentMergeSort<T>(right);

        invokeAll(leftTask, rightTask);

        try {
            return merge(leftTask.get(), rightTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<T>();
        }
	}

    private List<T> merge(List<T> left, List<T> right) {
        List<T> list = new ArrayList<T>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
          if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
            list.add(left.get(leftIndex++));
          } else {
            list.add(right.get(rightIndex++));
          }
        }
        list.addAll(left.subList(leftIndex, left.size()));
        list.addAll(right.subList(rightIndex, right.size()));

        return list;
    }
}