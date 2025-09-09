package Stacks;

import java.util.*;

public class ReverseString {

    public static String reverseString(String s) {
        Stack<Character> s1 = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            s1.push(s.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while (!s1.isEmpty()) {
            char curr = s1.pop();
            result.append(curr);
        }
        return result.toString(); // because string builder do not have string data type
    }

    public static void main(String[] args) {
        String s = "HEllOWORLD";
        System.out.println(reverseString(s));
    }
}
