package DynamicProgramming;

public class fibonacci {

    // MEMOIZATION
    public static int fib(int n, int dp[]) {
        if (n == 0 | n == 1) {  // O(n) earlier it was O(2^n)
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    // TABULATION
    public static int fib2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // see it clearly
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1]; // +1 is because fibonacci series starts from 0 not 1
        System.out.println(fib2(n));
    }
}
