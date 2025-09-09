package Stacks;

import java.util.*;

public class NextGreater {

    public static void main(String[] args) { //--O(n)
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>(); // In this we store index of arr elements
        int NextGreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                NextGreater[i] = -1;
            } else {
                NextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for (int i = 0; i < NextGreater.length; i++) {
            System.out.print(NextGreater[i] + ",");
        }
    }
    // it can have four varieties---->>>

    // next greater to right
    // next greater to left
    // next smaller to right 
    // next smaller to left
}
