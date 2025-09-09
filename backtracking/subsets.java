package backtracking;

public class subsets {

    public static void FindSubsets(String str, String ans, int index) {
        // base case
        if (index == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        FindSubsets(str, ans + str.charAt(index), index + 1);
        FindSubsets(str, ans, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        FindSubsets(str, "", 0);
    }
}
