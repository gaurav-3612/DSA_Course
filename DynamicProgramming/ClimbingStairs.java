package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    // MEMOIZATION

    public static int calcMemoization(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = calcMemoization(n - 1, ways) + calcMemoization(n - 2, ways);
        // NOTE: IF WE ARE HAVING OPTION OF CLIMBING 1,2 AND 3 STAIRS AT A TIME THEN THERE IS ONLY A SMALL CHANGE COMES THAT IS
        // calcMemoization(N-1,WAYS)+calcMemoization(N-2,WAYS)+calcMemoization(N-3,WAYS)
        return ways[n];
    }

    // TABULIZATION
    public static int calcTabulation(int n) {
        int dp[] = new int[n + 1];
        if (n == 0) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {  //o(n)
        int n = 4;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);  // it will fill -1 at all array ondoces earlier it was 0
        System.out.println(calcMemoization(n, ways));
        System.out.println(calcTabulation(n));
    }
}
