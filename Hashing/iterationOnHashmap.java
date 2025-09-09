package Hashing;

import java.util.HashMap;
import java.util.Set;

public class iterationOnHashmap {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("Pakistan", -100);
        hm.put("America", 50);
        hm.put("America", 80);
        hm.put("India", 100);

        Set<String> keys = hm.keySet();
        System.out.println(keys); //[Pakistan, America, India]

        for (String k : keys) {
            System.out.println("keys=" + k + ",value=" + hm.get(k));
        }
    }
}
