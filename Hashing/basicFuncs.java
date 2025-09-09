package Hashing;

import java.util.HashMap;

public class basicFuncs {

    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();
        // put O(1)
        hm.put("India", 100);
        hm.put("Pakistan", -100);
        hm.put("America", 50);
        hm.put("America", 80);
        hm.put("India", 100);

        System.out.println(hm);// prints in random order no rule or aglgo is followed

        // get O(1)
        System.out.println(hm.get("India"));
        System.out.println(hm.get("China"));// prints null

        // contains  O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Japan"));

        // remove o(1)
        System.out.println(hm.remove("Pakistan"));
        System.out.println(hm.remove("Australia"));

        //size
        System.out.println(hm.size());

        // clear
        hm.clear();

        // isEmpty
        System.out.println(hm.isEmpty());
    }
}
