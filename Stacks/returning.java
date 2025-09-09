package Stacks;

import java.util.Stack;

public class returning {

    public static Stack<Double> createStack() {
        Stack<Double> stack = new Stack<>();
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);
        System.out.println("Top: " + stack.peek());
        return stack; // returning the Stack
    }

    public static void main(String[] args) {
        Stack<Double> result = createStack();
        System.out.println(result); // Output: [1.1, 2.2, 3.3]
    }
}
