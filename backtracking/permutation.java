package backtracking;

public class permutation {

    public static void FindPermutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // kaam
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // changing the string 
            String new_str = str.substring(0, i) + str.substring(i + 1);
            FindPermutation(new_str, ans + curr);
        }
    }
    // time complexity of this code is O(n*n!)

    public static void main(String[] args) {
        String str = "abc";
        FindPermutation(str, "");
    }
}
