package Stacks;

import java.util.*;

public class StockSpan {

    public static void StockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        // in stack we will store index
        // in span array we will store span

        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stock.length; i++) {
            int curr = stock[i];
            while (!s.isEmpty() && curr > stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) { // edge case for 100
                span[i] = i + 1;
            } else {
                int prev = s.peek();
                span[i] = i - prev;
                s.push(i);
            }
        }
    }

    public static void main(String[] args) {
        int stock[] = {10, 6, 8, 5, 11, 9};
        int span[] = new int[stock.length];
        StockSpan(stock, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + ",");
        }
    }
}
/*
 Nested loops usually imply O(n²) if each inner loop fully iterates n times for each outer iteration.

Here, the inner while loop runs a total of n times across all outer iterations, not n times per iteration.
 */
