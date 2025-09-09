package Hashing;

import java.util.*;

public class anagrams {

    public static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.remove(s2.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "lipids";
        String s2 = "spdili";
        String s3 = "race";
        String s4 = "care";
        System.out.println(check(s1, s2));
        System.out.println(check(s3, s4));
    }
}
