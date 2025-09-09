package Hashing;

import java.util.TreeSet;

public class tree_set {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(50);
        set.add(7);
        set.add(9);
        System.out.println(set);
        set.remove(2);
        System.out.println(set.contains(2));
        System.out.println(set.size());
        set.clear();
        System.out.println(set.isEmpty());
    }
}
