package ArrayList;

import java.util.*;

class MergeInterval {

    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        ArrayList<int[]> a = new ArrayList<>();

        // Sort intervals by start time
        Arrays.sort(arr, (x, y) -> Integer.compare(x[0], y[0]));

        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end) {
                // Overlapping → merge
                end = Math.max(end, arr[i][1]);
            } else {
                // Non-overlapping → add previous interval
                a.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        // Add last interval
        a.add(new int[]{start, end});

        return a;
    }
}
