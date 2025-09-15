package DynamicProgramming;
// Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
// Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
// Determine the maximum amount he can loot.

class SticklerThief {

    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
