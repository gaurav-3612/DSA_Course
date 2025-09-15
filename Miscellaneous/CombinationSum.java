package Miscellaneous;
// gfg

import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // optional: helps to optimize
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start,
            List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // found valid combination
            return;
        }
        if (target < 0) {
            return; // no valid combination if sum exceeds target
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // i (not i+1) because we can reuse the same number
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(arr, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}

/*
 Step 1: Start

Sorted arr = [2, 3, 6, 7]
target = 7
Result = []

We call backtrack(arr, 7, 0, [], result)

Step 2: Loop i = 0 → choose 2

Current = [2]

Target left = 7 - 2 = 5

Call backtrack(arr, 5, 0, [2], result)

Step 3: Loop i = 0 again (reuse 2)

Current = [2, 2]

Target left = 5 - 2 = 3

Call backtrack(arr, 3, 0, [2, 2], result)

Step 4: Loop i = 0 again (reuse 2)

Current = [2, 2, 2]

Target left = 3 - 2 = 1

Call backtrack(arr, 1, 0, [2, 2, 2], result)

Step 5: Loop i = 0 again (reuse 2)

Current = [2, 2, 2, 2]

Target left = 1 - 2 = -1 → invalid, backtrack

Remove last → [2, 2, 2]

Step 6: Loop i = 1 → choose 3

Current = [2, 2, 3]

Target left = 3 - 3 = 0

✅ Found a valid combination → add [2, 2, 3] to result

Result = [[2, 2, 3]]

Backtrack → remove last → [2, 2]

Step 7: Loop i = 2 → choose 6

Target left = 3 - 6 = -3 → invalid, backtrack

Loop i = 3 → choose 7

Target left = 3 - 7 = -4 → invalid, backtrack

So return up to [2]

Step 8: At [2], try i = 1 → choose 3

Current = [2, 3]

Target left = 5 - 3 = 2

Call backtrack(arr, 2, 1, [2, 3], result)

Now try 3 again → 2 - 3 = -1 (invalid),
try 6 or 7 → also invalid.

So backtrack → [2]

Step 9: At [2], try i = 2 → choose 6

Target left = 5 - 6 = -1 → invalid

Try i = 3 → 7 → 5 - 7 = -2 → invalid

So return up to []

Step 10: At root [], try i = 1 → choose 3

Current = [3]

Target left = 7 - 3 = 4

From [3], try more:

[3, 3] → target left = 1

Try 3 again → -2 → invalid

Try 6 or 7 → invalid

So backtrack → []

Step 11: At root [], try i = 2 → choose 6

Current = [6]

Target left = 7 - 6 = 1

From [6], next options:

6 again → -5 → invalid

7 → -6 → invalid

So backtrack → []

Step 12: At root [], try i = 3 → choose 7

Current = [7]

Target left = 7 - 7 = 0

✅ Found valid combination → [7]

Add to result.

Result = [[2, 2, 3], [7]]
 */
