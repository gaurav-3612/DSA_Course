package Stacks;

import java.util.*;

public class PushAtBottom {

    public static void BottomPush(Stack<Integer> s1, int data) {
        if (s1.isEmpty()) {  //isEmpty is a by-default function in java
            s1.push(data);
            return;
        }
        int top = s1.pop();
        BottomPush(s1, data);
        s1.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(2);
        s1.push(1);
        BottomPush(s1, 4);
        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
