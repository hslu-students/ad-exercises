package ch.hslu.ad.search;

/**
 * OptimisedSearch
 */
public class OptimisedSearch implements Search {

    private static int[] initNext(final String p) {

        final int length = p.length();
        final int[] next = new int[length];

        int i = 0;
        int j = -1;
        next[0] = -1;

        // special value! (-1 = no reference to a following state)
        do {
            if ((j == -1) || (p.charAt(i) == p.charAt(j))) {
                // (j == -1) must be first operand!
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (length - 1));
        return next;
    }

    @Override
    public int search(String text, String pattern) {

        final int n = text.length();
        final int m = pattern.length();
        int i = 0; // index to string a
        int j = 0; // index to pattern p respectively state

        // 1. generate next
        final int[] next = initNext(pattern);
        // 2. search for p
        do {
            if ((j == -1) || (text.charAt(i) == pattern.charAt(j))) {
                i++; // process next character
                j++;
            } else {
                j = next[j]; // go to next state
            }
        } while ((j < m) && (i < n));

        if (j == m) {
            return (i - m);
        } else {
            return -1;
        }
    }
}