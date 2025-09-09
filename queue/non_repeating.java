package queue;

import java.util.*;

public class non_repeating {

    public static void FirstNonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (!q.isEmpty()) {
                System.out.print(q.peek() + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        FirstNonRepeating(str);
    }
}
