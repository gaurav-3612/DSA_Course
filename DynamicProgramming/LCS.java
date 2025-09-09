package DynamicProgramming;

public class LCS {

    public static int recursion(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return recursion(s1, s2, n - 1, m - 1) + 1;
        } else {
            int ans1 = recursion(s1, s2, n - 1, m);
            int ans2 = recursion(s1, s2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    public static int memoization(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = recursion(s1, s2, n - 1, m - 1) + 1;
        } else {
            int ans1 = recursion(s1, s2, n - 1, m);
            int ans2 = recursion(s1, s2, n, m - 1);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static int Tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcdeg";
        String s2 = "abedg";
        int n = s1.length();
        int m = s2.length();
        System.out.println(recursion(s1, s2, n, m));
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(memoization(s1, s2, n, m, dp));
        System.out.println(Tabulation(s1, s2));
    }
}
