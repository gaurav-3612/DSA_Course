package Heaps;

import java.util.*;

public class insertElement {

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
    }

    public static void main(String[] args) {

    }
}
