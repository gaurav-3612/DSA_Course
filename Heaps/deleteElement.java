package Heaps;

import java.util.ArrayList;

public class deleteElement {

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {   // O(logn) as for a tree with n nodes there are n levels in it
            arr.add(data);
            int child = arr.size() - 1;
            int parent = (child - 1) / 2;
            while (arr.get(child) < arr.get(parent)) {
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public int peek() {   // if i use static peek() then i need to make arraylist also static
            return arr.get(0);
        }

        private void heapify(int i) {  // O(log n)
            int left = 2 * i + 1; //left child
            int right = 2 * i + 2;  // right child
            int minValueIdx = i; // let i be the minimum index

            if (left < arr.size() && arr.get(minValueIdx) > arr.get(left)) {
                minValueIdx = left;
            }
            if (right < arr.size() && arr.get(minValueIdx) > arr.get(right)) {
                minValueIdx = right;
            }
            if (minValueIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minValueIdx));
                arr.set(minValueIdx, temp);
                heapify(minValueIdx);
            }
        }

        public int remove() {
            int result = arr.get(0);
            int temp = peek();
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            arr.remove(arr.size() - 1);
            heapify(0);
            return result;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(2);
        h.add(8);
        h.add(5);
        h.add(1);
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
