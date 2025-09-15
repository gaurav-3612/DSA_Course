package Miscellaneous;
// leetcode 1006

import java.util.*;

class ClumsyFactorial {

    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        N--;

        int index = 0; // 0 = *, 1 = /, 2 = +, 3 = -
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
