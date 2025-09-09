package Stacks;

import java.util.*;

public class ReverseStack {

    public static void BottomPush(Stack<Integer> s1, int data) {
        if (s1.isEmpty()) {  //isEmpty is a by-default function in java
            s1.push(data);
            return;
        }
        int top = s1.pop();
        BottomPush(s1, data);
        s1.push(top);
    }

    public static void PrintStack(Stack<Integer> s1) {
        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
    }

    public static void Reverse(Stack<Integer> s1) {
        if (s1.isEmpty()) {
            return;
        }
        int top = s1.pop();
        Reverse(s1);
        BottomPush(s1, top);
    }

    // tem.addAll(s1) copy all s1 to temp
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(2);
        s1.push(1);
        Reverse(s1);
        PrintStack(s1);
    }
}
