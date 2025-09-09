package DynamicProgramming;

public class UnboundedKnapsack {
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

                    int incProfit = v + dp[i][j - w]; // CHANGE IS MADE HERE
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
        System.out.println(tabulation(value, wt, W));

    }
}
