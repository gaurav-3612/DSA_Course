package Hashing;

import java.util.*;

public class tree_map {

    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("Pakistan", -100);
        tm.put("America", 50);
        tm.put("America", 80); // update
        tm.put("Nepal", 10);
        tm.put("China", 30);
        tm.put("Japan", 60);

        // it do all methods in O(logn) but prints result in sorted order according to the first letter of the key not the value
        System.out.println(tm);
    }
}
