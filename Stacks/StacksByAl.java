package Stacks;

import java.util.*;

public class StacksByAl {

    public static class stack {

        static ArrayList<Integer> list = new ArrayList<>();

        // empty check
        public static boolean isEmpty() {
            return (list.size() == 0);
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);  //list.remove(top) tries to remove the element with value top,
            // not the element at the top index.
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        stack s1 = new stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
