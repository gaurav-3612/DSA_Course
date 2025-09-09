package Hashing;

import java.util.LinkedHashMap;

public class Linkedhashmap {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("Pakistan", -100);
        lhm.put("America", 50);
        lhm.put("America", 80);
        lhm.put("India", 100);
        System.out.println(lhm);
        // it is implemented with doubly linked linked list in 
//  Insertion Order (default): Elements are returned in the order they were added.
// Access Order (optional): Recently accessed entries move to the end; useful for LRU (Least Recently Used) caches.
    }
}
