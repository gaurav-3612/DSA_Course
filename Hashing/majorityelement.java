package Hashing;

import java.util.*;

public class majorityelement {

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 1, 3, 4, 1, 1, 4, 1, 1, 3, 2,};
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            h.put(arr[i], h.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : h.keySet()) {
            if (h.get(key) > (arr.length / 3)) {
                System.out.println(key);
            }
        }
    }
}
