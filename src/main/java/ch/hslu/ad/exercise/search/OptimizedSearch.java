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
}
