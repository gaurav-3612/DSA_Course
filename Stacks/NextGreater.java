package Stacks;
// VERY IMPORTANT CAN HAVE MANY VARITIES-------------TOPIC NAME CALLED: MONOTONIC STACKS---------------------------

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
/*
 --------WHAT IF THE ARRAY GIVEN IS CIRCULAR----------
 EXAMPLE: [1,2,1]
 No circular output: [2,-1,-1]
 Circular Output: [2,-1,2]
 SO WE NEED TO TRAVERSE ARRAY TWICE MEANS i=2*n-1 and idx=i%n

 class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            ans[i]=-1;
        }
        for(int i=n*2-1;i>=0;i--){
            int idx=i%n;
            while(!st.isEmpty()&&nums[idx]>=nums[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[idx]=nums[st.peek()];
            }
            st.push(idx);
        }
        return ans;
    }
}
 */
