package arrays;
// kSum time complexity: O(n^(k-1))

import java.util.*;

public class threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array

        int n = nums.length;

        // Step 2: Loop through each number
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate first numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;  // Step 3: Left pointer  // already moving pointer
            int right = n - 1; // Step 3: Right pointer

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (total < 0) {
                    left++;  // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }

        return result;
    }

    // Quick testing
    public static void main(String[] args) {
        threeSum solution = new threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
        // Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}
