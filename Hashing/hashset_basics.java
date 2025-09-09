package Hashing;

import java.util.*;

public class hashset_basics {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(7);
        set.add(9);
        // System.out.println(set);
        // set.remove(2);
        // System.out.println(set.contains(2));
        // System.out.println(set.size());
        // set.clear();
        // System.out.println(set.isEmpty());

        // iteration on hashset
        Iterator it = set.iterator();
        while (it.hasNext()) {   // itnitially points at null
            System.out.println(it.next());
        }

        for (int i : set) {
            System.out.println(i);
        }
    }
}
