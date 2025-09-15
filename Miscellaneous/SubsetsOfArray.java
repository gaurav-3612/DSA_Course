package Miscellaneous;

import java.util.*;
// leetcode-78

class SubsetsOfArray {

    // for loop based--->
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(nums, ans, 0, temp);
        return ans;
    }

    public void helper(int nums[], ArrayList<ArrayList<Integer>> ans, int idx, ArrayList<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, ans, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    // pick/ not pick based--->
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
}
/*
 helper([], idx=0)
 ├── add []
 ├── i=0 → add 1
 │    └── helper([1], idx=1)
 │         ├── add [1]
 │         ├── i=1 → add 2
 │         │    └── helper([1,2], idx=2)
 │         │         ├── add [1,2]
 │         │         └── i=2 → add 3 → helper([1,2,3])
 │         │              └── add [1,2,3]
 │         └── i=2 → add 3 → helper([1,3])
 │              └── add [1,3]
 ├── i=1 → add 2
 │    └── helper([2], idx=2)
 │         ├── add [2]
 │         └── i=2 → add 3 → helper([2,3])
 │              └── add [2,3]
 └── i=2 → add 3
      └── helper([3], idx=3)
           └── add [3]



 helper([], idx=0)
 ├── pick 1 → helper([1], idx=1)
 │    ├── pick 2 → helper([1,2], idx=2)
 │    │    ├── pick 3 → helper([1,2,3], idx=3) → add [1,2,3]
 │    │    └── not pick 3 → helper([1,2], idx=3) → add [1,2]
 │    └── not pick 2 → helper([1], idx=2)
 │         ├── pick 3 → helper([1,3], idx=3) → add [1,3]
 │         └── not pick 3 → helper([1], idx=3) → add [1]
 └── not pick 1 → helper([], idx=1)
      ├── pick 2 → helper([2], idx=2)
      │    ├── pick 3 → helper([2,3], idx=3) → add [2,3]
      │    └── not pick 3 → helper([2], idx=3) → add [2]
      └── not pick 2 → helper([], idx=2)
           ├── pick 3 → helper([3], idx=3) → add [3]
           └── not pick 3 → helper([], idx=3) → add []

 */
