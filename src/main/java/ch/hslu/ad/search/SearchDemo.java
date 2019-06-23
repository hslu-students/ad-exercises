package ch.hslu.ad.search;

import java.util.Arrays;

/**
 * SearchDemo
 */
public class SearchDemo {

    public static void main(String[] args) {

        Arrays.asList(
            new OptimisedSearch()
        ).forEach((search) -> {
            long start = System.currentTimeMillis();

            System.out.printf("SEARCH USING [%s]", search.getClass());
            System.out.println(search.search(
                "I am searching for you!! What is this1",
                "you"
            ));

            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Time needed: " + elapsed + "ms");
        });

    }
}