package Miscellaneous;

class PartitionEqualSubsetSum {

    static boolean equalPartition(int arr[]) {
        int totalSum = 0;

        // Step 1: Calculate the total sum of all elements
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: If totalSum is odd, it can never be divided equally
        // Example: 11 -> cannot split into two equal integers
        if (totalSum % 2 != 0) {
            return false;
        }

        // Step 3: Each subset must sum to totalSum / 2
        // So the problem reduces to: Can we find ONE subset of sum = target?
        int target = totalSum / 2;

        // Step 4: DP table for memoization
        // dp[idx][currSum] = whether we can reach "currSum" starting from index "idx"
        // Use Boolean (wrapper class) so we can store null (not computed yet)
        Boolean dp[][] = new Boolean[arr.length][target + 1];

        // Step 5: Start recursion from index 0 with currSum = 0
        return helper(arr, target, 0, dp, 0);
    }

    /**
     * Recursive helper function
     *
     * @param arr the input array
     * @param target the sum we want each subset to reach
     * @param currSum current running sum of chosen elements
     * @param dp memoization table
     * @param idx current index in array
     * @return true if we can reach target, false otherwise
     */
    public static boolean helper(int arr[], int target, int currSum, Boolean dp[][], int idx) {

        // Base Case 1: If currSum == target, we found a valid subset
        if (currSum == target) {
            return true;
        }

        // Base Case 2: If we run out of elements OR currSum > target, it's invalid
        if (idx == arr.length || currSum > target) {
            return false;
        }

        // Step 6: Check memoization
        // If this state (idx, currSum) was already solved, return stored value
        if (dp[idx][currSum] != null) {
            return dp[idx][currSum];
        }

        // Step 7: Choice 1 → include current element in subset
        boolean include = helper(arr, target, currSum + arr[idx], dp, idx + 1);

        // Step 8: Choice 2 → exclude current element and move forward
        boolean exclude = helper(arr, target, currSum, dp, idx + 1);

        // Step 9: Store the result in dp and return
        // Why "include || exclude"? 
        // → If either path finds a valid subset, the answer is true
        return dp[idx][currSum] = include || exclude;
    }
}
