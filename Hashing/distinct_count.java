package Hashing;

import java.util.*;

public class distinct_count {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 1, 2, 3, 5, 6, 4, 5, 6, 7, 6, 8, 6, 9, 3};
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        System.out.println(set.size());
    }
}
