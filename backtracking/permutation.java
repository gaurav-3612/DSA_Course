package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class permutation {

    public static ArrayList<String> findPermutation(String S) {
        ArrayList<String> result = new ArrayList<>();
        helper(S, "", result);
        Collections.sort(result); // GFG requires lexicographic order
        return result;
    }

    private static void helper(String s, String ans, ArrayList<String> result) {
        if (s.length() == 0) {
            result.add(ans);
            return;
        }

        HashSet<Character> used = new HashSet<>(); // to avoid duplicate chars at same level
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (used.contains(ch)) {
                continue; // skip duplicates at this recursion level

            }
            used.add(ch);

            String newStr = s.substring(0, i) + s.substring(i + 1);
            helper(newStr, ans + ch, result);
        }
    }
    // time complexity of this code is O(n*n!)

    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str);
    }
}
/*
  for arrays--> here no duplicates 
  
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
    return ans;
}
private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
    if (path.size() == nums.length) {                // PERMUTATION COMPLETE
        ans.add(new ArrayList<>(path));
        return;
    }
    for (int i = 0; i < nums.length; ++i) {
        if (used[i]) continue;                       // Skip used
        used[i] = true;                              // Mark as used
        path.add(nums[i]);                           // Pick
        backtrack(nums, used, path, ans);            // Recurse
        path.remove(path.size() - 1);                // Remove last (backtrack)
        used[i] = false;                             // Unmark
    }
}

for arrays--> having duplicates

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort duplicates adjacent
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // skip duplicates: only use if previous duplicate is used
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}


 */
