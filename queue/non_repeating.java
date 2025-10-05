package queue;

import java.util.*;

public class non_repeating {

// here we used queue to solve this because we need first non repeating
// and the stack will give last non repeating by peek() but queue will give first non repeating by peek()
// used queue because we need to find first non repating all upto ith non one from all string
    public static void FirstNonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) { // if freq of a char is greater than 1 once then it is fully removed because of the for loop as after removing one time do not decrease freq it still remains greateer than 1
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
