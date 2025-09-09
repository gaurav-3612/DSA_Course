package DynamicProgramming;

public class RodCutting {

    public static int MaxPrice(int length[], int prices[], int rodLength) {
        int p = prices.length;
        int dp[][] = new int[p + 1][rodLength + 1];
        for (int i = 0; i < p + 1; i++) {
            for (int j = 0; j < rodLength + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < p + 1; i++) { // here i is traversing in both length and the prices array and used as needed
            for (int j = 1; j < rodLength + 1; j++) { // this is used to traverse the rodLength
                if (length[i - 1] <= j) {  // this necessary because we do not know that whether the length array is sorted or not
                    dp[i][j] = Math.max(prices[i - 1] + dp[i - 1][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[p][rodLength];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println(MaxPrice(length, prices, rodLength));
    }
}
