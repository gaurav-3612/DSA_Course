package Heaps;

public class MaxSubArrSlidingWindow {

    public static int maxSum(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Step 1: Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < arr.length; i++) {
            // remove the element going out of the window
            windowSum -= arr[i - k];
            // add the new element coming into the window
            windowSum += arr[i];
            // update max
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " = " + maxSum(arr, k));
    }
}
