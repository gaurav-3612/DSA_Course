package GreedyAlgorithms;

import java.util.*;

public class minimumDiffPairs {

    public static void main(String[] args) {
        int pair1[] = {1, 2, 3};
        int pair2[] = {2, 3, 1};
        Arrays.sort(pair1);
        Arrays.sort(pair2);
        int diff = 0;
        for (int i = 0; i < pair1.length; i++) {
            diff += Math.abs(pair1[i] - pair2[i]);
        }
        System.out.println(diff);
    }
}
