package Hashing;

import java.util.*;

public class union_intersection {

    public static void main(String[] args) {
        int s1[] = {1, 2, 3, 4};
        int s2[] = {5, 2, 6, 1, 3, 7, 8, 9};

        // UNION
        HashSet<Integer> set = new HashSet<>();
        for (int i : s1) {
            set.add(i);
        }
        for (int j : s2) {
            set.add(j);
        }
        System.out.println("Union:" + set.size());
        System.out.println(set);

        // INTERSECTION'
        HashSet<Integer> set2 = new HashSet<>();
        set.clear();
        for (int i : s1) {
            set.add(i);
        }
        int count = 0;
        for (int j : s2) {
            if (set.contains(j)) {
                count++;
                set2.add(j);
            }
        }
        System.out.println("Intersection:" + count);
        System.out.println(set2);
    }
}
