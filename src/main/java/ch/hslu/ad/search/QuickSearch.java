package ch.hslu.ad.search;

/**
 * QuickSearch
 */
public class QuickSearch implements Search {

    @Override
    public int search(String text, String pattern) {

        final int textLength = text.length();
        final int patternLength = pattern.length();
        final int range = 256; // -> ASCII-Range

        final int[] shift = new int[range];
        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = patternLength + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < patternLength; i++) {
            shift[pattern.charAt(i)] = patternLength - i;
        }

        int i = 0; // index to string
        int j = 0; // index to pattern p

        do {
            if (text.charAt(i + j) == pattern.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + patternLength) < textLength) { // a.charAt(i1+m) is not outside a
                    i += shift[text.charAt(i + patternLength)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < patternLength) && ((i + patternLength) <= textLength));

        // (pattern p not found) && (end of a not reached)
        if (j == patternLength) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }
}