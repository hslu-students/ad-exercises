package ch.hslu.ad.sort;

import java.util.Arrays;
import java.util.List;

/**
 * SortDemo
 */
public class SortDemo {

    public static void main(String[] args) {

        final Sort<Integer> sort = new InsertSort<>();
        List<Integer> data = Arrays.asList(1,3,4,6,0,2,7,8,5,9);
        data = sort.sort(data);
        System.out.println(data);

    }
}