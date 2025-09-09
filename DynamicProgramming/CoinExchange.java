package DynamicProgramming;

public class CoinExchange {

    public static int Exchange(int arr[], int sum) {
        int n = arr.length;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) { // valid
                    dp[i][j] = dp[i][j - arr[i - 1]] + dp[i - 1][j];
                } else { // not valid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int sum = 4;
        System.out.println(Exchange(arr, sum));
    }
}
/*

 j=0  1  2  3  4
i=0    1  0  0  0  0
i=1    1  0  0  0  0
i=2    1  0  0  0  0
i=3    1  0  0  0  0

dp[1][1] = dp[1][1-1] + dp[0][1] = dp[1][0] + dp[0][1] = 1 + 0 = 1
dp[1][2] = dp[1][2-1] + dp[0][2] = dp[1][1] + dp[0][2] = 1 + 0 = 1
dp[1][3] = dp[1][3-1] + dp[0][3] = dp[1][2] + dp[0][3] = 1 + 0 = 1
dp[1][4] = dp[1][4-1] + dp[0][4] = dp[1][3] + dp[0][4] = 1 + 0 = 1

       0  1  2  3  4
i=0    1  0  0  0  0
i=1    1  1  1  1  1
i=2    1  0  0  0  0
i=3    1  0  0  0  0

dp[2][1] = dp[2][1] (since 2 > 1) = dp[1][1] = 1
dp[2][2] = dp[2][2-2] + dp[1][2] = dp[2][0] + dp[1][2] = 1 + 1 = 2
dp[2][3] = dp[2][3-2] + dp[1][3] = dp[2][1] + dp[1][3] = 1 + 1 = 2
dp[2][4] = dp[2][4-2] + dp[1][4] = dp[2][2] + dp[1][4] = 2 + 1 = 3

       0  1  2  3  4
i=0    1  0  0  0  0
i=1    1  1  1  1  1
i=2    1  1  2  2  3
i=3    1  0  0  0  0

dp[3][1] = dp[2][1] (since 3 > 1) = 1
dp[3][2] = dp[2][2] (since 3 > 2) = 2
dp[3][3] = dp[3][3-3] + dp[2][3] = dp[3][0] + dp[2][3] = 1 + 2 = 3
dp[3][4] = dp[3][4-3] + dp[2][4] = dp[3][1] + dp[2][4] = 1 + 3 = 4

       0  1  2  3  4
i=0    1  0  0  0  0
i=1    1  1  1  1  1
i=2    1  1  2  2  3
i=3    1  1  2  3  4

 */
