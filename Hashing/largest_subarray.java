package Hashing;

import java.util.*;

public class largest_subarray {
    // we are finding largest sub array with sum equals to zero

    public static void main(String[] args) { //O(n)
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        HashMap<Integer, Integer> map = new HashMap<>();
        // map(sum,idx)
        int sum = 0;
        int len = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = j - map.get(sum);
            } else {
                map.put(sum, j);
            }
        }
        System.out.println(len);
    }
}
