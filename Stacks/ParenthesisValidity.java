package Stacks;

import java.util.*;

public class ParenthesisValidity {

    public static boolean valid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') { // opening
                s.push(ch);
            } else {
                if (s.isEmpty()) {  //if string starts with close bracket then s is empty and not valid
                    return false;
                }
                if ((ch == ')' && s.peek() == '(')
                        || // closing
                        (ch == '}' && s.peek() == '{')
                        || (ch == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = "({[[({})]]})";
        String str2 = "]]]((({{{}}})))";
        String str3 = "({}[][()])]]]][[[)))))]]]";
        System.out.println(valid(str1));
        System.out.println(valid(str2));
        System.out.println(valid(str3));
    }
}
