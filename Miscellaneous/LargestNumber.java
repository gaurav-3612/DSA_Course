package Miscellaneous;

import java.util.*;

class LargestNumber {

    public String largestNumber(int[] nums) {
        // Step 1: Convert numbers to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]); // can also use Integer.toString(nums[i])
        }

        // Step 2: Sort with custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        // Example: compare "3" and "30" by "330" vs "303"

        // Step 3: Handle edge case where result is all "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the final result
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}
