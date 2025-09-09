package Miscellaneous;

import java.util.*;
// LEETCODE---> 49

class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // If key not present, insert new list
            map.putIfAbsent(key, new ArrayList<>());

            // Add current word to the list
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
