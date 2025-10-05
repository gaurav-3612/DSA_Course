package Stacks;

import java.util.*;

public class DuplicateBrackets {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // we are taking closing first because it has only one condition of ) and
            //  opening has infinite (,1,2,3..., then all cover in else

            int count = 0;
            if (ch == ')') { // closing
                while (s.peek() != '(') { // we do not write empty condition because strings are valids snd do not start with )
                    s.pop();
                    count++;
                }
                if (count <= 1) {// having bracket in along sigle number is also redundant like (5)+6
                    return true; // duplicatae exist
                } else {
                    s.pop();    // removing the opening pair
                }
            } else {
                s.push(ch);    // pushing everything other than close bracket
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "((2+3))";  // true
        String str2 = "(2+3)";    // false
        System.out.println(isDuplicate(str1));
        System.out.println(isDuplicate(str2));
    }
}
