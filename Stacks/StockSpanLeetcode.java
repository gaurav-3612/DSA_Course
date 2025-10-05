package Stacks;

import java.util.*;
// problem-901

public class StockSpanLeetcode {

}

class StockSpanner {

    Stack<int[]> s; // each element: [price, span]

    public StockSpanner() {
        s = new Stack<>();
    }

    public int next(int price) { // here we do not need for loop to traverse any stock array as .next call funtion again and again itself
        int span = 1;
        while (!s.isEmpty() && s.peek()[0] <= price) {
            span += s.pop()[1];
        }
        s.push(new int[]{price, span});
        return span;
    }
}

// StockSpanner stockSpanner = new StockSpanner();
// stockSpanner.next(100); // return 1
// stockSpanner.next(80);  // return 1
// stockSpanner.next(60);  // return 1
// stockSpanner.next(70);  // return 2
// stockSpanner.next(60);  // return 1

/*
 if we do normal stock span i-prevhigh approach each time .next is called and everything happen again causing O(n^2)
 */

 /*
  🔑 Approach Used (Monotonic Stack)

We solve LeetCode 901: Online Stock Span using a monotonic decreasing stack.

Each stack entry is (price, span).

Idea: For each new price:

Start with span = 1 (at least today counts).

While the stack top has price ≤ current price:

Pop it.

Add its span to current span (because today’s price is bigger, so it extends over all those past days too).

Push (price, span) onto the stack.

Return span.

👉 Each element is pushed and popped at most once → amortized O(1) time per query.
 */
