package Heaps;

import java.util.PriorityQueue;

public class PQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(8);
        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(7);
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
/*
| Feature          | `PriorityQueue` Behavior         |
| ---------------- | -------------------------------- |
| Default behavior | Min-heap                         |
| `poll()` returns | Smallest element                 |
| To make max-heap | Use `Collections.reverseOrder()` |

 */

 /*
  | Operation                      | Time Complexity |
| ------------------------------ | --------------- |
| **Insert (add/enqueue)**       | `O(log n)`      |
| **Remove min/max (dequeue)**   | `O(log n)`      |
| **Peek (get min/max)**         | `O(1)`          |
| **Build from array (heapify)** | `O(n)`          |

  */
