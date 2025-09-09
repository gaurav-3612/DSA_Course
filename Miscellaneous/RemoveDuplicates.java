package Miscellaneous;

import java.util.*;
// leetcode-> 1047

class RemoveDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek() == ch) {
                st.pop(); // remove duplicate
            } else {
                st.push(ch); // push if not duplicate
            }
        }

        // build result
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
