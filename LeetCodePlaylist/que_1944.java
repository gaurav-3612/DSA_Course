package LeetCodePlaylist;

import java.util.*;

class que_1944 {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // decreasing stack

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            // Pop all shorter people → visible but don’t block
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                count++;
            }

            // If a taller/equal person remains → also visible
            if (!stack.isEmpty()) {
                count++;
            }

            res[i] = count;
            stack.push(heights[i]); // push current person
        }

        return res;
    }
}
/*
  Approach-->
  1) we start from back of the array
  2) first make count as 0
  3) we remove the element from the stack we it is smaller than the current element and count++ because if the right side element is shorter than the
     current element than it will not be visible to the other left side elements
  4) if stack remains non empty than we do count++ because of the largest rightmost visible as it would not be counted by the above while loop
  5) At last we do store count in ans array and push the element into the stack
 */
