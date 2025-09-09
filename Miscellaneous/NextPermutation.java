package Miscellaneous;

public class NextPermutation {
    // LEETCODE--> 31
}

/*
 Problem Restatement

You’re given an array nums that represents a permutation of numbers.
The task is to rearrange the numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible (i.e., array is in descending order = last permutation), then rearrange it into the lowest permutation (ascending order).

✅ Algorithm Explained (based on your code)

Your code follows the standard 3-step process:

Find the pivot (i)

Traverse from right to left, and find the first index i such that nums[i] < nums[i+1].

Why? Because this is the point where the sequence stops increasing when moving from right to left.

If no such i exists, the array is in descending order (last permutation).

Find the swap candidate (j)

If i >= 0, find the rightmost element greater than nums[i] (index j).

Swap nums[i] and nums[j].

Why? Because swapping with the smallest number bigger than nums[i] ensures the next permutation is just larger, not too large.

Reverse the suffix

Reverse everything from i+1 to the end.

Why? Because the suffix is currently in descending order. Reversing makes it the smallest possible order (ascending), ensuring minimal increase.

📝 Dry Run Example

Let’s dry run on nums = [1, 2, 3].

Step 1: Find i

Start from right:

3 is not less than anything.

Compare nums[1]=2 with nums[2]=3. Yes, 2 < 3.
👉 So i = 1.

Step 2: Find j

Now find the smallest number greater than nums[i] = 2 from right side.

From right: nums[2]=3 > 2.
👉 So j = 2.

Swap → [1, 3, 2].

Step 3: Reverse suffix

Reverse part from i+1=2 to end=2.

That’s just [2], so no change.

✅ Result = [1, 3, 2] (the next permutation).

Another Example: nums = [3, 2, 1]

Step 1: From right → no i found (array is fully descending).

Step 2: Skip swap (since i < 0).

Step 3: Reverse whole array → [1, 2, 3].

✅ Correct: if no next permutation, return smallest permutation.

⏱️ Time Complexity

Step 1 (finding i) → O(n)

Step 2 (finding j) → O(n) in worst case

Step 3 (reversing suffix) → O(n)

Overall = O(n)

Space Complexity = O(1) (in-place).
 */
