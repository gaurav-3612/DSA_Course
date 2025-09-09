package queue;

import java.util.*;

public class queueStacks {

    static class Queue {

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // add
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove() {
            if (s1.isEmpty()) {
                return -1;
            }
            int val = s1.pop();
            return val;
        }

        // peek
        public static int peek() {
            if (s1.isEmpty()) {
                return -1;
            }
            return s1.peek();
        }

        // is Empty because we can not do s1.isEmpty in main as we are building queue so no use of stack
        public static boolean isEmpty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.add(100);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.remove();

        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
