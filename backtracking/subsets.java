package backtracking;

public class subsets {

    /*

Same as your string version: O(n × n!)
n! permutations,
each costs O(n) to build/copy.

     */
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
/*
  for arrays--->

  public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, ans, 0, temp);
        return ans;
    }

    public void helper(int nums[], List<List<Integer>> ans, int idx, List<Integer> temp) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // pick
        temp.add(nums[idx]);
        helper(nums, ans, idx + 1, temp);
        temp.remove(temp.size() - 1);
        // not pick
        helper(nums, ans, idx + 1, temp);
    }
 */
