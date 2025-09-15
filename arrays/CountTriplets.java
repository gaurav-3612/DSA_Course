package arrays;
// Problem: Count the number of triplets in an array such that the sum of the triplet is less than a given value.
// Given an array arr[] of size n and an integer sum, find the count of all triplets (i, j, k) 
// with i < j < k such that arr[i] + arr[j] + arr[k] < sum.
//
// Example:
// Input: arr = [5, 1, 3, 4, 7], n = 5, sum = 12
// Output: 4
// Explanation: The triplets are (1,3,4), (1,3,5), (1,3,7), (1,4,5)

import java.util.*;

class Solution {

    long CountTriplets(int n, int sum, long arr[]) {
        // Step 1: Sort the array to use two-pointer technique efficiently
        Arrays.sort(arr);

        long count = 0; // Initialize count of valid triplets

        // Step 2: Fix the first element of the triplet one by one
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;  // Pointer for the second element
            int right = n - 1; // Pointer for the third element

            // Step 3: Use two pointers to find valid triplets with arr[i] as the first element
            while (left < right) {
                long total = arrr[i] + arr[left] + arr[right]; // Current triplet sum

                if (total < sum) {
                    // If sum of triplet is less than given sum,
                    // all triplets between left and right are valid because the array is sorted
                    count += (right - left);

                    // Move left pointer to consider next element as second element
                    left++;
                } else {
                    // If sum >= target sum, reduce sum by moving right pointer to the left
                    right--;
                }
            }
        }

        return count; // Return total count of triplets
    }

    // Main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        long arr[] = {5, 1, 3, 4, 7};
        int n = arr.length;
        int sum = 12;
        System.out.println(sol.CountTriplets(n, sum, arr)); // Output: 4
    }
}
