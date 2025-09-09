package Heaps;

import java.util.*;

public class slidingWindowMax {

    static class pairs implements Comparable<pairs> {

        int value;
        int idx;

        public pairs(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(pairs p2) {
            //ascending order pq
            // return this.value-p2.value

            //descending:
            return p2.value - this.value;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<pairs> pq = new PriorityQueue<>();
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // window size
        int res[] = new int[arr.length - k + 1];
        // add elements in the priority queue
        for (int i = 0; i < k; i++) {
            pq.add(new pairs(arr[i], i));
        }
        res[0] = pq.peek().value;
        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx < i - k) {
                pq.remove();
            }
            pq.add(new pairs(arr[i], i));
            res[i - k + 1] = pq.peek().value;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "  ");
        }
    }
}
