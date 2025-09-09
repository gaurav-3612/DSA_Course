package GreedyAlgorithms;

import java.util.*;

public class ActivityUnsorted {

    public static void main(String args[]) {
        int start[] = {5, 0, 3, 1, 8, 5};
        int end[] = {7, 6, 4, 2, 9, 9};
        int arr[][] = new int[start.length][3];
        ArrayList<Integer> act = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            arr[i][0] = i;
            arr[i][1] = start[i];
            arr[i][2] = end[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));
        int maxAct = 1;
        int endLast = arr[0][2];
        act.add(arr[0][0]);
        for (int i = 1; i < start.length; i++) {
            if (arr[i][1] >= endLast) {
                maxAct++;
                act.add(arr[i][0]);
                endLast = arr[i][2];
            }
        }
        System.out.println(maxAct);
        for (int i = 0; i < act.size(); i++) {
            System.out.print(act.get(i) + " ");
        }
    }
}
