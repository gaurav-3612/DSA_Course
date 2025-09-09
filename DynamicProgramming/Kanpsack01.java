package DynamicProgramming;

public class Kanpsack01 {

//  RECURSION
    public static int Knapsack(int value[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = value[n - 1] + Knapsack(value, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = Knapsack(value, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else {
            // skip this item
            return Knapsack(value, wt, W, n - 1);
        }
    }

//  MEMOIZATION
    public static int KnapsackMemo(int value[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            // include
            int ans1 = value[n - 1] + KnapsackMemo(value, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = KnapsackMemo(value, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);
        } else {
            // skip this item
            dp[n][W] = KnapsackMemo(value, wt, W, n - 1, dp);
        }
        return dp[n][W];
    }

    // TABULATION
    public static int tabulation(int value[], int wt[], int W) {
        int n = value.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n; i++) {  // 0th collumn
            dp[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {  // 0th row
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {  // here i is for ith value and ith weight
            for (int j = 1; j < W + 1; j++) {  // here j is variable weight from 0 to W
                int v = value[i - 1]; // ith item value ,,,, because indexing is 0-based but i starts from 1 in DP table
                int w = wt[i - 1]; // ith item wt
                if (w <= j) { // checking if w is less than or not to j for validity condition
                    int incProfit = v + dp[i - 1][j - w];
                    int excProift = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProift);
                } else { // invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int value[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(Knapsack(value, wt, W, value.length)); // Expected: 75

        int dp[][] = new int[value.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(KnapsackMemo(value, wt, W, value.length, dp));
        System.out.println(tabulation(value, wt, W));
    }
}
/*
 Think of the DP table as building solutions from smaller subproblems:

Row 1: best value using only item 1 (completely filled first).

Row 2: best value using items 1 & 2 (built from row 1).

Row 3: best value using items 1, 2 & 3 (built from row 2).

So when filling cell dp[3][50]:

j-w = 50-30=20

We look up dp[2][20] (row for first 2 items, capacity 20)

That’s already computed when i=2 was processed.
 */
