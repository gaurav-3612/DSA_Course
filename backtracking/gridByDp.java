package backtracking;

public class gridByDp {

}
// memoization-------------->>>>>>>>

// package backtracking;
// public class grid {
//     public static int gridways(int i, int j, int n, int m, int[][] dp) {
//         // base cases
//         if (i == n - 1 && j == m - 1) {
//             return 1;
//         }
//         if (i == n || j == m) {
//             return 0;
//         }
//         // if already solved
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         // recursive + memoize
//         int down = gridways(i + 1, j, n, m, dp);
//         int right = gridways(i, j + 1, n, m, dp);
//         return dp[i][j] = down + right;
//     }
//     public static void main(String[] args) {
//         int n = 3, m = 3;
//         int[][] dp = new int[n][m];
//         // fill dp with -1
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         System.out.println(gridways(0, 0, n, m, dp));  // Output: 6
//     }
// }
// tabulation----------->
// package backtracking;
// public class grid {
//     public static int gridways(int n, int m) {
//         int[][] dp = new int[n][m];
//         // base: only 1 way to reach last row or last col
//         for (int i = 0; i < n; i++) dp[i][m - 1] = 1;
//         for (int j = 0; j < m; j++) dp[n - 1][j] = 1;
//         // fill from bottom-right upwards
//         for (int i = n - 2; i >= 0; i--) {
//             for (int j = m - 2; j >= 0; j--) {
//                 dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//             }
//         }
//         return dp[0][0];
//     }
//     public static void main(String[] args) {
//         int n = 3, m = 3;
//         System.out.println(gridways(n, m));  // Output: 6
//     }
// }
