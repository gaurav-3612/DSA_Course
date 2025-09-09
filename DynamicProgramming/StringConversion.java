package DynamicProgramming;

public class StringConversion {
    // here we are allowed to do two steps addition, deletion

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
        String s1 = "abcdef";
        String s2 = "aceg";
        int lcs = Tabulation(s1, s2);
        int deletion = s1.length() - lcs;
        int addition = s2.length() - lcs;
        System.out.println(deletion + addition);
    }
}
// the lcs of two strings s1 and s2 is w then if we are converting from s1 to s2 then by sbubtracting the lengths of s1 and w
// we get the number of deletion operations we required in s1 and then taking the length diff of w and s2 then we get the 
// number of add operations and after adding them we get the total number off add and delete operations
