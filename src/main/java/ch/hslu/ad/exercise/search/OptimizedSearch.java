package ch.hslu.ad.exercise.search;


public class OptimizedSearch {
    public static boolean search(final String text) {
        ANANASSearchState state = ANANASSearchState.Z0;
        for(char c : text.toCharArray()) {
            state = state.next(c);
            if (state == ANANASSearchState.Z6) {
                return true;
            }
        }
        return false;
    }

    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];
        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n));
        // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }
}
