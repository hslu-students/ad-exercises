package ch.hslu.ad.sort;

import java.util.Collections;
import java.util.List;

/**
 * QuickSort
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> list) {
        return sort(list, 0, (list.size() - 1));

    }

    private List<T> sort(List<T> list, int start, int end) {

        int left = start;
        int right = end - 1;

        // take last element as devider element
        T devider = list.get(end);
        boolean done = false;

        do {

            // search bigger element from the left
            while (list.get(left).compareTo(devider) < 0) {
                left++;
            }

            while ((list.get(right).compareTo(devider) >= 0) && (right > left)) {
                right--;
            }

            if (right > left) {
                Collections.swap(list, left, right);
                left++;
                right--;

            } else {
                done = true;
            }

        } while (right > left);

        // swap devider to final position
        Collections.swap(list, left, end);

        if (start < (right - 1)) {
            sort(list, start, (right - 1));
        }
        if ((left + 1) < end) {
            sort(list, (left + 1), end);
        }

        return list;
    }

}