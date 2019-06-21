package ch.hslu.ad.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * MergeSort
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list) {
        return mergeSort(list);
    }

    private List<T> mergeSort(List<T> list) {

        if (list.size() < 2) {
            return list;
        }

        int center = list.size() / 2;
        List<T> left = new ArrayList<T>(list.subList(0, center));
        List<T> right = new ArrayList<T>(list.subList(center, list.size()));

        return merge(
            mergeSort(left),
            mergeSort(right)
        );
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