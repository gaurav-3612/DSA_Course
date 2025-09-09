package DynamicProgramming;

public class TargetSum {

    // Tabulation
    public static boolean Target(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1]; // it is current value
                if (v <= j && dp[i - 1][j - v] == true) {// include
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {// exclude
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 9, 10, 20};
        System.out.println(Target(arr, 19));
        System.out.println(Target(arr, 50));
    }
}
